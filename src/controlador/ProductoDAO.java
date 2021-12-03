package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Producto;

public class ProductoDAO 
{
     public boolean ingresarProducto(Producto producto)
    {
        boolean resultado = false;
        try {
            Connection con = Conexion.getConexion();
            String query= "INSERT INTO PRODUCTO (id, nombre, tipoProducto, subTipoProducto, precio, cantidad) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, producto.getId());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getTipoProducto());
            ps.setString(4, producto.getSubTipoProducto());
            ps.setInt(5, producto.getPrecio());
            ps.setInt(6, producto.getCantidad());
            resultado = ps.executeUpdate() == 1;
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
     
    public Producto buscarProducto(String id)
    {
        Producto producto=null;
        try {
            Connection con = Conexion.getConexion();
            String query = "SELECT * FROM PRODUCTO WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
                producto = new Producto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return producto;
    }
    
    public boolean eliminarProducto(String id)
    {
        boolean resultado = false;
        try {
            Connection con = Conexion.getConexion();
            String query = "DELETE FROM PRODUCTO WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, id);
            resultado = ps.executeUpdate()==1;
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public boolean modificarProducto(Producto producto)
    {
        boolean resultado=false;
        try {
            Connection con = Conexion.getConexion();
            String query = "UPDATE PRODUCTO SET nombre = ?,tipoProducto = ?, subTipoProducto = ?, precio = ?, cantidad = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getTipoProducto());
            ps.setString(3, producto.getSubTipoProducto());
            ps.setInt(4, producto.getPrecio());
            ps.setInt(5, producto.getCantidad());
            ps.setString(6, producto.getId());
            resultado = ps.executeUpdate() == 1;
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public ArrayList<Producto> obtenerTodo()
    {
        ArrayList <Producto> productos = new ArrayList<Producto>();
        try {
            Connection con = Conexion.getConexion();
            String query = "SELECT * FROM PRODUCTO";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            Producto producto;
            while(rs.next())
            {
                producto = new Producto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
                productos.add(producto);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productos;
    }
}
