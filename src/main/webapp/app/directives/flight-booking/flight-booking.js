"use strict";

angular.module('myApp').directive('flightBooking', flightBooking);

flightBooking.$inject = ['airportService'];

function flightBooking(airportService) {
    return {
        restrict: 'E',
        templateUrl: 'app/directives/flight-booking/flight-booking.html',
        scope: {
            data: "="
        },
        link: function (scope, element, attrs) {
            scope.airportService = airportService
        }
    }
}