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

  public Item getFirstItem() {
    return this.contents.get(0);
  }

  // overloaded method -- get item at index
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

  public Item removeFirstItem() {
    return this.contents.remove(0);
  }

  // overloaded method -- remove item at index
  public Item removeItem(int index) {
    return this.contents.remove(index);
  }

  // overloaded method -- remove item with description
  public Item removeItem(String description) {
    for ( Item item : this.contents ) {
      if ( item.getDescription() == description ) {
        int index = this.contents.indexOf(item);
        return this.contents.remove(index);
      }
    }
    return null;
  }

  // overloaded method -- remove item with Item object
  public Item removeItem(Item item) {
    for ( Item anItem : this.contents ) {
      if ( anItem.equals(item) ) {
        int index = this.contents.indexOf(anItem);
        return this.contents.remove(index);
      }
    }
    return null;
  }

  public double totalCost() {
    double total = 0;
    for ( Item anItem : this.contents ) {
      total += anItem.getPrice();
    }
    return total;
  }

  private ArrayList<Item> removeFreeBogofItems() {
    ArrayList<Item> notFreeItems = new ArrayList<>();
    ArrayList<Item> freeItems = new ArrayList<>();

    for ( Item anItem : this.contents ) {
      if ( anItem.getBogofStatus() && ( Collections.frequency(notFreeItems, anItem) - Collections.frequency(freeItems, anItem) == 1) ) {

        freeItems.add(anItem);
      }
      else notFreeItems.add(anItem);
    }
    return notFreeItems;
  }

  public double bogofCost() {
    double total = 0;
    for ( Item anItem : removeFreeBogofItems() ) {
      total += anItem.getPrice();
    }
    return total;
  }

  public double applyThresholdDiscount() {
    if ( bogofCost() > 20.0 ) {
      return bogofCost() * 0.9;
    }
    else return bogofCost();
  }











}