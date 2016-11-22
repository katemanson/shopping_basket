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

  // public double calculateTotalAfterBogofs() {
  //   double total = 0;
  //   int numberOfItems = this.contents.size(); 
  //   for ( int i = 0; i < numberOfItems; i++ ) {
  //     Item firstItem = this.contents.removeFirstItem();
  //     for ( Item item : this.contents ) {
  //       if ( item.equals(firstItem) && item.getBogofStatus() ) {
  //         int index = this.contents.indexOf(item);
  //         this.contents.remove(index);
  //       }

  //     total += item.getPrice();
  //   }
  //   return total;
  // }








}