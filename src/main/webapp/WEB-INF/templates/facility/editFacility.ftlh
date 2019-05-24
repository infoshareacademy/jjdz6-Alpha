<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Edycja placówki ${facility.name}</title>
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
    />
    <link rel="stylesheet" href="main.css" />
    <title>Edycja placówki : ${facility.name}</title>
</head>
<body>

<header>
    <h1>Edycja placówki : ${facility.name}</h1>
    <nav>
        <a href="/">Main page</a>
    </nav>
</header>

<div class="container">

    <form action="/wwr/facility" method="post">

        <div>
            <label for="facility_name">Nazwa placówki</label>
            <p>
                <input type="text" name="facility_name" value="${facility.name}">
                <input type="hidden" name="facility_id" value="${facility.id}">
            </p>
        </div>

        <div>
            <label for="facility_address_city">Adres placówki : miasto </label>
            <p>
                <input type="text" name="facility_address_city" value="${facility.address.city}">
            </p>
        </div>
        <div>
            <label for="facility_address_street">Adres placówki : ulica </label>
            <p>
                <input type="text" name="facility_address_street" value="${facility.address.street}">
            </p>
        </div>
        <div>
            <label for="facility_address_phone">Adres placówki : telefon </label>
            <p>
                <input type="text" name="facility_address_street" value="${facility.address.phone}">
            </p>
        </div>
        <div>
            <label for="facility_services">Usługi oferowane przez placówkę : </label>
        </div>
        <div id="facility_services">
            <#list facility.services as service>
                <p>
                    <input type="text" name="service[]" value="${service.name}">
                </p>
            </#list>
        </div>

        <div>
            <p><button id="add_service">Dodaj usługę</button></p>
        </div>
        <div>
            <button>Zapisz</button>
        </div>
    </form>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="/wwr/js/script.js"></script>

</body>
</html>
