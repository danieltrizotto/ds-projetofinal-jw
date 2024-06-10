/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.Carrinho;
import model.bean.Categorias;
import model.bean.Endereço;
import model.bean.Pedidos;
import model.dao.CarrinhoDAO;
import model.dao.CategoriasDAO;
import model.dao.EndereçoDAO;
import model.dao.PedidosDAO;

/**
 *
 * @author User
 */
public class checkoutController extends HttpServlet {

    Pedidos ped = new Pedidos();
    PedidosDAO dao = new PedidosDAO();

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
        ///listar categorias
        CategoriasDAO categoriasDAO = new CategoriasDAO();
        List<Categorias> categorias = categoriasDAO.listarCategorias();
        request.setAttribute("categorias", categorias);

        CarrinhoDAO produto = new CarrinhoDAO();//model dao
        List<Carrinho> c = new ArrayList();

        HttpSession session = request.getSession();
        // recuperar o id do usuário da sessão
        Integer usuarioId = (Integer) session.getAttribute("usuarioId");
        c = produto.leitura(usuarioId);
        request.setAttribute("carrinho", c);
        float valorTotal = 0;
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i).getImgBlob() != null) {//tratamento para imagem
                String imagemBase64 = Base64.getEncoder().encodeToString(c.get(i).getImgBlob());
                c.get(i).setImg(imagemBase64);
                valorTotal = valorTotal + (c.get(i).getQuantidade() * c.get(i).getPreço());
            }
        }

        request.setAttribute("carrinho", c);
        request.setAttribute("total", valorTotal);

        String nextPage = "/WEB-INF/jsp/telaCheckout.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);

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
        processRequest(request, response);
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
