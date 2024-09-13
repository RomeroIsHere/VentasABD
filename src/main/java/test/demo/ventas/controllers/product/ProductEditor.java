package test.demo.ventas.controllers.product;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import test.demo.ventas.model.Product;

public abstract class ProductEditor {

    public TextField nombre;
    public TextField desc;
    public Spinner<Double> precio;
    protected Product item;
    protected Product getItem(){
        Product newItem=new Product();
        newItem.setNombre(nombre.getText());
        newItem.setDescripcion(desc.getText());
        newItem.setPrecio(precio.getValue().floatValue());
        newItem.setIdProducto(item==null? 0:item.getIdProducto());
        return newItem;
    }

    public void onCancelButton(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        item=null;
        stage.close();
    }
}
