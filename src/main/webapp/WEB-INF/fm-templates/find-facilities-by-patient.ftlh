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

<#if selectedPatientsFacilities?size == 0>Nie znaleziono placówek rehabilitacyjnych dla pacjenta ${selectedPatient.pesel.pesel}
<#else>Najbliższe placówki rehabilitacyjne pacjenta ${selectedPatient.pesel.pesel}
    <#list selectedPatientsFacilities>
        <ul>
            <#items as facility>
            <li>${facility}
                </#items>
        </ul>
    </#list>
</#if>

<script src="https://code.jquery.com/jquery-1.10.2.js"
        type="text/javascript"></script>
<script src="/find-facilities-by-patient.js"></script>

</body>
</html>