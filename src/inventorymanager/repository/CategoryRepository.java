/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorymanager.repository;

import inventorymanager.model.Category;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabote
 */
//JAR https://dev.mysql.com/downloads/file/?id=546177
public class CategoryRepository {

    private SqlConnector sqlCon;

    //CATEGORY TABLE MODEL
    private static final String CATEGORY_ID = "category_id";
    private static final String CATEGORY_NAME = "category_name";

    public CategoryRepository() {
        this.sqlCon = new SqlConnector();
    }

    public Category findCategoryById(int id) {

        String query = "SELECT * FROM category WHERE category_id = ?";
        System.out.println("Ejecutando query para id " + id + ". QUERY: " + query);
        Category category = null;

        try (Connection conn = sqlCon.getConnection(); 
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {    
                    category = new Category(rs.getInt(CATEGORY_ID), rs.getString(CATEGORY_NAME));
                }
            }

            return category;

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            return null;
        }
    }
    
    public List<Category> findAllCategories(){
        List<Category> categoryList = new ArrayList<>();
        String query = "SELECT * FROM category";
        
        try (Connection conn = sqlCon.getConnection(); 
                Statement stmt = conn.prepareStatement(query)) {

            try (ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    Category c = new Category();
                    c.setCategoryId(rs.getInt(1));
                    c.setCategoryName(rs.getString(2));
                    
                    categoryList.add(c);
                }
            }
        
            return categoryList;

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            return null;
        }
    }

}
