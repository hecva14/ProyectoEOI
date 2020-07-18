package Pedidos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Pedidos {
     int idPedido;
     int numPedido;
     int numUsuario;
     int numProducto;
     double Precio;
     int Cantidad;
     String Fecha;
     boolean Pagado;
     double Descuento;
	
    public Pedidos() {
		
	}

    public Pedidos(int idPedido, int numPedido, int numUsuario, int numProducto, double Precio, int Cantidad, String Fecha, boolean Pagado, double Descuento) {
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

    public int getNumPedido() {
        return numPedido;
    }

    public void numPedido() {
       Random r =new Random();
      this.numPedido=r.nextInt(999999);
		
    }
    
     public void setNumPedido(int numPedido) {
         this.numPedido=numPedido;
         
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
    
	
        /*
        public String getPedido(){
            return numPedido;
        }
        
        public void setPedido(String pedido){
            numPedido = pedido;
        }
*/
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
        
        public void Fecha(){
            String formato = "yyyy-MM-dd HH:mm:ss";
	DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);
	LocalDateTime ahora = LocalDateTime.now();
        this.Fecha=formateador.format(ahora);
	
        }
        
          public void setFecha(String fecha){
                 this.Fecha=fecha;
              
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

        
        
        
        
        public String fechaHoraActual() {
	String formato = "yyyy-MM-dd HH:mm:ss";
	DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);
	LocalDateTime ahora = LocalDateTime.now();
	return formateador.format(ahora);
}
    @Override
    public String toString() {
        return "Pedidos{" + "idPedido=" + idPedido + ", numPedido=" + numPedido + ", numUsuario=" + numUsuario + ", numProducto=" + numProducto + ", Precio=" + Precio + ", Cantidad=" + Cantidad + ", Fecha=" + Fecha + ", Pagado=" + Pagado + ", Descuento=" + Descuento + '}';
    }
	
   
}
