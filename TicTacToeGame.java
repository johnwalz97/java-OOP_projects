import java.util.Scanner;
public class TicTacToeGame {
    private String[] gameBoard2 = {"1","2","3","4","5","6","7","8","9"};
    private boolean gameOver;
    private String currentTurn;

    public TicTacToeGame() {
        gameOver = false;
        currentTurn = "Red";
    }
    
    public void showBoard(){
        System.out.println(gameBoard2[0] + "|" + gameBoard2[1] + "|" + gameBoard2[2]);
        System.out.println(gameBoard2[3] + "|" + gameBoard2[4] + "|" + gameBoard2[5]);
        System.out.println(gameBoard2[6] + "|" + gameBoard2[7] + "|" + gameBoard2[8]);
    }
    
    public String getCurrentTurn() {
        return currentTurn;
    }

    public boolean gameStopped() {
        return gameOver;
    }

    public void updateGameBoardAt(int index, String color) {
        if(color == "Red") {
            if(gameBoard2[index -1] != "x" || gameBoard2[index -1] != "o") {
                gameBoard2[index - 1] = "x";
                currentTurn = "Blue";
                checkGame();
            }
        } else {
            if(gameBoard2[index -1] != "x" || gameBoard2[index -1] != "o") {
                gameBoard2[index - 1] = "o";
                currentTurn = "Red";
                checkGame();
            }
        }
    }

    public void checkGame() {
        for(int i = 0; i < 7; i += 3){
            if(gameBoard2[i] == "x" && gameBoard2[i + 1] == "x" && gameBoard2[i + 2] == "x"){
                gameOver = true;
                currentTurn = "Red";
            } else if(gameBoard2[i] == "o" && gameBoard2[i + 1] == "o" && gameBoard2[i + 2] == "o"){
                gameOver = true;
                currentTurn = "Blue";
            }
        }
        for(int i = 0; i < 3; i ++){
            if(gameBoard2[i] == "x" && gameBoard2[i + 3] == "x" && gameBoard2[i + 6] == "x"){
                gameOver = true;
                currentTurn = "Red";
            } else if(gameBoard2[i] == "o" && gameBoard2[i + 3] == "o" && gameBoard2[i + 6] == "o"){
                gameOver = true;
                currentTurn = "Blue";
            }
        }
        if(gameBoard2[0] == "x" && gameBoard2[4] == "x" && gameBoard2[8] == "x" || gameBoard2[2] == "x" && gameBoard2[4] == "x" && gameBoard2[6] == "x"){
            gameOver = true;
            currentTurn = "Red";
        } else if(gameBoard2[0] == "o" && gameBoard2[4] == "o" && gameBoard2[8] == "o" || gameBoard2[2] == "o" && gameBoard2[4] == "o" && gameBoard2[6] == "o"){
            gameOver = true;
            currentTurn = "Blue";
        }
    }
    
    public static void main(String[] args){
        do {
            playGame();
        } while(playAgain());        
    }
    
    public static void playGame(){
        Scanner keyboard = new Scanner(System.in);
        TicTacToeGame game = new TicTacToeGame();
        System.out.println("Player1 is Red - your symbol is x");
        System.out.println("Player2 is Blue - your symbol is o");
        game.showBoard();
        while(!game.gameStopped()){
            System.out.println("New turn: it is " + game.getCurrentTurn() + "'s turn!");
            System.out.println("Enter the number of the slot you want to choose: ");
            int userChoice = keyboard.nextInt();
            game.updateGameBoardAt(userChoice, game.getCurrentTurn());
            game.showBoard();
        }
        System.out.println("The winner is " + game.getCurrentTurn());
    }
    
    public static boolean playAgain(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Do you want to play again? Y/N:");
        char playAgain = keyboard.nextLine().charAt(0);
        if(playAgain == 'Y' || playAgain == 'y'){
            return true;
        } else {
            return false;
        }
    }
}