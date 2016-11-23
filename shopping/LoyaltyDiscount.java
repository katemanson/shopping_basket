package shopping;

public class LoyaltyDiscount implements Discountable {

  Customer customer;
  double totalBeforeDiscount;

  public LoyaltyDiscount(Customer customer, double total) {
    this.customer = customer;
    this.totalBeforeDiscount = total;
  }

  public double applyDiscount() {
    if ( this.customer.hasLoyaltyCard() ) {
      return (this.totalBeforeDiscount/100) * 98;
    }
    else return this.totalBeforeDiscount;
  }

}