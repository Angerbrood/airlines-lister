
function getLocationData() {
    var cityName = document.getElementById("locationCityName").value;
    var countryName = document.getElementById("locationCountryName").value;
    var result = {
        id: null,
        city : cityName,
        country : countryName
    };


    return result;
}

function getLocationId(selectId) {
    var locationSelect = document.getElementById(selectId);
    var selectedLocation = locationSelect.options[locationSelect.selectedIndex];
    var result = selectedLocation.value;
    return {id : result};
}
function fillLocationInput(data) {
     document.getElementById("locationUpdateCityName").value = data.city;
     document.getElementById("locationUpdateCountryName").value = data.country;
}
function getUpdatedLocationData() {
    var cityName = document.getElementById("locationUpdateCityName").value;
    var countryName = document.getElementById("locationUpdateCountryName").value;
    var locationSelect = document.getElementById("locationDeleteSelect");
    var selectedLocation = locationSelect.options[locationSelect.selectedIndex];
    var result = {
        id: selectedLocation.value,
        city : cityName,
        country : countryName
    };


    return result;
}
