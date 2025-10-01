package proguard.evaluation.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ArrayIndexOutOfBoundsDiffblueTest {
  /**
   * Test {@link ArrayIndexOutOfBounds#ArrayIndexOutOfBounds(int, int)}.
   *
   * <p>Method under test: {@link ArrayIndexOutOfBounds#ArrayIndexOutOfBounds(int, int)}
   */
  @Test
  @DisplayName("Test new ArrayIndexOutOfBounds(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ArrayIndexOutOfBounds.<init>(int, int)"})
  void testNewArrayIndexOutOfBounds() {
    // Arrange and Act
    ArrayIndexOutOfBounds actualArrayIndexOutOfBounds = new ArrayIndexOutOfBounds(1, 1);

    // Assert
    Object[] errorParameters = actualArrayIndexOutOfBounds.getErrorParameters();
    assertEquals("1", errorParameters[0]);
    assertEquals("1", errorParameters[1]);
    assertEquals(
        "Index [1] out of bounds for array of length 1",
        actualArrayIndexOutOfBounds.getLocalizedMessage());
    assertEquals(
        "Index [1] out of bounds for array of length 1", actualArrayIndexOutOfBounds.getMessage());
    assertNull(actualArrayIndexOutOfBounds.getCause());
    assertEquals(0, actualArrayIndexOutOfBounds.getSuppressed().length);
    assertEquals(1, actualArrayIndexOutOfBounds.getBound());
    assertEquals(1, actualArrayIndexOutOfBounds.getIndex());
    assertEquals(1008, actualArrayIndexOutOfBounds.getComponentErrorId());
    assertEquals(2, errorParameters.length);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ArrayIndexOutOfBounds#getBound()}
   *   <li>{@link ArrayIndexOutOfBounds#getIndex()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ArrayIndexOutOfBounds.getBound()",
    "int ArrayIndexOutOfBounds.getIndex()"
  })
  void testGettersAndSetters() {
    // Arrange
    ArrayIndexOutOfBounds arrayIndexOutOfBounds = new ArrayIndexOutOfBounds(1, 1);

    // Act
    int actualBound = arrayIndexOutOfBounds.getBound();

    // Assert
    assertEquals(1, actualBound);
    assertEquals(1, arrayIndexOutOfBounds.getIndex());
  }
}
