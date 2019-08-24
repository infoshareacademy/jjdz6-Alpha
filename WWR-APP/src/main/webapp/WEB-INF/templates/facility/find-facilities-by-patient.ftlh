<!DOCTYPE html>
<html>
<head>
    <title>WWR - znajdź placówki</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/wwr/css/find-facilities-by-patient.css">
</head>
<body class="bg-light">
<#include "../subpageHeader.ftlh">
<main>
    <div class="jumbotron jumbotron-fluid">
        <div class="container">
            <h1 class="display-4">Znajdź najbliższe placówki rehabilitacyjne dla pacjenta</h1>
            <div class="lead">
                <form name="patientsFacilities">
                    <p>
                        <input class="patientNameInput" type="text" name="patient-surname"
                               placeholder="Wpisz nazwisko pacjenta">
                        <button type="submit" class="patientNameInputButton btn btn-primary btn-sm my-2 my-sm-0">Szukaj</button>
                    </p>
                </form>
                <p>
                    <#if selectedPatients??>
                    <#if selectedPatients?size == 0>Nie znaleziono takiego pacjenta.
                    <#else>Najbliższe placówki rehabilitacyjne dla pacjenta:
                </p>
                <#list selectedPatientsFacilities as patient, facilities>
                    <p class="font-weight-bold">${patient.surname}, ${patient.name}</p>
                    <ul>
                        <#if facilities?has_content>
                            <#list facilities as facility>
                                <li class="facility"><span class="facility-span"
                                                           title="Kliknij, aby zobaczyć szczegóły">${facility.name}</span>
                                    <ul class="facility-details">
                                        <li>Adres: ul. ${facility.address.street}, ${facility.address.postalCode?c?substring(0,2)}-${facility.address.postalCode?c?substring(2)} ${facility.address.city}</li>
                                        <li><#if facility.services?size == 0>Brak wprowadzonych usług<#else>Usługi: ${facility.services?join(", ")}</#if></li>
                                        <li>Kontakt: tel. ${facility.address.phone}</li>
                                    </ul>
                                </li>
                            </#list>
                        <#else>
                            <li>Brak placówek w mieście zamieszkania</li>
                        </#if>
                    </ul>
                </#list>
                </#if>
                </#if>
            </div>
        </div>
    </div>
</main>

<#include "../footer.ftlh">
<#include "../common-scripts.ftlh">
<script src="/wwr/js/find-facilities-by-patient.js"></script>
</body>
</html>