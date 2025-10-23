package org.example;

public class Main {
    public static void main(String[] args) {
        
        Modelos modelos = new Modelos("Profesor", "Alumno", "Asignatura", "Nota", "Fecha");
        Repositorios repositorios = new Repositorios();
        repositorios.guardar(modelos);
        repositorios.buscar(modelos);
        repositorios.eliminar(modelos);

    }
}