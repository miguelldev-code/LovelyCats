<%@ include file="../common/header.jsp" %>
<%@ include file="../common/navigation.jsp" %>

<div class="container">
    <div>
        <a type="button" class="btn btn-primary btn-md" href="/add-pet">Adicionar Mascota</a>
    </div>
    <br>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3>Lista de Mascotas</h3>
        </div>
        <div class="panel-body">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Edad</th>
                    <th>Género</th>
                    <th>Descripción</th>
                    <th>Fecha de Adopción</th>
                    <th>Foto</th>
                    <th>Acciones</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pet}" var="pet">
                    <tr>
                        <td>${pet.namePet}</td>
                        <td>${pet.age}</td>
                        <td>${pet.gender}</td>
                        <td>${pet.description}</td>
                        <td>${pet.adoptionDate}</td>
                        <td><img class="" style="height: 70px" src="../uploads/${pet.image}" alt="pet"/></td>

                        <td>
                            <a type="button" class="btn btn-success"
                               href="/update-pet?id=${pet.id}">Actualizar</a>
                            <a type="button" class="btn btn-warning"
                               href="/delete-pet?id=${pet.id}">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@ include file="../common/footer.jsp" %>
