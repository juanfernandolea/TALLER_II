package com.uniajc.controlador;

import com.uniajc.modelo.Materia;
import com.uniajc.servicios.MateriaService;
import java.util.List;

public class ControladorMateria {
    private MateriaService materiaService = new MateriaService();

    public void registrarMateria(String nombre, int creditos) {
        materiaService.guardarMateria(nombre, creditos);
    }

    public void mostrarTodasLasMaterias() {
        List<Materia> materias = materiaService.obtenerTodasLasMaterias();
        System.out.println("\n--- Lista de Materias ---");
        for (Materia m : materias) {
            System.out.println("ID: " + m.getIdMateria() + " | Nombre: " + m.getNombreMateria() + " | Créditos: " + m.getCreditos());
        }
    }
}