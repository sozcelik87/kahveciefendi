/**
 * 
 */
function AuthenticationController($scope,$rootScope,$http, $state,TokenStorage,AuthService) {

	$scope.login = function() {
		
		var credentials = {
			email : $scope.email,
			password : $scope.password
		};
		

		AuthService.login(credentials).then(function(data) {
			console.log("Login successful");
			TokenStorage.store(data.token);
			$state.go('order');
		}).catch(function(error) {
			alert(error.data.Exception);
		});
	};
	
	
	$scope.register = function() {
		
		var data = {
			name : $scope.name,
			surname : $scope.surname,
			email : $scope.email,
			password : $scope.password,
			rePassword :$scope.rePassword
		};
		

		AuthService.register(data).then(function(data) {
			console.log("Login successful");
			TokenStorage.store(data.token);
			$state.go('order');
		}).catch(function(error) {
			alert(error.data.Exception);
		});
	};	
}

angular.module('kahveciEfendi').controller('AuthenticationController',
		AuthenticationController);