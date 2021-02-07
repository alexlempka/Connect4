abstract class Player {
  
  public char token; // every player has a token / counter
  public Player(char token) { // common constructor for all classes
    this.token = token;
  }; 
  public abstract int makeTurn(); 
}