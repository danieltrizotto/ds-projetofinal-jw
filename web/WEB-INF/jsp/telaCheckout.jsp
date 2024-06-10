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
                      
                    </div>
                </div>

                <div class="inserirEndereço">
                    <form action="checkoutFrete" method="GET" class="frete">
                        <input type="text" placeholder="Rua" name="rua">
                        <br>
                        <input type="text" placeholder="Numero" name="numero">
                        <br>
                        <input type="text" placeholder="CEP" name="cep">
                        <br>
              
                        <button type="submit" name="freteBtn" class="freteBtn">calcular frete</button>
                    </form>
                </div>
                <br>
                <form action="checkoutPagamento" method="get" name="formpaga">
                    <div class="metodoPagamneto">
                        <p><b>Método de Pagamento:</b><br>
                            <input type="radio" name="metodo" value="pix" onclick="mostrarDiv();">Pix<br>
                            <input type="radio" name="metodo" value="debito" onclick="mostrarDiv();">Débito<br>
                            <input type="radio" name="metodo" value="credito" onclick="mostrarDiv();">Crédito
                        </p>
                        <div class="infoCartao">
                            <h2>Informações do Cartão de Crédito</h2>
                            <div class="form-group">
                                <label for="nome-cartao">Nome no Cartão</label>
                                <input type="text" id="nome-cartao" name="nome-cartao" required>
                            </div>
                            <div class="form-group">
                                <label for="numero-cartao">Número do Cartão</label>
                                <input type="text" id="numero-cartao" name="numero-cartao" required>
                            </div>
                            <div class="form-group">
                                <label for="validade-cartao">Data de Validade (MM/AA)</label>
                                <input type="text" id="validade-cartao" name="validade-cartao" required>
                            </div>
                            <div class="form-group">
                                <label for="cvv-cartao">CVV</label>
                                <input type="text" id="cvv-cartao" name="cvv-cartao" required>
                            </div>
                        </div>
                        <div class="pagarPix">
                            <h2>CPF para PIX</h2>
                            <div class="form-group">
                                <label for="cpf">CPF</label>
                                <input type="text" id="cpf" name="cpf" required>
                            </div>
                        </div>
                    </div>
                    <br>
                    <div class="finalizarPedido">
                        <p>preço frete:0</p>
                        <p>preço total:${total}</p>
                        <button class="compra" type="submit" name="compra">Finalizar Compra</button>
                        <input type="hidden" name="idProduto" value="${produto.id_Produto}">
                        <input type="hidden" name="idEndereco" value="${endereco.id_endereco}">


                    </div>
                </form>
            </main>

            <footer>
                <h3>CYBER TREND</h3>
                <p>Daniel trizotto@2024</p>
            </footer>
            <script>
                function mostrarDiv() {
                    var metodo = document.querySelector('input[name="metodo"]:checked').value;
                    var infoCartao = document.getElementsByClassName('.infoCartao');
                    var pagarPix = document.getElementsByClassName('.pagarPix');

                    if (metodo === 'credito' || metodo === 'debito') {
                        infoCartao.style.display = 'block';
                        pagarPix.style.display = 'none';
                    } else if (metodo === 'pix') {
                        infoCartao.style.display = 'none';
                        pagarPix.style.display = 'block';
                    } else {
                        infoCartao.style.display = 'none';
                        pagarPix.style.display = 'none';
                    }
                }
            </script>
        </body>

        </html>