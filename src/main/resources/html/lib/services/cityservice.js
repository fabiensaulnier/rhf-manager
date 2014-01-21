'use strict';

angular.module('RollerHockeyManagerApp')
  .service('CityService', ['$http', function CityService($http) {

    return {
      getIndex: function() {
        return $http.get('http://localhost:8080/zone/villes');
      },
      addNode: function(node) {
        return $http.post('http://localhost:8080/zone/villes', node);
      }
    };

  }
]);
