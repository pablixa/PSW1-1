/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rafael.Soares
 */
public class Converter extends HttpServlet {

    public String converter(String texto) {
        
        Map<String, String> map = new HashMap<String, String>();
        map.put("z", "p");
        map.put("e", "o");
        map.put("n", "l");
        map.put("i", "a");
        map.put("t", "r");
        map.put("p", "z");
        map.put("o", "e");
        map.put("l", "n");
        map.put("a", "i");
        map.put("r", "t");
        
              
        String letras[] = texto.split("");
        
        
        String textoConvertido = "";
        
        for (String letra : letras) {
            String code = map.get(letra);
            if (code != null)
                textoConvertido = textoConvertido + code;
            else
                textoConvertido = textoConvertido + letra;
        }
        
        return textoConvertido;
    } 
    
    
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
        try (PrintWriter out = response.getWriter()) {
            
            
            String palavra;
            palavra = request.getParameter("palavra");
            
            String textoConvertido;
            textoConvertido = converter(palavra);
            String historico = "";
            Cookie[] cookies = request.getCookies();
            if(cookies != null){
                for (Cookie cooky : cookies) {
                    if(cooky.getName().equals("palavras")){
                        historico = cooky.getValue();
                    }
                }
            }
            
            
            String valorCookie = palavra + ", " + historico;
            
            Cookie c = new Cookie("palavras", valorCookie);
            c.setMaxAge(1000 * 60 * 60);
            response.addCookie(c);
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Converter</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Sua palavra: " + textoConvertido + " </h1>");
            out.println("<h2>Historico: " + historico + "</h2>");
            out.println("</body>");
            out.println("</html>");
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
