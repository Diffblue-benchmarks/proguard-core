package proguard.evaluation.value;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class Category1ValueDiffblueTest {
  /**
   * Method under test: {@link Category1Value#category1Value()}
   */
  @Test
  public void testCategory1Value() {
    // Arrange
    TopValue topValue = new TopValue();

    // Act and Assert
    assertSame(topValue, topValue.category1Value());
  }

  /**
   * Method under test: {@link Category1Value#isCategory2()}
   */
  @Test
  public void testIsCategory2() {
    // Arrange, Act and Assert
    assertFalse((new TopValue()).isCategory2());
  }
}
