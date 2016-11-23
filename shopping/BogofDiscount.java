package shopping;
import java.util.*;

public class BogofDiscount implements Discountable {

  Basket basket;

  public BogofDiscount(Basket basket) {
    this.basket = basket;
  }

  public double applyDiscount() {

    ArrayList<Item> notFreeItems = removeFreeBogofItems(this.basket);

    double total = 0;
    for ( Item item : notFreeItems ) {
      total += item.getPrice();
    }
    return total;
  }

  private ArrayList<Item> removeFreeBogofItems(Basket basket) {
    ArrayList<Item> notFreeItems = new ArrayList<>();
    ArrayList<Item> freeItems = new ArrayList<>();

    for ( Item item : basket.getContents() ) {
      if ( item.getBogofStatus() && ( Collections.frequency(notFreeItems, item) - Collections.frequency(freeItems, item) == 1) ) {

        freeItems.add(item);
      }
      else notFreeItems.add(item);
    }
    return notFreeItems;
  }       

}