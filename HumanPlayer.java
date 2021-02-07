import java.util.*;

class HumanPlayer extends Player {
   public HumanPlayer(char token){
        super(token);
    }

  public int makeTurn() {
    // use scanner instead to get input from user
    Scanner input = new Scanner (System.in); 

    while (input.hasNext()){
    int column;
    try{
      column=input.nextInt();
    } catch (InputMismatchException ex){ //catch Exception here for non integer input
      input.next(); // do a next() here
      errorInvalidInput();
      continue;
    }
      if (column < 0 || column > 6){
          errorInvalidInput(); // print error if number is not within the range
          continue;
      }

      if(isFull(column)) {
        errorWrongColumn();
        continue;
      }

      return column;
    }

    return 0;
  }

  // the column is full if there is no more empty space
  private boolean isFull(int choice) {
    if (Board.board[0][choice] != ' '){
            return true;
        }
    return false;
  }

    private void errorWrongColumn(){
        System.out.println("Please choose another column");
    }
    private void errorInvalidInput(){
        System.out.println("Please enter an integer from 0 to 6.");
    }
}