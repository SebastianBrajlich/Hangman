import java.util.Scanner;
import java.io.*;

public class Display{

    public static void printArray(String[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static void printTopList(String fileName){
        Scanner readFile;
        try{
            readFile = new Scanner(new File(fileName));
            int count = 1;
            System.out.println("*****Top 10*****\n");
            while(readFile.hasNextLine()){
                System.out.println("" + count + ". " + readFile.nextLine());
                count ++;
            }
            
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}