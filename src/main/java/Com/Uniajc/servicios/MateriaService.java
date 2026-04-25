package com.uniajc.servicios;

import com.uniajc.dao.MateriaDao;
import com.uniajc.modelo.Materia;
import java.util.List;

public class MateriaService {
private MateriaDao materiaDao = new MateriaDao();

public void guardarMateria(String nombre, int creditos) {
Materia nuevaMateria = new Materia(nombre, creditos);
materiaDao.insertar(nuevaMateria);
}

public List<Materia> obtenerTodasLasMaterias() {
return materiaDao.obtenerTodas();
}
}
