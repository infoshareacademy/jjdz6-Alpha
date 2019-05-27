<!DOCTYPE html>
<html>
<head>
</head>
<body>
<h1>Znajdź najbliższe placówki rehabilitacyjne dla pacjenta</h1>
<form name="patientsFacilities">
    <input type="text" name="patient" placeholder="Imię lub nazwisko pacjenta">
</form>
<p>
    <#if selectedPatients?size == 0>Nie znaleziono takiego pacjenta.
    <#else>Najbliższe placówki rehabilitacyjne dla pacjenta:
</p>
<#list selectedPatientsFacilities as patient, facilities>
    <strong>${patient.name} ${patient.surname}</strong>
    <ul>
        <#if facilities?has_content>
            <#list facilities as facility>
                <li class="facility"><strong>${facility.name}</strong>
                    <#--dodać przycisk/podświetlenie na niebiesko?-->
                    <ul class="facility-details" style="display: none">
                        <li>${facility.address}</li>
                        <li><#if facility.services?size == 0>Brak wprowadzonych usług<#else>${facility.services?join(", ")}</#if></li>
                    </ul>
                </li>
            </#list>
        <#else>
            <li>Brak placówek w mieście zamieszkania</li></#if>
    </ul>
</#list>
</#if>
<script src="https://code.jquery.com/jquery-1.10.2.js"
        type="text/javascript"></script>
<script src="js-files/find-facilities-by-patient.js"></script>
</body>
</html>