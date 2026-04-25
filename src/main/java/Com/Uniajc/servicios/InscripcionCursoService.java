package com.uniajc.servicios;

import com.uniajc.dao.InscripcionCursoDao;
import com.uniajc.modelo.InscripcionCurso;
import java.util.List;

public class InscripcionCursoService {
private InscripcionCursoDao dao = new InscripcionCursoDao();

public void guardarInscripcion(int idEst, int idGrp, float nota, String estado) {
InscripcionCurso nueva = new InscripcionCurso(idEst, idGrp, nota, estado);
dao.insertar(nueva);
}

public List<InscripcionCurso> obtenerTodas() {
return dao.obtenerTodas();
}
}