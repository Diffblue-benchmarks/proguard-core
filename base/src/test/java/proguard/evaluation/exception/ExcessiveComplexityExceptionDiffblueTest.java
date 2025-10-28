package proguard.evaluation.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ExcessiveComplexityExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link ExcessiveComplexityException#ExcessiveComplexityException(String)}
   */
  @Test
  public void testNewExcessiveComplexityException() {
    // Arrange and Act
    ExcessiveComplexityException actualExcessiveComplexityException = new ExcessiveComplexityException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualExcessiveComplexityException.getLocalizedMessage());
    assertEquals("An error occurred", actualExcessiveComplexityException.getMessage());
    assertNull(actualExcessiveComplexityException.getCause());
    assertEquals(0, actualExcessiveComplexityException.getSuppressed().length);
    assertEquals(0, actualExcessiveComplexityException.getErrorParameters().length);
    assertEquals(1003, actualExcessiveComplexityException.getComponentErrorId());
  }

  /**
   * Method under test:
   * {@link ExcessiveComplexityException#ExcessiveComplexityException(String)}
   */
  @Test
  public void testNewExcessiveComplexityException2() {
    // Arrange and Act
    ExcessiveComplexityException actualExcessiveComplexityException = new ExcessiveComplexityException(null);

    // Assert
    assertNull(actualExcessiveComplexityException.getLocalizedMessage());
    assertNull(actualExcessiveComplexityException.getMessage());
    assertNull(actualExcessiveComplexityException.getCause());
    assertEquals(0, actualExcessiveComplexityException.getSuppressed().length);
    assertEquals(0, actualExcessiveComplexityException.getErrorParameters().length);
    assertEquals(1003, actualExcessiveComplexityException.getComponentErrorId());
  }
}
