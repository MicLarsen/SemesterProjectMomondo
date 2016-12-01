"use strict";

/**
 * This is file where we define our factories used throughout the application.
 */

angular.module('myApp').factory('dataFactory', dataFactory);

dataFactory.$inject = ['$http', '$q'];

function dataFactory($http, $q) {
    var data = {
        flights: {}
    };

    data.flights.getFlights = function (attrs) {
        return get('mock/flights.json');

        // @todo: Refactor to match your own api
        // if (searchCriteria.destination == null) {
        //     return get('api/flightinfo/' + attrs.origin + '/' + attrs.date + '/' + attrs.seats);
        // } else {
        //     return get('api/flightinfo/' + attrs.origin + '/' + attrs.destination + '/' + attrs.date + '/' + attrs.seats);
        // }
    };

    data.flights.getFlight = function (id) {
        return get('mock/flight.json');

        // @todo: Refactor with your own endpoint
        // return get('api/flightinfo/flight/' + id);
    };

    data.flights.sendReservation = function (data) {
        return get('mock/reservation.json', data);

        // @todo: Refactor with your own endpoint
        // return post('http://yoursite.com/api/resource', data);
    };


    function get(url) {
        let q = $q.defer();
        $http.get(url).then(function (response) {
            q.resolve(response.data);
        }, function (response) {
            q.reject(response.data);
        });
        return q.promise;
    }

    function post(url, data) {
        let q = $q.defer();
        $http.post(url, data).then(function (response) {
            q.resolve(response.data);
        }, function (response) {
            q.reject(response.data);
        });
        return q.promise;
    }

    return data;
}

