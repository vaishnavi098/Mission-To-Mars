package com.MissionToMars;
import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class FileIO {

    /**
     *Method to read Files
     */
    public String readFile(String filename){
        String output = "";
        try
        {
            FileReader inputFile = new FileReader(filename);
            Scanner parser = new Scanner(inputFile);
            StringBuffer buffer = new StringBuffer();
            while(parser.hasNext()) {
                buffer.append(parser.nextLine());
                buffer.append("\n");
            }
         output = buffer.toString();
         inputFile.close();
        }
        catch (IOException e) {
            System.out.println("File not found");
            System.exit(1);
        }
        return output;
    }
}


