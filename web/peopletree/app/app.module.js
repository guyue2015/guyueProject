angular
	.module('app', [
		'ui.router',
		'ngSanitize',
		'ngToast',
		'angular-drag',
		'ngFileUpload',
		'ui.bootstrap'
	])
	.config(['ngToastProvider', function(ngToastProvider) {
		ngToastProvider.configure({
			horizontalPosition: 'center',
			verticalPosition: 'bottom'
		});
	}]).directive('dateFormat', ['$filter', function($filter) {
		var dateFilter = $filter('date');
		return {
			require: 'ngModel',
			link: function(scope, elm, attrs, ctrl) {

				function formatter(value) {
					return dateFilter(value, 'yyyy-MM-dd HH:mm:ss'); //format
				}

				function parser() {
					return ctrl.$modelValue;
				}

				ctrl.$formatters.push(formatter);
				ctrl.$parsers.unshift(parser);

			}
		};
	}]).run(['$api','$rootScope', '$stateParams', '$location',
		function($api,$rootScope, $stateParams, $location) {
			document.title = "接口快速开发任务管理";
			
		}
	]);