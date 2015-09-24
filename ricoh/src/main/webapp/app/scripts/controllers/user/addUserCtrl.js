angular.module('sbAdminApp').controller('AddUserCtrl', function($scope, $stateParams, $http, $state) {
	console.log('Start AddUserCtrl');
	$scope.$parent.iconBtn = 'fa-long-arrow-left';
	$scope.$parent.url = 'search';
	$scope.$parent.headerTitle = 'User Adding';
	
	if($stateParams.user) { //-- Initial edit module
		console.log('Init edit page');
		$scope.user = $stateParams.user;
		$scope.isEdit = true;
	} else {                // Initial for create module
		$scope.user = {};
		$scope.user.roles = [{}];
		$scope.user.enabled = 1;
	}
	
	$scope.clear = function() {
		setNull();
	}
	
	$scope.update = function() {
		$http.post('/ricoh/restAct/user/updateUser', {
			id: $scope.user.id,
			userName: $scope.user.userName,
			authority: $scope.user.roles[0].authority,
			status: $scope.user.enabled
		}).then(function(data) {
			if(data.data.statusCode != 0) {
				// Manage Error
				return;
			}
			console.log("Save success");
			$state.go('dashboard.user.search');
		}, function(response) {
			// Manage Error
			console.log("Save error");
		});
	}
	
	$scope.save = function() {
		$http.post('/ricoh/restAct/user/saveUser', {
			userName: $scope.user.userName,
			password: btoa($scope.user.password),
			authority: $scope.user.roles[0].authority,
			status: $scope.user.enabled
		}).then(function(data) {
			if(data.data.statusCode != 0) {
				console.log("have error");
				
				if(data.data.statusCode == 200) {
					$scope.userNameErrStyle = 'has-error';
					$scope.msg = "Please use other name";
				}
				return;
			}
			console.log("Save success");
			$state.go('dashboard.user.search');
		}, function(response) {
			// Manage Error
			console.log("Save error");
		});
	}
	
	$scope.autoGenEvent = function() {
		if($scope.autoGen){
			$scope.user.userName = 'gen_' + Math.floor(Date.now() / 1000);
			$scope.user.password = '1234';    	
			$scope.user.roles[0].authority = "";
		}else{
			setNull();
		}    			
	}
	
	function setNull() {
		$scope.user.reTypePassword = null;
		$scope.user.userName = null;
		$scope.user.password = null;
		$scope.autoGen = false;
		$scope.user.roles[0].authority = "";
	} 
});