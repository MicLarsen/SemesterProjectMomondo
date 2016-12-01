"use strict";

/**
 * This is the BookingController, which handles the functionality on the booking view.
 */

angular.module('myApp').controller('BookingController', BookingController);

BookingController.$inject = ['dataFactory', '$stateParams', '$state'];

function BookingController(dataFactory, $stateParams, $state) {

    let vm = this;
    vm.reservation = {};
    vm.reservationSuccess = false;
    vm.reservationError = false;

    if (typeof $stateParams.id == 'undefined' || $stateParams.id == null || $stateParams.id == '') {
        $state.go('home');
    }

    dataFactory.flights.getFlight($stateParams.id).then(function (response) {
        vm.flight = response;
    }, function () {
        $state.go('home');
    });

    vm.reservation.passengers = [
        {firstname: null, lastname: null}
    ];

    vm.addPassenger = function () {
        vm.reservation.passengers.push({firstname: null, lastname: null});
    };

    vm.removePassenger = function (index) {
        if (vm.reservation.passengers.length > 1) {
            vm.reservation.passengers.splice(index, 1);
        }
    };

    vm.formValidated = function () {

        let val = true;

        vm.reservation.passengers.forEach(function (e) {
            if (e.firstname === null || e.lastname === null) {
                val = false;
            }
        });

        if (typeof vm.reservation.reserveeName == 'undefined') {
            val = false;
        }

        if (typeof vm.reservation.reserveeEmail == 'undefined') {
            val = false;
        }

        if (typeof vm.reservation.reserveePhone == 'undefined') {
            val = false;
        }

        console.log(vm.reservation);

        return val;
    };

    vm.sendReservation = function () {

        vm.reservationError = false;

        if (vm.formValidated()) {
            dataFactory.flights.sendReservation(vm.reservation).then(function () {
                vm.reservationSuccess = true;
            }, function () {
                vm.reservationError = true;
            });
        }
    };
}