package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class Category1ValueDiffblueTest {
  /**
   * Test {@link Category1Value#category1Value()}.
   *
   * <p>Method under test: {@link Category1Value#category1Value()}
   */
  @Test
  @DisplayName("Test category1Value()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Category1Value Category1Value.category1Value()"})
  void testCategory1Value() {
    // Arrange
    TopValue topValue = new TopValue();

    // Act
    Category1Value actualCategory1ValueResult = topValue.category1Value();

    // Assert
    assertSame(topValue, actualCategory1ValueResult);
  }

  /**
   * Test {@link Category1Value#isCategory2()}.
   *
   * <p>Method under test: {@link Category1Value#isCategory2()}
   */
  @Test
  @DisplayName("Test isCategory2()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Category1Value.isCategory2()"})
  void testIsCategory2() {
    // Arrange, Act and Assert
    assertFalse(new TopValue().isCategory2());
  }
}
