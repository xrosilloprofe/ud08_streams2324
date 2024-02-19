package es.ieslavereda;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Example02 {
    public static void main(String[] args) {
        List<Persona> personas = new LinkedList<>();
        personas.add(new Persona("Xavier","Rosillo", LocalDate.of(1973,2,14)));
        personas.add(new Persona("Lucía","Navarro", LocalDate.of(1995,12,24)));
        personas.add(new Persona("Isabel","Guerrero", LocalDate.of(2000,1,4)));
        personas.add(new Persona("Raquel","García", LocalDate.of(1979,6,5)));
        personas.add(new Persona("Manuel","Pimentel", LocalDate.of(1983,5,25)));

        try{
            save(personas);
            List<Persona> lectura = load();
            System.out.println(lectura);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void save(List<Persona> personas) throws IOException{
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("personas.csv"))){
            for (Persona p:personas){
                bw.write(p.getNombre()+";"+p.getApellidos()+";"+p.getFechaNac());
                bw.newLine();
            }
        }
    }

    public static List<Persona> load() throws IOException{
        List<Persona> personas = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("personas.csv"))){
            String linea;
            while((linea=br.readLine())!=null){
                String[] datosPersona = linea.split(";");
                personas.add(new Persona(datosPersona[0],datosPersona[1],LocalDate.parse(datosPersona[2])));
            }
        }
        return personas;
    }

}
