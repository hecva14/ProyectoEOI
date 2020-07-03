package Usuario;

public class Usuario {
     String Usuario;
     String Apellidos;
     String Password;
     String Email;
     int Telefono;
     int Telefono2;
     int Rol;
     String Direccion;
     int idUsuario;
	
    public Usuario() {
		
	}
        
        public Usuario(int rol){
            Rol = rol;
        }
        
        public Usuario(String direccion){
            Direccion = direccion;
        }
        
	public Usuario(String apellidos, String direccion, String usuario, String password, String email, int telefono, int telefono2, int rol) {
		Usuario = usuario;
		Password = password;
		Email = email;
		Telefono = telefono;
                Telefono2 = telefono2;
                Rol = rol;
                Direccion = direccion;
                Apellidos = apellidos;
	}

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

        
	public String getUsuario(){
		return Usuario;
        }
	
	public void setUsuario(String usuario) {
	    Usuario = usuario;
	}
	
	public String getPassword(){
		return Password;
	}
	
	public void setPassword(String password) {
	    Password = password;
	}
        
        public String getEmail(){
            return Email;
        }
        
        public void setEmail(String email){
            Email = email;
        }
        
        public int getTelefono(){
            return Telefono;
        }
        
        public void setTelefono(int telefono){
            Telefono = telefono;
        }
        
        public int getTelefono2(){
            return Telefono2;
        }
        
        public void setTelefono2(int telefono2){
            Telefono2 = telefono2;
        }
        
        public int getRol(){
            return Rol;
        }
        
        public void setRol(int rol){
            Rol = rol;
        }
	
	

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getApellidos() {
       return Apellidos;
    }

    public String getDireccion() {
       return Direccion;
    }

    @Override
    public String toString() {
        return "Usuario{" + "Usuario=" + Usuario + ", Apellidos=" + Apellidos + ", Password=" + Password + ", Email=" + Email + ", Telefono=" + Telefono + ", Telefono2=" + Telefono2 + ", Rol=" + Rol + ", Direccion=" + Direccion + ", idUsuario=" + idUsuario + '}';
    }
    
    
}
