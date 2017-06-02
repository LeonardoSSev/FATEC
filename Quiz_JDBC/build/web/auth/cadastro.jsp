<%-- 
    Document   : cadastro
    Created on : 28/05/2017, 17:19:08
    Author     : Leonardo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.fatecpg.data.Perfil"%>
<%@page import="com.fatecpg.data.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro</title>
    </head>
    <body>
        <%
            HttpSession userSession = request.getSession();

            String nome = request.getParameter("nomeCadastro");
            String senha = request.getParameter("senhaCadastro");
            String nomeUsuario = request.getParameter("nomeUsuarioCadastro");
            Usuario usuario = new Usuario(nomeUsuario, nome, senha, 2);

            ArrayList<Usuario> usuarios = usuario.all();

            try {
                    if(Usuario.hasUsername(nomeUsuario)){
                        userSession.setAttribute("erro", "Usuário já cadastrado com esse nome.");
                    } else {
                        usuario.store();
                        userSession.setAttribute("usuarioLogado", usuario);
                    }
                        response.sendRedirect("../index.jsp");
        } catch (Exception ex) {%>
        <h3><%=ex.getMessage()%></h3>
        <%throw ex;
            }%>
    </body>
</html>
<%--Identado--%>
