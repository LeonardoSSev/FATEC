<%-- 
    Document   : tabela-price
    Created on : 14/04/2017, 00:13:44
    Author     : Leonardo
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" type="image/x-icon" href="images/money-icon.png"/>
        <link href="css/semantic-ui/semantic.css" rel="stylesheet" type="text/css">
        <link href="css/estilo.css" rel="stylesheet" type="text/css">
        <title>Amortização Americana</title>
    </head>
    <body>

        <%@include file="WEB-INF/jspf/cabecalho.jspf" %>
        <%@include file="WEB-INF/jspf/menu.jspf" %>



        <% int p = 4;
            float v = 0, j = 0, vTotal = 0, jTotal = 0;

            try {
                p = Integer.parseInt(request.getParameter("periodo"));
                v = Float.parseFloat(request.getParameter("principal"));
                j = Float.parseFloat(request.getParameter("juros"));
            } catch (Exception e) {
            }

            DecimalFormat cv = new DecimalFormat("#0.00");
            DecimalFormat cj = new DecimalFormat("#0.00");
        %>

        <%@include file="WEB-INF/jspf/entradaDados.jspf" %>
        <div class="content">
            <table class="ui celled table">
                <tr>
                    <td>Período</td>
                    <td>Saldo Devedor</td>
                    <td>Amortização</td>
                    <td>Juros</td>
                </tr>
                <%for (int i = 0; i <= p; i++) {%>
                <tr>
                    <td><%=i%></td>
                    <%if (i == p) {
                            out.println("<td>" + cv.format(0) + "</td>");
                        } else {
                            out.println("<td>" + cv.format(v) + "</td>");
                        }%>

                    <%if (i == p) {
                            out.println("<td>" + cv.format(v) + "</td>");
                        } else {
                            out.println("<td>" + cv.format(0) + "</td>");
                        }%>

                    <%if (i != 0) {
                            out.println("<td>" + cj.format(v * j * 0.01) + "</td>");
                        } else {
                            out.println("<td>" + cj.format(0) + "</td>");
                        }%>
                </tr>
                
                <%}%>
                <tr>
                    <td>Total</td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </table>
        </div>
        <%@include file="WEB-INF/jspf/rodape.jspf" %>
    </body>

</html>
