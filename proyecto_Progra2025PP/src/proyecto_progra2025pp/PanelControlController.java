/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyecto_progra2025pp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
/**
 * FXML Controller class
 *
 * @author ALIS
 */
public class PanelControlController implements Initializable {

    private ResourceBundle.Control locale;
        
        @FXML
        private ComboBox<String> comboIdioma;
        @FXML
        private ComboBox<String> comboZonaHora;
        @FXML 
        private Label labelIdioma;
        @FXML
        private Label labelZonaHoraria;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    //Implementacion de Zonas horarias
        ObservableList<String> zonas = FXCollections.observableArrayList(
        "America/Guatemala", " America/Mexico_City", "America/Chicago", "Europe/Francia" 
        );
        
        comboZonaHora.setItems(zonas);
        comboZonaHora.setValue("America/Guatemala");
        
        // Idiomas
        comboIdioma.setItems(FXCollections.observableArrayList("Español", "Inglés"));
        comboIdioma.setValue("Español");

        // Listener para cambio de idioma
        
        comboIdioma.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            cambiarIdioma(newVal);
        });
        
        //Etiquetas al español al iniciar
        cambiarIdioma("Español");
    
    }    
        private void cambiarIdioma(String idiomaSeleccionado) {
        Locale locale = idiomaSeleccionado.equals("Español") ? new Locale("es", "ES") : new Locale("en", "US");
        ResourceBundle bundle = ResourceBundle.getBundle("Idiomas.Messages", locale);

        labelIdioma.setText(bundle.getString("label.idioma"));
        labelZonaHoraria.setText(bundle.getString("label.zonaHoraria"));
        // Aquí puedes agregar más etiquetas si las tienes con fx:id
    }
}





