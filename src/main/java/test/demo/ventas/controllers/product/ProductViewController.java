package test.demo.ventas.controllers.product;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;
import test.demo.ventas.database.dao.ProductDAO;
import test.demo.ventas.model.Product;

import java.io.IOException;
import java.util.Optional;

public class ProductViewController {
    public Label name,productID,desc,price;
    private Product item;
    public ProductViewController setProduct(Product item) {
        this.item=item;
        return this;
    }

    public void fillData() {
        name.setText(item.getNombre());
        productID.setText(item.getIdProducto()+"");
        desc.setText(item.getDescripcion());
        price.setText(item.getPriceString());

    }

    public void onReset(ActionEvent actionEvent) {
        fillData();
    }

    public void onUpdateButton(ActionEvent actionEvent) {
        Stage stage=new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(ProductUpdateController.class.getResource("productUpdateView.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
            scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ((ProductUpdateController)(fxmlLoader.getController())).setProduct(item);
        ((ProductUpdateController)(fxmlLoader.getController())).setBackwardsReference(this);

        stage.setScene(scene);
        stage.setTitle(item.toString());
        stage.show();
    }

    public void onDeleteButton(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación de Borrado");
        alert.setHeaderText("Al borrar este Modelo, no habrá manera de Recuperarlo, y los Carros Vendidos no podrán Ver este Modelo");
        alert.setContentText("Quieres Borrar Este Modelo Permanentemente?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            if (new ProductDAO().delete(item.getIdProducto())){
                Alert info = new Alert(Alert.AlertType.INFORMATION);
                info.setTitle("Modelo Borrado");
                info.setHeaderText(null);
                info.setContentText(String.format("El modelo %s ha sido borrado",item.getNombre()));
                info.showAndWait();
                System.out.println("Close window");
                Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
                stage.close();
            }
        }

    }
}
