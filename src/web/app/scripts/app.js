'use strict';

/**
 * @ngdoc overview
 * @name agileManagerApp
 * @description
 * # agileManagerApp
 *
 * Main module of the application.
 */
angular
  .module('agileManagerApp', [
    'ngCookies',
    'ngMessages',
    'ngResource',
    'ngRoute'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/api', {
        templateUrl: 'views/api.html',
        controller: 'ApiCtrl',
        controllerAs: 'api'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
