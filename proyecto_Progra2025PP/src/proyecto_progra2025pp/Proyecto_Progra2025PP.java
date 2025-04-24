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
}

