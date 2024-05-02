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
            <div class="enviarimg">
                <form name="frmProduct" action="insert" enctype="multipart/form-data" method="post">
                    <br><br>
                    <h2>IMAGEM</h2>
                    <input type="file" name="imagem" id="imagem">
                    <h2>nome
                        <h2 />
                        <input type="text" name="nome">

                        <h2>categoria
                            <h2 />
                            <input type="text" name="categoria">

                            <h2>descriçao
                                <h2 />
                                <input type="text" name="descri">
                                <h2>valor
                                    <h2 />
                                    <input type="text" name="valor">
                                    <input type="submit" value="Enviar">

                </form>
            </div>
        </body>

        </html>