/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorymanager.repository;

import inventorymanager.model.Category;
import inventorymanager.model.Product;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Gabote
 */
//JAR https://dev.mysql.com/downloads/file/?id=546177
public class ProductRepository {

    private SqlConnector sqlCon;
    private CategoryRepository catRepo;

    //PRODUCT TABLE MODEL
    private static final String PRODUCT_ID = "product_id";
    private static final String PRODUCT_NAME = "product_name";
    private static final String PRODUCT_CATEGORY_ID = "product_category_id";
    private static final String PRODUCT_PRICE = "product_price";
    private static final String PRODUCT_STOCK = "product_stock";

    public ProductRepository() {
        this.sqlCon = new SqlConnector();
        this.catRepo = new CategoryRepository();
    }

    public Product findProductById(int id) {
        Product prod = null;
        String query = "SELECT * FROM Product WHERE product_id = ?";

        try (Connection conn = sqlCon.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Category category = catRepo.findCategoryById(rs.getInt(PRODUCT_CATEGORY_ID));
                    prod = new Product(
                            rs.getInt(PRODUCT_ID),
                            rs.getString(PRODUCT_NAME),
                            category,
                            rs.getInt(PRODUCT_PRICE),
                            rs.getInt(PRODUCT_STOCK)
                    );
                }

                return prod;
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());

            return null;
        }
    }

    public List<Product> findAllProducts() {

        List<Product> result = new ArrayList<>();
        String query = "SELECT * FROM Product";

        try (Connection conn = sqlCon.getConnection(); Statement stmt = conn.createStatement()) {

            try (ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    Category category = catRepo.findCategoryById(rs.getInt(PRODUCT_CATEGORY_ID));
                    Product p = new Product(
                            rs.getInt(PRODUCT_ID),
                            rs.getString(PRODUCT_NAME),
                            category,
                            rs.getInt(PRODUCT_PRICE),
                            rs.getInt(PRODUCT_STOCK)
                    );

                    result.add(p);
                }
            }

            return result;

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());

            return null;
        }
    }

    public boolean insertProduct(Product p) {
        String query = "INSERT INTO Product VALUES(?, ?, ?, ?, ?)";

        try (Connection conn = sqlCon.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, p.getProductId());
            pstmt.setString(2, p.getProductName());
            pstmt.setInt(3, p.getProductCategory().getCategoryId());
            pstmt.setInt(4, p.getProductPrice());
            pstmt.setInt(5, p.getProductStock());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            return false;
        }
    }

    public boolean updateProduct(int oldId, Product newProd) {
        String query = "UPDATE Product SET product_id = ?, "
                + "product_name = ?, "
                + "product_category_id = ?, "
                + "product_price = ?, "
                + "product_stock = ? "
                + "WHERE product_id = ?";

        try (Connection conn = sqlCon.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, newProd.getProductId());
            pstmt.setString(2, newProd.getProductName());
            pstmt.setInt(3, newProd.getProductCategory().getCategoryId());
            pstmt.setInt(4, newProd.getProductPrice());
            pstmt.setInt(5, newProd.getProductStock());

            //WHERE
            pstmt.setInt(6, oldId);

            return pstmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            return false;
        }
    }

    public boolean deleteProductById(int id) {
        String query = "DELETE FROM Product WHERE product_id = ?";

        try (Connection conn = sqlCon.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);

            return pstmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            return false;
        }
    }

    public int countProducts() {
        String query = "SELECT COUNT(*) FROM Product";
        
        try(Connection conn = sqlCon.getConnection(); 
                Statement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery(query) ){
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
            
        }catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            return 0;
        }
    }
}
