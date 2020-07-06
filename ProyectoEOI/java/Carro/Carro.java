package Carro;

public class Carro {
     String producto;
     double precio;
     String descripcion;
     String foto;

    public Carro(String producto, double precio, String descripcion){
	this.producto = producto;
	this.precio = precio;
        this.descripcion=descripcion;
    }

    public String getArticulo(){
        return producto;
    }
    
    public String getDescripcion(){
        return descripcion;
    }

    public double getPrecio(){
        return precio;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
}
