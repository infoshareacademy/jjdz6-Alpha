<!DOCTYPE html>
<!--dm13.05.2019-->
<html lang="pl">
<head>
    <title>Potwierdzenie dodawania nowej placowki</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

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
                        <a class="dropdown-item" href="patient">Pokaż wszystkich pacjentów</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Opcje dostępne dla placówki
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <#--<a class="dropdown-item" href="#">Znajdź placówkę</a>-->
                        <a class="dropdown-item" href="/wwr/facility/add">Dodaj placówkę</a>
                        <a class="dropdown-item" href="/wwr/facility?id=1">Edytuj placówkę</a>
                        <#--<a class="dropdown-item" href="#">Usuń placówkę</a>-->
                        <#--<a class="dropdown-item" href="#">Dodaj placówkę z pliku</a>-->
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="facility">Pokaż wszystkie placówki</a>
                    </div>
                </li>
                <li class="nav-item">
                    <#--<a class="nav-link" href="#">Kontakt</a>-->
                </li>

            </ul>
            <form class="form-inline mt-2 mt-md-0">
                <input class="form-control mr-sm-2" type="text" placeholder="Wyszukaj na stronie" aria-label="Search">
                <button class="btn btn-primary btn-sm my-2 my-sm-0" type="submit">Szukaj</button>
            </form>
        </div>
    </nav>
</header>

<main>

    <div class="container">
        <div id="signupbox" style=" margin-top:40px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <div class="card">
                <div class="card-header">
                    <div class="card-title">
                        Dodano nową placówkę:
                    </div>
                </div>
                <div class="card-body">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-10 control-label">Rodzaj placówki</label>
                            <div class="col-sm-10">
                                <#if facility.nfz??>
                                    <p class="form-control-static">Placówka NFZ</p>
                                <#else>
                                    <p class="form-control-static">Placówka prywatna</p>
                                </#if>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Nazwa</label>
                            <div class="col-sm-10">
                                <p class="form-control-static">${facility.name}</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Adres</label>
                            <div class="col-sm-10">
                                <p class="form-control-static">${facility.address.postalCode} ${facility.address.city}</p>
                                <p class="form-control-static">${facility.address.street}</p>
                                <p class="form-control-static">tel.: ${facility.address.phone}</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Usługi</label>
                            <div class="col-sm-10">
                                <#list facility.services as service>
                                    <p class="form-control-static">${service.name}</p>
                                </#list>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>
<script
        src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous">
</script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous">
</script>
</body>
</html>