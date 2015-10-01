angular.module('sbAdminApp').controller('SearchUserCtrl', function($rootScope, $scope, $http, $state, loadUsers) {	
	
	$scope.$parent.url = 'add';
	$scope.$parent.iconBtn = 'fa-plus-square';
	$scope.$parent.headerTitle = 'User Listing';
	$scope.data = {};
	$scope.data.users = loadUsers.users;
	
	$scope.deleteUser = function(userId) {
		$http.get(urlPrefix + '/restAct/user/deleteUser?userId=' + userId)
		.then(function(data) {
    		if(data.data.statusCode != 0) {
    			//-- Handle error
    			console.log("Have error");
    			return;
    		}	    		
    		$scope.data.users = data.data.users;
	    }, function(response) {
	    	//-- Handle error
	    	console.log("Have error");
	    });
	}
	
	$scope.editUser = function(user) {
		$state.go('dashboard.user.add', {user: user});
	}
	
});
