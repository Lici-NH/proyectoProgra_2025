/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_progra2025pp;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ALIS
 */
public class Proyecto_Progra2025PP extends Application {

    //Configuracion del MAIN
    @Override
    public void start (Stage primaryStage) throws IOException  {
   
    Parent root = FXMLLoader.load(getClass().getResource("/proyecto_progra2025pp/Login.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Proyecto_Progra2025PP");
        primaryStage.show();
    }
    
    public static void main (String []args){
    launch (args);
    }
    
    //PRIMERA IMPLEMENTACION DE CODIGO PARA CONEXION A BASE DE DATOS
    public class ConexionBD {
    // Datos de conexión
    private static final String URL = "---";
    private static final String USUARIO = "*--";
    private static final String CONTRASENA = "--";

    public static Connection conectar() {
        Connection conexion = null;
        try {
            // Cargar el driver de MySQL (opcional a partir de JDBC 4.0)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Crear la conexión
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Driver no encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error de conexión a la base de datos.");
            e.printStackTrace();
        }
        return conexion;
    }

    public static void main(String[] args) {
        // Llamar al método para probar la conexión
        Connection conn = ConexionBD.conectar();

        // Cerrar conexión (si fue exitosa)
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}    
    
}


