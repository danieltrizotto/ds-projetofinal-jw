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
                <link rel="stylesheet" href="./styles/telaProduto.css">
            </head>

            <body>
                <header>
                    <nav class="navbar navbar-expand-lg navbar-light bg-light">
                        <div class="container-fluid">
                            <a class="navbar-brand" href="./home"><i class="fa-solid fa-house"></i></a>
                            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                                <div class="busca-pc">
                                    <form class="pesquisa" action="buscar-produtos" method="get">
                                        <input name="busca" type="search" placeholder="pesquisar.." aria-label="Search">
                                        <button class="b-submit" type="submit">
                                            <i class="fa-solid fa-magnifying-glass"></i>
                                        </button>
                                </div>
                            </div>
                            <div class="busca-mobile">
                                <form class="pesquisa" action="buscar-produtos" method="get">
                                    <input name="busca" type="search" placeholder="pesquisar.." aria-label="Search">
                                    <button class="b-submit" type="submit">
                                        <i class="fa-solid fa-magnifying-glass"></i>
                                    </button>
                                </form>
                            </div>
                        </div>
                        <h1>CyberMercado</h1>
                        <br>
                        <div></div>
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

                    <div class="mostrar">
                        <div class="cabeça">
                            <div class="img"><img src="" alt=""> <img src="data:image/jpg;base64,${produto.img}"
                                    alt="${produto.nome}"></div>
                            <div class=>
                                <h2>${produto.nome}</h5>
                            </div>
                        </div>
                        <br><br>
                        <hr>
                        <div class="corpo">
                            <div>
                                <p>${produto.preço}</p>
                            </div>
                            <div>
                                <p>${produto.descriçao}</p>
                            </div>
                            <div>
                                <p>${produto.fk_categoria}</p>
                            </div>
                        </div>
                    </div>

                </main>
            </body>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                crossorigin="anonymous"></script>
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