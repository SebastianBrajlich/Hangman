import java.util.Scanner;

public class Player{

    private String name;
    private int guessAttempts = 0;
    private int points = 7;
    private long startTime;
    private double finishTime;

    public Player(String name){
        this.name = name;
        this.startTime = System.nanoTime();
    }
    public String getName(){
        return this.name;
    }
    public int getGuessAttempts(){
        return this.guessAttempts;
    }
    public int getPoints(){
        return this.points;
    }
    public double getFinishTime(){
        return this.finishTime;
    }
    public void setGuessAttempts(){
        this.guessAttempts +=1;
    }
    public void deductPointsByOne(){
        this.points -= 1;
    }
    public void deductPointsByTwo(){
        this.points -= 2;
    }
    public void setFinishTime(){
        this.finishTime = ((double) System.nanoTime() - this.startTime)/(double) 1000000000;
    }
    public void negativPointsHandle(){
        if(this.points < 0){
            this.points = 0;
        }
    }
    public String guess(){
        Scanner read = new Scanner(System.in);
        String guess = read.nextLine();
        return guess;
    }
}