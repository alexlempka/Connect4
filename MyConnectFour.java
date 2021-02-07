import java.util.*;

public class MyConnectFour {
   
  ArrayList<Player> players = new
  ArrayList<Player>();//Creating arraylist of players that will take part in the game

  private int currentPlayerIndex = -1; //Set to minus one to start with zero
    Player currentPlayer; 


  private int maxTurns = 42; // only max amount of 42 counters can be placed
  private int currentTurns = 0; // initialise current turns

  private final int NDefault = 4; // default at 4
  private final int NMin = 3; // first step in ConnectN
  private final int NMax = 6; // max value that N can be
  private int N = NDefault;

  public  MyConnectFour(){ // called in Main method
        playGame();
    }

  public void playGame(){
        System.out.println("Welcome to Connect 4");
        System.out.println("There are 2 players red and yellow");
        System.out.println("Player 1 is Red, Player 2 is Yellow");
        System.out.println("To play the game type in the number of the column you want to drop you counter in");
        System.out.println("A player wins by connecting N counters in a row - vertically, horizontally or diagonally");
      
        System.out.println("");
        players.add(new HumanPlayer('r')); // add a human player with counter r
        players.add(new ComputerPlayer('y')); // add computer player with counter y
        players.add(new ComputerPlayer('b')); // add additional computer player with counter b
        currentPlayer = players.get(0);
        Board.board = fillBoard(Board.board, ' ');
        printBoard(Board.board);

      while(!hasWon(Board.board) && !isDraw(currentTurns, maxTurns)) {
        currentPlayerIndex = changeTurn(players.size(), currentPlayerIndex);
        currentPlayer = players.get(currentPlayerIndex);
        System.out.println(currentPlayer.token + " turn");
        int column = currentPlayer.makeTurn();

        if(placeCounter(Board.board,column,currentPlayer.token)) {
          printBoard(Board.board);   
    }
  }

      if(hasWon(Board.board)) { // if player has won, print out that the player has won
        System.out.println (currentPlayer.token + " won!");
        return;
    }

      if(isDraw(currentTurns, maxTurns)) { // if no winner, print out that there is a draw
        System.out.println("It's a draw");
        return;
    }
}

  private static boolean isDraw(int currentTurns, int maxTurns) {
  return currentTurns >= maxTurns;
}
// prints board where i=rows and j=columns
  public static void printBoard(char[][] board){
        System.out.println();
        for (int i = 0; i < board.length; i++){
            System.out.print("|");
            for (int j = 0; j < board[i].length; j++){
                System.out.print(" " + board[i][j] + " |");
            }
            System.out.println();
        }
        System.out.println("  0   1   2   3   4   5   6"); // columns from 0 to 6 in line with index 
    }

    // fill the board with ' ' characters
  public static char [][] fillBoard (char[][] board, char spaces) {

    for (int i = 0; i < board.length; i++){
        java.util.Arrays.fill(board[i], 0, board[i].length, spaces);
      }
      return board;
    }

  // boolean that defines whether a counter can be placed
  public boolean placeCounter(char[][] board, int j, char player){
      boolean result = false;

      for (int i = board.length-1; i >= 0; i--){
            if (board[i][j] == ' '){
                board[i][j] = player;
                return true;
            }
        }
      return result;
      
    }

    // change turns between players by identifying the players
    public static int changeTurn(int totalPlayers, int currentPlayerIndex) {

        if ((currentPlayerIndex+=1) == totalPlayers) {
          return 0;
        } else {
          return currentPlayerIndex;
        }
    }

    private boolean hasWon(char[][]board){
        boolean result = false;

      //horizontal win, including connectN code
        for (int j = 0; j < board[0].length; j++){
            for (int i = 0; i < board.length-(N-1); i++){
                 if(board[i][j] != ' ' && board[i][j] == board[i+1][j] && board[i][j] == board[i+2][j] && board[i][j] == board[i+3][j]){
                   return true;
              } 
        }
        }

// check for vertical win
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length-3; j++){
                if (board[i][j] != ' ' && board[i][j] == board[i][j+1] && board[i][j] == board[i][j+2] && board[i][j] == board[i][j+3]){
                    return true;
                }
            }
        }

// check  diagonal for both y=x and y=-x
        for (int i = 0; i < board.length-3; i++){
            for (int j = 0; j < board[i].length - 3; j++){
                if (board[i][j] != ' ' && board[i][j] == board[i+1][j+1] && board[i][j] == board[i+2][j+2] && board[i][j] == board[i+3][j+3]){
                    return true;
                }
            }
        }
        for (int i = 0; i < board.length-3; i++){
            for (int j = 3; j < board[i].length; j++){
                if (board[i][j] != ' ' && board[i][j] == board[i+1][j-1] && board[i][j] == board[i+2][j-2] && board[i][j] == board[i+3][j-3]){
                    return true;
                }
            }
        }
        return result;
    }

}


