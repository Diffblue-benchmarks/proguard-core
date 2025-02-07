package proguard.evaluation.exception;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VariableIndexOutOfBoundExceptionDiffblueTest {
  /**
   * Test {@link VariableIndexOutOfBoundException#VariableIndexOutOfBoundException(int, int)}.
   *
   * <p>Method under test: {@link
   * VariableIndexOutOfBoundException#VariableIndexOutOfBoundException(int, int)}
   */
  @Test
  @DisplayName("Test new VariableIndexOutOfBoundException(int, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.exception.VariableIndexOutOfBoundException.<init>(int, int)"
  })
  void testNewVariableIndexOutOfBoundException() {
    // Arrange and Act
    VariableIndexOutOfBoundException actualVariableIndexOutOfBoundException =
        new VariableIndexOutOfBoundException(1, 1);

    // Assert
    Object[] errorParameters = actualVariableIndexOutOfBoundException.getErrorParameters();
    assertTrue(errorParameters instanceof String[]);
    assertEquals(
        "Variable index [1] out of bounds. There are 1 variables in this code attribute.",
        actualVariableIndexOutOfBoundException.getLocalizedMessage());
    assertEquals(
        "Variable index [1] out of bounds. There are 1 variables in this code attribute.",
        actualVariableIndexOutOfBoundException.getMessage());
    assertNull(actualVariableIndexOutOfBoundException.getCause());
    assertEquals(0, actualVariableIndexOutOfBoundException.getSuppressed().length);
    assertEquals(1, actualVariableIndexOutOfBoundException.getIndex());
    assertEquals(1, actualVariableIndexOutOfBoundException.getBound());
    assertEquals(1001, actualVariableIndexOutOfBoundException.getComponentErrorId());
    assertArrayEquals(new String[] {"1", "1"}, errorParameters);
  }

  /**
   * Test {@link VariableIndexOutOfBoundException#getBound()}.
   *
   * <p>Method under test: {@link VariableIndexOutOfBoundException#getBound()}
   */
  @Test
  @DisplayName("Test getBound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.exception.VariableIndexOutOfBoundException.getBound()"
  })
  void testGetBound() {
    // Arrange, Act and Assert
    assertEquals(1, (new VariableIndexOutOfBoundException(1, 1)).getBound());
  }
}
