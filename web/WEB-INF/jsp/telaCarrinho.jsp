<%-- Document : telaCarrinho Created on : 13/05/2024, 14:30:47 Author : Senai --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
                integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
                crossorigin="anonymous">
            <title>Carrinho</title>
            <script src="https://kit.fontawesome.com/0444e3e789.js" crossorigin="anonymous"></script>
            <link rel="stylesheet" href="./styles/carrinho.css" />
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
                        <a class="outro" href=""><i class="fa-solid fa-truck"></i></a>
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
                <div class="carrinho">
                <c:forEach items="${produtos}" var="produto">
                    <img src="data:image/jpg;base64,${produto.img}" class="card-img-top" alt="${produto.nome}">
                      <div class="texto">
                        <h5>${produto.nome}</h5>
                        <p class="card-text">quantidade:${produto.quantidade}</p>
                        <p class="card-text">categoria:${produto.fk_categoria}</p>
                        <p class="card-text">Valor unitario:${produto.preço}</p>
                        <p class="card-text">Valor total:${produto.preço}</p>
                      </div>
                      <div class="excluir"><button><i class="fa-solid fa-trash"></i></button></div>
                </c:forEach>
            </div>
            </main>
        </body>

        </html>