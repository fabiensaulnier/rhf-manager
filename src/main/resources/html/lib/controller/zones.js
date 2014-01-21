var app = angular.module('RollerHockeyManagerApp');

app.controller('ZoneVillesCtrl', ['$scope', '$http', 'CityService',
  function($scope, $http, CityService) {


    $scope.master = {};
    $scope.cities = [];

    // Get Cities
    CityService.getIndex()
      .then(function(data) {
        $scope.cities = data;
      });

    $scope.addCity = function(city) {

      CityService.addNode(city)
        .then(function(data) {
          $scope.cities.push(city);
        });


    };

    $scope.isUnchanged = function(city) {
      return angular.equals(city, $scope.master);
    };
  }
]);

app.controller('ZoneRepartitionCtrl', ['$scope', '$routeParams',
  function($scope, $routeParams) {
    $scope.phoneId = $routeParams.phoneId;
  }
]);
