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
        <title>Quiz - Inserir Questão</title>
    </head>
    <body>
        <%@include file="../../WEB-INF/jspfs/protecaoAdmin.jspf" %>
        <div id="wrapper">
            <%@include file="../../WEB-INF/jspfs/menuConjunto.jspf" %>
            <div id="page-wrapper" class="text-center">
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-10 col-md-offset-1">
                            <form action="store.jsp" method="post">
                                <h2>Inserir nova questão</h2>
                                <div class="form-group col-md-6 col-md-offset-3">
                                    <label for="txtQuestao"><h3>Questão:</h3></label>
                                    <input type="text" name="txtQuestao" id="txtQuestao" class="form-control"/>
                                </div>
                        </div>
                    </div>
                    <h3>Inserir alternativas</h3>
                    <div class="col-md-8 col-md-offset-2">
                        <table class="table table-bordered">
                            <tr>
                                <th>#</th>
                                <th>Texto</th>
                                <th>Correta</th>
                            </tr>
                            <tr>
                                <td>1.</td>
                                <td>
                                    <div class="form-group">
                                        <input type="text" name="alternativa[0]" id="alternativa[0]" class="form-control"/>
                                    </div>
                                </td>
                                <td>
                                    <div class="radio">
                                        <input type="radio" name="correta" value="0">
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>2.</td>
                                <td>
                                    <div class="form-group">
                                        <input type="text" name="alternativa[1]" id="alternativa[1]" class="form-control"/>
                                    </div>
                                </td>
                                <td>
                                    <div class="radio">
                                        <input type="radio" name="correta" value="1">
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>3.</td>
                                <td>
                                    <div class="form-group">
                                        <input type="text" name="alternativa[2]" id="alternativa[2]" class="form-control"/>
                                    </div>
                                </td>
                                <td>
                                    <div class="radio">
                                        <input type="radio" name="correta" value="2">
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>4.</td>
                                <td>
                                    <div class="form-group">
                                        <input type="text" name="alternativa[3]" id="alternativa[3]" class="form-control"/>
                                    </div>
                                </td>
                                <td><div class="radio">
                                        <input type="radio" name="correta" value="3">
                                    </div>
                                </td>
                            </tr>
                        </table>
                        <input type="submit" value="Cadastrar" class="btn btn-primary"/>
                        </form>
                    </div>
                </div>              
            </div>
        </div>     
    </div>
</div>
</div>
<%@include file="../../WEB-INF/jspfs/modals.jspf" %>
<%@include file="../../WEB-INF/jspfs/footer.jspf" %>
<%@include file="../../WEB-INF/jspfs/scripts.jspf" %>
</body>
</html>
