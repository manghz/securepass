module com.example.securepass {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    exports com.example.securepass.controller;
    opens com.example.securepass.controller to javafx.fxml;
    exports com.example.securepass.model;
    opens com.example.securepass.model to javafx.fxml;
    exports com.example.securepass.util;
    opens com.example.securepass.util to javafx.fxml;
    exports com.example.securepass.app;
    opens com.example.securepass.app to javafx.fxml;
}