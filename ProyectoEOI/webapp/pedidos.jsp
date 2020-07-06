<%-- 
    Document   : pedidos
    Created on : 2 jul. 2020, 18:45:58
    Author     : Usuario
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="Conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Pedidos.Pedidos"
import="Producto.Producto"
import="Usuario.Usuario"
import="java.io.IOException"
import="java.sql.SQLException"
import="java.util.ArrayList"
import="java.util.List"
import="javax.servlet.ServletException"
import="javax.servlet.annotation.WebServlet"
import="javax.servlet.http.HttpServlet"
import="javax.servlet.http.HttpServletRequest"
import="javax.servlet.http.HttpServletResponse"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="css/main.css" />
    <title>indice Administrador</title>
</head>
    <body class="login">
        <header class="header">
            <nav class="navegador">
                <div class="ropa">
                    <ul class="uluno">
                    <li class="liuno"><a href="index.html">Inicio</a></li>
                    <li class="liuno"><a href="#">Hombre</a></li>
                    <li class="liuno"><a href="#">Mujer</a></li>
                    <li class="liuno"><a href="kids.html">Niños</a></li>
                    <li class="liuno"><a href="#">Contacto</a></li>
                    <li class="lidos"><a href="login.html">LOG IN</a></li>
                    <li class="litres"><a href="registrar.html">Registrarse</a></li>
                    </ul>
                </div>
            </nav>
        </header>
            <div class="container">
              <div class="forma_top">
               <h2><span>Consultar Pedido</span></h2>
                <form class="form_registro" action="/ProyectoEOI/pedidos.jsp" method="post"> 
                   Ingrese pedido: <input  type="text" class="input"  name="pedido"> 
                  <br>
                 <input  type="submit" name="Mostrarpedido" value="Mostrar pedidos"> 
                 <br>
                  <table>
	           <tr>
			<td>numPedido</td>
                        <td>numUsuario</td>
                        <td>numProducto</td>
			<td>Cantidad</td>
			<td>precio</td>
			<td>Fecha</td>
			<td>Pagado</td>
			<td>Descuento</td>
		  </tr>
		  <%    
                    String idpedido=request.getParameter("pedido");
        
                           System.out.println("holaaaa");
                           System.out.println(idpedido);
                     if(idpedido!=null){
                         System.out.println("holaaaa22");
                           Conexion con=new Conexion();
                           ArrayList<Pedidos>  pedidos=new ArrayList();
           
			    try {
				pedidos=con.consultarPedido(idpedido);
                                System.out.println("holaaaa33");
				for (Pedidos pedido : pedidos) {
                                 %>
                                 <tr> 
                                    
                                     <td><% out.print(pedido.getNumPedido());%></td>
                                      <td><% out.print(pedido.getNumUsuario());%></td>
                                      <td><% out.print(pedido.getNumProducto()); %></td>
			              <td><% out.print(pedido.getCantidad());%></td>
			              <td><% out.print(pedido.getPrecio());%></td>
			              <td><% out.print(pedido.getFecha());%></td>
			              <td><% out.print(pedido.getPagado());%></td>
			              <td><% out.print(pedido.getDescuento());%></td>
                                </tr> 
                                <%
                                System.out.println(pedido.toString());
				}

				
                            } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
                            }
                     }
     
                         %>
	</table>
             <br>
             <br>
            <a class="hyper" href="indiceAdmin.html">Indice Administrador</a>
                        
        </form>
        </div>
       </div> 
      
    </body>
</html>
