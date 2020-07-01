package Pedidos;

public class Pedidos {
    private String Pedido;
    private double Precio;
    private int Cantidad;
    private String Fecha;
    private boolean Pagado;
    private double Descuento;
	
    public Pedidos() {
		
	}
    
	public Pedidos(String pedido, double precio, int cantidad,
                String fecha, boolean pagado, double descuento) {
                Pedido = pedido;
		Precio = precio;
		Cantidad = cantidad;
		Fecha = fecha;
		Pagado = pagado;
                Descuento = descuento;
	}
        
        public String getPedido(){
            return Pedido;
        }
        
        public void setPedido(String pedido){
            Pedido = pedido;
        }

	public double getPrecio(){
		return Precio;
	}
	
	public void setPrecio(double precio) {
	    Precio = precio;
	}
	
	public int getCantidad(){
		return Cantidad;
	}
	
	public void setCantidad(int cantidad) {
	    Cantidad = cantidad;
	}
        
        public String getFecha(){
            return Fecha;
        }
        
        public void setFecha(String fecha){
            Fecha = fecha;
        }
        
        public boolean getPagado(){
            return Pagado;
        }
        
        public void setPagado(boolean pagado){
            Pagado = pagado;
        }
        
        public double getDescuento(){
            return Descuento;
        }
        
        public void setDescuento(double descuento){
            Descuento = descuento;
        }
	
	public String toString() {
		return "El número de Pedido es " + Pedido +
			", su precio es " + Precio + 
			", se realizo el día " + Fecha +
                        " y su estado Pagado es " + Pagado; 
        }
}
