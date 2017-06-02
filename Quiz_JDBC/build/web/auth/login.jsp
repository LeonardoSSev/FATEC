<%-- 
    Document   : login
    Created on : 29/05/2017, 04:08:25
    Author     : Leonardo
--%>

<%@page import="com.fatecpg.data.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <%
        HttpSession userSession = request.getSession();
        String nomeUsuario = request.getParameter("usernameLogin");
        String senha = request.getParameter("senhaLogin");
        Usuario usuario = new Usuario(nomeUsuario, senha);

        ArrayList<Usuario> usuarios = Usuario.all();
        try {
            for (Usuario u : usuarios) {
                if (Usuario.jaCadastrado(nomeUsuario, senha)) {
                    usuario = Usuario.findByUsername(nomeUsuario);
                    userSession.setAttribute("usuarioLogado", usuario);
                    if (usuario.isAdmin()) {
                        usuario = Usuario.findByUsername(nomeUsuario);
                        userSession.setAttribute("usuarioLogado", usuario);
                        response.sendRedirect("../admin/index.jsp");
                        break;
                    } else {
                        response.sendRedirect("../index.jsp");
                        break;
                    }
                } else {
                    userSession.setAttribute("erro", "Dados incorretos.");
                    response.sendRedirect("../index.jsp");
                    break;
                }
            }
        } catch (Exception ex) {%>
    <h3>ERRO:<%=ex.getMessage()%></h3>
    <%throw ex;
        }
    %>
</html>
<%--Identado--%>
