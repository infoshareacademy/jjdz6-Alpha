<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <a href="/wwr/">Main page</a>
    </nav>
</header>

<div class="container">

    <#if serviceError??>
        <div id="servicesErrors">
            <#if serviceError.code == 10000><p>Nie znaleziono edytowanej placówki</p></#if>
        </div>
    </#if>

    <#if editSuccess??> Dane placówki zostały uaktualnione. </#if>

    <form action="/wwr/facility" method="POST" enctype="application/x-www-form-urlencoded" accept-charset="UTF-8">

        <div>
            <label for="facility_name">Nazwa placówki</label>
            <p>
                <#if validationError?? && validationError.code == 1001>
                    <b>Błędna nazwa placówki: </b>
                    <input class="input-error" type="text" name="facility_name" value="${facility.name}">
                <#else>
                    <input type="text" name="facility_name" value="${facility.name}">
                </#if>
            </p>

            <input type="hidden" name="facility_id" value="${facility.id}">
            <input type="hidden" name="_method" value="PUT">

        </div>

        <div>
            <label for="facility_address_city">Adres placówki : miasto </label>
            <p>
                <#if validationError?? && validationError.code == 1002>
                    <b>Błędna nazwa miasta: </b><input type="text" name="facility_address_city" value="${facility.address.city}">
                <#else>
                    <input type="text" name="facility_address_city" value="${facility.address.city}">
                </#if>
            </p>
        </div>
        <div>
            <label for="facility_address_street">Adres placówki : ulica </label>
            <p>
                <#if validationError?? && validationError.code == 1003>
                    <b>Błędna nazwa ulicy: </b><input type="text" name="facility_address_street" value="${facility.address.street}">
                <#else>
                    <input type="text" name="facility_address_street" value="${facility.address.street}">
                </#if>
            </p>
        </div>
        <div>
            <label for="facility_address_phone">Adres placówki : telefon </label>
            <p>
                <#if validationError?? && validationError.code == 1004>
                    <b>Błędny nr. telefonu: </b><input type="text" name="facility_address_phone" value="${facility.address.phone}">
                <#else>
                    <input type="text" name="facility_address_phone" value="${facility.address.phone}">
                </#if>
            </p>
        </div>
        <div>
            <label for="facility_services">Usługi oferowane przez placówkę : </label>
        </div>

        <div id="facility_services">
            <#list facility.services as service>
                <div>
                    <input type="text" name="service[]" value="${service.name}">
                    <p id="remove_service_item">(Usun)</p>
                </div>
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
