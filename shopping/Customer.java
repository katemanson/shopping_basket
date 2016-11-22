package shopping;

public class Customer {

  private String name;
  private double wallet;
  private boolean loyaltyCardStatus;

  public Customer(String name, double money) {
    this.name = name;
    this.wallet = money;
    this.loyaltyCardStatus = false;
  }

  public String getName() {
    return this.name;
  }

  public double getWallet() {
    return this.wallet;
  }

  public boolean getLoyaltyCardStatus() {
    return this.loyaltyCardStatus;
  }


}