<%@page import="com.fatecpg.cadastros.Fornecedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" type="image/x-icon" href="images/icone.png"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <title>Fornecedor</title>
    </head>
    <body>
        <div class="container">
            <%@ include file="WEB-INF/jspf/menu.jspf" %>
            <div class="row">
                <div class="col-md-12">
                    <h1>Fornecedor</h1>
                    <%
                        Fornecedor fornecedorEncontrado = null;
                        if (request.getParameter("adicionar") != null || request.getParameter("salvar") != null) {
                            String nome = request.getParameter("nome");
                            String razaoSocial = request.getParameter("razao_social");
                            String cnpj = request.getParameter("cnpj");
                            String email = request.getParameter("email");
                            String telefone = request.getParameter("telefone");
                            String endereco = request.getParameter("endereco");

                            Fornecedor f = new Fornecedor(nome, razaoSocial, cnpj, email, telefone, endereco);

                            if (request.getParameter("adicionar") != null) {
                                Fornecedor.adicionar(f);
                            } else {
                                short id = Short.parseShort(request.getParameter("id"));
                                Fornecedor.editar(f, id);
                            }
                        } else if (request.getParameter("editar") != null) {
                            short id = Short.parseShort(request.getParameter("id"));
                            fornecedorEncontrado = Fornecedor.fornecedorById(id);
                        } else if (request.getParameter("excluir") != null) {
                            short id = Short.parseShort(request.getParameter("id"));
                            Fornecedor.excluir(id);
                        }
                    %>
                    <form class="form" action="" method="POST">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    Nome<input class="form-control" type="text" name="nome" id="nome" <% if (fornecedorEncontrado != null) {%> value="<%=fornecedorEncontrado.getNome()%>" <%}%>>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    Razão Social<input class="form-control" type="text" name="razao_social" id="razao-social" <% if (fornecedorEncontrado != null) {%> value="<%=fornecedorEncontrado.getRazaoSocial()%>" <%}%>>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="form-group">
                                    CNPJ<input class="form-control" type="text" name="cnpj" id="cnpj" maxlength="14" <% if (fornecedorEncontrado != null) {%> value="<%=fornecedorEncontrado.getCnpj()%>" <%}%>>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    E-mail<input class="form-control" type="email" name="email" id="email"<% if (fornecedorEncontrado != null) {%> value="<%=fornecedorEncontrado.getEmail()%>" <%}%>>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="form-group">
                                    Telefone<input class="form-control" type="text" name="telefone" id="telefone"<% if (fornecedorEncontrado != null) {%> value="<%=fornecedorEncontrado.getTelefone()%>" <%}%>>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    Endereço<input class="form-control" type="text" name="endereco" id="endereco" <% if (fornecedorEncontrado != null) {%> value="<%=fornecedorEncontrado.getEndereco()%>" <%}%>>
                                </div>
                            </div>
                        </div>

                        <% if (fornecedorEncontrado == null) {%>
                        <input class="btn btn-default pull-right" type="submit" name="adicionar" value="Adicionar">
                        <%} else {%>
                        <input type="number" name="id" value="<%=fornecedorEncontrado.getId()%>" hidden>
                        <input class="btn btn-default pull-right" type="submit" name="salvar" value="Salvar">
                        <%}%>

                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <hr>
                    <h1>Listagem</h1>
                    <table class="table table-striped table-responsive table-bordered">
                        <tr>
                            <th>Nome</th>
                            <th>Razão Social</th>
                            <th>CNPJ</th>
                            <th>E-mail</th>
                            <th>Telefone</th>
                            <th>Endereço</th>
                            <th>Ação</th>
                        </tr>

                        <%
                            for (Fornecedor fornecedor : Fornecedor.getLista()) {
                        %>
                        <tr>
                            <td><%=fornecedor.getNome()%></td>
                            <td><%=fornecedor.getRazaoSocial()%></td>
                            <td class="table-cnpj"><%=fornecedor.getCnpj()%></td>
                            <td><%=fornecedor.getEmail()%></td>
                            <td class="table-telefone"><%=fornecedor.getTelefone()%></td>
                            <td><%=fornecedor.getEndereco()%></td>
                            <td>
                                <div class="row">
                                    <div class="col-md-6">
                                        <form action="" method="POST">
                                            <input type="number" name="id" value="<%=fornecedor.getId()%>" hidden>
                                            <input class="btn btn-default btn-sm" type="submit" name="editar" value="Editar">
                                        </form>
                                    </div>
                                    <div class="col-md-6">
                                        <form action="" method="POST">
                                            <input type="number" name="id" value="<%=fornecedor.getId()%>" hidden>
                                            <input class="btn btn-default btn-sm" type="submit" name="excluir" value="Excluir">
                                        </form>
                                    </div>
                                </div>


                            </td>
                        </tr>

                        <%}%>
                    </table>
                </div>
            </div>
        </div>
        <hr>
        <%@ include file="WEB-INF/jspf/rodape.jspf" %>       
    </body>
</html>
