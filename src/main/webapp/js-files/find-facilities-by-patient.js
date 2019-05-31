$(document).ready(function () {
    $(".facility").on("click", function () {
        $(this).find(".facility-details").toggle();
    }).on("click", "ul", function (e) {
        e.stopPropagation();
    })

    // TODO display facility details only after click on facility name (not the whole row)
    // TODO implement jquery for span display-all-facilities
    // TODO minlength in patientNameInput
});