package shopping;
import java.util.*;

public class Checkout {

  private Customer customer;
  private Basket basket;
  private ArrayList<Discountable> discounts;

  public Checkout(Customer customer, Basket basket) {
    this.customer = customer;
    this.basket = basket;
    this.discounts = new ArrayList<>();
  }

  public ArrayList<Discountable> getDiscounts() {
    return this.discounts;
  }

  public void setDiscount(Discountable discount) {
    this.discounts.add(discount);
  }

  // ?Why?
  public double rawTotal() {
    double total = 0;
    for ( Item item : basket.getContents() ) {
      total += item.getPrice();
    }
    return total;
  }

  public double discountedTotal() {
    double total = 0;
    for ( Discountable discount : this.discounts ) {
      total = discount.applyDiscount();
    }
    return total; 
  }


  // public void finalCost() {

  // }

  // public void checkout() {
  //   // get final cost, after discounts
  //   // check customer has enough money
  //   // take cost from customer wallet
  //   // pack bag
  //   // empty basket
  // }

}