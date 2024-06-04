package inmobiliaria.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import inmobiliaria.model.*;
import inmobiliaria.util.DBConnection;

public class PropiedadDAO {
    
    public Propiedad obtenerPropiedadPorId(int propiedadId) {
        String query = "SELECT * FROM propiedades WHERE propiedad_id = ?";
        Propiedad propiedad = null;
        
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, propiedadId);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                int id = resultSet.getInt("propiedad_id");
                int usuarioId = resultSet.getInt("cliente_id");
                String tipoProp = resultSet.getString("tipo_propiedad");
                String ciudad = resultSet.getString("ciudad");
                String pais = resultSet.getString("pais");
                double valor = resultSet.getDouble("valor");
                Date fechaReg = resultSet.getDate("fecha_registro");
                String estado = resultSet.getString("estado"); 
                
                propiedad = new Propiedad(usuarioId, tipoProp, ciudad, pais, valor, fechaReg, estado);
                propiedad.setPropiedadId(id);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return propiedad;
    }
    
    public List<Propiedad> obtenerPropiedadesPorUsuario(int usuarioId) {
        List<Propiedad> propiedades = new ArrayList<>();
        String query = "SELECT * FROM propiedades WHERE cliente_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
             
            statement.setInt(1, usuarioId);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                int id = resultSet.getInt("propiedad_id");
                String tipoProp = resultSet.getString("tipo_propiedad");
                String ciudad = resultSet.getString("ciudad");
                String pais = resultSet.getString("pais");
                double valor = resultSet.getDouble("valor");
                Date fechaReg = resultSet.getDate("fecha_registro");
                String estado = resultSet.getString("estado");

                Propiedad propiedad = new Propiedad(usuarioId, tipoProp, ciudad, pais, valor, fechaReg, estado);
                propiedad.setPropiedadId(id);

                if (propiedad != null) {
                    propiedades.add(propiedad);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return propiedades;
    }
    
    public boolean actualizarPropiedad(Propiedad propiedad) {
        String query = "UPDATE propiedades SET estado = ? WHERE propiedad_id = ?";
        
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
             
            statement.setString(1, propiedad.getEstado());
            statement.setInt(2, propiedad.getPropiedadId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
    }

    public boolean agregarPropiedad(Propiedad propiedad) {
        String query = "INSERT INTO propiedades (propiedad_id, cliente_id, tipo_propiedad, ciudad, pais, valor, fecha_registro, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
             
            statement.setInt(1, propiedad.getPropiedadId());
            statement.setInt(2, propiedad.getClienteId());
            statement.setString(3, propiedad.getTipo());
            statement.setString(4, propiedad.getCiudad());
            statement.setString(5, propiedad.getPais());
            statement.setDouble(6, propiedad.getValor());
            statement.setDate(7, new java.sql.Date(propiedad.getFechaApertura().getTime()));
            statement.setString(8, propiedad.getEstado());
            

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
