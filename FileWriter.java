import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class FileWriter{

    PrintWriter writer;

    public FileWriter(String fileName){
        try{
            writer = new PrintWriter(fileName);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public void writeScore(Score score){
        writer.println(score.toString());
        writer.close();
    }
    public void writeScores(List<Score> listOfscores){
        int topListOfTenPlayers = 10;
        if(listOfscores.size() <= topListOfTenPlayers){
            for(int i = 0; i < listOfscores.size(); i++){
                writer.println(listOfscores.get(i).toString());
            }
        }
        else{
            for(int i = 0; i < topListOfTenPlayers; i++){
                writer.println(listOfscores.get(i).toString());
            }
        }
        writer.close();
    }
}