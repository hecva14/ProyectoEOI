
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
public class ServletSubirProducto extends HttpServlet {
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String registro=req.getParameter("SUBIR");
        
        String nombre=req.getParameter("Nombre");
        String descrp= req.getParameter("Descripcion");
        System.out.println("Precio del producto nuevo"+req.getParameter("precio2"));
        
        double precio =Double.parseDouble( req.getParameter("precio2"));
        int categoria = Integer.parseInt(req.getParameter("Categoria"));
        String marca= req.getParameter("Marca");
        String modelo= req.getParameter("Modelo");
        int stock = Integer.parseInt(req.getParameter("Stock"));
        Double descuento = Double.parseDouble(req.getParameter("Descuento"));
        String referencia = req.getParameter("Refenrecia");
        String ruta= req.getParameter("Imagen");
       
        Conexion con= new Conexion();
        Producto producto= new Producto();
       
         producto.setNombre(nombre);
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
         if(registro!=null){
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
}