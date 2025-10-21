package proguard.evaluation.exception;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class VariableIndexOutOfBoundExceptionDiffblueTest {
  /**
   * Test {@link VariableIndexOutOfBoundException#VariableIndexOutOfBoundException(int, int)}.
   *
   * <p>Method under test: {@link
   * VariableIndexOutOfBoundException#VariableIndexOutOfBoundException(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VariableIndexOutOfBoundException.<init>(int, int)"})
  public void testNewVariableIndexOutOfBoundException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int VariableIndexOutOfBoundException.getBound()"})
  public void testGetBound() {
    // Arrange, Act and Assert
    assertEquals(1, (new VariableIndexOutOfBoundException(1, 1)).getBound());
  }
}
