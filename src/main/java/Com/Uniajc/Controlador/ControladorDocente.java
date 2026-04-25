package com.uniajc.controlador;

import com.uniajc.modelo.Docente;
import com.uniajc.servicios.DocenteService;
import com.uniajc.vista.VistaDocente;
import java.util.List;

public class ControladorDocente {
private DocenteService service;
private VistaDocente vista;

public ControladorDocente(VistaDocente vista, DocenteService service) {
this.vista = vista;
this.service = service;
}

public void registrarDocente() {
String nombre = vista.pedirNombre();
String espec = vista.pedirEspecialidad();
service.guardarDocente(nombre, espec);
}

public void listarDocentes() {
List<Docente> lista = service.obtenerTodos();
for (Docente d : lista) {
System.out.println("ID: " + d.getIdDocente() + " | Prof: " + d.getNombre());
}
}
}