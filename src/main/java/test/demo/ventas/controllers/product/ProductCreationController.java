package test.demo.ventas.controllers.product;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import test.demo.ventas.database.dao.ProductDAO;
import test.demo.ventas.model.Product;

public class ProductCreationController extends ProductEditor{

    public void onAcceptButton(ActionEvent actionEvent) {
    item=getItem();
        if(new ProductDAO().save(item)) {
            Alert info = new Alert(Alert.AlertType.INFORMATION);
            info.setTitle("Modelo Creado");
            info.setHeaderText(null);
            info.setContentText(String.format("El modelo %s ha sido creado",item.getNombre()));
            info.showAndWait();
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            System.out.println("Close window Creators");
            stage.close();
        }
    }
}
