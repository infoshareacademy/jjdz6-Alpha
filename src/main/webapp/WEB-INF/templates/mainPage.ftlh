<!doctype html>
<html>
<head>
    <title>WWR strona główna</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


</head>

<body class="bg-light">

<#include "header.ftlh">

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
                            <img class="d-block w-100" src="img/slide-01.jpg" alt="image"/>
                            <div class="carousel-caption">
                                <h2>Szukasz wykwalifikowanego terapeuty?</h2>
                                <p>Na stronie znajdziesz tylko sprawdzonych specjalistów</p>
                            </div>

                        </div>

                        <div class="carousel-item">
                            <img class="d-block w-100" src="img/slide-01.jpg" alt="image"/>
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

<#include "footer.ftlh">

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

