package Jdbc.Dao;

import Jdbc.Model.Category;
import Jdbc.Model.Genre;
import Jdbc.Model.Movie;
import Jdbc.Util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoMovie {
    private DaoGenre daoGenre = new DaoGenre();
    private DaoCategory daoCategory = new DaoCategory();

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        Genre g = new Genre();
        Category c = new Category();
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement("SELECT * FROM filmes ORDER BY cod_filmes;");) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int cod_filmes = rs.getInt("cod_filmes");
                String titulo_original = rs.getString("titulo_original");
                String titulo = rs.getString("titulo");
                int quantidade = rs.getInt("quantidade");
                g = daoGenre.getGenre(rs.getInt("fk_cod_gen"));
                c = daoCategory.getCategory(rs.getInt("fk_cod_cat"));
                Movie movie = new Movie(cod_filmes, titulo_original, titulo, quantidade, c, g);
                movies.add(movie);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return movies;
    }

    public int insertMovie(Movie m) {

        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement("INSERT INTO FILMES (TITULO_ORIGINAL, TITULO, " + "QUANTIDADE,FK_COD_CAT,FK_COD_GEN) VALUES (?,?,?,?,?)");) {
            ps.setString(1, m.getTitulo_original());
            ps.setString(2, m.getTitulo());
            ps.setInt(3, m.getQuantidade());
            ps.setInt(4, m.getCategory().getId());
            ps.setInt(5, m.getGenre().getId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
