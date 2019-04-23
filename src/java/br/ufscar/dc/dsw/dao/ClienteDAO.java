package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Cliente;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pedro
 */
public class ClienteDAO {
    
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    public ClienteDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/Sistema-de-locacao-de-bicicletas", "root", "root");
    }
    
    public void insert(Cliente cliente) {

        String userSql = "Insert into Cliente (email, senha, cpf, nome, telefone, sexo, nascimento, ativo) "
                    + "values (?,?,?,?,?,?,?,?)";
        
        String roleSql = "Insert into Papel (email, nome)"
                    + "values (?,?)";

        try {
            Connection conn = this.getConnection();
             PreparedStatement userStatement = conn.prepareStatement(userSql);

            userStatement = conn.prepareStatement(userSql);
            userStatement.setString(1, cliente.getEmail());
            userStatement.setString(2, encoder.encode(cliente.getSenha()));
            userStatement.setString(3, cliente.getCpf());
            userStatement.setString(4, cliente.getNome());
            userStatement.setString(5, cliente.getTelefone());
            userStatement.setString(6, cliente.getSexo());
            userStatement.setDate(7, (Date) cliente.getNascimento());
            userStatement.setBoolean(8, true);
            userStatement.execute();
            
            PreparedStatement roleStatement = conn.prepareStatement(roleSql);

            roleStatement = conn.prepareStatement(roleSql);
            roleStatement.setString(1, cliente.getEmail());
            roleStatement.setString(2, "ROLE_USER");
            roleStatement.execute();
            
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> getAll() {

        List<Cliente> listaClientes = new ArrayList<>();

        String sql = "SELECT * FROM Cliente";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String cpf = resultSet.getString("cpf");
                String telefone = resultSet.getString("telefone");
                String sexo = resultSet.getString("sexo");             
                Date nascimento = resultSet.getDate("nascimento");

                Cliente cliente = new Cliente(id, email, cpf, nome, telefone, sexo, nascimento);
                listaClientes.add(cliente);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaClientes;
    }

    public void delete(Cliente cliente) {
        String sql = "DELETE FROM Cliente where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, cliente.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Cliente cliente, int id) {
        String userSql = "UPDATE Cliente SET email=?, senha=?, cpf=?, nome=?, telefone=?, sexo=?, nascimento=?, ativo=?";
        userSql += " WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement userStatement = conn.prepareStatement(userSql);

            userStatement = conn.prepareStatement(userSql);
            userStatement.setString(1, cliente.getEmail());
            userStatement.setString(2, encoder.encode(cliente.getSenha()));
            userStatement.setString(3, cliente.getCpf());
            userStatement.setString(4, cliente.getNome());
            userStatement.setString(5, cliente.getTelefone());
            userStatement.setString(6, cliente.getSexo());
            userStatement.setDate(7, (Date) cliente.getNascimento());
            userStatement.setBoolean(8, true);
            userStatement.setInt(9,id);
            userStatement.execute();

            userStatement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Cliente get(String email) {
        Cliente cliente = null;
        String sql = "SELECT * FROM Cliente WHERE email = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String cpf = resultSet.getString("cpf");
                String telefone = resultSet.getString("telefone");
                String sexo = resultSet.getString("sexo");             
                Date nascimento = resultSet.getDate("nascimento");
                cliente = new Cliente(id, email, cpf, nome, telefone, sexo, nascimento);
 
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }

    public Cliente get(int id) {
        Cliente cliente = null;
        String sql = "SELECT * FROM Cliente WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String cpf = resultSet.getString("cpf");
                String telefone = resultSet.getString("telefone");
                String sexo = resultSet.getString("sexo");             
                Date nascimento = resultSet.getDate("nascimento");
                cliente = new Cliente(id, email, cpf, nome, telefone, sexo, nascimento);
 
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }
}
