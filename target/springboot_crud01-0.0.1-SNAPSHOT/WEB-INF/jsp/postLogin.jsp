
<%@ include file="common/header.jsp"%>
<div class="d-flex flex-column align-items-center justify-content-center" style="height: 100vh;">
    <h1>BIENVENIDO OTRA VEZ</h1>
    <p>Nombre: ${usuario.userNombre}</p>
    <p>Apellido: ${usuario.userApellido}</p>
    <p>User: ${usuario.userUser}</p>
    <p>${rol}</p>
    <c:if test="${rol eq 'ROLE_ADMIN'}">
        <a href="/welcome/admin" class="btn btn-primary">CLICK PARA IR A LA SECCION ADMIN</a>
    </c:if>
</div>
</body>
</html>