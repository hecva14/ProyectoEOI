package Producto;

public class Producto {
    private String Producto;
    private double Precio;
    private String Descripcion;
    private int Categoria;
    private String Marca;
    private String Modelo;
    private String Referencia;
    private int Stock;
    private double Descuento;
	
    public Producto() {
		
	}
    
	public Producto(String producto, double precio, String descripcion, int categoria,
                String marca, String modelo, String referencia, int stock, double descuento) {
                Producto = producto;
		Precio = precio;
		Descripcion = descripcion;
		Categoria = categoria;
		Marca = marca;
                Modelo = modelo;
                Referencia = referencia;
                Stock = stock;
                Descuento = descuento;
	}
        
        public String getProducto(){
            return Producto;
        }
        
        public void setProducto(String producto){
            Producto = producto;
        }

	public double getPrecio(){
		return Precio;
	}
	
	public void setPrecio(double precio) {
	    Precio = precio;
	}
	
	public String getDescripcion(){
		return Descripcion;
	}
	
	public void setDescripcion(String descripcion) {
	    Descripcion = descripcion;
	}
        
        public int getCategoria(){
            return Categoria;
        }
        
        public void setCategoria(int categoria){
            Categoria = categoria;
        }
        
        public String getMarca(){
            return Marca;
        }
        
        public void setMarca(String marca){
            Marca = marca;
        }
        
        public String getModelo(){
            return Modelo;
        }
        
        public void setModelo(String modelo){
            Modelo = modelo;
        }
        
        public String getReferencia(){
            return Referencia;
        }
        
        public void setReferencia(String referencia){
            Referencia = referencia;
        }
        
        public int getStock(){
            return Stock;
        }
        
        public void setStock(int stock){
            Stock = stock;
        }
        
        public double getDescuento(){
            return Descuento;
        }
        
        public void setDescuento(double descuento){
            Descuento = descuento;
        }
	
	public String toString() {
		return "El Producto es " + Producto 
                        + ", su descripción es " + Descripcion +
			", su precio es " + Precio + 
			", pertenece a la categoría " + Categoria +
                        ", su marca es " + Marca +
                        ", su modelo es " + Modelo +
                        ", su referencia es " + Referencia; 
        }
    
}
