<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Administración de Usuarios</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <style>
        body {
            padding-top: 20px;
            background-color: #f8f9fa;
        }
        .jumbotron {
            background-color: #e9ecef;
        }
        .center-screen {
            display: flex;
            flex-direction: column;
            justify-content: center;
            height: 100%;
        }
    </style>
</head>

<body>
<div class="container center-screen">
    <div class="jumbotron text-center">
        <h1>Registrate</h1>
        <c:if test="${REGISTRO != null}">
            <p>Nombre: ${REGISTRO}</p>
            <p>${REGISTRO.userid}</p>
            <p>${REGISTRO.userNombre}</p>
            <p>${REGISTRO.userApellido}</p>
            <p>${REGISTRO.userUser}</p>
            <ul>
                <c:forEach items="${REGISTRO.roles}" var="rol">
                    <li>${rol.rolNombre}</li>
                </c:forEach>
            </ul>
        </c:if>

        <c:if test="${REGISTRO == null}">
            <p> NO HAY REGISTRO AUN HECHO :) recuerda ir a UserService linea 47 al 52</p>
        </c:if>
    </div>
    <button onclick="window.location.href='/';">Regresar a página principal</button>

</div>
</body>

</html>