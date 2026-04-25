package com.uniajc.dao;

import com.uniajc.config.ConexionPostgresDatabase;
import com.uniajc.modelo.InscripcionCurso;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InscripcionCursoDao {
public void insertar(InscripcionCurso inscripcion) {
String sql = "INSERT INTO \"practica-mvc\".inscripcion_curso (id_estudiante, id_grupo, nota_final, estado) VALUES (?, ?, ?, ?)";
try (Connection conn = ConexionPostgresDatabase.getConnection();
PreparedStatement pstmt = conn.prepareStatement(sql)) {
pstmt.setInt(1, inscripcion.getIdEstudiante());
pstmt.setInt(2, inscripcion.getIdGrupo());
pstmt.setFloat(3, inscripcion.getNotaFinal());
pstmt.setString(4, inscripcion.getEstado());
pstmt.executeUpdate();
System.out.println("Inscripción realizada con éxito.");
} catch (SQLException e) {
System.out.println("Error al inscribir: " + e.getMessage());
}
}

public List<InscripcionCurso> obtenerTodas() {
List<InscripcionCurso> lista = new ArrayList<>();
String sql = "SELECT * FROM \"practica-mvc\".inscripcion_curso";
try (Connection conn = ConexionPostgresDatabase.getConnection();
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(sql)) {
while (rs.next()) {
InscripcionCurso ic = new InscripcionCurso();
ic.setIdInscripcion(rs.getInt("id_inscripcion"));
ic.setIdEstudiante(rs.getInt("id_estudiante"));
ic.setIdGrupo(rs.getInt("id_grupo"));
ic.setNotaFinal(rs.getFloat("nota_final"));
ic.setEstado(rs.getString("estado"));
lista.add(ic);
}
} catch (SQLException e) {
e.printStackTrace();
}
return lista;
}
}