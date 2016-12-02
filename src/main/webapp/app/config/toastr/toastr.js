angular.module('myApp').config(configureToastr);

function configureToastr(toastrConfig) {
    angular.extend(toastrConfig, {
        positionClass: 'toast-bottom-left',
        timeOut: 2500
    });
}