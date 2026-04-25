package com.uniajc;

import com.uniajc.controlador.ControladorEstudiante;
import com.uniajc.servicios.EstudianteService;
import com.uniajc.vista.VistaEstudiante;
import com.uniajc.controlador.ControladorMateria;
import com.uniajc.controlador.ControladorDocente; // Nuevo import
import java.util.Scanner; // Import necesario para leer el teclado

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Practica MVC - Sistema academico Uniajc!");
        
        // --- ENTIDAD: ESTUDIANTE ---
        VistaEstudiante vista = new VistaEstudiante();
        EstudianteService estudianteService = new EstudianteService();
        ControladorEstudiante controlador = new ControladorEstudiante(vista, estudianteService);
        
        System.out.println("\n>>> GESTIÓN DE ESTUDIANTES");
        controlador.mostrarTodosLosEstudiantes();
        controlador.registrarEstudiante();
        controlador.mostrarTodosLosEstudiantes();

        // --- ENTIDAD: MATERIA ---
        System.out.println("\n>>> GESTIÓN DE MATERIAS");
        ControladorMateria controladorMateria = new ControladorMateria();
        
        System.out.print("Ingrese el nombre de la materia: ");
        String nombreMat = teclado.nextLine();
        System.out.print("Ingrese los créditos de la materia: ");
        int creditosMat = teclado.nextInt();
        teclado.nextLine(); // Limpiar el buffer del Enter

        controladorMateria.registrarMateria(nombreMat, creditosMat);
        controladorMateria.mostrarTodasLasMaterias();

        // --- ENTIDAD: DOCENTE ---
        System.out.println("\n>>> GESTIÓN DE DOCENTES");
        ControladorDocente controladorDocente = new ControladorDocente();

        System.out.print("Ingrese el nombre del docente: ");
        String nombreDoc = teclado.nextLine();
        System.out.print("Ingrese la especialidad del docente: ");
        String especialidadDoc = teclado.nextLine();

        controladorDocente.registrarDocente(nombreDoc, especialidadDoc);
        controladorDocente.listarDocentes();

        System.out.println("\nProceso finalizado. ¡Buen trabajo!");
    }
}