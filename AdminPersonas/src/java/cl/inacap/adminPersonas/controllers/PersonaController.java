/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.adminPersonas.controllers;

import cl.inacap.adminPersonas.beans.PersonaBeanLocal;
import cl.inacap.adminPersonas.modelo.Persona;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sarayar
 */
@WebServlet(name = "PersonaController", urlPatterns = {"/control.do"})
public class PersonaController extends HttpServlet {

    @EJB
    private PersonaBeanLocal service;

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

        String boton = request.getParameter("btn");

        switch (boton) {
            case "login":
                login(request, response);
                break;
            case "registro":
                registro(request, response);
                break;
            case "editar":
                editar(request, response);
                break;
            default:
                procesaRut(request, response, boton);
                break;
        }

    }

    protected void procesaRut(HttpServletRequest request, HttpServletResponse response, String boton)
            throws ServletException, IOException {

        Persona p = this.service.buscar(boton);
        request.setAttribute("persona", p);
        request.getRequestDispatcher("editarPersonas.jsp").forward(request, response);

    }

    protected void registro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rut = request.getParameter("rut");
        String activo = request.getParameter("activo");

        this.service.editar(rut, activo.equalsIgnoreCase("si"));

        response.sendRedirect("personas.jsp");

    }

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rut = request.getParameter("rut");
        String clave = request.getParameter("clave");

        if (!rut.isEmpty() && !clave.isEmpty()) {

            Persona p = this.service.loguear(rut, clave);

            if (p == null) {
                request.setAttribute("msg", "Hubo un error al iniciar sesion :(");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else if (!p.isActivo()) {
                request.setAttribute("msg", "Usuario deshabilitado, consulte a su administrador :(");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else if (p.getPerfil().equalsIgnoreCase("admin")) {
                request.getSession().setAttribute("admin", p);
                request.getRequestDispatcher("inicio.jsp").forward(request, response);
            } else {
                request.getSession().setAttribute("person", p);
                request.getRequestDispatcher("inicio.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("msg", "Favor ingrese todos los campos");
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
