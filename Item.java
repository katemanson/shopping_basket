package shopping;

public class Item {

  private String description;
  private double price;
  private boolean bogofStatus;

  public Item(String description, double price) {
    this.description = description;
    this.price = price;
    this.bogofStatus = false;
  }

  public String getDescription() {
    return this.description;
  }

  public double getPrice() {
    return this.price;
  }

  public boolean getBogofStatus() {
    return this.bogofStatus;
  }

  public void setDescription(String newDescription) {
    this.description = newDescription;
  }

  public void setPrice(double newPrice) {
    this.price = newPrice;
  }

  public void setBogofStatus(boolean newStatus) {
    this.bogofStatus = newStatus;
  }

}