public class TopTenPlayersList {
  Player first = null;

  public void addEntry(String name, double score) {
    Player entry = new Player(name, score, null);
    if (isEmpty()) {    // if this is the first player
      first = entry;
    }
    else {    // not the first player
      int count = 0;
      Player current = first;
      // will loop through each player until the next guy is worse or doesnt exist
      while (current.getNext() != null && entry.getScore() < current.getNext().getScore()) {
        current = current.getNext();
        count++;
        System.out.println(count);
      }
      if (count < 10) {   // better the the 10th player
        if (count == 9) {    // is the new 10th best player
          removeLast();
          entry = new Player(name, score, null);
        }
        else {    // somewhere between 1st and 10th best
          entry = new Player(name, score, current.getNext());
          current.setNext(entry);
        }
      }
      else {
        System.out.println("this player sucks!");
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
        if (current.getNext() == null) {
          System.out.println("removing " + current.getName() + " at " + i);
          current = null;
        }
      }
      System.out.println("removing " + current.getName());
      current = null;
    }
    else {
      System.out.println("no one was entered into the list");
    }
  }

  public String printList() {
    Player current = first;
    String print = null;
    if (isEmpty()) {
      print = "No Top Players";
    }
    else {
      while (current.getNext() != null) {
        print = current.getName() + " " + String.valueOf(current.getScore()) + "\n";
      }
    }
    return print;

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
