function ProductService($q,$http){
	console.log("Creating product service");
	
	this.getBeverages = function(){
		var deferred = $q.defer();	
		
		var request = $http({
			method : "get",
			url : "api/v1/product/list/beverages"
		});
		
		request.then(function(response){
			deferred.resolve(response.data);
		}).catch(function(error){
			deferred.reject(error);
		});
		
		return deferred.promise;
	};
}

angular.module('kahveciEfendi').service('ProductService',ProductService);