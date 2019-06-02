/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw;

import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.dao.LocadoraDAO;
import br.ufscar.dc.dsw.dao.PapelDAO;
import br.ufscar.dc.dsw.pojo.Usuario;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.pojo.Cliente;
import br.ufscar.dc.dsw.pojo.Locadora;
import br.ufscar.dc.dsw.pojo.Papel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.sql.DataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CriaUsuarios {

    public static void main(String[] args) throws ClassNotFoundException {

        try {

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            DataSource ds = JDBCUtil.getDataSource();


            // Criando Usuario admin com papel ROLE_ADMIN
            
            
//            Cliente cliente = new Cliente();
//            cliente.setEmail("admin@admin");
//            cliente.setSenha(encoder.encode("admin"));
//            cliente.setCpf("11111111155");
//            cliente.setNome("Berenice");
//            cliente.setTelefone("999999999");
//            cliente.setSexo("f");
//            cliente.setNascimento(java.sql.Date.valueOf("2013-09-04"));
//            cliente.setAtivo(Boolean.TRUE);
            ClienteDAO clienteDAO = new ClienteDAO();
//            clienteDAO.save(cliente);
            
            Usuario usuario = new Usuario();
            usuario.setEmail("admin@admin");
            usuario.setSenha(encoder.encode("admin"));
            usuario.setAtivo(Boolean.TRUE);
            
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.save(usuario);
            
            PapelDAO papelDAO = new PapelDAO();
            Papel papel = new Papel();
            
            papel.setEmail("admin@admin");
            papel.setNome("ROLE_ADMIN");

            papelDAO.save(papel);
            // Criando Usuario user com papel ROLE_USER
            
            Locadora locadora = new Locadora();
            locadora.setEmail("loc@loc");
            locadora.setSenha(encoder.encode("user"));
            locadora.setCidade("Araras");
            locadora.setNome("loc");
            locadora.setCnpj("11111111111");
            locadora.setAtivo(true);
            
            LocadoraDAO locadoraDAO = new LocadoraDAO();
            locadoraDAO.save(locadora);

            Usuario usuario3 = new Usuario();
            usuario3.setEmail("loc@loc");
            usuario3.setSenha(encoder.encode("loc"));
            usuario3.setAtivo(Boolean.TRUE);
            
            usuarioDAO.save(usuario3);
            
            Cliente cliente2 = new Cliente();
            cliente2.setEmail("user@user");
            cliente2.setSenha(encoder.encode("user"));
            cliente2.setCpf("21111111155");
            cliente2.setNome("Berenice");
            cliente2.setTelefone("999999999");
            cliente2.setSexo("f");
            cliente2.setNascimento(java.sql.Date.valueOf("2013-09-04"));
            cliente2.setAtivo(Boolean.TRUE);
            
            clienteDAO.save(cliente2);
            
            Usuario usuario2 = new Usuario();
            usuario2.setEmail("user@user");
            usuario2.setSenha(encoder.encode("user"));
            usuario2.setAtivo(Boolean.TRUE);
            
            usuarioDAO.save(usuario2);

            
            Papel papel2 = new Papel();
            papel2.setEmail("user@user");
            papel2.setNome("ROLE_USER");
            papelDAO.save(papel2);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

