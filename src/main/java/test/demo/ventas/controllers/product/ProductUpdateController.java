package test.demo.ventas.controllers.product;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import test.demo.ventas.database.dao.ProductDAO;
import test.demo.ventas.model.Product;

public class ProductUpdateController extends ProductEditor{
    ProductViewController pvc;
    public void setProduct(Product item) {
        this.item=item;
        fillData();
    }

    private void fillData() {
        nombre.setText(item.getNombre());
        desc.setText(item.getDescripcion());
        precio.getValueFactory().setValue((double) item.getFloatPrice());
    }

    public void onAcceptButton(ActionEvent actionEvent) {
        item=getItem();
        if (new ProductDAO().update(item)){
            Alert info = new Alert(Alert.AlertType.INFORMATION);
            info.setTitle("Modelo Actualizado");
            info.setHeaderText(null);
            info.setContentText(String.format("El modelo %s ha sido actualizado",item.getNombre()));
            info.showAndWait();
            setProduct(item);
            pvc.setProduct(item);
            pvc.fillData();
            onCancelButton(actionEvent);
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ocurrio un Error");
            alert.setHeaderText(null);
            alert.setContentText("Ooops, No se pudo Actualizar el Modelo");
            alert.showAndWait();
        }

    }

    public void setBackwardsReference(ProductViewController productViewController) {
        pvc=productViewController;
    }
}
