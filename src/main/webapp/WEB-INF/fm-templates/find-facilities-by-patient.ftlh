<!DOCTYPE html>
<html>
<head>
</head>
<body>
<h1>Znajdź najbliższe placówki rehabilitacyjne dla pacjenta</h1>
<form name="patientsFacilities">
    <input type="text" name="searchBy" onkeyup="searchInfo()">
</form>


<script>
    var request = new XMLHttpRequest();

    function searchInfo() {
        var name = document.patientsFacilities.searchBy.value;
        var url = "/wwr/facility?searchBy=" + name;

        try {
            request.onreadystatechange = function () {
                if (request.readyState === 4) {
                    // var val = request.responseText;
                    request.responseText = document.getElementById('mylocation').innerHTML;
                }
            }//end of function
            request.open("GET", url, true);
            request.send();
        } catch (e) {
            alert("Unable to connect to server");
        }
    }
</script>

<span id="mylocation">${selectedPatient.name}</span>


<p><#if selectedPatientsFacilities?size == 0>Nie znaleziono placówek rehabilitacyjnych dla pacjenta
    <strong>${selectedPatient.name} ${selectedPatient.surname}</strong>
    <#else>Najbliższe placówki rehabilitacyjne dla pacjenta
    <strong>${selectedPatient.name} ${selectedPatient.surname}</strong>:</p>
<#list selectedPatientsFacilities>
    <ul>
        <#items as facility>
            <li class="facility"><strong>${facility.name}</strong>
                <ul class="facility-details" style="display: none">
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