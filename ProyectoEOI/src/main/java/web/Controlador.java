/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;


import Conexion.Conexion;
import Producto.Producto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet("/ControladorCarrito")
public class Controlador extends HttpServlet {

    Conexion con= new Conexion();
    List<Producto> productos= new ArrayList<>();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
      String accion=request.getParameter("accion");
      Producto p= new Producto();
      switch(accion){
          case "AgregarCarrito":
                 int idp = Integer.parseInt(request.getParameter("id"));
                   p=con.listaId(idp);
                  break;
                  
          default:
              request.setAttribute("productos", productos);
	      response.sendRedirect("indice.html");
      }
      
      
      
        }
    }
