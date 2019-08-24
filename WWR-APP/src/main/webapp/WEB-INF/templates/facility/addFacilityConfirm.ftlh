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

<#include "../subpageHeader.ftlh">

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
                                <#if facility.isNfz??>
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
<#include "../common-scripts.ftlh">
</body>
</html>