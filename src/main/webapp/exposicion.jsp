<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jakarta.servlet.http.*,jakarta.servlet.*, inmobiliaria.model.Cliente" %>
<% 
    Cliente usuario = null;
    if (session != null) {
        usuario = (Cliente) session.getAttribute("usuario");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Exposición</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/secondstyles.css">
    </head>
    <body class="body-funciones">
        <section class="form-exposicion">
            <h4>Registro de Inmueble</h4>
            
            <form action="exposicionServlet" method="POST">
            <h5>Tipo de inmueble</h5>
            <select name="tipos-inmueble" id="tipo-inmueble">
                <option value="casa">Casa</option>
                <option value="apartamento">Apartamento</option>
                <option value="estudio">Estudio</option>
                <option value="terreno">Terreno</option>
            </select><br> 
            
            <h5>Seleccione el país en el que se encuentra:</h5>
            <select name="pais-inmueble" id="pais-inmueble">
                <option value="colombia">Colombia</option>
            </select><br>
            
            <h5>Especifique en que ciudad se encuentra:</h5>
            <input type="text" name="ciudad" value="" placeholder="ciudad">
            
            <h5>Especifique el valor base por el que se venderá:</h5>
            <input type="number" name="valor-base" value="" placeholder="valor base">
            
            <button class="buttons-informe" id="button-exposicion">Registrar</button>
            </form>
    </body>
</html>
