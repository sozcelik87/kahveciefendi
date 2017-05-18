/**
 * Angularjs route
 */
angular.module('kahveciEfendi').config(function($stateProvider, $urlRouterProvider, $httpProvider) {
			
			$httpProvider.interceptors.push('TokenAuthInterceptor');
			// For any unmatched url, redirect to list_items page
			$urlRouterProvider.otherwise( function($injector, $location) {
	            var $state = $injector.get("$state");
	            $state.go("list_products");
	        });
			//
			// Now set up the states
			$stateProvider.state('login', {
				url : "/login",
				templateUrl : "pages/login.html"
			}).state('order', {
				templateUrl : "pages/order.html"
			}).state('list_products', {
				url : "/list_products",
				templateUrl : "pages/list_products.html"
			});
		});

angular.module('kahveciEfendi').run(function($rootScope,$state,AuthService,TranslateService,CONSTANTS){
			//For authorization
		 	console.log("Run calisti"); 
			$rootScope.$on('$stateChangeStart',function(event, toState, toParams, fromState, fromParams){
				console.log(fromState +"-->" + toState);
				
				if(toState.name =='order'){
					var user = AuthService.getCurrentUser();
					if(user == null){
						//If there is no token go to login page
						event.preventDefault();
						$state.go('login');
					}
				}		
			});
		
		 //Load messages
		 TranslateService.setTranslateData();	
		 //Load constants
		 $rootScope.CONSTANTS = CONSTANTS;
});

angular.module('kahveciEfendi').constant("CONSTANTS",{
	NONE : "/static/images/live/event/eventimages/"	
});