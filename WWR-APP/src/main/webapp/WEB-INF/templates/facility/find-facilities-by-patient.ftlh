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

<#--<#include "../subpageHeader.ftlh">-->
<header>

    <nav class="navbar navbar-expand-md navbar-dark static-top bg-dark">
        <a class="navbar-brand" href="/wwr">WWR</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarCollapse">


            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button"
                       aria-haspopup="true" aria-expanded="false">Opcje dostępne dla pacjenta</a>
                    <div class="dropdown-menu">
                        <#--<a class="dropdown-item" href="#">Znajdź pacjenta</a>-->
                        <a class="dropdown-item" href="find-facilities">Pokaż placówki dla pacjenta</a>
                        <a class="dropdown-item" href="/wwr/patient-add">Dodaj pacjenta</a>
                        <#--<a class="dropdown-item" href="#">Edytuj pacjenta</a>-->
                        <#--<a class="dropdown-item" href="#">Usuń pacjenta</a>-->
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/wwr/patient">Pokaż wszystkich pacjentów</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Opcje dostępne dla placówki
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <#--<a class="dropdown-item" href="#">Znajdź placówkę</a>-->
                        <a class="dropdown-item" href="/wwr/facility-add">Dodaj placówkę</a>
                        <a class="dropdown-item" href="/wwr/facility?id=1">Edytuj placówkę</a>
                        <#--<a class="dropdown-item" href="#">Usuń placówkę</a>-->
                        <#--<a class="dropdown-item" href="#">Dodaj placówkę z pliku</a>-->
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/wwr/facility">Pokaż wszystkie placówki</a>
                    </div>
                </li>
                <li class="nav-item">
                    <#--<a class="nav-link" href="#">Kontakt</a>-->
                </li>

                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Panel administracyjny-logowanie
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">

                        <a class="g-signin2" data-onsuccess="onSignIn" id="my-signin2"></a>

                        <a type="button" class="btn btn-primary btn-block" href="#" onclick="signOut();">Wyloguj się</a>
                        <script>

                            function signOut() {
                                var auth2 = gapi.auth2.getAuthInstance();
                                auth2.signOut().then(function () {
                                    location.href = "http://localhost:8080/wwr/";
                                });
                            }
                        </script>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Raporty</a>
                        <a class="dropdown-item" href="#">Ustawienia</a>
                    </div>
                </div>

            </ul>
            <form class="form-inline mt-2 mt-md-0">
                <input class="form-control mr-sm-2" type="text" placeholder="Wyszukaj na stronie" aria-label="Search">
                <button class="btn btn-primary btn-sm my-2 my-sm-0" type="submit">Szukaj</button>
            </form>
        </div>
    </nav>

</header>


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
                <#list selectedPatients as patient>
                    <p class="font-weight-bold">${patient.surname}, ${patient.name}</p>
                    <ul>
                        <#if patient.facilities?has_content>

                            <#list patient.facilities as facility>
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

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
<script src="/wwr/js/find-facilities-by-patient.js"></script>

</body>
</html>