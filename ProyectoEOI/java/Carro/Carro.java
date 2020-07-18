package Carro;

public class Carro {
    int item;
    int idproducto;
    double precio;
    double precioTotal;
    int cantidad;
    String descripcion;
    String foto;
    String nombre;
     
     
      public Carro(){
           precioTotal();
       }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void precioTotal() {
       
        this.precioTotal =this.cantidad*this.precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
         this.descripcion=descripcion;
    }
    public double getPrecio(){
        return precio;
    }
    
    public void setPrecio(double precio){
         this.precio=precio;
    }
   
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Carro{" + "item=" + item + ", idproducto=" + idproducto + ", precio=" + precio + ", precioTotal=" + precioTotal + ", cantidad=" + cantidad + ", descripcion=" + descripcion + ", foto=" + foto + ", nombre=" + nombre + '}';
    }
    
}
