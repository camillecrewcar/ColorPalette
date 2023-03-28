module com.example.projekt {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jetbrains.annotations;
    requires java.base;
    requires java.naming;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;

    opens com.example.projekt to javafx.fxml,org.hibernate.orm.core;
    exports com.example.projekt;
}