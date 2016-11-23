import static org.junit.Assert.*;
import org.junit.*;
import shopping.*;

public class ThresholdDiscountTest {

  double totalOne;
  double totalTwo;
  ThresholdDiscount thresholdDiscountOne;
  ThresholdDiscount thresholdDiscountTwo;

  @Before
  public void before() {
    totalOne = 19.49;
    totalTwo = 36.44;
    thresholdDiscountOne = new ThresholdDiscount(totalOne);
    thresholdDiscountTwo = new ThresholdDiscount(totalTwo);
  }

@Test
public void canApplyThresholdDiscount_NoDiscount() {
  assertEquals(19.49, thresholdDiscountOne.applyDiscount(), 0.01);
}

@Test
public void canApplyThresholdDiscount_Discount() {
  assertEquals(32.80, thresholdDiscountTwo.applyDiscount(), 0.01);
}

}