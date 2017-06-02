<%-- 
    Document   : index
    Created on : 29/05/2017, 21:46:32
    Author     : Cesar
--%>

<%-- 
    Document   : index.jsp
    Created on : 28/05/2017, 01:18:36
    Author     : jeffersoncn
--%>

<%@page import="com.fatecpg.data.Alternativa"%>
<%@page import="com.fatecpg.data.Questao"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../WEB-INF/jspfs/links.jspf" %>
        <title></title>
    </head>
    <body>
        <%
            ArrayList<Usuario> jogadores = Usuario.all(2);
            ArrayList<Usuario> administradores = Usuario.all(1);
            ArrayList<Questao> questoes = Questao.all();
        %>
        <%@include file="../WEB-INF/jspfs/protecaoAdmin.jspf" %>
        <div id="wrapper">
            <%@include file="../WEB-INF/jspfs/menuConjunto.jspf"%>
            <div id="page-wrapper">
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <h2 class="text-center">Painel do Administrador</h2>   
                            <h5 class="text-center">Bem vindo, Admnistrador. </h5>
                            <h4>Usuários</h4>
                            <p>Há <%= jogadores.size() %> jogador(es) cadastrado(s) no site.</p>
                            <p>Há <%= administradores.size() %> administrador(es) cadastrado(s) no site.</p>
                            <p>Há <%= jogadores.size() + administradores.size() %> usuários cadastrados no site.</p>
                            <h4>Questões</h4>
                            <p>Há <%= questoes.size()%> questão(ões) cadastrada(s) no quiz. </p>
                        </div>
                    </div>              
                </div>
            </div>     
        </div>
    </div>
</div>
<%@include file="../WEB-INF/jspfs/modals.jspf" %>
<%@include file="../WEB-INF/jspfs/footer.jspf" %>
<%@include file="../WEB-INF/jspfs/scripts.jspf" %>
</body>
</html>