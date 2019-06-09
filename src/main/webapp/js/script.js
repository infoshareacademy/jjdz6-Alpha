
$("#add_service").click(function(e) {
    e.preventDefault();
    let randomElement = Math.floor((Math.random() * 100) + 1);
    let singleFacilityElement = "<div class=\"serviceItem\">\n" +
        "                    <input class=\"form-control\" type=\"text\" name=\"service[]\" >\n" +
        "                    <button type=\"button\" class=\"btn btn-outline-info btn-sm\" onclick=\"$(this).parent().remove();\">Usuń</button>\n" +
        "                </div>";
    $("#facility_services").append(singleFacilityElement);
});j
