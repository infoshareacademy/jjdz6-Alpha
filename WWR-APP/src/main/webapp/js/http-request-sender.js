var requestUrl = "http://127.0.0.1:8081/wwr-api/queries";

$("#mainSearchBarButton").on("click", function () {
    var queryText = document.getElementById("mainSearchBarQuery").value;
    $.ajax({
        url: requestUrl,
        dataType: "json",
        type: "POST",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({
            "queryText": queryText
        })
    })
});
