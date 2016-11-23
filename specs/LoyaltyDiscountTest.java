import static org.junit.Assert.*;
import org.junit.*;
import shopping.*;

public class LoyaltyDiscountTest {

  Customer customerOne;
  Customer customerTwo;
  double total;
  LoyaltyDiscount loyaltyDiscountOne;
  LoyaltyDiscount loyaltyDiscountTwo;

  @Before
  public void before() {
    customerOne = new Customer("Floortje", 50.00, true);
    customerTwo = new Customer("Lowrie", 50.00, false);
    total = 53.67;
    loyaltyDiscountOne = new LoyaltyDiscount(customerOne, total);
    loyaltyDiscountTwo = new LoyaltyDiscount(customerTwo, total);
    }

  @Test
  public void canApplyLoyaltyDiscount_LoyaltyCard() {
    assertEquals(52.60, loyaltyDiscountOne.applyDiscount(), 0.01);
  }

  @Test
  public void canApplyLoyaltyDiscount_NoLoyaltyCard() {
    assertEquals(53.67, loyaltyDiscountTwo.applyDiscount(), 0.01);
  }
}