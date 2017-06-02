<%-- 
    Document   : home
    Created on : 01/05/2017, 13:41:52
    Author     : Leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.fatecpg.cadastros.Cliente"%>
<%@page import="com.fatecpg.cadastros.Fornecedor"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" type="image/x-icon" href="images/icone.png"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <title>Home</title>
    </head>
    <body>
        <div class="container content">
            <%@include file="WEB-INF/jspf/menu.jspf" %>
            <div class="jumbotron">
                <h1>Aplicação de Cadastro</h1>
                <p class="lead">Este projeto tem como objetivo realizar o cadastro de clientes e fornecedores.</p>
                <p class="lead">Também deve ser possível listar, editar e excluir clientes e fornecedores já cadastrados.</p>
            </div>
            <div class="row">
                <h1 class="section-title">Equipe</h1>
                <div class="col-md-3">
                    <div class="panel panel-default panel m-b-0">
                        <div class="panel-heading background-higor"></div>
                        <div class="panel-body text-center">
                            <img class="panel-profile-img redondo" src="images/higormoroni.jpg"/>
                            <h4 class="section-title">Higor Moroni</h4>
                            <p class="parag">Desenvolvedor</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="panel panel-default panel m-b-0">
                        <div class="panel-heading background-leonardo"></div>
                        <div class="panel-body text-center">
                            <img class="panel-profile-img" src="images/leonardo.jpg"/>
                            <h4 class="section-title">Leonardo</h4>
                            <p class="parag">Desenvolvedor</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="panel panel-default panel m-b-0">
                        <div class="panel-heading background-thiago1"></div>
                        <div class="panel-body text-center">
                            <img class="panel-profile-img" src="images/thiago1.jpg"/>
                            <h4 class="section-title">Thiago Bonini</h4>
                            <p class="parag">Desenvolvedor</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="panel panel-default panel m-b-0">
                        <div class="panel-heading background-thiago2"></div>
                        <div class="panel-body text-center">
                            <img class="panel-profile-img" src="images/thiago2.jpg"/>
                            <h4 class="section-title">Thiago Felipe</h4>
                            <p class="parag">Desenvolvedor</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@include file="WEB-INF/jspf/rodape.jspf" %>
</body>
</html>
