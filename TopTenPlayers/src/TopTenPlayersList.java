public class TopTenPlayersList {
  Player first = null;

  public void addEntry(String name, double score) {
    Player entry = new Player(name, score, null);
    if (isEmpty()) {    // if this is the first player
      first = entry;
      System.out.println(first.getName());
    }
    else if(first.getNext() == null) {
      if(first.getScore() > entry.getScore()) {
        first.setNext(entry);
        System.out.println(entry.getName());
      }
      else {
        entry.setNext(first);
        first = entry;
        System.out.println(first.getName());
      }
    }
    else {
      Player current = first;
      boolean doIt = true;
      while(entry.getScore() < current.getScore()) {
        if(current.getNext() == null) {
          current.setNext(entry);
          System.out.println(entry.getName());
          doIt = false;
          break;
        }
        else {
          current = current.getNext();
        }
      }
      if(doIt) {
        entry.setNext(current);
        System.out.println(entry.getName());
        first = entry;
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
      while (!last){
        System.out.println(current.getName() + " " + String.valueOf(current.getScore()));
        current = current.getNext();
        if(current == null) {
          last = true;
        }
      }
    }
//    System.out.println(print);

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
