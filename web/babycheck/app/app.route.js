angular
    .module('app')
    .config(['$stateProvider', '$urlRouterProvider',
        function ($stateProvider, $urlRouterProvider) {
            // For any unmatched url, redirect to /
            // Now set up the states
            $stateProvider
               .state('TestList', {
				      url: '/TestList',
				      views: {
					  '': {
						controller: 'testListController',
						templateUrl: 'app/components/quartz_manage/test_list.html'
					}
				}
			});
        }]);
