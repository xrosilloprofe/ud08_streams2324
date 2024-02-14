package es.ieslavereda;

import java.io.*;

public class CopyCharactersEnhaced2 {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("xanadu.txt"));
            PrintWriter pw = new PrintWriter(new FileWriter("copiaTexto3.txt")) ){

            String copia;
            while((copia=br.readLine())!=null){
                pw.println(copia);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
