package proguard.evaluation.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IncompleteClassHierarchyExceptionDiffblueTest {
  /**
   * Test {@link IncompleteClassHierarchyException#IncompleteClassHierarchyException(String)}.
   *
   * <p>Method under test: {@link
   * IncompleteClassHierarchyException#IncompleteClassHierarchyException(String)}
   */
  @Test
  @DisplayName("Test new IncompleteClassHierarchyException(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.exception.IncompleteClassHierarchyException.<init>(java.lang.String)"
  })
  void testNewIncompleteClassHierarchyException() {
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
  @DisplayName(
      "Test new IncompleteClassHierarchyException(String); then return LocalizedMessage is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.exception.IncompleteClassHierarchyException.<init>(java.lang.String)"
  })
  void testNewIncompleteClassHierarchyException_thenReturnLocalizedMessageIsNull() {
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
