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
        boolean resultado=false;
        try {
            Connection con= Conexion.getConexion();
            String query= "INSERT INTO PRODUCTO (codigo, nombre, tipoProducto, subTipoProducto, Precio) VALUES (?,?,?,?,?)";
            PreparedStatement ps= con.prepareStatement(query);
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getTipoProducto());
            ps.setString(4, producto.getSubTipoProducto());
            ps.setInt(5, producto.getPrecio());
            resultado= ps.executeUpdate() == 1;
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
     
    public Producto buscarProducto(String codigo)
    {
        Producto producto=null;
        try {
            Connection con= Conexion.getConexion();
            String query= "SELECT * FROM PRODUCTO WHERE codigo = ?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, codigo);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
                producto= new Producto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return producto;
    }
    
    public boolean eliminarAlumno(String rut)
    {
        boolean resultado=false;
        try {
            Connection con=Conexion.getConexion();
            String query="delete from alumno where rut=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, rut);
            resultado=ps.executeUpdate()==1;
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    public boolean modificarAlumno(Producto alu)
    {
        boolean resultado=false;
        try {
            Connection con =Conexion.getConexion();
            String query="update alumno set nombre=?,nota1=?,nota2=?,nota3=?,trabajogrupal=? where rut=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, alu.getNombre());
            ps.setDouble(2, alu.getNota1());
            ps.setDouble(3, alu.getNota2());
            ps.setDouble(4, alu.getNota3());
            ps.setDouble(5, alu.getNotaProCont());
            ps.setString(6, alu.getRut());
            resultado=ps.executeUpdate()==1;
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
        ArrayList <Alumno> alumnos=new ArrayList<Alumno>();
        try {
            Connection con=Conexion.getConexion();
            String query="select * from alumno";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            Alumno alu;
            while(rs.next())
            {
                alu=new Alumno(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6));
                alumnos.add(alu);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumnos;
    }
       
}
