/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.bean.Carrinho;
import model.bean.Categorias;
import model.bean.Produtos;
import model.bean.Usuarios;
import model.dao.CarrinhoDAO;
import model.dao.CategoriasDAO;
import model.dao.ProdutosDAO;

/**
 *
 * @author User
 */
@MultipartConfig
public class produtosController extends HttpServlet {

    Carrinho bean = new Carrinho();// model bean
    CarrinhoDAO dao = new CarrinhoDAO();//model dao

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProdutosDAO produtosDAO = new ProdutosDAO();
        List<Produtos> produtos = new ArrayList();
        CategoriasDAO categoriasDAO = new CategoriasDAO();
        List<Categorias> categorias = categoriasDAO.listarCategorias();

        request.setAttribute("categorias", categorias);
        String u = request.getServletPath();
        System.out.println(u);
        if (u.equals("/cadastrar-produto")) {
            String nextPage = "/WEB-INF/jsp/telaADM.jsp";//direcionar para a pagina telaADM
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if (u.equals("/home")) {
            produtos = produtosDAO.leitura();
            for (int i = 0; i < produtos.size(); i++) {//trata a imagem
                if (produtos.get(i).getImgBlob() != null) {
                    String imgBase64 = Base64.getEncoder().encodeToString(produtos.get(i).getImgBlob());
                    produtos.get(i).setImg(imgBase64);
                }
            }
            request.setAttribute("produtos", produtos);
            String nextPage = "/WEB-INF/jsp/telaHome.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if (u.equals("/buscar-produtos")) {
            String pesquisa = request.getParameter("busca") != null ? request.getParameter("busca") : "";

            if (pesquisa.equals("")) { // pesquisa
                String cat = request.getParameter("cat");
                if (cat != null && !cat.equals("")) {
                    produtos = produtosDAO.pesquisaCategorias(Integer.parseInt(cat));// pesquisa por categoria
                    for (int i = 0; i < produtos.size(); i++) { // trata a imagem
                        if (produtos.get(i).getImgBlob() != null) {
                            String imagemBase64 = Base64.getEncoder().encodeToString(produtos.get(i).getImgBlob());
                            produtos.get(i).setImg(imagemBase64);
                        }
                    }
                    request.setAttribute("produtos", produtos);
                    String nextPage = "/WEB-INF/jsp/busca.jsp";
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
                    dispatcher.forward(request, response);
                } else {///caso tenha nado no input
                    String nextPage = "/WEB-INF/jsp/busca.jsp";
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
                    dispatcher.forward(request, response);
                }
            } else { // pesquisa por texto
                pesquisa = "%" + pesquisa + "%";
                produtos = produtosDAO.pesquisaProdutos(pesquisa);
                for (int i = 0; i < produtos.size(); i++) { // Trata as imagens
                    if (produtos.get(i).getImgBlob() != null) {
                        String imgBase64 = Base64.getEncoder().encodeToString(produtos.get(i).getImgBlob());
                        produtos.get(i).setImg(imgBase64);
                    }
                }
                request.setAttribute("produtos", produtos);
                String nextPage = "/WEB-INF/jsp/busca.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
                dispatcher.forward(request, response);
            }

        } else if (u.equals("/ver-produto")) {
            int p = Integer.parseInt(request.getParameter("id"));
            Produtos pr = new Produtos();
            System.out.println(u);
            pr = produtosDAO.mostrarProdutos(p);//mostra o o produto do id
            if (pr.getImgBlob() != null) {//trata a imagem
                String imagemBase64 = Base64.getEncoder().encodeToString(pr.getImgBlob());
                pr.setImg(imagemBase64);
            }
            request.setAttribute("produto", pr);
            String nextPage = "/WEB-INF/jsp/telaProduto.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if (u.equals("/enviar-carr")) {
            HttpSession session = request.getSession();

            // recuperar o id do usuário da sessão
            Integer usuarioId = (Integer) session.getAttribute("usuarioId");//adiciona o usuario
            // recuperar parâmetros do produto e quantidade
            int produtoId = Integer.parseInt(request.getParameter("id"));///adiciona o id
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));//adiciona quantidade
            float preco_uni = Float.parseFloat(request.getParameter("preco_uni"));//adicioan o preço unitario
                    Carrinho bean = new Carrinho();
            bean.setFkProduto(produtoId);
            bean.setFkUsuario(usuarioId);
            bean.setQuantidade(quantidade);
            bean.setPreço(preco_uni);

            dao.inserir(bean);
            // atualiza a lista de carrinho na sessao
            List<Carrinho> carrinho = (List<Carrinho>) session.getAttribute("carrinho");
            if (carrinho == null) {
                carrinho = new ArrayList<>();
            }
            carrinho.add(bean);
            session.setAttribute("carrinho", carrinho);

            System.out.println(request.getParameter("id"));
            System.out.println(u);
            // redirecionar para a página do carrinho
            response.sendRedirect("./carrinho");
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //insert em produto
        String u = request.getServletPath();
        Produtos p = new Produtos();
        p.setNome(request.getParameter("nome"));
        p.setFk_categoria(Integer.parseInt(request.getParameter("categoria")));
        p.setPreço(Float.parseFloat(request.getParameter("valor")));
        p.setDescriçao(request.getParameter("descricao"));
        //tratar a imagem
        Part file = request.getPart("imagem");
        InputStream istream = file.getInputStream();
        ByteArrayOutputStream a = new ByteArrayOutputStream();
        byte[] img = new byte[4096];
        int bytesLidos = -1;
        while ((bytesLidos = istream.read(img)) != -1) {
            a.write(img, 0, bytesLidos);
        }
        byte[] imgBytes = a.toByteArray();
        p.setImgBlob(imgBytes);
        p.setEstoque(Integer.parseInt(request.getParameter("estoque")));
        ProdutosDAO produtosD = new ProdutosDAO();
        produtosD.insertProduto(p);
        response.sendRedirect("./telaADM");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
