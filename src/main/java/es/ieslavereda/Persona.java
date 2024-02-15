package es.ieslavereda;

import java.io.Serializable;
import java.time.LocalDate;

public class Persona implements Comparable<Persona>, Serializable {
    private String nombre;
    private String apellidos;
    private LocalDate fechaNac;


    public Persona(String nombre, String apellidos, LocalDate fechaNac) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNac = fechaNac;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNac=" + fechaNac +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Persona persona = (Persona) object;
        return nombre.equals(persona.nombre) && apellidos.equals(persona.apellidos);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode() + apellidos.hashCode();
    }


    @Override
    public int compareTo(Persona o) {
        if (apellidos.equals(o.getApellidos()))
            return nombre.compareTo(o.getNombre());
        return apellidos.compareTo(o.getApellidos());
    }
}