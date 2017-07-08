/**
 * 
 */
function ListProductsController($scope,$rootScope,$uibModal,ProductService) {
	$scope.beverages = [];
	
	$scope.getBeveragesPromise = ProductService.getBeverages();
	
	$scope.getBeveragesPromise.then(function(beverages){
		$scope.beverages = beverages;
	}).catch(function(error){
		console.log(error);
	});
	
	$scope.addProduct = function(product){
		 var scope = $rootScope.$new();
	     scope.selectedProduct = product;
	     console.log("Creating AddProductModal");
	     console.log(scope.selectedProduct);
	     $uibModal.open({
	            scope : scope,
	            templateUrl: 'pages/add_product.html',
	            controller: 'AddProductController',
	            backdrop:'static',
	            keyboard:false
	        });
	};

}

angular.module('kahveciEfendi').controller('ListProductsController',ListProductsController);