package proguard.evaluation.exception;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class VariableIndexOutOfBoundExceptionDiffblueTest {
  /**
   * Method under test: {@link VariableIndexOutOfBoundException#getBound()}
   */
  @Test
  public void testGetBound() {
    // Arrange, Act and Assert
    assertEquals(1, (new VariableIndexOutOfBoundException(1, 1)).getBound());
  }

  /**
   * Method under test:
   * {@link VariableIndexOutOfBoundException#VariableIndexOutOfBoundException(int, int)}
   */
  @Test
  public void testNewVariableIndexOutOfBoundException() {
    // Arrange and Act
    VariableIndexOutOfBoundException actualVariableIndexOutOfBoundException = new VariableIndexOutOfBoundException(1,
        1);

    // Assert
    Object[] errorParameters = actualVariableIndexOutOfBoundException.getErrorParameters();
    assertTrue(errorParameters instanceof String[]);
    assertEquals("Variable index [1] out of bounds. There are 1 variables in this code attribute.",
        actualVariableIndexOutOfBoundException.getLocalizedMessage());
    assertEquals("Variable index [1] out of bounds. There are 1 variables in this code attribute.",
        actualVariableIndexOutOfBoundException.getMessage());
    assertNull(actualVariableIndexOutOfBoundException.getCause());
    assertEquals(0, actualVariableIndexOutOfBoundException.getSuppressed().length);
    assertEquals(1, actualVariableIndexOutOfBoundException.getIndex());
    assertEquals(1, actualVariableIndexOutOfBoundException.getBound());
    assertEquals(1001, actualVariableIndexOutOfBoundException.getComponentErrorId());
    assertArrayEquals(new String[]{"1", "1"}, errorParameters);
  }
}
