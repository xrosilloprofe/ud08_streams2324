package es.ieslavereda;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyData {
    static double[] precios = {0.99, 2.59, 1.99};
    static String[] productos = {"naranja","tomate","manzana"};
    static int[] stock = {100,200,300};

    public static void main(String[] args) {
        //guardarme los datos en un fichero
        try {
            save();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void save() throws IOException {
        try(DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("fruteria.dat")))){
            for (int i = 0; i < productos.length; i++) {
                dos.writeUTF(productos[i]);
                dos.writeDouble(precios[i]);
                dos.writeInt(stock[i]);
            }
        }
    }

    public static void load(){

    }

}
