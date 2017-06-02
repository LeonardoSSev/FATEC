<%-- 
    Document   : index.jsp
    Created on : 28/05/2017, 01:18:36
    Author     : jeffersoncn
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.fatecpg.data.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../../WEB-INF/jspfs/links.jspf" %>
        <title>Gerenciar Usuários</title>
    </head>
    <body>
        <%@include file="../../WEB-INF/jspfs/protecaoAdmin.jspf" %>
        <div id="wrapper">
            <%@include file="../../WEB-INF/jspfs/menuConjunto.jspf" %>
            <div id="page-wrapper" >
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <%request.setCharacterEncoding("utf-8");

                                String mensagem = null;
                                ArrayList<Usuario> usuarios = null;

                                try {
                                    usuarios = Usuario.all();
                                } catch (Exception e) {
                                    mensagem = "Erro ao carregar usuários";
                                }

                                if (usuarios != null) {
                            %>
                            <h1 class="text-center">Usuários Cadastrados</h1>
                            <%
                                mensagem = (String) userSession.getAttribute("mensagem");

                                if (mensagem != null) {
                            %>
                            <p><%= mensagem%></p>
                            <%
                                }
                            %>

                            <table class="table table-bordered table-responsive table-striped">
                                <tr>
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th>Username</th>
                                    <th>Perfil</th>
                                    <th>Ação</th>
                                </tr>
                                <%
                                    for (Usuario usuario : usuarios) {
                                %>
                                <tr>
                                    <td><%= usuario.getId()%></td>
                                    <td><%= usuario.getNome()%></td>
                                    <td><%= usuario.getUsername()%></td>
                                    <td><%= usuario.getPerfil().getDescricao()%></td>
                                    <td>
                                        <a href="<%=ServerHelpers.getRootPath(request)%>/admin/usuarios/edit.jsp?id=<%= usuario.getId() %>"><i class="fa fa-edit"></i></a> <a href="<%=ServerHelpers.getRootPath(request)%>/admin/usuarios/delete.jsp?id=<%= usuario.getId() %>"><i class="fa fa-trash"></i></a>
                                    </td>
                                </tr>
                                <%
                                    }
                                %>
                            </table>
                            <%
                                }
                            %>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../../WEB-INF/jspfs/footer.jspf" %>
        <%@include file="../../WEB-INF/jspfs/modals.jspf" %>
        <%@include file="../../WEB-INF/jspfs/scripts.jspf" %>
    </body>
</html>
<%--Identado--%>