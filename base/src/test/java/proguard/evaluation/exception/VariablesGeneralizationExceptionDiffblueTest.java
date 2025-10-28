package proguard.evaluation.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;
import proguard.evaluation.TracedVariables;

public class VariablesGeneralizationExceptionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link VariablesGeneralizationException#getFirst()}
   *   <li>{@link VariablesGeneralizationException#getSecond()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Throwable cause = new Throwable();
    TracedVariables first = new TracedVariables(3);
    TracedVariables second = new TracedVariables(3);
    VariablesGeneralizationException variablesGeneralizationException = new VariablesGeneralizationException(cause,
        first, second);

    // Act
    TracedVariables actualFirst = variablesGeneralizationException.getFirst();

    // Assert
    assertSame(first, actualFirst);
    assertSame(second, variablesGeneralizationException.getSecond());
  }

  /**
   * Method under test:
   * {@link VariablesGeneralizationException#VariablesGeneralizationException(Throwable, TracedVariables, TracedVariables)}
   */
  @Test
  public void testNewVariablesGeneralizationException() {
    // Arrange
    Throwable cause = new Throwable();
    TracedVariables first = new TracedVariables(3);
    TracedVariables second = new TracedVariables(3);

    // Act
    VariablesGeneralizationException actualVariablesGeneralizationException = new VariablesGeneralizationException(
        cause, first, second);

    // Assert
    assertEquals("Could not generalize variables [empty:empty][empty:empty][empty:empty] and [empty:empty][empty:empty"
        + "][empty:empty] because: \"null\".", actualVariablesGeneralizationException.getLocalizedMessage());
    assertEquals("Could not generalize variables [empty:empty][empty:empty][empty:empty] and [empty:empty][empty:empty"
        + "][empty:empty] because: \"null\".", actualVariablesGeneralizationException.getMessage());
    Object[] errorParameters = actualVariablesGeneralizationException.getErrorParameters();
    assertEquals("[empty:empty][empty:empty][empty:empty]", errorParameters[0]);
    assertEquals("[empty:empty][empty:empty][empty:empty]", errorParameters[1]);
    assertNull(errorParameters[2]);
    assertEquals(0, actualVariablesGeneralizationException.getSuppressed().length);
    assertEquals(1010, actualVariablesGeneralizationException.getComponentErrorId());
    assertEquals(3, errorParameters.length);
    assertSame(cause, actualVariablesGeneralizationException.getCause());
    assertSame(first, actualVariablesGeneralizationException.getFirst());
    assertSame(second, actualVariablesGeneralizationException.getSecond());
  }
}
