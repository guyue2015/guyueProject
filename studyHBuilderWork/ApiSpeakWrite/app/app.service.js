angular
    .module('app')
   .factory('$env', [function() {
        var env = location.host.split('.')[0];
        if (env.indexOf('localhost') === 0) {
            env = 'local';
        } else if (env == 'test'  ) {
            env = 'test';
        }
        return env;
    }])
    .factory('$apiHost', ['$env', function($env) {
     //return 'http://localhost:8888/mapi';
        if ($env === 'test') {
            return 'http://test.apispeed.com/ApiSpeed';
        }
        return 'http://127.0.0.1:9999/ApiSpeed';
    }])
    .factory('$apiRoot', ['$apiHost', function($apiHost) {
        return $apiHost;
    }])
    /**
     * 传入接口的path和参数，返回完整URL。
     * @param  {String} path 如 ssl/payment/toTaste
     * @param  {Object} params 如 getUrl('invest/toInvest', {rows: 6})
     * @return {String} 完整的URL，包含GET参数
     */
    .factory('$getUrl', ['$apiRoot', '$param', function ($apiRoot, $param) {
        return function (path, params) {
            var search = typeof params === 'object' ? ('?' + $param(params)) : '';
            return $apiRoot + '/' + path + search;
        }
    }])
    /**
     * 功能等于jQuery的$.param(data)
     */
    .factory('$param', [function () {
        return function (data) {
            var query = [];
            var encode = encodeURIComponent;
            for (var paramName in data) {
                query.push(encode(paramName) + '=' + encode(data[paramName]));
            }
            return query.join('&');
        };
    }])
    .factory('$val', ['$rootScope', function ($rootScope) {
        return function (input, $scope) {
            $scope = $scope || $rootScope;
            var parts = input.split('.');
            var length = parts.length;
            if (length < 2) {
                return null;
            }

            var cursor = $scope;
            for (var i = 0, len = parts.length, part; i < len; i++) {
                part = parts[i];
                if (i === len - 1) {
                    return cursor[part];
                }

                if (angular.isObject(cursor[part]) ||
                    angular.isArray(cursor[part])) {
                    cursor = cursor[part];
                } else {
                    return null;
                }
            }
        };
    }])
    .factory('$api', ['$http', '$rootScope', '$param', '$getUrl', function ($http, $rootScope, $param, $getUrl) {
        var api = {};

        api.get = function (url, params) {
            var config = {};
            config.withCredentials = true;
            config.cache = false;
			config.headers = config.headers || {};
            config.headers['Content-Type'] = 'application/x-www-form-urlencoded';
            return $http.get($getUrl(url, params), config);
        };

        api.post = function (url, data, config) {
            config = config || {};
            config.withCredentials = true;

            // 拼接公共参数
            data = data || {};
            data = $param(data);
            return $http.post($getUrl(url), data, config);
        };

        api.postJson = function (url, data, config) {
            config = config || {};
            config.withCredentials = true;

            config.headers = config.headers || {};
            config.headers['Content-Type'] = 'application/json';

            return $http.post($getUrl(url), JSON.stringify(data), config);
        };

        api.put = function (url, data, config) {
            config = config || {};
            config.withCredentials = true;

            // 拼接公共参数
            data = data || {};
            data = $param(data);

            config.headers = config.headers || {};
            config.headers['Content-Type'] = 'application/x-www-form-urlencoded';

            return $http.put($getUrl(url), data, config);
        };

        api.putJson = function (url, data, config) {
            config = config || {};
            config.withCredentials = true;

            config.headers = config.headers || {};
            config.headers['Content-Type'] = 'application/json';

            return $http.put($getUrl(url), JSON.stringify(data), config);
        };

        api.delete = function(url, config) {
            config = config || {};
            config.withCredentials = true;

            return $http.delete($getUrl(url), config);
        };


        return api;
    }]);
