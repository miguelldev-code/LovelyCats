<%@ include file="common/header.jsp"%>
<div class="d-flex flex-column align-items-center justify-content-center" style="height: 100vh;">
    <h1>BIENVENIDO ADMIN :D</h1>
<br><br>
    <div class="container">
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Usuario</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${usuarios}" var="user">
                <tr>
                    <td>${user.userid}</td>
                    <td>${user.userNombre}</td>
                    <td>${user.userApellido}</td>
                    <td>${user.userUser}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


</body>


</html>