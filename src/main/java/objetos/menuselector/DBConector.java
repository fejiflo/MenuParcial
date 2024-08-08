/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos.menuselector;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ESTUDIANTES
 */
public class DBConector {
    private static Connection conexion;

    private static DBConector instancia;

    private static final String URL = "jdbc:mysql://localhost/tomadeorden";

    private static final String USER = "root";

    private static final String PASSWORD = "";
    
    private DBConector(){
    
    }
     public Connection conectar() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Conexion exitosa");

            return conexion;
        } catch (Exception e) {
            System.out.println("Error de conexion");
        }
        return conexion;
    }

    public void cerrarConexion() throws SQLException {
        try {
            conexion.close();
            System.out.println("Se desconecto de la base de datos");

        } catch (Exception e) {
            conexion.close();
        } finally {
            conexion.close();
        }
    }

    public static DBConector getInstance() {
        if (instancia == null) {
            instancia = new DBConector();
        }
        return instancia;
    }

}
