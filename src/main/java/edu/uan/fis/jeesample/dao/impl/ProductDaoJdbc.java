package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dao.ProductDao;
import edu.uan.fis.jeesample.dto.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Product DAO implementation using JDBC
 */
public class ProductDaoJdbc implements ProductDao {

    public Product create(Product product) {
        // Sample code
        Connection conn = null;
        Statement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Supermercado1;create=false;user=ana&password=anita4427");
            // 3. Creates the product in the database
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO producto(id_producto,nombre_producto) VALUES(" + product.getProductId() + ",'" + product.getName() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return product;
    }

    public Product update(Product product) {

        Connection conn = null;
        Statement stmt = null;
        try {            // 1. Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Supermercado1;create=false;user=ana&password=anita4427");
            // 3. actualizar producto en la base de datos
            stmt = conn.createStatement();
            stmt.execute("UPDATE producto SET nombre_producto = 'Modificado' WHERE id_producto = 0");

        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return product;

    }

    public void delete(Product product) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Supermercado1;create=false;user=ana&password=anita4427");
            // 3. actualizar producto en la base de datos
            stmt = conn.createStatement();
            stmt.execute("DELETE FROM producto WHERE id_producto = 23");

        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Product findById(Integer productId) {
        Product producto = null;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Supermercado1;create=false;user=ana&password=anita4427");
            String updateTableSQL = "Select * FROM producto WHERE id_producto = ?";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar producto en la base de datos
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            //preparedStatement.setString(1, 1);
            preparedStatement.setInt(1, 2);
// execute insert SQL stetement
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                producto = new Product();

                int idproduct = rs.getInt("id_producto");

                String nombre = rs.getString("nombre_producto");

                producto.setProductId(idproduct);
                System.out.println(idproduct);
                producto.setName(nombre);
                System.out.println(nombre);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return producto;
    }

    public List<Product> findAll() {
        Product producto = null;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Supermercado1;create=false;user=ana&password=anita4427");
            String updateTableSQL = "Select * FROM producto";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar producto en la base de datos

            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            preparedStatement.executeQuery();
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                producto = new Product();

                int idproduct = rs.getInt("id_producto");

                String nombre = rs.getString("nombre_producto");

                producto.setProductId(idproduct);
                System.out.println(idproduct);
                producto.setName(nombre);
                System.out.println(nombre);
            }
            //stmt.executeUpdate("INSERT INTO tbl_product VALUES(" + product.getProductId() + ",'" + product.getName() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}