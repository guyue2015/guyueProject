angular
  .module('app')
  .controller('testListController', testListController);
testListController.$inject = ['$scope',  '$api'];
function testListController($scope, $api) {
	
	$api.get("test/search").then(function(resp){
		if( resp.data.code == 200){
			$scope.testList =  resp.data.data;
		} else if( resp.data.code == 401){
			alert('未登录');
			location.href = "login.html";
		}
		
	});
}
