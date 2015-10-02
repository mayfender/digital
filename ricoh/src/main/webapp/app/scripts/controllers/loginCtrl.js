angular.module('sbAdminApp').controller('LoginCtrl', function($rootScope, $scope, $state, $http, $window, $stateParams, $window, $base64, urlPrefix) {
	
	var windowElement = angular.element($window);
	windowElement.on('beforeunload', function (event) {
		// do whatever you want in here before the page unloads.        
		// the following line of code will prevent reload or navigating away.
		event.preventDefault();
	});
	
	$rootScope.systemAlert = function(code) {
		if(code == undefined) alert('Server service unavailable! please contact admin');
		else if(code == 403) alert('Access denied!  you are not authorized to access this service');
		else if(code == 401) {
			alert('Seesion expired! please login again');
			$window.location.href = urlPrefix;
		}
		else if(code == 1000) alert('Server service error('+code+')');
	}
	
	
	$scope.login = function() {		
		authenticate($scope.credentials, function() {
	        if ($scope.authenticated) {
	        	$state.go("dashboard.may");
	        	$scope.error = false;
	        } else {
	        	$scope.error = true;
	        }
	   });
	}
	
	var authenticate = function(credentials, callback) {
	    var headers = credentials ? {authorization : "Basic " + $base64.encode(credentials.username + ":" + credentials.password)} : {};

	    $http.get(urlPrefix + '/user', {headers : headers}).
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
	    	if(response.data.status == 401) {
	    		$scope.msg = 'Account does not exist';
	    	} else {
	    		$scope.msg = 'Failed to Connect';	    		
	    	}
	    	
	    	$scope.authenticated = false;
	    	callback && callback();
	    });
	}
	
	var logout = function() {
		$http.post(urlPrefix + '/logout', {}).
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