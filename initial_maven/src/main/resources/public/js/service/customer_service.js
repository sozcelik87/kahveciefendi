function CustomerService($q,$http){
	console.log("Creating customer service");
	
	this.getCustomerAddresses = function(){
		var deferred = $q.defer();	
		
		var request = $http({
			method : "get",
			url : "api/v1/customer/list/addresses"
		});
		
		request.then(function(response){
			deferred.resolve(response.data);
		}).catch(function(error){
			deferred.reject(error);
		});
		
		return deferred.promise;
	};
	
	this.addCustomerAddress= function(address){
		var deferred = $q.defer();	
		
		var request = $http({
			method : "post",
			url : "api/v1/customer/add/address",
			data : address
		});
		
		request.then(function(response){
			deferred.resolve(response.data);
		}).catch(function(error){
			deferred.reject(error);
		});
		
		return deferred.promise;
	};
}

angular.module('kahveciEfendi').service('CustomerService',CustomerService);