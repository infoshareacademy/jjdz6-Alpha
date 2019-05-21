<!DOCTYPE html>
<html>
<head>
    <title>Edycja placówki : ${facility.name}</title>
    <#--<link type="text/css" rel="stylesheet" href="/css/styles.css"/>-->
    <#--<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>-->
</head>
<body>

<form action="/wwr/facility" method="post">
    <#--<p>-->
        <#--<label>Title</label><br>-->
        <#--<label>-->
            <#--<input type="radio" name="title" value="mr">-->
            <#--Mr-->
        <#--</label>-->
        <#--<label>-->
            <#--<input type="radio" name="title" value="mrs">-->
            <#--Mrs-->
        <#--</label>-->
        <#--<label>-->
            <#--<input type="radio" name="title" value="miss">-->
            <#--Miss-->
        <#--</label>-->
    <#--</p>-->
    <p>
        <label>Nazwa placówki</label><br>
        <input type="text" name="facility_name" value="${facility.name}">
        <input type="hidden" name="facility_id" value="${facility.id}">
    </p>
    <p>
        <label>Adres placówki : miasto </label><br>
        <input type="text" name="facility_address_city" value="${facility.address.city}">
    </p>
    <p>
        <label>Adres placówki : ulica </label><br>
        <input type="text" name="facility_address_street" value="${facility.address.street}">
    </p>
    <p>
        <label>Adres placówki : telefon </label><br>
        <input type="text" name="facility_address_street" value="${facility.address.phone}">
    </p>
    <#--<p>-->
        <#--<label>Email</label><br>-->
        <#--<input type="email" name="email" required>-->
    <#--</p>-->
    <#--<p>-->
        <#--<label>Phone number</label><br>-->
        <#--<input type="tel" name="phone">-->
    <#--</p>-->
    <#--<p>-->
        <#--<label>Password</label><br>-->
        <#--<input type="password" name="password">-->
    <#--</p>-->
    <#--<p>-->
        <#--<label>Country</label><br>-->
        <#--<select>-->
            <#--<option>China</option>-->
            <#--<option>India</option>-->
            <#--<option>United States</option>-->
            <#--<option>Indonesia</option>-->
            <#--<option>Brazil</option>-->
        <#--</select>-->
    <#--</p>-->
    <#--<p>-->
        <#--<label>-->
            <#--<input type="checkbox" value="terms">-->
            <#--I agree to the <a href="/terms">terms and conditions</a>-->
        <#--</label>-->
    <#--</p>-->


    <select multiple name="facility_services">
        <#list facility.services as service>
            <option value="facility_service_name">${service.name}</option>
        </#list>
    </select>

    <p>
        <button>Zapisz</button>
    </p>
</form>

</body>
</html>
