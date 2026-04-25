package com.uniajc.dao;

import com.uniajc.config.ConexionPostgresDatabase;
import com.uniajc.modelo.Docente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DocenteDao {
public void insertar(Docente docente) {
String sql = "INSERT INTO \"practica-mvc\".docente (nombre, especialidad) VALUES (?, ?)";
try (Connection conn = ConexionPostgresDatabase.getConnection();
    PreparedStatement pstmt = conn.prepareStatement(sql)) {
pstmt.setString(1, docente.getNombre());
pstmt.setString(2, docente.getEspecialidad());
pstmt.executeUpdate();
System.out.println("Docente guardado con éxito.");
} catch (SQLException e) {
e.printStackTrace();
}
}

public List<Docente> obtenerTodos() {
List<Docente> docentes = new ArrayList<>();
String sql = "SELECT * FROM \"practica-mvc\".docente";
try (Connection conn = ConexionPostgresDatabase.getConnection();
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql)) {
while (rs.next()) {
    Docente d = new Docente();
    d.setIdDocente(rs.getInt("id_docente"));
    d.setNombre(rs.getString("nombre"));
    d.setEspecialidad(rs.getString("especialidad"));
    docentes.add(d);
}
} catch (SQLException e) {
e.printStackTrace();
}
return docentes;
}
}