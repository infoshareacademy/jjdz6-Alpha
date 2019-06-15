<!DOCTYPE html>
<!--dm13.05.2019-->
<html lang="pl">
    <head>
        <title>
            Formularz dodawania placowki
        </title>
        <meta charset="utf-8"/>
        <link
                rel="stylesheet"
                href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
                id="bootstrap-css"
        />
    </head>
    <body>
        <div class="container">
            <div id="signupbox" style=" margin-top:40px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <div class="panel-title">
                            Formularz dodawania placowki
                        </div>
                    </div>
                    <div class="panel-body">
                        <form name="addFacility" class="form-horizontal"method="post" action="/facility">
                            <input type='hidden' name='selection' value='selectOne'/>
                                <div id="div_id_select" class="form-group required">
                                    <label for="div_id_select" class="control-label col-md-4  requiredField">
                                        Rodzaj placowki
                                        <input name="isNfz">
                                        <span class="asteriskField">*</span>
                                    </label>
                                    <div class="controls col-md-8 " style="margin-bottom: 10px">
                                        <label class="radio-inline">
                                            <input type="radio" checked="checked" name="NFZ facility" id="id_select_1" value="S" style="margin-bottom: 10px">
                                            Placowka NFZ
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="private facility" id="id_select_2" value="P" style="margin-bottom: 10px">
                                            Placowka prywatna
                                        </label>
                                    </div>
                                </div>
                                <div id="div_id_name" class="form-group required">
                                    <label for="id_name" class="control-label col-md-4  requiredField">
                                        Nazwa
                                        <span class="asteriskField">*</span>
                                        <small id="help1Id" class="form-text text-muted">Wpisz pelna nazwe placowki</small>
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
                                        <small id="help2Id" class="form-text text-muted">Wpisz nazwe ulicy</small>
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
                                        <small id="help3Id" class="form-text text-muted">Wpisz nazwe miasta</small>
                                    </label>
                                    <div class="controls col-md-8 ">
                                        <input class="input-md textinput textInput form-control" id="id_city" aria-describedby="help3Id" name="city"
                                               placeholder="np. Gdynia " style="margin-bottom: 10px" type="text"/>
                                    </div>
                                </div>
                                <div id="div_id_postalCode" class="form-group required">
                                    <label for="div_id_postalCode" class="control-label col-md-4  requiredField">
                                        Kod pocztowy
                                        <#if validationError?? && validationError.code == 1007>
                                            <input class="form-control is-invalid" type="text" name="div_id_postalCode" value="${facility.address.postalCode?c}">
                                            <div class="invalid-feedback">Błędny kod pocztowy.</div>
                                        <#else>
                                            <input class="form-control" type="text" name="div_id_postalCode" value="${facility.address.postalCode?c}">
                                        </#if>
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
                                    Number kontaktowy
                                    <span class="asteriskField">*</span>
                                    <small id="help4Id" class="form-number number-muted">Wpisz numer telefonu</small>
                                </label>
                                <div class="controls col-md-8 ">
                                    <input class="input-md textinput textInput form-control" id="id_number" aria-describedby="help4Id" name="number"
                                           placeholder="eg. 555444333" style="margin-bottom: 20px" type="text"/>
                                </div>
                            </div>
                            <fieldset class="form-group">
                                <div id="div_id_service" class="row" style="margin-bottom: 20px">
                                    <label for="id_service" class="control-label col-md-4  requiredField">
                                        Uslugi
                                        <span class="asteriskField">*</span>
                                        <small class="form-text text-muted">Wybierz uslugi dostepne w danej placowce</small>
                                    </label>
                                    <div class="controls col-md-8">
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" name="gridRadios" id="check_id_neurolog" value="option1" aria-checked="false">
                                            <label class="form-check-label" for="check_id_neurolog">
                                                Neurolog
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" name="gridRadios" id="check_id_neurologopeda" value="option2" aria-checked="false">
                                            <label class="form-check-label" for="check_id_neurologopeda">
                                                Neurologopeda
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" name="gridRadios" id="check_id_psycholog" value="option3" aria-checked="false">
                                            <label class="form-check-label" for="check_id_psycholog">
                                                Psycholog specjalny
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" name="gridRadios" id="check_id_pedagog" value="option4" aria-checked="false">
                                            <label class="form-check-label" for="check_id_pedagog">
                                                Pedagog specjalny
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" name="gridRadios" id="check_id_rehabilitacja" value="option5" aria-checked="false">
                                            <label class="form-check-label" for="check_id_rehabilitacja">
                                                Rehabilitacja
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" name="gridRadios" id="check_id_terapiaSI" value="option6" aria-checked="false">
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
                                                <input class="input-ms checkboxinput" id="id_terms" name="terms"
                                                       style="margin-bottom: 10px" type="checkbox"/>
                                               Wyrazam zgode na dodanie danych o powyzszej placowce do bazy danych
                                            </label>
                                        </div>

                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="aab controls col-md-4 "></div>
                                    <div class="controls col-md-8 ">
                                        <input type="submit" name="submit_button" value="Dodaj placowke" class="btn btn-primary btn btn-info"
                                               id="submit-id-information"/>
                                        <input type="reset" name="reset_button" value="Resetuj" class="btn btn-secondary btn btn-sm"
                                               id="reset--id-information"/>
                                    </div>
                                </div>

                            </form>

                            <table class="datatable">
                                <tr>
                                    <th>Rodzaj placowki</th>
                                    <th>Nazwa</th>
                                    <th>Ulica</th>
                                    <th>Miasto</th>
                                    <th>Kod pocztowy</th>
                                    <th>Number kontaktowy</th>
                                    <th>Uslugi</th>
                                </tr>
                                <#list facilities as facility>
                                    <tr>
                                        <td>${facility.isNfz}</td>
                                        <td>${facility.name}</td>
                                        <td>${facility.address.street}</td>
                                        <td>${facility.address.city}</td>
                                        <td>${facility.address.postalCode}</td>
                                        <td>${facility.address.phone}</td>
                                        <td>${facility.services}</td>
                                    </tr>
                                </#list>
                            </table>
                    </div>
                </div>
            </div>
        </div>
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