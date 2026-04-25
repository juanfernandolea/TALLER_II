package com.uniajc.vista;
import java.util.Scanner;

public class VistaInscripcion {
    private Scanner scanner = new Scanner(System.in);
    public int pedirIdEstudiante() { System.out.print("ID Estudiante: "); return scanner.nextInt(); }
    public int pedirIdGrupo() { System.out.print("ID Grupo: "); return scanner.nextInt(); }
    public float pedirNota() { System.out.print("Nota Final: "); return scanner.nextFloat(); }
    public String pedirEstado() { scanner.nextLine(); System.out.print("Estado: "); return scanner.nextLine(); }
}