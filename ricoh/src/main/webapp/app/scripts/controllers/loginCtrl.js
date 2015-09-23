angular.module('sbAdminApp').controller('LoginCtrl', function($rootScope, $scope, $state, $http, $stateParams, $window) {
	
	var windowElement = angular.element($window);
	windowElement.on('beforeunload', function (event) {
		// do whatever you want in here before the page unloads.        
		// the following line of code will prevent reload or navigating away.
		event.preventDefault();
	});
	
	$scope.login = function() {		
		authenticate($scope.credentials, function() {
	        if ($scope.authenticated) {
	        	$state.go("dashboard.user.search");
	        	$rootScope.error = false;
	        	$rootScope.msg = null;
	        } else {
	        	$rootScope.error = true;
	        	$rootScope.msg = "Invalid!";
	        }
	   });
	}
	
	var authenticate = function(credentials, callback) {
	    var headers = credentials ? {authorization : "Basic " + btoa(credentials.username + ":" + credentials.password), 'X-Requested-With' : 'XMLHttpRequest'} : {};

	    $http.get('/ricoh/user', {headers : headers}).success(function(data) {
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