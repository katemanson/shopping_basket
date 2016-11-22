import static org.junit.Assert.*;
import org.junit.*;
import shopping.*;

public class ItemTest {

  Item itemOne;
  Item itemTwo;

  @Before
  public void before() {
    itemOne = new Item("Thingy", 12.99);
    itemTwo = new Item("Doofer", 4.45, true);
  }

  @Test
  public void testCanGetDescription() {
    assertEquals("Thingy", itemOne.getDescription());
    assertEquals("Doofer", itemTwo.getDescription());
  }

  @Test
  public void testCanGetPrice() {
    assertEquals(12.99, itemOne.getPrice(), 0.001);
    assertEquals(4.45, itemTwo.getPrice(), 0.001);
  }

  @Test
  public void testCanGetBogofStatus() {
    assertEquals(false, itemOne.getBogofStatus());
    assertEquals(true, itemTwo.getBogofStatus());
  }

  @Test
  public void testCanSetDescription() {
    itemOne.setDescription("Whatsit");
    itemTwo.setDescription("Thingumajig");
    assertEquals("Whatsit", itemOne.getDescription());
    assertEquals("Thingumajig", itemTwo.getDescription());
  }

  @Test
  public void testCanSetPrice() {
    itemOne.setPrice(9.99);
    itemTwo.setPrice(5.45);
    assertEquals(9.99, itemOne.getPrice(), 0.001);
    assertEquals(5.45, itemTwo.getPrice(), 0.001);
  }

  @Test
  public void testCanSetBogofStatus() {
    itemOne.setBogofStatus(true);
    itemTwo.setBogofStatus(false);
    assertEquals(true, itemOne.getBogofStatus());
    assertEquals(false, itemTwo.getBogofStatus());
  }
}