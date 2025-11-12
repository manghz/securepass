# 🔐 SecurePass

**SecurePass** es una aplicación de escritorio desarrollada en **Java** con **JavaFX**, diseñada para gestionar contraseñas de manera sencilla y segura.  
Permite guardar, visualizar y mantener tus credenciales organizadas localmente mediante un sistema de almacenamiento cifrado.

---

## 🚀 Características

- 🧾 **Gestión de contraseñas**: guarda servicios, usuarios y contraseñas en una tabla interactiva.  
- 💾 **Persistencia de datos**: los registros se guardan automáticamente en un archivo local (`passwords.dat`).  
- 🔒 **Cifrado AES**: las contraseñas se almacenan cifradas para mayor seguridad.  
- 🖥️ **Interfaz moderna**: desarrollada con JavaFX, ofrece una experiencia limpia y fácil de usar.  

---

## 📁 Estructura del proyecto
```
SecurePass/
├── src/
│ ├── com/example/securepass/
│ │ ├── controller/
│ │ │ └── MainController.java
│ │ ├── model/
│ │ │ └── PasswordEntry.java
│ │ ├── util/
│ │ │ ├── CipherUtils.java
│ │ │ └── FileUtils.java
│ │ └── SecurePassApplication.java
│ └── resources/
│ └── com/example/securepass/
│ └── main-view.fxml
└── README.md
```
---

## 🧠 Cómo funciona

1. Al iniciar, la aplicación carga las contraseñas guardadas desde `passwords.dat`.  
2. Puedes añadir nuevos registros indicando:
   - Servicio (por ejemplo: *Gmail*)  
   - Usuario  
   - Contraseña  
3. Al pulsar **Agregar**, el registro aparece en la tabla y se guarda automáticamente en el archivo.  
4. Al cerrar y volver a abrir la app, los datos se recargan automáticamente.  

---

## ⚙️ Tecnologías utilizadas

- **Java 17+**
- **JavaFX**
- **FXML**
- **Maven / IntelliJ IDEA**
- **Cifrado AES (Java Cryptography Extension)**

---

## 🧩 Clases principales

### `PasswordEntry`
Representa cada entrada de contraseña. Implementa `Serializable` para poder guardarse en disco.

### `FileUtils`
Gestiona la lectura y escritura de contraseñas en el archivo `passwords.dat`.

### `CipherUtils`
Cifra y descifra las contraseñas usando AES con una clave fija de 16 caracteres.

### `MainController`
Controla la interfaz JavaFX, maneja eventos del botón **Agregar** y actualiza la tabla.

---

## 📦 Ejecución

1. Clona el repositorio:
   ```bash
   https://github.com/manghz/securepass.git
```
   🧑‍💻 Autor

Desarrollado por Miguel Ángel González Hernández
Proyecto educativo para practicar JavaFX.
