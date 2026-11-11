/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info;

/**
 *
 * @author ProBook
 */
import java.io.*;
import java.util.*;
public class Saveinfo 
{
    public static void info(ArrayList<String> list, String location) 
    {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(new File(location)));

            for (String item : list) {
                writer.println(item);
            }

            writer.close();
        } 
        catch (IOException e) 
        {
        }
    }    
     public static boolean info(String name , String location) 
    {
        boolean check = false;
        try {
            FileWriter writer = new FileWriter(location);
            writer.write(name);
            writer.close();
            check = true;
        } 
        catch (IOException e) 
        {
        }
        return check;
    }
    public static String readinfo( String location) 
    {
        String num = "0";
        try (BufferedReader br = new BufferedReader(new FileReader(location))) 
        {
            String line;
            line = br.readLine();
            num = line;
        } 
        catch (IOException e) 
        {
        }
        return num;
    }
     public static ArrayList<String> readinfo(ArrayList<String> list, String location) 
     {

        try (BufferedReader br = new BufferedReader(new FileReader(location))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } 
        catch (IOException e) 
        {
            
        }
        return list;
    }
    
}
