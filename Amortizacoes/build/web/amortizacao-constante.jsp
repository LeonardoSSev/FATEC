<%-- 
    Document   : amortizacao-constante
    Created on : 14/04/2017, 00:13:17
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
        <title>Amortização Constante</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/cabecalho.jspf" %>
        <%@include file="WEB-INF/jspf/menu.jspf" %>
        <%

            double valor = 1000;
            double per = 4;
            double txjrs = 3;
            double jPeriodo = 0;
            double amortizacao = 0;
            double prestacao = 0;
            double saldoDevedor = 0;
            double jurosTotal = 0;
            double amortizacaoTotal = 0;
            double prestacaoTotal = 0;

            DecimalFormat df = new DecimalFormat("#0.00");

            try {
                per = Double.parseDouble(request.getParameter("periodo"));
                txjrs = Double.parseDouble(request.getParameter("juros"));
                valor = Double.parseDouble(request.getParameter("principal"));
                amortizacao = valor / per;
                saldoDevedor = valor;
            } catch (Exception e) {
            }

        %>
        <%@include file="WEB-INF/jspf/entradaDados.jspf" %>
        <div class="content">
            <table class="ui celled table">
                <tr>
                    <td>Período</td>
                    <td>Juros </td>
                    <td>Parcela</td>
                    <td>Amortização</td>
                    <td>Saldo devedor</td>

                    <%for (int i = 1; i <= per; i++) {%>
                <tr>
                    <%
                        jPeriodo = (per - i + 1) * (txjrs / 100) * (amortizacao);
                        prestacao = amortizacao + jPeriodo;
                        saldoDevedor = saldoDevedor - amortizacao;
                    %>
                    <td> <%=i%></td>
                    <td> <%= df.format(jPeriodo)%> </td>
                    <td> <%= df.format(prestacao)%> </td>
                    <td> <%= df.format(amortizacao)%> </td>
                    <td> <%= df.format(saldoDevedor)%> </td>
                </tr>
                <%
                    jurosTotal += jPeriodo;
                    prestacaoTotal += prestacao;
                    amortizacaoTotal += amortizacao;
                }%>
                <tr>
                    <td>Total</td>
                    <td><%=df.format(jurosTotal)%></td>
                    <td><%=df.format(prestacaoTotal)%></td>
                    <td><%=df.format(amortizacaoTotal)%></td>
                    <td> <%=df.format(saldoDevedor)%> </td>
                </tr>
            </table>
        </div>
        <%@include file="WEB-INF/jspf/rodape.jspf" %>
    </body>
</html>
