<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Lovely Cats</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <!-- Favicon -->
    <link href="/resources/img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins&family=Roboto:wght@700&display=swap" rel="stylesheet">

    <!-- Estilos Icon Font -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">
    <link href="/resources/lib/flaticon/font/flaticon.css" rel="stylesheet">
    <link rel="shortcut icon" href="/resources/img/logo.png"/>

    <!-- Librerias Stylesheet -->
    <link href="/resources/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!--  Bootstrap y css -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/style.css" rel="stylesheet">
</head>

<body>


<!-- Inicio Navegador -->
<nav class="navbar navbar-expand-lg bg-white navbar-light shadow-sm py-3 py-lg-0 px-3 px-lg-0">
    <a href="<%= request.getContextPath() %>/" class="navbar-brand ms-lg-5">
        <h1 class="m-0 text-uppercase text-dark"><img src="/resources/img/logo.png" class="img-logo" alt="logo"></h1>
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <div class="navbar-nav ms-auto py-0">
            <a href="<%= request.getContextPath() %>/" class="nav-item nav-link active"><spring:message
                    code="navbar.home"/></a>
            <a href="/adopte" class="nav-item nav-link "><spring:message code="navbar.adoptar"/></a>
            <a href="/service" class="nav-item nav-link"><spring:message code="navbar.servicios"/></a>
            <a href="/vsc-product" class="nav-item nav-link"><spring:message code="navbar.productos"/></a>
            <a href="#" class="nav-item nav-link"><spring:message code="navbar.blog"/></a>

            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle bi bi-translate" data-bs-toggle="dropdown"><spring:message
                        code="navbar.idioma"/></a>
                <div class="dropdown-menu m-0">
                    <a class="dropdown-item" href="?lang=es">Español</a>
                    <a class="dropdown-item" href="?lang=en">English</a>
                    <a class="dropdown-item" href="?lang=fr">Français</a>
                    <a class="dropdown-item" href="?lang=it">Italiano</a>
                </div>
            </div>
            <a href="/login" class="nav-item nav-link nav-contact bg-primary text-white px-5 ms-lg-5"><spring:message
                    code="navbar.iniciarSesion"/></a>
        </div>
    </div>
</nav>
<!-- Fin navegador -->

<!-- Inicio Presentacion -->
<div class="container-fluid bg-primary py-5 mb-5 hero-header">
    <div class="container py-5">
        <div class="row justify-content-start">
            <div class="col-lg-8 text-center text-lg-start">
                <h1 class="display-1 text-uppercase text-dark mb-lg-4"><spring:message code="presentation.title1"
                                                                                       text="Bienvenidos"/></h1>
                <h1 class="text-uppercase text-white mb-lg-4"><spring:message code="presentation.title2"
                                                                              text="Haz feliz a tu mascota y encuentra a tu peludito"/></h1>
                <p class="fs-4 text-white mb-lg-4"><spring:message code="presentation.subtitle"
                                                                   text="Adopta y date la oportunidad de conocer a tu nuevo compañero, además conoce nuestros servicios para el bien y cuidado de tu mascota"/></p>
                <div class="d-flex align-items-center justify-content-center justify-content-lg-start pt-5">
                    <a href="#" class="btn btn-outline-light border-2 py-md-3 px-md-5 me-5"><spring:message
                            code="presentation.moreInfo" text="Más información"/></a>
                    <button type="button" class="btn-play" data-bs-toggle="modal"
                            data-src="https://www.youtube.com/embed/yOSxgvTCc4U" data-bs-target="#videoModal">
                        <span></span>
                    </button>
                    <h5 class="font-weight-normal text-white m-0 ms-4 d-none d-sm-block"><spring:message
                            code="presentation.presentation" text="Presentación"/></h5>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Fin presentación -->

<!-- Inicio video modal -->
<div class="modal fade" id="videoModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content rounded-0">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel"><spring:message code="modal.videoTitle"
                                                                               text="Video de presentación"/></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <!-- 16:9 aspect ratio -->
                <div class="ratio ratio-16x9">
                    <iframe class="embed-responsive-item" src="" id="video" allowfullscreen
                            allowscriptaccess="always"></iframe>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Fin video modal -->


<!-- Inicio Quiénes Somos  -->
<div class="container-fluid py-5">
    <div class="container">
        <div class="border-start border-5 border-primary ps-5 mb-5" style="max-width: 600px;">
            <h6 class="text-primary text-uppercase"><spring:message code="quienesSomos.titulo"/></h6>
            <h1 class="display-5 text-uppercase mb-0"><spring:message code="quienesSomos.conocenosMas"/></h1>
        </div>
        <div class="row g-5">
            <div class="col-md-6">
                <p><spring:message code="quienesSomos.parrafo1"/></p>
                <p><spring:message code="quienesSomos.parrafo2"/></p>
            </div>
            <div class="col-md-6">
                <p><spring:message code="quienesSomos.parrafo3"/></p>
                <p><spring:message code="quienesSomos.parrafo4"/></p>
            </div>
        </div>
    </div>
</div>
<!-- Fin Quiénes Somos -->

<!-- Inicio Acerca de Nosotros -->
<div class="container-fluid py-5">
    <div class="container">
        <div class="row gx-5">
            <div class="col-lg-5 mb-5 mb-lg-0" style="min-height: 500px;">
                <div class="position-relative h-100">
                    <img class="position-absolute w-100 h-100 rounded" src="/resources/img/about.jpg"
                         alt="<spring:message code='acercaDeNosotros.titulo' />" style="object-fit: cover;">
                </div>
            </div>
            <div class="col-lg-7">
                <div class="border-start border-5 border-primary ps-5 mb-5">
                    <h6 class="text-primary text-uppercase"><spring:message code="acercaDeNosotros.titulo"/></h6>
                    <h1 class="display-5 text-uppercase mb-0"><spring:message
                            code="acercaDeNosotros.mantenerFelices"/></h1>
                </div>
                <h4 class="text-body mb-4"><spring:message code="acercaDeNosotros.subtitulo"/></h4>
                <div class="bg-light p-4">
                    <ul class="nav nav-pills justify-content-between mb-3" id="pills-tab" role="tablist">
                        <li class="nav-item w-50" role="presentation">
                            <button class="nav-link text-uppercase w-100 active" id="pills-1-tab" data-bs-toggle="pill"
                                    data-bs-target="#pills-1" type="button" role="tab" aria-controls="pills-1"
                                    aria-selected="true"><spring:message
                                    code="acercaDeNosotros.nuestraMision"/></button>
                        </li>
                        <li class="nav-item w-50" role="presentation">
                            <button class="nav-link text-uppercase w-100" id="pills-2-tab" data-bs-toggle="pill"
                                    data-bs-target="#pills-2" type="button" role="tab" aria-controls="pills-2"
                                    aria-selected="false"><spring:message
                                    code="acercaDeNosotros.nuestraVision"/></button>
                        </li>
                    </ul>
                    <div class="tab-content" id="pills-tabContent">
                        <div class="tab-pane fade show active" id="pills-1" role="tabpanel"
                             aria-labelledby="pills-1-tab">
                            <p class="mb-0"><spring:message code="acercaDeNosotros.misionDescripcion"/></p>
                        </div>
                        <div class="tab-pane fade" id="pills-2" role="tabpanel" aria-labelledby="pills-2-tab">
                            <p class="mb-0"><spring:message code="acercaDeNosotros.visionDescripcion"/></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Fin Acerca de Nosotros -->


<!-- Inicio Footer -->
<div class="container-fluid bg-dark text-secondary mt-5 py-5 px-sm-3 px-md-5">
    <div class="row pt-5">
        <div class="col-lg-3 col-md-6 mb-5">
            <h4 class="text-uppercase text-light mb-4"><spring:message code="footer.contacto"/></h4>
            <p class="mb-2"><i class="bi bi-geo-alt text-primary me-2"></i><spring:message code="footer.direccion"/></p>
            <p class="mb-2"><i class="bi bi-envelope-open text-primary me-2"></i><spring:message code="footer.correo"/>
            </p>
            <p class="mb-0"><i class="bi bi-telephone text-primary me-2"></i><spring:message code="footer.telefono"/>
            </p>
        </div>
        <div class="col-lg-3 col-md-6 mb-5">
            <h4 class="text-uppercase text-light mb-4"><spring:message code="footer.enlacesRapidos"/></h4>
            <div class="d-flex flex-column justify-content-start">
                <a class="text-secondary mb-2" href="<%= request.getContextPath() %>/"><spring:message
                        code="footer.inicio"/></a>
                <a class="text-secondary mb-2" href="#"><spring:message code="footer.adoptar"/></a>
                <a class="text-secondary mb-2" href="#"><spring:message code="footer.servicios"/></a>
                <a class="text-secondary mb-2" href="#"><spring:message code="footer.productos"/></a>
                <a class="text-secondary mb-2" href="#"><spring:message code="footer.blog"/></a>
                <a class="text-secondary" href="#"><spring:message code="footer.contactoNosotros"/></a>
            </div>
        </div>
        <div class="col-lg-3 col-md-6 mb-5">
            <h4 class="text-uppercase text-light mb-4"><spring:message code="footer.enlacesPopulares"/></h4>
            <div class="d-flex flex-column justify-content-start">
                <a class="text-secondary mb-2" href="#"><spring:message code="footer.sobreNosotros"/></a>
                <a class="text-secondary mb-2" href="#"><spring:message code="footer.adoptar"/></a>
                <a class="text-secondary mb-2" href="#"><spring:message code="footer.servicios"/></a>
                <a class="text-secondary" href="#"><spring:message code="footer.contactoNosotros"/></a>
            </div>
        </div>
        <div class="col-lg-3 col-md-6 mb-5">
            <h4 class="text-uppercase text-light mb-4"><spring:message code="footer.boletin"/></h4>
            <p class="mb-4"><spring:message code="footer.infoSuscribirse"/></p>
            <div class="w-100">
                <div class="input-group">
                    <input type="text" class="form-control border-light" style="padding: 25px;"
                           placeholder="<spring:message code="footer.correoPlaceholder" />">
                    <button class="btn btn-primary px-4"><spring:message code="footer.suscribirse"/></button>
                </div>
            </div>
        </div>
    </div>
    <div class="container border-top border-secondary pt-5">
        <p class="m-0 text-center text-secondary">&copy; <a class="text-primary" href="#"><spring:message
                code="footer.derechos"/></a>. <spring:message code="footer.disenadoPor"/> <a class="text-primary"
                                                                                             href="#"><spring:message
                code="footer.disenador"/></a></p>
    </div>
</div>
<!-- Fin Footer -->

<!-- Regresar al inicio -->
<a href="#" class="btn btn-primary py-3 fs-4 back-to-top"><i class="bi bi-arrow-up"></i></a>

<!-- Librerias JavaScript y js-->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="/resources/lib/easing/easing.min.js"></script>
<script src="/resources/lib/waypoints/waypoints.min.js"></script>
<script src="/resources/lib/owlcarousel/owl.carousel.min.js"></script>
<script src="/resources/js/main.js"></script>
</body>
</html>
