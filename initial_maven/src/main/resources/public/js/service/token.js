/**
 * Angular JWT implementation
 */

function TokenStorage() {
			var storageKey = 'auth_token';
			return {
				store : function(token) {
					return localStorage.setItem(storageKey, token);
				},
				retrieve : function() {
					return localStorage.getItem(storageKey);
				},
				clear : function() {
					return localStorage.removeItem(storageKey);
				}
			};
}

function TokenAuthInterceptor($q, $injector, TokenStorage) {
			return {
				request : function(config) {
					var authToken = TokenStorage.retrieve();
					config.headers['Content-Type'] = 'application/json';
					if (authToken) {
						config.headers['X-AUTH-TOKEN'] ="Bearer "+authToken;
					}
					return config;
				},
				responseError : function(error) {
					if (error.status === 401) {
						$injector.get('$state').go('login');
					}else if(error.status === 403){
						$injector.get('$state').go('access_denied');
					}
					return $q.reject(error);
				}
			};
}
		
		
angular.module('kahveciEfendi').factory('TokenStorage',TokenStorage);
angular.module('kahveciEfendi').factory('TokenAuthInterceptor',TokenAuthInterceptor);