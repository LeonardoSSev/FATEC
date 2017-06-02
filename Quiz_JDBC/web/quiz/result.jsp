<%-- 
    Document   : result
    Created on : 31/05/2017, 02:19:10
    Author     : jeffersoncn
--%>
<%@page import="com.fatecpg.data.Partida"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../WEB-INF/jspfs/links.jspf" %>
        <title>Resultado</title>
    </head>
    <body>
        <%@include file="../WEB-INF/jspfs/protecaoUsuario.jspf" %>
        <div id="wrapper">
            <%@include file="../WEB-INF/jspfs/menuConjunto.jspf" %>
            <div id="page-wrapper">
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12 text-center">
                            <h1>Resultado</h1>
                            <%
                                String mensagem = (String) request.getSession().getAttribute("mensagem");
                                if (mensagem != null) {
                            %>
                            Mensagem: <%= mensagem%>
                            <%
                                }

                                request.getSession().removeAttribute("mensagem");
                            %>
                            <%
                                Partida partida = (Partida) request.getSession().getAttribute("partida");

                                if (partida != null) {
                            %>
                            <p>Questões respondidas: <%= partida.getNumeroRespondidas()%></p>
                            <p>Pontuação: <%= partida.getPontuacao()%></p>
                            <%
                                }
                            %>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../../WEB-INF/jspfs/modals.jspf" %>
        <%@include file="../../WEB-INF/jspfs/footer.jspf" %>
        <%@include file="../../WEB-INF/jspfs/scripts.jspf" %>
    </body>
</html>
