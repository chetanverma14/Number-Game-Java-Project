import java.util.Scanner;
import java.util.Random;

public class numbergame{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        Random random=new Random();
        
        int lowerBound=1;
        int upperBound=100;
        int maxAttempts=10;
        int score=0;

        System.out.println("Welcome to the Number Guessing Game!");
        boolean playAgain=true;
        
        while(playAgain){
            int targetNumber=random.nextInt(upperBound-lowerBound+1)+lowerBound;
            int attempts=0;
            System.out.println("\nI have selected a number between "+lowerBound+"and "+upperBound+".Try to guess it! ");

            while(attempts<maxAttempts){
                System.out.print("Attempt "+ (attempts+1)+"/"+ maxAttempts+": Enter your guess: ");
                int userGuess=sc.nextInt();
                sc.nextLine(); 
                
                attempts++;
                
                if(userGuess<targetNumber){
                    System.out.println("Your guess is too low.");
                } else if(userGuess>targetNumber){
                    System.out.println("Your guess is too high.");
                } else{
                    System.out.println("Congratulations! You've guessed the number "+targetNumber+" in "+attempts+" attempts.");
                    score+=(maxAttempts-attempts+1);
                    break;
                }      
                if(attempts==maxAttempts){
                    System.out.println("Sorry, you've reached the maximum number of attempts. The number was "+targetNumber+".");
                }
            }
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgainInput=sc.nextLine();
            playAgain=playAgainInput.equalsIgnoreCase("yes");
        }
        System.out.println("\nThanks for playing! Your final score is: "+score);
    }
}