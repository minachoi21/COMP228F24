module org.example.minachoi_comp228lab5 {
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
    requires java.sql;

    opens org.example.minachoi_comp228lab5 to javafx.fxml;
    exports org.example.minachoi_comp228lab5;
    exports org.example.minachoi_comp228lab5.controller;
    exports org.example.minachoi_comp228lab5.model;

    opens org.example.minachoi_comp228lab5.controller to javafx.fxml;
    opens org.example.minachoi_comp228lab5.model to javafx.base;

}