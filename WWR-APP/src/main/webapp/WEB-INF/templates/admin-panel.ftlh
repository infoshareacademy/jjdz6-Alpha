<!doctype html>
<html>
<head>
    <title>WWR panel administracyjny</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id"
          content="674333452690-oqakalh87637ojol3g6h1383aeppqvot.apps.googleusercontent.com">


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
                        <#--<a class="dropdown-item" href="#">Raporty</a>-->
                        <#--<a class="dropdown-item" href="#">Ustawienia</a>-->
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
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <div id="my-slider" class="carousel slide" data-ride="carousel">

                    <ol class="carousel-indicators">
                        <li data-target="#my-slider" data-slide-to="0" class="active"></li>
                        <li data-target="#my-slider" data-slide-to="1"></li>

                    </ol>

                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img class="d-block w-100" src="/wwr/img/slide-01.jpg" alt="image"/>
                            <div class="carousel-caption">
                                <h2>Szukasz wykwalifikowanego terapeuty?</h2>
                                <p>Na stronie znajdziesz tylko sprawdzonych specjalistów</p>
                            </div>

                        </div>

                        <div class="carousel-item">
                            <img class="d-block w-100" src="/wwr/img/slide-01.jpg" alt="image"/>
                            <div class="carousel-caption">
                                <h2>Szukasz placówki rehabilitacyjnej dla Twojego dziecka?</h2>
                                <p>Na stronie znajdziesz wszystkie dostępne w Twojej okolicy placówki i terapeutów</p>
                            </div>

                        </div>


                        <a class="carousel-control-prev" href="#my-slider" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previuos</span>
                        </a>
                        <a class="carousel-control-next" href="#my-slider" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>

                    </div>


                </div>
            </div>
        </div>
    </div>
</main>

<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1 class="display-4">Witaj na stronie Wczesnego Wspomagania Rozwoju!</h1>
        <p class="lead">WWR to zintegrowane działania profilaktyczne, diagnostyczne, terapeutyczne i medyczne, mające na
            celu stymulowanie funkcji odpowiedzialnych za rozwój psychomotoryczny i komunikację małego dziecka
            niepełnosprawnego. Działania te obejmują również pomoc i wsparcie udzielane rodzicom i rodzinie w celu
            nabycia umiejętności postępowania z dzieckiem. Istotne jest, by intensywne i kompleksowe działania zostały
            podjęte jak najwcześniej</p>
        <hr class="my-4">
        <p>Celem zorganizowania wczesnego wspomagania rozwoju jest pobudzenie psychoruchowego i społecznego rozwoju
            dziecka od chwili wykrycia niepełnosprawności do podjęcia nauki w szkole.</p>
        <p>Tu znajdziesz wszelie informacje dotyczące progamów wspomagania, a także zapiszesz swoje dziecko do wybranego
            specjalisty.</p>
    </div>
</div>

<footer class="container">
    <p class="float-right"><a href="#" class="text-dark">Back to top</a></p>
    <p>&copy; 2019 Alpha-Team &middot;</p>
</footer>

<script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>
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