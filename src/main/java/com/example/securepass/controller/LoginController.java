package com.example.securepass.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Controlador del formulario de inicio de sesión (login.fxml) de la aplicación SecurePass.
 * Gestiona la interacción del usuario con los componentes de la interfaz de inicio de sesión.
 */


public class LoginController {

    // Campo de entrada donde el usuario introduce la contraseña maestra.
    @FXML
    private PasswordField txtMasterPassword;

    // Etiqueta utilizada para mostrar mensajes de error o información al usuario.
    @FXML
    private Label lblMessage;

    /**
     * Método que ejecuta al hacer clic en el botón "Iniciar sesión".
     * Verifica la contraseña introducida y, si es correcta, carga la ventana principal.
     * @param event Evento de acción generado por el clic del botón
     */
    @FXML
    private void onLoginClick(ActionEvent event) {
        // Obtiene el texto introducido por el usuario.
        String password = txtMasterPassword.getText();

        // Validación de la contraseña (en este caso, una clave fija de prueba)
        if (password.equals("1234")) { //Clave de ejemplo, no usar en producción.
            try {
                // Carga la vista principal (main.fxml).
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main.fxml"));
                Scene scene = new Scene(loader.load());

                // Obtiene la escena actual por la ventana principal.
                Stage stage = (Stage) txtMasterPassword.getScene().getWindow();
                // Cambia la escena actual por la ventana principal.
                stage.setScene(scene);
                stage.setTitle("SecurePass - Principal");
            } catch (Exception e) {
                // Muestra mensaje de error si ocurre un problema al cargar la vista.
                lblMessage.setText("Error al cargar la ventana principal");
                e.printStackTrace();
            }
        } else {
            // Mensaje de error si la contraseña no coincide.
            lblMessage.setText("Contraseña incorrecta");
        }
    }
}
