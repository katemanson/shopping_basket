import static org.junit.Assert.*;
import org.junit.*;
import shopping.*;

public class CheckoutTest {

  Customer customerOne;
  Customer customerTwo;
  Basket basketOne;
  Basket basketTwo;
  Checkout checkoutOne;
  Checkout checkoutTwo;

  @Before
  public void before() {
  customerOne = new Customer("Floortje", 40.00);
  customerTwo = new Customer("Lowrie", 150.00, true);
  basketOne = new Basket();
  basketTwo = new Basket();
  setUpBasketOne();
  setUpBasketTwo();
  checkoutOne = new Checkout(customerOne, basketOne);
  checkoutTwo = new Checkout(customerTwo, basketTwo);
  }

  private void setUpBasketOne() {
    Item milk = new Item("Milk", 1.09, false);
    Item apples = new Item("Apples", 1.49, true);
    Item bread = new Item("Bread", 1.74, true);
    Item oliveOil = new Item("Olive Oil", 8.98, false);
    basketOne.addItem(milk);
    basketOne.addItem(apples);
    basketOne.addItem(apples);
    basketOne.addItem(bread);
    basketOne.addItem(bread);
    basketOne.addItem(bread);
    basketOne.addItem(oliveOil);
    basketOne.addItem(oliveOil);
  }

  private void setUpBasketTwo() {
    Item laundryDetergent = new Item("Laundry Detergent", 8.75, false);
    Item sharonFruit = new Item("Sharon Fruit", 2.24, true);
    Item granola = new Item("Granola", 3.99, true);
    Item yoghurt = new Item("Yoghurt", 1.65, false);
    Item lightbulb = new Item("Lightbulb", 5.34, false);
    basketTwo.addItem(laundryDetergent);
    basketTwo.addItem(laundryDetergent);
    basketTwo.addItem(sharonFruit);
    basketTwo.addItem(sharonFruit);
    basketTwo.addItem(sharonFruit);
    basketTwo.addItem(granola);
    basketTwo.addItem(yoghurt);
    basketTwo.addItem(lightbulb);
  }

  @Test
  public void canGetDiscounts() {
    assertEquals(0, checkoutOne.getDiscounts().size());
  }

  @Test
  public void canSetDiscount() {
    checkoutOne.setDiscount(new BogofDiscount(basketOne));
    assertEquals(1, checkoutOne.getDiscounts().size());
  }

  @Test
  public void canGetTotalBeforeDiscounts() {
    assertEquals(27.25, checkoutOne.totalBeforeDiscounts(), 0.01);
    assertEquals(35.20, checkoutTwo.totalBeforeDiscounts(), 0.01);
  }

  // @Test
  // public void canApplyDiscounts() {
  //   checkoutOne.setDiscount(new BogofDiscount(basketOne));
  //   checkoutOne.setDiscount(new )
  //   assertEquals(21.62, checkoutOne.totalAfterDiscounts());
  //   assertEquals(29.95, checkoutTwo.totalAfterDiscounts());
  // }

}