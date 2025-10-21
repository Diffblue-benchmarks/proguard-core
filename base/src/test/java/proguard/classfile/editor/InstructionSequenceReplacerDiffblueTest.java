package proguard.classfile.editor;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.visitor.MaxStackSizeComputer;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.editor.InstructionSequenceReplacer.Label;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.instruction.visitor.InstructionVisitor;
import proguard.classfile.util.BranchTargetFinder;
import proguard.classfile.util.InstructionSequenceMatcher;

public class InstructionSequenceReplacerDiffblueTest {
  /**
   * Test Label {@link Label#equals(Object)}, and {@link Label#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Label#equals(Object)}
   *   <li>{@link Label#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Label.equals(Object)", "int Label.hashCode()"})
  public void testLabelEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Label labelResult = InstructionSequenceReplacer.label();

    // Act and Assert
    assertEquals(labelResult, labelResult);
    int expectedHashCodeResult = labelResult.hashCode();
    assertEquals(expectedHashCodeResult, labelResult.hashCode());
  }

  /**
   * Test Label {@link Label#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Label#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Label.equals(Object)", "int Label.hashCode()"})
  public void testLabelEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Label labelResult = InstructionSequenceReplacer.label();

    // Act and Assert
    assertNotEquals(labelResult, InstructionSequenceReplacer.label());
  }

  /**
   * Test Label {@link Label#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Label#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Label.equals(Object)", "int Label.hashCode()"})
  public void testLabelEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(InstructionSequenceReplacer.label(), null);
  }

  /**
   * Test Label {@link Label#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Label#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Label.equals(Object)", "int Label.hashCode()"})
  public void testLabelEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(InstructionSequenceReplacer.label(), "Different type to Label");
  }

  /**
   * Test Label {@link Label#length(int)}.
   *
   * <p>Method under test: {@link Label#length(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Label.length(int)"})
  public void testLabelLength() {
    // Arrange, Act and Assert
    assertEquals(0, InstructionSequenceReplacer.label().length(2));
  }

  /**
   * Test Label {@link Label#readInfo(byte[], int)}.
   *
   * <p>Method under test: {@link Label#readInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Label.readInfo(byte[], int)"})
  public void testLabelReadInfo() throws UnsupportedEncodingException {
    // Arrange
    Label labelResult = InstructionSequenceReplacer.label();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> labelResult.readInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test Label {@link Label#shrink()}.
   *
   * <p>Method under test: {@link Label#shrink()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Instruction Label.shrink()"})
  public void testLabelShrink() {
    // Arrange
    Label labelResult = InstructionSequenceReplacer.label();

    // Act and Assert
    assertSame(labelResult, labelResult.shrink());
  }

  /**
   * Test Label {@link Label#writeInfo(byte[], int)}.
   *
   * <p>Method under test: {@link Label#writeInfo(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Label.writeInfo(byte[], int)"})
  public void testLabelWriteInfo() throws UnsupportedEncodingException {
    // Arrange
    Label labelResult = InstructionSequenceReplacer.label();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> labelResult.writeInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link InstructionSequenceReplacer#InstructionSequenceReplacer(InstructionSequenceMatcher,
   * Constant[], Instruction[], BranchTargetFinder, CodeAttributeEditor, InstructionVisitor)}.
   *
   * <p>Method under test: {@link
   * InstructionSequenceReplacer#InstructionSequenceReplacer(InstructionSequenceMatcher, Constant[],
   * Instruction[], BranchTargetFinder, CodeAttributeEditor, InstructionVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void InstructionSequenceReplacer.<init>(InstructionSequenceMatcher, Constant[], Instruction[], BranchTargetFinder, CodeAttributeEditor, InstructionVisitor)"
  })
  public void testNewInstructionSequenceReplacer() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertSame(
        instructionSequenceMatcher,
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .getInstructionSequenceMatcher());
  }

  /**
   * Test {@link InstructionSequenceReplacer#InstructionSequenceReplacer(InstructionSequenceMatcher,
   * Constant[], Instruction[], Constant[], Instruction[], BranchTargetFinder, CodeAttributeEditor,
   * InstructionVisitor)}.
   *
   * <p>Method under test: {@link
   * InstructionSequenceReplacer#InstructionSequenceReplacer(InstructionSequenceMatcher, Constant[],
   * Instruction[], Constant[], Instruction[], BranchTargetFinder, CodeAttributeEditor,
   * InstructionVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void InstructionSequenceReplacer.<init>(InstructionSequenceMatcher, Constant[], Instruction[], Constant[], Instruction[], BranchTargetFinder, CodeAttributeEditor, InstructionVisitor)"
  })
  public void testNewInstructionSequenceReplacer2() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertSame(
        instructionSequenceMatcher,
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)},
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .getInstructionSequenceMatcher());
  }

  /**
   * Test {@link InstructionSequenceReplacer#InstructionSequenceReplacer(Constant[], Instruction[],
   * Constant[], Instruction[], BranchTargetFinder, CodeAttributeEditor)}.
   *
   * <p>Method under test: {@link
   * InstructionSequenceReplacer#InstructionSequenceReplacer(Constant[], Instruction[], Constant[],
   * Instruction[], BranchTargetFinder, CodeAttributeEditor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void InstructionSequenceReplacer.<init>(Constant[], Instruction[], Constant[], Instruction[], BranchTargetFinder, CodeAttributeEditor)"
  })
  public void testNewInstructionSequenceReplacer3() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();

    // Act and Assert
    assertFalse(
        (new InstructionSequenceReplacer(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)},
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)},
                branchTargetFinder,
                new CodeAttributeEditor()))
            .getInstructionSequenceMatcher()
            .isMatching());
  }

  /**
   * Test {@link InstructionSequenceReplacer#InstructionSequenceReplacer(Constant[], Instruction[],
   * Constant[], Instruction[], BranchTargetFinder, CodeAttributeEditor, InstructionVisitor)}.
   *
   * <p>Method under test: {@link
   * InstructionSequenceReplacer#InstructionSequenceReplacer(Constant[], Instruction[], Constant[],
   * Instruction[], BranchTargetFinder, CodeAttributeEditor, InstructionVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void InstructionSequenceReplacer.<init>(Constant[], Instruction[], Constant[], Instruction[], BranchTargetFinder, CodeAttributeEditor, InstructionVisitor)"
  })
  public void testNewInstructionSequenceReplacer4() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertFalse(
        (new InstructionSequenceReplacer(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)},
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .getInstructionSequenceMatcher()
            .isMatching());
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedArgument(int)} with {@code argument}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedArgument(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int InstructionSequenceReplacer.matchedArgument(int)"})
  public void testMatchedArgumentWithArgument_whenOne_thenReturnOne() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertEquals(
        1,
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .matchedArgument(1));
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedArgument(int)} with {@code argument}.
   *
   * <ul>
   *   <li>When {@link InstructionSequenceReplacer#X}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedArgument(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int InstructionSequenceReplacer.matchedArgument(int)"})
  public void testMatchedArgumentWithArgument_whenX_thenReturnZero() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertEquals(
        0,
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .matchedArgument(InstructionSequenceReplacer.X));
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedArgument(Clazz, int)} with {@code clazz}, {@code
   * argument}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedArgument(Clazz, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int InstructionSequenceReplacer.matchedArgument(Clazz, int)"})
  public void testMatchedArgumentWithClazzArgument_whenOne_thenReturnOne() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    InstructionSequenceReplacer instructionSequenceReplacer =
        new InstructionSequenceReplacer(
            instructionSequenceMatcher,
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)},
            branchTargetFinder,
            codeAttributeEditor,
            new MaxStackSizeComputer());

    // Act and Assert
    assertEquals(1, instructionSequenceReplacer.matchedArgument(new LibraryClass(), 1));
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedArgument(Clazz, Method, CodeAttribute, int,
   * int)} with {@code clazz}, {@code method}, {@code codeAttribute}, {@code offset}, {@code
   * argument}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedArgument(Clazz, Method,
   * CodeAttribute, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "int InstructionSequenceReplacer.matchedArgument(Clazz, Method, CodeAttribute, int, int)"
  })
  public void testMatchedArgumentWithClazzMethodCodeAttributeOffsetArgument_thenReturnOne() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    InstructionSequenceReplacer instructionSequenceReplacer =
        new InstructionSequenceReplacer(
            instructionSequenceMatcher,
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)},
            branchTargetFinder,
            codeAttributeEditor,
            new MaxStackSizeComputer());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        1, instructionSequenceReplacer.matchedArgument(clazz, method, new CodeAttribute(1), 2, 1));
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}.
   *
   * <ul>
   *   <li>When {@code -16777216}.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int InstructionSequenceReplacer.matchedBranchOffset(int, int)"})
  public void testMatchedBranchOffset_when16777216_thenReturnThree() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 3)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertEquals(
        3,
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 3)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .matchedBranchOffset(-16777216, 3));
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}.
   *
   * <ul>
   *   <li>When {@link InstructionSequenceReplacer#STRING_A_LENGTH}.
   *   <li>Then return {@link InstructionSequenceReplacer#STRING_A_LENGTH}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int InstructionSequenceReplacer.matchedBranchOffset(int, int)"})
  public void testMatchedBranchOffset_whenString_a_length_thenReturnString_a_length() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 3)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertEquals(
        InstructionSequenceReplacer.STRING_A_LENGTH,
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 3)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .matchedBranchOffset(2, InstructionSequenceReplacer.STRING_A_LENGTH));
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}.
   *
   * <ul>
   *   <li>When {@link InstructionSequenceReplacer#STRING_A_LENGTH}.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int InstructionSequenceReplacer.matchedBranchOffset(int, int)"})
  public void testMatchedBranchOffset_whenString_a_length_thenReturnThree() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 3)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertEquals(
        3,
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 3)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .matchedBranchOffset(InstructionSequenceReplacer.STRING_A_LENGTH, 3));
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int InstructionSequenceReplacer.matchedBranchOffset(int, int)"})
  public void testMatchedBranchOffset_whenTwo_thenReturnThree() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 3)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertEquals(
        3,
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 3)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .matchedBranchOffset(2, 3));
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}.
   *
   * <ul>
   *   <li>When {@link InstructionSequenceReplacer#X}.
   *   <li>Then return minus two.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int InstructionSequenceReplacer.matchedBranchOffset(int, int)"})
  public void testMatchedBranchOffset_whenX_thenReturnMinusTwo() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 3)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertEquals(
        -2,
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 3)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .matchedBranchOffset(2, InstructionSequenceReplacer.X));
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}.
   *
   * <ul>
   *   <li>When {@link InstructionSequenceReplacer#X}.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int InstructionSequenceReplacer.matchedBranchOffset(int, int)"})
  public void testMatchedBranchOffset_whenX_thenReturnThree() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 3)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertEquals(
        3,
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 3)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .matchedBranchOffset(InstructionSequenceReplacer.X, 3));
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedJumpOffsets(int, int[])}.
   *
   * <ul>
   *   <li>Then return array of {@code int} with minus two and {@code -16777216}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedJumpOffsets(int, int[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int[] InstructionSequenceReplacer.matchedJumpOffsets(int, int[])"})
  public void testMatchedJumpOffsets_thenReturnArrayOfIntWithMinusTwoAnd16777216() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertArrayEquals(
        new int[] {-2, -16777216, 1, -16777216},
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .matchedJumpOffsets(
                2, new int[] {InstructionSequenceReplacer.X, -16777216, 1, -16777216}));
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedJumpOffsets(int, int[])}.
   *
   * <ul>
   *   <li>Then return array of {@code int} with one and {@code -16777216}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedJumpOffsets(int, int[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int[] InstructionSequenceReplacer.matchedJumpOffsets(int, int[])"})
  public void testMatchedJumpOffsets_thenReturnArrayOfIntWithOneAnd16777216() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertArrayEquals(
        new int[] {1, -16777216, 1, -16777216},
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .matchedJumpOffsets(2, new int[] {1, -16777216, 1, -16777216}));
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedJumpOffsets(int, int[])}.
   *
   * <ul>
   *   <li>Then return array of {@code int} with {@link InstructionSequenceReplacer#STRING_A_LENGTH}
   *       and {@code -16777216}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedJumpOffsets(int, int[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int[] InstructionSequenceReplacer.matchedJumpOffsets(int, int[])"})
  public void testMatchedJumpOffsets_thenReturnArrayOfIntWithString_a_lengthAnd16777216() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertArrayEquals(
        new int[] {InstructionSequenceReplacer.STRING_A_LENGTH, -16777216, 1, -16777216},
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .matchedJumpOffsets(
                2,
                new int[] {InstructionSequenceReplacer.STRING_A_LENGTH, -16777216, 1, -16777216}));
  }

  /**
   * Test {@link InstructionSequenceReplacer#getInstructionSequenceMatcher()}.
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#getInstructionSequenceMatcher()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InstructionSequenceMatcher InstructionSequenceReplacer.getInstructionSequenceMatcher()"
  })
  public void testGetInstructionSequenceMatcher() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act
    InstructionSequenceMatcher actualInstructionSequenceMatcher =
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .getInstructionSequenceMatcher();

    // Assert
    assertFalse(actualInstructionSequenceMatcher.isMatching());
    assertSame(instructionSequenceMatcher, actualInstructionSequenceMatcher);
  }

  /**
   * Test {@link InstructionSequenceReplacer#wasConstant(int)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#wasConstant(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InstructionSequenceReplacer.wasConstant(int)"})
  public void testWasConstant_thenReturnFalse() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertFalse(
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .wasConstant(1));
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedConstant(ProgramClass, int)}.
   *
   * <ul>
   *   <li>Then return {@link ClassConstant#ClassConstant()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedConstant(ProgramClass, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Constant InstructionSequenceReplacer.matchedConstant(ProgramClass, int)"})
  public void testMatchedConstant_thenReturnClassConstant() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {classConstant, new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    InstructionSequenceReplacer instructionSequenceReplacer =
        new InstructionSequenceReplacer(
            instructionSequenceMatcher,
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)},
            branchTargetFinder,
            codeAttributeEditor,
            new MaxStackSizeComputer());
    ClassConstant classConstant2 = new ClassConstant();

    // Act and Assert
    assertSame(
        classConstant2,
        instructionSequenceReplacer.matchedConstant(
            new ProgramClass(
                InstructionSequenceReplacer.X,
                3,
                new Constant[] {classConstant2},
                InstructionSequenceReplacer.X,
                InstructionSequenceReplacer.X,
                InstructionSequenceReplacer.X),
            1));
  }

  /**
   * Test {@link InstructionSequenceReplacer#label()}.
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#label()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Label InstructionSequenceReplacer.label()"})
  public void testLabel() {
    // Arrange and Act
    Label actualLabelResult = InstructionSequenceReplacer.label();

    // Assert
    assertEquals("nop", actualLabelResult.getName());
    assertEquals((byte) 0, actualLabelResult.opcode);
    assertFalse(actualLabelResult.isCategory2());
  }

  /**
   * Test {@link InstructionSequenceReplacer#catch_(int, int, int)}.
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#catch_(int, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Label InstructionSequenceReplacer.catch_(int, int, int)"})
  public void testCatch_() {
    // Arrange and Act
    Label actualCatch_Result = InstructionSequenceReplacer.catch_(1, 3, 1);

    // Assert
    assertEquals("nop", actualCatch_Result.getName());
    assertEquals((byte) 0, actualCatch_Result.opcode);
    assertFalse(actualCatch_Result.isCategory2());
  }
}
