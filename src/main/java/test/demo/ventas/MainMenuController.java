package test.demo.ventas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import test.demo.ventas.controllers.product.ProductTableController;

import java.io.IOException;

public class MainMenuController {

    @FXML
    protected void onProductosButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ProductTableController.class.getResource("productTableView.fxml"));
        ((Node) actionEvent.getSource()).getScene().setRoot(fxmlLoader.load());

    }
}