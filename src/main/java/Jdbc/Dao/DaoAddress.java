package Jdbc.Dao;

import Jdbc.Model.Address;
import Jdbc.Util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoAddress {
    public List<Address> getAllAddress() {
        List<Address> addresses = new ArrayList<>();
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement("SELECT * FROM endereco ORDER BY cod_end");) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int cod_end = rs.getInt("cod_end");
                String logradouro = rs.getString("logradouro");
                String tipo_logradouro = rs.getString("tipo_log");
                String complemento = rs.getString("complemento");
                String cidade = rs.getString("cidade");
                String uf = rs.getString("uf");
                String cep = rs.getString("cep");
                String numero = rs.getString("numero");
                String bairro = rs.getString("bairro");
                Address address = new Address(cod_end, logradouro, tipo_logradouro, complemento, cidade, uf, cep, numero, bairro);
                addresses.add(address);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return addresses;
    }

    public int insertAddress(Address a) {

        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(
                "INSERT INTO ENDERECO (LOGRADOURO, TIPO_LOG, COMPLEMENTO, CIDADE, UF, CEP, " +
                        "NUMERO, BAIRRO) VALUES (?,?,?,?,?,?,?,?)");) {
            ps.setString(1, a.getLogradouro());
            ps.setString(2, a.getTipo_logradouro());
            ps.setString(3, a.getComplemento());
            ps.setString(4, a.getCidade());
            ps.setString(5, a.getUf());
            ps.setString(6, a.getCep());
            ps.setString(7, a.getNumero());
            ps.setString(8, a.getBairro());
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
