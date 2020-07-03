package Conexion;

import Producto.Producto;
import Usuario.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
    private Connection getConnection() throws SQLException {
       
        String url = "jdbc:mysql://localhost:3306/proyectoeoi?useSSL=false&serverTimezone=UTC";
	String user = "root";
	String pass = "CyanDolphins55";
	
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de MySQL: " + ex);
        }
        
	return DriverManager.getConnection(url, user, pass);
	}
    
    public boolean createUsuario(Usuario usuario) {
	String insertQuery = "INSERT INTO usuarios(usuario, password, telefono_movil, telefono_secundario, email) VALUES (?, ?, ?, ?, ?)";
	Connection con = null;
	PreparedStatement stmt = null;
	int rows = 0;
            try {
                con = getConnection();
                stmt = con.prepareStatement(insertQuery);
		stmt.setString(1, usuario.getUsuario());
                stmt.setString(2, usuario.getPassword());
                stmt.setInt(3, 666666666);
                stmt.setInt(4, 666666666);
                stmt.setString(5, usuario.getEmail());
                
                System.out.println(usuario.getUsuario() + usuario.getPassword() + usuario.getEmail());
                
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
public Usuario consultarLogin(String nombre, String passw) throws SQLException {
	    Connection con=null;

	    Usuario user=null;
	    String quary="SELECT rol FROM user WHERE nombre=? and pass=?";
	    con=getConnection();
	    PreparedStatement statement = con.prepareStatement(quary);
            statement.setString(1, nombre);
            statement.setString(2, passw);
	    ResultSet rs = statement.executeQuery();

	    while (rs.next()) {
	    	user=new Usuario(rs.getInt("rol"));
              
                System.out.println("el rol de este usuario es: "+user);
	         
	    }     
		return user;
	}
     
     
     
      public boolean registrarProducto(Producto producto) {
	String insertQuery = "INSERT INTO producto(producto,descripcion, precio, categoria, marca,  modelo,stock,referencia,descuento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	Connection con = null;
	PreparedStatement stmt = null;
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
                System.out.println("Ejecutando la query: " + insertQuery);
				
		rows = stmt.executeUpdate();
                System.out.println("Registros afectados: " + rows);
				
		stmt.close();
                con.close();
				
		return true;
				
				
	    } catch (SQLException e) {
		return false;
        }
        
            
    }
      
}
