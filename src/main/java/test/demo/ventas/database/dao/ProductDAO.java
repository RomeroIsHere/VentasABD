package test.demo.ventas.database.dao;

import test.demo.ventas.database.MySQLConnection;
import test.demo.ventas.model.Product;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class ProductDAO extends MySQLConnection implements DAO<Product> {
    Connection conn= getConnection();
    @Override
    public Optional<Product> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public boolean save(Product record) {
        return false;
    }

    @Override
    public boolean update(Product record) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
