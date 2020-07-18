package Conexion;

import Direcciones.Direcciones;
import Pedidos.Pedidos;
import Producto.Producto;
import Usuario.Usuario;
import java.util.List;
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
       
        String url = "jdbc:mysql://localhost:3306/proyectoeoi?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
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
	String insertQuery = "INSERT INTO usuario(nombre, apellidos,contrasena,email ,direccion,rol) VALUES (?, ?, ?, ?, ?,2)";
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

	    Usuario user=new Usuario();
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
             pedido.setNumPedido(rs.getInt(2));
             pedido.setNumUsuario(rs.getInt(3));
           
             pedido.setCantidad(rs.getInt(4));
             pedido.setPrecio(rs.getDouble(5));
             pedido.setDescuento(rs.getDouble(6));
             pedido.setFecha(rs.getString(7));
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
        
       // File imagen=new File(producto.getFoto());
       // FileInputStream fis=new FileInputStream(imagen);
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
                stmt.setBlob(10, producto.getImagen());
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
      
      public Producto listaProducto(int id) throws SQLException{
          
            Connection con=null;
            
	    con=getConnection();
           
            //List<Producto> listaProductos= new ArrayList<>();
                  Producto  producto= new Producto();
                  String sql="select * from producto where idproducto=?";
	          PreparedStatement statement = con.prepareStatement(sql);
                  statement.setInt(1,id);
	          ResultSet rs = statement.executeQuery();

	    while (rs.next()) {
	    	
                producto.setIdproducto(rs.getInt("idproducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble(3));
                producto.setCategoria(rs.getInt(4));
                producto.setMarca(rs.getString(5));
                producto.setModelo(rs.getString(6));
                producto.setStock(rs.getInt(7));
                producto.setDescuento(rs.getDouble(8));
                producto.setImagen(rs.getBinaryStream(9));
                 producto.setNombre(rs.getString(10));
                
                System.out.println("metodo: "+producto.toString());
	        
	    }     
		return producto;
      }
      
      
      
      
      
      public Producto consultarProducto( int id) throws SQLException{
            String quary="SELECT * FROM producto where idproducto=? ";
          Connection con=null;
           
          //List<Producto>prod=new ArrayList();
	  
	 
          Producto producto=null;
	    con=getConnection();
	    PreparedStatement statement = con.prepareStatement(quary);
             statement.setInt(1,id);
	    ResultSet rs = statement.executeQuery();

	    while (rs.next()) {
	    	producto=new Producto();
                producto.setIdproducto(rs.getInt("idproducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                
                 System.out.println("Producto seleccionado: "+producto.toString());
	    }   
                rs.close();
		statement.close();
                con.close();
		return producto;
      }
      
       public ArrayList consultarProductos() throws SQLException{
            String quary="SELECT * FROM producto";
          Connection con=null;
           
          ArrayList<Producto> prod = new ArrayList();
	  
	 
          Producto producto=null;
	  con=getConnection();
	  PreparedStatement statement = con.prepareStatement(quary);
	  ResultSet rs = statement.executeQuery();

	    while (rs.next()) {
	    	producto=new Producto();
                producto.setIdproducto(rs.getInt("idproducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                prod.add(producto);
                System.out.println("Producto seleccionado: "+producto.toString());
	    }   
                rs.close();
		statement.close();
                con.close();
		return prod;
      }
      
      public void listarImagen(int id,HttpServletResponse response) throws IOException, SQLException{
           Connection con=null;
          String sql="select foto from producto where idproducto=?";
          
          InputStream inputStream=null;
          OutputStream  outputStream=null;
          BufferedInputStream buferedInput=null;
           BufferedOutputStream buferedOutput=null;
         try{
               outputStream=response.getOutputStream();
                con=getConnection();
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setInt(1,id);
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
                
           }catch(IOException | SQLException e){
               
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
                 producto.setNombre(rs.getString(10));      
                lista.add(producto);
                
                System.out.println(producto);
	         
	    }     
		return lista;
      }
      public ArrayList consultarMujer() throws SQLException{
          Connection con=null;
            Producto producto=null;
            ArrayList lista=new ArrayList();
	  
	    String quary="SELECT * FROM producto where categoria=2";
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
                producto.setNombre(rs.getString(10));
                       
                lista.add(producto);
                
                System.out.println(producto.toString());
	         
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
                 producto.setNombre(rs.getString(10));      
                lista.add(producto);
                
                System.out.println(producto);
	         
	    }     
		return lista;
      }
 public boolean cambiarRol(int rol, HttpServletRequest req) {
        Connection con=null;
        
        HttpSession session = req.getSession();
        String usuario = (String) session.getAttribute("user");
	String updateQuery="UPDATE rol FROM usuario WHERE usuario=?";
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
    
    public boolean crearDireccion(Direcciones direccion, HttpServletRequest request){
        String insertQuery = "UPDATE dirección, poblacion, provincia, codigo postal FROM direcciones WHERE usuarios=?";
	Connection con = null;
	PreparedStatement stmt = null;
	int rows = 0;
        HttpSession sesion = request.getSession();
        String usuario = (String) sesion.getAttribute("user");
        
            try {
                con = getConnection();
                stmt = con.prepareStatement(insertQuery);
                stmt.setString(1, direccion.getDireccion());
                stmt.setString(2, direccion.getPoblacion());
                stmt.setString(3, direccion.getProvincia());
                stmt.setInt(4, direccion.getCP());
                stmt.setString(5, usuario);
                
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
    
    public boolean editarDireccion(Direcciones direccion, HttpServletRequest request){
        String updateQuery = "INSERT INTO direcciones(id_usuario, dirección, poblacion, provincia, codigo postal) VALUES (?, ?, ?, ?, ?)";
	Connection con = null;
	PreparedStatement stmt = null;
	int rows = 0;
        HttpSession sesion = request.getSession();
        String usuario = (String) sesion.getAttribute("user");
        
            try {
                con = getConnection();
                stmt = con.prepareStatement(updateQuery);
		stmt.setString(1, usuario);
                stmt.setString(2, direccion.getDireccion());
                stmt.setString(3, direccion.getPoblacion());
                stmt.setString(4, direccion.getProvincia());
                stmt.setInt(5, direccion.getCP());
                
                System.out.println("Ejecutando la query: " + updateQuery);
				
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
    //actualiza el stock del producto en la base de datos
    public void cambiarStock(int cantidad, int id) throws SQLException{
         Connection con=null;
         Producto producto=null;
         
          int rows=0;
	  int StockTabla=0;
          int nuevoStock=0;
             
          String quary="SELECT stock FROM producto where idproducto="+id;
          con = getConnection();
	  PreparedStatement stmt = con.prepareStatement(quary);
         // stmt.setInt(1, id);
	  System.out.println("quary1"+quary);
	  ResultSet rs = stmt.executeQuery();
         
	    while (rs.next()) {
	    	StockTabla=rs.getInt("stock");
               
            }
	   //tStock(rs.getInt(7)); 
            nuevoStock= StockTabla-cantidad;
            System.out.println("nuevoStock: "+nuevoStock);
          
                String quary2="UPDATE producto SET stock="+nuevoStock+" where idproducto="+id;
            PreparedStatement stmt2 = con.prepareStatement(quary2);
          
              try {
                con = getConnection();
               // stmt2.setInt(1, nuevoStock);
             
                System.out.println("Ejecutando la query2: " + quary2);	
		rows = stmt2.executeUpdate();
                System.out.println("Registros afectados: " + rows);
				
		stmt.close();
                con.close();
                
              } catch (SQLException e) {
		e.printStackTrace();
              }
    }
    
     public boolean registrarPedido(Pedidos pedido) throws SQLException {
	//String insertQuery = "INSERT INTO pedidos(idpedidos, numPedido,usuario,cantidadTotal ,precioTotal,descuento,fechaPedido,pagado) VALUES (?, ?, ?, ?, ?,?,?,?)";
	String insertQuery = "UPDATE * from pedidos";
        Connection con = null;
	PreparedStatement stmt = null;
	int rows = 0;
            try {
                con = getConnection();
                stmt = con.prepareStatement(insertQuery);
		stmt.setInt(1, pedido.getIdPedido());
                stmt.setInt(2, pedido.getNumPedido());
                stmt.setInt(3, pedido.getNumUsuario());
                stmt.setInt(4, pedido.getCantidad());
                stmt.setDouble(5, pedido.getPrecio());
                stmt.setDouble(6,pedido.getDescuento() );
                stmt.setString(7, pedido.getFecha());
               
                System.out.println(pedido.toString());
                System.out.println("Ejecutando la query de registro de pedidos: " + insertQuery);
	        System.out.println("stmt "+stmt.executeUpdate(insertQuery));
		rows = stmt.executeUpdate(insertQuery);
                System.out.println("Registros afectados en el registro de pedidos: " + rows);
				
		stmt.close();
                con.close();
                		
		return true;
                 } catch (SQLException e) {
              }
            		
		return true;
            }   

     
     public FileInputStream guardaImagen(String ruta) throws SQLException, FileNotFoundException{
        //Creamos una cadena para después prepararla
        File imagen = new File(ruta);
        //ruta puede ser: "/home/cmop/Desktop/1.jpg"
        FileInputStream fis = new FileInputStream(imagen);
        return fis;
        //Lo convertimos en un Stream
}
}