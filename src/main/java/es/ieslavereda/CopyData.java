package es.ieslavereda;

import java.io.*;

import static java.io.DataInputStream.readUTF;

public class CopyData {
    static double[] precios = {0.99, 2.59, 1.99};
    static String[] productos = {"naranja","tomate","manzana"};
    static int[] stock = {100,200,300};

    public static void main(String[] args) {
        //guardarme los datos en un fichero
        try {
            save();
            load();
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

    public static void load() throws IOException{
        try(DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("fruteria.dat")))){
            double precio;
            String producto;
            int stock;

            while(true){
                producto = dis.readUTF();
                precio = dis.readDouble();
                stock = dis.readInt();
                System.out.println("Producto: " + producto + " precio: " + precio + " stock: " + stock);
            }
        } catch (EOFException e){
        }
    }

}
