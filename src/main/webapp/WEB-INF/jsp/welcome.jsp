<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>
<div class="container">

    <div class="panel panel-primary">
        <div class="panel-heading">Portal de acceso - sistema de notas</div>

        <div class="panel-body">
            <p class="text-muted">Si eres admin, haz click en el siguiente boton para administrar usuarios.</p>
            <button type="button" class="btn btn-primary" onclick="window.location.href='/list-todos'">Portal a
                administrador
            </button>
        </div>
        <div class="panel-body">
            <p class="text-muted">Si eres estudiante, accede a tus notas haciendo click en este boton.</p>
            <button type="button" class="btn btn-primary" onclick="window.location.href='/student'">Portal a
                estudiantes
            </button>
        </div>
        <div class="panel-body">
            <p class="text-muted">Si eres profesor, haz click en el boton para editar notas de estudiantes.</p>
            <button type="button" class="btn btn-primary" onclick="window.location.href='/professor'">Portal a
                profesores
            </button>
        </div>
        <div class="panel-body">
            <p class="text-muted">Si eres de mantenimiento, haz click en el boton para realizar ajustes necesarios.</p>
            <button type="button" class="btn btn-primary" onclick="window.location.href='/maintenance'">Portal a
                mantenimiento
            </button>
        </div>
    </div>
</div>

<%@ include file="common/footer.jsp" %>