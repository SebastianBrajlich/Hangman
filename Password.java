import java.util.ArrayList;
import java.util.Arrays;

public class Password{

    private String[] password;
    private String[] dashes;
    private String dash = " ... ";
    
    public Password(String password){
        
        this.password = password.toUpperCase().split("");
        this.dashes = new String[this.password.length];
        
        for(int i = 0; i < this.password.length; i++){
            dashes[i] = dash;
        }
    }
    public String[] getPassword(){
        return this.password;
    }
    public String[] getDashes(){
        return this.dashes;
    }
    public boolean checkPassword(){
        if(Arrays.equals(this.password, this.dashes)){
            return true;
        }
        return false;
    }
    public boolean checkLetter(String letter){
        for(int i = 0; i < this.password.length; i++){
            if(letter.toUpperCase().equals(this.password[i])){
                return true;
            }
        }
        return false;
    }
    public boolean chackGuess(String guess){
        if(guess.length()>1){
            if(Arrays.equals(guess.toUpperCase().split(""), password)){
                return true;
            }
        }
        else{
            if(checkLetter(guess)){
                return true;
            }
        }
        return false;
    }
    public void changeDashes(String guess){
        if(guess.length() > 1){
            if(chackGuess(guess)){
                dashes = password;
            }
        }
        else{
            for(int i = 0; i < password.length; i++){
                if(guess.toUpperCase().equals(password[i])){
                    dashes[i] = guess.toUpperCase();
                }
            }
        }
    }
}