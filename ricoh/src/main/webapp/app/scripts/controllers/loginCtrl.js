angular.module('sbAdminApp').controller('LoginCtrl', function($rootScope, $scope, $state, $http, $stateParams) {
	
	$scope.login = function() {
		$scope.error = false;
		
		authenticate($scope.credentials, function() {
	        if ($scope.authenticated) {
	        	console.log("Login Sucess");
	        	$state.go("dashboard.user.search");
	        } else {
	        	console.log("Login Error");
	        	$scope.error = true;
	        }
	   });
	}
	
	var authenticate = function(credentials, callback) {
	    var headers = credentials ? {authorization : "Basic " + btoa(credentials.username + ":" + credentials.password), 'X-Requested-With' : 'XMLHttpRequest'} : {};

	    $http.get('/ricoh/user', {headers : headers}).success(function(data) {
		    console.log(data);
		    
		    if (data.name) {
		    	$rootScope.principal = data.principal;
		        $scope.authenticated = true;
		    } else {
		    	$scope.authenticated = false;
		    }
		    
		    callback && callback();
	    }).error(function() {
	    	$scope.authenticated = false;
	    	callback && callback();
	    });
	}
	
	var logout = function() {
		$http.post('/ricoh/logout', {}).success(function() {
			console.log("Logout success");
			$scope.authenticated = false;
		}).error(function(data) {
			console.log("Logout error");
			$scope.authenticated = false;
		});
	}
	
	if($stateParams.action == 'logout') {
		logout();
	}
	
});