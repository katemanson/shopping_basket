package shopping;
import java.util.*;

public class Customer {

  private String name;
  private double wallet;
  private boolean loyaltyCard;
  private ArrayList<Item> shoppingBag;

  public Customer(String name, double money) {
    this.name = name;
    this.wallet = money;
    this.loyaltyCard = false;
    this.shoppingBag = new ArrayList<>();
  }

  // overloaded constructor
  public Customer(String name, double money, boolean loyaltyCard) {
    this.name = name;
    this.wallet = money;
    this.loyaltyCard = loyaltyCard;
    this.shoppingBag = new ArrayList<>();
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

  public ArrayList<Item> getShoppingBag() {
    return this.shoppingBag;
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

  public void packBag(Basket basket) {
    this.shoppingBag.addAll(basket.getContents());
  }

}