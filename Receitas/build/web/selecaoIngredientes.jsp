<%-- 
    Document   : selecaoIngredientes
    Created on : 13/09/2016, 20:15:55
    Author     : rafael.soares
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Quais ingredientes voce tem?</h1>
        <form action="ListarReceitas">
            <c:forEach items="${requestScope.ingredientesSelecionaveis}" var="ingr">
                <br/><input type="checkbox" name="ingred" value="${ingr.nome}"> ${ingr.nome}
            </c:forEach>
            <input type="submit">    
        </form>
        
    </body>
</html>
