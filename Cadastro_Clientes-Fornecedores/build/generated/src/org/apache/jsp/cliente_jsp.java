package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.fatecpg.cadastros.Cliente;
import com.fatecpg.cadastros.Fornecedor;

public final class cliente_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("         <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("         <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"images/icone.png\"/>\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/estilo.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>Cliente</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
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
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-12\">\n");
      out.write("                    <div class=\"card\">\n");
      out.write("                            <h2 style=\"text-align:center\" class=\"card-title\">Clientes</h2>\n");
      out.write("                            <p style=\"text-align:center\" class=\"card-text\">Adicionar novo cliente</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-block col-md-6\">\n");
      out.write("                        <form>\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-md-12\">\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label>Nome: </label>\n");
      out.write("                                        <input type=\"text\" name=\"nome\" class=\"form-control\" required>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-6\">\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label>CPF: </label>\n");
      out.write("                                        <input type=\"text\" name=\"cpf\" class=\"form-control\" required>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-6\">\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label>RG: </label>\n");
      out.write("                                        <input type=\"text\" name=\"rg\" class=\"form-control\" required>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-8\">\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label>Email: </label>\n");
      out.write("                                        <input type=\"text\" name=\"email\" class=\"form-control\" required>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-4\">\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label>Telefone: </label>\n");
      out.write("                                        <input type=\"text\" name=\"telefone\" class=\"form-control\" required>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-12\">\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label>Endereço: </label>\n");
      out.write("                                        <input type=\"text\" name=\"endereco\" class=\"form-control\" required>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div style=\"float: right\">\n");
      out.write("                                    <div class=\"col-md-6\">\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <input type=\"submit\" name=\"incluir\" value=\"Incluir\" class=\"btn btn-success\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div style=\"float: right\">\n");
      out.write("                                    <div class=\"col-md-6\">\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <input type=\"submit\" name=\"listar\" value=\"Listar\" class=\"btn btn-success\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    ");
try{
                        if(request.getParameter("incluir")!=null){
                            String nome=request.getParameter("nome");
                            String cpf=request.getParameter("cpf");
                            String rg=request.getParameter("rg");
                            String email=request.getParameter("email");
                            String telefone=request.getParameter("telefone");
                            String endereco=request.getParameter("endereco");
                            Cliente c = new Cliente();
                            c.setCliente(nome, cpf, rg, email, telefone, endereco);
                            Cliente.getClientes().add(c);
                            response.sendRedirect(request.getRequestURI());
                        }else if(request.getParameter("excluir")!=null){
                            String id=request.getParameter("id");
                            int i = Integer.parseInt(id);
                            Cliente.getClientes().remove(i);
                            response.sendRedirect(request.getRequestURI());
                        }else if(request.getParameter("listar")!=null){
                            for(int i=0; i<Cliente.getClientes().size(); i++){
                                Cliente c = Cliente.getClientes().get(i);
      out.write("\n");
      out.write("                                <div class=\"card-block col-md-6\">\n");
      out.write("                                    <table class=\"table\">\n");
      out.write("                                        <thead>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th>#</th>\n");
      out.write("                                                <th>Nome</th>\n");
      out.write("                                                <th>CPF</th>\n");
      out.write("                                                <th>RG</th>\n");
      out.write("                                                <th>Email</th>\n");
      out.write("                                                <th>Telefone</th>\n");
      out.write("                                                <th>Endereço</th>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        <tbody>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th>");
      out.print( i );
      out.write("</th>\n");
      out.write("                                                <td>");
      out.print( c.getNome() );
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print( c.getCpf() );
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print( c.getRg() );
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print( c.getEmail() );
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print( c.getTelefone() );
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print( c.getEndereco() );
      out.write("</td>\n");
      out.write("                                                <td>\n");
      out.write("                                                    <form>\n");
      out.write("                                                        <input type=\"hidden\" name=\"di\" value=\"");
      out.print(i);
      out.write("\"/>\n");
      out.write("                                                        <input type=\"submit\" name=\"alterar\" value=\"Alterar\"/>\n");
      out.write("                                                    </form>\n");
      out.write("                                                </td>\n");
      out.write("                                                <td>\n");
      out.write("                                                    <form>\n");
      out.write("                                                        <input type=\"hidden\" name=\"id\" value=\"");
      out.print(i);
      out.write("\"/>\n");
      out.write("                                                        <input type=\"submit\" name=\"excluir\" value=\"Excluir\"/>\n");
      out.write("                                                    </form>\n");
      out.write("                                                </td>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </tbody>\n");
      out.write("                                    </table>\n");
      out.write("                                </div>\n");
      out.write("                                ");
response.sendRedirect(request.getRequestURI());
                            }
                        }else if(request.getParameter("alterar")!=null){
                            String id=request.getParameter("di");
                            int i = Integer.parseInt(id);
                            Cliente.getClientes().remove(i);
                            response.sendRedirect(request.getRequestURI());
                        }
                    }catch(Exception ex){
      out.write("\n");
      out.write("                        <div style=\"color: red;\">Erro: ");
      out.print(ex.getMessage());
      out.write("</div>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                    <br/>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <br/>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("<footer class=\"footer\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("    <p class=\"text-muted\">Projeto 4 da disciplina de Programação Orientada a Objetos ministrada pelo professor Ricardo Pupo</p>\n");
      out.write("    </div>\n");
      out.write("</footer>");
      out.write("\n");
      out.write("    </body>\n");
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
