'use strict';

/* Controllers */

angular.module('app.controllers', []).
  controller('MyCtrl1', [function() {

  }])
  .controller('MyCtrl2', [function() {

  }]);

  var appControllers = angular.module('app.controllers',[]);

appControllers.controller('ZoneVillesCtrl', [ '$scope', '$http',
	function($scope, $http) {
	
		$scope.ville = {};
	
		// 
		$http.get('/zone/villes').success(function(data) {
			$scope.villes = data;
		});
		
		$scope.addVille = function() {			
			$http.post('/zone/villes', $scope.ville)
			.success(
				function(data) {
					$scope.ville = {};
					$scope.villes.push(data.ville);
			})
			.error(
					function(data) {
						//alert("error" + data);
					});
		};
		
		$scope.isUnchanged = function(ville) {
			 return angular.equals(ville, $scope.master);
		};
	} 
]);	


appControllers.controller('ZoneVillesAddCtrl', ['$scope', '$http',
		function($scope, $http) {
			$scope.villes = {};
	
			$http.post('/zone/villes', $scope.ville)
				 .success(
					function(data) {
						$scope.villes = data;
			});
		} 
]);	

appControllers.controller('ZoneRepartitionCtrl', [ '$scope', '$routeParams',
	function($scope, $routeParams) {
		$scope.phoneId = $routeParams.phoneId;
	} 
]);