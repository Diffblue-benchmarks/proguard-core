package proguard.evaluation.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class IncompleteClassHierarchyExceptionDiffblueTest {
  /**
   * Test {@link IncompleteClassHierarchyException#IncompleteClassHierarchyException(String)}.
   *
   * <p>Method under test: {@link
   * IncompleteClassHierarchyException#IncompleteClassHierarchyException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncompleteClassHierarchyException.<init>(String)"})
  public void testNewIncompleteClassHierarchyException() {
    // Arrange and Act
    IncompleteClassHierarchyException actualIncompleteClassHierarchyException =
        new IncompleteClassHierarchyException("An error occurred");

    // Assert
    assertEquals(
        "An error occurred", actualIncompleteClassHierarchyException.getLocalizedMessage());
    assertEquals("An error occurred", actualIncompleteClassHierarchyException.getMessage());
    assertNull(actualIncompleteClassHierarchyException.getCause());
    assertEquals(0, actualIncompleteClassHierarchyException.getSuppressed().length);
    assertEquals(0, actualIncompleteClassHierarchyException.getErrorParameters().length);
    assertEquals(1004, actualIncompleteClassHierarchyException.getComponentErrorId());
  }

  /**
   * Test {@link IncompleteClassHierarchyException#IncompleteClassHierarchyException(String)}.
   *
   * <ul>
   *   <li>Then return LocalizedMessage is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IncompleteClassHierarchyException#IncompleteClassHierarchyException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncompleteClassHierarchyException.<init>(String)"})
  public void testNewIncompleteClassHierarchyException_thenReturnLocalizedMessageIsNull() {
    // Arrange and Act
    IncompleteClassHierarchyException actualIncompleteClassHierarchyException =
        new IncompleteClassHierarchyException(null);

    // Assert
    assertNull(actualIncompleteClassHierarchyException.getLocalizedMessage());
    assertNull(actualIncompleteClassHierarchyException.getMessage());
    assertNull(actualIncompleteClassHierarchyException.getCause());
    assertEquals(0, actualIncompleteClassHierarchyException.getSuppressed().length);
    assertEquals(0, actualIncompleteClassHierarchyException.getErrorParameters().length);
    assertEquals(1004, actualIncompleteClassHierarchyException.getComponentErrorId());
  }
}
