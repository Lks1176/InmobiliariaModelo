<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jakarta.servlet.http.*,jakarta.servlet.*, inmobiliaria.model.Cliente, inmobiliaria.model.*, java.util.List, inmobiliaria.DAO.*, java.text.DecimalFormat" %>
<% 
    Cliente usuario = null;
    if (session != null) {
        usuario = (Cliente) session.getAttribute("usuario");
    }
    
    DecimalFormat df = new DecimalFormat("#,###.00");
    
    PropiedadDAO propiedadDAO = new PropiedadDAO();
    List<Propiedad> propiedades = propiedadDAO.obtenerPropiedadesPorUsuario(usuario.getId());

%>
<!DOCTYPE html>
<html>
    <head>
        <title>Adquisiciones</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/secondstyles.css">
    </head>
    <body class="body-funciones">
        <section class="form-adquisicion">
            <h4>Compra de Inmueble</h4>
            <form>
            <h5>Lista de inmuebles disponibles:</h5>
            <select name="opciones-disponibilidad" id="inmuebles-disponibles">
                <% if (!propiedades.isEmpty()) { %>
                    <% for (Propiedad propiedad : propiedades) { %>
                        <option value="<%= propiedad.getTipo()%> - <%= propiedad.getCiudad()%> - <%= propiedad.getValor()%>"><%= propiedad.getTipo()%> - <%= propiedad.getCiudad()%> - <%= df.format(propiedad.getValor())%></option>
                    <% } %>
                <% } %>
            </select><br> 
            
            <h5>Elija en que va a pagar:</h5>
            <select name="opciones-venta" id="moneda-pago">
                <option value="dolares">Dolares</option>
                <option value="euros">Euros</option>
                <option value="pesos">Pesos</option>
            </select><br> 
            
            <button class="buttons-informe" id="button-adquisicion">Comprar</button>
            </form>
        </section>
    </body>
</html>
