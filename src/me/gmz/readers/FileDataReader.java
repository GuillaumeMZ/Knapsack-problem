package me.gmz.readers;

import me.gmz.backpack.IDataReader;
import me.gmz.backpack.Item;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileDataReader implements IDataReader {
    public FileDataReader(String filePath){
        try{
            file = new BufferedReader(new FileReader(filePath));
        }catch (FileNotFoundException e){
            System.err.println("File " + filePath + " wasn't found.");
        }
    }

    public ArrayList<Item> readData(){
        ArrayList<Item> items = new ArrayList<>();
        String buffer = "";
        while (buffer != null){
            try{
                buffer = file.readLine();
                if(buffer == null) break;
            }catch (IOException e){
                System.err.println(e);
            }
            String[] values = buffer.split(";");
            items.add(new Item(values[0], Float.parseFloat(values[1]), Float.parseFloat(values[2])));
        }
        return items;
    }

    private BufferedReader file;
}