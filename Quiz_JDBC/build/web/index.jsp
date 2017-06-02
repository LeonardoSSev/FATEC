<%@page import="com.fatecpg.data.Partida"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Index Quiz</title>
        <%@include file="WEB-INF/jspfs/links.jspf" %>
    </head>
    <body>
        <% HttpSession userSession = request.getSession();
            String mensagem = "";
            if ((String) userSession.getAttribute("erro") != null) {
                mensagem = (String) userSession.getAttribute("erro");
            }
        %>
        <div id="wrapper">
            <%@include file="WEB-INF/jspfs/menuConjunto.jspf" %>
            <div id="page-wrapper" >
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <p style="color: #DB0630;"><%= mensagem%></p>
                            <h1 class="text-center"><strong>Quiz</strong></h1>   
                            <h3 class="text-center">Bem vindo ao quiz. </h3>
                        </div>
                    </div>             
                    <div class="divider"></div>
                    <div class="row"> 
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="panel panel-default">
                                <div class="panel-heading text-center">
                                    <b>Ranking</b>
                                </div>
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover">
                                            <thead>
                                                <tr>
                                                    <th>Data/Hora</th>
                                                    <th>Pontuação</th>
                                                    <th>Nome</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%
                                                    ArrayList<Partida> partidas = Partida.getRanking();

                                                    if (partidas != null) {
                                                        for (Partida partida : partidas) {
                                                %>
                                                <tr>
                                                    <td><%= partida.getDataFormatada() %></td>
                                                    <td><%= partida.getPontuacao() %></td>
                                                    <td><%= partida.getPlayerName() %></td>
                                                </tr>
                                                <%
                                                        }
                                                    }
                                                %>

                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="divider"></div>
                    <h2 class="text-center">Equipe</h2>
                    <div class="container-fluid">
                        <div class="row">
                            <div class="card hovercard col-md-2">
                                <img src="assets/img/cover-cesar.jpg" alt="Cesar Cesario"/>
                                <div class="avatar">
                                    <img src="assets/img/cesar.jpg" alt="Cesar Cesario"  class="circle"/>
                                </div>
                                <div class="info">
                                    <div class="title">
                                        Cesar Cesario
                                    </div>
                                    <p class="text-center">Responsável pela elaboração dos textos da página principal, pesquisa de campo para o quiz, feedback de teste do projeto e suporte na correção de erros.</p>
                                </div>
                                <div class="bottom">
                                    <p class="text-muted">Desenvolvedor</p>
                                </div>
                            </div>
                            <div class="card hovercard col-md-2">
                                <img src="assets/img/cover-helaman.jpg" alt="Helaman-fundo"/>
                                <div class="avatar">
                                    <img src="assets/img/helaman.jpg" alt="Helaman-foto"  class="circle"/>
                                </div>
                                <div class="info">
                                    <div class="title">
                                        Helaman Spadari
                                    </div>
                                    <p class="text-center">Responsável pela implementação dos links das páginas, da criação das pasta e dos arquivos de include e suporte na correção de erros.</p>
                                </div>
                                <div class="bottom">
                                    <p class="text-muted">Desenvolvedor</p>
                                </div>
                            </div>
                            <div class="card hovercard col-md-2">
                                <img src="assets/img/cover-jefferson.jpg" alt="Jefferson-fundo"/>
                                <div class="avatar">
                                    <img src="assets/img/jefferson.jpg" alt="Jefferson-foto"  class="circle"/>
                                </div>
                                <div class="info">
                                    <div class="title">
                                        Jefferson Nascimento
                                    </div>
                                    <ul class="text-center lista-card">
                                        <p class="text-center">Responsável por elaborar a modelagem do banco, implemenar as classes e os métodos, implementar o gerenciamento do administrador, auxiliar na correção de erros.</p>
                                </div>
                                <div class="bottom">
                                    <p class="text-muted">Desenvolvedor</p>
                                </div>
                            </div>
                            <div class="card hovercard col-md-2">
                                <img src="assets/img/cover-leonardo.jpg" alt="Leonardo Santos"/>
                                <div class="avatar">
                                    <img src="assets/img/leonardo.jpg" alt="Leonardo Santos"  class="circle"/>
                                </div>
                                <div class="info">
                                    <div class="title">
                                        Leonardo Santos
                                    </div>
                                    <p class="text-center">Responsável por auxiliar na modelagem do banco, realizar a estilização do site, criar lógica de autenticação de usuário e de proteção de acesso às páginas internas.</p>
                                </div>
                                <div class="bottom">
                                    <p class="text-muted">Desenvolvedor</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="WEB-INF/jspfs/footer.jspf" %>
<%@include file="WEB-INF/jspfs/modals.jspf" %>
<%@include file="WEB-INF/jspfs/scripts.jspf" %>
<% session.removeAttribute("erro");%>
</body>
</html>