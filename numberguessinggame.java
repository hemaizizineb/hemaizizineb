import java.util.Random;
import java.util.Scanner; 

public class numberguessinggame {
  public static void main(String[] args){

    Random rand=new Random();
    
    Scanner scanner = new Scanner(System.in);

    int  randomnumber = rand.nextInt(100)+1;
   
    while(true){ //true make an endless loop so we need a break statement

    System.out.println("Enter your guess(1-100)");
    int playerguess=scanner.nextInt();//get the INT and store it into the var playerguess
     
    //check if the playerguess is right
    if(playerguess == randomnumber) {
        System.out.println("Correct! You Win!");
        break;//the break! to escape the loop
    } 
    else if(playerguess > randomnumber){
        System.out.println("Nope! the number you gave is higher. Guess again.");
        
    }
    else {System.out.println("Nope! the number is lower. Guess again.");}
    }

  }
}