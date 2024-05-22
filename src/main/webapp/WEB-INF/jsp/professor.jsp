<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>

<div class="container">

    <div class="panel panel-primary">
        <div class="panel-heading">
            <h2>Bienvenido Profesor ${name}</h2>
        </div>
        <div class="panel-body">
            <p>Esta pagina solo la ven los roles de profesores.</p>
        </div>
    </div>

    <div class="panel panel-primary">
        <div class="panel-heading">
            <h2>Mis Cursos</h2>
        </div>
        <div class="panel-body">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th width="40%">Nombre del Curso</th>
                    <th width="30%">Codigo del Curso</th>
                    <th width="30%">Estudiantes</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cursos}" var="curso">
                    <tr>
                        <td>${curso.nombre}</td>
                        <td>${curso.codigo}</td>
                        <td>
                            <a href="/curso/estudiantes/${curso.id}">Ver Estudiantes</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>

<%@ include file="common/footer.jsp" %>
