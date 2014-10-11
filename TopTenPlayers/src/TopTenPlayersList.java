public class TopTenPlayersList {

  int            size;

  private Player first;
  private Player last;

  public TopTenPlayersList() {
    first = null;
    last = null;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public void addEntry(String name, int score) {
    Player newPlayer = new Player(name, score);
    Player previous = null;
    Player current = first;

    while (current != null && score < current.getScore()) {
      previous = current;
      current = current.next;
    }

    if (previous == null) {
      first = newPlayer;
    }
    else {
      previous.next = newPlayer;
    }
    newPlayer.next = current;
    removeDuplicate(name);
  }

  private void removeDuplicate(String name) {
    Player previous = null;
    Player current = first;

    while (current != null && !current.getName().equals(name)) {
      previous = current;
      current = current.getNext();
    }
    previous = current;
    current = current.getNext();

    while (current != null && current.getName().equals(name)) {
      previous.setNext(current.getNext());
    }
  }

  public Player removeFirst() {
    Player temp = first;
    first = first.next;
    return temp;
  }

  public Player removeLast() {
    Player temp;
    if(first == null) {
      return null;
    }
    if(first.getNext() == null) {
      temp = first;
      first = null;
    }
    else {
      Player current = first;
      while(current.getNext().getNext() != null) {
        current = current.getNext();
      }
      temp = current.getNext();
      current.setNext(null);
    }
    size--;
    return temp;
  }

  public String printList() {
    return "";
  }

}
