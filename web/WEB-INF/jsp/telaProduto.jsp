<%-- Document : telaProduto Created on : 06/05/2024, 16:52:59 Author : Senai --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

    <head>
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


                </div>
                <div class="categorias">
                    <c:forEach items="${categorias}" var="categoria">
                        <div class="categoria">
                            <a
                                href="./buscar-produtos?cat=${categoria.idCategoria}&busca=">${categoria.nome}</a>
                        </div>
                    </c:forEach>
                </div>
                <br>
            </div>
        </header>
        <main>
            <div class="areaProduto">
                <div class="container text-center">
                    <div class="row">
                        <div class="col-sm-8"> <img src="data:image/jpg;base64,${produto.img}"
                                                    class="card-img-top" alt="${produto.nome}"></div>
                        <div class="col-sm-4">
                            <h3>${produto.nome}</h3>
                            <h5>Preço:${produto.preço}</h5>
                        </div>
                    </div>
                    <div class="row1">
                        <div class="col-sm">
                            <p>Descriçao:${produto.descriçao}</p>
                        </div>
                        <div class="col-sm">
                            <p>Categoria:${produto.fk_categoria}</p>
                        </div>
                        <div class="col-sm">

                            <form name="formCarr" method="GET" action="enviar-carr">
                                <input type="hidden" name="id" value="${produto.id_Produto}">
                                <input type="number" placeholder="Quantidade" class="form-control" id="quantidade" name="quantidade" min="1" required>
                                  <input type="hidden" name="preco_uni" value="${produto.preço}">
                                <button class="comprar" type="submit">Comprar</button>
                            </form>

                        </div>
                    </div>
                </div>

            </div>
        </main>
        <footer>
            <h3>CYBER TREND</h3>
            <p>Daniel trizotto@2024</p>
        </footer>
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