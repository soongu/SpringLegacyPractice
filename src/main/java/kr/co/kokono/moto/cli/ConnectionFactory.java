package kr.co.kokono.moto.cli;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@PropertySource("classpath:application.properties")
public class ConnectionFactory {

    @Value("${jdbc.username}") private String uid;
    @Value("${jdbc.password}") private String upw;
    @Value("${jdbc.url}") private String url;
    @Value("${jdbc.driver-class}") private String driver;

    public Connection createConnection() throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        return DriverManager.getConnection(url, uid, upw);
    }

}
