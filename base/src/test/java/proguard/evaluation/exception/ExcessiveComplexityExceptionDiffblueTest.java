package proguard.evaluation.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ExcessiveComplexityExceptionDiffblueTest {
  /**
   * Test {@link ExcessiveComplexityException#ExcessiveComplexityException(String)}.
   *
   * <ul>
   *   <li>Then return LocalizedMessage is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ExcessiveComplexityException#ExcessiveComplexityException(String)}
   */
  @Test
  @DisplayName(
      "Test new ExcessiveComplexityException(String); then return LocalizedMessage is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.exception.ExcessiveComplexityException.<init>(java.lang.String)"
  })
  void testNewExcessiveComplexityException_thenReturnLocalizedMessageIsAnErrorOccurred() {
    // Arrange and Act
    ExcessiveComplexityException actualExcessiveComplexityException =
        new ExcessiveComplexityException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualExcessiveComplexityException.getLocalizedMessage());
    assertEquals("An error occurred", actualExcessiveComplexityException.getMessage());
    assertNull(actualExcessiveComplexityException.getCause());
    assertEquals(0, actualExcessiveComplexityException.getSuppressed().length);
    assertEquals(0, actualExcessiveComplexityException.getErrorParameters().length);
    assertEquals(1003, actualExcessiveComplexityException.getComponentErrorId());
  }

  /**
   * Test {@link ExcessiveComplexityException#ExcessiveComplexityException(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return LocalizedMessage is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExcessiveComplexityException#ExcessiveComplexityException(String)}
   */
  @Test
  @DisplayName(
      "Test new ExcessiveComplexityException(String); when 'null'; then return LocalizedMessage is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.exception.ExcessiveComplexityException.<init>(java.lang.String)"
  })
  void testNewExcessiveComplexityException_whenNull_thenReturnLocalizedMessageIsNull() {
    // Arrange and Act
    ExcessiveComplexityException actualExcessiveComplexityException =
        new ExcessiveComplexityException(null);

    // Assert
    assertNull(actualExcessiveComplexityException.getLocalizedMessage());
    assertNull(actualExcessiveComplexityException.getMessage());
    assertNull(actualExcessiveComplexityException.getCause());
    assertEquals(0, actualExcessiveComplexityException.getSuppressed().length);
    assertEquals(0, actualExcessiveComplexityException.getErrorParameters().length);
    assertEquals(1003, actualExcessiveComplexityException.getComponentErrorId());
  }
}
