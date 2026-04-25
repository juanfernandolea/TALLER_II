package com.uniajc.controlador;

import com.uniajc.modelo.Estudiante;
import com.uniajc.servicios.EstudianteService;
import com.uniajc.vista.VistaEstudiante;

public class ControladorEstudiante {

    private VistaEstudiante vista;
    private EstudianteService servicio; // Corregido: nombre único

    public ControladorEstudiante(VistaEstudiante vista, EstudianteService servicio) {
        this.vista = vista;
        this.servicio = servicio;
    }

    public void registrarEstudiante() {
        try {
            Estudiante estudiante = vista.solicitarDatosEstudiante();
            if (estudiante != null) {
                servicio.registrarEstudiante(estudiante);
                vista.mostrarMensaje("Estudiante registrado exitosamente.");
            }
        } catch (Exception e) {
            vista.mostrarMensaje("Error al registrar el estudiante.");
        }
    }

    public void mostrarTodosLosEstudiantes() {
        vista.mostrarTodosLosEstudiantes(servicio.obtenerTodosLosEstudiantes());
    }
}
