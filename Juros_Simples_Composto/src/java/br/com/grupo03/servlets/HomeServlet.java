/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo03.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jonatas Lopes
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home.html"})
public class HomeServlet extends HttpServlet {

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
            out.println("<title>Home</title>");
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
                out.println("<main>"
                                +"<div class=\"container\">"
                                    +"<div class=\"row\">"
                                        + "<h1 class=\"section-title\">Grupo 3 - Integrantes</h1>"
                                        + "<h2 class=\"section-subtitle\">ADS 4ºCiclo - Noturno</h2>"
                                        +"<div class=\"col-md-3 m-b-lg\">"
                                            +"<div class=\"panel panel-default panel-profile m-b-0\">"
                                                +"<div class=\"panel-heading bg-felipe\"></div>"
                                                +"<div class=\"panel-body text-center\">"
                                                    +"<img class=\"panel-profile-img\" src=\"imagens/felipe.jpg\">"
                                                    +"<h4 class=\"section-title\">Felipe Melo</h4>"
                                                    +"<p class=\"parag\">Desenvolvedor do estilo do projeto</p>"
                                                +"</div>"
                                            +"</div>"
                                        +"</div>"
                                        +"<div class=\"col-md-3 m-b-lg\">"
                                            +"<div class=\"panel panel-default panel-profile m-b-0\">"
                                                +"<div class=\"panel-heading bg-higor\"></div>"
                                                +"<div class=\"panel-body text-center\">"
                                                    +"<img class=\"panel-profile-img\" src=\"imagens/higor.jpg\">"
                                                    +"<h4 class=\"section-title\">Higor Moroni</h4>"
                                                    +"<p class=\"parag\">Desenvolvedor da página de Juros</p>"
                                                +"</div>"
                                            +"</div>"
                                        +"</div>"
                                        +"<div class=\"col-md-3 m-b-lg\">"
                                            +"<div class=\"panel panel-default panel-profile m-b-0\">"
                                                +"<div class=\"panel-heading bg-jonatas\"></div>"
                                                +"<div class=\"panel-body text-center\">"
                                                    +"<img class=\"panel-profile-img\" src=\"imagens/jonatas.jpg\">"
                                                    +"<h4 class=\"section-title\">Jonatas</h4>"
                                                    +"<p class=\"parag\">Desenvolvedor da página Home</p>"
                                                +"</div>"
                                            +"</div>"
                                        +"</div>"
                                        +"<div class=\"col-md-3 m-b-lg\">"
                                            +"<div class=\"panel panel-default panel-profile m-b-0\">"
                                                +"<div class=\"panel-heading bg-leonardo\"></div>"
                                                +"<div class=\"panel-body text-center\">"
                                                    +"<img class=\"panel-profile-img\" src=\"imagens/leonardo.jpg\">"
                                                    +"<h4 class=\"section-title\">Leonardo Santos</h4>"
                                                    +"<p class=\"parag\">Desenvolvedor da página de Juros Composto</p>"
                                                +"</div>"
                                            +"</div>"
                                        +"</div>"
                                    + "</div>"
                                +"</div>"
                        +"</main>");
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
