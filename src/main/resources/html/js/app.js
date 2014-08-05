'use strict';

/* App Module */

var app = angular.module('RollerHockeyManagerApp', [
<<<<<<< HEAD:src/main/resources/html/js/app.js
	'ngRoute',
  	'app.filters',
  	'app.services',
  	'app.directives',
  	'app.controllers'
=======
  'ngRoute'
>>>>>>> 0fee1f4a2dd762685fd2c5f9b5cdd1824787347a:src/main/resources/html/lib/app.js
]);

app.constant('managerBaseUrl', '');

app.config(['$routeProvider',
<<<<<<< HEAD:src/main/resources/html/js/app.js
     function($routeProvider) {
          $routeProvider.
          
          		// DASHBOARD
          		when('/', {
          			templateUrl: 'template/dashboard/accueil.html'
          		}).
          		
          		// ARBITRES
          		
          		
          		// COMPETITIONS
          		
          
          		// DISCIPLINE
          		when('/discipline/incidents', {
          			templateUrl: 'template/discipline/incidents.html',
          			controller: 'DisciplineIncidentsCtrl'
          		}).
               
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
                    templateUrl: 'partials/phone-detail.html'//,
                    //controller: 'VilleCrtl'
               })
        
               // DEFAULT
               .otherwise({
                    redirectTo: '/',
               });
     }
=======
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
>>>>>>> 0fee1f4a2dd762685fd2c5f9b5cdd1824787347a:src/main/resources/html/lib/app.js
]);
