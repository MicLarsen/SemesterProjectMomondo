angular
    .module('myApp')
    .config(Routes);

function Routes($stateProvider, $urlRouterProvider, $urlMatcherFactoryProvider) {
    'use strict';

    $urlRouterProvider.otherwise('/');

    $urlMatcherFactoryProvider.caseInsensitive(true);
    $urlMatcherFactoryProvider.strictMode(false);

    $stateProvider
        .state('home', {
            url: '/',
            templateUrl: 'app/views/home/_home.html',
            controller: 'HomeController',
            controllerAs: 'vm'
        })
        .state('booking', {
            url: '/booking/:id',
            templateUrl: 'app/views/booking/_booking.html',
            controller: 'BookingController',
            controllerAs: 'vm'
        })
}