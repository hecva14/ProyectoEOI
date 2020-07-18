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
    <title>Consulta Pedidos</title>
</head>
    <body class="login">
        <header class="header">
            <nav class="navegador">
                <div class="ropa">
                    <ul class="uluno">
                    <li class="liuno"><a href="index.html">Inicio</a></li>
                     <li class="liuno"><a href="MEN.jsp">Hombre</a></li>
                    <li class="liuno"><a href="WOMAN.jsp" name="mujer">Mujer</a></li>
                    <li class="liuno"><a href="KIDS.jsp">Niños</a></li>
                    <li class="liuno"><a href="#">Contacto</a></li>
                    <li class="lidos"><a href="login.html">LOG IN</a></li>
                    <li class="litres"><a href="registrar.html">Registrarse</a></li>
                    </ul>
                </div>
            </nav>
        </header>
             <div class="containerall ">
        
         <br>
         <h1 class="tituloTabla" style="color: blueviolet;">Consultar Pedidos</h1>
                <form class="form_registro" action="/ProyectoEOI/pedidos.jsp" method="post"> 
                   Ingrese pedido: <input  type="text"  name="pedido" style='width:70px; height:25px'> 
                  <br>
                 <input  type="submit" name="Mostrarpedido" value="Mostrar pedidos" style='width:70px; height:25px'> 
                 <br>
                   <div class="left">
                  <table class="tabla">
	           <tr>
			<td>&nbsp;numPedido&nbsp;</td>
                        <td>&nbsp;numUsuario&nbsp;</td>
			<td>&nbsp;Cantidad&nbsp;</td>
			<td>&nbsp;precio&nbsp;</td>
			<td>&nbsp;&nbsp;Fecha&nbsp;&nbsp;</td>
			<td>&nbsp;Pagado&nbsp;</td>
			<td>&nbsp;Descuento&nbsp;</td>
		  </tr>
		  <%    
                    String idpedido=request.getParameter("pedido");
        
                           System.out.println("holaaaa");
                           System.out.println(idpedido);
                     if(idpedido!=null){
                       
                           Conexion con=new Conexion();
                           ArrayList<Pedidos>  pedidos=new ArrayList();
           
			    try {
				pedidos=con.consultarPedido(idpedido);
                               
				for (Pedidos pedido : pedidos) {
                                 %>
                                 <tr> 
                                    
                                     <td><% out.print(pedido.getNumPedido());%></td>
                                      <td><% out.print(pedido.getNumUsuario());%></td>
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
           </div>          
        </form>
        </div>
       </div> 
      
    </body>
</html>
