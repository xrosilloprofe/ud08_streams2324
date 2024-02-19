package es.ieslavereda.exercices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *     Sobre la clase Gato creada en los ejercicios de excepciones:
 *     hacerla serializable y añadir dos métodos: load que devuelve una lista de gatos (List)
 *     y tiene como parámetro un String que contendrá el nombre del fichero;
 *     y el otro que se llame save y que guarda en un fichero que le pasamos como parámetro
 *     una lista de gatos (que le pasamos también como parámetro).
 *     Crear un main para probarlo gestionando en el main las posibles excepciones.
 */

public class Exercise01 {
    public static void main(String[] args) {
        List<Gato> camada = new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        for (int i = 0; i < 5; i++) {

            try {
                System.out.print("Nombre del gato: ");
                String nombre = scanner.next();
                System.out.print("Edad del gato: ");
                int edad = scanner.nextInt();
                camada.add(new Gato(nombre, edad));
            } catch (InputMismatchException e){
                System.err.println(e);
                scanner.nextLine();
                i--;
            } catch (ExcepcionGatuna e){
                System.err.println(e);
                i--;
            }
        }

        try{
            Gato.save(camada,"camada.dat");
        } catch (IOException e){
            e.printStackTrace();
        }


    }
}
