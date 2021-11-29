package modelo;

public class Producto {
    private String id;
    private String nombre;
    private String tipoProducto;
    private String subTipoProducto;
    private int precio;

    public Producto(String id, String nombre, String tipoProducto, String subTipoProducto, int precio) {
        this.id = id;
        this.nombre = nombre;
        this.tipoProducto = tipoProducto;
        this.subTipoProducto = subTipoProducto;
        this.precio = precio;
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
        
}
