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
  BogofDiscount bogofOne;
  BogofDiscount bogofTwo;
  ThresholdDiscount thresholdOne;
  ThresholdDiscount thresholdTwo;
  ThresholdDiscount thresholdBasic;
  LoyaltyDiscount loyaltyOne;
  LoyaltyDiscount loyaltyTwo;

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
  thresholdBasic = new ThresholdDiscount(100);
  bogofOne = new BogofDiscount(basketOne);
  bogofTwo = new BogofDiscount(basketTwo);
  thresholdOne = new ThresholdDiscount(bogofOne.applyDiscount());
  thresholdTwo = new ThresholdDiscount(bogofTwo.applyDiscount());
  loyaltyOne = new LoyaltyDiscount(customerOne, thresholdOne.applyDiscount());
  loyaltyTwo = new LoyaltyDiscount(customerTwo, thresholdTwo.applyDiscount());
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
  public void canGetRawTotal() {
    assertEquals(27.25, checkoutOne.rawTotal(), 0.01);
    assertEquals(35.20, checkoutTwo.rawTotal(), 0.01);
  }

  @Test
  public void canApplyDiscounts_Simple() {
    checkoutOne.setDiscount(thresholdBasic);
    assertEquals(1, checkoutOne.getDiscounts().size());
    assertEquals(90.0, checkoutOne.discountedTotal(), 0.01);
  }

  @Test
  public void canApplyDiscounts_BitMoreComplex() {
    checkoutOne.setDiscount(bogofOne);
    checkoutOne.setDiscount(thresholdOne);
    checkoutOne.setDiscount(loyaltyOne);
    assertEquals(3, checkoutOne.getDiscounts().size());
    assertEquals(21.62, checkoutOne.discountedTotal(), 0.01);
  }

  @Test
  public void canApplyDiscounts_MoreComplexAgain() {
    checkoutTwo.setDiscount(bogofTwo);
    checkoutTwo.setDiscount(thresholdTwo);
    checkoutTwo.setDiscount(loyaltyTwo);
    assertEquals(3, checkoutTwo.getDiscounts().size());
    assertEquals(29.07, checkoutTwo.discountedTotal(), 0.01);
  }

}