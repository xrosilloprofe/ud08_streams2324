package es.ieslavereda.exercices;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 *     Notas de alumnos: El archivo ‘alumnos_notas.txt’ contiene una lista de 10 alumnos
 *     y las notas que han obtenido en cada asignatura. El número de asignaturas de cada alumno
 *     es variable. Implementa un programa que muestre por pantalla la nota media de cada alumno
 *     junto a su nombre y apellido, ordenado por nota media de mayor a menor.
 */

public class Exercise03 {
    public static final String FICHERO ="Documentos/alumnos_notas.txt";
    public static void main(String[] args) {
        try {
            List<String> studentData = readFile();
            Map<String,Double> studentsAverage = new HashMap<>();
            String fullName;
            Double average;

            for(String student:studentData){
                String[] arrayStudent = student.split(" ");
                Double suma=0.0;
                average=0.0;
                //por si acaso
                if(arrayStudent.length<2)
                    throw new Exception("Datos insuficientes");

                fullName = arrayStudent[0]+" "+arrayStudent[1];
                for (int i = 2; i < arrayStudent.length; i++) {
                    suma += Double.parseDouble(arrayStudent[i]);
                }
                average = suma/(arrayStudent.length-2);
                studentsAverage.put(fullName,average);
            }

            System.out.println("ANTES DE ORDENARLO POR NOTA");
            System.out.println(studentsAverage);

            System.out.println("DESPUÉS DE ORDENARLO POR NOTA");
            List<Map.Entry<String,Double>> listaMapa = new ArrayList<>(studentsAverage.entrySet());
            listaMapa.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
            listaMapa.forEach(System.out::println);

            System.out.println("DESPUÉS DE ORDENARLO POR NOTA 2");
            studentsAverage.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);

        } catch (Exception e){
            e.printStackTrace();
        }


    }

    public static List<String> readFile() throws IOException {
        List<String> studentData=new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(FICHERO))){
            String linea;
            while((linea=br.readLine())!=null)
                studentData.add(linea);
        }
        return studentData;
    }

}
