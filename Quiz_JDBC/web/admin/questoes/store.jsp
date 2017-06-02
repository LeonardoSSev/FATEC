<%-- 
    Document   : store
    Created on : 28/05/2017, 01:19:00
    Author     : jeffersoncn
--%>

<%@page import="br.com.fatecpg.helpers.ServerHelpers"%>
<%@page import="com.fatecpg.data.Usuario"%>
<%@page import="com.fatecpg.data.Alternativa"%>
<%@page import="com.fatecpg.data.Questao"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("utf-8");
            HttpSession userSession = request.getSession();
            Usuario adminLogado = (Usuario) userSession.getAttribute("usuarioLogado");
            if (!ServerHelpers.isAdminLogged(adminLogado)) {
                userSession.setAttribute("erro", "Acesso negado.");
                response.sendRedirect(ServerHelpers.getRootPath(request) + "/index.jsp");
            } else {
                String mensagem = null;

                String textoQuestao = request.getParameter("txtQuestao");

                if (textoQuestao != null && !textoQuestao.equals("")) {
                    Questao questao = new Questao(textoQuestao);

                    try {
                        questao.store();
                    } catch (Exception ex) {
                        mensagem = "Erro ao gravar a Questão. Tente novamente.";
                    }

                    Integer correta = null;
                    try {
                        correta = Integer.parseInt(request.getParameter("correta"));
                    } catch (Exception e) {
                        mensagem = "É necessário informar qual alternativa é a correta.";
                        questao.delete();
                    }

                    if (questao.getId() != null && correta != null) {
                        ArrayList<Alternativa> alternativas = new ArrayList<>();
                        String txtAlternativa = null;

                        for (int i = 0; i < 4; i++) {
                            txtAlternativa = request.getParameter(String.format("alternativa[%d]", i));

                            if (txtAlternativa != null) {
                                alternativas.add(
                                        new Alternativa(
                                                txtAlternativa,
                                                correta == i,
                                                questao.getId()
                                        )
                                );
                            }
                        }

                        try {
                            for (Alternativa alternativa : alternativas) {
                                alternativa.store();
                            }
                        } catch (Exception e) {
                            mensagem = "Erro ao gravar as Alternativas. Tente novamente.";
                            questao.delete();
                        }
                    }
                } else {
                    mensagem = "Texto da questão não pode estar vazio.";
                }

                userSession.setAttribute("mensagem", mensagem != null ? mensagem : "Questão cadastrada com sucesso");

                response.sendRedirect("index.jsp");
            }
        %>
    </body>
</html>
