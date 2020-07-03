package Carro;

public class Carro {
     String producto;
     double precio;
     String descripcion;

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
}
