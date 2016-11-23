import static org.junit.Assert.*;
import org.junit.*;
import shopping.*;

public class CheckoutTest {

  Customer customerOne;
  Customer customerTwo;
  Basket basket;
  Checkout checkoutOne;
  Checkout checkoutTwo;

  @Before
  public void before() {
  customerOne = new Customer("Floortje", 40.00);
  customerTwo = new Customer("Lowrie", 150.00, true);
  basket = new Basket();
  setUpBasket();
  checkoutOne = new Checkout(customerOne, basket);
  checkoutTwo = new Checkout(customerTwo, basket);
  }

  private void setUpBasket() {
    Item milk = new Item("Milk", 1.09, false);
    Item apples = new Item("Apples", 1.49, true);
    Item bread = new Item("Bread", 1.74, true);
    Item oliveOil = new Item("Olive Oil", 8.98, false);
    basket.addItem(milk);
    basket.addItem(apples);
    basket.addItem(apples);
    basket.addItem(bread);
    basket.addItem(bread);
    basket.addItem(bread);
    basket.addItem(oliveOil);
  }

  @Test
  public void canGetDiscounts() {
    assertEquals(0, checkoutOne.getDiscounts().size());
  }




  // @Test
  // public void canGetFinalCost() {
    
  // }
}