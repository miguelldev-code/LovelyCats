<%@ include file="../common/header.jsp" %>
<%@ include file="../common/navigation.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3 ">
            <div class="panel panel-primary">
                <div class="panel-heading">Adicionar Mascota</div>
                <div class="panel-body">
                    <form:form method="post" modelAttribute="pet" enctype="multipart/form-data">
                        <form:hidden path="id"/>
                        <fieldset class="form-group">
                            <form:label path="namePet">Nombre</form:label>
                            <form:input path="namePet" type="text" class="form-control"
                                        required="required"/>
                            <form:errors path="namePet" cssClass="text-warning"/>
                        </fieldset>

                        <fieldset class="form-group">
                            <form:label path="age">Edad</form:label>
                            <form:input path="age" type="number" class="form-control"
                                        required="required"/>
                            <form:errors path="age" cssClass="text-warning"/>
                        </fieldset>

                        <fieldset class="form-group">
                            <form:label path="gender">Género</form:label>
                            <form:input path="gender" type="text" class="form-control"
                                        required="required"/>
                            <form:errors path="gender" cssClass="text-warning"/>
                        </fieldset>

                        <fieldset class="form-group">
                            <form:label path="description">Descripción</form:label>
                            <form:input path="description" type="text" class="form-control"
                                        required="required"/>
                            <form:errors path="description" cssClass="text-warning"/>
                        </fieldset>

                        <fieldset class="form-group">
                            <form:label path="status">Estado</form:label>
                            <form:input path="status" type="text" class="form-control"
                                        required="required"/>
                            <form:errors path="status" cssClass="text-warning"/>
                        </fieldset>

                        <fieldset class="form-group">
                            <form:label path="adoptionDate">Fecha de Adopción</form:label>
                            <form:input path="adoptionDate" type="text" class="form-control"
                                        required="required"/>
                            <form:errors path="adoptionDate" cssClass="text-warning"/>
                        </fieldset>

                        <fieldset class="form-group">
                            <label for="image" class="form-label">Imagen mascota</label>
                            <input type="file" class="form-control" id="image" name="file" step="0.01" required>
                        </fieldset>

                        <button type="submit" class="btn btn-success">Guardar</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../common/footer.jsp" %>
