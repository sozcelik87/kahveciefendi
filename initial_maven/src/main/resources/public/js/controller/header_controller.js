/**
 * 
 */
function HeaderController($scope,$window,$state,TokenStorage){
	$scope.back = function(){
		$window.history.back();	
	};
	
	$scope.logout = function () {
		// Just clear the local storage
		TokenStorage.clear();
		$state.go('login');
	};
}

angular.module('kahveciEfendi').controller('HeaderController',HeaderController);