package Jdbc.Dao;

import Jdbc.Model.Genre;
import Jdbc.Util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoGenre {

    public List<Genre> getAllGenres() {
        List<Genre> genres = new ArrayList<>();
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement("select * from genero order by cod_gen")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int cod_gen = rs.getInt("cod_gen");
                String nome = rs.getString("nome");
                Genre genre = new Genre(cod_gen, nome);
                genres.add(genre);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return genres;
    }

    public int insertGenre(Genre g) {
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement("INSERT INTO GENERO (NOME) VALUES (?)")) {
            ps.setString(1, g.getName());
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getGenreName(int cod_gen) {
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement("select nome from genero where cod_gen=?");) {
            ps.setInt(1, cod_gen);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("nome");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Genre getGenre(int cod_gen) {
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement("select nome from genero where cod_gen=?")) {
            ps.setInt(1, cod_gen);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Genre(cod_gen, rs.getString("nome"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
