package shopping;

public class Customer {

  private String name;
  private double wallet;
  private boolean loyaltyCard;

  public Customer(String name, double money) {
    this.name = name;
    this.wallet = money;
    this.loyaltyCard = false;
  }

  public String getName() {
    return this.name;
  }

  public double getWallet() {
    return this.wallet;
  }

  public boolean hasLoyaltyCard() {
    return this.loyaltyCard;
  }

  public void setName(String newName) {
    this.name = newName;
  }

  public void setWallet(double newMoney) {
    this.wallet = newMoney;
  }

  public void setHasLoyaltyCard(boolean newStatus) {
    this.loyaltyCard = newStatus;
  }

}