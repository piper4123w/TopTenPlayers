public class TopTenPlayersList {
  Player first = null;

  public void addEntry(String name, double score) {
    Player entry = new Player(name, score, null);
    if (isEmpty()) {    // if this is the first player
      first = entry;
    }
    else if (first.getNext() == null) {   // is the second player
      if (name != first.getName()) {
        if (first.getScore() > entry.getScore()) {
          first.setNext(entry);
        }
        else {
          entry.setNext(first);
          first = entry;
        }
      }
    }
    else {
      Player dupCheck = first;
      Player beforeDup = first;
      Player leadBefore = first;
      while(dupCheck != null && !dupCheck.getName().equals(entry.getName())) {
        dupCheck = dupCheck.getNext();
      }
      if(dupCheck != null && dupCheck.getName().equals(entry.getName())) {
        if(dupCheck.getScore() > entry.getScore()) {
          return;
        }
        else {
          while(beforeDup.getNext() != dupCheck) {
            beforeDup = beforeDup.getNext();
          }
          beforeDup.setNext(dupCheck.getNext());
          while(beforeDup.getScore() != first.getScore()) {
            while(leadBefore.getNext().getScore() != beforeDup.getScore()) {
              leadBefore = leadBefore.getNext();
            }
            beforeDup = leadBefore;
            leadBefore = first;
          }
          first = leadBefore;
        }
      }
    
      if (first.getScore() < entry.getScore()) {
        entry.setNext(first);
        first = entry;
      }
      else {
        Player before = first;
        Player after = first;
        Player current = first;
        while (after != null && entry.getScore() < after.getScore()) {
          after = after.getNext();
        }
        while (before.getNext() != null && entry.getScore() < before.getNext().getScore()) {
          before = before.getNext();
        }
        entry.setNext(after);
        before.setNext(entry);
        while (before.getScore() != first.getScore()) {
          while (current.getNext().getScore() != before.getScore()) {
            current = current.getNext();
          }
          before = current;
          current = first;
        }
        first = current;
      }
    }
  }

  public void removeFirst() {
    if (first != null && first.getNext() != null) {
      first = first.getNext();
    }
  }

  public void removeLast() {
    Player current = first;
    if (first != null && first.getNext() != null) { // if the list isnt empty or just one guy
      for (int i = 10; i > 0; i--) {
        if (current.getNext().getNext() == null) {
          current.setNext(null);

          break;
        }
        current = current.getNext();
      }
      current = null;
    }
    else {
      System.out.println("no one was entered into the list");
    }
  }

  public void printList() {
    Player current = first;
    if (isEmpty()) {
      System.out.println("No Top Players");
    }
    else {
      boolean last = false;
      while (!last) {
        System.out.println(current.getName() + " " + String.valueOf(current.getScore()));
        current = current.getNext();
        if (current == null) {
          last = true;
        }
      }
      System.out.println("");
    }

  }

  public boolean isEmpty() {
    if (first == null) {
      return true;
    }
    return false;
  }

  public boolean isFull() {
    boolean full = false;
    int count = 10;
    Player current = first;
    if (!isEmpty()) {
      while (current.getNext() != null && count > 0) {
        count--;
        current = current.getNext();
      }
      if (count == 1) {
        full = true;
      }
    }
    return full;
  }

}


class Player {
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
