/*
Wil Fullmer
CSC-160380
4/27/2022
-----------
Problem:

The goal of the game is to reach a score of exactly 30.
Each player has two dice. The players take turns rolling their dice.
When a player rolls both dice, the player may keep the total of both dice or the face value of either die to add to that players total.
A player MUST select either the face value of one of the dice, or the total value of both dice.
If a player's score goes over 30, then that player's score is reset to zero and play continues until one player obtains a score of exactly 30.
The first player to score exactly 30 is the Winner.
Your code should allow for two players.
Your code should obtain the players' names and print a personalized welcome to the game.
The first player's name and starting score of zero should be displayed. The game should roll two dice for the player and display the face value of each die and the total value of both dice. The first player is then required to pick the face value of one of the dice or the total value of both dice. This value is added to that player's score. The new player score is displayed.
If the player's score is less than 30, the turn is passed to the other player.
If the player's score is greater than 30, then the player score is reset to zero and the turn is passed to the other player.
If the player's score is exactly 30, then that player is declared the winner.
 */


import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {


        // Dice values and player Scores
        int dice1, dice2;
        int player1Score = 0;
        int player2Score = 0;

        //test values
        int testScore = 0;   //total dice score
        int rollAmt1 = 0;
        int rollAmt2 = 0;

        //Random number values
        int min   = 1;   // min dice number
        int max   = 6;   // max dice number
        int reactionmax = 5; //max reaction num

        //text reactions
        int randoReact = 0;
        String[] reactions  = {"Nice to meet you", "Welcome", "Hello", "Howdy","Happy to see you", "Glad you're here"};

        //Calling the intro
        Scanner i = new Scanner(System.in);
        System.out.println("------------------------");
        System.out.println("| Welcome to Dice Toss |");
        System.out.println("------------------------");

        //player 1 intro
        System.out.println("\nPlayer 1, Who are you...? : ");
        String player1Name = i.nextLine();

        // random reaction
        randoReact = min + (int)(Math.random() * ((reactionmax - min) + 1));
        System.out.println(reactions[randoReact]+","+player1Name);

        //player 2 intro
        System.out.print("\nPlayer 2, Who are you...? : ");
        String player2Name = i.nextLine();
        randoReact = min + (int)(Math.random() * ((reactionmax - min) + 1));
        System.out.println(reactions[randoReact]+","+player2Name);





        // While loop for gameplay
        while (player1Score < 30 || player2Score <30) {

            //open scanner
            Scanner s = new Scanner(System.in);
            // Logic for player1's score and input
            //--------------------------------------

            //logic for dice values and score | PLAYER 1
            dice1 = min + (int)(Math.random() * ((max - min) + 1));
            dice2 = min + (int)(Math.random() * ((max - min) + 1));
            rollAmt1++;
            testScore = dice1 + dice2;

            // output
            System.out.println("\nRolling dice.......");
            System.out.println("\nYour turn "+player1Name+"!");
            System.out.println("Dice 1 value: " +dice1);
            System.out.println("Dice 2 value: " +dice2);
            System.out.print("\nPLayer 1: Enter(1) to keep dice 1 | Enter(2) to keep dice 2: ");
            int input1 = s.nextInt();

            // gameplay
            switch (input1) {
                case 1:
                    player1Score += dice1;
                    System.out.println("You kept dice 1; your score is now: " + player1Score);
                    System.out.println();
                    break;
                case 2:
                    player1Score += dice2;
                    System.out.println("You kept dice 2; your score is now: " + player1Score);
                    System.out.println();
                    break;
            }
            //overflow catch
            if (player1Score > 30){
                System.out.println(player1Name+" You went over 30....\nResetting score");
            }
            //logic for player 2
            //----------------------------

            //logic for dice values and score | PLAYER 2
            dice1 = min + (int)(Math.random() * ((max - min) + 1));
            dice2 = min + (int)(Math.random() * ((max - min) + 1));
            rollAmt2++;
            testScore = dice1 + dice2;

            // output
            System.out.println("\nRolling dice.......");
            System.out.println("\nYour turn "+player2Name+"!");
            System.out.println("Dice 1 value: " +dice1);
            System.out.println("Dice 2 value : " +dice2);

           // gameplay
            System.out.println("Player 2: Enter(1) to keep dice 1 | Enter(2) to keep dice 2: ");
            int input2 = s.nextInt();
            switch (input2) {
                case 1:
                    player2Score += dice1;
                    System.out.println("You kept dice 1; your score is now: " + player2Score);
                    break;
                case 2:
                    player2Score += dice2;
                    System.out.println("You kept dice 2; your score is now: " + player2Score);
                    break;
            }
            //overflow catch
            if (player2Score > 30){
                System.out.println(player2Name+" You went over 30....\nResetting score");
            }
        }
        //Outro
        if(player1Score == 30){
            System.out.println("\n-------------------------------------------------------");
            System.out.println("  _____  _                         __  __     __          __          ___       _ \n" +
                    " |  __ \\| |                       /_ | \\ \\   / /          \\ \\        / (_)     | |\n" +
                    " | |__) | | __ _ _   _  ___ _ __   | |  \\ \\_/ /__  _   _   \\ \\  /\\  / / _ _ __ | |\n" +
                    " |  ___/| |/ _` | | | |/ _ \\ '__|  | |   \\   / _ \\| | | |   \\ \\/  \\/ / | | '_ \\| |\n" +
                    " | |    | | (_| | |_| |  __/ |     | |    | | (_) | |_| |    \\  /\\  /  | | | | |_|\n" +
                    " |_|    |_|\\__,_|\\__, |\\___|_|     |_|    |_|\\___/ \\__,_|     \\/  \\/   |_|_| |_(_)\n" +
                    "                  __/ |                                                           \n" +
                    "                 |___/                                                            ");
            System.out.println();
            System.out.println("Stats");
            System.out.println("----");
            System.out.println("Player 1 rolled their dice "+rollAmt1+"times!");
            System.out.println("\nPlayer 2 rolled their dice "+rollAmt2+"times!");
        }
        if(player1Score == 30){
            System.out.println("\n-------------------------------------------------------");
            System.out.println("  _____  _                         ___   __     __          __          ___       _ \n" +
                    " |  __ \\| |                       |__ \\  \\ \\   / /          \\ \\        / (_)     | |\n" +
                    " | |__) | | __ _ _   _  ___ _ __     ) |  \\ \\_/ /__  _   _   \\ \\  /\\  / / _ _ __ | |\n" +
                    " |  ___/| |/ _` | | | |/ _ \\ '__|   / /    \\   / _ \\| | | |   \\ \\/  \\/ / | | '_ \\| |\n" +
                    " | |    | | (_| | |_| |  __/ |     / /_     | | (_) | |_| |    \\  /\\  /  | | | | |_|\n" +
                    " |_|    |_|\\__,_|\\__, |\\___|_|    |____|    |_|\\___/ \\__,_|     \\/  \\/   |_|_| |_(_)\n" +
                    "                  __/ |                                                             \n" +
                    "                 |___/                                                              ");
            System.out.println();
            System.out.println("Stats");
            System.out.println("----");
            System.out.println(" rolled their dice "+rollAmt2+"times!");
            System.out.println("\nPlayer 1 rolled their dice "+rollAmt1+"times!");


        }


    }


}