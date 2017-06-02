<%-- 
    Document   : show
    Created on : 28/05/2017, 01:19:49
    Author     : jeffersoncn
--%>

<%@page import="br.com.fatecpg.helpers.ServerHelpers"%>
<%@page import="com.fatecpg.data.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../../WEB-INF/jspfs/links.jspf" %>
        <title>Quiz - Usuário</title>
    </head>
    <body>
        <div id="wrapper">
            <%@include file="../../WEB-INF/jspfs/menuConjunto.jspf" %>
            <div id="page-wrapper" >
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <h1>Usuário</h1>
                            <%
                                HttpSession userSession = request.getSession();
                                Usuario adminLogado = (Usuario) userSession.getAttribute("usuarioLogado");
                                if (!ServerHelpers.isAdminLogged(adminLogado)) {
                                    userSession.setAttribute("erro", "Acesso negado.");
                                    response.sendRedirect(ServerHelpers.getRootPath(request) + "/index.jsp");
                                } else {
                                    String mensagem = null;

                                    Integer id = null;
                                    try {
                                        id = Integer.parseInt(request.getParameter("id"));
                                    } catch (Exception e) {
                                        mensagem = "ID informado é inválido.";
                                    }

                                    if (id != null) {
                                        Usuario usuario = Usuario.find(id);

                                        if (usuario != null) {
                            %>
                            <p>
                                Nome: <%= usuario.getNome()%><br>
                                Username: <%= usuario.getUsername()%><br>
                                Perfil: <%= usuario.getPerfil().getDescricao()%>
                            </p>
                            <%
                                        } else {
                                            userSession.setAttribute("mensagem", "Usuário não encontrado.");
                                            response.sendRedirect("index.jsp");
                                        }
                                    }
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