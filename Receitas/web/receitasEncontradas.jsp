<%-- 
    Document   : receitasEncontradas
    Created on : 15/09/2016, 21:59:11
    Author     : Rafael.Soares
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
        <h1>Sugestoes de receitas com base nos ingredienes selecionados:</h1>
    
        <c:forEach items="${requestScope.recei}" var="receita">
            ${receita.nome} <br/>
        </c:forEach>
        
    </body>
</html>
