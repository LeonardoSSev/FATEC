<%-- 
    Document   : create
    Created on : 28/05/2017, 01:18:49
    Author     : jeffersoncn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../../WEB-INF/jspfs/links.jspf" %>
        <title>Quiz - Inserir Usuário</title>
    </head>
    <body>
        <%@include file="../../WEB-INF/jspfs/protecaoAdmin.jspf" %>
        <div id="wrapper">
            <%@include file="../../WEB-INF/jspfs/menuConjunto.jspf" %>
            <div id="page-wrapper" >
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="container">
                                <div class="col-md-6 col-md-offset-3">
                                    <h2 class="text-center">Inserir novo usuário</h2>
                                    <form action="store.jsp" method="post">
                                        <div class="form-group text-center">
                                            <label for="radio1" class="radio-inline">Admin</label>
                                            <input type="radio" name="perfil" id="radio1" value="1" required="">
                                            <label for="radio2" class="radio-inline">Jogador</label>
                                            <input type="radio" name="perfil" id="radio2" value="2" required="">
                                        </div>
                                        <div class="form-group">
                                            <label for="txtNome">Nome Completo:</label>
                                            <input type="text" name="txtNome" id="txtNome" class="form-control" required/>
                                        </div>
                                        <div class="form-group">
                                            <label for="txtUsername">Username:</label>
                                            <input type="text" name="txtUsername" id="txtUsername" class="form-control" required/>
                                        </div>
                                        <div class="form-group">
                                            <label for="txtSenha">Senha:</label>
                                            <input type="password" name="txtSenha" id="txtSenha" class="form-control" required/>
                                        </div>
                                        <div class="form-group">
                                            <label for="txtConfirmaSenha">Confirmação de Senha:</label>
                                            <input type="password" name="txtConfirmaSenha" id="txtConfirmaSenha" class="form-control" required/>
                                        </div>
                                        <input class="btn btn-primary" type="submit" value="Cadastrar" />
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../../WEB-INF/jspfs/footer.jspf" %>
        <%@include file="../../WEB-INF/jspfs/modals.jspf" %>
        <%@include file="../../WEB-INF/jspfs/scripts.jspf" %>
    </body>
</html>
<%--Identado--%>