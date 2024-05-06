<%-- Document : telaProduto Created on : 06/05/2024, 16:52:59 Author : Senai --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
                    integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
                    crossorigin="anonymous">
                <title>tela Produto</title>
                <script src="https://kit.fontawesome.com/0444e3e789.js" crossorigin="anonymous"></script>
            </head>

            <body>
                <header>
                    <nav class="navbar navbar-expand-lg navbar-light bg-light">
                        <div class="container-fluid">
                            <a class="navbar-brand" href="./home"><i class="fa-solid fa-house"></i></a>
                            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                                <div class="busca-pc">
                                    <form class="d-flex" action="buscar-produtos" method="get">
                                        <input class="form-control me-2" name="busca" type="search" placeholder="Search"
                                            aria-label="Search">
                                        <button class="btn btn-outline-success" type="submit">
                                            <i class="fa-solid fa-magnifying-glass"></i>
                                        </button>
                                    </form>
                                </div>
                            </div>
                            <div class="busca-mobile">
                                <form class="d-flex" action="buscar-produtos" method="get">
                                    <input class="form-control me-2" name="busca" type="search" placeholder="Search"
                                        aria-label="Search">
                                    <button class="btn btn-outline-success" type="submit">
                                        <i class="fa-solid fa-magnifying-glass"></i>
                                    </button>
                                </form>
                            </div>
                        </div>

                        <div class="container container-categorias">
                            <c:forEach items="${categorias}" var="categoria">
                                <div class="categoria">
                                    <a
                                        href="./buscar-produtos?cat=${categoria.idCategoria}&busca=">${categoria.nome}</a>
                                </div>
                            </c:forEach>
                        </div>


                    </nav>
                </header>
                <main>
                    <div items="${produtos}" var="produto">
                        <div class="container text-center">
                            <div class="row">
                                <div class="col-sm-8">${produto.imgBlob}</div>
                                <div class="col-sm-4">${produto.nome}</div>
                            </div>
                            <div class="row">
                                <div class="col-sm">${produto.descriçao}</div>
                                <div class="col-sm">c${produto.preço}</div>
                               
                            </div>
                        </div>

                    </div>
                </main>
            </body>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
                crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
                integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
                crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
                integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
                crossorigin="anonymous"></script>

            </html>