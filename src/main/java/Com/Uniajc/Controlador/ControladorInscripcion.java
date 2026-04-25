package com.uniajc.controlador;

import com.uniajc.modelo.InscripcionCurso;
import com.uniajc.servicios.InscripcionCursoService;
import com.uniajc.vista.VistaInscripcion;
import java.util.List;

public class ControladorInscripcion {
    private InscripcionCursoService service;
    private VistaInscripcion vista;

    public ControladorInscripcion(VistaInscripcion vista, InscripcionCursoService service) {
        this.vista = vista;
        this.service = service;
    }

    public void registrarInscripcion() {
        int idEst = vista.pedirIdEstudiante();
        int idGrp = vista.pedirIdGrupo();
        float nota = vista.pedirNota();
        String estado = vista.pedirEstado();
        service.guardarInscripcion(idEst, idGrp, nota, estado);
    }

    public void mostrarInscripciones() {
        List<InscripcionCurso> lista = service.obtenerTodas();
        for (InscripcionCurso ic : lista) {
            System.out.println("Inscripción: " + ic.getIdInscripcion() + " | Nota: " + ic.getNotaFinal());
        }
    }
}