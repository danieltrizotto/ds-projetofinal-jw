/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.Carrinho;
import model.bean.Categorias;
import model.bean.Produtos;
import model.bean.Usuarios;
import model.dao.CarrinhoDAO;
import model.dao.CategoriasDAO;
import model.dao.PedidosDAO;
import model.dao.ProdutosDAO;

/**
 *
 * @author Senai
 */
public class carrinhoController extends HttpServlet {

    Carrinho ca = new Carrinho();
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

        String nextPage = "/WEB-INF/jsp/telaCarrinho.jsp";///redireciona ao carrinho
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
        processRequest(request, response);
        //para atualizar pagina
        CarrinhoDAO produto = new CarrinhoDAO(); // model dao
        HttpSession session = request.getSession();
        Integer usuarioId = (Integer) session.getAttribute("usuarioId");
        List<Carrinho> c = produto.leitura(usuarioId);
        request.setAttribute("carrinho", c);

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

        CarrinhoDAO produto = new CarrinhoDAO();//model dao
        List<Carrinho> c = new ArrayList();
        HttpSession session = request.getSession();
        List<Carrinho> ca = (List<Carrinho>) session.getAttribute("carrinho");
        // recuperar o id do usuário da sessão
        Integer usuarioId = (Integer) session.getAttribute("usuarioId");
        c = produto.leitura(usuarioId);
        request.setAttribute("carrinho", c);
        String url = request.getServletPath();
        List<Carrinho> carrinho = new ArrayList();
        if (url.equals("/apagarProduto")) {
            int carrinhoId = Integer.parseInt(request.getParameter("id"));
            produto.excluirProduto(carrinhoId);//excluir produto especifico
          
      ///para nao dar erro no carrinho apos exclusao
            if (ca != null) {
                Iterator<Carrinho> iterator = carrinho.iterator();//vai percorrer o carrinho
                while (iterator.hasNext()) {///percorre o carrinho
                    Carrinho car = iterator.next();
                    if (car.getIdCarrinho() == carrinhoId) {///verifica o id especifico que foi deletado
                        iterator.remove();//remove 
                        break; //interrompe apos encontrar o item
                    }
                }
                session.setAttribute("carrinho", carrinho);//atualiza  a sessao do carrinho
            }

            System.out.println("Produto de ID apagado: " + carrinhoId);
            response.sendRedirect("./carrinho");
        } else if (url.equals("/excluirCarrin")) {
            dao.deleteCarrinho(usuarioId);//excluir todo o carrinho
            session.removeAttribute("carrinho");
            System.out.println("apagado produto de id:" + usuarioId);
            response.sendRedirect("./carrinho");
        }

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
