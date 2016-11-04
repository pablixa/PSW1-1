/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.spi.DirStateFactory;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rafael.Soares
 */
public class Listar extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try{
            
            String produto = request.getParameter("produto");
            
            //cookie para gravar o ultimo filtro usado
            Cookie cookie = new Cookie("ultimoFiltro", produto);
            response.addCookie(cookie);
            
            
            
            //Carrega o driver na memória
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            // Conecta ao banco
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app", "app");

            // Cria o tubo por onde enviamos o comando
            java.sql.Statement statement = con.createStatement();            

            //monta o comando
            String comando = "SELECT * FROM VENDAS";
            if(produto != null && !produto.trim().equals("") ){
                comando = comando + " WHERE PRODUTO = '" + produto + "'";
            }
            
            System.out.println(comando);
            
            ResultSet resultado = statement.executeQuery(comando);

            
            List<Venda> vendas  = new ArrayList<>();
            while(resultado.next()){
                Venda v = new Venda();
                v.setPreco(resultado.getInt("preco"));
                v.setProduto(resultado.getString("produto"));
                v.setQuantidade(resultado.getInt("quantidade"));
                
                vendas.add(v);
            }
            
            //*** Finaliza transação e conexão
            statement.close();
            con.close();
            
            request.setAttribute("vendas", vendas);
            
            request.getRequestDispatcher("vendas.jsp").forward(request, response);
            
        }
        catch(Exception e){
            e.printStackTrace();
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
