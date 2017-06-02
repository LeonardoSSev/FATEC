<%-- 
    Document   : perfil
    Created on : 30/05/2017, 18:06:14
    Author     : Leonardo
--%>
<%@page import="com.fatecpg.data.Usuario"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Index Quiz</title>
        <%@include file="WEB-INF/jspfs/links.jspf" %>
    </head>
    <body>
        <%
            HttpSession userSession = request.getSession();
            Usuario usuario = (Usuario) userSession.getAttribute("usuarioLogado");
            if (!ServerHelpers.isLogged(usuario)) {
                userSession.setAttribute("erro", "Acesso negado.");
                response.sendRedirect("index.jsp");
            } else {

        %>
        <div id="wrapper">
            <%@include file="WEB-INF/jspfs/menuConjunto.jspf" %>
            <div id="page-wrapper" >
                <div id="page-inner">
                    <div class="row">
                        
                    </div>              
                </div>
            </div>
        </div>
        <%@include file="WEB-INF/jspfs/footer.jspf" %>
    </div>
    <%@include file="WEB-INF/jspfs/modals.jspf" %>
    <%@include file="WEB-INF/jspfs/scripts.jspf" %>
    <%}%>
</body>
</html>