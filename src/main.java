package com.uniajc;

import java.sql.Connection;

import com.uniajc.config.ConexionPostgresDatabase;
import com.uniajc.controlador.ControladorEstudiante;
import com.uniajc.servicios.EstudianteService;
import com.uniajc.vista.VistaEstudiante;

// import com.uniajc.controlador.ControladorEstudiante;
// import com.uniajc.modelo.Estudiante;
// import com.uniajc.vista.VistaEstudiante;

public class Main {
    public static void main(String[] args) {
        System.out.println("Practica MVC - Sistema academico Uniajc!");

        VistaEstudiante vista = new VistaEstudiante();
        EstudianteService estudianteService = new EstudianteService();

        // Crear el controlador y pasarle la vista y el servicio
        ControladorEstudiante controlador = new ControladorEstudiante(vista, estudianteService);

        controlador.mostrarTodosLosEstudiantes(); // Llamar al método para mostrar todos los estudiantes antes de registrar uno nuevo

        controlador.registrarEstudiante(); // Llamar al método para registrar un estudiante

        controlador.mostrarTodosLosEstudiantes(); // Llamar al método para mostrar todos los estudiantes después de registrar uno nuevo
       
    }
}