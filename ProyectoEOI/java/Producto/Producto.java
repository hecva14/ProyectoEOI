package Producto;

import java.io.InputStream;

public class Producto {
      int idproducto;
     String Producto;
     double Precio;
     String Descripcion;
     int Categoria;
     String Marca;
     String Modelo;
     String Referencia;
     int Stock;
     double Descuento;
     String foto;
     InputStream Imagen;
     String nombre;
	
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
          public void setImagen(InputStream Imagen) {
        this.Imagen=Imagen;
    }
          public int getIdproducto() {
              return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto=idproducto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto=foto;
    }
	
    @Override
	public String toString() {
		return "El Producto es " + nombre 
                        + ", su descripción es " + Descripcion +
                        ", su id es " + idproducto + 
			", su precio es " + Precio + 
			", pertenece a la categoría " + Categoria +
                        ", su marca es " + Marca +
                        ", su modelo es " + Modelo +
                        ".";
        }

  
    public InputStream getImagen(){
        return Imagen;
    }
    
}
