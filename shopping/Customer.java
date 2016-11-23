package shopping;
import java.util.*;

public class Customer {

  private String name;
  private double wallet;
  private boolean loyaltyCard;
  private ArrayList<Item> shopping;

  public Customer(String name, double money) {
    this.name = name;
    this.wallet = money;
    this.loyaltyCard = false;
    this.shopping = new ArrayList<>();
  }

  // overloaded constructor
  public Customer(String name, double money, boolean loyaltyCard) {
    this.name = name;
    this.wallet = money;
    this.loyaltyCard = loyaltyCard;
    this.shopping = new ArrayList<>();
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

  public ArrayList<Item> getShopping() {
    return this.shopping;
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