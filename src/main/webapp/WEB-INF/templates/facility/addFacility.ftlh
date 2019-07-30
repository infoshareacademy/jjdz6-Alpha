<!DOCTYPE html>
<!--dm13.05.2019-->
<html lang="pl">
<head>
    <title>Formularz dodawania placowki</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" id="bootstrap-css"/>

</head>

<body class="bg-light">

<header>
    <nav class="navbar navbar-default navbar-static-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="/wwr">Stona główna</a>
            </div>
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
                    <form name="addFacility" class="form-horizontal" action="/wwr/facility/add" method="POST" enctype="application/x-www-form-urlencoded" accept-charset="UTF-8">
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
                            <label for="div_id_postalCode" class="control-label col-md-4  requiredField">Kod pocztowy</label>
                            <span class="asteriskField">*</span>
                            <small id="help4Id" class="form-text text-muted">Wpisz kod pocztowy</small>

                            <div class="controls col-md-8 ">
                                <input class="input-md textinput textInput form-control" id="id_city" aria-describedby="help4Id" name="postalCode"
                                       placeholder="np. 80-299 " style="margin-bottom: 10px" type="text"/>
                            </div>
                        </div>
                        <div id="div_id_number" class="form-group required">
                            <label for="id_number" class="control-label col-md-4  requiredField">
                                Number kontaktowy
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