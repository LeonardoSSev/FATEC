<%@page import="java.util.Collections"%>
<%@page import="com.domain.quiz.Score"%>
<%@page import="com.domain.quiz.Player"%>
<%@page import="com.domain.quiz.Quiz"%>
<%@page import="com.domain.quiz.Question"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    try {
        if (request.getParameter("test") != null) {
            //para o quiz
            Quiz.validateTest(new String[]{
                request.getParameter("0"),
                request.getParameter("1"),
                request.getParameter("2"),
                request.getParameter("3"),
                request.getParameter("4"),
                request.getParameter("5"),
                request.getParameter("6"),
                request.getParameter("7"),
                request.getParameter("8"),
                request.getParameter("9")
            });
            double scoreJogador = Quiz.getLastGrade() * 10;
            String nome = request.getParameter("name");

            //criando jogador
            Player p = new Player(nome);
            p.setName(nome);

            //criando pontuaçao
            Score score = new Score();
            score.setPlayer(p);
            score.setScore(scoreJogador);
            Score.ranking.add(score);

            response.sendRedirect("index.jsp");
        }
    } catch (Exception e) {
    }

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="WEB-INF/jspfs/head.jspf" %>
        <title>Quiz: Teste</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspfs/header.jspf" %>
        <div class="container content">
            <div class="container">
                <h4 id="instructionsTitle" class="lead">Instruções:</h4>
                <ul class="list-group">
                    <li>Para cada questão há apenas uma alternativa correta.</li>
                    <li>Selecione a alternativa que julgar correta.</li>
                    <li>Ao final do teste, clique em Finalizar para finalizar o quiz.</li>
                    <li>Boa sorte!</li>
                </ul>
            </div>
            <hr/>
            <fieldset class="col-md-12">
                <form action="test.jsp">
                    <%ArrayList<Question> test = Quiz.getTest();
                    Collections.shuffle(test);
                    int numQuestao = 0;
                    for (Question q : test) {
                    numQuestao++;%>
                    <h3><span class="label label-warning"><%= numQuestao + " - " + q.getQuestion()%></span></h3>
                        <%for (String alternative : q.getAlternatives()) {%>
                    <div class="form-control">
                        <label class="radio">
                            <input type="radio" name="<%=test.indexOf(q)%>" value="<%=alternative%>" required/><%=alternative%>
                        </label>
                    </div>
                    <%}%>
                    <hr/>
                    <%}%>
                    <div class="form-group">
                        <input class="btn btn-primary btn-lg col-md-offset-2 col-md-8" type="submit" name="test" value="Concluir"/>
                        <input type="hidden" value=<%=request.getParameter("nm")%> name="name" />
                    </div>
                </form>
            </fieldset>
        </div>
        <%@include file="WEB-INF/jspfs/footer.jspf" %>
    </body>
</html>
