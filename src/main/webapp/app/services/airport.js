angular.module('myApp').service('airportService', airportService);

function airportService() {

    let airports = [
        {
            abbr: "SXF",
            city: "Berlin"
        },
        {
            abbr: "CPH",
            city: "Copenhagen"
        },
        {
            abbr: "STN",
            city: "London"
        },
        {
            abbr: "CDG",
            city: "Paris"
        },
        {
            abbr: "BCN",
            city: "Barcelona"
        }
    ];

    this.getAirportFromAbbr = function (abbr) {
        return airports.find(function (element) {
            return element.abbr == abbr;
        }).city;
    };

    this.getAirports = function () {
        return airports;
    };

}