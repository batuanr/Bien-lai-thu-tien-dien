package io;

import model.Receipt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IO {

    public static <T> void writeFile(String url, List<T> list){
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(url);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static  List readToFile(String url){
        List list = new ArrayList<>();
        FileInputStream fis;
        try {
            fis = new FileInputStream(url);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (List) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
