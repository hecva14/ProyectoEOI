
package web;

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
import javax.servlet.http.*;

    @WebServlet("/ServletCarrito")
public class ControladorImg extends HttpServlet {
        Conexion con= new Conexion();
          List<Producto> productos= new ArrayList<>();
    @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
         
         
     }
         
    @Override
     protected void doGet( HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
         int id=Integer.parseInt(req.getParameter("id"));
            try {
                con.listarImagen(id, res);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorImg.class.getName()).log(Level.SEVERE, null, ex);
            }
         
         
     }
   
    
}
   
