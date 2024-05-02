<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

  <html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Loja Home</title>
    <script src="https://kit.fontawesome.com/0444e3e789.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./styles/telaHome.css" />
  </head>

  <body>
      <header>
        <div id="cabeçalho">
          <div id="pesquisa">
            <div id="pesquisa1">
              <img src="" alt="" />
              <h1>Cyber Street</h1>
            </div>

            <div id="pesquisa2">
              <input type="text" placeholder="Pesquise um produto..." />
              <div id="confirm">
                <button><i class="fa-solid fa-book-bookmark"></i></button>
              </div>
            </div>
            <div class="login">
              <a href=""><i class="fa-solid fa-door-open">Conta</i></a>
            </div>
          </div>
          <nav class="categorias">
            <ul>
              <li><a href="">1.jaquetas</a></li>
              <li><a href="#">2.calças</a></li>
              <li><a href="#">3.brusas</a></li>
              <li> <a href="#">4.capacetes</a></li>
              <li><a href="#">5.tenis</a></li>
              <li><a href="#">6.acessorios</a></li>
            </ul>
          </nav>

          <nav class="categorias-mobile">
            <ul>
              <li><a href="">1.jaquetas</a></li>
              <li><a href="#">2.calças</a></li>
              <li><a href="#">3.brusas</a></li>
              <li> <a href="#">4.capacetes</a></li>
              <li><a href="#">5.tenis</a></li>
              <li><a href="#">6.acessorios</a></li>
            </ul>
          </nav>
        </div>
      </header>
      <main>
        <h1>Produtos</h1>
        <hr>
        <div class="produtos">
          <%-- Use JSP para iterar sobre a lista de livros e exibi-los na tabela --%>
            <c:forEach items="${produtos}" var="prod">
              <section class="produtos">
                <div class="item">
                  <img src="data:image/jpg;base64,${prod.imgBlob}" alt="Imagem do Produto">
                  <h5 class="titulo">Nome:${prod.nome}</h5>
                  <span class="preço">R$:${prod.valor}</span>
                  <span>categorias:${prod.categoriaId}</span>
                  <button class="comprar">COMPRAR</button>
                </div>
              </section>
            </c:forEach>
        </div>
      </main>
  </body>

  </html>