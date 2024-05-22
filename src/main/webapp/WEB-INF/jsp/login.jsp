<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Iniciar sesión</title>
    <!-- Asegúrate de incluir Bootstrap en tu proyecto -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>


<!-- Login Form Start -->
<div class="container-fluid p-5">
    <div class="container">
        <div class="border-start border-5 border-primary ps-5 mb-5" style="max-width: 600px;">
            <h6 class="text-primary text-uppercase">Iniciar sesion</h6>
            <h1 class="display-5 text-uppercase mb-0">¡Bienvenido!</h1>
        </div>
        <div class="row g-5">
            <div class="col-lg-7 mx-auto"> <!-- Agregada la clase mx-auto -->
                <!---RUTA DE POST SERA EN /login-->
                <form action="/login" method="post">
                    <form>
                        <div class="mb-3">
                            <input type="text" name="username" class="form-control bg-light border-0 px-4"
                                   placeholder="Usuario" style="height: 55px;">
                        </div>
                        <div class="mb-3">
                            <label>
                                <input type="password" name="password" class="form-control bg-light border-0 px-4"
                                       placeholder="Contraseña"
                                       style="height: 55px;">
                            </label>
                        </div>
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="rememberCheck">
                                <label class="form-check-label" for="rememberCheck">
                                    Recuerdame d
                                </label>
                            </div>
                            <a href="#" class="text-decoration-none">¿Olvidaste la contraseña?</a>
                        </div>
                        <div class="mb-3">
                            <button class="btn btn-primary w-100 py-3" type="submit">Entrar</button>
                        </div>
                        <div class="text-center">
                            <p>¿No estas registrado? <a href="singin.html">Registrate aqui</a></p>
                        </div>
                    </form>
            </div>
        </div>
    </div>
</div>
<!-- Login Form End -->


<c:if test="${error != null}">
    <div class="alert alert-danger" role="alert">
            ${error}
    </div>
</c:if>
</body>
</html>