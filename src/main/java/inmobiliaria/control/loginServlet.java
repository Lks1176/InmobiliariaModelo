/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package inmobiliaria.control;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import inmobiliaria.util.DBConnection;
import inmobiliaria.model.Cliente;

/**
 *
 * @author User
 */
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("correo");
        String contraseña = request.getParameter("contrasena");
        
        //Validar los datos en la base de datos
        boolean valido = validarUsuario(email, contraseña);
        
        //Obtener los datos del usuario si es valido, y crear un objeto cliente para la sesion
        if (valido) {
            HttpSession session = request.getSession();
            String nombre = null, apellido = null, ciudad = null, telefono = null;
            int id = -1;
            
            ResultSet rs = obtenerDatosUsuario(email, contraseña);
            try {
                rs.next();
                id = rs.getInt("cliente_id");
                nombre = rs.getString("nombre");
                apellido = rs.getString("apellido");
                ciudad = rs.getString("ciudad");
                telefono = rs.getString("telefono");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            Cliente usuario = new Cliente(nombre, apellido, ciudad, telefono, email, contraseña);
            usuario.setId(id);
            session.setAttribute("usuario", usuario);
            response.sendRedirect("main.jsp?login=success");
        } else {
            response.sendRedirect("login.jsp?error=true");
        }
    }
    
    private boolean validarUsuario(String correo, String contrasena) {
        boolean valido = false;
        String query = "SELECT * FROM clientes WHERE email = ? AND contrasena = ?";
        
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);){
            statement.setString(1, correo);
            statement.setString(2, contrasena);
            ResultSet resultSet = statement.executeQuery();
            
            //Verificar que hay filas seleccionadas
            if (resultSet.next()) {
                valido = true;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return valido;
    }
    
    private ResultSet obtenerDatosUsuario(String correo, String contrasena) {
        String query = "SELECT * FROM clientes WHERE email = ? AND contrasena = ?";
        ResultSet rs = null;
        
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);){
            statement.setString(1, correo);
            statement.setString(2, contrasena);
            rs = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
