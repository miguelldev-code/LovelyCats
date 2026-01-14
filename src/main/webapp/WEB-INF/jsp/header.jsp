<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
        <nav class="navbar navbar-expand-lg bg-white navbar-light shadow-sm py-3 py-lg-0 px-3 px-lg-0">
            <a href="<%= request.getContextPath() %>/" class="navbar-brand ms-lg-5">
                <h1 class="m-0 text-uppercase text-dark"><img src="/resources/img/logo.png" class="img-logo" alt="logo">
                </h1>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <div class="navbar-nav ms-auto py-0">
                    <a href="<%= request.getContextPath() %>/" class="nav-item nav-link ">
                        <spring:message code="navbar.home" />
                    </a>
                    <a href="/adopte" class="nav-item nav-link ">
                        <spring:message code="navbar.adoptar" />
                    </a>
                    <a href="/service" class="nav-item nav-link">
                        <spring:message code="navbar.servicios" />
                    </a>
                    <a href="/vsc-product" class="nav-item nav-link active">
                        <spring:message code="navbar.productos" />
                    </a>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle bi bi-translate" data-bs-toggle="dropdown">
                            <spring:message code="navbar.idioma" />
                        </a>
                        <div class="dropdown-menu m-0">
                            <a class="dropdown-item" href="?lang=es">Español</a>
                            <a class="dropdown-item" href="?lang=en">English</a>
                            <a class="dropdown-item" href="?lang=fr">Français</a>
                            <a class="dropdown-item" href="?lang=it">Italiano</a>
                        </div>
                    </div>
                    <a href="/login" class="nav-item nav-link nav-contact bg-primary text-white px-5 ms-lg-5">
                        <spring:message code="navbar.iniciarSesion" />
                    </a>
                    <a href="/cart" class="nav-item nav-link"><i class="bi bi-cart-fill text-primary display-6"></i></a>
                </div>
            </div>
        </nav>