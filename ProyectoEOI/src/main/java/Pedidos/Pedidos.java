package Pedidos;

public class Pedidos {
     int idPedido;
     String numPedido;
     int numUsuario;
     int numProducto;
     double Precio;
     int Cantidad;
     String Fecha;
     boolean Pagado;
     double Descuento;
	
    public Pedidos() {
		
	}

    public Pedidos(int idPedido, String numPedido, int numUsuario, int numProducto, double Precio, int Cantidad, String Fecha, boolean Pagado, double Descuento) {
        this.idPedido = idPedido;
        this.numPedido = numPedido;
        this.numUsuario = numUsuario;
        this.numProducto = numProducto;
        this.Precio = Precio;
        this.Cantidad = Cantidad;
        this.Fecha = Fecha;
        this.Pagado = Pagado;
        this.Descuento = Descuento;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(String numPedido) {
        this.numPedido = numPedido;
    }

    public int getNumUsuario() {
        return numUsuario;
    }

    public void setNumUsuario(int numUsuario) {
        this.numUsuario = numUsuario;
    }

    public int getNumProducto() {
        return numProducto;
    }

    public void setNumProducto(int numProducto) {
        this.numProducto = numProducto;
    }
    
	
        
        public String getPedido(){
            return numPedido;
        }
        
        public void setPedido(String pedido){
            numPedido = pedido;
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

    @Override
    public String toString() {
        return "Pedidos{" + "idPedido=" + idPedido + ", numPedido=" + numPedido + ", numUsuario=" + numUsuario + ", numProducto=" + numProducto + ", Precio=" + Precio + ", Cantidad=" + Cantidad + ", Fecha=" + Fecha + ", Pagado=" + Pagado + ", Descuento=" + Descuento + '}';
    }
	
   
}
