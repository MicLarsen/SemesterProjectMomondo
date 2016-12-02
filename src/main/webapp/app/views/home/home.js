"use strict";

/**
 * This is the HomeController, which handles the functionality on the root view.
 */

angular.module('myApp').controller('HomeController', HomeController);

HomeController.$inject = ['dataFactory', 'airportService', 'toastr'];

function HomeController(dataFactory, airportService, toastr) {
    let vm = this;

    vm.searching = false;
    vm.hasSearched = false;
    vm.flights = [];

    vm.search = {
        origin: null,
        destination: null,
        date: new Date(),
        seats: 1
    };

    vm.searchFlights = function () {
        vm.searching = true;
        vm.hasSearched = false;
        vm.flights = [];

        dataFactory.flights.getFlights(vm.search).then(function (response) {
            response.map(x => vm.flights.push(...x.flights));
            vm.searching = false;
            vm.hasSearched = true;
            toastr.success(vm.flights.length + ' flights successfully fetched');
        }, function () {
            vm.searching = false;
            vm.hasSearched = true;
            toastr.error('An error occured while requesting the flights from the API.')
        });

    };

    vm.getAirports = function () {
        return airportService.getAirports();
    };

    vm.testField = function () {
        console.log(vm.search.destination);
    };
}