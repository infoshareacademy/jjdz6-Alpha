$(document).ready(function () {
    // TODO wyłączyć toggle przy clicku na class facility details
    $(".facility").on("click", function () {
        $(this).find(".facility-details").toggle();
    })
});