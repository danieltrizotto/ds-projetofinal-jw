<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>

        <head>

            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
                integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
                crossorigin="anonymous">
            <title>Loja Home</title>
            <script src="https://kit.fontawesome.com/0444e3e789.js" crossorigin="anonymous"></script>
            <link rel="stylesheet" href="./styles/telaHome.css" />
        </head>

        <body>
            <header>
                <div class="header">
                    <div class="inicio">
                        <div class="logo">
                            <h1><a href="./home">CYBER TREND</a></h1>
                        </div>
                        <form class="pesquisa" action="buscar-produtos" method="get">
                            <input name="busca" class="busca" type="search" placeholder="pesquisar.."
                                aria-label="Search">
                            <button class="b-submit" type="submit">
                                <i class="fa-solid fa-magnifying-glass"></i>
                            </button>
                        </form>
                       <a class="outro" href="./carrinho"><i class="fa-solid fa-cart-shopping"></i></a>
                            <a class="outro" href="./pedidos"><i class="fa-solid fa-truck"></i></a>
                         <a class="outro" href="./voltarlogin"><i class="fa-solid fa-door-open"></i></a>
                     

                    </div>
                    <div class="categorias">
                        <c:forEach items="${categorias}" var="categoria">
                            <div class="categoria">
                                <a href="./buscar-produtos?cat=${categoria.idCategoria}&busca=">${categoria.nome}</a>
                            </div>
                        </c:forEach>
                    </div>
                    <br>
                </div>
            </header>
            <main>
                <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img class="d-block w-100" src="./assets/banner-3.jpg" alt="Primeiro Slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="./assets/roupas-masculinas.jpg" alt="Segundo Slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="./assets/roupas-femininas.jpg" alt="Terceiro Slide">
                        </div>

                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Anterior</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Próximo</span>
                    </a>
                </div>
                <h2>Produtos</h2>
                <hr>
                <div class="produtos">
                    <%-- Use JSP para iterar sobre a lista de livros e exibi-los na tabela --%>
                        <c:forEach items="${produtos}" var="produto">
                            <div class="card" style="width: 18rem;">
                                <img src="data:image/jpg;base64,${produto.img}" class="card-img-top"
                                    alt="${produto.nome}">
                                <br>
                                <div class="card-text">
                                    <h5 class="card-title">${produto.nome}</h5>
                                    <p class="card-text">Valor:${produto.preço}</p>
                                    <p class="card-text">Descriçao:${produto.descriçao}</p>
                                    <p class="card-text">categoria:${produto.fk_categoria}</p>
                                    <a href="./ver-produto?id=${produto.id_Produto}" class="btn btn-primary">Comprar</a>
                                </div>
                                <br>
                            </div>
                        </c:forEach>
                </div>
            </main>

            <footer>
                <h3>CYBER TREND</h3>
                <p>Daniel trizotto@2024</p>
            </footer>
        </body>
        <script src="https://kit.fontawesome.com/ffe7fbbd06.js" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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