package proguard.evaluation.value;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Category2ValueDiffblueTest {
  /**
   * Test {@link Category2Value#category2Value()}.
   *
   * <p>Method under test: {@link Category2Value#category2Value()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Category2Value Category2Value.category2Value()"})
  public void testCategory2Value() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.category2Value());
  }

  /**
   * Test {@link Category2Value#isCategory2()}.
   *
   * <p>Method under test: {@link Category2Value#isCategory2()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Category2Value.isCategory2()"})
  public void testIsCategory2() {
    // Arrange, Act and Assert
    assertTrue((new UnknownDoubleValue()).isCategory2());
  }
}
