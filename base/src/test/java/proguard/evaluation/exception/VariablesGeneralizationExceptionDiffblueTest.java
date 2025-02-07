package proguard.evaluation.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.exception.VariablesGeneralizationException.<init>(java.lang.Throwable, proguard.evaluation.TracedVariables, proguard.evaluation.TracedVariables)"
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

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VariablesGeneralizationException#getFirst()}
   *   <li>{@link VariablesGeneralizationException#getSecond()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.TracedVariables proguard.evaluation.exception.VariablesGeneralizationException.getFirst()",
    "proguard.evaluation.TracedVariables proguard.evaluation.exception.VariablesGeneralizationException.getSecond()"
  })
  void testGettersAndSetters() {
    // Arrange
    Throwable cause = new Throwable();
    TracedVariables first = new TracedVariables(3);
    TracedVariables second = new TracedVariables(3);
    VariablesGeneralizationException variablesGeneralizationException =
        new VariablesGeneralizationException(cause, first, second);

    // Act
    TracedVariables actualFirst = variablesGeneralizationException.getFirst();

    // Assert
    assertSame(first, actualFirst);
    assertSame(second, variablesGeneralizationException.getSecond());
  }
}
