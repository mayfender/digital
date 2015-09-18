angular.module('sbAdminApp').controller('LoginCtrl', function($scope, $http, $stateParams) {
	
	$scope.logout = function() {
		$http.post('/ricoh/logout', {}).success(function() {
			console.log("Logout success");
			$scope.authenticated = false;
//		    $location.path("/");
		}).error(function(data) {
			console.log("Logout error");
			$scope.authenticated = false;
		});
	}
	
	$scope.login = function() {
		authenticate($scope.credentials, function() {
	        if ($scope.authenticated) {
	          //$location.path("/");
	          $scope.error = false;
	          console.log("Login Sucess");
	        } else {
	          //$location.path("/login");
	          $scope.error = true;
	          console.log("Login Error");
	        }
	   });
	}
	
	
	var authenticate = function(credentials, callback) {
		console.log(credentials.username + ":" + credentials.password);
	    var headers = credentials ? {authorization : "Basic " + btoa(credentials.username + ":" + credentials.password)} : {};
	    console.log(headers);

	    $http.get('/ricoh/user', {headers : headers}).success(function(data) {
	    	console.log(data);
	      if (data.name) {
	        $scope.authenticated = true;
	    	  console.log('2');
	      } else {
	    	  $scope.authenticated = false;
	    	  console.log('3');
	      }
	      callback && callback();
	    }).error(function() {
	    	console.log('1');
	      $scope.authenticated = false;
	      callback && callback();
	    });

	}
	
	
});