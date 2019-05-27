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
    <#elseif selectedPatientsFacilities?size == 0>Nie znaleziono placówek rehabilitacyjnych dla
        <#if selectedPatients?size == 1> pacjenta <strong>${selectedPatients.name} ${selectedPatients.surname}</strong>
        <#else> pacjentów <#list selectedPatients.surname as surname><strong>${surname}</strong></#list>
        </#if>
    <#else>Najbliższe placówki rehabilitacyjne dla pacjenta:
</p>
<#list selectedPatientsFacilities as patient, facilities>
    <strong>${patient.name} ${patient.surname}</strong>
    <ul>
        <#list facilities as facility>
            <li class="facility"><strong>${facility.name}</strong>
                <ul class="facility-details" style="display: none">
                    <li>${facility.address}</li>
                    <li><#if facility.services?size == 0>Brak wprowadzonych usług<#else>${facility.services?join(", ")}</#if></li>
                </ul>
            </li>
        </#list>
    </ul>
</#list>
</#if>

<script src="https://code.jquery.com/jquery-1.10.2.js"
        type="text/javascript"></script>
<script src="js-files/find-facilities-by-patient.js"></script>

</body>
</html>