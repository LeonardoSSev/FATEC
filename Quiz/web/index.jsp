<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Collections"%>
<%@page import="com.domain.quiz.RankingComparator"%>
<%@page import="com.domain.quiz.Score"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.domain.quiz.Player"%>
<%@page import="com.domain.quiz.Quiz"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    DecimalFormat df = new DecimalFormat("#.##");
    DecimalFormat df2 = new DecimalFormat("0.00");
    double lastGrade = 100.0 * Quiz.getLastGrade();
    double averageGrade = 100.0 * Quiz.getGradeAverage();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="WEB-INF/jspfs/head.jspf" %>
        <title>Quiz: index</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspfs/header.jspf" %>
        <div class="container content">
            <fieldset>
                <legend>Comece a Jogar</legend>
                <form class="form col-md-12" action="test.jsp" method="GET">
                    <div class="form-control col-md-offset-6 col-md-12">
                        <input type="text" id="nm" name="nm" class="form-control input-md" placeholder="Informe o seu nome aqui.." required/>
                        <input type="submit" class="btn btn-primary btn-lg btn-block" value="Começar Quiz"  />
                    </div>
                </form>
            </fieldset>
            <hr/>
            <div class="row">
                <div class="col-md-6">
                    <h3>Última nota:</h3>
                    <h4><%= df.format(lastGrade)%>%</h4>
                </div>
                <div class="col-md-6">
                    <h3>Média</h3>
                    <h4><%= df.format(averageGrade)%>%</h4>
                </div>
            </div>
            <hr/>
            <div class="table col-md-12">
                <table class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <th id="titleTable" colspan="2"> <h3>Ranking</h3> </th>
                        </tr>
                        <tr>
                            <th>Pontuação</th>
                            <th>Jogador</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ArrayList<Score> ranking = Score.ranking;
                            Collections.sort(ranking, new RankingComparator());
                            for (Score score : ranking) {%>
                        <tr>
                            <td><%= df2.format(score.getScore())%></td>
                            <td><%= score.getPlayer().getNome()%></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div
            <section class="section team-section col-md-12 "> 
                <hr/>
                <h1 class="section-heading ">Nossa Equipe</h1>
                <p class="text">Quinto trabalho da disciplina de Programação Orientada a Objetos, ministrada pelo professor Ricardo Pupo, realizado pela equipe 3.</p>
                <div class="row text-center">
                    <div class="col-md-4">
                        <img src="libs/imgs/anderson.jpg" class="img-thumbnail">
                        <h4>Anderson Orsogna</h4>
                        <h5>Desenvolvedor Back-end</h5>
                    </div>
                    <div class="col-md-4">
                        <img src="libs/imgs/leonardo.jpg" class="img-thumbnail">
                        <h4>Leonardo Santos</h4>
                        <h5>Desenvolvedor Back-end</h5>
                    </div>
                    <div class="col-md-4 mb-r">
                        <img src="libs/imgs/rafael.jpg" class="img-thumbnail"/>
                        <h4>Rafael Araújo</h4>
                        <h5>Desenvolvedor Front-end</h5>
                    </div>
                </div>
            </section>
        </div>
        <%@include file="WEB-INF/jspfs/footer.jspf" %>
    </body>
</html>
