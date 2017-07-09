angular
	.module('app')
	.controller('LoginController',LoginController);

LoginController.$inject = ['$rootScope','$scope', '$api','$http'];
function LoginController($rootScope, $scope, $api, $http) {
	function login() {
		var admin ={};
		admin.loginName=$scope.admin.loginName; 
		admin.password =  $scope.admin.password;
		$api.postJson('test/login', admin).then(function(resp) {
			if (resp.data.code == 200) {
				location.href="/index.html";
			} else {
				 $("#message").html('<p class="error">'+resp.data.message+'</p>');
			}
		});
	}
	
	$scope.login = login;

}