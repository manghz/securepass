package com.example.securepass.model;
//Importa la interfaz Serializable para permitir guardar objetos en archivos
import java.io.Serializable;

/**
 * Clase que representa una entrada de contraseña dentro del gestor SecurePass.
 * Implementa Serializable para poder guardarse y cargarse desde archivos.
 */

public class PasswordEntry  implements Serializable {
    //--Atributos privados--
    //Nombre del serivicio
    private String service;
    //Nombre de usuario
    private String username;
    //Contraseña cifrada
    private String password;

    public PasswordEntry(String service, String username, String password) {
        this.service = service;
        this.username = username;
        this.password = password;
    }

    //--Metodos getter--

    public String getService() {
        return service;
    }
    public String getUsername(){
        return  username;
    }
    public String getPassword(){
        return password;
    }

    //--Metodos setter--

    public void setService(String service){
        this.service = service;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public void setPassword(String password){
        this.password=password;
    }
}
