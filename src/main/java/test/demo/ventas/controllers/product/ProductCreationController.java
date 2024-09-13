package test.demo.ventas.controllers.product;

import javafx.event.ActionEvent;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import test.demo.ventas.database.dao.ProductDAO;
import test.demo.ventas.model.Product;

public class ProductCreationController extends ProductEditor{

    public void onAcceptButton(ActionEvent actionEvent) {
        new ProductDAO().save(getItem());
    }
}
