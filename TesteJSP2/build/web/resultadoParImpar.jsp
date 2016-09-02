<%-- 
    Document   : resultadoParImpar
    Created on : 01/09/2016, 21:45:33
    Author     : Rafael.Soares
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Parabens Voce <%=request.getAttribute("rsp")%>!</h1>
        
            <h2>
                Voce jogou: <%out.println(request.getAttribute("numUsu"));%>
            </h2>
             <h2>
                Eu joguei: <%out.println(request.getAttribute("numCpu"));%>
            </h2>
        
        
        
    </body>
</html>
