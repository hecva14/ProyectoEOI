
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

@WebServlet( "/ServletCarro")
public class Carrito extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
      //creamos el objeto sesion
     HttpSession sesion = req.getSession();

     
     //recuperamos la lista de ariculos agregados previamente
 List<String> articulos=(List<String>) sesion.getAttribute("articulos");
    
 //verificamos si la lista de articulos existe
 if(articulos==null){
     articulos= new ArrayList<>();
     sesion.setAttribute("articulos", articulos);
 }

//seleccionamos el articulo que queremos
 String articuloNuevo = req.getParameter("articulo");
 
 
 //revisamos  y agregamos el nuevo articulo
 if(articuloNuevo!=null){
     articulos.add(articuloNuevo);
 }
        PrintWriter out= res.getWriter();
        out.print("lista de articulos");
        //itenermaos todos los pruductos
        for(String articulo:articulos){
             out.print("<li>"+articulo+"</li>");
        }
 
 
  
   
    
}
}
 
    

/*  if (req.getParameter("submit").equals("mujer")) {

			ProductoDAO productoDAO = new ProductoDAO();
			List<Producto> lista = new ArrayList<>();
			try {
				lista = productoDAO.obtenerProductos();
				for (Producto producto : lista) {
					System.out.println(producto);
				}

				request.setAttribute("lista", lista);
				res.sendRedirect("pagina");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/