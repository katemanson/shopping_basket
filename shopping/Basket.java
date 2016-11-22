package shopping;
import java.util.*;

public class Basket {

  private ArrayList<Item> contents;

  public Basket() {
    this.contents = new ArrayList<>();
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

  // overloaded method -- get item with index
  public Item getItem(int index) {
    return this.contents.get(index);
  }

  // overloaded method -- get item with description
  public Item getItem(String description) {
    for ( Item item : this.contents ) {
      if ( item.getDescription() == description ) {
        return item;
      }
    }
    return null;
  }

  // overloaded method -- remove item with index
  public Item removeItem(int index) {
    return this.contents.remove(index);
  }

  public Item removeItem(String description) {
    for ( Item item : this.contents ) {
      if ( item.getDescription() == description ) {
        int index = this.contents.indexOf(item);
        return this.contents.remove(index);
      }
    }
    return null;
  }

  public double calculateRawTotal() {
    double total = 0;
    for ( Item item : this.contents ) {
      total += item.getPrice();
    }
    return total;
  }




}