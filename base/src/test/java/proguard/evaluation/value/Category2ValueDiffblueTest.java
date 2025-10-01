package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Category2Value Category2Value.category2Value()"})
  void testCategory2Value() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    Category2Value actualCategory2ValueResult = unknownDoubleValue.category2Value();

    // Assert
    assertSame(unknownDoubleValue, actualCategory2ValueResult);
  }

  /**
   * Test {@link Category2Value#isCategory2()}.
   *
   * <p>Method under test: {@link Category2Value#isCategory2()}
   */
  @Test
  @DisplayName("Test isCategory2()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Category2Value.isCategory2()"})
  void testIsCategory2() {
    // Arrange, Act and Assert
    assertTrue(new UnknownDoubleValue().isCategory2());
  }
}
