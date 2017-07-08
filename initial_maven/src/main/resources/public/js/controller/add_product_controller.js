/**
 * 
 */
function AddProductController($scope,$rootScope,$uibModalInstance,ProductService,ShoppingCartService) {
	
	$scope.selectedProduct.quantity =1;
	
	$scope.increase = function(){
		$scope.selectedProduct.quantity++;
	};
	
	$scope.decrease = function(){
		if($scope.selectedProduct.quantity>1){
			$scope.selectedProduct.quantity--;
		}
	};
	
	$scope.selectedProduct.totalPrice = $scope.selectedProduct.price;
	
	if($scope.selectedProduct.additions){
		for(var i=0;i<$scope.selectedProduct.additions.length;i++){
			$scope.selectedProduct.additions[i].checked=false;
		}
	}

	var checkedAdditions =[];
	
	$scope.addToShoppingCart= function(){
		
		var shoppingCartId = localStorage.getItem("SHOPPING_CART_ID");
		var shoppingItem ={
			"itemId" : $scope.selectedProduct.id,
			"additions" : checkedAdditions,
			"quantity" : $scope.selectedProduct.quantity
		};
		if(shoppingCartId&&shoppingCartId!='undefined'){
			shoppingItem.shoppingCartId =shoppingCartId;
		}
		ShoppingCartService.addItem(shoppingItem).then(function(shoppingCart){
			localStorage.setItem("SHOPPING_CART_ID",shoppingCart.shoppingCartId);
			$rootScope.$broadcast("UPDATE_SHOPPING_CART",shoppingCart);
			$uibModalInstance.dismiss('cancel');
		}).catch(function(error){
			console.log(error);
		});
	};
	
	$scope.calculatePrice = function(){
		var totalPrice = $scope.selectedProduct.price;
		checkedAdditions =[];
		$scope.selectedProduct.additions.forEach(function(addition){
			if(addition.checked){
				totalPrice +=addition.price;
				checkedAdditions.push(addition.id);
			}
		});
		$scope.selectedProduct.totalPrice =totalPrice;
	};
	
	$scope.cancel = function() {
		$uibModalInstance.dismiss('cancel');
    };

    
	
}

angular.module('kahveciEfendi').controller('AddProductController',AddProductController);