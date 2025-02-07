package proguard.classfile.instruction;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.instruction.visitor.InstructionConstantVisitor;
import proguard.classfile.instruction.visitor.InstructionVisitor;

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.TableSwitchInstruction.<init>()",
    "void proguard.classfile.instruction.TableSwitchInstruction.<init>(byte, int, int, int, int[])"
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.TableSwitchInstruction.<init>()",
    "void proguard.classfile.instruction.TableSwitchInstruction.<init>(byte, int, int, int, int[])"
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.instruction.TableSwitchInstruction proguard.classfile.instruction.TableSwitchInstruction.copy(proguard.classfile.instruction.TableSwitchInstruction)"
  })
  void testCopyWithTableSwitchInstruction_thenReturnTableSwitchInstruction() {
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
  @DisplayName("Test shrink()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.instruction.Instruction proguard.classfile.instruction.TableSwitchInstruction.shrink()"
  })
  void testShrink() {
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
  @DisplayName(
      "Test readInfo(byte[], int); when 'A'; then TableSwitchInstruction() defaultOffset is '1090732291'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.TableSwitchInstruction.readInfo(byte[], int)"
  })
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
   * <p>Method under test: {@link TableSwitchInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName("Test writeInfo(byte[], int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.TableSwitchInstruction.writeInfo(byte[], int)"
  })
  void testWriteInfo() {
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
  @DisplayName("Test writeInfo(byte[], int); then array of byte with 'A' and OP_ICONST_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.TableSwitchInstruction.writeInfo(byte[], int)"
  })
  void testWriteInfo_thenArrayOfByteWithAAndOp_iconst_0() {
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
  @DisplayName("Test length(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.instruction.TableSwitchInstruction.length(int)"})
  void testLength() {
    // Arrange, Act and Assert
    assertEquals(18, (new TableSwitchInstruction()).length(2));
  }

  /**
   * Test {@link TableSwitchInstruction#accept(Clazz, Method, CodeAttribute, int,
   * InstructionVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link InstructionVisitor#visitTableSwitchInstruction(Clazz, Method,
   *       CodeAttribute, int, TableSwitchInstruction)}.
   * </ul>
   *
   * <p>Method under test: {@link TableSwitchInstruction#accept(Clazz, Method, CodeAttribute, int,
   * InstructionVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, CodeAttribute, int, InstructionVisitor); then calls visitTableSwitchInstruction(Clazz, Method, CodeAttribute, int, TableSwitchInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.TableSwitchInstruction.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.visitor.InstructionVisitor)"
  })
  void testAccept_thenCallsVisitTableSwitchInstruction() {
    // Arrange
    TableSwitchInstruction tableSwitchInstruction = new TableSwitchInstruction();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    InstructionConstantVisitor instructionVisitor = mock(InstructionConstantVisitor.class);
    doNothing()
        .when(instructionVisitor)
        .visitTableSwitchInstruction(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            Mockito.<TableSwitchInstruction>any());

    // Act
    tableSwitchInstruction.accept(clazz, method, codeAttribute, 2, instructionVisitor);

    // Assert
    verify(instructionVisitor)
        .visitTableSwitchInstruction(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(2),
            isA(TableSwitchInstruction.class));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.instruction.TableSwitchInstruction.equals(java.lang.Object)",
    "int proguard.classfile.instruction.TableSwitchInstruction.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.instruction.TableSwitchInstruction.equals(java.lang.Object)",
    "int proguard.classfile.instruction.TableSwitchInstruction.hashCode()"
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.instruction.TableSwitchInstruction.equals(java.lang.Object)",
    "int proguard.classfile.instruction.TableSwitchInstruction.hashCode()"
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
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TableSwitchInstruction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.instruction.TableSwitchInstruction.equals(java.lang.Object)",
    "int proguard.classfile.instruction.TableSwitchInstruction.hashCode()"
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.instruction.TableSwitchInstruction.equals(java.lang.Object)",
    "int proguard.classfile.instruction.TableSwitchInstruction.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TableSwitchInstruction(), "Different type to TableSwitchInstruction");
  }
}
