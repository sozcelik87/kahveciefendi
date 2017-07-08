function OrderService($q,$http){
	console.log("Creating order service");
	
	this.completeOrder= function(order){
		var deferred = $q.defer();	
		
		var request = $http({
			method : "post",
			url : "api/v1/order/complete",
			data : order
		});
		
		request.then(function(response){
			deferred.resolve(response.data);
		}).catch(function(error){
			deferred.reject(error);
		});
		
		return deferred.promise;
	};
}

angular.module('kahveciEfendi').service('OrderService',OrderService);