package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.fatecpg.cadastros.Cliente;
import com.fatecpg.cadastros.Fornecedor;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/WEB-INF/jspf/menu.jspf");
    _jspx_dependants.add("/WEB-INF/jspf/rodape.jspf");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"images/icone.png\"/>\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/estilo.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>Home</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container content\">\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"header clearfix\">\n");
      out.write("    <nav>\n");
      out.write("        <ul class=\"nav nav-pills pull-right\">\n");
      out.write("            <li role=\"presentation\"><a href=\"home.jsp\">Home</a></li>\n");
      out.write("            <li role=\"presentation\"><a href=\"cliente.jsp\">Cliente</a></li>\n");
      out.write("            <li role=\"presentation\"><a href=\"fornecedor.jsp\">Fornecedor</a></li>\n");
      out.write("        </ul>\n");
      out.write("    </nav>\n");
      out.write("    <h3 class=\"text-muted\">Projeto 4 - POO</h3>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("            <div class=\"jumbotron\">\n");
      out.write("                <h1>Aplicação de Cadastro</h1>\n");
      out.write("                <p class=\"lead\">Este projeto tem como objetivo realizar o cadastro de clientes e fornecedores.</p>\n");
      out.write("                <p class=\"lead\">Também deve ser possível listar, editar e excluir clientes e fornecedores já cadastrados.</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <h1 class=\"section-title\">Equipe</h1>\n");
      out.write("                <div class=\"col-md-3\">\n");
      out.write("                    <div class=\"panel panel-default panel m-b-0\">\n");
      out.write("                        <div class=\"panel-heading background-higor\"></div>\n");
      out.write("                        <div class=\"panel-body text-center\">\n");
      out.write("                            <img class=\"panel-profile-img redondo\" src=\"images/higormoroni.jpg\"/>\n");
      out.write("                            <h4 class=\"section-title\">Higor Moroni</h4>\n");
      out.write("                            <p class=\"parag\">Desenvolvedor</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-3\">\n");
      out.write("                    <div class=\"panel panel-default panel m-b-0\">\n");
      out.write("                        <div class=\"panel-heading background-leonardo\"></div>\n");
      out.write("                        <div class=\"panel-body text-center\">\n");
      out.write("                            <img class=\"panel-profile-img\" src=\"images/leonardo.jpg\"/>\n");
      out.write("                            <h4 class=\"section-title\">Leonardo</h4>\n");
      out.write("                            <p class=\"parag\">Desenvolvedor</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-3\">\n");
      out.write("                    <div class=\"panel panel-default panel m-b-0\">\n");
      out.write("                        <div class=\"panel-heading background-thiago1\"></div>\n");
      out.write("                        <div class=\"panel-body text-center\">\n");
      out.write("                            <img class=\"panel-profile-img\" src=\"images/thiago1.jpg\"/>\n");
      out.write("                            <h4 class=\"section-title\">Thiago Bonini</h4>\n");
      out.write("                            <p class=\"parag\">Desenvolvedor</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-3\">\n");
      out.write("                    <div class=\"panel panel-default panel m-b-0\">\n");
      out.write("                        <div class=\"panel-heading background-thiago2\"></div>\n");
      out.write("                        <div class=\"panel-body text-center\">\n");
      out.write("                            <img class=\"panel-profile-img\" src=\"images/thiago2.jpg\"/>\n");
      out.write("                            <h4 class=\"section-title\">Thiago Felipe</h4>\n");
      out.write("                            <p class=\"parag\">Desenvolvedor</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("<footer class=\"footer\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("    <p class=\"text-muted\">Projeto 4 da disciplina de Programação Orientada a Objetos ministrada pelo professor Ricardo Pupo</p>\n");
      out.write("    </div>\n");
      out.write("</footer>");
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
