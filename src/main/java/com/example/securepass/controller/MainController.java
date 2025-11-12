package com.example.securepass.controller;

// Importaciones necesarias
import com.example.securepass.util.FileUtils;
import com.example.securepass.model.PasswordEntry;
import com.example.securepass.util.CipherUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;

/**
 * Controlador principal de la aplicación SecurePass.
 * Gestiona la lógica de la ventana principal, permitiendo agregar,
 * Eliminar y visualizar contraseñas almacenadas de forma cifrada.
 */

public class MainController {

    //Elementos de la interfaz
    @FXML private TableView<PasswordEntry> tablePasswords; //Tabla de contraseñas
    @FXML private TableColumn<PasswordEntry, String> colService; //Columna del servicio
    @FXML private TableColumn<PasswordEntry, String> colUsername; // Columna del nombre del usuario
    @FXML private TableColumn<PasswordEntry, String> colPassword; // Columna de la contraseña cifrada

    // Campos para añadir nuevas contraseñas
    @FXML private TextField txtService;
    @FXML private TextField txtUsername;
    @FXML private TextField txtPassword;

    //Lista que contiene las contraseñas en la tabla
    private ObservableList<PasswordEntry> passwordList;

    /**
    Metodo que se ejecuta automáticamente al iniciar el controlador
     Carga las contraseñas guardadas en el archivo y configura las columnas de la tabla
     **/

    @FXML
    public void initialize(){
        //Carga contraseñas guardadas usando la utilidad FileUtils
        passwordList = FXCollections.observableArrayList(FileUtils.loadPasswords());


        //Vincula las propiedades de PasswordEntry con las columnas de la tabla
        colService.setCellValueFactory(new PropertyValueFactory<>("service"));
        colUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("password"));

        //Asigna la lista cargada a la tabla para que se muestre la intrefaz
        tablePasswords.setItems(passwordList);
    }

    /**
     * Evento al hacer clic en el botón "Agregar"
     * Valida los campos, cifra la contraseña y la guarda en el archivo.
     */

    @FXML
    private void onAddPassword() {
        String service = txtService.getText().trim();
        String username = txtUsername.getText().trim();
        String passwordPlain = txtPassword.getText().trim();

        //Verifica que todos los campos estén llenos
        if (service.isEmpty() || username.isEmpty() || passwordPlain.isEmpty()) {
            showAlert("Error", "Por favor, completa todos los campos antes de agregar.");
            return;
        }

        // Cifrar la contraseña antes de guardarla
        String passwordEncrypted = CipherUtils.encrypt(passwordPlain);

        // Añadir la entrada
        PasswordEntry entry = new PasswordEntry(service, username, passwordEncrypted);
        passwordList.add(entry);

        FileUtils.savePasswords(passwordList);

        // Limpiar campos
        txtService.clear();
        txtUsername.clear();
        txtPassword.clear();

        //Mensaje de exito
        showAlert("Éxito", "Contraseña agregada correctamente.");
    }

    /**
     * Evento al hacer clic en el botón "Eliminar"
     * borra la entrada seleccionada de la tabla y del archivo.
     */


    @FXML
    private void onDeletePassword() {
        PasswordEntry selected = tablePasswords.getSelectionModel().getSelectedItem();
        //Verificar que haya una fila seleccionada
        if (selected != null) {
            passwordList.remove(selected);
            FileUtils.savePasswords(passwordList);
        } else {
            showAlert("Aviso", "Selecciona una fila para eliminar.");
        }
    }

    /**
     * Evento al hacer clic en el botón "ver contraseña"
     * Desencripta la contraseña seleccionada y la muestra en un cuadro de diálogo
     */

    @FXML
    private void onShowDecriptedPassword(){
        PasswordEntry selected = tablePasswords.getSelectionModel().getSelectedItem();
        //Desencripta la contraseña usando utilidad de cifrado
        if (selected != null){
            String decrypted = CipherUtils.decrypt(selected.getPassword());
            showAlert("Contraseña desencriptada", "La contraseña es: "+decrypted);
        } else {
            showAlert("Aviso","Selecciona una fila para ver la contraseña.");
        }
    }

    // Método auxiliar para mostrar mensajes
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}



