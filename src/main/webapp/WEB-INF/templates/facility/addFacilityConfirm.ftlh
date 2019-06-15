<!DOCTYPE html>
<!--dm13.05.2019-->
<html lang="pl">
<head>
    <title>Potwierdzenie dodawania nowej placowki</title>
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
                        Dodano nową placówkę:
                    </div>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Rodzaj placówki</label>
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