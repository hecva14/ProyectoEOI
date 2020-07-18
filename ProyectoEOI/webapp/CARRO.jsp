<%-- 
    Document   : CARRO
    Created on : 4 jul. 2020, 20:13:32
    Author     : Usuario
--%>





<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="web.CarritoServlet"%>
<%@page import="com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.*;"%>
<%@page import="Carro.Carro"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <body>
        
    </body>
</html>
 <body class="carro">
        <header class="header">
            <nav class="navegador">
                <div class="ropa">
                    <ul class="uluno">
                    <li class="liuno"><a href="index.jsp">Inicio</a></li>
                    <li class="liuno"><a href="MEN.jsp">Hombre</a></li>
                    <li class="liuno"><a href="WOMAN.jsp">Mujer</a></li>
                    <li class="liuno"><a href="KIDS.jsp">Niños</a></li>
                    <li class="liuno"><a href="#">Contacto</a></li>
                    <%-- <li class="liuno"><a href="CARRO.jsp"><i class="fas fa-cart-plus">(<label style="color: gold"><% out.print("numero") ;%></label>)</i>CARRO</a></li>--%>
                    <li class="lidos"><a href="login.html">LOG IN</a></li>
                    <li class="litres"><a href="registroUsuario.jsp">Registrarse</a></li>
                    </ul>
                </div>
            </nav>
        </header>
     <div class="containerall ">
        
         <br>
         <h1 class="tituloTabla" style="color: blueviolet;">Productos guardados en cesta</h1>
            <form class="form_carrito" action="/ProyectoEOI/CARRO.jsp" method="post"> 
                <div class="left">
                  <table class="tabla">
                      
	           <tr>
                       <th>&nbsp;ITEM&nbsp;</th>
                        <th>&nbsp;idProducto&nbsp;</th>
                        <th>&nbsp;Nombre&nbsp;</th>
                        <th>&nbsp;Descripcion&nbsp;</th>
                        <th>&nbsp;Precio(€)&nbsp;</th>
			<th>&nbsp;Cantidad&nbsp;</th>
			<th>&nbsp;Precio total(€)&nbsp;</th>
		  </tr>
                  <tbody>
                      <%
                             HttpSession sesion = request.getSession();
                            
                            List<Integer> id = (List<Integer>)sesion.getAttribute("idproductos");
             
                      int item=0;
                      boolean filaProdcuto=true;
                    Conexion con=new Conexion();   
                    Producto p2= new Producto();
		   Carro car= new Carro();
                    //List<Carro> carrito=new ArrayList();
                  double totalPagar=0.0;
        try {
            for(Integer id1:id){
                
                //nos aseguramos que no se repita el mismo producto en la tabla del carro
               for(int i=1;i<=id.size();i++){
                   if(id1.equals(id)){
                        filaProdcuto=false;
                   }
               }
               
               if(filaProdcuto==true){
                item = item + 1;
                p2 = con.consultarProducto(id1);
                
                int cant = 0;
                int cantidadPedido=0;
                String inputName = "cantidad" + String.valueOf(item);
              
                try{
                    cant = Integer.parseInt(request.getParameter(inputName));
                } catch(NumberFormatException ex){
                    cant = 0;
                }
                System.out.println("cant: "+cant);
               
                car.setItem(item);
                car.setIdproducto(p2.getIdproducto());
                car.setNombre(p2.getNombre());
                car.setDescripcion(p2.getDescripcion());
                car.setCantidad(cant);
                car.setPrecio(p2.getPrecio());
                car.precioTotal();
                totalPagar=totalPagar + car.getPrecioTotal();
                sesion.setAttribute("totalPagar", totalPagar);
                cantidadPedido=cantidadPedido+car.getCantidad();
                System.out.println("carro completo " + car.toString());
           
                %>
                <tr>
                   <td  align="center"><% out.print(car.getItem());%></td>
                   <td  align="center"><% out.print(car.getIdproducto());%></td>
                   <td  align="center"><% out.print(car.getNombre());%></td>
                   <td  align="center"><% out.print(car.getDescripcion());%></td>
                   <td  align="center"><% out.print(car.getPrecio());%></td>
                         
                   <td  align="center" ><input type="text" name="<% out.print(inputName); %>" value="<% out.print(car.getCantidad()); %>" size="4"
                              onkeydown="function(event){if(event.keyCode===13) {document.getElementById('sendForm').click();}}">
                             
                   </td>
                   <td  align="center"><% out.print(car.getPrecioTotal());%></td>
                </tr>
                           <%
                               //metodo que va restando los productos en stock que hay en la base de datos
                              
                               con.cambiarStock(cant,id1);
                               
                               sesion.setAttribute("cantidadPedido", cantidadPedido);
                               
                               }              
            }
                    //res.sendRedirect("CARRO.jsp");
                   } catch (SQLException ex) {
            Logger.getLogger(CarritoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
               

                          %>
              
                </tbody>
                 
            </table>
            <input style="display:none;" id="sendForm" type="submit" value="Actualizar">
            
            </div>
                    <div class="PrecioTotal">
                        <h2>Total a Pagar</h2>
                        <input value="<% out.print(totalPagar); %>" type="text" name="pagoTotal" size="3">€<br><br>
                        <a href="/ProyectoEOI/ServletGenerarPedido">Generar pedido</a><br>
                        <a href="/ProyectoEOI/ServletGenerarFactura">Generar Factura</a>
                    </div>
         </form>
  </div>      
                  
 </body >
</html>
   
           
                            