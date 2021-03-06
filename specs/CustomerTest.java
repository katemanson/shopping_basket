import static org.junit.Assert.*;
import org.junit.*;
import shopping.*;

public class CustomerTest {

  Customer customerOne;
  Customer customerTwo;
  Basket basket;
  Item milk;
  Item apples;
  Item bread;
  Item oliveOil;

  @Before
  public void before() {
  customerOne = new Customer("Floortje", 40.00);
  customerTwo = new Customer("Lowrie", 150.00, true);
  basket = new Basket();
  setUpBasket();
  }

  private void setUpBasket() {
    milk = new Item("Milk", 1.09, false);
    apples = new Item("Apples", 1.49, true);
    bread = new Item("Bread", 1.74, true);
    oliveOil = new Item("Olive Oil", 8.98, false);
    basket.addItem(milk);
    basket.addItem(apples);
    basket.addItem(apples);
    basket.addItem(bread);
    basket.addItem(bread);
    basket.addItem(bread);
    basket.addItem(oliveOil);
  }

  @Test
  public void canGetName() {
    assertEquals("Floortje", customerOne.getName());
    assertEquals("Lowrie", customerTwo.getName());
  }

  @Test
  public void canGetWallet() {
    assertEquals(40.00, customerOne.getWallet(), 0.001);
    assertEquals(150.00, customerTwo.getWallet(), 0.001);
  }

  @Test
  public void testHasLoyaltyCard() {
    assertEquals(false, customerOne.hasLoyaltyCard());
    assertEquals(true, customerTwo.hasLoyaltyCard());
  }

  @Test
  public void canGetShoppingBag() {
    assertEquals(0, customerOne.getShoppingBag().size());
    assertEquals(0, customerTwo.getShoppingBag().size());
  }

  @Test
  public void canSetName() {
    customerOne.setName("Freya");
    customerTwo.setName("Magnus");
    assertEquals("Freya", customerOne.getName());
    assertEquals("Magnus", customerTwo.getName());
  }

  @Test
  public void canSetWallet() {
    customerOne.setWallet(20.00);
    customerTwo.setWallet(100.00);
    assertEquals(20.00, customerOne.getWallet(), 0.001);
    assertEquals(100.00, customerTwo.getWallet(), 0.001);
  }

  @Test
  public void canSetHasLoyaltyCard() {
    customerOne.setHasLoyaltyCard(true);
    customerTwo.setHasLoyaltyCard(false);
    assertEquals(true, customerOne.hasLoyaltyCard());
    assertEquals(false, customerTwo.hasLoyaltyCard());
  }

  @Test
  public void canPackBag() {
    customerOne.packBag(basket);
    assertEquals(7, customerOne.getShoppingBag().size());
  } 

}