<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Edycja placówki <#if notFoundError??>nie znaleziono placówki<#else>${facility.name}</#if></title>
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
    />
    <#--<link rel="stylesheet" href="main.css" />-->
    <title>Edycja placówki : <#if notFoundError??>nie znaleziono placówki<#else>${facility.name}</#if></title>
</head>
<body class="bg-light">

<#include "../subpageHeader.ftlh">

<div class="container">

    <#if validationError?? && validationError.code == 1005>
        <div class="alert alert-danger" role="alert">Błąd walidacji nie wszystkie dane zostały wysłane.</div>
    </#if>

    <#if serviceError??>
        <div id="servicesErrors">
            <#if serviceError.code == 10000>
                <div class="alert alert-danger" role="alert">Błąd servisu</div>
            </#if>
        </div>
    </#if>

    <#if notFoundError??>
        <div class="alert alert-warning" role="alert">Nie znaleziono placówki</div>
    <#else>
        <h1>Edycja placówki : ${facility.name}</h1>

        <#if editSuccess??>
            <div class="alert alert-success" role="alert">Dane placówki zostały uaktualnione. </div>
        </#if>

        <form action="/wwr/facility" method="POST" enctype="application/x-www-form-urlencoded" accept-charset="UTF-8">

            <div class="form-group">
                    <label for="facility_name">Nazwa placówki</label>
                    <#if validationError?? && validationError.code == 1001>
                        <input class="form-control is-invalid" type="text" name="facility_name" value="${facility.name}">
                        <div class="invalid-feedback">Błędna nazwa placówki</div>
                    <#else>
                        <input class="form-control" type="text" name="facility_name" value="${facility.name}">
                    </#if>
                <input type="hidden" name="facility_id" value="${facility.id}">
                <input type="hidden" name="_method" value="PUT">
            </div>

            <div class="form-group">
                <label for="facility_address_city">Miasto</label>
                <#if validationError?? && validationError.code == 1002>
                    <input class="form-control is-invalid" type="text" name="facility_address_city" value="${facility.address.city}">
                    <div class="invalid-feedback">Błędna nazwa miasta</div>
                <#else>
                    <input class="form-control" type="text" name="facility_address_city" value="${facility.address.city}">
                </#if>
            </div>

            <div class="form-group">
                <label for="facility_address_street">Ulica</label>
                    <#if validationError?? && validationError.code == 1003>
                        <input class="form-control is-invalid" type="text" name="facility_address_street" value="${facility.address.street}">
                        <div class="invalid-feedback">Błędna nazwa ulicy</div>
                    <#else>
                        <input class="form-control" type="text" name="facility_address_street" value="${facility.address.street}">
                    </#if>
            </div>

            <div class="form-group">
                <label for="facility_address_phone">Telefon:</label>
                    <#if validationError?? && validationError.code == 1004>
                        <input class="form-control is-invalid" type="text" name="facility_address_phone" value="${facility.address.phone}">
                        <div class="invalid-feedback">Błędny nr. telefonu</div>
                    <#else>
                        <input class="form-control" type="text" name="facility_address_phone" value="${facility.address.phone}">
                    </#if>
            </div>

            <div class="form-group">
                <label for="facility_address_phone">Kod pocztowy:</label>
                    <#if validationError?? && validationError.code == 1007>
                        <input class="form-control is-invalid" type="text" name="facility_address_postal" value="${facility.address.postalCode?c}">
                        <div class="invalid-feedback">Błędny kod pocztowy.</div>
                    <#else>
                        <input class="form-control" type="text" name="facility_address_postal" value="${facility.address.postalCode?c}">
                    </#if>
            </div>

            <div class="form-group">
                <#if validationError?? && validationError.code == 1005>
                    <label for="facility_services">Usługi oferowane przez placówkę: </label>
                    <div class="alert alert-danger" role="alert">Brak usług </div>
                <#else>
                    <label for="facility_services">Usługi oferowane przez placówkę : </label>
                </#if>
            </div>


            <div class="form-group">
                <div id="facility_services">

                    <#if validationError?? && validationError.code == 1006>
                        <div class="alert alert-danger" role="alert">Błędny wpis w usługach (pusta nazwa usługi) </div>
                      </#if>

                    <#list facility.services as service>
                        <div class="serviceItem">
                            <input class="form-control" type="text" name="service[]" value="${service.name}">
                            <button type="button" class="btn btn-outline-info btn-sm" onclick="$(this).parent().remove();">Usuń</button>
                        </div>
                    </#list>
                </div>
            </div>
            <div class="form-group">
                <button id="add_service" type="button" class="btn btn-outline-info btn-sm">Dodaj usługę</button>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Zapisz</button>
            </div>
        </form>
    </#if>


</div>

<#include "../footer.ftlh">

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
