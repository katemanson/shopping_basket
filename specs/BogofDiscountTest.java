import static org.junit.Assert.*;
import org.junit.*;
import shopping.*;

public class BogofDiscountTest {

  Basket basket;
  Item soap;
  Item milk;
  Item apples;
  Item bread;
  Item oliveOil;
  BogofDiscount bogof;

  @Before
  public void before() {
    basket = new Basket();
    soap = new Item("Soap", 2.49, false);
    milk = new Item("Milk", 1.09, false);
    apples = new Item("Apples", 1.49, true);
    bread = new Item("Bread", 1.74, true);
    oliveOil = new Item("Olive Oil", 8.98, false);
    bogof = new BogofDiscount(basket);
  }

  @Test
  public void canApplyBogofDiscounts_TwoItems() {
    basket.addItem(apples);
    basket.addItem(apples);
    assertEquals(1.49, bogof.applyDiscount(), 0.01);
  }

  @Test
  public void canApplyBogofDiscounts_ThreeItems() {
    basket.addItem(apples);
    basket.addItem(apples);
    basket.addItem(apples);
    assertEquals(2.98, bogof.applyDiscount(), 0.01);
  }

  @Test
  public void canApplyBogofDiscounts_VariousItems() {
    basket.addItem(apples);
    basket.addItem(apples);
    basket.addItem(bread);
    basket.addItem(bread);
    basket.addItem(bread);
    basket.addItem(soap);
    basket.addItem(soap);
    basket.addItem(milk);
    assertEquals(11.04, bogof.applyDiscount(), 0.01);
  }

}