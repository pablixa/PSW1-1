<%-- 
    Document   : ImparPar
    Created on : 30/08/2016, 20:13:02
    Author     : Rafael.Soares
--%>

<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Par ou Impar advanced plus plus!</h1>
        <%
            String op = request.getParameter("opcao");
            int numero = Integer.parseInt(request.getParameter("numero"));
            
            int numServidor = new Random().nextInt(10);
            
            int soma = numero + numServidor;
            
            String resultado = "p";
            
            if((soma % 2) == 1){
                resultado = "i";
            }
            
            if(op.equals(resultado)){
                %>
                <h1>Voce Ganhou!</h1>
            <%
            }
            else {
%>
                <h1>Voce Perdeu!</h1>    
                <%
            }
            
            out.println("Eu joguei (" + numServidor 
                    +") e voce jogou (" + numero + ")");
            
            %>
    </body>
</html>
