public class TopTenPlayersList {
  Player first = null;

  public void addEntry(String name, double score) {
    Player entry = new Player(name, score, null);
    Player check = first;
//    while(check.getName() !)
    if (isEmpty()) {    // if this is the first player
      first = entry;
    }
    else if (first.getNext() == null) {   // is the second player
      if (first.getScore() > entry.getScore()) {
        first.setNext(entry);
      }
      else {
        entry.setNext(first);
        first = entry;
      }
    }
    else {
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
