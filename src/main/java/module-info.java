module test.demo.ventas {
    requires javafx.controls;
    requires javafx.fxml;


    opens test.demo.ventas to javafx.fxml;
    exports test.demo.ventas;
}