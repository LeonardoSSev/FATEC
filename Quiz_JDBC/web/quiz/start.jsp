<%-- 
    Document   : start
    Created on : 30/05/2017, 00:48:59
    Author     : jeffersoncn
--%>
<%@page import="com.fatecpg.data.Alternativa"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.fatecpg.data.Questao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../WEB-INF/jspfs/links.jspf" %>
        <title>Quiz - Iniciar</title>
    </head>
    <body>
        <%@include file="../WEB-INF/jspfs/protecaoUsuario.jspf" %>
        <div id="wrapper">
            <%@include file="../../WEB-INF/jspfs/menuConjunto.jspf" %>
            <div id="page-wrapper">
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <h1>Quiz</h1>
                            <form action="process.jsp" method="POST" >
                                <%
                                    String mensagem = null;

                                    ArrayList<Questao> questoes = null;

                                    try {
                                        questoes = Questao.getRandom();
                                    } catch (Exception e) {
                                        mensagem = "Não foi possível carregar as questões do Quiz.";
                                    }

                                    if (questoes != null) {
                                        int i = 0;
                                        for (Questao questao : questoes) {
                                            if (i == 10) {
                                                break;
                                            }
                                %>
                                <p>
                                    <%= i + 1%>. <%= questao.getTexto()%>
                                    <br>
                                    <%
                                        ArrayList<Alternativa> alternativas = null;
                                        try {
                                            alternativas = questao.getAlternativas();
                                        } catch (Exception e) {
                                            mensagem = "Não foi possível carregar as alternativas da Questão.";
                                        }

                                        if (alternativas != null) {
                                            for (Alternativa alternativa : alternativas) {
                                    %>
                                    <input type="radio" name="questao[<%=i%>]" id="questao<%=i%>" value="<%= alternativa.getId()%>" />
                                    <%= alternativa.getTexto()%><br>   
                                    <%
                                            }
                                        }
                                    %>
                                </p>
                                <%
                                            i++;
                                        }
                                    }
                                %>

                                <input class="btn btn-primary" type="submit" value="Ver resultado" />
                            </form>
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
