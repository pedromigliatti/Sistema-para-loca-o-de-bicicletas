/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Locacao;
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
public class LocacaoDAO {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    public LocacaoDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/Sistema-de-locacao-de-bicicletas", "root", "root");
    }
    
    public void insert(Locacao locacao) {

        String userSql = "Insert into Locacao (data_hora, cpf_cliente, cnpj_locadora) "
                    + "values (?,?,?)";

        try {
            Connection conn = this.getConnection();
             PreparedStatement userStatement = conn.prepareStatement(userSql);

            userStatement = conn.prepareStatement(userSql);
            userStatement.setDate(1, (Date) locacao.getDataHora());
            userStatement.setString(3, locacao.getCnpjLocadora());
            userStatement.setString(4, locacao.getCpfCliente());
            userStatement.execute();
            
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Locacao> getAll() {

        List<Locacao> listaLocacao = new ArrayList<>();

        String sql = "SELECT * FROM Locacao";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String cpf = resultSet.getString("cpf_cliente");
                String cnpj = resultSet.getString("cnpj_locadora");
                Date data = resultSet.getDate("data_hora");
               

                Locacao locacao = new Locacao(id,  data, cpf, cnpj);
                listaLocacao.add(locacao);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocacao;
    }
    
    public List<Locacao> getAllCliente(String nome) {
        List<Locacao> listaLocacao = new ArrayList<>();
        
        String sqlNome = "SELECT * FROM Cliente WHERE email = ?";

        String sql = "SELECT * FROM Locacao WHERE cpf_cliente = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statementNome = conn.prepareStatement(sqlNome);

            statementNome = conn.prepareStatement(sqlNome);
            statementNome.setString(1, nome);
            
            ResultSet resultSet = statementNome.executeQuery();
            
            PreparedStatement statement = conn.prepareStatement(sql);
            String cpf = null;
            while (resultSet.next()) {
                cpf = resultSet.getString("cpf");
            }
            statement = conn.prepareStatement(sql);
            statement.setString(1, cpf);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String cnpj = resultSet.getString("cnpj_locadora");
                Date data = resultSet.getDate("data_hora");
               

                Locacao locacao = new Locacao(id,  data, cpf, cnpj);
                listaLocacao.add(locacao);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocacao;
    }

    public List<Locacao> getAllLocadora(String cnpj) {
        List<Locacao> listaLocacao = new ArrayList<>();

        String sql = "SELECT * FROM Locacao WHERE cnpj_locadora = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, cnpj);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String cpf = resultSet.getString("cpf_cliente");
                Date data = resultSet.getDate("data_hora");
               

                Locacao locacao = new Locacao(id,  data, cpf, cnpj);
                listaLocacao.add(locacao);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocacao;
    }
    
    public void delete(Locacao locacao) {
        String sql = "DELETE FROM Locacao where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, locacao.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public void update(Locadora locadora, int id) {
//        String userSql = "UPDATE Locadora SET email=?, senha=?, cnpj=?, nome=?, cidade=?, ativo=?";
//        userSql += " WHERE id = ?";
//
//        try {
//            Connection conn = this.getConnection();
//            PreparedStatement userStatement = conn.prepareStatement(userSql);
//
//            userStatement = conn.prepareStatement(userSql);
//            userStatement.setString(1, locadora.getEmail());
//            userStatement.setString(2, encoder.encode(locadora.getSenha()));
//            userStatement.setString(3, locadora.getCnpj());
//            userStatement.setString(4, locadora.getNome());
//            userStatement.setString(5, locadora.getCidade());
//            userStatement.setBoolean(6, true);
//            userStatement.setInt(7, id);
//            userStatement.execute();
//
//            userStatement.close();
//            conn.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public Locadora get(int id) {
//        Locadora locadora = null;
//        String sql = "SELECT * FROM Locadora WHERE id = ?";
//
//        try {
//            Connection conn = this.getConnection();
//            PreparedStatement statement = conn.prepareStatement(sql);
//            
//            statement.setInt(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                String nome = resultSet.getString("nome");
//                String email = resultSet.getString("email");
//                String cnpj = resultSet.getString("cnpj");
//                String cidade = resultSet.getString("cidade");
//                locadora = new Locadora(id, email, cnpj, nome, cidade);
// 
//            }
//
//            resultSet.close();
//            statement.close();
//            conn.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return locadora;
//    }
    
    
}
