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
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
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
public class ClienteDAO extends GenericDAO<Cliente> {
    
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//    public ClienteDAO() {
//        try {
//            Class.forName("org.apache.derby.jdbc.ClientDriver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    
//    protected Connection getConnection() throws SQLException {
//        return DriverManager.getConnection("jdbc:derby://localhost:1527/Sistema-de-locacao-de-bicicletas", "root", "root");
//    }
    
//    public void insert(Cliente cliente) {
//
//        String userSql = "Insert into Cliente (email, senha, cpf, nome, telefone, sexo, nascimento, ativo) "
//                    + "values (?,?,?,?,?,?,?,?)";
//        
//        String sql = "Insert into Usuario (email, senha, ativo) values (?,?,?)";
//        
//        String roleSql = "Insert into Papel (email, nome)"
//                    + "values (?,?)";
//
//        try {
//            Connection conn = this.getConnection();
//             PreparedStatement userStatement = conn.prepareStatement(userSql);
//
//            userStatement = conn.prepareStatement(userSql);
//            userStatement.setString(1, cliente.getEmail());
//            userStatement.setString(2, cliente.getSenha());
//            userStatement.setString(3, cliente.getCpf());
//            userStatement.setString(4, cliente.getNome());
//            userStatement.setString(5, cliente.getTelefone());
//            userStatement.setString(6, cliente.getSexo());
//            userStatement.setDate(7, (Date) cliente.getNascimento());
//            userStatement.setBoolean(8, true);
//            userStatement.execute();
//            
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1,cliente.getEmail());
//            statement.setString(2,cliente.getSenha());
//            statement.setBoolean(3,true);
//            statement.execute();
//            
//            PreparedStatement roleStatement = conn.prepareStatement(roleSql);
//
//            roleStatement = conn.prepareStatement(roleSql);
//            roleStatement.setString(1, cliente.getEmail());
//            roleStatement.setString(2, "ROLE_USER");
//            roleStatement.execute();
//            
//            conn.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Override
    public List<Cliente> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Cliente.findAll");
        List<Cliente> listaClientes = q.getResultList();
        em.close();

        return listaClientes;
    }

    /**
     *
     * @param cliente
     */
    @Override
    public void delete(Cliente cliente) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        cliente = em.getReference(Cliente.class, cliente.getId());
        tx.begin();
        em.remove(cliente);
        tx.commit();
    }

    @Override
    public void update(Cliente cliente) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(cliente);
        tx.commit();
        em.close();
    }
    
    @Override
    public Cliente get(Long id) {
        EntityManager em = this.getEntityManager();
        Cliente cliente = em.find(Cliente.class, id);
        em.close();
        return cliente;
    }
    
    public Cliente get(String nome) {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Cliente.findByNome", Cliente.class);
        q.setParameter("nome", nome);
        List<Cliente> cliente = q.getResultList();
        em.close();
        return cliente.get(0); 
    }


    @Override
    public void save(Cliente cliente) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(cliente);
        tx.commit();
        em.close();
    }
    
    public Cliente getCpf(String cpf){
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Cliente.findByCpf", Cliente.class);
        q.setParameter("cpf", cpf);
        List<Cliente> cliente = q.getResultList();
        em.close();
        return cliente.get(0);
    }

}
