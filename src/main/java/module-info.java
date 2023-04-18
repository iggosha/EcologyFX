module com.ecology.ecologyfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ecology.ecologyfx to javafx.fxml;
    exports com.ecology.ecologyfx;
}