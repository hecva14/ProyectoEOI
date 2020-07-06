/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import Conexion.Conexion;
import Pedidos.Pedidos;
import Producto.Producto;
import Usuario.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/ServletPedidos")
public class ServletPedidos extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        String idpedido=req.getParameter("pedido");
        
        System.out.println("holaaaa");
        
     
         Conexion con=new Conexion();
         ArrayList<Pedidos>  pedidos=new ArrayList();
           
			try {
				pedidos=con.consultarPedido(idpedido);
				for (Pedidos pedido : pedidos) {
					System.out.println(pedido.toString());
				}

				req.setAttribute("pedidos", pedidos);
				//res.sendRedirect("indiceAdmin.html");
             } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
             }
         }
}