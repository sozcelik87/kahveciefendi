function AuthService($http,$q,TokenStorage){
	
	console.log("AuthService created");
	
	this.getCurrentUser= function(){ 
		
		if(TokenStorage.retrieve()==null){
			return null;
		}
		
		var user = JSON.parse(atob(TokenStorage.retrieve().split('.')[1]));
		return user;
	};
	
	this.login = function(data){
		var deferred = $q.defer();	
		
		var request = $http({
			method : "post",
			url : "/api/v1/authentication/login",
			data :data
		});
		
		request.then(function(response){
			deferred.resolve(response.data);
		}).catch(function(error){
			deferred.reject(error);
		});
		
		return deferred.promise;
	};
	
	
	this.register = function(data){
		var deferred = $q.defer();	
		
		var request = $http({
			method : "post",
			url : "/api/v1/authentication/register",
			data :data
		});
		
		request.then(function(response){
			deferred.resolve(response.data);
		}).catch(function(error){
			deferred.reject(error);
		});
		
		return deferred.promise;
	};
}

angular.module('kahveciEfendi').service('AuthService',AuthService);