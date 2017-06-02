<%-- 
    Document   : store
    Created on : 28/05/2017, 01:19:00
    Author     : jeffersoncn
--%>

<%@page import="br.com.fatecpg.helpers.ServerHelpers"%>
<%@page import="com.fatecpg.data.Usuario"%>
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

        String nome = request.getParameter("txtNome");
        String username = request.getParameter("txtUsername");
        String senha = request.getParameter("txtSenha");
        String confirmaSenha = request.getParameter("txtConfirmaSenha");

        Integer perfilId = null;

        try {
            perfilId = Integer.parseInt(request.getParameter("perfil"));
        } catch (Exception e) {
            mensagem = "Código do perfil é inválido.";
        }

        if (nome == null) {
            mensagem = "Informe o nome do usuário.";
        } else if (username == null) {
            mensagem = "Informe o username.";
        } else if (Usuario.hasUsername(username)) {
            mensagem = "Nome de usuário já utilizado. Tente outro.";
        } else if (senha == null) {
            mensagem = "Informe a senha.";
        } else if (confirmaSenha == null) {
            mensagem = "Informe a confirmação de senha.";
        } else if (!senha.equals(confirmaSenha)) {
            mensagem = "Confirmação de senha não confere.";
        } else if (perfilId == null) {
            mensagem = "Informe o perfil do usuário.";
        } else {
            Usuario newUsuario = new Usuario(username, nome, senha, perfilId);

            try {
                newUsuario.store();
            } catch (Exception e) {
                mensagem = "Não foi possível gravar o usuário.";
            }
        }

        userSession.setAttribute("mensagem", mensagem != null ? mensagem : "Usuário cadastrado com sucesso.");
        response.sendRedirect("index.jsp");
    }
%>
<%--Identado--%>