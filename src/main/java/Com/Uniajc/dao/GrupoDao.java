package com.uniajc.dao;

import com.uniajc.config.ConexionPostgresDatabase;
import com.uniajc.modelo.Grupo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GrupoDao {
public void insertar(Grupo grupo) {
String sql = "INSERT INTO \"practica-mvc\".grupo (id_materia, id_docente, aula, horario) VALUES (?, ?, ?, ?)";
try (Connection conn = ConexionPostgresDatabase.getConnection();
PreparedStatement pstmt = conn.prepareStatement(sql)) {
pstmt.setInt(1, grupo.getIdMateria());
pstmt.setInt(2, grupo.getIdDocente());
pstmt.setString(3, grupo.getAula());
pstmt.setString(4, grupo.getHorario());
pstmt.executeUpdate();
System.out.println("Grupo creado exitosamente.");
} catch (SQLException e) {
System.out.println("Error al crear grupo: " + e.getMessage());
}
}

public List<Grupo> obtenerTodos() {
List<Grupo> grupos = new ArrayList<>();
String sql = "SELECT * FROM \"practica-mvc\".grupo";
try (Connection conn = ConexionPostgresDatabase.getConnection();
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(sql)) {
while (rs.next()) {
Grupo g = new Grupo();
g.setIdGrupo(rs.getInt("id_grupo"));
g.setIdMateria(rs.getInt("id_materia"));
g.setIdDocente(rs.getInt("id_docente"));
g.setAula(rs.getString("aula"));
g.setHorario(rs.getString("horario"));
grupos.add(g);
}
} catch (SQLException e) {
e.printStackTrace();
}
return grupos;
}
}