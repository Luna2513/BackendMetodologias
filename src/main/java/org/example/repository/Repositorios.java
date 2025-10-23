package org.example.repository;

import org.example.models.Modelos;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional; // Necesario para el método buscar

public class Repositorios {

    // Usamos una lista estática para simular una base de datos en memoria.
    private static final List<Modelos> baseDeDatosSimulada = new ArrayList<>();

    /**
     * Guarda un registro de asistencia/nota en la base de datos.
     * Este método ha sido reemplazado por `registrarAsistencia` para manejar la lógica de actualización.
     * Se mantiene por si se necesita añadir registros sin verificar duplicados, pero `registrarAsistencia` es más robusto.
     * @param modelos El objeto Modelos a añadir.
     */
    public void guardar(Modelos modelos) {
        System.out.println("Guardando registro para el alumno: " + modelos.getAlumno());
        baseDeDatosSimulada.add(modelos);
    }

    /**
     * Registra o actualiza un registro de asistencia para un estudiante en una fecha y asignatura específicas.
     * Si ya existe un registro para el mismo alumno, asignatura y fecha, se actualiza la nota y el profesor.
     * Si no existe, se añade un nuevo registro.
     *
     * @param nuevoRegistro El objeto Modelos con la información del registro de asistencia.
     */
    public void registrarAsistencia(Modelos nuevoRegistro) {
        // Buscar si ya existe un registro para este alumno, asignatura y fecha
        Optional<Modelos> registroExistente = buscar(
            nuevoRegistro.getAlumno(),
            nuevoRegistro.getAsignatura(),
            nuevoRegistro.getFecha()
        );

        if (registroExistente.isPresent()) {
            // Si existe, actualizamos la nota y el profesor del registro existente
            Modelos modeloAActualizar = registroExistente.get();
            modeloAActualizar.setNota(nuevoRegistro.getNota());
            modeloAActualizar.setProfesor(nuevoRegistro.getProfesor());
            System.out.println("Registro de asistencia actualizado para " + nuevoRegistro.getAlumno() +
                               " en " + nuevoRegistro.getAsignatura() + " el " + nuevoRegistro.getFecha() +
                               ". Nueva nota: " + nuevoRegistro.getNota());
        } else {
            // Si no existe, añadimos el nuevo registro
            baseDeDatosSimulada.add(nuevoRegistro);
            System.out.println("Nuevo registro de asistencia añadido para " + nuevoRegistro.getAlumno() +
                               " en " + nuevoRegistro.getAsignatura() + " el " + nuevoRegistro.getFecha() +
                               ". Nota: " + nuevoRegistro.getNota());
        }
    }

    /**
     * Busca un registro de asistencia específico por alumno, asignatura y fecha.
     * Esto permite "jalar la info de un usuario ya creado" para una asistencia particular.
     *
     * @param alumno El nombre del alumno.
     * @param asignatura La asignatura.
     * @param fecha La fecha del registro.
     * @return Un Optional que contiene el Modelos si se encuentra, o un Optional vacío si no.
     */
    public Optional<Modelos> buscar(String alumno, String asignatura, String fecha) {
        System.out.println("Buscando registro para alumno: " + alumno + ", asignatura: " + asignatura + ", fecha: " + fecha);
        return baseDeDatosSimulada.stream()
                .filter(m -> m.getAlumno().equalsIgnoreCase(alumno) &&
                             m.getAsignatura().equalsIgnoreCase(asignatura) &&
                             m.getFecha().equals(fecha)) // La fecha es un String, equals es suficiente
                .findFirst();
    }

    /**
     * Obtiene todos los registros de asistencia almacenados.
     * Útil para verificar el estado de la "base de datos" simulada.
     * @return Una lista de todos los objetos Modelos.
     */
    public List<Modelos> obtenerTodos() {
        return new ArrayList<>(baseDeDatosSimulada); // Devolver una copia para evitar modificaciones externas
    }
}
