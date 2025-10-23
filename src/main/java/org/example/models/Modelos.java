package org.example.models;

import java.util.Objects;

public class Modelos {
    private String profesor;
    private String alumno;
    private String asignatura;
    private String nota;
    private String fecha;

    public Modelos(String profesor, String alumno, String asignatura, String nota, String fecha) {
        this.profesor = profesor;
        this.alumno = alumno;
        this.asignatura = asignatura;
        this.nota = nota;
        this.fecha = fecha;
    }

    // Getters
    public String getProfesor() {
        return profesor;
    }

    public String getAlumno() {
        return alumno;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public String getNota() {
        return nota;
    }

    public String getFecha() {
        return fecha;
    }

    // Setters
    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Proporciona una representación en cadena del objeto Modelos.
     * Útil para depuración y visualización.
     */
    @Override
    public String toString() {
        return "Registro{" +
               "profesor='" + profesor + '\'' +
               ", alumno='" + alumno + '\'' +
               ", asignatura='" + asignatura + '\'' +
               ", nota='" + nota + '\'' +
               ", fecha='" + fecha + '\'' +
               '}';
    }

    /**
     * Define la igualdad de dos objetos Modelos basándose en alumno, asignatura y fecha.
     * Esto es clave para buscar y actualizar registros de asistencia únicos.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modelos modelos = (Modelos) o;
        return Objects.equals(alumno, modelos.alumno) &&
               Objects.equals(asignatura, modelos.asignatura) &&
               Objects.equals(fecha, modelos.fecha);
    }

    /**
     * Genera un código hash para el objeto Modelos basándose en alumno, asignatura y fecha.
     * Necesario cuando se sobrescribe equals().
     */
    @Override
    public int hashCode() {
        return Objects.hash(alumno, asignatura, fecha);
    }
}
