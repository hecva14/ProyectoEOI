package web;

import Carro.Carro;
import java.io.IOException;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

    @WebServlet("/ServletCarrito")
public class ServletCarrito extends HttpServlet {
    @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
     HttpSession sesion = req.getSession();
     //???
     String articulo = req.getParameter("producto");
     Double precio = Double.parseDouble(req.getParameter("precio"));
     String descripcion = req.getParameter("descripcion");

     if (sesion.isNew()){
	 Vector carro = new Vector();
	 carro.addElement(new Carro(articulo, precio,descripcion));
	 sesion.setAttribute("miCarro", carro);
     } else {
	 Vector carro = (Vector)(sesion.getAttribute("miCarro"));
	 carro.addElement(new Carro(articulo, precio,descripcion));
	 sesion.setAttribute("miCarro", carro);
        }
     }
    
}
    
