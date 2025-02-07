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

class LookUpSwitchInstructionDiffblueTest {
  /**
   * Test {@link LookUpSwitchInstruction#LookUpSwitchInstruction()}.
   *
   * <ul>
   *   <li>Then return Name is {@code nop}.
   * </ul>
   *
   * <p>Method under test: {@link LookUpSwitchInstruction#LookUpSwitchInstruction()}
   */
  @Test
  @DisplayName("Test new LookUpSwitchInstruction(); then return Name is 'nop'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.LookUpSwitchInstruction.<init>()",
    "void proguard.classfile.instruction.LookUpSwitchInstruction.<init>(byte, int, int[], int[])"
  })
  void testNewLookUpSwitchInstruction_thenReturnNameIsNop() {
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
   * Test {@link LookUpSwitchInstruction#LookUpSwitchInstruction(byte, int, int[], int[])}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Name is {@code lstore_2}.
   * </ul>
   *
   * <p>Method under test: {@link LookUpSwitchInstruction#LookUpSwitchInstruction(byte, int, int[],
   * int[])}
   */
  @Test
  @DisplayName(
      "Test new LookUpSwitchInstruction(byte, int, int[], int[]); when 'A'; then return Name is 'lstore_2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.LookUpSwitchInstruction.<init>()",
    "void proguard.classfile.instruction.LookUpSwitchInstruction.<init>(byte, int, int[], int[])"
  })
  void testNewLookUpSwitchInstruction_whenA_thenReturnNameIsLstore2() {
    // Arrange and Act
    LookUpSwitchInstruction actualLookUpSwitchInstruction =
        new LookUpSwitchInstruction((byte) 'A', 1, new int[] {1, 0, 1, 0}, new int[] {1, 0, 1, 0});

    // Assert
    assertEquals("lstore_2", actualLookUpSwitchInstruction.getName());
    assertEquals(1, actualLookUpSwitchInstruction.defaultOffset);
    assertFalse(actualLookUpSwitchInstruction.isWide());
    assertTrue(actualLookUpSwitchInstruction.isCategory2());
    assertEquals('A', actualLookUpSwitchInstruction.opcode);
    assertArrayEquals(new int[] {1, 0, 1, 0}, actualLookUpSwitchInstruction.cases);
    assertArrayEquals(new int[] {1, 0, 1, 0}, actualLookUpSwitchInstruction.jumpOffsets);
  }

  /**
   * Test {@link LookUpSwitchInstruction#copy(LookUpSwitchInstruction)} with {@code
   * lookUpSwitchInstruction}.
   *
   * <ul>
   *   <li>Then return {@link LookUpSwitchInstruction#LookUpSwitchInstruction()}.
   * </ul>
   *
   * <p>Method under test: {@link LookUpSwitchInstruction#copy(LookUpSwitchInstruction)}
   */
  @Test
  @DisplayName(
      "Test copy(LookUpSwitchInstruction) with 'lookUpSwitchInstruction'; then return LookUpSwitchInstruction()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.instruction.LookUpSwitchInstruction proguard.classfile.instruction.LookUpSwitchInstruction.copy(proguard.classfile.instruction.LookUpSwitchInstruction)"
  })
  void testCopyWithLookUpSwitchInstruction_thenReturnLookUpSwitchInstruction() {
    // Arrange
    LookUpSwitchInstruction lookUpSwitchInstruction = new LookUpSwitchInstruction();

    // Act and Assert
    assertSame(
        lookUpSwitchInstruction, lookUpSwitchInstruction.copy(new LookUpSwitchInstruction()));
  }

  /**
   * Test {@link LookUpSwitchInstruction#shrink()}.
   *
   * <p>Method under test: {@link LookUpSwitchInstruction#shrink()}
   */
  @Test
  @DisplayName("Test shrink()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.instruction.Instruction proguard.classfile.instruction.LookUpSwitchInstruction.shrink()"
  })
  void testShrink() {
    // Arrange
    LookUpSwitchInstruction lookUpSwitchInstruction = new LookUpSwitchInstruction();

    // Act and Assert
    assertSame(lookUpSwitchInstruction, lookUpSwitchInstruction.shrink());
  }

  /**
   * Test {@link LookUpSwitchInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then array of {@code byte} with {@code A} and {@link Instruction#OP_ICONST_0}.
   * </ul>
   *
   * <p>Method under test: {@link LookUpSwitchInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName("Test writeInfo(byte[], int); then array of byte with 'A' and OP_ICONST_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.LookUpSwitchInstruction.writeInfo(byte[], int)"
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
          Instruction.OP_ICONST_0
        };

    // Act
    (new LookUpSwitchInstruction((byte) 'A', 3, new int[] {}, new int[] {3, 2, 3, 2}))
        .writeInfo(code, 2);

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
          Instruction.OP_NOP,
          'A',
          Instruction.OP_ICONST_0,
          'A',
          Instruction.OP_ICONST_0
        },
        code);
  }

  /**
   * Test {@link LookUpSwitchInstruction#length(int)}.
   *
   * <ul>
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link LookUpSwitchInstruction#length(int)}
   */
  @Test
  @DisplayName("Test length(int); then return forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.instruction.LookUpSwitchInstruction.length(int)"})
  void testLength_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(
        42,
        (new LookUpSwitchInstruction((byte) 'A', 1, new int[] {1, 3, 1, 3}, new int[] {1, 3, 1, 3}))
            .length(2));
  }

  /**
   * Test {@link LookUpSwitchInstruction#accept(Clazz, Method, CodeAttribute, int,
   * InstructionVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link InstructionVisitor#visitLookUpSwitchInstruction(Clazz, Method,
   *       CodeAttribute, int, LookUpSwitchInstruction)}.
   * </ul>
   *
   * <p>Method under test: {@link LookUpSwitchInstruction#accept(Clazz, Method, CodeAttribute, int,
   * InstructionVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, CodeAttribute, int, InstructionVisitor); then calls visitLookUpSwitchInstruction(Clazz, Method, CodeAttribute, int, LookUpSwitchInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.LookUpSwitchInstruction.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.visitor.InstructionVisitor)"
  })
  void testAccept_thenCallsVisitLookUpSwitchInstruction() {
    // Arrange
    LookUpSwitchInstruction lookUpSwitchInstruction = new LookUpSwitchInstruction();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    InstructionConstantVisitor instructionVisitor = mock(InstructionConstantVisitor.class);
    doNothing()
        .when(instructionVisitor)
        .visitLookUpSwitchInstruction(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            Mockito.<LookUpSwitchInstruction>any());

    // Act
    lookUpSwitchInstruction.accept(clazz, method, codeAttribute, 2, instructionVisitor);

    // Assert
    verify(instructionVisitor)
        .visitLookUpSwitchInstruction(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(2),
            isA(LookUpSwitchInstruction.class));
  }

  /**
   * Test {@link LookUpSwitchInstruction#equals(Object)}, and {@link
   * LookUpSwitchInstruction#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LookUpSwitchInstruction#equals(Object)}
   *   <li>{@link LookUpSwitchInstruction#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.instruction.LookUpSwitchInstruction.equals(java.lang.Object)",
    "int proguard.classfile.instruction.LookUpSwitchInstruction.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LookUpSwitchInstruction lookUpSwitchInstruction = new LookUpSwitchInstruction();
    LookUpSwitchInstruction lookUpSwitchInstruction2 = new LookUpSwitchInstruction();

    // Act and Assert
    assertEquals(lookUpSwitchInstruction, lookUpSwitchInstruction2);
    int expectedHashCodeResult = lookUpSwitchInstruction.hashCode();
    assertEquals(expectedHashCodeResult, lookUpSwitchInstruction2.hashCode());
  }

  /**
   * Test {@link LookUpSwitchInstruction#equals(Object)}, and {@link
   * LookUpSwitchInstruction#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LookUpSwitchInstruction#equals(Object)}
   *   <li>{@link LookUpSwitchInstruction#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.instruction.LookUpSwitchInstruction.equals(java.lang.Object)",
    "int proguard.classfile.instruction.LookUpSwitchInstruction.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LookUpSwitchInstruction lookUpSwitchInstruction = new LookUpSwitchInstruction();

    // Act and Assert
    assertEquals(lookUpSwitchInstruction, lookUpSwitchInstruction);
    int expectedHashCodeResult = lookUpSwitchInstruction.hashCode();
    assertEquals(expectedHashCodeResult, lookUpSwitchInstruction.hashCode());
  }

  /**
   * Test {@link LookUpSwitchInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LookUpSwitchInstruction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.instruction.LookUpSwitchInstruction.equals(java.lang.Object)",
    "int proguard.classfile.instruction.LookUpSwitchInstruction.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LookUpSwitchInstruction lookUpSwitchInstruction =
        new LookUpSwitchInstruction((byte) 'A', 1, new int[] {1, 0, 1, 0}, new int[] {1, 0, 1, 0});

    // Act and Assert
    assertNotEquals(lookUpSwitchInstruction, new LookUpSwitchInstruction());
  }

  /**
   * Test {@link LookUpSwitchInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LookUpSwitchInstruction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.instruction.LookUpSwitchInstruction.equals(java.lang.Object)",
    "int proguard.classfile.instruction.LookUpSwitchInstruction.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LookUpSwitchInstruction(), null);
  }

  /**
   * Test {@link LookUpSwitchInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LookUpSwitchInstruction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.instruction.LookUpSwitchInstruction.equals(java.lang.Object)",
    "int proguard.classfile.instruction.LookUpSwitchInstruction.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LookUpSwitchInstruction(), "Different type to LookUpSwitchInstruction");
  }
}
