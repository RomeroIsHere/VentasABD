module test.demo.ventas {
    requires javafx.controls;
    requires javafx.fxml;


    opens test.demo.ventas to javafx.fxml;
    exports test.demo.ventas;
    exports test.demo.ventas.controllers.product;
    opens test.demo.ventas.controllers.product to javafx.fxml;
}