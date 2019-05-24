<!DOCTYPE html>
<html>
<head>
</head>
<body>
<h1>Znajdź najbliższe placówki rehabilitacyjne pacjenta</h1>
<form name="patientsFacilities">
    <input type="text" name="searchBy" onkeyup="searchInfo()">
</form>

<span id="mylocation"></span>

<p><#if selectedPatientsFacilities?size == 0>Nie znaleziono placówek rehabilitacyjnych dla pacjenta
    <strong>${selectedPatient.name} ${selectedPatient.surname}</strong>
    <#else>Najbliższe placówki rehabilitacyjne pacjenta
    <strong>${selectedPatient.name} ${selectedPatient.surname}</strong>:</p>
<#list selectedPatientsFacilities>
    <ul>
        <#items as facility>
            <li class="facility">${facility.name}
                <ul class="facility-details">
                    <li>${facility.address}</li>
                    <li><#if facility.services?size == 0>Brak wprowadzonych usług<#else>${facility.services?join(", ")}</#if></li>
                </ul>
            </li>
        </#items>
    </ul>
</#list>
</#if>

<script src="https://code.jquery.com/jquery-1.10.2.js"
        type="text/javascript"></script>
<script src="js-files/find-facilities-by-patient.js"></script>

</body>
</html>