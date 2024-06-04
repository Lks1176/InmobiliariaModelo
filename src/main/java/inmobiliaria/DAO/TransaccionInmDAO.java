package inmobiliaria.DAO;

import java.sql.*;
import java.util.Date;
import inmobiliaria.util.DBConnection;
import inmobiliaria.model.TransaccionInm;
import inmobiliaria.control.obtencionValores;
import java.util.List;
import java.util.ArrayList;

public class TransaccionInmDAO {
    
    public boolean registrarTransaccionInm(int propiedadId, String tipoTransaccion, double valor, int clienteId) {
        String query = "INSERT INTO transaccionesinmobiliaria (propiedad_id, tipo_transaccion, cantidad, fecha_transaccion, cliente_id, comision, valor_multa, valor_impuesto) values (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            
            double comision = obtencionValores.obtenerComision(valor);
            double multa = 0;
            double impuesto = obtencionValores.obtenerImpuesto(valor);
        
            statement.setInt(1, propiedadId);
            statement.setString(2, tipoTransaccion);
            statement.setDouble(3, valor);
            statement.setDate(4, new java.sql.Date(new Date().getTime()));
            statement.setInt(5, clienteId);
            statement.setDouble(6, comision);
            statement.setDouble(6, multa);
            statement.setDouble(6, impuesto);
            
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
