package es.ieslavereda;

import java.io.*;

public class CopyBytesEnhanced2 {
    public static void main(String[] args) {
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("Jack_Russell_Terrier_1.jpg"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("prueba.jpg"))){

            int copia;
            while((copia=bis.read())!=-1)
                bos.write(copia);

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
