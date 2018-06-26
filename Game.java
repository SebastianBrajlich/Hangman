import java.util.Scanner;

public class Game{

    private Player player;
    private DataBase dataBase = new DataBase("countries_and_capitals.txt");
    private Password password;
    private Scanner read = new Scanner(System.in);
    private HangmanGraphics graphics = new HangmanGraphics("graphics.txt");

    public Game(){
        System.out.print("Please enter Your name: ");
        String name = read.next();
        this.player = new Player(name);
        String capital = dataBase.getCountry().getCapitalName();
        this.password = new Password(capital);
    }
    public void play(){
        boolean stop = false;
        while(!stop){
            handleGraphics();
            System.out.println("Try to guess: ");
            String guess = player.guess();
            password.changeDashes(guess);
            player.setGuessAttempts();
            if(password.checkPassword()){
                handleWinGame();
                stop = true;
            }
            else{
                if(!password.chackGuess(guess)){
                    if(guess.length() >1 ){
                        player.deductPointsByTwo();
                    }
                    else{
                        player.deductPointsByOne();
                    }
                }
            }
            player.negativPointsHandle();
            if(player.getPoints() == 0){
                handleGraphics();
                System.out.println("You have lost!!!");
                graphics.displayEndGame();
                stop = true;
            }
        }
    }
    private void handleGraphics(){
        int lives = player.getPoints();
        int numberOflives = 7;
        int graphicNumber = numberOflives - lives;
        graphics.displayGraphic(graphicNumber);
        Display.printArray(password.getPassword());
        Display.printArray(password.getDashes());
    }
    private void handleWinGame(){
        Display.printArray(password.getDashes());
        System.out.println(" \n You have won! \n");
        player.setFinishTime();
        Score score = new Score(player);
        System.out.println("Your score: " + score.toString() + "\n");
        Rank rank = new Rank("TopList.txt");
        rank.addScore(score);
        FileWriter writer = new FileWriter("TopList.txt");
        rank.sortListOdScores();
        writer.writeScores(rank.getListOfScores());
        Display.printTopList("TopList.txt");
    }
    
}