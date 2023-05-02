
package clases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conexion {
  public static final String URL = "jdbc:mysql://localhost:3306/inicio";
    public static final String USER = "root";
    public static final String CLAVE = "";
    
    public Connection getConexion(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
            System.out.println("Exito");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }  
}
