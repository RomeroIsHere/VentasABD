package test.demo.ventas.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Product {
    private int idProducto;
    private String nombre,descripcion;
    private BigDecimal precio;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }
    public float getFloatPrice(){
        return precio.floatValue();
    }
    public String getPriceString(){
        return "$"+NumberFormat.getCurrencyInstance().format(precio.floatValue());
    }
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public void setPrecio(float price){
        this.precio = new BigDecimal(price);
    }

    @Override
    public String toString() {
        return idProducto+":"+nombre;


    }
}
