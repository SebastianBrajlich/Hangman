import java.util.Scanner;
import java.io.*;

public class HangmanGraphics{

    private String[] graphics = new String[10];
    private Scanner readFile;

    public HangmanGraphics(String fileName){
        try{
            this.readFile = new Scanner(new File(fileName));
            addGraphics();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    private void addGraphics(){
        for(int i = 0; i < 10; i++){
            StringBuilder graphic = new StringBuilder();
            for(int j = 0; j < 9; j++){
                graphic.append(readFile.nextLine() + "\n");
            }
            graphics[i] = graphic.toString();
        }
    }
    public void displayGraphic(int graphicNumber){
        System.out.println(graphics[graphicNumber]);
    }
    public void displayEndGame(){
        for(int i = 0; i < 6; i++){
            int graphicNumber = 8;
            System.out.println(graphics[graphicNumber]);
            sleep(500);
            clear();
            System.out.println(graphics[graphicNumber + 1]);
            sleep(500);
            clear();
        }
    }
    public static void sleep(long time){
        try{
            Thread.sleep(time);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    public static void clear(){
        try{
            Runtime.getRuntime().exec("clear");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}