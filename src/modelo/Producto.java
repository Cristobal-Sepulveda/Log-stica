package modelo;

public class Producto {
    private String codigo;
    private String nombre;
    private String tipoProducto;
    private String subTipoProducto;
    private int precio;

    public Producto(String codigo, String nombre, String tipoProducto, String subTipoProducto, int precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipoProducto = tipoProducto;
        this.subTipoProducto = subTipoProducto;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
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

    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
