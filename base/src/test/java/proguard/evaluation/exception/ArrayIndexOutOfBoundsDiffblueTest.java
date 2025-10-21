package proguard.evaluation.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ArrayIndexOutOfBoundsDiffblueTest {
  /**
   * Test {@link ArrayIndexOutOfBounds#ArrayIndexOutOfBounds(int, int)}.
   *
   * <p>Method under test: {@link ArrayIndexOutOfBounds#ArrayIndexOutOfBounds(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ArrayIndexOutOfBounds.<init>(int, int)"})
  public void testNewArrayIndexOutOfBounds() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "int ArrayIndexOutOfBounds.getBound()",
    "int ArrayIndexOutOfBounds.getIndex()"
  })
  public void testGettersAndSetters() {
    // Arrange
    ArrayIndexOutOfBounds arrayIndexOutOfBounds = new ArrayIndexOutOfBounds(1, 1);

    // Act
    int actualBound = arrayIndexOutOfBounds.getBound();

    // Assert
    assertEquals(1, actualBound);
    assertEquals(1, arrayIndexOutOfBounds.getIndex());
  }
}
