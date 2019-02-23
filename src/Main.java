import java.util.Scanner;

public class Main {

    private static int batchSize = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in );

        //Asks user if want to play batch mode or one by one
        System.out.println( " Press 1 for Batch mode( " + batchSize + " game play ) and press 2 for one by one " );
        //users inout decision
        int gameDecision = scanner.nextInt();
        if( gameDecision == 1 ){
            batchMode();
        }
        else if ( gameDecision == 2 ){
            oneByone();
        }
        //if any other input rather than 1 or 2
        else{
            System.out.println(" Invalid input ");
        }
    }

    private static void oneByone() {
        Scanner scanner = new Scanner(System.in);
        //asks for users choice
        System.out.println( " User Choice " );
        System.out.println( " Press 1 for stone \n Press 2 for paper \n Press 3 for Scissor \n " );
        //user choice
        int userChoice = scanner.nextInt();
        //computer random selection
        int computerChoice = (int)(Math.random()*3 + 1);

        //display of choices
        System.out.println( " User Choice = " + (userChoice==1?"stone": (userChoice==2?"paper":"Scissor")) + "\n"
                + " System Choice = " + (computerChoice==1?"stone": (computerChoice==2?"paper":"Scissor")) );
        //calculating whether user wins or system
        char result = result(computerChoice, userChoice);
        //result display
        if( result == 'D' ){
            System.out.println( " Match Draw ");
        }
        else if( result == 'U' ){
            System.out.println( " User wins " );
        }
        else {
            System.out.println(" System wins ");
        }
    }

    private static void batchMode() {
        Scanner scanner = new Scanner(System.in);
        int userWins = 0, computerWins = 0;
        //to store user and system input
        int[] userInputs = new int[batchSize];
        int[] systemInputs = new int[batchSize];
        for( int i = 0 ; i < batchSize ; i++ ){
            System.out.println( " Press 1 for stone \n Press 2 for paper \n Press 3 for Scissor \n " );

            int userChoice = scanner.nextInt();
            //storing users choice
            userInputs[i] = userChoice;
            int computerChoice = (int)(Math.random()*3 + 1);
            //storing system choice
            systemInputs[i] = computerChoice;
            char result = result(computerChoice,userChoice);

            //calculates number of time user wins or system
            if( result == 'U' ){
                userWins++;
            }
            else if( result == 'S' ){
                computerWins++;
            }
        }

        //display results of both the user and system
        for( int i = 0 ; i < 3 ; i++ ){
            System.out.println( " User Choice = " + (userInputs[i]==1?"stone": (userInputs[i]==2?"paper":"Scissor")) +
                     " System Choice = " + (systemInputs[i]==1?"stone": (systemInputs[i]==2?"paper":"Scissor")) );
        }


        if( userWins > computerWins ){
            System.out.println( "  User wins series " );
        }
        else if( computerWins > userWins ){
            System.out.println( " System wins series " );
        }
        else{
            System.out.println( " Series Draw " );
        }
    }

    private static char result(int computerChoice, int userChoice) {
        //D for draw, U for user wins, S for system wins;

        //System.out.println( " Press 1 for stone \n Press 2 for paper \n Press 3 for Scissor \n " );
        if( computerChoice == userChoice  ){
            return 'D';
        }
        if( userChoice == 1 ){
            if ( computerChoice == 2 ) {
                return 'S';
            }
            if (computerChoice == 3 ){
                return  'U';
            }
        }

        if( userChoice == 2 ){
            if( computerChoice == 1 ) {
                return 'U';
            }
            if ( computerChoice == 3  ){
                return 'S';
            }
        }
        if (userChoice == 3 && computerChoice == 1) {
            return 'S';
        }
        /* userChoice == 3 && computerChoice == 2 */
        return 'U';
    }

}
