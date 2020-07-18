
package web;
import Usuario.Usuario;
import Conexion.Conexion;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet( "/ServletLogin")
public class ServletLogin extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
          String usuario=req.getParameter("user");
          String pass=req.getParameter("passwd");
          
          Usuario user= new Usuario();
          user.setUsuario(usuario);
          user.setPassword(pass);
          Conexion con= new Conexion();
           System.out.println("probando login");
       
        try {
            user.setRol(con.consultarLogin(user));
            if(user.getRol()==1 || user.getRol()==2){
                System.out.println("Usuario valido");
                HttpSession sesion = req.getSession();
                  sesion.setAttribute("numUsuario", user.getIdUsuario());
                System.out.println("rol"+user.getRol());
                 if(user.getRol()==1){
                  //redirigir a la pagina de admin
                   System.out.println("se ha registrado como admin");
                    res.sendRedirect("indiceAdmin.html");
              }else{
                     
                  //redirigir a la pagina de usuario
                  
	           res.sendRedirect("kids.html");
                 
              }
            }else{
                System.out.println("Usuario no valido o no tiene rol");
                res.sendRedirect("login.html");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
         
}
}