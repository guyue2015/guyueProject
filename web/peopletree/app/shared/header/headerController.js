angular
    .module('app')
    .controller('HeaderController', HeaderController);

HeaderController.$inject = ['$scope', '$rootScope', '$location', '$state','$api'];
function HeaderController($scope, $rootScope, $location, $state,$api) {
	var changepwd = [];
	$scope.isShow = false;
	$api.get("login/status").success(function(data, status, headers, config){
		if(data.code == 401){
			location.href = "/login.html";
		}
	}).error(function(data, status, headers, config){
		if(status == 404 ){
			alert("地址错误");
			location.href = "/login.html";
		} else if(status == 401 ){
			alert("无权限");
			location.href = "/login.html";
		} else if(status == 500 ){
			alert("系统异常");
			location.href = "/login.html";
		}else {
				alert("未知错误 请联系管理员");
		}
			
	});
}
