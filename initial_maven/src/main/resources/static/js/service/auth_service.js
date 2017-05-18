function AuthService($http,$q,TokenStorage){
	
	console.log("AuthService created");
	
	//Return current user
	this.getCurrentUser= function(){ 
		/*
		var request = $http({
			method:"get",
			url :"rest/users/current"
		});
		return request;
		*/
		if(TokenStorage.retrieve()==null){
			return null;
		}
		
		var user = JSON.parse(atob(TokenStorage.retrieve().split('.')[1]));
		return user;
	}
}

angular.module('kahveciEfendi').service('AuthService',AuthService);