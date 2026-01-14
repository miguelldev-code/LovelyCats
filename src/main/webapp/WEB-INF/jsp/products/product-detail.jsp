<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
        <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8">
                <title>Lovely Cats - ${product.nameProduct}</title>
                <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
                <link href="/resources/css/style.css" rel="stylesheet">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
                    rel="stylesheet">
            </head>

            <body>

                <jsp:include page="../header.jsp" />

                <div class="container py-5">
                    <div class="row">
                        <div class="col-lg-6">
                            <img class="img-fluid w-100" src="../uploads/product/${product.image}"
                                alt="${product.nameProduct}">
                        </div>
                        <div class="col-lg-6 h-auto mb-30">
                            <div class="h-100 bg-light p-30">
                                <h3>${product.nameProduct}</h3>
                                <h3 class="font-weight-semi-bold mb-4">${product.price}</h3>
                                <p class="mb-4">${product.description}</p>
                                <div class="d-flex align-items-center mb-4 pt-2">
                                    <a href="/cart/add/${product.id}" class="btn btn-primary px-3"><i
                                            class="bi bi-cart-plus mr-1"></i> Agregar al Carrito</a>
                                    <a href="/vsc-product" class="btn btn-secondary px-3 ms-2">Volver</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
            </body>

            </html>