package com.uniajc.vista;
import java.util.Scanner;

public class VistaGrupo {
    private Scanner scanner = new Scanner(System.in);
    public int pedirIdMateria() { System.out.print("ID Materia: "); return scanner.nextInt(); }
    public int pedirIdDocente() { System.out.print("ID Docente: "); return scanner.nextInt(); }
    public String pedirAula() { scanner.nextLine(); System.out.print("Aula: "); return scanner.nextLine(); }
    public String pedirHorario() { System.out.print("Horario: "); return scanner.nextLine(); }
}