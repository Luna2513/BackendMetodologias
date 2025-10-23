package org.example;

import org.example.models.Modelos;
import org.example.repository.Repositorios;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Repositorios repositorios = new Repositorios();
        // Usamos try-with-resources para asegurar que el Scanner se cierre automáticamente
        try (Scanner scanner = new Scanner(System.in)) {
            boolean salir = false;

            while (!salir) {
                System.out.println("\n--- Sistema de Gestión de Asistencia ---");
                System.out.println("1. Registrar o Actualizar Asistencia");
                System.out.println("2. Buscar Registro de Asistencia");
                System.out.println("3. Mostrar Todos los Registros");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");

                int opcion = -1;
                try {
                    opcion = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Error: Por favor, ingrese un número válido.");
                    continue;
                }

                switch (opcion) {
                    case 1:
                        System.out.println("\n--- Registrar/Actualizar Asistencia ---");
                        System.out.print("Nombre del Alumno: ");
                        String alumno = scanner.nextLine();
                        System.out.print("Asignatura: ");
                        String asignatura = scanner.nextLine();
                        System.out.print("Fecha (YYYY-MM-DD): ");
                        String fecha = scanner.nextLine();
                        System.out.print("Estado de Asistencia (Presente, Ausente, Tardanza): ");
                        String nota = scanner.nextLine();
                        System.out.print("Nombre del Profesor: ");
                        String profesor = scanner.nextLine();

                        Modelos nuevoRegistro = new Modelos(profesor, alumno, asignatura, nota, fecha);
                        repositorios.registrarAsistencia(nuevoRegistro);
                        break;

                    case 2:
                        System.out.println("\n--- Buscar Registro de Asistencia ---");
                        System.out.print("Nombre del Alumno a buscar: ");
                        String alumnoBusqueda = scanner.nextLine();
                        System.out.print("Asignatura a buscar: ");
                        String asignaturaBusqueda = scanner.nextLine();
                        System.out.print("Fecha a buscar (YYYY-MM-DD): ");
                        String fechaBusqueda = scanner.nextLine();

                        Optional<Modelos> registroEncontrado = repositorios.buscar(alumnoBusqueda, asignaturaBusqueda, fechaBusqueda);
                        if (registroEncontrado.isPresent()) {
                            System.out.println("Registro encontrado: " + registroEncontrado.get());
                        } else {
                            System.out.println("No se encontró ningún registro con esos datos.");
                        }
                        break;

                    case 3:
                        System.out.println("\n--- Todos los Registros de Asistencia ---");
                        List<Modelos> todos = repositorios.obtenerTodos();
                        if (todos.isEmpty()) {
                            System.out.println("No hay registros de asistencia guardados.");
                        } else {
                            todos.forEach(System.out::println);
                        }
                        break;

                    case 4:
                        salir = true;
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                        break;
                }
            }
        }
    }
}