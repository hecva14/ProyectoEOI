package web;

import Conexion.Conexion;
import Usuario.Usuario;
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/ServletRegistro")
public class Registrar  extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        String usuario=req.getParameter("nombre");
        String apellidos=req.getParameter("apellidos");
        
        String email=req.getParameter("email");
        String direccion=req.getParameter("direccion");
        String contrasena=req.getParameter("contrasena");
        //falta el rol
        
        Usuario user= new Usuario();
        Conexion con=new Conexion();
         user.setUsuario(usuario);
         user.setApellidos(apellidos);
         user.setEmail(email);
         user.setPassword(contrasena);
         user.setDireccion(direccion);
        
         System.out.println( user.toString());
         con.registrarUsuario(user);
        
    }
}