module com.henrik.portfolio3_jfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires sqlite.jdbc;


    opens com.henrik.portfolio3_jfx to javafx.fxml;
    exports com.henrik.portfolio3_jfx;
}