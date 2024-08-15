/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author ESTUDIANTES
 */
public class Utilities {
    
    public static void Insertar(DBConector conectar, String Orden) {
        try {
            Connection conexion = conectar.conectar();
            PreparedStatement insertar = conexion.prepareStatement("Insert into usuarios values(?,?)");
            insertar.setString(1, Orden);
            insertar.setString(2, "0");

            insertar.executeUpdate();
            JOptionPane.showMessageDialog(null,"Orden tomada exitosamente!");
            conectar.cerrarConexion();

        } catch (HeadlessException | SQLException e) {
           JOptionPane.showMessageDialog(null,"Orden No Registrada, Contacte con un administrador o vuelva a intentarlo");

        }
    }

}
