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


<div class="container">
    <div class="alert alert-danger text-center" role="alert">
        <h4 class="alert-heading">Acceso Denegado!</h4>
        <p>Error al ingresar a la pagina.</p>
        <p>Por favor, contacta a tu administrador para obtener acceso.</p>
    </div>
</div>


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
