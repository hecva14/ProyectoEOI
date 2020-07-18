package web;

import Conexion.Conexion;
import Direcciones.Direcciones;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletEditarDireccion")
public class ServletEditarDireccion extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String direccion = request.getParameter("Direccion");
        String poblacion = request.getParameter("Poblacion");
        String provincia = request.getParameter("Provincia");
        int cp = Integer.parseInt(request.getParameter("CP"));
        
        Direcciones nuevaDireccion = new Direcciones();
        nuevaDireccion.setDireccion(direccion);
        nuevaDireccion.setPoblacion(poblacion);
        nuevaDireccion.setProvincia(provincia);
        nuevaDireccion.setCP(cp);
        
        Conexion conexion = new Conexion();
        conexion.editarDireccion(nuevaDireccion, request);
    }
    
}
