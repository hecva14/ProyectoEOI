package Usuario;

public class Usuario {
    private String Usuario;
    private String Apellidos;
    private String Password;
    private String Email;
    private int Telefono;
    private int Telefono2;
    private int Rol;
    private String Direccion;
	
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
	
	public String toString() {
		return "El Usuario se llama " + Usuario 
                        + ", su contraseña es " + Password +
			", su email es " + Email + 
			" y su teléfono es " + Telefono
                        + ". Su teléfono secundario es " + Telefono2; 
        }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }
    
}
