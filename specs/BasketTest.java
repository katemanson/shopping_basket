import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import shopping.*;

public class BasketTest {

  Basket basketOne;
  Customer customerOne;
  Customer customerTwo;
  Item soap;
  Item milk;
  Item apples;
  Item bread;
  Item oliveOil;

  @Before
  public void before() {
    basketOne = new Basket();
    customerOne = new Customer("Floortje", 50.00, true);
    customerTwo = new Customer("Lowrie", 50.00, false);
    soap = new Item("Soap", 2.49, false);
    milk = new Item("Milk", 1.09, false);
    apples = new Item("Apples", 1.49, true);
    bread = new Item("Bread", 1.74, true);
    oliveOil = new Item("Olive Oil", 8.98, false);
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
  public void canAddItem() {
    basketOne.addItem(soap);
    assertEquals(1, basketOne.getContents().size());
  }

  @Test
  public void canAddItems() {
    ArrayList<Item> itemsToAdd = new ArrayList<>();
    itemsToAdd.add(soap);
    itemsToAdd.add(milk);
    itemsToAdd.add(apples);
    itemsToAdd.add(bread);
    basketOne.addItems(itemsToAdd);
    assertEquals(4, basketOne.getContents().size());
  }

  @Test
  public void testCanEmptyBasket() {
    basketOne.addItem(soap);
    basketOne.addItem(milk);
    basketOne.addItem(apples);
    basketOne.addItem(bread);
    assertEquals(4, basketOne.getContents().size());
    basketOne.emptyBasket();
    assertEquals(0, basketOne.getContents().size());    
  }

  @Test
  public void testCanGetItemWithIndex() {
    basketOne.addItem(apples);
    basketOne.addItem(bread);
    assertEquals("Bread", basketOne.getItem(1).getDescription());
    assertEquals(2, basketOne.getContents().size());
  }

  @Test
  public void testCanRemoveItemAtIndex() {
    basketOne.addItem(apples);
    basketOne.addItem(bread);
    basketOne.addItem(soap);
    assertEquals(3, basketOne.getContents().size());
    assertEquals("Apples", basketOne.removeFirstItem().getDescription());
    assertEquals(2, basketOne.getContents().size());
  }

  @Test
  public void canGetItemWithDescription() {
    basketOne.addItem(apples);
    basketOne.addItem(bread);
    assertEquals(Item.class, basketOne.getItem("Apples").getClass());
    assertEquals("Apples", basketOne.getItem("Apples").getDescription());
    assertEquals(2, basketOne.getContents().size());
  }

  @Test
  public void canRemoveItemWithDescription() {
    basketOne.addItem(apples);
    basketOne.addItem(bread);
    assertEquals("Apples", basketOne.removeItem("Apples").getDescription());
    assertEquals(1, basketOne.getContents().size());
  }

  @Test
  public void testCanGetFirstItem() {
    basketOne.addItem(apples);
    basketOne.addItem(bread);
    assertEquals("Apples", basketOne.getFirstItem().getDescription());
    assertEquals(2, basketOne.getContents().size());
  }

  @Test
  public void canRemoveFirstItem() {
    basketOne.addItem(apples);
    basketOne.addItem(bread);
    assertEquals("Apples", basketOne.getFirstItem().getDescription());
    assertEquals(2, basketOne.getContents().size());
    basketOne.removeFirstItem();
    assertEquals("Bread", basketOne.getFirstItem().getDescription());
    assertEquals(1, basketOne.getContents().size());
  }

  @Test
  public void canRemoveItemAsObject() {
    basketOne.addItem(apples);
    basketOne.addItem(apples);
    basketOne.addItem(bread);
    basketOne.addItem(bread);
    basketOne.addItem(bread);
    assertEquals(5, basketOne.getContents().size());    
    basketOne.removeItem(apples);
    assertEquals(4, basketOne.getContents().size());
  }

}