<%-- Document : telaADM Created on : 30/04/2024, 17:06:04 Author : Senai --%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@page contentType="text/html" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html>

            <head>

                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>adm pag</title>
                <link rel="stylesheet" href="./styles/telaADM.css" />
            </head>

            <body>
                <header>
                    <div class="header">
                        <div class="inicio">
                            <h2>PAGINA DE ADMINISTRAÇAO</h2>
                        </div>
                        <br>

                        <div class="admin">
                            <a class="outro" href="">Produtos</a>
                            <a class="outro" href="">Pedidos</a>
                            <a class="outro" href="">Financeiro</a>
                            <a class="outro" href="">Usuarios</a>
                        </div>
                        <br>
                </header>
                <main>
                    <br>
                    <h2>Cadastro de Produto</h2>
                    <br>
                    <br>
                    <div class="container">

                        <form action="cadastrarProduto" method="POST" enctype="multipart/form-data">

                            <div class="form-group">
                                <label for="nome">Nome:</label>
                                <input type="text" class="form-control" id="nome" name="nome" required>
                            </div>
                            <br>
                            <div class="form-group">
                                <label for="categoria">Categoria:</label>
                                <input type="number" name="categoria">
                            </div>
                            <br>
                            <div class="form-group">
                                <label for="valor">Valor:</label>
                                <input type="number" step="0.01" class="form-control" id="valor" name="valor" required>
                            </div>
                            <br>
                            <div class="form-group">
                                <label for="descriçao">Descrição:</label>
                                <textarea class="form-control" name="descricao" rows="3"></textarea>
                            </div>
                            <br>
                            <div class="form-group">
                                <label for="imagem">Imagem do Produto:</label>
                                <input type="file" class="form-control-file" id="imagem" name="imagem">
                            </div>
                            <br>
                            <button type="submit" class="btn btn-primary">Cadastrar</button>
                        </form>
                    </div>
                </main>
                <footer>
                    <h3>CYBER TREND</h3>
                    <p>Daniel trizotto@2024</p>
                </footer>

            </body>

            </html>