angular.module('sbAdminApp').controller('SearchUserCtrl', function($rootScope, $scope, $state, loadUsers) {
	console.log('Start SearchUserCtrl');
	
	$scope.$parent.url = 'add';
	$scope.$parent.iconBtn = 'fa-plus-square';
	$scope.$parent.headerTitle = 'User Listing';
	$scope.data = {};
	$scope.data.users = loadUsers.users;
	
	$scope.deleteUser = function(user) {
		console.log('deleteUser : ' + user.id);
	}
	
	$scope.editUser = function(user) {
		console.log('editUser : ' + user.id);
		$state.go('dashboard.user.add', {user: user});
	}
	
});
