/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Cliente;
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
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author pedro
 */
public class LocacaoDAO extends GenericDAO<Locacao> {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//    public LocacaoDAO() {
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
    
//    public void insert(Locacao locacao) {
//
//        String userSql = "Insert into Locacao (data_hora, cpf_cliente, cnpj_locadora) "
//                    + "values (?,?,?)";
//
//        try {
//            Connection conn = this.getConnection();
//             PreparedStatement userStatement = conn.prepareStatement(userSql);
//
//            userStatement = conn.prepareStatement(userSql);
//            userStatement.setDate(1, (Date) locacao.getDataHora());
//            userStatement.setString(3, locacao.getCnpjLocadora().getCnpj());
//            userStatement.setString(2, locacao.getCpfCliente().getCpf());
//            userStatement.execute();
//            
//            conn.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Override
    public List<Locacao> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Locacao.findAll");
        List<Locacao> listaLocacao = q.getResultList();
        em.close();

        return listaLocacao;
    }
    
    public List<Locacao> getAllCliente(String cpf) {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Locacao.findByCliente", Locacao.class);
        q.setParameter("cliente", cpf);
        List<Locacao> locacao = q.getResultList();
        em.close();
        return locacao;
    }

    public List<Locacao> getAllLocadora(String cnpj) {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Locacao.findByLocadora", Locacao.class);
        q.setParameter("locadora", cnpj);
        List<Locacao> locacao = q.getResultList();
        em.close();
        return locacao;
    }
    
    @Override
    public void delete(Locacao locacao) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        locacao = em.getReference(Locacao.class, locacao.getId());
        tx.begin();
        em.remove(locacao);
        tx.commit();}
    


    @Override
    public Locacao get(Long id) {
        EntityManager em = this.getEntityManager();
        Locacao locacao = em.find(Locacao.class, id);
        em.close();
        return locacao;
    }

    @Override
    public void save(Locacao t) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(t);
        tx.commit();
        em.close();
    }

    @Override
    void update(Locacao t) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(t);
        tx.commit();
        em.close();
    }
    
    
}
