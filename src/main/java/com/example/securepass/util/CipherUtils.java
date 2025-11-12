package com.example.securepass.util;

//Librerías necesarias para el cifrado y codificación Base64
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * Clase utilitaria para cifrar y descifrar texto usando el algoritmo AES.
 */

public class CipherUtils {

    //-- Clave de cifrado --
    //Debe tener exactamente 16 caracteres 128 bits para AES-128
    private static final String KEY = "1234567891234567"; // clave de 16 caracteres

    public static String encrypt(String plainText){
        try{
            //Crear una clave secreta a partir de la cadena KEY
            SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), "AES");
            //Crear una instancia del cifrador AES
            Cipher cipher = Cipher.getInstance("AES");
            //Inicializar el cifrador en modo ENCRYPT (cifrar)
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            //Ejecutar el proceso de cifrado
            byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
            //Codificar el resultado en Base64
            return Base64.getEncoder().encodeToString(encryptedBytes);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    // Descifra un texto cifrado en AES y devuelve el texto original.
    public static String decrypt(String encryptedText) {
        try{
            //Crear la misma clave secreta usada en el cifrado
            SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), "AES");
           //Crear una instancia del cifrador AES
            Cipher cipher = Cipher.getInstance("AES");
            //Inicializar en modo DECRYPT
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            //Decodificar el texto Base64
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
            //Ejecutar el proceso de descifrado
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            //Convertir los bytes descifrados en un String
            return new String(decryptedBytes);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
