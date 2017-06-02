<%-- 
    Document   : update
    Created on : 28/05/2017, 01:19:20
    Author     : jeffersoncn
--%>

<%@page import="br.com.fatecpg.helpers.ServerHelpers"%>
<%@page import="com.fatecpg.data.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    request.setCharacterEncoding("utf-8");
    HttpSession userSession = request.getSession();
    Usuario adminLogado = (Usuario) userSession.getAttribute("usuarioLogado");
    if (!ServerHelpers.isAdminLogged(adminLogado)) {
        userSession.setAttribute("erro", "Acesso negado.");
        response.sendRedirect(ServerHelpers.getRootPath(request) + "/index.jsp");
    } else {

        String mensagem = null;
        Integer id = null;

        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {
            mensagem = "ID informado é inválido.";
        }

        if (id != null) {
            String nome = request.getParameter("txtNome");
            String username = request.getParameter("txtUsername");
            Integer perfilId = null;

            try {
                perfilId = Integer.parseInt(request.getParameter("perfil"));
            } catch (Exception e) {
                mensagem = "Perfil informado é inválido.";
            }

            if (nome == null) {
                mensagem = "É necessário informar o nome.";
            } else if (username == null) {
                mensagem = "É necessário informar o username.";
            } else if (perfilId == null) {
                mensagem = "É necessário informar o perfil.";
            } else {
                Usuario usuario = Usuario.find(id);

                usuario.setNome(nome);
                usuario.setUsername(username);
                usuario.setPerfilId(perfilId);

                try {
                    usuario.update();
                } catch (Exception e) {
                    mensagem = "Não foi possível editar os dados do usuário.";
                }
            }
        }

        if (mensagem != null) {
            userSession.setAttribute("mensagem", mensagem);
        } else {
            userSession.setAttribute("mensagem", "Dados do usuário atualizados com sucesso.");
        }

        response.sendRedirect("index.jsp");
    }
%>
<%--Identado--%>