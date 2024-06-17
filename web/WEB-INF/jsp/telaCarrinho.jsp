<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <a class="outro" href="#"><i class="fa-solid fa-cart-shopping"></i></a>
                    <a class="outro" href="./pedidos"><i class="fa-solid fa-truck"></i></a>
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
            <div class="areaCarrinho">
                <c:forEach items="${carrinho}" var="carrinho">
                    <div class="carrinho">
                        <img src="data:image/jpg;base64,${carrinho.img}" class="imgCarrinho"
                             alt="${carrinho.nome}">
                        <div class="texto">
                            <p class="card-text">nome:${carrinho.nome}</p>
                            <p class="card-text">quantidade:${carrinho.quantidade}</p>
                            <p class="card-text">categoria:${carrinho.fkCategoria}</p>
                            <p class="card-text">Valor unitario:${carrinho.preço}</p>
                            <p class="card-text">Valor total:${carrinho.preço * carrinho.quantidade }</p>
                        </div>
                        <form action="apagarProduto" method="post">
                            <input type="hidden" name="id" value="${carrinho.idCarrinho}">
                            <div class="excluir"><button name="apagarP" style="border: none;" type="submit" ><i class="fa-solid fa-trash"></i></button></div>
                        </form>
                    </div>

                    <hr>
                </c:forEach>
            </div>
            <br><br><br><br><br>
            <form action="excluirCarrin" method="post"><button class="excluirCarrinh" type="submit">Excluir carrinho</button></form>
            <div class="finalizarArea">
                <div class="area">
                    <p>Total Carrinho:${total}</p>

                    <button><a href="./checkout">Finalizar Compra</a></button>

                </div>
            </div>
        </main>
        <footer>
            <h3>CYBER TREND</h3>
            <p>Daniel trizotto@2024</p>
        </footer>
        <script>
            var carrinhoItems = document.querySelectorAll('.carrinho');
            if (carrinhoItems.length === 0) {
                var areaCarrinho = document.querySelector('.areaCarrinho');
                areaCarrinho.innerHTML = "<p>Carrinho vazio</p>";
            }
        </script>
    </body>

</html>