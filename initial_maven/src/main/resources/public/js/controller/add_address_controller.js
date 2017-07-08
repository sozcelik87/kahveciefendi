/**
 * 
 */
function AddAddressController($scope,$rootScope,$uibModalInstance,CustomerService) {
	
	$scope.address={};
	
	$scope.saveAddress = function(){
		CustomerService.addCustomerAddress($scope.address).then(function(addresses){
			$rootScope.$broadcast("UPDATE_ADDRESS_LIST",addresses);
			$uibModalInstance.dismiss('cancel');
		}).catch(function(error){
			alert(error);
		});
	};

	$scope.cancel = function() {
		$uibModalInstance.dismiss('cancel');
    };

    
	
}

angular.module('kahveciEfendi').controller('AddAddressController',AddAddressController);