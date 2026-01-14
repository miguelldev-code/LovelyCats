<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8">
                <title>Lovely Cats - Carrito</title>
                <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
                <link href="/resources/css/style.css" rel="stylesheet">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
                    rel="stylesheet">
            </head>

            <body>

                <jsp:include page="header.jsp" />

                <div class="container py-5">
                    <h2>Carrito de Compras</h2>
                    <div class="table-responsive mb-5">
                        <table class="table table-bordered text-center mb-0">
                            <thead class="bg-primary text-dark">
                                <tr>
                                    <th>Producto</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Total</th>
                                    <th>Acción</th>
                                </tr>
                            </thead>
                            <tbody class="align-middle">
                                <c:forEach var="item" items="${cart}">
                                    <tr>
                                        <td class="align-middle"><img src="/uploads/product/${item.product.image}"
                                                alt="" style="width: 50px;"> ${item.product.nameProduct}</td>
                                        <td class="align-middle">${item.product.price}</td>
                                        <td class="align-middle">${item.quantity}</td>
                                        <td class="align-middle">
                                            $
                                            <fmt:formatNumber type="number" maxFractionDigits="2"
                                                value="${item.totalPrice}" />
                                        </td>
                                        <td class="align-middle">
                                            <a href="/cart/remove/${item.product.id}" class="btn btn-sm btn-danger"><i
                                                    class="bi bi-x"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <c:if test="${empty cart}">
                                    <tr>
                                        <td colspan="5">Tu carrito está vacío. <a href="/vsc-product">Ir a comprar</a>
                                        </td>
                                    </tr>
                                </c:if>
                            </tbody>
                        </table>
                    </div>

                    <div class="row">
                        <div class="col-lg-4 ms-auto">
                            <div class="bg-light p-30 mb-5">
                                <div class="border-bottom pb-2">
                                    <div class="d-flex justify-content-between mb-3">
                                        <h6>Subtotal</h6>
                                        <h6>$
                                            <fmt:formatNumber type="number" maxFractionDigits="2" value="${total}" />
                                        </h6>
                                    </div>
                                </div>
                                <div class="pt-2">
                                    <a href="/cart/checkout"
                                        class="btn btn-block btn-primary font-weight-bold my-3 py-3 ${empty cart ? 'disabled' : ''}">Proceder
                                        al Checkout</a>
                                    <a href="/vsc-product"
                                        class="btn btn-block btn-secondary font-weight-bold my-3 py-3">Seguir
                                        Comprando</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
            </body>

            </html>