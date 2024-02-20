package es.ieslavereda.exercices;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exercise04 {
    public static final String NOMBRES="Documentos/usa_nombres.txt";
    public static final String APELLIDOS="Documentos/usa_apellidos.txt";
    public static void main(String[] args) {
        System.out.print("¿Cuántos nombres quiere generar?: ");
        Scanner scanner = new Scanner(System.in);
        try{
            int numero = scanner.nextInt();
            List<String> nombres = read(NOMBRES);
            List<String> apellidos = read(APELLIDOS);
            writeFile(nombres, apellidos,numero);
            writeFile2(nombres, apellidos,numero);

        } catch (NumberFormatException e){
            System.err.println("Error --> " + e.getMessage());
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public static List<String> read(String file) throws IOException {
        List<String> procesado = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String linea = br.readLine();
            while(linea!=null){
                procesado.add(linea);
                linea = br.readLine();
            }
        }
        return procesado;
    }

    public static void writeFile(List<String> nombres, List<String> apellidos, int numero)
    throws IOException{
        Collections.shuffle(nombres);
        Collections.shuffle(apellidos);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("usa_personas.txt"))){
            for (int i = 0; i < numero; i++) {
                bw.write(nombres.get(i) + " " + apellidos.get(i));
                bw.newLine();
            }
        }
    }

    public static void writeFile2(List<String> nombres, List<String> apellidos, int numero)
            throws IOException{
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("usa_personas2.txt"))){
            for (int i = 0; i < numero; i++) {
                int numNom = (int) (Math.random()* nombres.size());
                int numApe = (int) (Math.random()* apellidos.size());
                bw.write(nombres.get(numNom) + " " + apellidos.get(numApe));
                bw.newLine();
            }
        }
    }

}
