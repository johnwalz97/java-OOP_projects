import java.util.Scanner;
public class Connect4{
    private String[] gameBoard2 = {"_","_","_","_","_","_","_",
                                   "_","_","_","_","_","_","_",
                                   "_","_","_","_","_","_","_",
                                   "_","_","_","_","_","_","_",
                                   "_","_","_","_","_","_","_",
                                   "_","_","_","_","_","_","_"};
    private boolean gameOver;
    private String currentTurn;

    public Connect4() {
        gameOver = false;
        currentTurn = "Red";
    }
    
    public void showBoard(){
        System.out.println(" 1 2 3 4 5 6 7");
        System.out.println("|" + gameBoard2[0] + "|" + gameBoard2[1] + "|" + gameBoard2[2] + "|" + gameBoard2[3] + "|" + gameBoard2[4] + "|" + gameBoard2[5] + "|" + gameBoard2[6] + "|");
        System.out.println("|" + gameBoard2[7] + "|" + gameBoard2[8] + "|" + gameBoard2[9] + "|" + gameBoard2[10] + "|" + gameBoard2[11] + "|" + gameBoard2[12] + "|" + gameBoard2[13] + "|");
        System.out.println("|" + gameBoard2[14] + "|" + gameBoard2[15] + "|" + gameBoard2[16] + "|" + gameBoard2[17] + "|" + gameBoard2[18] + "|" + gameBoard2[19] + "|" + gameBoard2[20] + "|");
        System.out.println("|" + gameBoard2[21] + "|" + gameBoard2[22] + "|" + gameBoard2[23] + "|" + gameBoard2[24] + "|" + gameBoard2[25] + "|" + gameBoard2[26] + "|" + gameBoard2[27] + "|");
        System.out.println("|" + gameBoard2[28] + "|" + gameBoard2[29] + "|" + gameBoard2[30] + "|" + gameBoard2[31] + "|" + gameBoard2[32] + "|" + gameBoard2[33] + "|" + gameBoard2[34] + "|");
        System.out.println("|" + gameBoard2[35] + "|" + gameBoard2[36] + "|" + gameBoard2[37] + "|" + gameBoard2[38] + "|" + gameBoard2[39] + "|" + gameBoard2[40] + "|" + gameBoard2[41] + "|");
    }
    
    public String getCurrentTurn() {
        return currentTurn;
    }

    public boolean gameStopped() {
        return gameOver;
    }

    public void updateGameBoardAt(int slot, String color) {
        if(color == "Red") {
            for(int i = slot - 1 + 35; i > (slot - 2); i -= 7){
                if(gameBoard2[i] == "_"){
                    gameBoard2[i] = "r";
                    break;
                }
            }
            currentTurn = "Blue";
            checkGame();
        } else {
            for(int i = slot - 1 + 35; i > (slot - 2); i -= 7){
                if(gameBoard2[i] == "_"){
                    gameBoard2[i] = "b";
                    break;
                }
            }
            currentTurn = "Red";
            checkGame();
        }
    }

    public void checkGame() {
        checkColumns();
        checkRows();
        checkDiagonals();
    }
    public void checkColumns(){
        for(int i = 0; i < 7; i++){
            for(int j = 0 + i; j < i + 15; j += 7){
                if(gameBoard2[j] == "r" && gameBoard2[j + 7] == "r" && gameBoard2[j + 14] == "r" && gameBoard2[j + 21] == "r"){
                    gameOver = true;
                    currentTurn = "Red";
                } else if(gameBoard2[j] == "b" && gameBoard2[j + 7] == "b" && gameBoard2[j + 14] == "b" && gameBoard2[j + 21] == "b"){
                    gameOver = true;
                    currentTurn = "Blue";
                }
            }
        }
    }
    
    public void checkRows(){
        for(int i = 0; i < 36; i += 7){
            for(int j = i; j < i + 4; j++){
                if(gameBoard2[j] == "r" && gameBoard2[j + 1] == "r" && gameBoard2[j + 2] == "r" && gameBoard2[j + 3] == "r"){
                    gameOver = true;
                    currentTurn = "Red";
                } else if(gameBoard2[j] == "b" && gameBoard2[j + 1] == "b" && gameBoard2[j + 2] == "b" && gameBoard2[j + 3] == "b"){
                    gameOver = true;
                    currentTurn = "Blue";
                }
            }
        }
    }
    
    public void checkDiagonals(){
        for(int i = 21; i < 36; i += 7){
            for(int j = i; j < i + 4; j++){
                if(gameBoard2[j] == "r" && gameBoard2[j - 6] == "r" && gameBoard2[j - 12] == "r" && gameBoard2[j - 18] == "r"){
                    gameOver = true;
                    currentTurn = "Red";
                } else if(gameBoard2[j] == "b" && gameBoard2[j - 6] == "b" && gameBoard2[j - 12] == "b" && gameBoard2[j - 18] == "b"){
                    gameOver = true;
                    currentTurn = "Blue";
                }
            }
        }
        for(int i = 27; i < 42; i += 7){
            for(int j = i; j > i - 4; j--){
                if(gameBoard2[j] == "r" && gameBoard2[j - 6] == "r" && gameBoard2[j - 12] == "r" && gameBoard2[j - 18] == "r"){
                    gameOver = true;
                    currentTurn = "Red";
                } else if(gameBoard2[j] == "b" && gameBoard2[j - 8] == "b" && gameBoard2[j - 16] == "b" && gameBoard2[j - 24] == "b"){
                    gameOver = true;
                    currentTurn = "Blue";
                }
            }
        }
    }
    
    public static void main(String[] args){
        do {
            playGame();
        } while(playAgain());        
    }
    
    public static void playGame(){
        Scanner keyboard = new Scanner(System.in);
        Connect4 game = new Connect4();
        System.out.println("Player1 is Red - your symbol is r");
        System.out.println("Player2 is Blue - your symbol is b");
        game.showBoard();
        while(!game.gameStopped()){
            System.out.println("New turn: it is " + game.getCurrentTurn() + "'s turn!");
            System.out.println("Enter the number of the column you want to drop your token into: ");
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