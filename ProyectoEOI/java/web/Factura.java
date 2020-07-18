/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;


import Carro.Carro;
import Conexion.Conexion;
import Producto.Producto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Carro.Carro;
import Conexion.Conexion;
import Producto.Producto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

@WebServlet("/ServletGenerarFactura")
public class Factura {
    
     protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException, SQLException {
   
        try (PDDocument factura = new PDDocument()){
            PDPage pagina = new PDPage(PDRectangle.A6);
            factura.addPage(pagina);
            
            PDPageContentStream contentStream = new PDPageContentStream(factura, pagina);
            Carro car= new Carro();
            Conexion con=new Conexion();   
            Producto p2= new Producto();
            // Texto
            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_BOLD, 32);
            contentStream.newLineAtOffset( 20, pagina.getMediaBox().getHeight() - 52);
            
             HttpSession sesion = req.getSession();   
             List<Integer> id = (List<Integer>)sesion.getAttribute("idproductos");
               
             for(Integer id1:id){
              p2 = con.consultarProducto(id1);
            contentStream.showText(" " +car.getItem()+" "+ car.getIdproducto() + " " + car.getNombre() + " " + car.getDescripcion() + " "+ car.getPrecio()+" "            
                    +" "+ car.getPrecio());
             }
            contentStream.showText(" "+car.getPrecioTotal());
            contentStream.endText();

            // Imagen
            /*PDImageXObject image = PDImageXObject.createFromByteArray(factura, Factura.class.getResourceAsStream("/java.png").readAllBytes(), "Java Logo");
            contentStream.drawImage(image, 20, 20, image.getWidth() / 3, image.getHeight() / 3);*/

            contentStream.close();

            factura.save("factura.pdf");
        }
        
    }
    
}
