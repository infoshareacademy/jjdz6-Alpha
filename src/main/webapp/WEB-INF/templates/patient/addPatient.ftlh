<!doctype html>
<html>
<head>
    <title>WWR - dodaj pacjenta</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


</head>

<body class="bg-light">

<#include "../subpageHeader.ftlh">

<main>
    <div class="container">
            <form method="post" action="/wwr/patient" class="needs-validation m-3" novalidate>
                <div>
                    <h2>DANE PACJENTA</h2>
                </div>
                <#if editSuccess??>
                    <div class="alert alert-success" role="alert">Dane pacjenta zostały dodane.</div>
                </#if>
                <#if validationError??>
                    <div class="alert alert-danger" role="alert">Błąd : ${message}</div>
                </#if>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="validationCustom01">Imię</label>
                        <input type="text" class="form-control" id="validationCustom01" name="name" placeholder="imię"
                               required>
                        <div class="valid-feedback">
                            Prawidłowo!
                        </div>
                        <div class="invalid-feedback">
                            Podaj wartość!
                        </div>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="validationCustom02">Nazwisko</label>
                        <input type="text" class="form-control" id="validationCustom02" name="surname"
                               placeholder="nazwisko"
                               required>
                        <div class="valid-feedback">
                            Prawidłowo!
                        </div>
                        <div class="invalid-feedback">
                            Podaj wartość!
                        </div>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="validationCustom03">PESEL</label>
                        <input type="number" class="form-control" id="validationCustom03" name="pesel"
                               placeholder="PESEL"
                               required>
                        <div class="valid-feedback">
                            Prawidłowo!
                        </div>
                        <div class="invalid-feedback">
                            Podaj wartość!
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-8">
                        <label for="validationCustom04">Ulica</label>
                        <input type="text" class="form-control" id="validationCustom04" name="street"
                               placeholder="ulica, nr domu / nr mieszkania"
                               required>
                        <div class="valid-feedback">
                            Prawidłowo!
                        </div>
                        <div class="invalid-feedback">
                            Podaj wartość!
                        </div>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="validationCustom04">Kod pocztowy</label>
                        <input type="number" class="form-control" id="validationCustom05" name="postalCode"
                               placeholder="80000"
                               required>
                        <div class="valid-feedback">
                            Prawidłowo!
                        </div>
                        <div class="invalid-feedback">
                            Podaj wartość!
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="validationCustom05">Miasto</label>
                        <input type="text" class="form-control" id="validationCustom06" name="city" required>
                        <div class="valid-feedback">
                            Prawidłowo!
                        </div>
                        <div class="invalid-feedback">
                            Podaj wartość!
                        </div>
                    </div>
                    <div class="form-group col-md-2">
                        <label for="validationCustom06">Telefon</label>
                        <input type="number" class="form-control" id="validationCustom07" name="phone"
                               placeholder="123123123"
                               required>
                        <div class="valid-feedback">
                            Prawidłowo!
                        </div>
                        <div class="invalid-feedback">
                            Podaj wartość!
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="validationCustom07">Imię rodzica / opiekuna</label>
                        <input type="text" class="form-control" id="validationCustom08" name="parentName"
                               placeholder="imię"
                               required>
                        <div class="valid-feedback">
                            Prawidłowo!
                        </div>
                        <div class="invalid-feedback">
                            Podaj wartość!
                        </div>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="validationCustom08">Nazwisko rodzica / opiekuna</label>
                        <input type="text" class="form-control" id="validationCustom09" name="parentSurname"
                               placeholder="nazwisko" required>
                        <div class="valid-feedback">
                            Prawidłowo!
                        </div>
                        <div class="invalid-feedback">
                            Podaj wartość!
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary" name="save" value="save">Wyślij formularz</button>

            </form>
    </div>


</main>

<#include "../footer.ftlh">

<script>
    (function () {
        'use strict';
        window.addEventListener('load', function () {
            var forms = document.getElementsByClassName('needs-validation');
            var validation = Array.prototype.filter.call(forms, function (form) {
                form.addEventListener('submit', function (event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        }, false);
    })();
</script>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>