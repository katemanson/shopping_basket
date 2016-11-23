package shopping;

public class ThresholdDiscount implements Discountable {

  double totalBeforeDiscount;

  public ThresholdDiscount(double total) {
    this.totalBeforeDiscount = total;
  }

  public double applyDiscount() {
    if ( this.totalBeforeDiscount > 20.0 ) {
      return (this.totalBeforeDiscount/10) * 9;
    }
    else return this.totalBeforeDiscount;
  }

}