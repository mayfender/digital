angular.module('sbAdminApp').controller('AddUserCtrl', function($scope, $stateParams) {
	console.log('Start AddUserCtrl');
	$scope.$parent.iconBtn = 'fa-long-arrow-left';
	$scope.$parent.url = 'search';
	$scope.$parent.headerTitle = 'User Adding';
	
	//-- Initial Edit page
	if($stateParams.user) {
		console.log('Init edit page');
		$scope.username = $stateParams.user.userName;
		$scope.role = $stateParams.user.roleId;
		$scope.isEdit = true;
	}
	
	$scope.clear = function() {
		setNull();    			
	}
	
	$scope.save = function() {
		
	}
	
	$scope.autoGenEvent = function() {
		if($scope.autoGen){
			$scope.username = 'gen_' + Math.floor(Date.now() / 1000);
			$scope.password = '1234';    	
			$scope.role = "";
		}else{
			setNull();
		}    			
	}
	
	function setNull() {
		$scope.reTypePassword = null;
		$scope.username = null;
		$scope.password = null;
		$scope.autoGen = false;
		$scope.role = "";
	} 
});