/**
 * 
 */
function AuthenticationController($scope, $http, $state, TokenStorage,
		SweetAlert,$rootScope) {

	$scope.login = function() {
		var credentials = {
			username : $scope.username,
			password : $scope.password
		};
		var request = $http({
			method : "post",
			url : "rest/login",
			data : credentials

		});

		request.then(function(response) {
			console.log("Login successful");
			TokenStorage.store(response.headers('X-AUTH-TOKEN'));
			$state.go('event_group');
		}, function(response) {
			SweetAlert.swal({
				title : $rootScope.MESSAGES.LOGIN_ERROR_TITLE,
				text : $rootScope.MESSAGES.LOGIN_ERROR_TEXT,
				timer : 2000,
				showConfirmButton : false
			});
		});
	}
}

angular.module('kahveciEfendi').controller('AuthenticationController',
		AuthenticationController);