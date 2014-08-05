'use strict';

/* App Module */

var app = angular.module('RollerHockeyManagerApp', [
	'ngRoute',
  	'app.filters',
  	'app.services',
  	'app.directives',
  	'app.controllers'
]);

app.constant('managerBaseUrl', '');

app.config(['$routeProvider',
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
]);
