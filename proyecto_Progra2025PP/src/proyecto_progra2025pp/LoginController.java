/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyecto_progra2025pp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ALIS
 */
public class LoginController implements Initializable {
@FXML private ComboBox <String> elegirUsuario;
@FXML private TextField cont;
@FXML private TextField rolUsuario;
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        elegirUsuario.getItems().addAll("Administrador", "Tecnico", "Usuario"); 
    }    
    
    //Funcion que tendra el combobox //on action 
    @FXML void ingreso(javafx.event.ActionEvent event)//para que el boton tenga accion
    {
    
        String elegir = elegirUsuario.getValue();
        String contraseña = cont.getText();
        String usuario = rolUsuario.getText();
      
        boolean acceso = false;
    String tipo = elegirUsuario.getValue();
         if("Administrador".equals(tipo)&& "Alicia".equals(usuario)&& "Admon".equals(contraseña)){
           acceso = true;
       }else if ("Tecnico".equals(tipo)&& "Juan".equals(usuario)&& "Tec".equals(contraseña)){
           acceso = true;   
       }else if ("Usuario".equals(tipo)&& "Iris".equals(usuario)&& "Usuario".equals(contraseña)){
           acceso = true;  
   }
         
     if (acceso) {
            abreMenuPrincipal(tipo);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Usuario o Contraseña Incorrectos. Intentalo,nuevamente.");
            alert.setTitle("Error!!");
            alert.setHeaderText("Error");
            alert.showAndWait();
        }
    }

    private void abreMenuPrincipal(String tipo) {
       {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PanelControl.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Panel de Control - " + tipo);
        stage.setScene(new Scene(root));
        stage.show();

       //Para cerrar la ventana actual
        Stage actual = (Stage) elegirUsuario.getScene().getWindow();
        actual.close();

    } catch (IOException e) {
        e.printStackTrace();
        Alert alert = new Alert(Alert.AlertType.ERROR, "No se pudo abrir el Panel de Control.");
        alert.showAndWait();
    }
       }
    }


    
}
    
    
    

