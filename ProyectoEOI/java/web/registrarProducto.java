
package web;

import Conexion.Conexion;
import Producto.Producto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/ServletSubirProducto")
public class registrarProducto extends HttpServlet {
    
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        
        String descrp= req.getParameter("descripcion");
        Double precio = Double.parseDouble(req.getParameter("precio"));
        int categoria = Integer.parseInt(req.getParameter("categoria"));
        String marca= req.getParameter("marca");
        String modelo= req.getParameter("modelo");
        int stock = Integer.parseInt(req.getParameter("stock"));
        Double descuento = Double.parseDouble(req.getParameter("descuento"));
        String referencia = req.getParameter("refenrecia");
        String ruta= req.getParameter("ruta");
       
        Conexion con= new Conexion();
        Producto producto= new Producto();
        // actualizar precio
         producto.setProducto(modelo);
         producto.setDescripcion(descrp);
         producto.setPrecio(precio);
         producto.setCategoria(categoria);
         producto.setMarca(marca);
         producto.setStock(stock);
         producto.setReferencia(referencia);
         producto.setDescuento(descuento);
         producto.setFoto(ruta);
        
         System.out.println( producto.toString());
         
           boolean resp = con.registrarProducto(producto);
            if(resp){
                 System.out.println("producto subido con exito");
                res.sendRedirect("indiceAdmin.html");
            }else{
                System.out.println("producto no subido");
                res.sendRedirect("subirproducto.html");
            }
        
        
    
    }
}