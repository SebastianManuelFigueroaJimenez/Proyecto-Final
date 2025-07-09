
package com.mycompany.remontada;

import java.util.ArrayList;
import java.util.Scanner;

class Estudiante {
    private String nombre;
    private ArrayList<Double> notas;

    public Estudiante(String nombre) {
        this.nombre = nombre;
        this.notas = new ArrayList<>();
    }

    public void agregarNota(double nota) {
        notas.add(nota);
    }

    public double calcularPromedio() {
        if (notas.isEmpty()) return 0;
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.size();
    }

    public void mostrarNotas() {
        System.out.println("Notas de " + nombre + ": " + notas);
        System.out.printf("Promedio: %.2f\n", calcularPromedio());
    }

    public String getNombre() {
        return nombre;
    }
}

public class RegistroNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        while (true) {
            System.out.println("\n📚 MENÚ DE REGISTRO DE NOTAS");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Agregar nota a estudiante");
            System.out.println("3. Mostrar notas de estudiante");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String nombre = scanner.nextLine();
                    estudiantes.add(new Estudiante(nombre));
                    System.out.println("Estudiante agregado.");
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del estudiante: ");
                    nombre = scanner.nextLine();
                    Estudiante estudiante = buscarEstudiante(estudiantes, nombre);
                    if (estudiante != null) {
                        System.out.print("Ingrese la nota: ");
                        double nota = scanner.nextDouble();
                        estudiante.agregarNota(nota);
                        System.out.println("Nota agregada.");
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del estudiante: ");
                    nombre = scanner.nextLine();
                    estudiante = buscarEstudiante(estudiantes, nombre);
                    if (estudiante != null) {
                        estudiante.mostrarNotas();
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    public static Estudiante buscarEstudiante(ArrayList<Estudiante> lista, String nombre) {
        for (Estudiante e : lista) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return e;
            }
        }
        return null;
    }
}
