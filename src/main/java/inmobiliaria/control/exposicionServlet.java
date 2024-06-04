/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package inmobiliaria.control;

import inmobiliaria.DAO.PropiedadDAO;
import inmobiliaria.util.DBConnection;
import inmobiliaria.model.Propiedad;
import inmobiliaria.model.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;

/**
 *
 * @author User
 */
@WebServlet(name = "exposicionServlet", urlPatterns = {"/exposicionServlet"})
public class exposicionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tipo = request.getParameter("tipos-inmueble");
        String ciudad = request.getParameter("ciudad");
        String pais = request.getParameter("pais-inmueble");
        double valor = Double.parseDouble(request.getParameter("valor-base"));
        
        HttpSession session = request.getSession(false);
        Cliente usuario = null;
        if (session != null) {
            usuario = (Cliente) session.getAttribute("usuario");
        }
        
        Propiedad propiedad = new Propiedad(usuario.getId(), tipo, ciudad, pais, valor, new Date(), "Disponible");
        
        PropiedadDAO propiedadDAO = new PropiedadDAO();
        propiedadDAO.agregarPropiedad(propiedad);
        response.sendRedirect("main.jsp");
    }
}
