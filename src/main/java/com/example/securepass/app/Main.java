package com.example.securepass.app;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase principal de la aplicación SecurePass.
 * Extiende de javafx.application.Application, lo que permite inicializar
 * la interfaz gráfica (JavaFX) al ejecutar el programa.
 */

public class Main extends Application {

    /**
     * Método que se ejecuta al iniciar la aplicación JavaFX.
     * Carga la vista principal (login.fxml) y muestra la ventana inicial.
     * @param stage Escenario principal de la aplicación
     * @throws Exception si ocurre un error al cargar el archivo FXML
     */

    @Override
    public void start(Stage stage) throws Exception{
        // Carga el archivo FXML que define la interfaz de inicio de sesión
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/login.fxml"));

        // Crea una nueva escena con la vista cargada.
        Scene scene = new Scene(fxmlLoader.load());

        // Configura el título de la ventana.
        stage.setTitle("SecurePass");
        // Asocia la escena al escenario principal.
        stage.setScene(scene);
        // Muestra la ventana en pantalla.
        stage.show();
    }

    /**
     * Punto de entrada de la aplicación
     * Llama al método Launch() que inicializa JavaFX.
     *
     * @param args Argumentos de línea de comandos.
     */

    public static void main(String[] args){
        launch(args);
    }
}
