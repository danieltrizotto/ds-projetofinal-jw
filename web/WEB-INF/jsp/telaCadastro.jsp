<%-- Document : cadastro Created on : 30/04/2024, 15:04:42 Author : Senai --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>

            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>cadastro</title>
            <link rel="stylesheet" href="./styles/cadastro.css">
        </head>

        <body>
            <main>
                <div class="areaCadastro">
                    <form name="formCadastro" method="post" action="cadastro">
                        
                            <img src="./assets/chalkboard-user-solid.svg" alt="" style="width: 90px;">
                            <h2>Cadastro</h2>
                            <input type="text" placeholder="nome..." class="nomeInput" name="nome">
                            <br><br>
                            <input type="text" placeholder="usuario..." class="usuarioInput" name="usuario">
                            <br><br>
                            <input type="text" placeholder="Senha..." class="senhaInput" name="senha">
                            <br><br>
                            <input type="text" placeholder="telefone..." class="telInput" name="telefone">
                            <br><br>
                            <input type="text" class="cpfInput" name="cpf" placeholder="cpf...">
                            <br><br>
                        
                        <button type="submit" name="entrar" value="Entrar" id="cadastro">cadastrar</button>
                    
                    </form>

                </div>
            </main>
        </body>

        </html>