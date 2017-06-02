package org.apache.jsp.admin.questoes;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.fatecpg.data.Alternativa;
import com.fatecpg.data.Questao;
import java.util.ArrayList;
import br.com.fatecpg.helpers.ServerHelpers;
import br.com.fatecpg.helpers.ServerHelpers;
import com.fatecpg.data.Usuario;
import br.com.fatecpg.helpers.ServerHelpers;
import br.com.fatecpg.helpers.ServerHelpers;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(6);
    _jspx_dependants.add("/admin/questoes/../../WEB-INF/jspfs/links.jspf");
    _jspx_dependants.add("/admin/questoes/../../WEB-INF/jspfs/menu.jspf");
    _jspx_dependants.add("/admin/questoes/../../WEB-INF/jspfs/menuLateral.jspf");
    _jspx_dependants.add("/admin/questoes/../../WEB-INF/jspfs/modals.jspf");
    _jspx_dependants.add("/admin/questoes/../../WEB-INF/jspfs/footer.jspf");
    _jspx_dependants.add("/admin/questoes/../../WEB-INF/jspfs/scripts.jspf");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"icon\" href=\"");
      out.print( ServerHelpers.getRootPath(request) );
      out.write("/assets/img/quiz-icone.png\" type=\"image/x-icon\" />\n");
      out.write("<link rel=\"shortcut icon\" href=\"");
      out.print( ServerHelpers.getRootPath(request) );
      out.write("/assets/img/quiz-icone.png\" type=\"image/x-icon\" />\n");
      out.write("<link href=\"");
      out.print( ServerHelpers.getRootPath(request) );
      out.write("/assets/css/bootstrap.css\" rel=\"stylesheet\" />\n");
      out.write("<link href=\"");
      out.print( ServerHelpers.getRootPath(request) );
      out.write("/assets/css/font-awesome.css\" rel=\"stylesheet\" />\n");
      out.write("<link href=\"");
      out.print( ServerHelpers.getRootPath(request) );
      out.write("/assets/js/morris/morris-0.4.3.min.css\" rel=\"stylesheet\" />\n");
      out.write("<link href=\"");
      out.print( ServerHelpers.getRootPath(request) );
      out.write("/assets/css/custom.css\" rel=\"stylesheet\" />\n");
      out.write("<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />\n");
      out.write("\n");
      out.write("        <title></title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    HttpSession menuSession = request.getSession();
    Usuario usuarioLogado = (Usuario) menuSession.getAttribute("usuarioLogado");
      out.write("\n");
      out.write("<nav class=\"navbar navbar-inverse navbar-cls-top \" role=\"navigation\" style=\"margin-bottom: 0\">\n");
      out.write("    <div class=\"navbar-header\">\n");
      out.write("        <a class=\"navbar-brand\" href=\"");
      out.print(ServerHelpers.getRootPath(request));
      out.write("/index.jsp\">Quiz</a> \n");
      out.write("    </div>\n");
      out.write("    <ul class=\"nav navbar-nav\" style=\"padding-left: 2%;\">\n");
      out.write("        <li><a href=\"#\">Página Inicial</a></li>\n");
      out.write("            ");
try {
        if (usuarioLogado == null) {
      out.write("\n");
      out.write("    </ul>\n");
      out.write("    <ul class=\"nav navbar-nav navbar-right\" style=\"margin-right: 2%;\">\n");
      out.write("\n");
      out.write("        <li><a href=\"#\" data-toggle=\"modal\" data-target=\"#cadastroModal\"><i class=\"fa fa-user\"></i> Cadastre-se</a></li>\n");
      out.write("        <li><a href=\"#\" data-toggle=\"modal\" data-target=\"#loginModal\"><i class=\"fa fa-sign-in\"></i> Login</a></li>\n");
      out.write("            ");
} else if (usuarioLogado.isAdmin()) {
      out.write("\n");
      out.write("    </ul>\n");
      out.write("    <ul class=\"nav navbar-nav navbar-right\" style=\"margin-right: 1%;\">\n");
      out.write("        <li class=\"navbar-text\">Bem vindo, ");
      out.print(usuarioLogado.getUsername());
      out.write("</li>\n");
      out.write("        <li><a href=\"index.jsp\"><i class=\"fa fa-user\"></i>Gerenciamento</a></li>\n");
      out.write("        <li><a href=\"#\" data-toggle=\"modal\" data-target=\"#logoffModal\"><i class=\"fa fa-sign-out\"></i> Sair</a></li>\n");
      out.write("            ");
} else {
      out.write("\n");
      out.write("        <li><a href=\"#\">Quiz</a></li>\n");
      out.write("    </ul>\n");
      out.write("    <ul class=\"nav navbar-nav navbar-right\" style=\"margin-right: 1%;\">\n");
      out.write("        <li class=\"navbar-text\">Bem vindo, ");
      out.print(usuarioLogado.getUsername());
      out.write("</li>\n");
      out.write("        <li><a href=\"perfil.jsp\"><i class=\"fa fa-user\"></i>Perfil</a></li>\n");
      out.write("        <li><a href=\"#\" data-toggle=\"modal\" data-target=\"#logoffModal\"><i class=\"fa fa-sign-out\"></i> Sair</a></li>\n");
      out.write("            ");
}
            } catch (Exception ex) {
      out.write("\n");
      out.write("        <li>Erro: ");
      out.print( ex.getMessage());
      out.write("</li>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("    </ul>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("        <div id=\"wrapper\">\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("            <nav class=\"navbar-default navbar-side\" role=\"navigation\">\n");
      out.write("                <div class=\"sidebar-collapse\">\n");
      out.write("                    <ul class=\"nav\" id=\"main-menu\">\n");
      out.write("                        <li class=\"text-center\">\n");
      out.write("                            <img src=\"../../assets/img/find_user.png\" class=\"user-image img-responsive\"/>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a class=\"active-menu\"  href=\"index,jsp\"><i class=\"fa fa-dashboard fa-3x\"></i> Painel</a>\n");
      out.write("                       <li>\n");
      out.write("                            <a href=\"#\"<i class=\"fa fa-users lg\"</i> Usuários<span class=\"fa arrow\"></span></a>\n");
      out.write("                            <ul class=\"nav nav-second-level\">\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"#\">Criar</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"#\">Editar</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"#\">Atualizar</a>\n");
      out.write("                                </li>\n");
      out.write("                                 <li>\n");
      out.write("                                    <a href=\"#\">Excluir</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"#\">Exibir</a>\n");
      out.write("                                </li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                            <a href=\"#\"<i class=\"fa fa-list lg\" ></i> Questões<span class=\"fa arrow\"></span></a>\n");
      out.write("                            <ul class=\"nav nav-second-level\">\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"create.jsp\">Criar</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"edit.jsp\">Editar</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"update.jsp\">Atualizar</a>\n");
      out.write("                                </li>\n");
      out.write("                                 <li>\n");
      out.write("                                    <a href=\"delete.jsp\">Excluir</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"store.jsp\">Exibir</a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>  \n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </nav>  ");
      out.write("\n");
      out.write("            <div id=\"page-wrapper\" class=\"container\">\n");
      out.write("                <div id=\"page-inner\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-12\">\n");
      out.write("                            <h2 class=\"text-center\">Painel do Administrador</h2>   \n");
      out.write("                            <h5 class=\"text-center\">Bem vindo, Admnistrador. </h5>\n");
      out.write("                            ");

                                String mensagem = (String) userSession.getAttribute("mensagem");

                                if (mensagem != null) {
                            
      out.write("\n");
      out.write("                            <p>");
      out.print(mensagem);
      out.write("</p>\n");
      out.write("                            ");

                                }

                                ArrayList<Questao> questoes = Questao.all();

                                for (Questao questao : questoes) {
                            
      out.write("\n");
      out.write("                            <p>\n");
      out.write("                                Questao: ");
      out.print( questao.getTexto());
      out.write("<br>\n");
      out.write("                            <ol>\n");
      out.write("                                ");

                                    for (Alternativa alternativa : questao.getAlternativas()) {
                                
      out.write("\n");
      out.write("                                <li>\n");
      out.write("                                    ");
      out.print( alternativa.getTexto());
      out.write("\n");
      out.write("                                </li>\n");
      out.write("                                ");

                                    }
                                
      out.write("\n");
      out.write("                            </ol>\n");
      out.write("                            </p>\n");
      out.write("                            ");

                                }
                                userSession.removeAttribute("mensagem");
                            
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>              \n");
      out.write("                </div>\n");
      out.write("            </div>     \n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!--MODAL DE CADASTRO-->\n");
      out.write("<div id=\"cadastroModal\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("    <div class=\"modal-dialog\">\n");
      out.write("        <!-- Modal content-->\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                <h4 class=\"modal-title text-center\">Cadastro</h4>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <form role=\"form\" action=\"auth/cadastro.jsp\" method=\"POST\">\n");
      out.write("                    <br/>\n");
      out.write("                    <div class=\"form-group input-group\">\n");
      out.write("                        <span class=\"input-group-addon\"><i class=\"fa fa-circle-o-notch\"  ></i></span>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"nomeCadastro\" placeholder=\"Nome\" required />\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group input-group\">\n");
      out.write("                        <span class=\"input-group-addon\"><i class=\"fa fa-circle-o-notch\"  ></i></span>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"nomeUsuarioCadastro\" placeholder=\"Nome de usuário\" required />\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group input-group\">\n");
      out.write("                        <span class=\"input-group-addon\"><i class=\"fa fa-lock\"></i></span>\n");
      out.write("                        <input type=\"password\" class=\"form-control\" name=\"senhaCadastro\" id=\"senhaCadastro\" placeholder=\"Senha\" required />\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group input-group\">\n");
      out.write("                        <span class=\"input-group-addon\"><i class=\"fa fa-lock\"  ></i></span>\n");
      out.write("                        <input type=\"password\" class=\"form-control\" name=\"senha2\" placeholder=\"Reescreva a senha\" oninput=\"validaSenha(this)\" required />\n");
      out.write("                    </div>\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-success \">Cadastrar</button>\n");
      out.write("                    <hr/>\n");
      out.write("                    Já é cadastrado?  <a href=\"#\" data-dismiss=\"modal\" data-target=\"#loginModal\" data-toggle=\"modal\">Faça o Login</a>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<!--FIM MODAL-->\n");
      out.write("<!--MODAL DE LOGIN-->\n");
      out.write("<div id=\"loginModal\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("    <div class=\"modal-dialog\">\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                <h4 class=\"modal-title text-center\">Login</h4>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <form role=\"form\" action=\"auth/login.jsp\" method=\"POST\">\n");
      out.write("                    <br />\n");
      out.write("                    <div class=\"form-group input-group\">\n");
      out.write("                        <span class=\"input-group-addon\"><i class=\"fa fa-circle-o-notch\"  ></i></span>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" placeholder=\"Nome de usuário \" name=\"usernameLogin\" required />\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group input-group\">\n");
      out.write("                        <span class=\"input-group-addon\"><i class=\"fa fa-lock\"  ></i></span>\n");
      out.write("                        <input type=\"password\" class=\"form-control\"  placeholder=\"Senha\" name=\"senhaLogin\" required />\n");
      out.write("                    </div>\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary \">Entrar</button>\n");
      out.write("                    <hr />\n");
      out.write("                    Não possui cadastro? <a href=\"#\" data-toggle=\"modal\" data-target=\"#cadastroModal\"  data-dismiss=\"modal\">Clique aqui </a> \n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<!--FIM MODAL-->\n");
      out.write("<!--MODAL DE LOGOFF-->\n");
      out.write("<div id=\"logoffModal\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("    <div class=\"modal-dialog\">\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                <h4 class=\"modal-title text-center\">Logoff</h4>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <p class=\"text-center\">Deseja realmente sair da sessão?</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-footer\">\n");
      out.write("                <a href=\"#\" data-dismiss=\"modal\" class=\"btn btn-success \">Cancelar</a>\n");
      out.write("                <a href=\"");
      out.print(ServerHelpers.getRootPath(request));
      out.write("/auth/logoff.jsp\" class=\"btn btn-danger \">Sair</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<!--FIM MODAL-->\n");
      out.write("<!--MODAL DE CADASTRO REALIZADO-->\n");
      out.write("<div id=\"cadastradoModal\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("    <div class=\"modal-dialog\">\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                <h4 class=\"modal-title text-center\">Cadastro</h4>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <p class=\"text-center\">Cadastro realizado com sucesso!</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-footer\">\n");
      out.write("                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Fechar</button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<!--FIM MODAL-->\n");
      out.write("<!--MODAL DE USUARIO EXISTENTE-->\n");
      out.write("<div id=\"usuarioExistenteModal\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("    <div class=\"modal-dialog\">\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" data-target=\"cadastroModal\">&times;</button>\n");
      out.write("                <h4 class=\"modal-title text-center\">Erro</h4>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <p class=\"text-center\">Ja existe um usuário cadastrado com esse nome!</p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<!--FIM MODAL-->\n");
      out.write("<!--MODAL DE USUARIO EXISTENTE-->\n");
      out.write("<div id=\"dadosIncorretosModal\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("    <div class=\"modal-dialog\">\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" data-target=\"loginModal\">&times;</button>\n");
      out.write("                <h4 class=\"modal-title text-center\">Erro</h4>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <p class=\"text-center\">Dados incorretos!</p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<!--FIM MODAL-->");
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("<footer>\n");
      out.write("    <div style=\"color:#fff;\" class=\"text-center\">\n");
      out.write("        <div class=\"well well-sm main-footer\"  style=\"background-color:#202020; border:0px\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-12\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-4\">\n");
      out.write("                            <h1 class=\"title-footer\">Projeto 06</h1>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-4 contact-email\">\n");
      out.write("                            <h2>\n");
      out.write("                                <a href=\"https://github.com/JeffersonCN/poo-projeto-06\">GitHub</a></h2>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-4\">\n");
      out.write("                            <div class=\"row contact row-first\">\n");
      out.write("                                <div class=\"col-md-6\">\n");
      out.write("                                    <a href=\"https://github.com/CezCesario\"target=\"_blank\" class=\"github\"><i class=\"fa fa-github\"></i>Cesar Cesario</a>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-6\">\n");
      out.write("                                    <a href=\"https://www.github.com/helamanspadari\" target=\"_blank\" class=\"github\"><i class=\"fa fa-github\"></i>Helaman Spadari</a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"row contact\">\n");
      out.write("                                <div class=\"col-md-6\">\n");
      out.write("                                    <a href=\"http://www.github.com/jeffersoncn\" target=\"_blank\" class=\"github\"><i class=\"fa fa-github\"></i>Jefferson Nascimento</a>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-6\">\n");
      out.write("                                    <a href=\"http://www.github.com/leonardossev\" target=\"_blank\" class=\"github\"><i class=\"fa fa-github\"></i>Leonardo Santos</a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</footer>");
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<script src=\"");
      out.print( ServerHelpers.getRootPath(request) );
      out.write("/assets/js/jquery-1.10.2.js\"></script>\n");
      out.write("<script src=\"");
      out.print( ServerHelpers.getRootPath(request) );
      out.write("/assets/js/bootstrap.min.js\"></script>\n");
      out.write("<script src=\"");
      out.print( ServerHelpers.getRootPath(request) );
      out.write("/assets/js/jquery.metisMenu.js\"></script>\n");
      out.write("<script src=\"");
      out.print( ServerHelpers.getRootPath(request) );
      out.write("/assets/js/morris/raphael-2.1.0.min.js\"></script>\n");
      out.write("<script src=\"");
      out.print( ServerHelpers.getRootPath(request) );
      out.write("/assets/js/morris/morris.js\"></script>\n");
      out.write("<script src=\"");
      out.print( ServerHelpers.getRootPath(request) );
      out.write("/assets/js/custom.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
