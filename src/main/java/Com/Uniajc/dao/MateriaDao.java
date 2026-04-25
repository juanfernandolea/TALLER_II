package com.uniajc.dao;

import com.uniajc.config.ConexionPostgresDatabase;
import com.uniajc.modelo.Materia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MateriaDao {
    public void insertar(Materia materia) {
        String sql = "INSERT INTO \"practica-mvc\".materia (nombre_materia, creditos) VALUES (?, ?)";
        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, materia.getNombreMateria());
            pstmt.setInt(2, materia.getCreditos());
            pstmt.executeUpdate();
            System.out.println("Materia guardada exitosamente en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al insertar materia: " + e.getMessage());
        }
    }

    public List<Materia> obtenerTodas() {
        List<Materia> materias = new ArrayList<>();
        String sql = "SELECT * FROM \"practica-mvc\".materia";
        try (Connection conn = ConexionPostgresDatabase.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Materia m = new Materia();
                m.setIdMateria(rs.getInt("id_materia"));
                m.setNombreMateria(rs.getString("nombre_materia"));
                m.setCreditos(rs.getInt("creditos"));
                materias.add(m);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener materias: " + e.getMessage());
        }
        return materias;
    }
}