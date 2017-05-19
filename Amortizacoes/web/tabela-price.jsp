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
        <title>Amortização Price</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/cabecalho.jspf" %>
        <%@include file="WEB-INF/jspf/menu.jspf" %>
        <%double pv = 1000, i = 0.03, n = 4, pmt = 0, saldo = 0, jur = 0, jacum = 0, tamort = 0, amort = 0;
            int x = 0;
            %>
        
            <%@include file="WEB-INF/jspf/entradaDados.jspf" %>

            <% String principal = request.getParameter("principal");
                String juros = request.getParameter("juros");
                String periodo = request.getParameter("periodo");

                try {
                    pv = Double.parseDouble(principal);
                } catch (Exception e) {
                }
                try {
                    i = Double.parseDouble(juros) / 100;
                    n = Double.parseDouble(periodo);
                } catch (Exception e) {
                }

                pmt = pv * (i / (1 - Math.pow((1 + i), -n)));
                saldo = pv;

            %>
<div class="content">
            <table class="ui celled table">
                <tr>
                    <td>Periodo</td>
                    <td>Parcela</td>
                    <td>Juros</td>
                    <td>Amortização</td>
                    <td>Saldo Devedor</td>
                </tr>
                <tr>
                    <td><%=x%></td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td><%=saldo%></td>
                </tr>
                <% for (x = 1; x <= n; x++) {
                        jur = saldo * i;
                        jacum += jur;

                        amort = pmt - jur;
                        tamort += amort;
                        saldo -= amort;%>
                <tr>
                    <td><%=x%></td>
                    <td><%=String.format("%.2f", pmt)%></td>
                    <td><%=String.format("%.2f", jur)%></td>
                    <td><%=String.format("%.2f", amort)%></td>
                    <td><%=String.format("%.2f", saldo)%></td>
                </tr>
                <%}%>
                <tr>
                    <td>Total</td>
                    <td><%=String.format("%.2f", pmt * (x - 1))%></td>
                    <td><%=String.format("%.2f", jacum)%></td>
                    <td><%=String.format("%.2f", tamort)%></td>
                    <td><%=String.format("%.2f", saldo)%></td>
                </tr>
            </table>

        </div>
        <%@include file="WEB-INF/jspf/rodape.jspf" %>
    </body>
</html>
