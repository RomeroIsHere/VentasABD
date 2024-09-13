package test.demo.ventas.controllers.product;

import javafx.animation.FadeTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.kordamp.bootstrapfx.BootstrapFX;
import test.demo.ventas.MainMenuController;
import test.demo.ventas.database.dao.ProductDAO;
import test.demo.ventas.model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProductTableController implements Initializable {
    public TableView<Product> tabla;
    public Label welcomeText;

    public void onReturnButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenuController.class.getResource("hello-view.fxml"));
        ((Node) actionEvent.getSource()).getScene().setRoot(fxmlLoader.load());
    }

    public void onReset() {
        tabla.setItems(FXCollections.observableList(new ProductDAO().findAll()));//Creates an list with all Products
        welcomeText.setText("Se ha actualizado la Tabla");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*
         *
         * author for this snippet of code  is James_D on StackOverflow
         * llama a un objeto de la interface callback que llama a un event handler para el mouse, esto para confirmar el objeto que se dio doble click
         * show product view genera un nuevo stage que permite mostrar toda la informacion de el producto seleccionado
         * */
        tabla.setRowFactory(modelTableView -> {
            TableRow<Product> serviceTableRow= new TableRow<>();
            serviceTableRow.setOnMouseClicked(event -> {
                if (!serviceTableRow.isEmpty()&&event.getClickCount()==2){
                    showProductView(serviceTableRow.getItem());
                }
            });
            return serviceTableRow;
        });
        final FadeTransition fadeTransition = new FadeTransition(Duration.millis(3000), welcomeText);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        welcomeText.textProperty().addListener((observableValue, s, t1) -> fadeTransition.play());
        onReset();
    }

    private void showProductView(Product item) {
        Stage stage=new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(ProductViewController.class.getResource("productView.fxml"));
        Scene scene=null;
        /*
         * author for this snippet is jewelsea on StackOverflow
         * */
        try {
            scene = new Scene(fxmlLoader.load());
            scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        }catch (IOException Io){
            Io.printStackTrace();
        }

        ProductViewController CVC=fxmlLoader.getController();
        CVC.setProduct(item).fillData();


        stage.setTitle(item.toString());
        stage.setScene(scene);
        stage.showAndWait();
        onReset();
    }

    public void onAddButtonClick(ActionEvent actionEvent) {
        Stage stage=new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(ProductViewController.class.getResource("productCreateView.fxml"));
        Scene scene=null;
        /*
         * author for this snippet is jewelsea on StackOverflow
         * */
        try {
            scene = new Scene(fxmlLoader.load());
            scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        }catch (IOException Io){
            Io.printStackTrace();
        }
        stage.setTitle("Nuevo Producto!");
        stage.setScene(scene);
        stage.showAndWait();
        onReset();
    }
}
