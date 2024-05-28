<%@ include file="../common/header.jsp" %>
<%@ include file="../common/navigation.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-primary">
                <div class="panel-heading">Adicionar Producto</div>
                <div class="panel-body">
                    <form:form method="post" modelAttribute="product" enctype="multipart/form-data">
                        <form:hidden path="id"/>
                        <fieldset class="form-group">
                            <form:label path="nameProduct">Nombre Producto</form:label>
                            <form:input path="nameProduct" type="text" class="form-control" required="required"/>
                            <form:errors path="nameProduct" cssClass="text-warning"/>
                        </fieldset>

                        <fieldset class="form-group">
                            <form:label path="description">Descripción</form:label>
                            <form:input path="description" type="text" class="form-control" required="required"/>
                            <form:errors path="description" cssClass="text-warning"/>
                        </fieldset>

                        <fieldset class="form-group">
                            <form:label path="price">Precio</form:label>
                            <form:input path="price" type="number" step="0.01" class="form-control" required="required"/>
                            <form:errors path="price" cssClass="text-warning"/>
                        </fieldset>

                        <fieldset class="form-group">
                            <label for="image" class="form-label">Imagen</label>
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
