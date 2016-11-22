import static org.junit.Assert.*;
import org.junit.*;
import shopping.*;

public class CustomerTest {

  Customer customerOne;
  Customer customerTwo;

  @Before
  public void before() {
  customerOne = new Customer("Floortje", 40.00);
  customerTwo = new Customer("Lowrie", 150.00, true);
  }

  @Test
  public void testCanGetName() {
    assertEquals("Floortje", customerOne.getName());
    assertEquals("Lowrie", customerTwo.getName());
  }

  @Test
  public void testCanGetWallet() {
    assertEquals(40.00, customerOne.getWallet(), 0.001);
    assertEquals(150.00, customerTwo.getWallet(), 0.001);
  }

  @Test
  public void testHasLoyaltyCard() {
    assertEquals(false, customerOne.hasLoyaltyCard());
    assertEquals(true, customerTwo.hasLoyaltyCard());
  }

  @Test
  public void testCanSetName() {
    customerOne.setName("Freya");
    customerTwo.setName("Magnus");
    assertEquals("Freya", customerOne.getName());
    assertEquals("Magnus", customerTwo.getName());
  }

  @Test
  public void testCanSetWallet() {
    customerOne.setWallet(20.00);
    customerTwo.setWallet(100.00);
    assertEquals(20.00, customerOne.getWallet(), 0.001);
    assertEquals(100.00, customerTwo.getWallet(), 0.001);
  }

  @Test
  public void testCanSetHasLoyaltyCard() {
    customerOne.setHasLoyaltyCard(true);
    customerTwo.setHasLoyaltyCard(false);
    assertEquals(true, customerOne.hasLoyaltyCard());
    assertEquals(false, customerTwo.hasLoyaltyCard());
  }

}