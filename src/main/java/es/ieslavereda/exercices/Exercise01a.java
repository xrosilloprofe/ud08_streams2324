package es.ieslavereda.exercices;

import java.io.IOException;
import java.util.List;

public class Exercise01a {
    public static void main(String[] args) {
        try{
            List<Gato> camada=Gato.load("camada.dat");
            System.out.println(camada);
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
