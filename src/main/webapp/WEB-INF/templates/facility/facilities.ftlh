<!DOCTYPE html>
<!--dm13.05.2019-->
<html lang="pl">
<head>
    <title>Placówki w systemie</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>

<body class="bg-light">

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
                        <a class="dropdown-item" href="#">Znajdź pacjenta</a>
                        <a class="dropdown-item" href="find-facilities">Pokaż placówki dla pacjenta</a>
                        <a class="dropdown-item" href="add-patient.html">Dodaj pacjenta</a>
                        <a class="dropdown-item" href="#">Edytuj pacjenta</a>
                        <a class="dropdown-item" href="#">Usuń pacjenta</a>
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
                        <a class="dropdown-item" href="#">Znajdź placówkę</a>
                        <a class="dropdown-item" href="/wwr/facility/add">Dodaj placówkę</a>
                        <a class="dropdown-item" href="/wwr/facility?id=1">Edytuj placówkę</a>
                        <a class="dropdown-item" href="#">Usuń placówkę</a>
                        <a class="dropdown-item" href="#">Dodaj placówkę z pliku</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="facility">Pokaż wszystkie placówki</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Kontakt</a>
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

        <#if serviceError??>
            <div id="servicesErrors">
                <#if serviceError.code == 10000>
                    <div class="alert alert-danger" role="alert">Błąd servisu</div>
                </#if>
                <#if serviceError.code == 10004>
                    <div class="alert alert-danger" role="alert">Nie można usunąć placówki, placówka zawiera aktywnych pacjentów.</div>
                </#if>
            </div>
        </#if>

        <div id="signupbox" style=" margin-top:40px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">

            <div class="panel panel-info">
                <div class="panel-heading">
                    <div class="panel-title">
                        WWR
                    </div>
                </div>
            </div>
        </div>

        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
                        <h2><b>Placówki</b> w systemie</h2>
                    </div>
                    <!-- buld operations not implemented -->
                    <#--<div class="col-sm-6">-->
                        <#--<a href="add-patient.html" class="btn btn-success" data-toggle="modal"><i-->
                                    <#--class="material-icons"></i> <span>Dodaj dplacówkę</span></a>-->
                        <#--<a href="#deletePatientModal" class="btn btn-danger" data-toggle="modal"><i-->
                                    <#--class="material-icons"></i> <span>Usuń wybrane placówki</span></a>-->
                    <#--</div>-->
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>
							<span class="custom-checkbox">
								<input type="checkbox" id="selectAll">
								<label for="selectAll"></label>
							</span>
                    </th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Phone</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <#list facilities as facility>
                    <tr>
                        <td>
							<span class="custom-checkbox">
								<input type="checkbox" id="checkbox1" name="options[]" value="${facility.id}">
								<label for="checkbox${facility.id}"></label>
							</span>
                        </td>
                        <td>${facility.name}</td>
                        <td><#if facility.address.email??> ${facility.address.email}<#else> N/A </#if></td>
                        <td>${facility.address.street}, ${facility.address.city}, PL</td>
                        <td>${facility.address.phone}</td>
                        <td>
                            <a href="facility?id=${facility.id}" class="edit"><i class="material-icons"
                                                                                             data-toggle="tooltip" title=""
                                                                                             data-original-title="Edit">Edycja</i></a>
                            <a href="facility?id=${facility.id}&action=delete" class="delete" ><i class="material-icons"
                                                                                                 data-toggle="tooltip"
                                                                                                 title=""
                                                                                                 data-original-title="Delete">Usuń</i></a>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>


            <!-- pagination section temp disabled-->
            <#--<div class="clearfix">-->
                <#--<div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>-->
                <#--<ul class="pagination">-->
                    <#--<li class="page-item disabled"><a href="#">Previous</a></li>-->
                    <#--<li class="page-item"><a href="#" class="page-link">1</a></li>-->
                    <#--<li class="page-item"><a href="#" class="page-link">2</a></li>-->
                    <#--<li class="page-item active"><a href="#" class="page-link">3</a></li>-->
                    <#--<li class="page-item"><a href="#" class="page-link">4</a></li>-->
                    <#--<li class="page-item"><a href="#" class="page-link">5</a></li>-->
                    <#--<li class="page-item"><a href="#" class="page-link">Next</a></li>-->
                <#--</ul>-->
            <#--</div>-->
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