package proguard.evaluation.exception;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class VariableEmptySlotExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link VariableEmptySlotException#VariableEmptySlotException(int)}
   */
  @Test
  public void testNewVariableEmptySlotException() {
    // Arrange and Act
    VariableEmptySlotException actualVariableEmptySlotException = new VariableEmptySlotException(1);

    // Assert
    Object[] errorParameters = actualVariableEmptySlotException.getErrorParameters();
    assertTrue(errorParameters instanceof String[]);
    assertEquals("Value in slot 1 is empty", actualVariableEmptySlotException.getLocalizedMessage());
    assertEquals("Value in slot 1 is empty", actualVariableEmptySlotException.getMessage());
    assertNull(actualVariableEmptySlotException.getCause());
    assertEquals(0, actualVariableEmptySlotException.getSuppressed().length);
    assertEquals(1, actualVariableEmptySlotException.getIndex());
    assertEquals(1000, actualVariableEmptySlotException.getComponentErrorId());
    assertArrayEquals(new String[]{"1"}, errorParameters);
  }
}
