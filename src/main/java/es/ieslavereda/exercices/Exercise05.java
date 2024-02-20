package es.ieslavereda.exercices;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Exercise05 {


    public static void main(String[] args) {
        List<String> libros = new ArrayList<>();
        List<String> fichero;

        int numLines, numChar, numWords;

        libros.add("Documentos/Libros/coplas_manrique.txt");
        libros.add("Documentos/Libros/fuenteovejuna_lopevega.txt");
        libros.add("Documentos/Libros/lazarillo.txt");
        libros.add("Documentos/Libros/quijote_cervantes.txt");
        libros.add("Documentos/Libros/vida_unamuno.txt");

        for(String libro:libros){
            Map<String,Integer> palabras = new HashMap<>();
            fichero = read(libro);
            numLines=fichero.size();
            numWords=numChar=0;
            //recorrer todas las líneas del libro
            for(String linea:fichero){
                String[] words = linea.split(" ");
                //no contamos las que están en blanco
                if(!(words.length==1 && words[0].equals(""))){
                    numWords += words.length;
                    for (int i = 0; i < words.length; i++) {
                        numChar += words[i].length();
                        //contar la repetición de la palabra
                        if(words[i].length()>=4 && words[i].charAt(0)!='_'){
                            int tam=0;
                            if(palabras.containsKey(words[i])){
                                tam= palabras.get(words[i]);
                            }
                            palabras.put(words[i], ++tam);
                        }
                    }
                }


            }

            System.out.println("Libro: " + libro + " líneas: " + numLines + " palabras: " + numWords +  "caracteres: " + numChar);
            palabras.entrySet().stream().
                    sorted(Map.Entry.comparingByValue(Collections.reverseOrder())).
                    limit(10).
                    forEach(System.out::println);




        }
    }

    public static List<String> read(String file) {
        List<String> resultado = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while((line=br.readLine())!=null){
                resultado.add(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return resultado;
    }

}
