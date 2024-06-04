<%-- 
    Document   : login
    Created on : 4/06/2024, 10:08:28 a. m.
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/secondstyles.css">
    </head>
    <body id="body-login">
        <section class="form-login">
            <h5>Login</h5>
            <form action="loginServlet" method="POST">
                <input class="controls" type="email" name="correo" placeholder="correo" required>
                <input class="controls" type="password" name="contrasena" placeholder="contraseña" required>
                <input class="buttons" type="submit" name="boton" value="Ingresar" id="button-login">
            </form>
        </section>
    </body>
</html>

