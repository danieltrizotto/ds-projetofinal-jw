<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
              crossorigin="anonymous">
        <title>Checkout</title>
        <script src="https://kit.fontawesome.com/0444e3e789.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="./styles/checkout.css" />
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
            <div class="areaRevisao">
                <div class="textoRevisao">
                    <c:forEach items="${carrinho}" var="carrinho">
                        <div class="carrinho">
                            <img src="data:image/jpg;base64,${carrinho.img}" class="imgCarrinho"
                                 alt="${carrinho.nome}">
                            <div class="texto">
                                <p class="card-text">nome:${carrinho.nome}</p>
                                <p class="card-text">Descriçao:${carrinho.descricao}</p>
                                <p class="card-text">categoria:${carrinho.fkCategoria}</p>
                                <p class="card-text">Valor:${carrinho.preço}</p>
                                <p class="card-text">quantidade:${carrinho.quantidade}</p>
                            </div>
                        </div>
                        <hr>
                    </c:forEach>
                </div>
            </div>
            <br>
            <br>
            <br>
            <br>
            <br>
            <div class="pagamentoCheck">
                <div class="inserirEndereço" style="margin-right: 15rem;">
                    <form action="checkoutFrete" method="GET" class="frete">
                        <input type="text" placeholder="Rua" name="rua">
                        <br>
                        <input type="text" placeholder="Numero" name="numero">
                        <br>
                        <input type="text" placeholder="CEP" name="cep">
                        <br>
                        <button type="submit" name="freteBtn" class="freteBtn">informar endereço</button>
                    </form>
                </div>
                <br>

                <form action="checkoutPagamento" method="GET" name="formpaga">
                    <div class="metodoPagamneto" style="margin-right: 300px;">
                        <p><b>Método de Pagamento:</b><br>
                            <input type="radio" name="metodo" value="pix" onclick="mostrarDiv();">Pix<br>
                            <input type="radio" name="metodo" value="debito" onclick="mostrarDiv();">Débito<br>
                            <input type="radio" name="metodo" value="credito" onclick="mostrarDiv();">Crédito
                        </p>
                    </div>
                    <br>
                    <div class="finalizarPedido">
                        <p>preço frete:5,00</p>
                        <p>preço total:${total}</p>
                        <form action="checkoutFinal" method="get" name="finalparte">
                        <button class="compra" type="submit" name="compra">Finalizar Compra</button>
                        <input type="hidden" name="idProduto" value="${produto.id_Produto}">
                        <input type="hidden" name="idEndereco" value="${endereco.id_endereco}">
                    </form>

                    </div>
                </form>
            </div>
        </main>

        <footer>
            <h3>CYBER TREND</h3>
            <p>Daniel trizotto@2024</p>
        </footer>
        <script>
          
        </script>
    </body>

</html>