import static org.junit.Assert.*;
import org.junit.*;
import shopping.*;

public class CustomerTest {

  Customer customerOne;

  @Before
  public void before() {
  customerOne = new Customer("Floortje", 40.00);
  }

  @Test
  public void testCanGetName() {
    assertEquals("Floortje", customerOne.getName());
  }

  @Test
  public void testCanGetWallet() {
    assertEquals(40.00, customerOne.getWallet(), 0.001);
  }

  @Test
  public void testCanGetLoyaltyCardStatus() {
    assertEquals(false, customerOne.getLoyaltyCardStatus());
  }

}