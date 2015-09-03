angular.module('sbAdminApp').controller('SearchUserCtrl', function($scope, $state) {
	console.log('Start SearchUserCtrl');
	$scope.$parent.iconBtn = 'fa-plus-square';
	$scope.$parent.url = 'add';
	$scope.$parent.headerTitle = 'User Listing';
	$scope.data = {};
	$scope.data.users = [{'id': 1, 'userName': 'John', 'role': 'Admin'}, 
	                     {'id': 2, 'userName': 'Max', 'role': 'Manager'}, 
	                     {'id': 3, 'userName': 'Michael', 'role': 'Reporter'}, 
	                     {'id': 4, 'userName': 'Michael', 'role': 'Reporter'}, 
	                     {'id': 5, 'userName': 'Michael', 'role': 'Reporter'}, 
	                     {'id': 6, 'userName': 'Sara', 'role': 'Production'}];
	
	
	
	$scope.deleteUser = function(id) {
		console.log('deleteUser : ' + id);
	}
	
	$scope.editUser = function(id) {
		console.log('editUser : ' + id);
		$state.go('dashboard.user.add', {userId : id});
	}
	
	
});
