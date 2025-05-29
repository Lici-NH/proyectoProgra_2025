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
import java.lang.IllegalArgumentException;
import java.lang.NumberFormatException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


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
        @FXML
        private javafx.scene.control.TextField txtVencimiento;
        @FXML
        private ComboBox<String> comboPrioridad;
       
    
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
        
        //Niveles de Prioridad (Campo No.6)
        comboPrioridad.setItems(FXCollections.observableArrayList("Alta", "Media", "Baja"));
        comboPrioridad.setValue("Alta");
    
    }  
        //Metodo
        private void cambiarIdioma(String idiomaSeleccionado) {
        Locale locale = idiomaSeleccionado.equals("Español") ? new Locale("es", "ES") : new Locale("en", "US");
        ResourceBundle bundle = ResourceBundle.getBundle("Idiomas.Messages", locale);

        labelIdioma.setText(bundle.getString("label.idioma"));
        labelZonaHoraria.setText(bundle.getString("label.zonaHoraria"));
        }
        
        //Metodo para obtenr y validar el vencimiento 
        public int getDiasVencimiento() throws IllegalArgumentException {
        String input = txtVencimiento.getText();
        if (input == null || input.trim().isEmpty() ){
        throw new IllegalArgumentException("El campo de vencimiento no puede estar vacio.");
        }
        
        try {
        int dias = Integer.parseInt(input);
        if (dias < 1 || dias > 365){
        throw new IllegalArgumentException("Debe estar entre 1 y 365 días.");
        }
        return dias;
        } catch (NumberFormatException e){ 
        throw new IllegalArgumentException("Debe ingresar numeros validos.");
        }
        }
            
        //Metodo Para la prioridad
        public String getPrioridadSeleccionada() {
        return comboPrioridad.getValue();
        }
        
        //Boton
        @FXML
        private void guardarConfiguracion() {
        try (java.sql.Connection conn = Conexion.getConexion();
         java.sql.PreparedStatement ps = conn.prepareStatement(
             "INSERT INTO configuracion (vencimiento_dias, prioridad, idioma, zona_horaria) VALUES (?, ?, ?, ?)")) {

        int vencimiento = getDiasVencimiento();
        String prioridad = getPrioridadSeleccionada();
        String idioma = comboIdioma.getValue();
        String zona = comboZonaHora.getValue();

        ps.setInt(1, vencimiento);
        ps.setString(2, prioridad);
        ps.setString(3, idioma);
        ps.setString(4, zona);

        ps.executeUpdate();
        mostrarAlertaInfo("Configuración guardada en la base de datos correctamente.");

    } catch (IllegalArgumentException ex) {
        mostrarAlertaError("Error de Validación", ex.getMessage());
    } catch (java.sql.SQLException ex) {
        mostrarAlertaError("Error de Base de Datos", "No se pudo guardar la configuración: " + ex.getMessage());
    }
}
        // Muestra una alerta informativa
        private void mostrarAlertaInfo(String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
}

        // Muestra una alerta de error con título y mensaje
        private void mostrarAlertaError(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
        }
}

        
            





