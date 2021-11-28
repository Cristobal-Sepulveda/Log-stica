package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion
{
    private static Connection conection=null;
    public static Connection getConexion() throws SQLException,ClassNotFoundException{
       if(conection==null)
       {
          Class.forName("com.mysql.cj.jdbc.Driver");
          conection= DriverManager.getConnection("jdbc:mysql://localhost/bd_tarea_final_software","root","");
        }
        return conection;
    }
}
