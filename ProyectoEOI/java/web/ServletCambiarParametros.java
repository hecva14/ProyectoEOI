package web;

import Conexion.Conexion;
import Usuario.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCambiarParametros extends HttpServlet {
    @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
     
     String newPassword = req.getParameter("NewPassword");
     int rol = Integer.parseInt(req.getParameter("Rol"));

     Conexion conexion = new Conexion();
     
     if (newPassword == null && rol > 1){
         conexion.cambiarRol(rol, req);
     } else if (rol == 0 && newPassword != null){
         conexion.cambiarPassword(newPassword, req);
     }

     }
    
}