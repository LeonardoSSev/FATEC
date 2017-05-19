package br.com.grupo03.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 //@author Leonardo
@WebServlet(name = "JurosCompostoServlet", urlPatterns = {"/juros-composto.html"})
public class JurosCompostoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet: Juros Composto</title>");
            out.println("<link rel=\"stylesheet\" href=\"estilo/bootstrap.css\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
            out.println("<link href=\"estilo/style.css\" rel=\"stylesheet\">");
            out.println("<link href=\"https://fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,500,500i,700,700i\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body>");
            
            out.println("<header>"
                                +"<div class=\"container-fluid\">"
                                    +"<nav class=\"navbar navbar-inverse\">"
                                        +"<div class=\"container\">"
                                            +"<ul class=\"nav navbar-nav\">"
                                                +"<li><a href='home.html'>Home</a></li>"
                                                +"<li><a href='juros-simples.html'>Juros Simples</a></li>" 
                                                +"<li><a href='juros-composto.html'>Juros Composto</a></li>"
                                            +"</ul>"
                                        +"</div>"
                                    +"</nav>"
                                +"</div>"
                            +"</header>");
                out.println("<br/>");
            
            double capitalInicial = 0, juros = 0;
            int meses = 0;
            try{
              capitalInicial = Double.parseDouble(request.getParameter("capitalInicial"));
              juros = Double.parseDouble(request.getParameter("taxaJuros"));
              meses = Integer.parseInt(request.getParameter("tempo"));
            } catch(Exception ex){ }
            
            out.println("<main>");
            out.println("<div class=\"container\">");
            out.println("<h1 class=\"section-title\">Juros Composto</h1>");
            out.println("<form>");
            out.println("<table class=\"table\">");
            out.println("<tr>");
            out.println("<th colspan='3'>");
            out.println("Entrada de Dados");
            out.println("</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>");
            out.println("Valor inicial");
            out.println("</th>");
            out.println("<th>");
            out.println("Taxa de juros");
            out.println("</th>");
            out.println("<th>");
            out.println("Tempo(Meses)");
            out.println("</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>");
            out.println("<input type='text' name='capitalInicial' value='" + capitalInicial + "' placeholder='R$' />");
            out.println("</td>");
            out.println("<td>");
            out.println("<input type='text' name='taxaJuros' value='" + juros + "' placeholder='%'/>");
            out.println("</td>");
            out.println("<td>");
            out.println("<input type='text' name='tempo' value='" + meses + "'/>");
            out.println("</td>");
            out.println("</tr>");
            out.println("</table");
            out.println("<br/>");
            out.println("<table class=\"table table-bordered\">");
            out.println("<tr>");
            out.println("<th colspan='" + (meses+1) + "'>");
            out.println("Saída de Dados");
            out.println("</th>");
           out.println("<tr>");
            out.println("<th>");
           out.println("Montante Inicial"); 
           out.println("</th>");
           for (int i = 1; i <=meses; i++){
                out.println("<th>");
                out.println("Mês " + i);
                out.println("</th>");
            }
            out.println("</tr>");
            out.println("<tr>");
            double resultado = capitalInicial * (1+(juros/100));
            DecimalFormat df = new DecimalFormat("#.##");
            out.println("<td>");
            out.println("R$ " + df.format(capitalInicial));
            out.println("</td>");
            for (int i = 1; i<=meses; i++){
                out.println("<td>");
                out.println("R$ " + df.format(resultado));
                resultado *= (1+(juros/100));
                out.println("</td>");
            }
            out.println("</tr>");
            out.println("</table>");
            out.println("<center><input class=\"btn btn-default\" type='submit' value='Calcular'/></center>");
            out.println("</form>");
            out.println("</div>");
            out.println("</main>");
            out.println("<footer>"
                +"<p class=\"fonte-branca\">Desenvolvido pelo grupo - G3</p>"
            +"</footer>");
            out.println("<script type=\"text/javascript\" src=\"js/bootstrap.js\" />");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
