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
                        <form action="checkoutFrete" method="POST" class="frete">
                            <input type="text" placeholder="Rua" name="rua" required>
                            <br>
                            <input type="text" placeholder="Numero" name="numero" required>
                            <br>
                            <input type="text" placeholder="CEP" name="cep" required> 
                            <br>
                            <button type="submit" name="freteBtn" class="freteBtn"
                                style="color: aliceblue; background-color: black;">informar endereço</button>
                        </form>
                    </div>
                    <br>
                  <form action="checkoutPagamento" method="POST" name="formpaga" onsubmit="return validarCampos()"><!--  apenas enviara caso o boolean preenchido estiver true-->
                        <div class="selecionarLocal" style="margin-right: 250px ">

                            <label for="local">Endereço:</label>
                            <select name="enderecoID" id="local">
                                <c:forEach items="${enderecos}" var="endereco">
                                    <option value="${endereco.id_endereco}">${endereco.rua}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <br>
                        <div class="metodoPagamento">
                            <p><b>Método de Pagamento:</b><br>
                                <input type="radio" name="metodo" value="pix" onclick="mostrarDiv()">Pix<br>
                                <input type="radio" name="metodo" value="debito" onclick="mostrarDiv()">Débito<br>
                                <input type="radio" name="metodo" value="credito" onclick="mostrarDiv()">Crédito
                            </p>
                            <div class="infoCartao hidden">

                                <div class="form-group">
                                    <label for="nomeCartao">Nome no Cartao</label>
                                    <input type="text" id="nomeCartao" name="nomeCartao" required>
                                </div>
                                <div class="form-group">
                                    <label for="numeroCartao">Número do Cartao</label>
                                    <input type="text" id="numeroCartao" name="numeroCartao" required>
                                </div>
                                <div class="form-group">
                                    <label for="validade">Validade (MM/AA)</label>
                                    <input type="text" id="validadeCartao" name="validadeCartao" style="width: 50px;"
                                        required>
                                </div>
                                <div class="form-group">
                                    <label for="cvv">CVV</label>
                                    <input type="text" id="cvv" name="cvv" style="width: 30px;" required>
                                </div>
                            </div>
                            <div class="pagarPix hidden">
                                <div class="form-group">
                                    <label for="pixCode">Pix</label>
                                    <input type="text" id="pixCode" name="pixCode" readonly> <!--valor nao aparece editavel-->
                                </div>
                            </div>
                        </div>
                        <br>
                        <div class="finalizarPedido"
                            style="margin-left: 30px;display: flex;align-items: center;flex-direction: column;margin-right: 300px;background-color: white;width: 18vw;">
                            <p>preço frete:5,00</p>
                            <p>preço total:${total + 5}</p>
                            <button class="compra" type="submit" name="compra" onclick="validarCampos()">Finalizar
                                Compra</button>
                        </div>
                    </form>
                </div>
            </main>

            <footer>
                <h3>CYBER TREND</h3>
                <p>Daniel trizotto@2024</p>
            </footer>
            <script>
                function mostrarDiv() {///mostra os div
                    var metodo = document.querySelector('input[name="metodo"]:checked').value;
                    var metodoCartao = document.querySelector('.infoCartao');
                    var metodoPix = document.querySelector('.pagarPix');
                    var codigoPix = document.getElementById('pixCode');
                    if (metodo === 'credito' || metodo === 'debito') {//para cartao    
                        metodoCartao.classList.add('visible');//adiciona o visible comn display block  ficar visivel
                        metodoCartao.classList.remove('hidden');//remove o  hidden display none que deixaq invisivel
                        metodoPix.classList.add('hidden');
                        metodoPix.classList.remove('visible');
                    } else if (metodo === 'pix') {//para pix
                        metodoCartao.classList.add('hidden');//adiciona o visible comn display block  ficar visivel
                        metodoCartao.classList.remove('visible');//remove o  hidden display none que deixaq invisivel
                        metodoPix.classList.add('visible');
                        metodoPix.classList.remove('hidden');
                        codigoPix.value = gerarCodigo(12);//adiciona um valor de 12 numeros para o sorteio de numeros
                        //remover o required
                        document.getElementById('nomeCartao').removeAttribute('required');
                        document.getElementById('numeroCartao').removeAttribute('required');
                        document.getElementById('validadeCartao').removeAttribute('required');
                        document.getElementById('cvv').removeAttribute('required');
                    }


                }

                function validarCampos() {
                    var metodo = document.querySelector('input[name="metodo"]:checked').value;//verifica o valor do do input 
                    var preenchido = true;

                    if (metodo === 'credito' || metodo === 'debito') {
                        var nomeCartao = document.getElementById('nomeCartao').value;
                        var numeroCartao = document.getElementById('numeroCartao').value;
                        var validadeCartao = document.getElementById('validadeCartao').value;
                        var cvv = document.getElementById('cvv').value;

                       //verifica o tamanho do valor da input
                        if (nomeCartao.length < 25) {
                            alert('O nome do titular deve ter no mínimo 25 caracteres.');
                            preenchido = false;
                        } else if (numeroCartao.length < 16) {
                            alert('O número do cartão deve ter no mínimo 16 caracteres');
                            preenchido = false;
                        } else if (validadeCartao.length < 5) {
                            alert('A validade deve ter no mínimo 5 caracteres (MM/AA)');
                            preenchido = false;
                        } else if (cvv.length < 3) {
                            alert('o cvv  deve ter no mínimo 3 caracteres');
                            preenchido = false;
                        }
                        
                    }

                    if (!preenchido) {
                        event.preventDefault()//impede de acontecer o evento o evento de acontecer se preenchido estiver diferente de true

                    }
                    return preenchido;//retorna o valor true
                }



                function gerarCodigo(length) {
                    var chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';//caracteres para o sorteio
                    var code = ''; //valor vazio para adicionar os valores
                    for (var i = 0; i < length; i++) {//le o valor lenght para o sorteio para criar um limite de valores adicionados
                        code += chars.charAt(Math.floor(Math.random() * chars.length));//multiplica um numero aleatorio pela comprimento da String e arredonda para que estaja valido dentra dos intervalos da string, apos isso, pega o valor da posiçao resultando na string e adiciona no codigo
                    }
                    return code;//retorna o valor
                }

            </script>
        </body>

        </html>