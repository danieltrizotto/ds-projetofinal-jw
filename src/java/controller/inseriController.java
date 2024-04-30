
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
//victor
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet(urlPatterns = "/insert")
@MultipartConfig
public class inseriController extends HttpServlet {

    Produtos objProduto = new Produtos();
    ProdutosDAO objProdutoDao = new ProdutosDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ///victor
        String action = request.getServletPath();
        
        if (action.equals("/insert")) {
            product(request, response);
        }
        /////
    }

    protected void product(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ///victor
        Part filePart = request.getPart("imagem");
        InputStream inputStream = filePart.getInputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        byte[] imageBytes = outputStream.toByteArray();

        objProduto.setNome(request.getParameter("nome"));
        objProduto.setCategoriaId(Integer.parseInt(request.getParameter("categoria")));
        objProduto.setValor(Float.parseFloat(request.getParameter("valor")));
        objProduto.setImgBlob(imageBytes);
        objProdutoDao.insertProduto(objProduto);
        /////
    }

}
//
