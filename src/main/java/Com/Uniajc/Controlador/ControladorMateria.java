package com.uniajc.controlador;

import com.uniajc.modelo.Materia;
import com.uniajc.servicios.MateriaService;
import com.uniajc.vista.VistaMateria;
import java.util.List;

public class ControladorMateria {
private MateriaService service;
private VistaMateria vista;

public ControladorMateria(VistaMateria vista, MateriaService service) {
this.vista = vista;
this.service = service;
}

public void registrarMateria() {
String nombre = vista.pedirNombre();
int creditos = vista.pedirCreditos();
service.guardarMateria(nombre, creditos);
}

public void mostrarTodasLasMaterias() {
List<Materia> materias = service.obtenerTodasLasMaterias();
System.out.println("\n--- LISTA DE MATERIAS ---");
for (Materia m : materias) {
System.out.println("ID: " + m.getIdMateria() + " | " + m.getNombreMateria());
}
}
}