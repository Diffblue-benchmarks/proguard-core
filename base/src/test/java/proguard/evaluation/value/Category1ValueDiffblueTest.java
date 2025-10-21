package proguard.evaluation.value;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Category1ValueDiffblueTest {
  /**
   * Test {@link Category1Value#category1Value()}.
   *
   * <p>Method under test: {@link Category1Value#category1Value()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Category1Value Category1Value.category1Value()"})
  public void testCategory1Value() {
    // Arrange
    TopValue topValue = new TopValue();

    // Act and Assert
    assertSame(topValue, topValue.category1Value());
  }

  /**
   * Test {@link Category1Value#isCategory2()}.
   *
   * <p>Method under test: {@link Category1Value#isCategory2()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Category1Value.isCategory2()"})
  public void testIsCategory2() {
    // Arrange, Act and Assert
    assertFalse((new TopValue()).isCategory2());
  }
}
