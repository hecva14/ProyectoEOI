<%-- 
    Document   : registroUsuario
    Created on : 15 jul. 2020, 11:02:29
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="css/main.css" />
    <title>REGISTRO</title>
</head>
<body class="registrar">
     <header class="header">
            <nav class="navegador">
                <div class="ropa">
                    <ul class="uluno">
                    <li class="liuno"><a href="index.html">Inicio</a></li>
                    <li class="liuno"><a href="men.html">Hombre</a></li>
                    <li class="liuno"><a href="WOMAN.jsp">Mujer</a></li>
                    <li class="liuno"><a href="kids.html">Niños</a></li>
                    <li class="liuno"><a href="#">Contacto</a></li>
                      <%-- <li class="liuno"><a href="CARRO.jsp"><i class="fas fa-cart-plus">(<label style="color: gold"><% out.print("numero") ;%></label>)</i>CARRO</a></li>--%>
                    <li class="lidos"><a href="login.html">LOG IN</a></li>
                    <li class="litres"><a href="registrar.html">Registrarse</a></li>
                    </ul>
                </div>
            </nav>
        </header>
    <div class="container">
        <div class="forma_top">
            <h2><span>Registro</span></h2>
        </div>
        <form class="form_registro" name="formularioRegistro" action="/ProyectoEOI/ServletRegistro" method="post"> 
            <input class="input" type="text" name="nombre" placeholder="&#128100;
            Nombre" required autofocus> 
            <input class="input" type="text" name="apellidos"  placeholder="&#128100;
            Apellidos" required> 
            <input class="input" type="email" name="email" placeholder="&#9993;
            Email" required>    
            <input class="input" type="password" name="contrasena" placeholder="&#128273;
            Contraseña" required>   
            <input class="input" type="text" name="direccion"  placeholder="&#8962;
            Direccion" required>
            <a class="hyper" href="login.html">Iniciar Sesion</a>
            <div class="boton_formulario">
                <input class="boton_submit" type="submit" type="submit" value="REGISTRAR">
            </div>              
        </form>
    </div>
</body>
</html>