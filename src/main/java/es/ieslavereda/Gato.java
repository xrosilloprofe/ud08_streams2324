package es.ieslavereda;

import java.io.Serializable;

public class Gato {
    private String nombre;
    private int edad;

    public Gato(String nombre, int edad) throws ExcepcionGatuna{
        if(edad<0)
            throw new ExcepcionGatuna("Edad incorrecta");
        this.edad = edad;
        if(nombre.length()<3)
            throw new ExcepcionGatuna("Nombre incorrecto");
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws ExcepcionGatuna{
        if(edad<0)
            throw new ExcepcionGatuna("Edad incorrecta");
        this.edad = edad;
    }

    public void setNombre(String nombre) throws ExcepcionGatuna{
        if(nombre.length()<3)
            throw new ExcepcionGatuna("Nombre incorrecto");
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return "Gato: " + nombre + " con edad " + edad;
    }
}
