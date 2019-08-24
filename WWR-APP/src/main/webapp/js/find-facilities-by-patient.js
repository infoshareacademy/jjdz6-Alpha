
    $(".facility").on("click", function () {
        $(this).find(".facility-details").toggle();
    }).on("click", "ul", function (e) {
        e.stopPropagation();
    });