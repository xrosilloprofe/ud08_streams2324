package es.ieslavereda;

import java.io.*;

public class CopyCharactersEnhaced {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("xanadu.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("copiaTexto2.txt")) ){

            String copia;
            while((copia=br.readLine())!=null){
                bw.write(copia);
                bw.newLine();
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
