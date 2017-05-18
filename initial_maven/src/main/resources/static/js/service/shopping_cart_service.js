function ShoppingCartService($q,$http){
	console.log("Creating shopping cart service");
	
	this.addItem = function(shoppingItem){
		var deferred = $q.defer();	
		
		var request = $http({
			method : "post",
			url : "/api/v1/shoppingCart/addItem",
			data :shoppingItem
		});
		
		request.then(function(response){
			deferred.resolve(response.data);
		}).catch(function(error){
			deferred.reject(error);
		});
		
		return deferred.promise;
	};
	
	this.getShoppingCart = function(shoppingCartId){
		var deferred = $q.defer();	
		
		var request = $http({
			method : "get",
			url : "/api/v1/shoppingCart/getShoppingCart/"+shoppingCartId
		});
		
		request.then(function(response){
			deferred.resolve(response.data);
		}).catch(function(error){
			deferred.reject(error);
		});
		
		return deferred.promise;
	};
	
	this.emptyShoppingCart = function(shoppingCartId){
		var deferred = $q.defer();	
		
		var request = $http({
			method : "get",
			url : "/api/v1/shoppingCart/emptyShoppingCart/"+shoppingCartId
		});
		
		request.then(function(response){
			deferred.resolve(response.data);
		}).catch(function(error){
			deferred.reject(error);
		});
		
		return deferred.promise;
	};
	
	this.removeItem = function(shoppingCartId,itemKey){
		var deferred = $q.defer();	
		
		var request = $http({
			method : "get",
			url : "/api/v1/shoppingCart/removeItem/"+shoppingCartId+"/"+itemKey
		});
		
		request.then(function(response){
			deferred.resolve(response.data);
		}).catch(function(error){
			deferred.reject(error);
		});
		
		return deferred.promise;
	};
}

angular.module('kahveciEfendi').service('ShoppingCartService',ShoppingCartService);