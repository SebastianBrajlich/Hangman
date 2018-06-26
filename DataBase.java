import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class DataBase{
   
    private ArrayList<Country> countries = new ArrayList<Country>();
    private Scanner readFile;

    public DataBase(String fileName){
        try{
            this.readFile = new Scanner(new File(fileName));
            addCountries();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    private void addCountries(){
        int country = 0;
        int capital = 1;
        while(readFile.hasNextLine()){
            String[] line = readFile.nextLine().split(" \\| ");
            countries.add(new Country(line[country], line[capital]));
        }
        readFile.close();
    }
    public ArrayList<Country> getCountries(){
        return this.countries;
    }
    public Country getCountry(){
        int index = randomGenerator(countries.size());
        return countries.get(index);
    }
    private static int randomGenerator(int value){
        Random random = new Random();
        int randomNum = random.nextInt(value);
        return randomNum;
    }
}