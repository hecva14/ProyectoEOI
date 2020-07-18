<%-- 
    Document   : Index
    Created on : 15 jul. 2020, 11:13:06
    Author     : Usuario
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="Conexion.Conexion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Producto.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/normalize.css" />
        <link rel="stylesheet" type="text/css" href="css/main.css" />
        <title>INICIO</title>
    </head>
    <body class="index" >
        <header class="header">
            <nav class="navegador">
                <div class="ropa">
                    <ul class="uluno">
                    <li class="liuno"><a href="index.jsp">Inicio</a></li>
                   <li class="liuno"><a href="MEN.jsp">Hombre</a></li>
                    <li class="liuno"><a href="WOMAN.jsp" name="mujer">Mujer</a></li>
                    <li class="liuno"><a href="KIDS.jsp">Niños</a></li>
                    <li class="liuno"><a href="#">Contacto</a></li>
                    <li class="lidos"><a href="login.html" name="Login">LOG IN</a></li>
                    <li class="litres"><a href="registroUsuario.jsp" name="Registrar">Registrarse</a></li>
                    </ul>
                </div>
            </nav>
        </header>
        <br> <br> <br> <br> <br>
       <%-- <div class="containerall "> --%>
    <tabla>
             <% 
                  ArrayList<Producto> lista = new ArrayList();
                     Conexion con= new Conexion();
                  
			try {
				lista = con.consultarProductos();
				for (Producto producto : lista) {
					System.out.println(producto.toString());
				
              %>
              
            <!-- class="subirformulario"-->
                       <div class="container2" style="text-align: center;"> 
                               <h2><label  class="coltitulo" class="subirformulario" >&nbsp;&nbsp;<% out.print(producto.getNombre());%></label></h2>
                               <img src="/ProyectoEOI/ServletCarrito?id=<% out.print(producto.getIdproducto()) ;%>" align="center" width="250" height="200"><br>
                               <label  class="coltitulo" class="subirformulario" style="padding-right:0px"><% out.print(producto.getDescripcion());%></label>
                               <i class="colprecio" class="subirformulario"><h3>&nbsp;&nbsp;&nbsp;&nbsp;<% out.print(producto.getPrecio());%>€</h3></i>&nbsp;&nbsp;<a  class="colcarrito" href="/ProyectoEOI/CarritoServlet?parametro=<% out.print(producto.getIdproducto()) ;%>">enviar al carro</a>                                                                       
                       </div>
                       <br> <br> 
        
                            
          
              
               <%
                
                   }
                            } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
                            }
              
                %>
    
     <%--   </div>  --%>
   </tabla>     
    </body>
</html >
