package shopping;
import java.util.*;

public class Basket {

  private ArrayList<Item> contents;

  public Basket() {
    contents = new ArrayList<>();
  }

  public ArrayList<Item> getContents() {
    return this.contents;
  }

  public void addItem(Item itemToAdd) {
    this.contents.add(itemToAdd);
  }

  public void emptyBasket() {
    this.contents.clear();
  }

}