package es.ieslavereda.exercices;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *  Máximo y mínimo: Implementa un programa que muestre por pantalla
 *  los valores máximos y mínimos del archivo ‘numeros.txt’.
 */
public class Exercise02 {
    public static final String fichero = "Documentos/numeros.txt";
    public static void main(String[] args) {
        //VERSIÓN 1 - CLÁSICA
        try(BufferedReader br = new BufferedReader(new FileReader(fichero))){
            int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE,num=0;
            String numCadena="";
            do{
                numCadena = br.readLine();
                if(numCadena != null){
                    num = Integer.parseInt(numCadena);
                    if(num>max)
                        max=num;
                    if(num<min)
                        min=num;
                }
            } while(numCadena!=null);

            System.out.println("Máximo: " + max + " mínimo: " + min);

        } catch (IOException e){
            e.printStackTrace();
        } catch (NumberFormatException e){
            e.printStackTrace();
        }

        //VERSIÓN 2 - CON STREAMS :)
        List<Integer> lista = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fichero))){
            String linea;
            while((linea=br.readLine())!=null){
                lista.add(Integer.parseInt(linea));
            }

            Integer maximo = lista.stream().mapToInt(n->n).max().getAsInt();
            Integer minimo = lista.stream().min(Comparator.comparingInt(Integer::intValue)).orElse(Integer.MAX_VALUE);

            System.out.println("Máximo: " + maximo + " mínimo: " + minimo);


        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
