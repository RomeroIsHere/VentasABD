package test.demo.ventas.controllers.product;

import test.demo.ventas.model.Product;

public class ProductViewController {
    private Product item;
    public ProductViewController setProduct(Product item) {
        this.item=item;
        return this;
    }

    public void fillData() {
        item.toString();
    }
}
