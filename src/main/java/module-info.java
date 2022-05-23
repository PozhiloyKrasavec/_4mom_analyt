module com.example._4mom_analyt {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example._4mom_analyt to javafx.fxml;
    opens com.example._4mom_analyt.model to javafx.fxml;
    exports com.example._4mom_analyt.model;
    exports com.example._4mom_analyt;
}