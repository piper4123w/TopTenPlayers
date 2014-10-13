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
    first = first.getNext();
  }

  public void removeLast() {
    Player current = first;
    if (first.getNext() != null) { // if there isnt just one guy
      for (int i = 10; i > 0; i--) {
        if (current.getNext() == null) {
          System.out.println("removing " + current.getName() + " at " + i);
          current = null;
        }
      }
      System.out.println("removing " + current.getName());
      current = null;
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

// public class TopTenPlayersList {
//
// int size;
//
// private Player first;
// private Player last;
//
// public TopTenPlayersList() {
// first = null;
// last = null;
// }
//
// public boolean isEmpty() {
// return first == null;
// }
//
// public void addEntry(String name, int score) {
// Player newPlayer = new Player(name, score, );
// Player previous = null;
// Player current = first;
//
// while (current != null && score < current.getScore()) {
// previous = current;
// current = current.next;
// }
//
// if (previous == null) {
// first = newPlayer;
// }
// else {
// previous.next = newPlayer;
// }
// newPlayer.next = current;
// removeDuplicate(name);
// }
//
// private void removeDuplicate(String name) {
// Player previous = null;
// Player current = first;
//
// while (current != null && !current.getName().equals(name)) {
// previous = current;
// current = current.getNext();
// }
// previous = current;
// current = current.getNext();
//
// while (current != null && current.getName().equals(name)) {
// previous.setNext(current.getNext());
// }
// }
//
// public Player removeFirst() {
// Player temp = first;
// first = first.next;
// return temp;
// }
//
// public Player removeLast() {
// Player temp;
// if(first == null) {
// return null;
// }
// if(first.getNext() == null) {
// temp = first;
// first = null;
// }
// else {
// Player current = first;
// while(current.getNext().getNext() != null) {
// current = current.getNext();
// }
// temp = current.getNext();
// current.setNext(null);
// }
// size--;
// return temp;
// }
//
// public String printList() {
// return "";
// }
//
// }
