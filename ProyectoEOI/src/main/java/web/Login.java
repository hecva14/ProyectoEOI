
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

@WebServlet( "/ServletLogin")
public class Login extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
          String usuario=req.getParameter("user");
          String pass=req.getParameter("passwd");
          
          Usuario user= new Usuario();
          Conexion con= new Conexion();
          
       
        try {
            user=con.consultarLogin(usuario, pass);
            if(user!=null){
                System.out.println("Usuario valido");
                 if(user.equals("admin")){
                  //redirigir a la pagina de admin
                    res.sendRedirect("pagina");
              }else{
                  //redirigir a la pagina de usuario
                  
	           res.sendRedirect("pagina");
                 
              }
            }else{
                System.out.println("Usuario no valido");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
         
}
    
    
}
