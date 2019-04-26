package br.ufscar.dc.dsw.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

public abstract class GenericDAO<T> {

    protected Connection connection;

    public GenericDAO() {
        Properties properties = new Properties();
        try {
            InputStream stream = this.getClass().getResourceAsStream("/bd.properties");
            properties.load(stream);
            String driver = properties.getProperty("connection.driver_class");
            String url = properties.getProperty("connection.url");
            String user = properties.getProperty("connection.username");
            String password = properties.getProperty("connection.password");
            Class.forName(driver).newInstance();
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    abstract public void save(T t);

    abstract List<T> getAll();
}
