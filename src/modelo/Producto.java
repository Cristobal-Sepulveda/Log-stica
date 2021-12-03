package modelo;

public class Producto {
    private String id;
    private String nombre;
    private String tipoProducto;
    private String subTipoProducto;
    private int precio;
    private int cantidad;
    

    public Producto(String id, String nombre, String tipoProducto, String subTipoProducto, int precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.tipoProducto = tipoProducto;
        this.subTipoProducto = subTipoProducto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getTipoProducto() {
        return tipoProducto;
    }
    public String getSubTipoProducto() {
        return subTipoProducto;
    }
    public int getPrecio() {
        return precio;
    }
    public int getCantidad(){
        return cantidad;
    }

    
    public void setId(String id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    public void setSubTipoProducto(String subTipoProducto) {
        this.subTipoProducto = subTipoProducto;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
    
    public int descuentoCodigo(int codigo, Producto producto){
        if(codigo == 123456){
            int aux = (int)(producto.getPrecio()*0.75);
            producto.setPrecio(aux);
            return 1;
        }
        return 0;
    }
    
    public void restauraPrecio(Producto producto){
        int aux = (int)((producto.getPrecio()/75)*100);
        producto.setPrecio(aux);          
    }
}
