
$("#add_service").click(function(e) {
    e.preventDefault();
    let randomElement = Math.floor((Math.random() * 100) + 1);
    let singleFacilityElement = "<p><input type=\"text\" name=\"service[]\"></p>";
    $("#facility_services").append(singleFacilityElement);
});

$("#remove_service_item").click(function (e) {
    e.preventDefault();
    console.log("remove element");
    //let input = $(this).parentElement.getElementsByClassName("input");
    this.parentElement.remove();
});