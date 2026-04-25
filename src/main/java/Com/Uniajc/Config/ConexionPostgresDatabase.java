package com.uniajc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConexionPostgresDatabase {
// Aquí estaba el error (estaba cortado en dos líneas)
private static Connection connection = null;

public static Connection getConnection() {
Properties properties = new Properties();
if (connection == null) {
try {
// Asegúrate de que el archivo se llame config.properties y esté en la raíz del proyecto
properties.load(new FileInputStream(new File("config.properties")));

String url = properties.getProperty("db.url");
String user = properties.getProperty("db.user");
String password = properties.getProperty("db.password");

connection = DriverManager.getConnection(url, user, password);
System.out.println("Conexión a base de datos exitosa.");
} catch (SQLException error) {
System.out.println("Failed to establish database connection. " + error.getMessage());
error.printStackTrace();
} catch (FileNotFoundException error) {
System.out.println("Error: No se encontró el archivo config.properties");
error.printStackTrace();
} catch (IOException error) {
error.printStackTrace();
}
}
return connection;
}

public static void closeConnection() {
if (connection != null) {
try {
connection.close();
connection = null; // IMPORTANTE: Resetear a null para poder reconectar luego
System.out.println("Database connection closed successfully.");
} catch (SQLException e) {
e.printStackTrace();
System.out.println("Failed to close database connection. " + e.getMessage());
}
}
}
}