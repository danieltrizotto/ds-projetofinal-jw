<%-- Document : telaADM Created on : 30/04/2024, 17:06:04 Author : Senai --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>adm pag</title>
    </head>

    <body>
        <main>
            <div class="container">
                <h2>Cadastro de Produto</h2>
                <form action="cadastrarProduto" method="POST" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="nome">Nome:</label>
                        <input type="text" class="form-control" id="nome" name="nome" required>
                    </div>
                    <div class="form-group">
                        <label for="categoria">Categoria:</label>
                        <input type="number" name="categoria">
                    </div>
                    <div class="form-group">
                        <label for="valor">Valor:</label>
                        <input type="number" step="0.01" class="form-control" id="valor" name="valor" required>
                    </div>
                    <div class="form-group">
                        <label for="descricao">Descrição:</label>
                        <textarea class="form-control" id="descricao" name="descriçao" rows="3"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="imagem">Imagem do Produto:</label>
                        <input type="file" class="form-control-file" id="imagem" name="imagem">
                    </div>
                    <button type="submit" class="btn btn-primary">Cadastrar</button>
                </form>
            </div>
        </main>
        
        <footer>
            <c:forEach items="${categorias}" var="categoria">
                <div class="categoria">
                    <a href="./buscar-produtos?cat=${categoria.idCategoria}&busca=">${categoria.nome}</a>
                </div>
            </c:forEach>
            <p>Daniel trizotto@2024</p>
        </footer>

    </body>

</html>