/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo03.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author supermoroni
 */
@WebServlet(name = "JurosSimplesServlet", urlPatterns = {"/juros-simples.html"})
public class JurosSimplesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JurosSimples</title><style>input.box{width:80px;}</style>"); 
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
            out.println("<h1 class=\"section-title\">Juros Simples</h1>");
            double j=0;
            double p=0;
            double i=0;
            int n = 0;
            try{
                p = Integer.parseInt(request.getParameter("p"));
                i = Integer.parseInt(request.getParameter("i"));
                n = Integer.parseInt(request.getParameter("n"));
            }
            catch(Exception ex){}
            out.println("<main>");
            out.println("<div class=\"container\">");
            out.println("<form><table class=\"table\"><tr>");
            out.println("<td><label for='principal'>Valor: </label></td>");
            out.println("<td><input type='text' placeholder='R$' maxlength='10' id='principal' name='p' requerid value'"+p+"'/></td></tr><br/>");
            out.println("<tr><td><label for='taxa'>Taxa de Juros Aplicada:</label></td>");
            out.println("<td><input type='text' id='taxa' name='i' requerid value'"+i+"'/>% a.m.</td></tr><br/>");
            out.println("<tr><td><label for='tempo'>Meses: </label></td>");
            out.println("<td><input type='text' id='tempo' requerid name='n' value'"+n+"'/></td></tr><br/>");
            out.println("<tr><td colspan=2><center><input class=\"btn btn-default\" type='submit' value='Calcular'/></center></td></tr>");
            out.println("</table></form>");
            i/=100;
            j=p*i*n;
            j+=p;
            DecimalFormat juros = new DecimalFormat("#.##");
            out.println("<p class=\"parag\"> Montante: R$ " + juros.format(j) + "</p");
            out.println("<br/>");
            out.println("</div>");
            out.println("</main>");
            out.println("<footer>"
                +"<p class=\"fonte-branca\">Desenvolvido pelo grupo - G3</p>"
            +"</footer>");
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