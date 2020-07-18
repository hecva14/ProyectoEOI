<%-- 
    Document   : KIDS
    Created on : 10 jul. 2020, 10:50:13
    Author     : Usuario
--%>

<%@page import="Carro.Carro"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Conexion.Conexion"%>
<%@page import="Producto.Producto"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/normalize.css" />
        <link rel="stylesheet" type="text/css" href="css/main.css" />
        <title>MUJER</title>
    </head>

 <body class="kids">
        <header class="header">
            <nav class="navegador">
                <div class="ropa">
                    <ul class="uluno">
                    <li class="liuno"><a href="index.html">Inicio</a></li>
                    <li class="liuno"><a href="MEN.jsp">Hombre</a></li>
                    <li class="liuno"><a href="WOMAN.jsp" name="mujer">Mujer</a></li>
                    <li class="liuno"><a href="KIDS.jsp">Niños</a></li>
                    <li class="liuno"><a href="#">Contacto</a></li>
                    <form class="form_kids" action="/ProyectoEOI/CarritoServletK" method="post">
                        <%
                           HttpSession sesion = request.getSession();
                           Integer contador=0;
                            if(sesion.getAttribute("contador")==null){
                             contador=0;
                         }else{
                           contador=(Integer)sesion.getAttribute("contador");
                         }
                      
                            %>
                    <li class="liuno"><a href="CARRO.jsp"><i>(<label style="color: gold"><%= contador%></label>)</i>CARRO</a></li>
                   </form>
                    <li class="lidos"><a href="login.html">LOG IN</a></li>
                    <li class="litres"><a href="registrar.html">Registrarse</a></li>
                    </ul>
                </div>
            </nav>
        </header>
    
          <h2><span>Seccion de Niños</span></h2>
          
          <form class="form_kids" action="/ProyectoEOI/KIDS.jsp" method="post">
              <% 
                  ArrayList<Producto> lista = new ArrayList();
                     Conexion con= new Conexion();
                  
			try {
				lista = con.consultarNiño();
				for (Producto producto : lista) {
					System.out.println(producto.toString());
				
              %>
                <div class="container2" style="text-align: center; padding-left: 600px;">
                  <div class="row">
                    
                          <div class="card" style="text-align: center;" >
                              <table>
                                  <tr>
                                     <td><h2><label  class="coltitulo"  class="subirformulario" ><% out.print(producto.getNombre());%></label></h2> </td>
                                 </tr>
                                  <tr>
                                      <td> <img src="/ProyectoEOI/ServletCarrito?id=<% out.print(producto.getIdproducto()) ;%>"align="center" width="250" height="200" ></td>
                                 </tr>
                                
                                 <tr>
                                     <td> <label  class="coltitulo"  class="subirformulario"  ><% out.print(producto.getDescripcion());%></label></td>
                                  <tr>
                                  <tr>
                                      <td><i class="colprecio"  class="subirformulario" ><h3><% out.print(producto.getPrecio());%>€</h3></i><a  class="colcarrito" href="/ProyectoEOI/CarritoServlet?parametro=<% out.print(producto.getIdproducto()) ;%>">enviar al carro</a></td>                                                 <td>
                                  </tr>
                               
                              </table>
                           </div>
                    </div>
             </div>
               
              
                     <%
                         
                      
                         
                   }
                            } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
                            }
              
                %>
    
          </form> 
       
       
         
  </body >
</html>
