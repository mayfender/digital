angular.module('sbAdminApp').controller('ProfileCtrl', function($rootScope, $scope, $http) {
	console.log('Start profile page');
	
	$scope.data = {};
	$scope.data.role = $rootScope.principal.authorities[0].authority;
	$scope.data.username = $rootScope.principal.username;
	$scope.data.password = "";
	$scope.data.reTypePassword = "";
	
	$scope.updateProfile = function() {
		var result = confirmPassword();
		
		if(!result) {
			$scope.notMatchRepassErrMsg = "Must match the previous entry";
			return;
		}
		
		console.log("Continue to call backend");
		$http.post('/ricoh/restAct/user/updateProfile', {
			oldUserName: $rootScope.principal.username,
			newUserName: $scope.data.username,
			password: $scope.data.password && btoa($scope.data.password)
		}).then(function(data) {
			console.log(data);
			if(data.data.statusCode != 0) {
				// Manage Error
				return;
			}
			
			$rootScope.principal.username = $scope.data.username;
			$scope.data.password = "";
			$scope.data.reTypePassword = "";
			console.log("Save success");
		}, function(response) {
			// Manage Error
			console.log("Save error");
		});
	}
	
	function confirmPassword() {
		return ($scope.data.password == $scope.data.reTypePassword);
	}
	
});