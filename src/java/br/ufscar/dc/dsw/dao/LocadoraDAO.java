/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Cliente;
import br.ufscar.dc.dsw.pojo.Locadora;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author pedro
 */
public class LocadoraDAO {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    public LocadoraDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/Sistema-de-locacao-de-bicicletas", "root", "root");
    }
    
    public void insert(Locadora locadora) {

        String userSql = "Insert into Locadora (email, senha, cnpj, nome, cidade, ativo) "
                    + "values (?,?,?,?,?,?)";
        
        String roleSql = "Insert into Papel (email, nome)"
                    + "values (?,?)";

        try {
            Connection conn = this.getConnection();
             PreparedStatement userStatement = conn.prepareStatement(userSql);

            userStatement = conn.prepareStatement(userSql);
            userStatement.setString(1, locadora.getEmail());
            userStatement.setString(2, encoder.encode(locadora.getSenha()));
            userStatement.setString(3, locadora.getCnpj());
            userStatement.setString(4, locadora.getNome());
            userStatement.setString(5, locadora.getCidade());
            userStatement.setBoolean(6, true);
            userStatement.execute();
            
            PreparedStatement roleStatement = conn.prepareStatement(roleSql);

            roleStatement = conn.prepareStatement(roleSql);
            roleStatement.setString(1, locadora.getEmail());
            roleStatement.setString(2, "ROLE_LOCADORA");
            roleStatement.execute();
            
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Locadora> getAll() {

        List<Locadora> listaLocadoras = new ArrayList<>();

        String sql = "SELECT * FROM Locadora";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String cnpj = resultSet.getString("cnpj");
                String cidade = resultSet.getString("cidade");
               

                Locadora locadora = new Locadora(id, email, cnpj, nome, cidade);
                listaLocadoras.add(locadora);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocadoras;
    }

    public void delete(Locadora locadora) {
        String sql = "DELETE FROM Locadora where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, locadora.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Locadora locadora, int id) {
        String userSql = "UPDATE Locadora SET email=?, senha=?, cnpj=?, nome=?, cidade=?, ativo=?";
        userSql += " WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement userStatement = conn.prepareStatement(userSql);

            userStatement = conn.prepareStatement(userSql);
            userStatement.setString(1, locadora.getEmail());
            userStatement.setString(2, encoder.encode(locadora.getSenha()));
            userStatement.setString(3, locadora.getCnpj());
            userStatement.setString(4, locadora.getNome());
            userStatement.setString(5, locadora.getCidade());
            userStatement.setBoolean(6, true);
            userStatement.setInt(7, id);
            userStatement.execute();

            userStatement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Locadora get(int id) {
        Locadora locadora = null;
        String sql = "SELECT * FROM Locadora WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String cnpj = resultSet.getString("cnpj");
                String cidade = resultSet.getString("cidade");
                locadora = new Locadora(id, email, cnpj, nome, cidade);
 
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return locadora;
    }
    
}
