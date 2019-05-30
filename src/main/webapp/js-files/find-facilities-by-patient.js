$(document).ready(function () {
    $(".facility").on("click", function () {
        $(this).find(".facility-details").toggle();
    }).on("click", "ul", function (e) {
        e.stopPropagation();
    })

    // TODO poprawić - wyświetlenie szczegółów tylko po kliknięciu na nazwę placówki
    // TODO jquery dla span-u display-all-facilities
});