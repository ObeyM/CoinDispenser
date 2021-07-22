'use strict';

angular.module('dispenserService', []).factory('CoinDispenserService', ["$http", function ($http) {

    var service = {};

    service.dispenseCoins = function (dispense) {

        return $http.post("http://localhost:8080/application/coin-dispenser", dispense);
    };

    return service;
}]);