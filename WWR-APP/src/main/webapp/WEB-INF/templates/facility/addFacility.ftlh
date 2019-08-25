<!DOCTYPE html>
<!--dm13.05.2019-->
<html lang="pl">
<head>
    <title>Formularz dodawania placowki</title>
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
                        <a class="dropdown-item" href="/wwr/facility-add">Dodaj placówkę</a>
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
            <div class="panel panel-info">
                <div class="panel-heading">
                    <div class="panel-title">
                        Formularz dodawania placówki
                    </div>
                </div>
                <div class="panel-body">
                    <form name="addFacility" class="form-horizontal" action="/wwr/facility-add" method="POST" enctype="application/x-www-form-urlencoded" accept-charset="UTF-8">
                        <input type='hidden' name='selection' value='selectOne'/>
                        <input type="hidden" name='_method' value="POST">

                        <div id="div_id_select" class="form-group required">
                            <label for="div_id_select" class="control-label col-md-4  requiredField">
                                Rodzaj placówki
                                <span class="asteriskField">*</span>
                            </label>

                            <div class="controls col-md-8 " style="margin-bottom: 10px">
                                <label class="radio-inline">
                                    <input type="radio" name="nfz" id="Placowka_NFZ" value="true"> Placówka NFZ
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="nfz" id="Placowka_prywatna" value="false"> Placówka prywatna
                                </label>
                            </div>
                        </div>
                        <div id="div_id_name" class="form-group required">
                            <label for="id_name" class="control-label col-md-4  requiredField">
                                Nazwa
                                <span class="asteriskField">*</span>
                                <small id="help1Id" class="form-text text-muted">Wpisz pełną nazwę placówki</small>
                            </label>
                            <div class="controls col-md-8 ">
                                <input class="input-md  textinput textInput form-control" id="id_name" aria-describedby="help1Id" maxlength="30"
                                       name="name" placeholder="np. OWI in Gdynia, filia nr2"
                                       style="margin-bottom: 10px" type="text"/>
                            </div>
                        </div>
                        <div id="div_id_street" class="form-group required">
                            <label for="id_street" class="control-label col-md-4  requiredField">
                                Ulica
                                <span class="asteriskField">*</span>
                                <small id="help2Id" class="form-text text-muted">Wpisz nazwę ulicy</small>
                            </label>
                            <div class="controls col-md-8 ">
                                <input class="input-md textinput textInput form-control" id="id_street" aria-describedby="help2Id" name="street"
                                       placeholder="np. Grunwaldzka 5/5" style="margin-bottom: 10px" type="text"/>
                            </div>
                        </div>
                        <div id="div_id_city" class="form-group required">
                            <label for="id_city" class="control-label col-md-4  requiredField">
                                Miasto
                                <span class="asteriskField">*</span>
                                <small id="help3Id" class="form-text text-muted">Wpisz nazwę miasta</small>
                            </label>
                            <div class="controls col-md-8 ">
                                <input class="input-md textinput textInput form-control" id="id_city" aria-describedby="help3Id" name="city"
                                       placeholder="np. Gdynia " style="margin-bottom: 10px" type="text"/>
                            </div>
                        </div>
                        <div id="div_id_postalCode" class="form-group required">
                            <label for="div_id_postalCode" class="control-label col-md-4  requiredField">
                                Kod pocztowy
                            <span class="asteriskField">*</span>
                            <small id="help4Id" class="form-text text-muted">Wpisz kod pocztowy</small>
                            </label>

                            <div class="controls col-md-8 ">
                                <input class="input-md textinput textInput form-control" id="id_city" aria-describedby="help4Id" name="postalCode"
                                       placeholder="np. 80-299 " style="margin-bottom: 10px" type="text"/>
                            </div>
                        </div>
                        <div id="div_id_number" class="form-group required">
                            <label for="id_number" class="control-label col-md-4  requiredField">
                                Numer kontaktowy
                                <span class="asteriskField">*</span>
                                <small id="help4Id" class="form-number number-muted">Wpisz numer telefonu</small>
                            </label>
                            <div class="controls col-md-8 ">
                                <input class="input-md textinput textInput form-control" id="id_number" aria-describedby="help4Id" name="phone"
                                       placeholder="np. 555444333" style="margin-bottom: 20px" type="text"/>
                            </div>
                        </div>
                        <fieldset class="form-group">
                            <div id="div_id_service" class="row" style="margin-bottom: 20px">
                                <label for="id_service" class="control-label col-md-4  requiredField">
                                    Uslugi
                                    <span class="asteriskField">*</span>
                                    <small class="form-text text-muted">Wybierz usługi dostępne w danej placówce</small>
                                </label>
                                <div class="controls col-md-8">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" name="services" id="check_id_neurolog" value="Neurolog" aria-checked="false">
                                        <label class="form-check-label" for="check_id_neurolog">
                                            Neurolog
                                        </label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" name="services" id="check_id_neurologopeda" value="Neurologopeda" aria-checked="false">
                                        <label class="form-check-label" for="check_id_neurologopeda">
                                            Neurologopeda
                                        </label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" name="services" id="check_id_psycholog" value="Psycholog specjalny" aria-checked="false">
                                        <label class="form-check-label" for="check_id_psycholog">
                                            Psycholog specjalny
                                        </label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" name="services" id="check_id_pedagog" value="Pedagog specjalny" aria-checked="false">
                                        <label class="form-check-label" for="check_id_pedagog">
                                            Pedagog specjalny
                                        </label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" name="services" id="check_id_rehabilitacja" value="Rehabilitacja" aria-checked="false">
                                        <label class="form-check-label" for="check_id_rehabilitacja">
                                            Rehabilitacja
                                        </label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" name="services" id="check_id_terapiaSI" value="Terapia SI" aria-checked="false">
                                        <label class="form-check-label" for="check_id_terapiaSI">
                                            Terapia SI
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                        <div class="form-group">
                            <div class="controls col-md-offset-4 col-md-8 ">
                                <div id="div_id_terms" class="checkbox required">
                                    <label for="id_terms" class=" requiredField">
                                        <input class="input-ms checkboxinput" id="id_terms" name="terms" value="true" style="margin-bottom: 10px" type="checkbox" required/>
                                        Wyrażam zgodę na dodanie danych o powyższej placówce do bazy danych
                                    </label>
                                </div>

                            </div>
                        </div>
                        <div class="form-group">
                            <div class="aab controls col-md-4 "></div>
                            <div class="controls col-md-8 ">
                                <input type="submit" name="submit_button" value="Dodaj placówke" class="btn btn-primary btn btn-info"
                                       id="submit-id-information"/>
                                <input type="reset" name="reset_button" value="Resetuj" class="btn btn-secondary btn btn-sm"
                                       id="reset--id-information"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>
<#include "../footer.ftlh">

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