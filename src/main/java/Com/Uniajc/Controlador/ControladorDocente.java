package com.uniajc.controlador;

import com.uniajc.modelo.Docente;
import com.uniajc.servicios.DocenteService;
import java.util.List;

public class ControladorDocente {
    private DocenteService service = new DocenteService();

    public void registrarDocente(String nombre, String especialidad) {
        service.guardarDocente(nombre, especialidad);
    }

    public void listarDocentes() {
        List<Docente> lista = service.obtenerTodos();
        System.out.println("\n--- Lista de Docentes ---");
        for (Docente d : lista) {
            System.out.println("ID: " + d.getIdDocente() + " | Nombre: " + d.getNombre() + " | Especialidad: " + d.getEspecialidad());
        }
    }
}