module gui.client_fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens gui.client_fx to javafx.fxml;
    exports gui.client_fx;
}