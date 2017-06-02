<%-- 
    Document   : logoff
    Created on : 28/05/2017, 17:18:58
    Author     : Leonardo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%
            HttpSession userSession = request.getSession();
            userSession.invalidate();
            response.sendRedirect("../index.jsp");
        %>
    </body>
</html>
<%--Identado--%>
