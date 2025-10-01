package proguard.evaluation.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.evaluation.TracedVariables;

class VariablesGeneralizationExceptionDiffblueTest {
  /**
   * Test {@link VariablesGeneralizationException#VariablesGeneralizationException(Throwable,
   * TracedVariables, TracedVariables)}.
   *
   * <p>Method under test: {@link
   * VariablesGeneralizationException#VariablesGeneralizationException(Throwable, TracedVariables,
   * TracedVariables)}
   */
  @Test
  @DisplayName(
      "Test new VariablesGeneralizationException(Throwable, TracedVariables, TracedVariables)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void VariablesGeneralizationException.<init>(Throwable, TracedVariables, TracedVariables)"
  })
  void testNewVariablesGeneralizationException() {
    // Arrange
    Throwable cause = new Throwable();
    TracedVariables first = new TracedVariables(3);
    TracedVariables second = new TracedVariables(3);

    // Act
    VariablesGeneralizationException actualVariablesGeneralizationException =
        new VariablesGeneralizationException(cause, first, second);

    // Assert
    assertEquals(
        "Could not generalize variables [empty:empty][empty:empty][empty:empty] and [empty:empty][empty:empty"
            + "][empty:empty] because: \"null\".",
        actualVariablesGeneralizationException.getLocalizedMessage());
    assertEquals(
        "Could not generalize variables [empty:empty][empty:empty][empty:empty] and [empty:empty][empty:empty"
            + "][empty:empty] because: \"null\".",
        actualVariablesGeneralizationException.getMessage());
    assertEquals(0, actualVariablesGeneralizationException.getSuppressed().length);
    assertEquals(1010, actualVariablesGeneralizationException.getComponentErrorId());
    assertEquals(3, actualVariablesGeneralizationException.getErrorParameters().length);
    assertSame(cause, actualVariablesGeneralizationException.getCause());
    assertSame(first, actualVariablesGeneralizationException.getFirst());
    assertSame(second, actualVariablesGeneralizationException.getSecond());
  }
}
