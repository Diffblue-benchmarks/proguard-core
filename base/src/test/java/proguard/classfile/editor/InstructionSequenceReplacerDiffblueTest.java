package proguard.classfile.editor;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.visitor.MaxStackSizeComputer;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.instruction.visitor.InstructionVisitor;
import proguard.classfile.util.BranchTargetFinder;
import proguard.classfile.util.InstructionSequenceMatcher;

public class InstructionSequenceReplacerDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link InstructionSequenceReplacer.Label#equals(Object)}
   *   <li>{@link InstructionSequenceReplacer.Label#hashCode()}
   * </ul>
   */
  @Test
  public void testLabelEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    InstructionSequenceReplacer.Label labelResult = InstructionSequenceReplacer.label();

    // Act and Assert
    assertEquals(labelResult, labelResult);
    int expectedHashCodeResult = labelResult.hashCode();
    assertEquals(expectedHashCodeResult, labelResult.hashCode());
  }

  /**
   * Method under test: {@link InstructionSequenceReplacer.Label#equals(Object)}
   */
  @Test
  public void testLabelEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    InstructionSequenceReplacer.Label labelResult = InstructionSequenceReplacer.label();

    // Act and Assert
    assertNotEquals(labelResult, InstructionSequenceReplacer.label());
  }

  /**
   * Method under test: {@link InstructionSequenceReplacer.Label#equals(Object)}
   */
  @Test
  public void testLabelEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(InstructionSequenceReplacer.label(), null);
  }

  /**
   * Method under test: {@link InstructionSequenceReplacer.Label#equals(Object)}
   */
  @Test
  public void testLabelEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(InstructionSequenceReplacer.label(), "Different type to Label");
  }

  /**
   * Method under test: {@link InstructionSequenceReplacer.Label#length(int)}
   */
  @Test
  public void testLabelLength() {
    // Arrange, Act and Assert
    assertEquals(0, InstructionSequenceReplacer.label().length(2));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceReplacer.Label#readInfo(byte[], int)}
   */
  @Test
  public void testLabelReadInfo() throws UnsupportedEncodingException {
    // Arrange
    InstructionSequenceReplacer.Label labelResult = InstructionSequenceReplacer.label();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> labelResult.readInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Method under test: {@link InstructionSequenceReplacer.Label#shrink()}
   */
  @Test
  public void testLabelShrink() {
    // Arrange
    InstructionSequenceReplacer.Label labelResult = InstructionSequenceReplacer.label();

    // Act and Assert
    assertSame(labelResult, labelResult.shrink());
  }

  /**
   * Method under test:
   * {@link InstructionSequenceReplacer.Label#writeInfo(byte[], int)}
   */
  @Test
  public void testLabelWriteInfo() throws UnsupportedEncodingException {
    // Arrange
    InstructionSequenceReplacer.Label labelResult = InstructionSequenceReplacer.label();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> labelResult.writeInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Method under test: {@link InstructionSequenceReplacer#matchedArgument(int)}
   */
  @Test
  public void testMatchedArgument() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{new ClassConstant()}, new Instruction[]{new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertEquals(1,
        (new InstructionSequenceReplacer(instructionSequenceMatcher, new Constant[]{new ClassConstant()},
            new Instruction[]{new BranchInstruction((byte) 'A', 1)}, branchTargetFinder, codeAttributeEditor,
            new MaxStackSizeComputer())).matchedArgument(1));
  }

  /**
   * Method under test: {@link InstructionSequenceReplacer#matchedArgument(int)}
   */
  @Test
  public void testMatchedArgument2() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{new ClassConstant()}, new Instruction[]{new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertEquals(0,
        (new InstructionSequenceReplacer(instructionSequenceMatcher, new Constant[]{new ClassConstant()},
            new Instruction[]{new BranchInstruction((byte) 'A', 1)}, branchTargetFinder, codeAttributeEditor,
            new MaxStackSizeComputer())).matchedArgument(InstructionSequenceReplacer.X));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceReplacer#matchedArgument(Clazz, int)}
   */
  @Test
  public void testMatchedArgument3() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{new ClassConstant()}, new Instruction[]{new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    InstructionSequenceReplacer instructionSequenceReplacer = new InstructionSequenceReplacer(
        instructionSequenceMatcher, new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)}, branchTargetFinder, codeAttributeEditor,
        new MaxStackSizeComputer());

    // Act and Assert
    assertEquals(1, instructionSequenceReplacer.matchedArgument(new LibraryClass(), 1));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceReplacer#matchedArgument(Clazz, Method, CodeAttribute, int, int)}
   */
  @Test
  public void testMatchedArgument4() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{new ClassConstant()}, new Instruction[]{new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    InstructionSequenceReplacer instructionSequenceReplacer = new InstructionSequenceReplacer(
        instructionSequenceMatcher, new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)}, branchTargetFinder, codeAttributeEditor,
        new MaxStackSizeComputer());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(1, instructionSequenceReplacer.matchedArgument(clazz, method, new CodeAttribute(1), 2, 1));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}
   */
  @Test
  public void testMatchedBranchOffset() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{new ClassConstant()}, new Instruction[]{new BranchInstruction((byte) 'A', 3)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertEquals(3,
        (new InstructionSequenceReplacer(instructionSequenceMatcher, new Constant[]{new ClassConstant()},
            new Instruction[]{new BranchInstruction((byte) 'A', 3)}, branchTargetFinder, codeAttributeEditor,
            new MaxStackSizeComputer())).matchedBranchOffset(2, 3));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}
   */
  @Test
  public void testMatchedBranchOffset2() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{new ClassConstant()}, new Instruction[]{new BranchInstruction((byte) 'A', 3)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertEquals(3,
        (new InstructionSequenceReplacer(instructionSequenceMatcher, new Constant[]{new ClassConstant()},
            new Instruction[]{new BranchInstruction((byte) 'A', 3)}, branchTargetFinder, codeAttributeEditor,
            new MaxStackSizeComputer())).matchedBranchOffset(-16777216, 3));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}
   */
  @Test
  public void testMatchedBranchOffset3() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{new ClassConstant()}, new Instruction[]{new BranchInstruction((byte) 'A', 3)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertEquals(3,
        (new InstructionSequenceReplacer(instructionSequenceMatcher, new Constant[]{new ClassConstant()},
            new Instruction[]{new BranchInstruction((byte) 'A', 3)}, branchTargetFinder, codeAttributeEditor,
            new MaxStackSizeComputer())).matchedBranchOffset(InstructionSequenceReplacer.STRING_A_LENGTH, 3));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}
   */
  @Test
  public void testMatchedBranchOffset4() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{new ClassConstant()}, new Instruction[]{new BranchInstruction((byte) 'A', 3)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertEquals(3,
        (new InstructionSequenceReplacer(instructionSequenceMatcher, new Constant[]{new ClassConstant()},
            new Instruction[]{new BranchInstruction((byte) 'A', 3)}, branchTargetFinder, codeAttributeEditor,
            new MaxStackSizeComputer())).matchedBranchOffset(InstructionSequenceReplacer.X, 3));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}
   */
  @Test
  public void testMatchedBranchOffset5() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{new ClassConstant()}, new Instruction[]{new BranchInstruction((byte) 'A', 3)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertEquals(InstructionSequenceReplacer.STRING_A_LENGTH,
        (new InstructionSequenceReplacer(instructionSequenceMatcher, new Constant[]{new ClassConstant()},
            new Instruction[]{new BranchInstruction((byte) 'A', 3)}, branchTargetFinder, codeAttributeEditor,
            new MaxStackSizeComputer())).matchedBranchOffset(2, InstructionSequenceReplacer.STRING_A_LENGTH));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}
   */
  @Test
  public void testMatchedBranchOffset6() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{new ClassConstant()}, new Instruction[]{new BranchInstruction((byte) 'A', 3)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertEquals(-2,
        (new InstructionSequenceReplacer(instructionSequenceMatcher, new Constant[]{new ClassConstant()},
            new Instruction[]{new BranchInstruction((byte) 'A', 3)}, branchTargetFinder, codeAttributeEditor,
            new MaxStackSizeComputer())).matchedBranchOffset(2, InstructionSequenceReplacer.X));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceReplacer#matchedJumpOffsets(int, int[])}
   */
  @Test
  public void testMatchedJumpOffsets() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{new ClassConstant()}, new Instruction[]{new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertArrayEquals(new int[]{1, -16777216, 1, -16777216},
        (new InstructionSequenceReplacer(instructionSequenceMatcher, new Constant[]{new ClassConstant()},
            new Instruction[]{new BranchInstruction((byte) 'A', 1)}, branchTargetFinder, codeAttributeEditor,
            new MaxStackSizeComputer())).matchedJumpOffsets(2, new int[]{1, -16777216, 1, -16777216}));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceReplacer#matchedJumpOffsets(int, int[])}
   */
  @Test
  public void testMatchedJumpOffsets2() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{new ClassConstant()}, new Instruction[]{new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertArrayEquals(new int[]{InstructionSequenceReplacer.STRING_A_LENGTH, -16777216, 1, -16777216},
        (new InstructionSequenceReplacer(instructionSequenceMatcher, new Constant[]{new ClassConstant()},
            new Instruction[]{new BranchInstruction((byte) 'A', 1)}, branchTargetFinder, codeAttributeEditor,
            new MaxStackSizeComputer())).matchedJumpOffsets(2,
                new int[]{InstructionSequenceReplacer.STRING_A_LENGTH, -16777216, 1, -16777216}));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceReplacer#matchedJumpOffsets(int, int[])}
   */
  @Test
  public void testMatchedJumpOffsets3() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{new ClassConstant()}, new Instruction[]{new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertArrayEquals(new int[]{-2, -16777216, 1, -16777216},
        (new InstructionSequenceReplacer(instructionSequenceMatcher, new Constant[]{new ClassConstant()},
            new Instruction[]{new BranchInstruction((byte) 'A', 1)}, branchTargetFinder, codeAttributeEditor,
            new MaxStackSizeComputer())).matchedJumpOffsets(2,
                new int[]{InstructionSequenceReplacer.X, -16777216, 1, -16777216}));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceReplacer#getInstructionSequenceMatcher()}
   */
  @Test
  public void testGetInstructionSequenceMatcher() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{new ClassConstant()}, new Instruction[]{new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act
    InstructionSequenceMatcher actualInstructionSequenceMatcher = (new InstructionSequenceReplacer(
        instructionSequenceMatcher, new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)}, branchTargetFinder, codeAttributeEditor,
        new MaxStackSizeComputer())).getInstructionSequenceMatcher();

    // Assert
    assertFalse(actualInstructionSequenceMatcher.isMatching());
    assertSame(instructionSequenceMatcher, actualInstructionSequenceMatcher);
  }

  /**
   * Method under test: {@link InstructionSequenceReplacer#wasConstant(int)}
   */
  @Test
  public void testWasConstant() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{new ClassConstant()}, new Instruction[]{new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertFalse((new InstructionSequenceReplacer(instructionSequenceMatcher, new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)}, branchTargetFinder, codeAttributeEditor,
        new MaxStackSizeComputer())).wasConstant(1));
  }

  /**
   * Method under test:
   * {@link InstructionSequenceReplacer#matchedConstant(ProgramClass, int)}
   */
  @Test
  public void testMatchedConstant() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    InstructionSequenceMatcher instructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{classConstant, new ClassConstant()}, new Instruction[]{new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    InstructionSequenceReplacer instructionSequenceReplacer = new InstructionSequenceReplacer(
        instructionSequenceMatcher, new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)}, branchTargetFinder, codeAttributeEditor,
        new MaxStackSizeComputer());
    ClassConstant classConstant2 = new ClassConstant();

    // Act and Assert
    assertSame(classConstant2,
        instructionSequenceReplacer
            .matchedConstant(new ProgramClass(InstructionSequenceReplacer.X, 3, new Constant[]{classConstant2},
                InstructionSequenceReplacer.X, InstructionSequenceReplacer.X, InstructionSequenceReplacer.X), 1));
  }

  /**
   * Method under test: {@link InstructionSequenceReplacer#label()}
   */
  @Test
  public void testLabel() {
    // Arrange and Act
    InstructionSequenceReplacer.Label actualLabelResult = InstructionSequenceReplacer.label();

    // Assert
    assertEquals("nop", actualLabelResult.getName());
    assertEquals((byte) 0, actualLabelResult.opcode);
    assertFalse(actualLabelResult.isCategory2());
  }

  /**
   * Method under test: {@link InstructionSequenceReplacer#catch_(int, int, int)}
   */
  @Test
  public void testCatch_() {
    // Arrange and Act
    InstructionSequenceReplacer.Label actualCatch_Result = InstructionSequenceReplacer.catch_(1, 3, 1);

    // Assert
    assertEquals("nop", actualCatch_Result.getName());
    assertEquals((byte) 0, actualCatch_Result.opcode);
    assertFalse(actualCatch_Result.isCategory2());
  }

  /**
   * Method under test:
   * {@link InstructionSequenceReplacer#InstructionSequenceReplacer(InstructionSequenceMatcher, Constant[], Instruction[], BranchTargetFinder, CodeAttributeEditor, InstructionVisitor)}
   */
  @Test
  public void testNewInstructionSequenceReplacer() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{new ClassConstant()}, new Instruction[]{new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    InstructionSequenceMatcher instructionSequenceMatcher2 = (new InstructionSequenceReplacer(
        instructionSequenceMatcher, new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)}, branchTargetFinder, codeAttributeEditor,
        new MaxStackSizeComputer())).getInstructionSequenceMatcher();
    assertFalse(instructionSequenceMatcher2.isMatching());
    assertSame(instructionSequenceMatcher, instructionSequenceMatcher2);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceReplacer#InstructionSequenceReplacer(InstructionSequenceMatcher, Constant[], Instruction[], Constant[], Instruction[], BranchTargetFinder, CodeAttributeEditor, InstructionVisitor)}
   */
  @Test
  public void testNewInstructionSequenceReplacer2() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = new InstructionSequenceMatcher(
        new Constant[]{new ClassConstant()}, new Instruction[]{new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    InstructionSequenceMatcher instructionSequenceMatcher2 = (new InstructionSequenceReplacer(
        instructionSequenceMatcher, new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)}, new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)}, branchTargetFinder, codeAttributeEditor,
        new MaxStackSizeComputer())).getInstructionSequenceMatcher();
    assertFalse(instructionSequenceMatcher2.isMatching());
    assertSame(instructionSequenceMatcher, instructionSequenceMatcher2);
  }

  /**
   * Method under test:
   * {@link InstructionSequenceReplacer#InstructionSequenceReplacer(Constant[], Instruction[], Constant[], Instruction[], BranchTargetFinder, CodeAttributeEditor)}
   */
  @Test
  public void testNewInstructionSequenceReplacer3() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();

    // Act and Assert
    assertFalse((new InstructionSequenceReplacer(new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)}, new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)}, branchTargetFinder, new CodeAttributeEditor()))
            .getInstructionSequenceMatcher()
            .isMatching());
  }

  /**
   * Method under test:
   * {@link InstructionSequenceReplacer#InstructionSequenceReplacer(Constant[], Instruction[], Constant[], Instruction[], BranchTargetFinder, CodeAttributeEditor, InstructionVisitor)}
   */
  @Test
  public void testNewInstructionSequenceReplacer4() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertFalse((new InstructionSequenceReplacer(new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)}, new Constant[]{new ClassConstant()},
        new Instruction[]{new BranchInstruction((byte) 'A', 1)}, branchTargetFinder, codeAttributeEditor,
        new MaxStackSizeComputer())).getInstructionSequenceMatcher().isMatching());
  }
}
