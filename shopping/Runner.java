import shopping.*;
import java.util.*;

public class Runner {

  public static void print(String message) {
    System.out.println(message);
  }

  public static String read() {
    return System.console().readLine();
  }

  public static void main(String[] args) {

    print("Enter customer name:");
    String customerName = read();

    print("Enter customer money:");
    double customerWallet = Double.parseDouble(read());

    print("Does the customer have a loyalty card? (Y/N):");
    boolean hasLoyaltyCard;
    if ( read() == "Y" || read() == "y" ) {
      hasLoyaltyCard = true;
    }
    else hasLoyaltyCard = false;

    Customer theCustomer = new Customer(customerName, customerWallet, hasLoyaltyCard);

    print("Customer name: " + theCustomer.getName() + "\nCustomer wallet: " + theCustomer.getWallet() + "\nCustomer has loyalty card: " + theCustomer.hasLoyaltyCard());

  }


}