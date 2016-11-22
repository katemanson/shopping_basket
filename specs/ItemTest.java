import static org.junit.Assert.*;
import org.junit.*;
import shopping.*;

public class ItemTest {

  Item itemOne;

  @Before
  public void before() {
    itemOne = new Item("Thingy", 12.99);
  }

  @Test
  public void testCanGetDescription() {
    assertEquals("Thingy", itemOne.getDescription());
  }

  @Test
  public void testCanGetPrice() {
    assertEquals(12.99, itemOne.getPrice(), 0.001);
  }

  @Test
  public void testCanGetBogofStatus() {
    assertEquals(false, itemOne.getBogofStatus());
  }

  @Test
  public void testCanSetDescription() {
    itemOne.setDescription("Whatsit");
    assertEquals("Whatsit", itemOne.getDescription());
  }

  @Test
  public void testCanSetPrice() {
    itemOne.setPrice(9.99);
    assertEquals(9.99, itemOne.getPrice(), 0.001);
  }

  @Test
  public void testCanSetBogofStatus() {
    itemOne.setBogofStatus(true);
    assertEquals(true, itemOne.getBogofStatus());
  }
}