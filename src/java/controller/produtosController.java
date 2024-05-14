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
import model.bean.CarrinhoItem;
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

    Carrinho objProduto = new Carrinho();
    CarrinhoDAO objProdutoDao = new CarrinhoDAO();

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
        String url = request.getServletPath();
        System.out.println(url);
        if (url.equals("/cadastrar-produto")) {
            
            String nextPage = "/WEB-INF/jsp/telaADM.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if (url.equals("/home")) {
            produtos = produtosDAO.leitura();
            for (int i = 0; i < produtos.size(); i++) {

                if (produtos.get(i).getImgBlob() != null) {
                    String imagemBase64 = Base64.getEncoder().encodeToString(produtos.get(i).getImgBlob());
                    System.out.println("aqui");
                    System.out.println(imagemBase64);
                    produtos.get(i).setImg(imagemBase64);

                }
            }
            request.setAttribute("produtos", produtos);
            String nextPage = "/WEB-INF/jsp/telaHome.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if (url.equals("/buscar-produtos")) {
            String busca = request.getParameter("busca") != null ? request.getParameter("busca") : "";
            if (busca.equals("")) {
                String categoria = request.getParameter("cat");
                produtos = produtosDAO.buscaCategorias(Integer.parseInt(categoria));
                for (int i = 0; i < produtos.size(); i++) {

                    if (produtos.get(i).getImgBlob() != null) {
                        String imagemBase64 = Base64.getEncoder().encodeToString(produtos.get(i).getImgBlob());
                        System.out.println("aqui");
                        System.out.println(imagemBase64);
                        produtos.get(i).setImg(imagemBase64);

                    }
                }

                request.setAttribute("produtos", produtos);
            } else {
                busca = "%" + busca + "%";
                produtos = produtosDAO.buscaProdutos(busca);
                for (int i = 0; i < produtos.size(); i++) {

                    if (produtos.get(i).getImgBlob() != null) {
                        String imagemBase64 = Base64.getEncoder().encodeToString(produtos.get(i).getImgBlob());
                        System.out.println("aqui");
                        System.out.println(imagemBase64);
                        produtos.get(i).setImg(imagemBase64);

                    }
                }
                request.setAttribute("produtos", produtos);
            }
            String nextPage = "/WEB-INF/jsp/busca.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if (url.equals("/ver-produto")) {
            int p = Integer.parseInt(request.getParameter("id"));
            Produtos pr = new Produtos();
            System.out.println(url);
            pr = produtosDAO.mostrarProdutos(p);
            if (pr.getImgBlob() != null) {
                String imagemBase64 = Base64.getEncoder().encodeToString(pr.getImgBlob());
                System.out.println("aqui");
                System.out.println(imagemBase64);
                pr.setImg(imagemBase64);
            }
            request.setAttribute("produto", pr);
            String nextPage = "/WEB-INF/jsp/telaProduto.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
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
        Produtos newProduto = new Produtos();
        newProduto.setNome(request.getParameter("nome"));
        newProduto.setFk_categoria(Integer.parseInt(request.getParameter("categoria")));
        newProduto.setPreço(Float.parseFloat(request.getParameter("valor")));
        newProduto.setDescriçao(request.getParameter("descricao"));

        Part filePart = request.getPart("imagem");
        InputStream istream = filePart.getInputStream();
        ByteArrayOutputStream byteA = new ByteArrayOutputStream();
        byte[] img = new byte[4096];
        int byteRead = -1;
        while ((byteRead = istream.read(img)) != -1) {
            byteA.write(img, 0, byteRead);
        }
        byte[] imgBytes = byteA.toByteArray();
        newProduto.setImgBlob(imgBytes);
        ProdutosDAO produtosD = new ProdutosDAO();
        produtosD.insertProduto(newProduto);
        System.out.println("sdf:" + newProduto.getDescriçao());
        response.sendRedirect("./home");
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
