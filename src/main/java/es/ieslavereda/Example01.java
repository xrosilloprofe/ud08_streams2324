package es.ieslavereda;

import java.io.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Example01 {
    public static void main(String[] args) {
        List<Persona> personas = new LinkedList<>();
        personas.add(new Persona("Xavier","Rosillo", LocalDate.of(1973,2,14)));
        personas.add(new Persona("Lucía","Navarro", LocalDate.of(1995,12,24)));
        personas.add(new Persona("Isabel","Guerrero", LocalDate.of(2000,1,4)));
        personas.add(new Persona("Raquel","García", LocalDate.of(1979,6,5)));
        personas.add(new Persona("Manuel","Pimentel", LocalDate.of(1983,5,25)));

        try(ObjectOutputStream input = new ObjectOutputStream(new FileOutputStream("personas.dat"))) {
            input.writeObject(personas);
        } catch (IOException e){
            e.printStackTrace();
        }

        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("personas.dat"))) {
            List<Persona> personitas= (List<Persona>) input.readObject();
            System.out.println(personitas);

        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
