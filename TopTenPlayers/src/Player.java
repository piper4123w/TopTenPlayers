
public class Player {
  private String name;
  private double score;
  private Player nextPlayer;
  
  public Player(String name, double score, Player nextPlayer) {
    this.name = name;
    this.score = score;
    this.nextPlayer = nextPlayer;
  }

  public double getScore() {
    return score;
  }
  
  public String getName() {
    return name;
  }
  
  public void setScore(int score) {
    this.score = score;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public Player getNext() {
    return nextPlayer;
  }
  
  public void setNext(Player nextPlayer) {
    this.nextPlayer = nextPlayer;
  }
}
