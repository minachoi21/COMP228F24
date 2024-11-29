package org.example.minachoi_comp228lab5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws IOException, SQLException {
        Properties properties = new Properties();

        try (InputStream inputStream = DatabaseConnection.class.getResourceAsStream("/org/example/minachoi_comp228lab5/application.properties")) {
            if (inputStream == null) {
                throw new FileNotFoundException("Property file 'application.properties' not found in the classpath");
            }
            properties.load(inputStream);
        }

        String url = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");

        return DriverManager.getConnection(url, username, password);
    }

}
