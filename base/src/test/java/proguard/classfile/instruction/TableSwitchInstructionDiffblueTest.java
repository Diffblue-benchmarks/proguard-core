package proguard.classfile.instruction;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TableSwitchInstructionDiffblueTest {
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
  @DisplayName("Test new TableSwitchInstruction(); then return Name is 'nop'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TableSwitchInstruction.<init>()",
    "void TableSwitchInstruction.<init>(byte, int, int, int, int[])"
  })
  void testNewTableSwitchInstruction_thenReturnNameIsNop() {
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
  @DisplayName(
      "Test new TableSwitchInstruction(byte, int, int, int, int[]); when 'A'; then return Name is 'lstore_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TableSwitchInstruction.<init>()",
    "void TableSwitchInstruction.<init>(byte, int, int, int, int[])"
  })
  void testNewTableSwitchInstruction_whenA_thenReturnNameIsLstore2() {
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
  @DisplayName(
      "Test copy(TableSwitchInstruction) with 'tableSwitchInstruction'; then return TableSwitchInstruction()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TableSwitchInstruction TableSwitchInstruction.copy(TableSwitchInstruction)"})
  void testCopyWithTableSwitchInstruction_thenReturnTableSwitchInstruction() {
    // Arrange
    TableSwitchInstruction tableSwitchInstruction = new TableSwitchInstruction();

    // Act
    TableSwitchInstruction actualCopyResult =
        tableSwitchInstruction.copy(new TableSwitchInstruction());

    // Assert
    assertSame(tableSwitchInstruction, actualCopyResult);
  }

  /**
   * Test {@link TableSwitchInstruction#shrink()}.
   *
   * <p>Method under test: {@link TableSwitchInstruction#shrink()}
   */
  @Test
  @DisplayName("Test shrink()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction TableSwitchInstruction.shrink()"})
  void testShrink() {
    // Arrange
    TableSwitchInstruction tableSwitchInstruction = new TableSwitchInstruction();

    // Act
    Instruction actualShrinkResult = tableSwitchInstruction.shrink();

    // Assert
    assertSame(tableSwitchInstruction, actualShrinkResult);
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
  @DisplayName(
      "Test readInfo(byte[], int); when 'A'; then TableSwitchInstruction() defaultOffset is '1090732291'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableSwitchInstruction.readInfo(byte[], int)"})
  void testReadInfo_whenA_thenTableSwitchInstructionDefaultOffsetIs1090732291() {
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
   * <ul>
   *   <li>Then array of {@code byte} with {@code A} and {@link Instruction#OP_ICONST_0}.
   * </ul>
   *
   * <p>Method under test: {@link TableSwitchInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName("Test writeInfo(byte[], int); then array of byte with 'A' and OP_ICONST_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableSwitchInstruction.writeInfo(byte[], int)"})
  void testWriteInfo_thenArrayOfByteWithAAndOp_iconst_0() {
    // Arrange
    TableSwitchInstruction tableSwitchInstruction =
        new TableSwitchInstruction((byte) 'A', 3, 255, 3, new int[] {3, 2, 3, 2});
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
    tableSwitchInstruction.writeInfo(code, 2);

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
   *   <li>Then array of {@code byte} with {@code A} and {@link Instruction#OP_ICONST_0} is array of
   *       {@code byte} with {@link Instruction#OP_NOP} and {@link Instruction#OP_NOP}.
   * </ul>
   *
   * <p>Method under test: {@link TableSwitchInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test writeInfo(byte[], int); then array of byte with 'A' and OP_ICONST_0 is array of byte with OP_NOP and OP_NOP")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableSwitchInstruction.writeInfo(byte[], int)"})
  void testWriteInfo_thenArrayOfByteWithAAndOp_iconst_0IsArrayOfByteWithOp_nopAndOp_nop() {
    // Arrange
    TableSwitchInstruction tableSwitchInstruction =
        new TableSwitchInstruction((byte) 'A', 3, 3, 3, new int[] {3, 2, 3, 2});
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
    tableSwitchInstruction.writeInfo(code, 0);

    // Assert
    assertArrayEquals(
        new byte[] {
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
  @DisplayName("Test length(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TableSwitchInstruction.length(int)"})
  void testLength() {
    // Arrange, Act and Assert
    assertEquals(18, new TableSwitchInstruction().length(2));
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TableSwitchInstruction.equals(Object)",
    "int TableSwitchInstruction.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TableSwitchInstruction tableSwitchInstruction = new TableSwitchInstruction();
    TableSwitchInstruction tableSwitchInstruction2 = new TableSwitchInstruction();

    // Act and Assert
    assertEquals(tableSwitchInstruction, tableSwitchInstruction2);
    assertEquals(tableSwitchInstruction.hashCode(), tableSwitchInstruction2.hashCode());
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
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TableSwitchInstruction.equals(Object)",
    "int TableSwitchInstruction.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TableSwitchInstruction.equals(Object)",
    "int TableSwitchInstruction.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TableSwitchInstruction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TableSwitchInstruction.equals(Object)",
    "int TableSwitchInstruction.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TableSwitchInstruction tableSwitchInstruction =
        new TableSwitchInstruction((byte) 'A', 1, 0, 1, new int[] {1, 0, 1, 0});

    // Act and Assert
    assertNotEquals(
        tableSwitchInstruction,
        new TableSwitchInstruction((byte) 'A', 1, 1, 1, new int[] {1, 0, 1, 0}));
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TableSwitchInstruction.equals(Object)",
    "int TableSwitchInstruction.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TableSwitchInstruction tableSwitchInstruction =
        new TableSwitchInstruction((byte) 'A', 1, 1, 0, new int[] {1, 0, 1, 0});

    // Act and Assert
    assertNotEquals(
        tableSwitchInstruction,
        new TableSwitchInstruction((byte) 'A', 1, 1, 1, new int[] {1, 0, 1, 0}));
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
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TableSwitchInstruction.equals(Object)",
    "int TableSwitchInstruction.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TableSwitchInstruction.equals(Object)",
    "int TableSwitchInstruction.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TableSwitchInstruction(), "Different type to TableSwitchInstruction");
  }
}
