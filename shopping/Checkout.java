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

  public String listBasketContents() {
    ArrayList<Item> basketContents = this.basket.getContents();
    StringBuilder basketList = new StringBuilder();

    if ( basketContents.size() == 0 ) {
      basketList.append( "Basket is empty" );
    }
    else {
      basketList.append( "Basket contains: " );
      for ( Item item : basketContents ) {
        basketList.append( "\n" + item.getDescription() );
      }
    }

    return basketList.toString();
  }

  public String listBagContents() {
    ArrayList<Item> bagContents = this.customer.getShoppingBag();
    StringBuilder bagList = new StringBuilder();

    if ( bagContents.size() == 0 ) {
      bagList.append( "Bag is empty" );
    }
    else {
      bagList.append( "Bag contains: " );
      for ( Item item : bagContents ) {
      bagList.append( "\n" + item.getDescription() );
      }
    }

    return bagList.toString();
  }

  public String checkout() {

    double wallet = this.customer.getWallet();

    if ( wallet < discountedTotal() ) {
      return "Not enough in wallet";
    }
    else {
      this.customer.setWallet( wallet - discountedTotal() );
      this.customer.packBag(this.basket);
      this.basket.emptyBasket();
      System.out.println(discountedTotal());
      System.out.println( "Total paid: £" + discountedTotal() + "\nAmount left in wallet: £" + this.customer.getWallet() + "\n" + listBagContents() + "\n" + listBasketContents());
      return "Total paid: £" + discountedTotal() + "\nAmount left in wallet: £" + this.customer.getWallet() + "\n" + listBagContents() + "\n" + listBasketContents();
    }
  }

}