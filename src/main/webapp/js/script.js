
$("#add_service").click(function(e) {
    e.preventDefault();

    let randomElement = Math.floor((Math.random() * 100) + 1);
    let singleFacilityElement = "<p><input type=\"text\" name=\"service[]\"></p>";

    $("#facility_services").append(singleFacilityElement);
});