package proguard.classfile.instruction;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TableSwitchInstructionDiffblueTest {
  /**
   * Method under test:
   * {@link TableSwitchInstruction#copy(TableSwitchInstruction)}
   */
  @Test
  public void testCopy() {
    // Arrange
    TableSwitchInstruction tableSwitchInstruction = new TableSwitchInstruction();

    // Act and Assert
    assertSame(tableSwitchInstruction, tableSwitchInstruction.copy(new TableSwitchInstruction()));
  }

  /**
   * Method under test: {@link TableSwitchInstruction#shrink()}
   */
  @Test
  public void testShrink() {
    // Arrange
    TableSwitchInstruction tableSwitchInstruction = new TableSwitchInstruction();

    // Act and Assert
    assertSame(tableSwitchInstruction, tableSwitchInstruction.shrink());
  }

  /**
   * Method under test: {@link TableSwitchInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo() {
    // Arrange
    byte[] code = new byte[]{'A', Instruction.OP_ICONST_0, 'A', Instruction.OP_ICONST_0, 'A', Instruction.OP_ICONST_0,
        'A', Instruction.OP_ICONST_0, 'A', Instruction.OP_ICONST_0, 'A', Instruction.OP_ICONST_0, 'A',
        Instruction.OP_ICONST_0, 'A', Instruction.OP_ICONST_0};

    // Act
    (new TableSwitchInstruction((byte) 'A', 3, 255, 3, new int[]{3, 2, 3, 2})).writeInfo(code, 2);

    // Assert
    assertEquals((byte) -1, code[11]);
    assertEquals(Short.SIZE, code.length);
    assertEquals(Instruction.OP_NOP, code[10]);
    assertEquals(Instruction.OP_NOP, code[12]);
    assertEquals(Instruction.OP_NOP, code[13]);
    assertEquals(Instruction.OP_NOP, code[14]);
    assertEquals(Instruction.OP_NOP, code[2]);
    assertEquals(Instruction.OP_NOP, code[3]);
    assertEquals(Instruction.OP_NOP, code[4]);
    assertEquals(Instruction.OP_NOP, code[5]);
    assertEquals(Instruction.OP_NOP, code[6]);
    assertEquals(Instruction.OP_NOP, code[8]);
    assertEquals(Instruction.OP_NOP, code[9]);
  }

  /**
   * Method under test: {@link TableSwitchInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo2() {
    // Arrange
    byte[] code = new byte[]{'A', Instruction.OP_ICONST_0, 'A', Instruction.OP_ICONST_0, 'A', Instruction.OP_ICONST_0,
        'A', Instruction.OP_ICONST_0, 'A', Instruction.OP_ICONST_0, 'A', Instruction.OP_ICONST_0, 'A',
        Instruction.OP_ICONST_0, 'A', Instruction.OP_ICONST_0, 'A', Instruction.OP_ICONST_0, 'A',
        Instruction.OP_ICONST_0, 'A', Instruction.OP_ICONST_0, 'A', Instruction.OP_ICONST_0};

    // Act
    (new TableSwitchInstruction((byte) 'A', 3, 3, 3, new int[]{3, 2, 3, 2})).writeInfo(code, 2);

    // Assert
    assertEquals(24, code.length);
    assertEquals(Instruction.OP_NOP, code[10]);
    assertEquals(Instruction.OP_NOP, code[12]);
    assertEquals(Instruction.OP_NOP, code[13]);
    assertEquals(Instruction.OP_NOP, code[14]);
    assertEquals(Instruction.OP_NOP, code[17]);
    assertEquals(Instruction.OP_NOP, code[18]);
    assertEquals(Instruction.OP_NOP, code[2]);
    assertEquals(Instruction.OP_NOP, code[3]);
    assertEquals(Instruction.OP_NOP, code[4]);
    assertEquals(Instruction.OP_NOP, code[5]);
    assertEquals(Instruction.OP_NOP, code[6]);
    assertEquals(Instruction.OP_NOP, code[8]);
    assertEquals(Instruction.OP_NOP, code[9]);
    assertEquals(Instruction.OP_NOP, code[Short.SIZE]);
  }

  /**
   * Method under test: {@link TableSwitchInstruction#length(int)}
   */
  @Test
  public void testLength() {
    // Arrange, Act and Assert
    assertEquals(18, (new TableSwitchInstruction()).length(2));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TableSwitchInstruction#equals(Object)}
   *   <li>{@link TableSwitchInstruction#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TableSwitchInstruction tableSwitchInstruction = new TableSwitchInstruction();
    TableSwitchInstruction tableSwitchInstruction2 = new TableSwitchInstruction();

    // Act and Assert
    assertEquals(tableSwitchInstruction, tableSwitchInstruction2);
    int expectedHashCodeResult = tableSwitchInstruction.hashCode();
    assertEquals(expectedHashCodeResult, tableSwitchInstruction2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TableSwitchInstruction#equals(Object)}
   *   <li>{@link TableSwitchInstruction#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TableSwitchInstruction tableSwitchInstruction = new TableSwitchInstruction();

    // Act and Assert
    assertEquals(tableSwitchInstruction, tableSwitchInstruction);
    int expectedHashCodeResult = tableSwitchInstruction.hashCode();
    assertEquals(expectedHashCodeResult, tableSwitchInstruction.hashCode());
  }

  /**
   * Method under test: {@link TableSwitchInstruction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TableSwitchInstruction tableSwitchInstruction = new TableSwitchInstruction((byte) 'A', 1, 1, 1,
        new int[]{1, 0, 1, 0});

    // Act and Assert
    assertNotEquals(tableSwitchInstruction, new TableSwitchInstruction());
  }

  /**
   * Method under test: {@link TableSwitchInstruction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TableSwitchInstruction(), null);
  }

  /**
   * Method under test: {@link TableSwitchInstruction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TableSwitchInstruction(), "Different type to TableSwitchInstruction");
  }

  /**
   * Method under test: {@link TableSwitchInstruction#TableSwitchInstruction()}
   */
  @Test
  public void testNewTableSwitchInstruction() {
    // Arrange and Act
    TableSwitchInstruction actualTableSwitchInstruction = new TableSwitchInstruction();

    // Assert
    assertEquals("nop", actualTableSwitchInstruction.getName());
    assertNull(actualTableSwitchInstruction.jumpOffsets);
    assertEquals(0, actualTableSwitchInstruction.defaultOffset);
    assertEquals(0, actualTableSwitchInstruction.highCase);
    assertEquals(0, actualTableSwitchInstruction.lowCase);
    assertFalse(actualTableSwitchInstruction.isCategory2());
    assertFalse(actualTableSwitchInstruction.isWide());
    assertEquals(Instruction.OP_NOP, actualTableSwitchInstruction.opcode);
  }

  /**
   * Method under test:
   * {@link TableSwitchInstruction#TableSwitchInstruction(byte, int, int, int, int[])}
   */
  @Test
  public void testNewTableSwitchInstruction2() {
    // Arrange and Act
    TableSwitchInstruction actualTableSwitchInstruction = new TableSwitchInstruction((byte) 'A', 1, 1, 1,
        new int[]{1, 0, 1, 0});

    // Assert
    assertEquals("lstore_2", actualTableSwitchInstruction.getName());
    assertEquals(1, actualTableSwitchInstruction.defaultOffset);
    assertEquals(1, actualTableSwitchInstruction.highCase);
    assertEquals(1, actualTableSwitchInstruction.lowCase);
    assertFalse(actualTableSwitchInstruction.isWide());
    assertTrue(actualTableSwitchInstruction.isCategory2());
    assertEquals('A', actualTableSwitchInstruction.opcode);
    assertArrayEquals(new int[]{1, 0, 1, 0}, actualTableSwitchInstruction.jumpOffsets);
  }
}
