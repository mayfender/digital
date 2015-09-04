angular.module('sbAdminApp').controller('SearchUserCtrl', function($scope, $state) {
	console.log('Start SearchUserCtrl');
	$scope.$parent.iconBtn = 'fa-plus-square';
	$scope.$parent.url = 'add';
	$scope.$parent.headerTitle = 'User Listing';
	$scope.data = {};
	$scope.data.users = [{'id': 1, 'userName': 'John', 'roleId': 11, 'role': 'Admin'}, 
	                     {'id': 2, 'userName': 'Max', 'roleId': 22, 'role': 'Manager'}, 
	                     {'id': 3, 'userName': 'Michael', 'roleId': 33, 'role': 'Reporter'}, 
	                     {'id': 4, 'userName': 'Michael', 'roleId': 44, 'role': 'Reporter'}, 
	                     {'id': 5, 'userName': 'Michael', 'roleId': 55, 'role': 'Reporter'}, 
	                     {'id': 6, 'userName': 'Sara', 'roleId': 66, 'role': 'Production'}];
	
	
	
	$scope.deleteUser = function(user) {
		console.log('deleteUser : ' + user.id);
	}
	
	$scope.editUser = function(user) {
		console.log('editUser : ' + user.id);
		$state.go('dashboard.user.add', {user: user});
	}
	
	
});
