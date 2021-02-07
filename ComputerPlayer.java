class ComputerPlayer extends Player {
  public ComputerPlayer(char token){
        super(token);
    }

  //Return pseudorandom double type numbers
  public int makeTurn() {
      int choice = (int)(Math.random() * 7);
      while(isFull(choice)) {
          choice = (int)(Math.random() * 7);
      }

      return choice;
  }

//create equivalent of error message for human player if board is full for the computer player by checking whether there is an empty space in column.
  private boolean isFull(int choice) { 
    if (Board.board[0][choice] != ' '){
            return true;
        }
    return false;
  }
}