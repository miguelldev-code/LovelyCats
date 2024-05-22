<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>

<div class="container">

    <div class="panel panel-primary">
        <div class="panel-heading">
            <h2>Mantenimiento de Cursos</h2>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-md-6">
                    <h3>Crear Nuevo Curso</h3>
                    <form action="/crear-curso" method="post">
                        <div class="form-group">
                            <label for="nombreCurso">Nombre del Curso:</label>
                            <input type="text" class="form-control" id="nombreCurso" name="nombreCurso"
                                   placeholder="Ingrese el nombre del curso">
                        </div>
                        <div class="form-group">
                            <label for="codigoCurso">Codigo del Curso:</label>
                            <input type="text" class="form-control" id="codigoCurso" name="codigoCurso"
                                   placeholder="Ingrese el codigo del curso">
                        </div>
                        <button type="submit" class="btn btn-primary">Crear Curso</button>
                    </form>
                </div>
                <div class="col-md-6">
                    <h3>Editar Curso Existente</h3>
                    <form action="/editar-curso" method="post">
                        <div class="form-group">
                            <label for="idCurso">Seleccionar Curso:</label>
                            <select class="form-control" id="idCurso" name="idCurso">
                                <option value="">Seleccionar Curso</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="nombreCursoEdit">Nombre del Curso:</label>
                            <input type="text" class="form-control" id="nombreCursoEdit" name="nombreCursoEdit"
                                   placeholder="Ingrese el nombre del curso">
                        </div>
                        <div class="form-group">
                            <label for="codigoCursoEdit">Codigo del Curso:</label>
                            <input type="text" class="form-control" id="codigoCursoEdit" name="codigoCursoEdit"
                                   placeholder="Ingrese el codigo del curso">
                        </div>
                        <button type="submit" class="btn btn-primary">Editar Curso</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="panel panel-primary">
        <div class="panel-heading">
            <h2>Mantenimiento de Estudiantes</h2>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-md-6">
                    <h3>Crear Nuevo Estudiante</h3>
                    <form action="/crear-estudiante" method="post">
                        <div class="form-group">
                            <label for="nombreEstudiante">Nombre del Estudiante:</label>
                            <input type="text" class="form-control" id="nombreEstudiante" name="nombreEstudiante"
                                   placeholder="Ingrese el nombre del estudiante">
                        </div>
                        <div class="form-group">
                            <label for="codigoEstudiante">Codigo del Estudiante:</label>
                            <input type="text" class="form-control" id="codigoEstudiante" name="codigoEstudiante"
                                   placeholder="Ingrese el codigo del estudiante">
                        </div>
                        <div class="form-group">
                            <label for="programaEstudiante">Programa del Estudiante:</label>
                            <input type="text" class="form-control" id="programaEstudiante" name="programaEstudiante"
                                   placeholder="Ingrese el programa del estudiante">
                        </div>
                        <div class="form-group">
                            <label for="correoEstudiante">Correo Electronico del Estudiante:</label>
                            <input type="email" class="form-control" id="correoEstudiante" name="correoEstudiante"
                                   placeholder="Ingrese el correo electronico del estudiante">
                        </div>
                        <button type="submit" class="btn btn-primary">Crear Estudiante</button>
                    </form>
                </div>
                <div class="col-md-6">
                    <h3>Editar Estudiante Existente</h3>
                    <form action="/editar-estudiante" method="post">
                        <div class="form-group">
                            <label for="idEstudiante">Seleccionar Estudiante:</label>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>