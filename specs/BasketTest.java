import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import shopping.*;

public class BasketTest {

  Basket basketOne;
  Item barOfSoap;

  @Before
  public void before() {
    basketOne = new Basket();
    barOfSoap = new Item("Soap", 2.49);
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

}