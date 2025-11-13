package proguard.evaluation.exception;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VariableEmptySlotExceptionDiffblueTest {
  /**
   * Test {@link VariableEmptySlotException#VariableEmptySlotException(int)}.
   *
   * <p>Method under test: {@link VariableEmptySlotException#VariableEmptySlotException(int)}
   */
  @Test
  @DisplayName("Test new VariableEmptySlotException(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableEmptySlotException.<init>(int)"})
  void testNewVariableEmptySlotException() {
    // Arrange and Act
    VariableEmptySlotException actualVariableEmptySlotException = new VariableEmptySlotException(1);

    // Assert
    Object[] errorParameters = actualVariableEmptySlotException.getErrorParameters();
    assertTrue(errorParameters instanceof String[]);
    assertEquals(
        "Value in slot 1 is empty", actualVariableEmptySlotException.getLocalizedMessage());
    assertEquals("Value in slot 1 is empty", actualVariableEmptySlotException.getMessage());
    assertNull(actualVariableEmptySlotException.getCause());
    assertEquals(0, actualVariableEmptySlotException.getSuppressed().length);
    assertEquals(1, actualVariableEmptySlotException.getIndex());
    assertEquals(1000, actualVariableEmptySlotException.getComponentErrorId());
    assertArrayEquals(new String[] {"1"}, errorParameters);
  }
}
