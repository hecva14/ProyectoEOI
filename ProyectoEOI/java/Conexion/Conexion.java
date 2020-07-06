package Conexion;

import Pedidos.Pedidos;
import Producto.Producto;
import Usuario.Usuario;
import java.awt.List;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Decoder;


public class Conexion {
    private Connection getConnection() throws SQLException {
       
        String url = "jdbc:mysql://localhost:3306/proyectoeoi?useSSL=false&serverTimezone=UTC";
	String user = "root";
	String pass = "Admin1234";
	
        try{
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de MySQL: " + ex);
            }
        
	return DriverManager.getConnection(url, user, pass);
	}
    
    public boolean createUsuario(Usuario usuario) {
	String insertQuery = "INSERT INTO usuario(nombre, apellidos,contraseña,email ,direccion) VALUES (?, ?, ?, ?, ?)";
	Connection con = null;
	PreparedStatement stmt = null;
	int rows = 0;
            try {
                con = getConnection();
                stmt = con.prepareStatement(insertQuery);
		stmt.setString(1, usuario.getUsuario());
                stmt.setString(2, usuario.getApellidos());
                stmt.setString(3, usuario.getPassword());
                stmt.setString(4, usuario.getEmail());
                stmt.setString(5, usuario.getDireccion());
                
                System.out.println("Ejecutando la query: " + insertQuery);
				
		rows = stmt.executeUpdate();
                System.out.println("Registros afectados: " + rows);
				
		stmt.close();
                con.close();
				
		return true;
				
				
	    } catch (SQLException e) {
		e.printStackTrace();
		return false;
        }
        
            
    }
public int consultarLogin(Usuario usuario) throws SQLException {
	    Connection con=null;
            
            Usuario user = new Usuario();

	    String quary="SELECT rol FROM usuario WHERE nombre=? and contrasena=?";
	    con=getConnection();
	    PreparedStatement statement = con.prepareStatement(quary);
            statement.setString(1, usuario.getUsuario());
            statement.setString(2, usuario.getPassword());
	    ResultSet rs = statement.executeQuery();

	    while (rs.next()) {
	    	
                user.setRol(rs.getInt("rol"));
                System.out.println("el rol de este usuario es: "+user.getRol());
	         
	    }     
                rs.close();
		statement.close();
                con.close();
                return user.getRol();
	}
     
     
   public ArrayList consultarPedido(String id) throws SQLException{
            Connection con=null;
           
	    Pedidos pedido=null;
	    String quary="SELECT * FROM pedidos WHERE numPedido=?";
	    con=getConnection();
	    PreparedStatement statement = con.prepareStatement(quary);
            statement.setString(1,id);
            ArrayList lista=new ArrayList();
	    ResultSet rs = statement.executeQuery();

	    while (rs.next()) {
	    	pedido=new Pedidos();
             pedido.setNumPedido(rs.getString(2));
             pedido.setNumUsuario(rs.getInt(3));
             pedido.setNumProducto(rs.getInt(4));
             pedido.setCantidad(rs.getInt(5));
             pedido.setPrecio(rs.getDouble(6));
             pedido.setDescuento(rs.getDouble(7));
             pedido.setFecha(rs.getString(8));
             pedido.setPagado(true);
             System.out.println(pedido.toString());
	         lista.add(pedido);
	    }     
		return lista;
   }
     
      public boolean registrarProducto(Producto producto) throws FileNotFoundException {
	
          boolean resp=false;
          String insertQuery = "INSERT INTO producto(producto,descripcion, precio, categoria, marca,  modelo,stock,referencia,descuento,foto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	Connection con = null;
	PreparedStatement stmt = null;
        
        File imagen=new File(producto.getFoto());
        FileInputStream fis=new FileInputStream(imagen);
	int rows = 0;
            try {
                con = getConnection();
                stmt = con.prepareStatement(insertQuery);
		stmt.setString(1, producto.getProducto());
                stmt.setString(2, producto.getDescripcion());
                stmt.setDouble(3, producto.getPrecio());
                stmt.setInt(4, producto.getCategoria());
                stmt.setString(5,producto.getMarca());
                stmt.setString(6,producto.getModelo());
                stmt.setInt(7,producto.getStock());
                stmt.setString(8,producto.getReferencia());
                stmt.setDouble(9,producto.getDescuento());
                stmt.setBlob(10, fis, (int) imagen.length());
                System.out.println("Ejecutando la query: " + insertQuery);
		
           
		rows = stmt.executeUpdate();
                if(rows==1){
                    resp=true;
                    System.out.println("Registros afectados: " + rows);
                }else{
                    resp=false;
                }
                
				
		stmt.close();
                con.close();
				
		
				
				
	    } catch (SQLException e) {
		System.out.println(e);
        }
        return resp;
            
    }
      
      public Producto listaId(int id) throws SQLException{
           String sql="select * from productos where idproducto="+id;
             Connection con=null;
            Producto producto=null;
          
	    con=getConnection();
	    PreparedStatement statement = con.prepareStatement(sql);
	    ResultSet rs = statement.executeQuery();

	    while (rs.next()) {
	    	 producto=new Producto();
                producto.setIdproducto(rs.getInt(1));
                producto.setDescripcion(rs.getString(2));
                producto.setPrecio(rs.getDouble(3));
                producto.setCategoria(rs.getInt(4));
                producto.setMarca(rs.getString(5));
                producto.setModelo(rs.getString(6));
                producto.setStock(rs.getInt(7));
                producto.setDescuento(rs.getDouble(8));
                producto.setImagen(rs.getBinaryStream(9));
                System.out.println(producto);
	         
	    }     
		return producto;
      }
      
      
      
      
      
      public ArrayList consultarProducto() throws SQLException{
            String quary="SELECT * FROM producto ";
          Connection con=null;
            Producto producto=null;
            ArrayList lista=new ArrayList();
	  
	  
	    con=getConnection();
	    PreparedStatement statement = con.prepareStatement(quary);
           
	    ResultSet rs = statement.executeQuery();

	    while (rs.next()) {
	    	 producto=new Producto();
                 producto.setIdproducto(rs.getInt(1));
                producto.setDescripcion(rs.getString(2));
                producto.setPrecio(rs.getDouble(3));
                producto.setCategoria(rs.getInt(4));
                producto.setMarca(rs.getString(5));
                producto.setModelo(rs.getString(6));
                producto.setStock(rs.getInt(7));
                producto.setDescuento(rs.getDouble(8));
                producto.setImagen(rs.getBinaryStream(9));
                        
                lista.add(producto);
                
                System.out.println(producto);
	         
	    }     
		return lista;
      }
      
      public void listarImagen(int id,HttpServletResponse response) throws IOException, SQLException{
           Connection con=null;
          String sql="select * from productos where idproducto="+id;
          InputStream inputStream=null;
          OutputStream  outputStream=null;
          BufferedInputStream buferedInput=null;
           BufferedOutputStream buferedOutput=null;
         try{
               outputStream=response.getOutputStream();
                con=getConnection();
                PreparedStatement statement = con.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
                if(rs.next()){
                    inputStream=rs.getBinaryStream("foto");
                }
                buferedInput= new BufferedInputStream(inputStream);
                buferedOutput= new BufferedOutputStream(outputStream);
                
                int i=0;
                while((i=buferedInput.read())!=-1){
                        buferedOutput.write(i);
         }
                
           }catch(Exception e){
               
           }
      }
      
       public ArrayList consultarNiño() throws SQLException{
          Connection con=null;
            Producto producto=null;
            ArrayList lista=new ArrayList();
	  
	    String quary="SELECT * FROM producto where categoria=1 ";
	    con=getConnection();
	    PreparedStatement statement = con.prepareStatement(quary);
           
	    ResultSet rs = statement.executeQuery();

	    while (rs.next()) {
	    	 producto=new Producto();
                 producto.setIdproducto(rs.getInt(1));
                producto.setDescripcion(rs.getString(2));
                producto.setPrecio(rs.getDouble(3));
                producto.setCategoria(rs.getInt(4));
                producto.setMarca(rs.getString(5));
                producto.setModelo(rs.getString(6));
                producto.setStock(rs.getInt(7));
                producto.setDescuento(rs.getDouble(8));
                producto.setImagen(rs.getBinaryStream(9));
                       
                lista.add(producto);
                
                System.out.println(producto);
	         
	    }     
		return lista;
      }
      public ArrayList consultarMujer() throws SQLException{
          Connection con=null;
            Producto producto=null;
            ArrayList lista=new ArrayList();
	  
	    String quary="SELECT * FROM producto where categoria=2 ";
	    con=getConnection();
	    PreparedStatement statement = con.prepareStatement(quary);
           
	    ResultSet rs = statement.executeQuery();

	    while (rs.next()) {
	    	 producto=new Producto();
                 producto.setIdproducto(rs.getInt(1));
                producto.setDescripcion(rs.getString(2));
                producto.setPrecio(rs.getDouble(3));
                producto.setCategoria(rs.getInt(4));
                producto.setMarca(rs.getString(5));
                producto.setModelo(rs.getString(6));
                producto.setStock(rs.getInt(7));
                producto.setDescuento(rs.getDouble(8));
                producto.setImagen(rs.getBinaryStream(9));
                       
                lista.add(producto);
                
                System.out.println(producto);
	         
	    }     
		return lista;
      }
      public ArrayList consultarHombre() throws SQLException{
          Connection con=null;
            Producto producto=null;
            ArrayList lista=new ArrayList();
	  
	    String quary="SELECT * FROM producto where categoria=3 ";
	    con=getConnection();
	    PreparedStatement statement = con.prepareStatement(quary);
           
	    ResultSet rs = statement.executeQuery();

	    while (rs.next()) {
	    	 producto=new Producto();
                 producto.setIdproducto(rs.getInt(1));
                producto.setDescripcion(rs.getString(2));
                producto.setPrecio(rs.getDouble(3));
                producto.setCategoria(rs.getInt(4));
                producto.setMarca(rs.getString(5));
                producto.setModelo(rs.getString(6));
                producto.setStock(rs.getInt(7));
                producto.setDescuento(rs.getDouble(8));
                producto.setImagen(rs.getBinaryStream(9));
                       
                lista.add(producto);
                
                System.out.println(producto);
	         
	    }     
		return lista;
      }

    public boolean cambiarRol(int rol, HttpServletRequest req) {
        Connection con=null;
        
        HttpSession session = req.getSession();
        String usuario = (String) session.getAttribute("user");
	String updateQuery="UPDATE rol FROM usuarios WHERE usuario=?";
        int rows = 0;
	
        try {
            con=getConnection();
            PreparedStatement statement = con.prepareStatement(updateQuery);
            statement.setInt(1, rol);
            statement.setString(2, usuario);
	    ResultSet rs = statement.executeQuery();
            
            System.out.println("Ejecutando la query: " + updateQuery);
				
	    rows = statement.executeUpdate();
            System.out.println("Registros afectados: " + rows);
				
	    statement.close();
            con.close();
				
	    return true;
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
    }

    public boolean cambiarPassword(String newPassword, HttpServletRequest req) {
        Connection con=null;
        
        HttpSession session = req.getSession();
        String usuario = (String) session.getAttribute("user");
	String updateQuery="UPDATE password FROM usuarios WHERE usuario=?";
        int rows = 0;
	
        try {
            con=getConnection();
            PreparedStatement statement = con.prepareStatement(updateQuery);
            statement.setString(1, newPassword);
            statement.setString(2, usuario);
	    ResultSet rs = statement.executeQuery();
            
            System.out.println("Ejecutando la query: " + updateQuery);
				
	    rows = statement.executeUpdate();
            System.out.println("Registros afectados: " + rows);
				
	    statement.close();
            con.close();
				
	    return true;
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
    }
}