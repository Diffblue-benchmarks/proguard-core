package proguard.evaluation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class IncompleteClassHierarchyExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link IncompleteClassHierarchyException#IncompleteClassHierarchyException(String)}
   */
  @Test
  public void testNewIncompleteClassHierarchyException() {
    // Arrange and Act
    IncompleteClassHierarchyException actualIncompleteClassHierarchyException = new IncompleteClassHierarchyException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualIncompleteClassHierarchyException.getLocalizedMessage());
    assertEquals("An error occurred", actualIncompleteClassHierarchyException.getMessage());
    assertNull(actualIncompleteClassHierarchyException.getCause());
    assertEquals(0, actualIncompleteClassHierarchyException.getSuppressed().length);
    assertEquals(0, actualIncompleteClassHierarchyException.getErrorParameters().length);
    assertEquals(1004, actualIncompleteClassHierarchyException.getComponentErrorId());
  }

  /**
   * Method under test:
   * {@link IncompleteClassHierarchyException#IncompleteClassHierarchyException(String)}
   */
  @Test
  public void testNewIncompleteClassHierarchyException2() {
    // Arrange and Act
    IncompleteClassHierarchyException actualIncompleteClassHierarchyException = new IncompleteClassHierarchyException(
        null);

    // Assert
    assertNull(actualIncompleteClassHierarchyException.getLocalizedMessage());
    assertNull(actualIncompleteClassHierarchyException.getMessage());
    assertNull(actualIncompleteClassHierarchyException.getCause());
    assertEquals(0, actualIncompleteClassHierarchyException.getSuppressed().length);
    assertEquals(0, actualIncompleteClassHierarchyException.getErrorParameters().length);
    assertEquals(1004, actualIncompleteClassHierarchyException.getComponentErrorId());
  }
}
