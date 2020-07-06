package web;

import Conexion.Conexion;
import Producto.Producto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletSubirProducto")
public class ServletSubirProducto extends HttpServlet {
    @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
     
     String articulo = req.getParameter("producto");
     String descripcion = req.getParameter("Descripcion");
     double precio = Double.parseDouble(req.getParameter("Precio"));
     int categoria = Integer.parseInt(req.getParameter("Categoria"));
     //Imagen
     String marca = req.getParameter("Marca");
     String modelo = req.getParameter("Modelo");
     String referencia = req.getParameter("Referencia");
     int stock = Integer.parseInt(req.getParameter("Stock"));
     double descuento = Integer.parseInt(req.getParameter("Descuento"));

     Producto producto = new Producto();
     producto.setProducto(articulo);
     producto.setDescripcion(descripcion);
     producto.setPrecio(precio);
     producto.setCategoria(categoria);
     //Imagen
     producto.setMarca(marca);
     producto.setModelo(modelo);
     producto.setReferencia(referencia);
     producto.setStock(stock);
     producto.setDescuento(descuento);
    
     Conexion conexion =new Conexion();
        
     System.out.println( producto.toString());
     conexion.registrarProducto(producto);
    
     }
    
}

