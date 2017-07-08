function PaymentTypeService($q,$http){
	console.log("Creating PaymentTypeService");
	
	this.getPaymentTypes = function(){
		var deferred = $q.defer();	
		
		var request = $http({
			method : "get",
			url : "api/v1/paymentType/list"
		});
		
		request.then(function(response){
			deferred.resolve(response.data);
		}).catch(function(error){
			deferred.reject(error);
		});
		
		return deferred.promise;
	};
}

angular.module('kahveciEfendi').service('PaymentTypeService',PaymentTypeService);