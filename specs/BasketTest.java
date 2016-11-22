import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import shopping.*;

public class BasketTest {

  Basket basketOne;
  Item barOfSoap;
  Item milk;
  Item apples;
  Item bread;

  @Before
  public void before() {
    basketOne = new Basket();
    barOfSoap = new Item("Soap", 2.49);
    milk = new Item("Milk", 1.09);
    apples = new Item("Apples", 1.49);
    bread = new Item("Bread", 1.74);
  }

  @Test
  public void testCanGetContents() {
    assertEquals(ArrayList.class, basketOne.getContents().getClass());
  }

  @Test
  public void testBasketStartsEmpty() {
    assertEquals(0, basketOne.getContents().size());
  }

  @Test
  public void testCanAddItem() {
    basketOne.addItem(barOfSoap);
    assertEquals(1, basketOne.getContents().size());
  }

  public void testCanEmptyBasket() {
    basketOne.addItem(barOfSoap);
    basketOne.addItem(milk);
    basketOne.addItem(apples);
    basketOne.addItem(bread);
    assertEquals(4, basketOne.getContents().size());
    basketOne.emptyBasket();
    assertEquals(0, basketOne.getContents().size());    
  }

  public void testCanGetItemWithIndex() {
    basketOne.addItem(apples);
    basketOne.addItem(bread);
    assertEquals("Bread", basketOne.getItemWithIndex(1).getDescription());
  }

}