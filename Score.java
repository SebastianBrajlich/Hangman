public class Score implements Comparable<Score>{

    String playerName;
    double time;
    int attempts;

    public Score(Player player){
        this.playerName = player.getName();
        this.time = player.getFinishTime();
        this.attempts = player.getGuessAttempts();
    }
    public Score(String name, String time, String attempts){
        this.playerName = name;
        this.time = Double.parseDouble(time);
        this.attempts = Integer.parseInt(attempts);
    }
    public String toString(){
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(playerName + " | " + time + " | " + attempts);
        return strBuilder.toString();
    }
    private double getTime(){
        return time;
    }
    public int compareTo(Score score){
        if(this.getTime() > score.getTime()){
            return 1;
        }
        else if(this.getTime() < score.getTime()){
            return -1;
        }
        return 0;
    }
}