package com.uniajc;

import com.uniajc.controlador.ControladorEstudiante;
import com.uniajc.servicios.EstudianteService;
import com.uniajc.vista.VistaEstudiante;

public class Main {
    public static void main(String[] args) {
        System.out.println("Practica MVC - Sistema academico Uniajc!");
        
        VistaEstudiante vista = new VistaEstudiante();
        EstudianteService estudianteService = new EstudianteService();
        
        // Crear el controlador y pasarle la vista y el servicio
        ControladorEstudiante controlador = new ControladorEstudiante(vista, estudianteService);
        
        controlador.mostrarTodosLosEstudiantes();
        controlador.registrarEstudiante();
        controlador.mostrarTodosLosEstudiantes();
    }
}