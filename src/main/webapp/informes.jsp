<%-- 
    Document   : informes
    Created on : 4/06/2024, 10:06:47 a. m.
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Informes</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/secondstyles.css">
    </head>
    <body id="body-informes">
        <section class="form-informes">
            <h4>Informes</h4>
            <h5>Ventas por:</h5>
            <select name="opciones-venta" id="informe-venta">
                <option value="fecha">Fecha</option>
                <option value="famoso">Usuario</option>
            </select><br> 
            <input class="inputs-informe" type="date" name="fecha-venta" id="fecha-venta-informe">
            <input class="inputs-informe" type="text" name="usuario" value="" placeholder="Id del usuario" id="usuario-venta">
            <h6>*Si escogio fecha llene el campo de fechas, si escogio usuario escriba el id del usuario</h6>
            <button class="buttons-informe" id="button-venta">Generar</button>
            
            <h5>Compra ventas por:</h5>
            <select name="opciones-compraventa" id="informe-compraventa">
                <option value="fecha">Fecha</option>
                <option value="famoso">Usuario</option>
            </select><br> 
            <input class="inputs-informe" type="date" name="fecha-compraventa" id="fecha-compraventa-informe">
            <input class="inputs-informe" type="text" name="usuario" value="" placeholder="Id del usuario" id="usuario-compraventa">
            <h6>*Si escogio fecha llene el campo de fechas, si escogio usuario escriba el id del usuario</h6>
            <button class="buttons-informe" id="button-compraventa">Generar</button>
            
            <h5>Valor comisiones</h5>
            <button class="buttons-informe" id="button-comision">Generar</button>
            
            <h5>Valor multas</h5>
            <button class="buttons-informe" id="button-multa">Generar</button>
            
            <h5>Valor impuestos en:</h5>
            <select name="opciones-impuestos" id="informe-impuestos">
                <option value="colombia">Colombia</option>
            </select>
            <button class="buttons-informe" id="button-impuesto">Generar</button>
        </section>
    </body>
</html>
