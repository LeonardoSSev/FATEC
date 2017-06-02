<%-- 
    Document   : process
    Created on : 31/05/2017, 00:58:02
    Author     : jeffersoncn
--%>

<%@page import="java.sql.Date"%>
<%@page import="com.fatecpg.data.Usuario"%>
<%@page import="com.fatecpg.data.Partida"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String mensagem = null;
    Usuario usuarioLogado = null;

    try {
        usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado");
    } catch (Exception e) {
        mensagem = "Não há nenhuma sessão de usuário aberta.";
    }

    if (usuarioLogado != null) {
        Partida partida = new Partida(0, new Date(System.currentTimeMillis()), usuarioLogado.getId());

        try {
            partida.store();
        } catch (Exception e) {
            mensagem = "Não foi possível salvar a partida no banco de dados: " + String.format("%tY-%tm-%td", partida.getData(), partida.getData(), partida.getData());
        }

        if (partida.getId() != null) {
            Integer idAlternativa = null;

            try {
                for (int i = 0; i < 10; i++) {
                    idAlternativa = Integer.parseInt(request.getParameter(String.format("questao[%d]", i)));

                    if (idAlternativa != null) {
                        partida.registrarAlternativaEscolhida(idAlternativa);
                    }
                }
            } catch (Exception e) {
                mensagem = "Alternativa inválida.";
            }
            
            partida.calculaPontuacao();
            partida.update();
            
            request.getSession().setAttribute("partida", partida);
        }
    } else {
        mensagem = "Não há usuário para iniciar uma partida";
    }

    if (mensagem != null) {
        request.getSession().setAttribute("mensagem", mensagem);
    }
    
    response.sendRedirect("result.jsp");
%>