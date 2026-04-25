package com.uniajc.servicios;

import com.uniajc.dao.GrupoDao;
import com.uniajc.modelo.Grupo;
import java.util.List;

public class GrupoService {
private GrupoDao grupoDao = new GrupoDao();

public void guardarGrupo(int idMateria, int idDocente, String aula, String horario) {
Grupo nuevo = new Grupo(idMateria, idDocente, aula, horario);
grupoDao.insertar(nuevo);
}

public List<Grupo> listarGrupos() {
return grupoDao.obtenerTodos();
}
}