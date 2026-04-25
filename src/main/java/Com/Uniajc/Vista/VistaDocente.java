package com.uniajc.vista;
import java.util.Scanner;

public class VistaDocente {
    private Scanner scanner = new Scanner(System.in);
    public String pedirNombre() { System.out.print("Nombre Docente: "); return scanner.nextLine(); }
    public String pedirEspecialidad() { System.out.print("Especialidad: "); return scanner.nextLine(); }
}
