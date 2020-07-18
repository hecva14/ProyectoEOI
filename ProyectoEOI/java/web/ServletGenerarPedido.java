/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import Conexion.Conexion;
import Pedidos.Pedidos;

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
import java.lang.Double.*;




@WebServlet("/ServletGenerarPedido")
public class ServletGenerarPedido extends HttpServlet{
    
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
         
         try {
             HttpSession sesion = req.getSession();
             Pedidos pedido= new Pedidos();
             // System.out.println("pago total delsevlet"+req.getParameter("pagoTotal"));
             double precio=(Double)sesion.getAttribute("totalPagar");
             int cantidad=(Integer)sesion.getAttribute("cantidadPedido");
             int idUsuario;
             if(sesion.getAttribute("numUsuario") == null){
                 idUsuario=0;
             }else{
                 idUsuario=(Integer)sesion.getAttribute("numUsuario");
             }
             
             
             int   item=2;
             item++;
             Conexion con=new Conexion();
             pedido.setIdPedido(item);
             pedido.numPedido();
             pedido.setNumUsuario(idUsuario);
             pedido.setCantidad(cantidad);
             pedido.setPrecio(precio);
             pedido.Fecha();
             pedido.setDescuento(0);
             
             System.out.println( pedido.toString());
             
             con.registrarPedido(pedido);
             
            
             res.sendRedirect("CARRO.jsp");
         } catch (SQLException ex) {
             Logger.getLogger(ServletGenerarPedido.class.getName()).log(Level.SEVERE, null, ex);
         }
             
             
             
        
    }
    
     
}
