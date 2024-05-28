<%@ include file="../common/header.jsp" %>
<%@ include file="../common/navigation.jsp" %>

<div class="container">
    <div>
        <a type="button" class="btn btn-primary btn-md" href="/add-product">Adicionar Producto</a>
    </div>
    <br>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3>Lista de Productos</h3>
        </div>
        <div class="panel-body">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Nombre Producto</th>
                    <th>Descripción</th>
                    <th>Precio</th>
                    <th>Acciones</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${product}" var="product">
                    <tr>
                        <td>${product.nameProduct}</td>
                        <td>${product.description}</td>
                        <td>${product.price}</td>
                        <td><img style="height: 70px" src="../uploads/${product.image}" alt="producto"/></td>

                        <td>
                            <a type="button" class="btn btn-success" href="/update-product?id=${product.id}">Actualizar</a>
                            <a type="button" class="btn btn-warning" href="/delete-product?id=${product.id}">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@ include file="../common/footer.jsp" %>
