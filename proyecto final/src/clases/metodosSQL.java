
package clases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


public class metodosSQL {
    public static java.sql.PreparedStatement sentencia_preparada;
    public static java.sql.ResultSet resultado;
    public static String sql;
    public static int result_numero=0;
    conexion cx=new conexion();
    
     public int guardar(String id,String nombre, String precio){
    int resultado=0;
    Connection conexion=null;
    String sentencia_guardar=("INSERT INTO productos(id,nombre,precio) VALUES(?,?,?)");
    try{
        conexion=cx.getConexion();
        sentencia_preparada=conexion.prepareStatement(sentencia_guardar);
        sentencia_preparada.setString(1, id);
        sentencia_preparada.setString(2, nombre);
        sentencia_preparada.setString(3, precio);
        resultado=sentencia_preparada.executeUpdate();
        sentencia_preparada.close();
        
    }catch(Exception e){
        System.out.println(e);
    }
    
    return resultado;
    }
     public  String buscarusuario(String correo){
         conexion c1=new conexion();
        String buscar_nombre=null;
        Connection conexion=null;
        try{
            conexion=c1.getConexion();
            String sent_buscar=("SELECT nombre FROM login WHERE correo='"+correo+"'");
            sentencia_preparada=conexion.prepareStatement(sent_buscar);
            resultado=sentencia_preparada.executeQuery();
            if(resultado.next()){
                String nombre=resultado.getString("nombre");
                buscar_nombre=nombre;
            }
            conexion.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return buscar_nombre;
     }
     public  String buscarusuarioRegistrado(String usuario,String contraseña){
         conexion c1=new conexion();
         String busqueda_usuario=null;
         Connection conexion=null;
         try{
             conexion=c1.getConexion();
             String sentencia_buscar_usuario=("SELECT nombre,contraseña,correo FROM login WHERE correo ='"+usuario+"'&& contraseña ='"+contraseña+"'");
             sentencia_preparada=conexion.prepareStatement(sentencia_buscar_usuario);
             resultado=sentencia_preparada.executeQuery();
             if(resultado.next()){
                 busqueda_usuario="usuario encontrado";
             }else{
                 busqueda_usuario="usuario no encontrado";
             }
             conexion.close();
         }catch(Exception e){
             System.out.println(e);
         }
         
         return busqueda_usuario;
     }
     public void mostrar(String tabla){
       sql="SELECT FROM"+tabla;
       conexion c1=new conexion();
       String mostrar=null;
       Connection conexion=null;
         System.out.println("exito");
     }
    public DefaultTableModel buscarProducto(String buscar){
        conexion c1=new conexion();
        String[] nombrecolumna={"id","nombre","precio"};
        String[]regis=new String[3];
         DefaultTableModel model = new DefaultTableModel(null,nombrecolumna);
         String sql="SELECT * FROM productos WHERE nombre like'%"+buscar+"%'";
         Connection conexion=null;
         sentencia_preparada=null;
         resultado=null;
         try{
        conexion=c1.getConexion();
        sentencia_preparada=conexion.prepareCall(sql);
        resultado=sentencia_preparada.executeQuery();
        while(resultado.next()){
                 regis[0]=resultado.getString("id");
                 regis[1]=resultado.getString("nombre");
                 regis[2]=resultado.getString("precio");
                 
                 model.addRow(regis);
             }
        
    }catch(Exception e){
        System.out.println(e);
    }
         
        //esto es del lic
        /*DefaultTableModel model = new DefaultTableModel();
        Object[] columnsName = new Object[3];
        columnsName[0] = "Id";
        columnsName[1] = "Nombre";
        columnsName[2] = "Cuenta";
        
        model.setColumnIdentifiers(columnsName);
        
        Object[] rowData = new Object[3];
        
        ArrayList<Alumnos> al = getAlumnos();
        
        for(int i = 0; i < al.size(); i++){
            
            rowData[0] = al.get(i).getId();
            rowData[1] = al.get(i).getFname();
            rowData[2] = al.get(i).getCuenta();
               
            model.addRow(rowData);
        }
        
        this.jTable1.setModel(model);*/
        return model;
    }
    public DefaultTableModel eliminarproducto(String eliminar){
        conexion c1=new conexion();
        String[] nombrecolumna={"id","nombre","precio"};
        String[]regis=new String[3];
         DefaultTableModel model = new DefaultTableModel(null,nombrecolumna);
         String sql="DELETE * FROM productos WHERE nombre like'%"+eliminar+"%'";
         Connection conexion=null;
         sentencia_preparada=null;
         resultado=null;
         try{
        conexion=c1.getConexion();
        sentencia_preparada=conexion.prepareCall(sql);
        resultado=sentencia_preparada.executeQuery();
        while(resultado.next()){
                 regis[0]=resultado.getString("id");
                 regis[1]=resultado.getString("nombre");
                 regis[2]=resultado.getString("precio");
                 
                 model.addRow(regis);
             }
        
    }catch(Exception e){
        System.out.println(e);
    }
         
        //esto es del lic
        /*DefaultTableModel model = new DefaultTableModel();
        Object[] columnsName = new Object[3];
        columnsName[0] = "Id";
        columnsName[1] = "Nombre";
        columnsName[2] = "Cuenta";
        
        model.setColumnIdentifiers(columnsName);
        
        Object[] rowData = new Object[3];
        
        ArrayList<Alumnos> al = getAlumnos();
        
        for(int i = 0; i < al.size(); i++){
            
            rowData[0] = al.get(i).getId();
            rowData[1] = al.get(i).getFname();
            rowData[2] = al.get(i).getCuenta();
               
            model.addRow(rowData);
        }
        
        this.jTable1.setModel(model);*/
        return model;
    }
}
