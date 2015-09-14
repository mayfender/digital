angular.module('sbAdminApp').controller('LoginCtrl', function($scope, $http, $stateParams) {
	
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

	    var headers = credentials ? {authorization : "Basic " + btoa(credentials.username + ":" + credentials.password)} : {};
	    console.log(headers);

	    $http.get('/ricoh/restAct/user/checkUser', {headers : headers}).success(function(data) {
	    	console.log(data);
	      if (data.name) {
	        //$rootScope.authenticated = true;
	    	  console.log('2');
	      } else {
	        //$rootScope.authenticated = false;
	    	  console.log('3');
	      }
	      callback && callback();
	    }).error(function() {
	    	console.log('1');
	      //$rootScope.authenticated = false;
	      callback && callback();
	    });

	}
	
	
});