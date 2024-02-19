package es.ieslavereda.exercices;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Gato  implements Serializable {
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

    public static void save(List<Gato> gatos, String file) throws IOException{
        try(ObjectOutputStream output = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(file))
        )){
            for(Gato gato: gatos)
                output.writeObject(gato);
        }
    }

    public static List<Gato> load(String file) throws IOException, ClassNotFoundException{
        try(ObjectInputStream input = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(file))
        )){
            List<Gato> cats = new ArrayList<>();
            Gato cat = (Gato) input.readObject();
            while (cat!=null){
                cats.add(cat);
                try {
                    cat = (Gato) input.readObject();
                } catch (EOFException e){
                    break;
                }
            }
            return cats;
        }
    }

    @Override
    public String toString(){
        return "Gato: " + nombre + " con edad " + edad;
    }
}
