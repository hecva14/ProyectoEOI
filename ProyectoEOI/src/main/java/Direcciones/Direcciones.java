package Direcciones;

public class Direcciones {
    private String Direccion;
    private String Poblacion;
    private String Provincia;
    private int CP;
	
    public Direcciones() {
		
	}
    
	public Direcciones(String direccion, String poblacion, String provincia, int cp){
		Direccion = direccion;
		Poblacion = poblacion;
		Provincia = provincia;
		CP = cp;
                
	}

	public String getDireccion(){
		return Direccion;
	}
	
	public void setDireccion(String direccion) {
	    Direccion = direccion;
	}
	
	public String getPoblacion(){
		return Poblacion;
	}
	
	public void setPoblacion(String poblacion) {
	    Poblacion = poblacion;
	}
        
        public String getProvincia(){
            return Provincia;
        }
        
        public void setProvincia(String provincia){
            Provincia = provincia;
        }
        
        public int getCP(){
            return CP;
        }
        
        public void setCP(int cp){
            CP = cp;
        }
	
	public String toString() {
		return "La Dirección es " + Direccion 
                        + ", " + Poblacion +
			", " + CP + 
			", " + Provincia;
        }
}
