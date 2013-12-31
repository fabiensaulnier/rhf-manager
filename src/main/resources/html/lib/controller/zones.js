var zoneControllers = angular.module('zoneControllers',[]);

zoneControllers.controller('ZoneVillesCtrl', [ '$scope', '$http',
	function($scope, $http) {
	
		$scope.master = {};
	
		// 
		$http.get('http://localhost:8080/zone/villes').success(function(data) {
			$scope.villes = data;
		});
		
		$scope.addVille = function() {
			$http.post('http://localhost:8080/zone/villes', $scope.addVilleForm)
			.success(
				function(data) {
					$scope.master = $scope.addVilleForm;
					//$scope.villes = data;
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


zoneControllers.controller('ZoneVillesAddCtrl', ['$scope', '$http',
		function($scope, $http) {
			$http.post('http://localhost:8080/zone/villes', $scope.ville)
				.success(
					function(data) {
						$scope.villes = data;
				});
		} 
]);	

zoneControllers.controller('ZoneRepartitionCtrl', [ '$scope', '$routeParams',
	function($scope, $routeParams) {
		$scope.phoneId = $routeParams.phoneId;
	} 
]);