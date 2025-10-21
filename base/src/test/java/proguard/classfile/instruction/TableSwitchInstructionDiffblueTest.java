package proguard.classfile.instruction;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TableSwitchInstructionDiffblueTest {
  /**
   * Test {@link TableSwitchInstruction#TableSwitchInstruction()}.
   *
   * <ul>
   *   <li>Then return Name is {@code nop}.
   * </ul>
   *
   * <p>Method under test: {@link TableSwitchInstruction#TableSwitchInstruction()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TableSwitchInstruction.<init>()",
    "void TableSwitchInstruction.<init>(byte, int, int, int, int[])"
  })
  public void testNewTableSwitchInstruction_thenReturnNameIsNop() {
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
   * Test {@link TableSwitchInstruction#TableSwitchInstruction(byte, int, int, int, int[])}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Name is {@code lstore_2}.
   * </ul>
   *
   * <p>Method under test: {@link TableSwitchInstruction#TableSwitchInstruction(byte, int, int, int,
   * int[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TableSwitchInstruction.<init>()",
    "void TableSwitchInstruction.<init>(byte, int, int, int, int[])"
  })
  public void testNewTableSwitchInstruction_whenA_thenReturnNameIsLstore2() {
    // Arrange and Act
    TableSwitchInstruction actualTableSwitchInstruction =
        new TableSwitchInstruction((byte) 'A', 1, 1, 1, new int[] {1, 0, 1, 0});

    // Assert
    assertEquals("lstore_2", actualTableSwitchInstruction.getName());
    assertEquals(1, actualTableSwitchInstruction.defaultOffset);
    assertEquals(1, actualTableSwitchInstruction.highCase);
    assertEquals(1, actualTableSwitchInstruction.lowCase);
    assertFalse(actualTableSwitchInstruction.isWide());
    assertTrue(actualTableSwitchInstruction.isCategory2());
    assertEquals('A', actualTableSwitchInstruction.opcode);
    assertArrayEquals(new int[] {1, 0, 1, 0}, actualTableSwitchInstruction.jumpOffsets);
  }

  /**
   * Test {@link TableSwitchInstruction#copy(TableSwitchInstruction)} with {@code
   * tableSwitchInstruction}.
   *
   * <ul>
   *   <li>Then return {@link TableSwitchInstruction#TableSwitchInstruction()}.
   * </ul>
   *
   * <p>Method under test: {@link TableSwitchInstruction#copy(TableSwitchInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TableSwitchInstruction TableSwitchInstruction.copy(TableSwitchInstruction)"})
  public void testCopyWithTableSwitchInstruction_thenReturnTableSwitchInstruction() {
    // Arrange
    TableSwitchInstruction tableSwitchInstruction = new TableSwitchInstruction();

    // Act and Assert
    assertSame(tableSwitchInstruction, tableSwitchInstruction.copy(new TableSwitchInstruction()));
  }

  /**
   * Test {@link TableSwitchInstruction#shrink()}.
   *
   * <p>Method under test: {@link TableSwitchInstruction#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction TableSwitchInstruction.shrink()"})
  public void testShrink() {
    // Arrange
    TableSwitchInstruction tableSwitchInstruction = new TableSwitchInstruction();

    // Act and Assert
    assertSame(tableSwitchInstruction, tableSwitchInstruction.shrink());
  }

  /**
   * Test {@link TableSwitchInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then {@link TableSwitchInstruction#TableSwitchInstruction()} {@link
   *       SwitchInstruction#defaultOffset} is {@code 1090732291}.
   * </ul>
   *
   * <p>Method under test: {@link TableSwitchInstruction#readInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TableSwitchInstruction.readInfo(byte[], int)"})
  public void testReadInfo_whenA_thenTableSwitchInstructionDefaultOffsetIs1090732291() {
    // Arrange
    TableSwitchInstruction tableSwitchInstruction = new TableSwitchInstruction();

    // Act
    tableSwitchInstruction.readInfo(
        new byte[] {
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0
        },
        2);

    // Assert
    assertEquals(1090732291, tableSwitchInstruction.defaultOffset);
    assertEquals(1090732291, tableSwitchInstruction.highCase);
    assertEquals(1090732291, tableSwitchInstruction.lowCase);
    assertArrayEquals(new int[] {1090732291}, tableSwitchInstruction.jumpOffsets);
  }

  /**
   * Test {@link TableSwitchInstruction#writeInfo(byte[], int)}.
   *
   * <p>Method under test: {@link TableSwitchInstruction#writeInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TableSwitchInstruction.writeInfo(byte[], int)"})
  public void testWriteInfo() {
    // Arrange
    byte[] code =
        new byte[] {
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0
        };

    // Act
    (new TableSwitchInstruction((byte) 'A', 3, 255, 3, new int[] {3, 2, 3, 2})).writeInfo(code, 2);

    // Assert
    assertArrayEquals(
        new byte[] {
          'A',
          Instruction.OP_ICONST_0,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          Instruction.OP_ICONST_0,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          -1,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          Instruction.OP_ICONST_0
        },
        code);
  }

  /**
   * Test {@link TableSwitchInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then array of {@code byte} with {@code A} and {@link Instruction#OP_ICONST_0}.
   * </ul>
   *
   * <p>Method under test: {@link TableSwitchInstruction#writeInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TableSwitchInstruction.writeInfo(byte[], int)"})
  public void testWriteInfo_thenArrayOfByteWithAAndOp_iconst_0() {
    // Arrange
    byte[] code =
        new byte[] {
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0
        };

    // Act
    (new TableSwitchInstruction((byte) 'A', 3, 3, 3, new int[] {3, 2, 3, 2})).writeInfo(code, 2);

    // Assert
    assertArrayEquals(
        new byte[] {
          'A',
          Instruction.OP_ICONST_0,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          Instruction.OP_ICONST_0,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          Instruction.OP_ICONST_0,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          Instruction.OP_ICONST_0,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0
        },
        code);
  }

  /**
   * Test {@link TableSwitchInstruction#length(int)}.
   *
   * <p>Method under test: {@link TableSwitchInstruction#length(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TableSwitchInstruction.length(int)"})
  public void testLength() {
    // Arrange, Act and Assert
    assertEquals(18, (new TableSwitchInstruction()).length(2));
  }

  /**
   * Test {@link TableSwitchInstruction#equals(Object)}, and {@link
   * TableSwitchInstruction#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TableSwitchInstruction#equals(Object)}
   *   <li>{@link TableSwitchInstruction#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TableSwitchInstruction.equals(Object)",
    "int TableSwitchInstruction.hashCode()"
  })
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
   * Test {@link TableSwitchInstruction#equals(Object)}, and {@link
   * TableSwitchInstruction#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TableSwitchInstruction#equals(Object)}
   *   <li>{@link TableSwitchInstruction#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TableSwitchInstruction.equals(Object)",
    "int TableSwitchInstruction.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TableSwitchInstruction tableSwitchInstruction = new TableSwitchInstruction();

    // Act and Assert
    assertEquals(tableSwitchInstruction, tableSwitchInstruction);
    int expectedHashCodeResult = tableSwitchInstruction.hashCode();
    assertEquals(expectedHashCodeResult, tableSwitchInstruction.hashCode());
  }

  /**
   * Test {@link TableSwitchInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TableSwitchInstruction#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TableSwitchInstruction.equals(Object)",
    "int TableSwitchInstruction.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TableSwitchInstruction tableSwitchInstruction =
        new TableSwitchInstruction((byte) 'A', 1, 1, 1, new int[] {1, 0, 1, 0});

    // Act and Assert
    assertNotEquals(tableSwitchInstruction, new TableSwitchInstruction());
  }

  /**
   * Test {@link TableSwitchInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TableSwitchInstruction#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TableSwitchInstruction.equals(Object)",
    "int TableSwitchInstruction.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TableSwitchInstruction(), null);
  }

  /**
   * Test {@link TableSwitchInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TableSwitchInstruction#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TableSwitchInstruction.equals(Object)",
    "int TableSwitchInstruction.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TableSwitchInstruction(), "Different type to TableSwitchInstruction");
  }
}
