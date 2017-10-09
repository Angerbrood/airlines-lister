

function getLocationData() {
    var cityName = document.getElementById("locationCityName").value;
    var countryName = document.getElementById("locationCountryName").value;
    var result = {
        id: 0,
        city : cityName,
        country : countryName
    };

    return JSON.stringify(result);
}