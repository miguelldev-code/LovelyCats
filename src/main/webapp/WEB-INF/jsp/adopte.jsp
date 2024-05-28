<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
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
            <a href="<%= request.getContextPath() %>/" class="nav-item nav-link "><spring:message
                    code="navbar.home"/></a>
            <a href="/adopte" class="nav-item nav-link active"><spring:message code="navbar.adoptar"/></a>
            <a href="/service" class="nav-item nav-link"><spring:message code="navbar.servicios"/></a>
            <a href="/vsc-product" class="nav-item nav-link"><spring:message code="navbar.productos"/></a>
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

<!-- Inicio Informacion adopcion -->
<div class="container-fluid bg-offer my-5 py-5">
    <div class="container py-5">
        <div class="row gx-5 justify-content-start">
            <div class="col-lg-7">
                <div class="border-start border-5 border-dark ps-5 mb-5">
                    <h6 class="text-dark text-uppercase"><spring:message code="adopte.titulo"/></h6>
                    <h1 class="display-5 text-uppercase text-white mb-0"><spring:message code="adopte.subtitulo"/></h1>
                </div>
                <p class="text-white mb-4"><spring:message code="adopte.descripcion"/></p>
                <a href="" class="btn btn-light py-md-3 px-md-5 me-3"><spring:message code="adopte.masInfo"/></a>
                <a href="" class="btn btn-outline-light py-md-3 px-md-5" data-bs-toggle="modal"
                   data-src="https://forms.gle/ZYiqHEoh4oRhN2yT9" data-bs-target="#formularioModal"><spring:message
                        code="adopte.descargarForm"/></a>
            </div>
        </div>
    </div>
</div>
<!-- Fin Informacion adopcion -->

<!-- Inicio Mascotas -->
<div class="container-fluid py-5">
    <div class="container">
        <div class="border-start border-5 border-primary ps-5 mb-5" style="max-width: 1000px;">
            <h6 class="text-primary text-uppercase"><spring:message code="mascotas.titulo"/></h6>
            <h1 class="display-5 text-uppercase mb-0"><spring:message code="mascotas.subtitulo"/></h1>
            <h4 class="text-body mb-4"><spring:message code="mascotas.descripcion"/></h4>
        </div>
        <div class="owl-carousel team-carousel position-relative" style="padding-right: 25px;">
            <c:forEach items="${pet}" var="pet">
                <div class="team-item card-container">
                    <div class="position-relative overflow-hidden">
                        <img class="img-fluid w-100 card-img-pet" src="../uploads/${pet.image}" alt="pet">
                        <div class="team-overlay">
                            <div class="d-flex align-items-center justify-content-start">
                                <a class="btn btn-light btn-square mx-1" href="#"><i class="bi bi-twitter"></i></a>
                                <a class="btn btn-light btn-square mx-1" href="#"><i class="bi bi-facebook"></i></a>
                                <a class="btn btn-light btn-square mx-1" href="#"><i class="bi bi-linkedin"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="bg-light p-4">
                        <h5 class="card-title">${pet.namePet}</h5>
                        <p class="card-text">Descripcion: ${pet.description}</p>
                        <p class="card-text">Género: ${pet.gender}</p>
                        <p class="card-text">Años: ${pet.age}</p>
                        <button type="button" class="btn btn-dark" data-bs-toggle="modal"
                                data-src="https://forms.gle/ZYiqHEoh4oRhN2yT9" data-bs-target="#formularioModal">
                            Pregunta por mi
                        </button>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<!-- Fin Mascotas -->

<!-- Inicio Formulario Modal -->
<div class="modal fade" id="formularioModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content rounded-0">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel"><spring:message code="formulario.titulo"/></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <!-- 16:9 aspect ratio -->
                <div class="ratio ratio-16x9">
                    <iframe class="embed-responsive-item" src="" id="formulario" allowfullscreen
                            allowscriptaccess="always" allow="autoplay"></iframe>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Fin Formulario Modal -->

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
