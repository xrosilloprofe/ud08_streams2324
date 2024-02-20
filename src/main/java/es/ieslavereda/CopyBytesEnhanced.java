package es.ieslavereda;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytesEnhanced {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("Jack_Russell_Terrier_1.jpg");
        FileOutputStream fos = new FileOutputStream("copia.jpg")){

            int copia;
            while((copia=fis.read())!=-1)
                fos.write(copia);

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
