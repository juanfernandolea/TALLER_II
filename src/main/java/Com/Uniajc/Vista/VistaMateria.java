package com.uniajc.vista;
import java.util.Scanner;

public class VistaMateria {
    private Scanner scanner = new Scanner(System.in);
    public String pedirNombre() { System.out.print("Nombre de Materia: "); return scanner.nextLine(); }
    public int pedirCreditos() { System.out.print("Créditos: "); int c = scanner.nextInt(); scanner.nextLine(); return c; }
}