import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Rank{

    private List<Score> listOfScores = new ArrayList<Score>();

    private Scanner readFile;
    
    public Rank(String fileName){
        try{
            this.readFile = new Scanner(new File(fileName));
            addScoreFromFile();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    private void addScoreFromFile(){
        int name = 0;
        int time = 1;
        int attempts = 2;
        while(readFile.hasNextLine()){
            String[] line = readFile.nextLine().split(" \\| ");
            listOfScores.add(new Score(line[name], line[time], line[attempts]));
        }
        readFile.close();
    }
    public void addScore(Score score){
        listOfScores.add(score);
    }
    public void sortListOdScores(){
        Collections.sort(listOfScores);
    }
    public List<Score> getListOfScores(){
        return listOfScores;
    }
}