<%-- 
    Document   : update
    Created on : 28/05/2017, 01:19:20
    Author     : jeffersoncn
--%>

<%@page import="br.com.fatecpg.helpers.ServerHelpers"%>
<%@page import="com.fatecpg.data.Usuario"%>
<%@page import="com.fatecpg.data.Questao"%>
<%@page import="com.fatecpg.data.Alternativa"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("utf-8");
    HttpSession userSession = request.getSession();
    Usuario adminLogado = (Usuario) userSession.getAttribute("usuarioLogado");
    if (!ServerHelpers.isAdminLogged(adminLogado)) {
        userSession.setAttribute("erro", "Acesso negado.");
        response.sendRedirect(ServerHelpers.getRootPath(request) + "/index.jsp");
    } else {

        String mensagem = null;

        try {
            Integer id = Integer.parseInt(request.getParameter("id"));

            try {
                Questao questao = Questao.find(id);

                String texto = request.getParameter("txtQuestao");

                if (texto != null) {
                    questao.setTexto(texto);

                    try {
                        questao.update();
                    } catch (Exception e) {
                        mensagem = "Erro: Não foi possível atualizar a questão.";
                    }
                }

                String txtAlternativa = null;
                Integer idCorreta = Integer.parseInt(request.getParameter("correta"));
                ArrayList<Alternativa> alternativas = questao.getAlternativas();
                int i = 0;

                for (Alternativa alternativa : alternativas) {
                    i = alternativas.indexOf(alternativa);
                    txtAlternativa = request.getParameter(String.format("alternativa[%d]", i));

                    if (txtAlternativa != null) {
                        alternativa.setTexto(txtAlternativa);
                    }

                    if (idCorreta != null) {
                        alternativa.setCorreta(idCorreta == i);
                    }

                    try {
                        alternativa.update();
                    } catch (Exception e) {
                        mensagem = "Erro: Não foi possível atualizar a alternativa.";
                    }
                }
            } catch (Exception e) {
                mensagem = "Erro: Não foi possível consultar a Questão.";
            }
        } catch (Exception e) {
            mensagem = "Erro: ID da Questão é inválido.";
        }

        if (mensagem != null) {
            userSession.setAttribute("mensagem", mensagem);
        } else {
            userSession.setAttribute("mensagem", "Questão alterada com sucesso!");
        }

        response.sendRedirect("index.jsp");
    }
%>