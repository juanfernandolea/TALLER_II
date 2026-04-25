package com.uniajc.servicios;

import com.uniajc.dao.DocenteDao;
import com.uniajc.modelo.Docente;
import java.util.List;

public class DocenteService {
private DocenteDao docenteDao = new DocenteDao();

public void guardarDocente(String nombre, String especialidad) {
Docente nuevo = new Docente(nombre, especialidad);
docenteDao.insertar(nuevo);
}

public List<Docente> obtenerTodos() {
return docenteDao.obtenerTodos();
}
}