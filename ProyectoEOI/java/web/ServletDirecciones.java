package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet( "/ServletDirecciones")
public class ServletDirecciones extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        int edit = Integer.parseInt(req.getParameter("Edit"));
        int add = Integer.parseInt(req.getParameter("Add"));
       
        if(edit == 1 && edit == 0){
            //redirigir a la pagina de admin
            res.sendRedirect("editarDireccion.html");
        }else if (add == 1 && edit == 0){
            //redirigir a la pagina de usuario
            res.sendRedirect("nuevaDireccion");
        }
            
    }
    
}
