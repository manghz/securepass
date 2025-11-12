package com.example.securepass.util;

import com.example.securepass.model.PasswordEntry;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class FileUtils {

    private static final String FILE_PATH = "passwords.dat";

   //Guardar la lista cifrada
   public static void savePasswords(ObservableList<PasswordEntry> passwords) {
    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
        oos.writeObject(new ArrayList<>(passwords));
    } catch (IOException e){
        e.printStackTrace();
    }
   }
   //Cargar la lista cifrada
    @SuppressWarnings("unchecked")
    public static List<PasswordEntry> loadPasswords() {
       File file = new File(FILE_PATH);
       if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<PasswordEntry>) ois.readObject();
        }catch (IOException | ClassNotFoundException e){
           e.printStackTrace();
           return new ArrayList<>();
       }
    }
}
