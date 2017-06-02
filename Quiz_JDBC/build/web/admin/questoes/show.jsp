<%-- 
    Document   : show
    Created on : 28/05/2017, 01:19:49
    Author     : jeffersoncn
--%>

<%@page import="br.com.fatecpg.helpers.ServerHelpers"%>
<%@page import="com.fatecpg.data.Usuario"%>
<%@page import="com.fatecpg.data.Alternativa"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.fatecpg.data.Questao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz - Questão</title>
    </head>
    <body>
        <%
            HttpSession userSession = request.getSession();
            Usuario adminLogado = (Usuario) userSession.getAttribute("usuarioLogado");
            if (ServerHelpers.isAdminLogged(adminLogado) == false) {
                userSession.setAttribute("erro", "Acesso negado.");
                response.sendRedirect(ServerHelpers.getRootPath(request) + "/index.jsp");
            } else{
            String mensagem = null;

            Integer id = null;
            try {
                id = Integer.parseInt(request.getParameter("id"));
            } catch (Exception e) {
                mensagem = "ID da questão informada é inválido.";
            }

            if (id != null) {
                Questao questao = Questao.find(id);

                if (questao != null) {
        %>
        <p>
            <%= questao.getTexto()%>
        </p>
        <%
            ArrayList<Alternativa> alternativas = questao.getAlternativas();

            if (alternativas != null) {
        %>
        <ul>
            <%
                for (Alternativa alternativa : alternativas) {
            %>
            <li><%= alternativa.getTexto()%></li>
                <%
                    }
                %>
        </ul>
        <%
                    } else {
                        mensagem = "Não foi possível buscar as alternativas dessa questão.";
                    }
                } else {
                    mensagem = "Não foi possível buscar a questão.";
                }
            } else {
                mensagem = "ID da questão informada é inválido.";
            }

            if (mensagem != null) {
                userSession.setAttribute("mensagem", mensagem);
                response.sendRedirect("index.jsp");
            }
}
        %>
    </body>
</html>
