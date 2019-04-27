/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.sql.DataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CriaUsuarios {

    public static void main(String[] args) throws ClassNotFoundException {

        try {

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            DataSource ds = JDBCUtil.getDataSource();

            Connection conn = ds.getConnection();

            String userSql = "Insert into Cliente (email, senha, cpf, nome, telefone, sexo, nascimento, ativo) "
                    + "values (?,?,?,?,?,?,?,?)";

            String roleSql = "Insert into Papel (email, nome)"
                    + "values (?,?)";

            // Criando Usuario admin com papel ROLE_ADMIN
//            
            PreparedStatement userStatement = conn.prepareStatement(userSql);
            userStatement.setString(1, "admin@admin");
            userStatement.setString(2, encoder.encode("admin"));
            userStatement.setString(3, "11111111155");
            userStatement.setString(4, "Berenice");
            userStatement.setString(5, "999999999");
            userStatement.setString(6, "f");
            userStatement.setDate(7, java.sql.Date.valueOf("2013-09-04"));
            userStatement.setBoolean(8, true);
            userStatement.execute();

            PreparedStatement roleStatement = conn.prepareStatement(roleSql);
            roleStatement.setString(1, "admin@admin");
            roleStatement.setString(2, "ROLE_ADMIN");
            roleStatement.execute();

            // Criando Usuario user com papel ROLE_USER
            userStatement = conn.prepareStatement(userSql);
            userStatement.setString(1, "user@user");
            userStatement.setString(2, encoder.encode("user"));
            userStatement.setString(3, "21111111155");
            userStatement.setString(4, "Berenice");
            userStatement.setString(5, "999999999");
            userStatement.setString(6, "f");
            userStatement.setDate(7, java.sql.Date.valueOf("2013-09-04"));
            userStatement.setBoolean(8, true);
            userStatement.execute();

            roleStatement = conn.prepareStatement(roleSql);
            roleStatement.setString(1, "user@user");
            roleStatement.setString(2, "ROLE_USER");
            roleStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

