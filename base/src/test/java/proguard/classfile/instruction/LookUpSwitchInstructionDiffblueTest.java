package proguard.classfile.instruction;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class LookUpSwitchInstructionDiffblueTest {
  /**
   * Method under test:
   * {@link LookUpSwitchInstruction#copy(LookUpSwitchInstruction)}
   */
  @Test
  public void testCopy() {
    // Arrange
    LookUpSwitchInstruction lookUpSwitchInstruction = new LookUpSwitchInstruction();

    // Act and Assert
    assertSame(lookUpSwitchInstruction, lookUpSwitchInstruction.copy(new LookUpSwitchInstruction()));
  }

  /**
   * Method under test: {@link LookUpSwitchInstruction#shrink()}
   */
  @Test
  public void testShrink() {
    // Arrange
    LookUpSwitchInstruction lookUpSwitchInstruction = new LookUpSwitchInstruction();

    // Act and Assert
    assertSame(lookUpSwitchInstruction, lookUpSwitchInstruction.shrink());
  }

  /**
   * Method under test: {@link LookUpSwitchInstruction#length(int)}
   */
  @Test
  public void testLength() {
    // Arrange, Act and Assert
    assertEquals(42,
        (new LookUpSwitchInstruction((byte) 'A', 1, new int[]{1, 3, 1, 3}, new int[]{1, 3, 1, 3})).length(2));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LookUpSwitchInstruction#equals(Object)}
   *   <li>{@link LookUpSwitchInstruction#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LookUpSwitchInstruction lookUpSwitchInstruction = new LookUpSwitchInstruction();
    LookUpSwitchInstruction lookUpSwitchInstruction2 = new LookUpSwitchInstruction();

    // Act and Assert
    assertEquals(lookUpSwitchInstruction, lookUpSwitchInstruction2);
    int expectedHashCodeResult = lookUpSwitchInstruction.hashCode();
    assertEquals(expectedHashCodeResult, lookUpSwitchInstruction2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LookUpSwitchInstruction#equals(Object)}
   *   <li>{@link LookUpSwitchInstruction#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LookUpSwitchInstruction lookUpSwitchInstruction = new LookUpSwitchInstruction();

    // Act and Assert
    assertEquals(lookUpSwitchInstruction, lookUpSwitchInstruction);
    int expectedHashCodeResult = lookUpSwitchInstruction.hashCode();
    assertEquals(expectedHashCodeResult, lookUpSwitchInstruction.hashCode());
  }

  /**
   * Method under test: {@link LookUpSwitchInstruction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LookUpSwitchInstruction lookUpSwitchInstruction = new LookUpSwitchInstruction((byte) 'A', 1, new int[]{1, 0, 1, 0},
        new int[]{1, 0, 1, 0});

    // Act and Assert
    assertNotEquals(lookUpSwitchInstruction, new LookUpSwitchInstruction());
  }

  /**
   * Method under test: {@link LookUpSwitchInstruction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LookUpSwitchInstruction(), null);
  }

  /**
   * Method under test: {@link LookUpSwitchInstruction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LookUpSwitchInstruction(), "Different type to LookUpSwitchInstruction");
  }

  /**
   * Method under test: {@link LookUpSwitchInstruction#LookUpSwitchInstruction()}
   */
  @Test
  public void testNewLookUpSwitchInstruction() {
    // Arrange and Act
    LookUpSwitchInstruction actualLookUpSwitchInstruction = new LookUpSwitchInstruction();

    // Assert
    assertEquals("nop", actualLookUpSwitchInstruction.getName());
    assertNull(actualLookUpSwitchInstruction.cases);
    assertNull(actualLookUpSwitchInstruction.jumpOffsets);
    assertEquals(0, actualLookUpSwitchInstruction.defaultOffset);
    assertFalse(actualLookUpSwitchInstruction.isCategory2());
    assertFalse(actualLookUpSwitchInstruction.isWide());
    assertEquals(Instruction.OP_NOP, actualLookUpSwitchInstruction.opcode);
  }

  /**
   * Method under test:
   * {@link LookUpSwitchInstruction#LookUpSwitchInstruction(byte, int, int[], int[])}
   */
  @Test
  public void testNewLookUpSwitchInstruction2() {
    // Arrange and Act
    LookUpSwitchInstruction actualLookUpSwitchInstruction = new LookUpSwitchInstruction((byte) 'A', 1,
        new int[]{1, 0, 1, 0}, new int[]{1, 0, 1, 0});

    // Assert
    assertEquals("lstore_2", actualLookUpSwitchInstruction.getName());
    assertEquals(1, actualLookUpSwitchInstruction.defaultOffset);
    assertFalse(actualLookUpSwitchInstruction.isWide());
    assertTrue(actualLookUpSwitchInstruction.isCategory2());
    assertEquals('A', actualLookUpSwitchInstruction.opcode);
    assertArrayEquals(new int[]{1, 0, 1, 0}, actualLookUpSwitchInstruction.cases);
    assertArrayEquals(new int[]{1, 0, 1, 0}, actualLookUpSwitchInstruction.jumpOffsets);
  }
}
