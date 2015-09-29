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
	        } else {
	        	$rootScope.error = true;
	        }
	   });
	}
	
	var authenticate = function(credentials, callback) {
	    var headers = credentials ? {authorization : "Basic " + btoa(credentials.username + ":" + credentials.password), 'X-Requested-With' : 'XMLHttpRequest'} : {};

	    $http.get('/ricoh/user', {headers : headers}).
	    then(function(data) {
		    if (data.data.name) {
		    	$rootScope.principal = data.data.principal;
		        $scope.authenticated = true;
		        $rootScope.msg = null;
		    } else {
		    	$scope.authenticated = false;
		    	$rootScope.msg = 'Account does not exist';
		    }
		    
		    callback && callback();
	    }, function(response) {
	    	if(response.data.error == 'Unauthorized') {
	    		$rootScope.msg = 'Account does not exist';
	    	} else {
	    		$rootScope.msg = 'Failed to Connect';	    		
	    	}
	    	
	    	$scope.authenticated = false;
	    	callback && callback();
	    });
	}
	
	var logout = function() {
		$http.post('/ricoh/logout', {}).
		then(function(data) {
			$scope.authenticated = false;
		}, function(response) {
			$scope.authenticated = false;
		});
	}
	
	if($stateParams.action == 'logout') {
		logout();
	}
	
});