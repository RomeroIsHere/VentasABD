package test.demo.ventas.database.dao;

import test.demo.ventas.database.MySQLConnection;
import test.demo.ventas.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDAO extends MySQLConnection implements DAO<Product> {
    Connection conn= getConnection();
    public ProductDAO(){
        conn=getConnection();
    }
    @Override
    public Optional<Product> findById(int id) {
        Optional<Product> optionalBrand = Optional.empty();
        String query = "select * from productos where idproducto=?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if ( rs.next() )
            {
                optionalBrand = Optional.of(extractProduct(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return optionalBrand;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList= new ArrayList<>();
        String query = "select * from productos";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next())
            {
                productList.add(extractProduct(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;

    }

    @Override
    public boolean save(Product record) {
        String query = "insert into productos (nombre,descripcion,precio)" +
                " values (?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, record.getNombre());
            ps.setString(2,record.getDescripcion());
            ps.setBigDecimal(3,record.getPrecio());
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Product record) {
        String query = "update productos set nombre=?, descripcion=?, precio=? where idproducto = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, record.getNombre());
            ps.setString(2,record.getDescripcion());
            ps.setBigDecimal(3,record.getPrecio());
            ps.setInt(4, record.getIdProducto());
            ps.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(int id) {
        String query = "delete from productos where idproducto = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private Product extractProduct(ResultSet rs) throws SQLException {
        Product p = new Product();
        p.setDescripcion(rs.getString("descripcion"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getBigDecimal("precio"));
        p.setIdProducto(rs.getInt("idproducto"));
        return p;
    }

}
