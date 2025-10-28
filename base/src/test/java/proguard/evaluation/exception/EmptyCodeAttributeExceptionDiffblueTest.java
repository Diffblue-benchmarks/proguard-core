package proguard.evaluation.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class EmptyCodeAttributeExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link EmptyCodeAttributeException#EmptyCodeAttributeException(String)}
   */
  @Test
  public void testNewEmptyCodeAttributeException() {
    // Arrange and Act
    EmptyCodeAttributeException actualEmptyCodeAttributeException = new EmptyCodeAttributeException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualEmptyCodeAttributeException.getLocalizedMessage());
    assertEquals("An error occurred", actualEmptyCodeAttributeException.getMessage());
    assertNull(actualEmptyCodeAttributeException.getCause());
    assertEquals(0, actualEmptyCodeAttributeException.getSuppressed().length);
    assertEquals(0, actualEmptyCodeAttributeException.getErrorParameters().length);
    assertEquals(1005, actualEmptyCodeAttributeException.getComponentErrorId());
  }

  /**
   * Method under test:
   * {@link EmptyCodeAttributeException#EmptyCodeAttributeException(String)}
   */
  @Test
  public void testNewEmptyCodeAttributeException2() {
    // Arrange and Act
    EmptyCodeAttributeException actualEmptyCodeAttributeException = new EmptyCodeAttributeException(null);

    // Assert
    assertNull(actualEmptyCodeAttributeException.getLocalizedMessage());
    assertNull(actualEmptyCodeAttributeException.getMessage());
    assertNull(actualEmptyCodeAttributeException.getCause());
    assertEquals(0, actualEmptyCodeAttributeException.getSuppressed().length);
    assertEquals(0, actualEmptyCodeAttributeException.getErrorParameters().length);
    assertEquals(1005, actualEmptyCodeAttributeException.getComponentErrorId());
  }
}
