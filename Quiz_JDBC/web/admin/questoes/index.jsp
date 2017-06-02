<%-- 
    Document   : index.jsp
    Created on : 28/05/2017, 01:18:36
    Author     : jeffersoncn
--%>

<%@page import="com.fatecpg.data.Alternativa"%>
<%@page import="com.fatecpg.data.Questao"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../../WEB-INF/jspfs/links.jspf" %>
        <title></title>
    </head>
    <body>
        <%@include file="../../WEB-INF/jspfs/protecaoAdmin.jspf" %>
        <div id="wrapper">
            <%@include file="../../WEB-INF/jspfs/menuConjunto.jspf" %>
            <div id="page-wrapper">
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <%
                                String mensagem = (String) userSession.getAttribute("mensagem");

                                if (mensagem != null) {
                            %>
                            <p><%=mensagem%></p>

                            <%
                                }

                                ArrayList<Questao> questoes = Questao.all();

                                if (questoes != null) {
                            %>
                            <table class="table table-bordered table-responsive table-striped">
                                <t>
                                    <th>ID</th>
                                    <th>Pergunta</th>
                                    <th>Ação</th>
                                </tr>
                                <%
                                    for (Questao questao : questoes) {
                                %>
                                <tr>
                                    <td><%= questao.getId()%></td>
                                    <td><%= questao.getTexto() %></td>
                                    <td>
                                        <a href="<%=ServerHelpers.getRootPath(request)%>/admin/questoes/edit.jsp?id=<%= questao.getId() %>"><i class="fa fa-edit"></i></a> <a href="<%=ServerHelpers.getRootPath(request)%>/admin/questoes/delete.jsp?id=<%= questao.getId() %>"><i class="fa fa-trash"></i></a>
                                    </td>
                                </tr>
                                <%
                                    }
                                    userSession.removeAttribute("mensagem");

                                %>
                            </table>
                            <%    }


                            %>
                        </div>
                    </div>              
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
