<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>

<div class="container">

    <div class="panel panel-primary">
        <div class="panel-heading">
            <h2>Mi Informacion</h2>
        </div>
        <div class="panel-body">
            <p><strong>Nombre:</strong> ${name}</p>
            <p><strong>Codigo:</strong> ${codigoEstudiante}</p>
            <p><strong>Programa:</strong> ${programa}</p>
            <p><strong>Correo electronico:</strong> ${correo}</p>
        </div>
    </div>

    <div class="panel panel-primary">
        <div class="panel-heading">
            <h2>Mis Notas</h2>
        </div>
        <div class="panel-body">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th width="40%">Curso</th>
                    <th width="30%">Nota Numerica</th>
                    <th width="30%">Concepto</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${notas}" var="nota">
                    <tr>
                        <td>${nota.curso}</td>
                        <td>${nota.notaNumerica}</td>
                        <td>${nota.concepto}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <div class="panel panel-primary">
        <div class="panel-heading">
            <h2>Mis Horarios</h2>
        </div>
        <div class="panel-body">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th width="30%">Dia</th>
                    <th width="30%">Hora</th>
                    <th width="40%">Curso</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${horarios}" var="horario">
                    <tr>
                        <td>${horario.dia}</td>
                        <td>${horario.horaInicio} - ${horario.horaFin}</td>
                        <td>${horario.curso}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>
<%@ include file="common/footer.jsp" %>
