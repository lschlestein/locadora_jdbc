package Jdbc.Dao;

import Jdbc.Model.Category;
import Jdbc.Util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoCategory {
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement("select * from categoria order by cod_cat")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int cod_cat = rs.getInt("cod_cat");
                String nome = rs.getString("nome");
                String valor = rs.getString("valor");
                Category category = new Category(cod_cat, nome, Float.parseFloat(valor));
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }

    public int insertCategory(Category c) {
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement("INSERT INTO CATEGORIA (NOME, VALOR) VALUES (?,?)")) {
            ps.setString(1, c.getNome());
            ps.setFloat(2, c.getValor());
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getCategoryName(int cod_cat) {
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement("select nome from categoria where cod_cat=?")) {
            ps.setInt(1, cod_cat);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("nome");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Category getCategory(int cod_cat) {
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement("select nome, valor from categoria where cod_cat=?")) {
            ps.setInt(1, cod_cat);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Category(cod_cat, rs.getString("nome"), rs.getFloat("valor"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
