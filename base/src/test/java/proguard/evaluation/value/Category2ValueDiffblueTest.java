package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class Category2ValueDiffblueTest {
  /**
   * Test {@link Category2Value#category2Value()}.
   *
   * <p>Method under test: {@link Category2Value#category2Value()}
   */
  @Test
  @DisplayName("Test category2Value()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Category2Value proguard.evaluation.value.Category2Value.category2Value()"
  })
  void testCategory2Value() {
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
  @DisplayName("Test isCategory2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.value.Category2Value.isCategory2()"})
  void testIsCategory2() {
    // Arrange, Act and Assert
    assertTrue((new UnknownDoubleValue()).isCategory2());
  }
}
