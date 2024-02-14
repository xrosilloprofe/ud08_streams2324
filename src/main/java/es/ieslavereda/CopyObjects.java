package es.ieslavereda;

import java.io.*;
import java.math.BigDecimal;

public class CopyObjects {

    static BigDecimal[] precios = {new BigDecimal(0.99),
            new BigDecimal(2.59), new BigDecimal(1.99)};
    static String[] productos = {"naranja","tomate","manzana"};
    static Integer[] stock = {100,200,300};
    public static void main(String[] args) {
        try{
            save();
            load();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void save() throws IOException{
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("objectos.dat")))){
            for (int i = 0; i < productos.length; i++) {
                objectOutputStream.writeObject(productos[i]);
                objectOutputStream.writeObject(precios[i]);
                objectOutputStream.writeObject(stock[i]);
            }
        }
    }

    public static void load() throws IOException, ClassNotFoundException{
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("objectos.dat")))){
            BigDecimal precio;
            String producto;
            Integer stock;

            while(true){
                producto=(String)objectInputStream.readObject();
                precio=(BigDecimal) objectInputStream.readObject();
                stock=(Integer) objectInputStream.readObject();
                System.out.println("Producto: " + producto + " precio: " + precio + " stock: " + stock);
            }
        } catch (EOFException e){
        }
    }

}
