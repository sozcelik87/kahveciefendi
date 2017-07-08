/**
 * 
 */
function ShoppingCartController($scope,$state,ShoppingCartService) {
	
	var shoppingCartId = localStorage.getItem("SHOPPING_CART_ID");
	
	$scope.shoppingCart={}
	
	$scope.emptyShoppingCart = function(){
		ShoppingCartService.emptyShoppingCart(shoppingCartId).then(function(shoppingCart){
			$scope.shoppingCart =shoppingCart;
		}).catch(function(error){
			console.log(error)
		});
	};
	
	$scope.confirmShoppingCart = function(){
		$state.go('order');
	};
	
	$scope.removeShoppingItem = function(itemKey){
		ShoppingCartService.removeItem(shoppingCartId,itemKey).then(function(shoppingCart){
			$scope.shoppingCart =shoppingCart;
		}).catch(function(error){
			console.log(error)
		});	
	};
	
	$scope.$on("UPDATE_SHOPPING_CART",function(event,shoppingCart){
		$scope.shoppingCart =shoppingCart;
	});
	
	$scope.hasItems = function(){
		return $scope.shoppingCart.items&&$scope.shoppingCart.items.length > 0 ? true :false;
	}
	
	if(shoppingCartId&&shoppingCartId!='undefined'){
		ShoppingCartService.getShoppingCart(shoppingCartId).then(function(shoppingCart){
			$scope.shoppingCart =shoppingCart;
		}).catch(function(error){
			console.log(error);	
		});
	}
	

}

angular.module('kahveciEfendi').controller('ShoppingCartController',ShoppingCartController);