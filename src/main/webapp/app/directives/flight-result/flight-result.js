"use strict";

angular.module('myApp').directive('flightResult', flightResult);

flightResult.$inject = ['airportService'];

function flightResult(airportService) {
    return {
        restrict: 'E',
        templateUrl: 'app/directives/flight-result/flight-result.html',
        scope: {
            data: "="
        },
        link: function (scope, element, attrs) {
            scope.airportService = airportService
        }
    }
}