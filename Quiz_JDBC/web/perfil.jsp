<%-- 
    Document   : perfil
    Created on : 30/05/2017, 18:06:14
    Author     : Leonardo
--%>
<%@page import="com.fatecpg.data.Partida"%>
<%@page import="java.util.ArrayList"%>
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
            ArrayList<Partida> partidas = null;
            if (!ServerHelpers.isLogged(usuario)) {
                response.sendRedirect("index.jsp");
            } else {
                try {
                    partidas = usuario.getPartidas();
                } catch (Exception e) {

                }

        %>
        <div id="wrapper">
            <%@include file="WEB-INF/jspfs/menuConjunto.jspf" %>
            <div id="page-wrapper" >
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <h1 class="text-center" style="color:red;"><b><%= usuario.getUsername()%></b></h1>   
                            <h3 class="text-center">Este é o seu perfil. </h3>
                        </div>
                    </div>              
                    <hr>
                    <div class="row"> 
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="panel panel-default">
                                <div class="panel-heading text-center">
                                    <strong>Histórico</strong>
                                </div>
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>Pontuação</th>
                                                    <th>Data/hora</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%
                                                    if (partidas != null) {
                                                        for (Partida partida : partidas) {

                                                %>
                                                <tr>
                                                    <td><%= partida.getPontuacao() %></td>
                                                    <td><%= partida.getDataFormatada() %></td>
                                                </tr>
                                                <%
                                                        }
                                                    }
                                                %>

                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
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