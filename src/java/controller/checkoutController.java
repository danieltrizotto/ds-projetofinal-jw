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
    Endereço e = new Endereço();
    EndereçoDAO ed = new EndereçoDAO();
    float valorTotal = 0;

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
        String url = request.getServletPath();
        HttpSession session = request.getSession();
        Integer usuarioId = (Integer) session.getAttribute("usuarioId");
        ///listar categorias
        CategoriasDAO categoriasDAO = new CategoriasDAO();
        List<Categorias> categorias = categoriasDAO.listarCategorias();
        request.setAttribute("categorias", categorias);

        CarrinhoDAO produto = new CarrinhoDAO();//model dao
        List<Carrinho> c = new ArrayList();

        ///listar os endereços
        List<Endereço> e = new ArrayList();
        e = ed.leitura(usuarioId);
        request.setAttribute("enderecos", e);

        // recuperar o id do usuário da sessão
        c = produto.leitura(usuarioId);
        request.setAttribute("carrinho", c);
           valorTotal = 0;
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
        processRequest(request, response);
        //para atualizar pagina
        CarrinhoDAO produto = new CarrinhoDAO(); // model dao
        HttpSession session = request.getSession();
        Integer usuarioId = (Integer) session.getAttribute("usuarioId");
        List<Carrinho> c = produto.leitura(usuarioId);
        request.setAttribute("carrinho", c);
        ///listar os endereços
        List<Endereço> e = new ArrayList();
        e = ed.leitura(usuarioId);
        request.setAttribute("enderecos", e);

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

        String url = request.getServletPath();
        HttpSession session = request.getSession();
        List<Carrinho> carrinho = (List<Carrinho>) session.getAttribute("carrinho");
        Integer usuarioId = (Integer) session.getAttribute("usuarioId");
        if (url.equals("/checkoutFrete")) {
            ///para fazer insert em endereços
            String rua = request.getParameter("rua");
            int numero = Integer.parseInt(request.getParameter("numero"));
            String cep = request.getParameter("cep");

            e.setFk_usuario(usuarioId);
            e.setRua(rua);
            e.setNumero(numero);
            e.setCep(cep);

            ed.inserirEndereço(e);
            System.out.println("feito endereço");
            response.sendRedirect("./checkout");
        } else if (url.equals("/checkoutPagamento")) {
            String metodoPagamento = request.getParameter("metodo");
            String enderecoIDString = request.getParameter("enderecoID");//trasformao id do input em string para conversao em int
            int enderecoID = Integer.parseInt(enderecoIDString );//converte para int

            ped.setModo_pago(metodoPagamento);
            ped.setValor_total(valorTotal + 5);
            ped.setFkUsuario(usuarioId);
            ped.setFkEndereco(enderecoID);
            Carrinho c = new Carrinho();
            int idPedido = dao.inserirPedidos(ped);

                for (int i = 0; i < carrinho.size(); i++) {
                    int quantidade = carrinho.get(i).getQuantidade();
                    int fkProduto = carrinho.get(i).getFkProduto();
                    float preco_uni = carrinho.get(i).getPreço();
                    dao.inserirPEDIDOSPROD(quantidade, fkProduto, idPedido, preco_uni);//insert em pedidos produtos
                    dao.updateEstoque(quantidade, fkProduto);//update em estoque
                }

            dao.deleteCarrinho(usuarioId);   // remover o carrinho do usuário após a finalização do pedido
            session.removeAttribute("carrinho");   // remover o carrinho da sessao apos a finalização do pedido
            valorTotal = 0;///apaga o valor salvo apos pedido
            response.sendRedirect("./cortesia");//redireciona a tela pedidos
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
