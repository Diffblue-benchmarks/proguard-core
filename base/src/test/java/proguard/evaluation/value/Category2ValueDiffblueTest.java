package proguard.evaluation.value;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class Category2ValueDiffblueTest {
  /**
   * Method under test: {@link Category2Value#category2Value()}
   */
  @Test
  public void testCategory2Value() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.category2Value());
  }

  /**
   * Method under test: {@link Category2Value#isCategory2()}
   */
  @Test
  public void testIsCategory2() {
    // Arrange, Act and Assert
    assertTrue((new UnknownDoubleValue()).isCategory2());
  }
}
