package com.uniajc.controlador;

import com.uniajc.modelo.Grupo;
import com.uniajc.servicios.GrupoService;
import com.uniajc.vista.VistaGrupo;
import java.util.List;

public class ControladorGrupo {
private GrupoService service;
private VistaGrupo vista;

public ControladorGrupo(VistaGrupo vista, GrupoService service) {
this.vista = vista;
this.service = service;
}

public void registrarGrupo() {
int idMat = vista.pedirIdMateria();
int idDoc = vista.pedirIdDocente();
String aula = vista.pedirAula();
String hor = vista.pedirHorario();
service.guardarGrupo(idMat, idDoc, aula, hor);
}

public void mostrarGrupos() {
List<Grupo> lista = service.listarGrupos();
for (Grupo g : lista) {
System.out.println("Grupo ID: " + g.getIdGrupo() + " | Aula: " + g.getAula());
}
}
}