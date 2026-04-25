package com.uniajc;

import com.uniajc.controlador.*;
import com.uniajc.servicios.*;
import com.uniajc.vista.*;

public class Main {
public static void main(String[] args) {
System.out.println("Practica MVC - Sistema academico Uniajc!");

// --- ENTIDAD: ESTUDIANTE ---
VistaEstudiante vistaEst = new VistaEstudiante();
EstudianteService serviceEst = new EstudianteService();
ControladorEstudiante ctrlEst = new ControladorEstudiante(vistaEst, serviceEst);

System.out.println("\n>>> GESTIÓN DE ESTUDIANTES");
ctrlEst.mostrarTodosLosEstudiantes();
ctrlEst.registrarEstudiante();
ctrlEst.mostrarTodosLosEstudiantes();

// --- ENTIDAD: MATERIA ---
VistaMateria vistaMat = new VistaMateria();
MateriaService serviceMat = new MateriaService();
ControladorMateria ctrlMat = new ControladorMateria(vistaMat, serviceMat);

System.out.println("\n>>> GESTIÓN DE MATERIAS");
ctrlMat.registrarMateria(); // La vista se encarga de pedir los datos
ctrlMat.mostrarTodasLasMaterias();

// --- ENTIDAD: DOCENTE ---
VistaDocente vistaDoc = new VistaDocente();
DocenteService serviceDoc = new DocenteService();
ControladorDocente ctrlDoc = new ControladorDocente(vistaDoc, serviceDoc);

System.out.println("\n>>> GESTIÓN DE DOCENTES");
ctrlDoc.registrarDocente();
ctrlDoc.listarDocentes();

// --- ENTIDAD: GRUPO ---
VistaGrupo vistaGrp = new VistaGrupo();
GrupoService serviceGrp = new GrupoService();
ControladorGrupo ctrlGrp = new ControladorGrupo(vistaGrp, serviceGrp);

System.out.println("\n>>> GESTIÓN DE GRUPOS");
ctrlGrp.registrarGrupo();
ctrlGrp.mostrarGrupos();

// --- ENTIDAD: INSCRIPCIÓN ---
VistaInscripcion vistaIns = new VistaInscripcion();
InscripcionCursoService serviceIns = new InscripcionCursoService();
ControladorInscripcion ctrlIns = new ControladorInscripcion(vistaIns, serviceIns);

System.out.println("\n>>> GESTIÓN DE INSCRIPCIONES");
ctrlIns.registrarInscripcion();
ctrlIns.mostrarInscripciones();

System.out.println("\nProceso finalizado. ¡Buen trabajo!");
}
}