/**
 * 
 */
function OrderController($scope,$state,$rootScope,$uibModal,ShoppingCartService,CustomerService,PaymentTypeService,OrderService) {
	
	var shoppingCartId = localStorage.getItem("SHOPPING_CART_ID");
	
	$scope.shoppingCart={}
	
	$scope.addresses =[];
	
	$scope.paymentTypes=[];

	$scope.order ={};
	
	$scope.completeOrder = function(){
		$scope.order.shoppingCartId = shoppingCartId;
		OrderService.completeOrder($scope.order).then(function(result){
			$state.go("confirmation");
		}).catch(function(error){
			alert(error);
		});	
	};
	
	$scope.addAddress = function(){
		 var scope = $rootScope.$new();
	     console.log("Creating AddAddress Modal");
	     $uibModal.open({
	            scope : scope,
	            templateUrl: 'pages/add_address.html',
	            controller: 'AddAddressController',
	            backdrop:'static',
	            keyboard:false
	        });
	};
	
	$scope.$on("UPDATE_ADDRESS_LIST",function(event,addresses){
		$scope.addresses =addresses;
	});
	
	
	if(shoppingCartId&&shoppingCartId!='undefined'){
		ShoppingCartService.getShoppingCart(shoppingCartId).then(function(shoppingCart){
			$scope.shoppingCart =shoppingCart;
		}).catch(function(error){
			console.log(error);	
		});
	}
	
	CustomerService.getCustomerAddresses().then(function(addresses){
		$scope.addresses = addresses;
	}).catch(function(error){
		alert(error);
	});
	
	PaymentTypeService.getPaymentTypes().then(function(paymentTypes){
		$scope.paymentTypes = paymentTypes;
	}).catch(function(error){
		alert(error);
	});
}

angular.module('kahveciEfendi').controller('OrderController',OrderController);