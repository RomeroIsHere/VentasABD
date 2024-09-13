module test.demo.ventas {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;
    requires org.kordamp.ikonli.javafx;
    requires java.sql;


    opens test.demo.ventas to javafx.fxml;
    exports test.demo.ventas;
    exports test.demo.ventas.model;
    opens test.demo.ventas.model to javafx.fxml;
    exports test.demo.ventas.controllers.product;
    opens test.demo.ventas.controllers.product to javafx.fxml;
}