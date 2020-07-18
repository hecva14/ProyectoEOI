/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import Carro.Carro;
import Conexion.Conexion;
import Producto.Producto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 @WebServlet("/CarritoServletK")
public class CarritoServletK extends HttpServlet{
    
     
 @Override
 protected void doGet( HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
     
         Integer id=Integer.parseInt(req.getParameter("parametro"));
         System.out.println(id);
              
         HttpSession sesion = req.getSession();
       
        //recuperamos la lista de articulos agregados previamente si existen
        List<Integer> idproductos = (List<Integer>)sesion.getAttribute("idproductos");
          Integer cont=(Integer) sesion.getAttribute("contador");
        if(cont==null){
            cont=1;
             sesion.setAttribute("contador", cont);
        }else{
            cont++;
             sesion.setAttribute("contador", cont);
        }
         res.sendRedirect("KIDS.jsp");
         
         
         
        //verificamos si la lista de articulos existe
        if (idproductos == null){
            //inicializamos la lista de articulos
            idproductos = new ArrayList();
              idproductos.add(id);
            sesion.setAttribute("idproductos", idproductos);
        }else{
            idproductos.add(id);
            sesion.setAttribute("idproductos", idproductos);
        }
        
      
        System.out.println("carro id: " + id);
                
       
        
         int cant=1;
           try {
              cant = Integer.parseInt(req.getParameter("cantidad"));
               System.out.println("cant: "+cant);
           } catch(NumberFormatException ex) {
	     // out.println("el dato no es numerico");
           }
                      int item=0;
                       
                    Conexion con=new Conexion();   
                    Producto p= new Producto();
		    Carro carrito= new Carro();
                    List<Carro> carro=new ArrayList();
                    
        try {
                    p=con.consultarProducto(id);
                    item=item+1;
                    carrito.setItem(item);
                    carrito.setIdproducto(p.getIdproducto());
                    carrito.setNombre(p.getNombre());
                    carrito.setDescripcion(p.getDescripcion());
                    carrito.setCantidad(cant);
                    carrito.setPrecio(p.getPrecio());
                    //carrito.setPrecioTotal(cant*p2.getPrecio());
                    System.out.println("carro completo " + carrito.toString());
                    carro.add(carrito);
                    req.setAttribute("carrito", carro);
                    //res.sendRedirect("CARRO.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(CarritoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
               
 }
     
     
}
