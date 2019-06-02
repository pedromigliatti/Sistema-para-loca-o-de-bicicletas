/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Cliente;
import br.ufscar.dc.dsw.pojo.Locadora;
import br.ufscar.dc.dsw.pojo.Papel;
import br.ufscar.dc.dsw.pojo.Usuario;
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
public class LocadoraDAO extends GenericDAO<Locadora> {
    
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//    public LocadoraDAO() {
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
//    
//    public void insert(Locadora locadora) {
//
//        String userSql = "Insert into Locadora (email, senha, cnpj, nome, cidade, ativo) "
//                    + "values (?,?,?,?,?,?)";
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
//            userStatement.setString(1, locadora.getEmail());
//            userStatement.setString(2, locadora.getSenha());
//            userStatement.setString(3, locadora.getCnpj());
//            userStatement.setString(4, locadora.getNome());
//            userStatement.setString(5, locadora.getCidade());
//            userStatement.setBoolean(6, true);
//            userStatement.execute();
//            
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1,locadora.getEmail());
//            statement.setString(2,locadora.getSenha());
//            statement.setBoolean(3,true);
//            statement.execute();
//            
//            
//            PreparedStatement roleStatement = conn.prepareStatement(roleSql);
//
//            roleStatement = conn.prepareStatement(roleSql);
//            roleStatement.setString(1, locadora.getEmail());
//            roleStatement.setString(2, "ROLE_USER");
//            roleStatement.execute();
//            
//            conn.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Override
    public List<Locadora> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Locadora.findAll");
        List<Locadora> listaLocadoras = q.getResultList();
        em.close();

        return listaLocadoras;
    }
    
    @Override
    public void delete(Locadora locadora) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        locadora = em.getReference(Locadora.class, locadora.getId());
        tx.begin();
        em.remove(locadora);
        tx.commit();
    }

    @Override
    public void update(Locadora locadora) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(locadora);
        tx.commit();
        em.close();
    }

    @Override
    public Locadora get(Integer id) {
        EntityManager em = this.getEntityManager();
        Locadora locadora = em.find(Locadora.class, id);
        em.close();
        return locadora;
    }
    
    public Locadora get(String email) {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Locadora.findByEmail", Locadora.class);
        q.setParameter("email", email);
        List<Locadora> locadoras = q.getResultList();
        em.close();
        Locadora locadora;
        if(locadoras.isEmpty()){
            locadora = null;
        } else{ 
            locadora = locadoras.get(0);
        }
        return locadora;
    }
    
    public Locadora getCnpj(String cnpj) {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Locadora.findByCnpj", Locadora.class);
        q.setParameter("cnpj", cnpj);
        List<Locadora> locadoras = q.getResultList();
        Locadora locadora;
        if(locadoras.isEmpty()){
            locadora = null;
        } else{ 
            locadora = locadoras.get(q.getFirstResult());
        }
        em.close();
        return locadora;
    }
    
    public List<Locadora> getCidade(String cidade) {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Locadora.findByCidade", Locadora.class);
        q.setParameter("cidade", cidade);
        List<Locadora> locadoras = q.getResultList();
        return locadoras;
    }


    @Override
    public void save(Locadora locadora) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(locadora);
        tx.commit();
        em.close();
        
        Papel papel = new Papel();
        papel.setEmail(locadora.getEmail());
        papel.setNome("ROLE_USER");
        
        PapelDAO papelDAO = new PapelDAO();
        papelDAO.save(papel);
        
        Usuario usuario = new Usuario();
        usuario.setAtivo(Boolean.TRUE);
        usuario.setEmail(locadora.getEmail());
        usuario.setSenha(locadora.getSenha());
        
        usuarioDAO.save(usuario);
    }

    
}
