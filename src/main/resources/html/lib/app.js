'use strict';

/* App Module */

var app = angular.module('RollerHockeyManagerApp', [
  'ngRoute'
]);

app.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
    // ZONES
    when('/zones/villes', {
      templateUrl: 'template/zones/villes.html',
      controller: 'ZoneVillesCtrl'
    }).
    when('/zones/repartitions', {
      templateUrl: 'template/zones/repartitions.html',
      controller: 'ZoneRepartitionCtrl'
    }).
    when('/zones/villes/:villeId', {
      templateUrl: 'partials/phone-detail.html' //,
      //controller: 'VilleCrtl'
    })

    // DEFAULT
    .otherwise({
      redirectTo: 'index.html',
    });
  }
]);
