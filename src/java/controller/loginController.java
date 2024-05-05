/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Usuarios;
import model.dao.UsuariosDAO;

/**
 *
 * @author Senai
 */
public class loginController extends HttpServlet {

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
                String url = request.getServletPath();
                if (url.equals("/logar")) {
                    System.out.println("passou do url");
                    String homePage = "/WEB-INF/jsp/telaHome.jsp";
                    String admPage = "/WEB-INF/jsp/telaADM.jsp";
                    String nextPage = "/WEB-INF/jsp/index.jsp";
                    Usuarios user = new Usuarios();
                    UsuariosDAO valida = new UsuariosDAO();
        
                    user.setUsuario(request.getParameter("usuario"));
                    user.setSenha(request.getParameter("senha"));
        
                    try {
                         Usuarios userAutenticado = valida.validaUser(user);
                        System.out.println("passou do try");
                        System.out.println("user:" + userAutenticado.getUsuario());
                        System.out.println("senha:" + userAutenticado.getSenha());
                        System.out.println("tipo " + userAutenticado.getTipo());
                        if (userAutenticado != null && !userAutenticado.getNome().isEmpty() && userAutenticado.getTipo().equals("admin")) {
                            System.out.println(" passou do if admin");
                            System.out.println(admPage);
                            response.sendRedirect("./cadastrar-produto");
                        } else if(userAutenticado != null && !userAutenticado.getNome().isEmpty() && userAutenticado.getTipo().equals("cliente")){
                             System.out.println(" passou do if cliente");
                            System.out.println(homePage);
                            response.sendRedirect("./home");
                        }
                        else {
                            request.setAttribute("errorMessage", "Usuário ou senha inválidos");
                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
                            dispatcher.forward(request, response);
                            System.out.println("erro login");
                        }
                    } catch (Exception e) {
                        System.out.println("nao passou do if");
                        request.setAttribute("errorMessage", "poblema com o banco de dados");
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
                        dispatcher.forward(request, response);
                    }
                } else {
                    processRequest(request, response);
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
