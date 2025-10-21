package proguard.classfile.editor;

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
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.annotation.TypeAnnotation;
import proguard.classfile.attribute.annotation.target.CatchTargetInfo;
import proguard.classfile.attribute.annotation.target.TargetInfo;
import proguard.classfile.attribute.preverification.VerificationType;
import proguard.classfile.attribute.preverification.VerificationTypeFactory;
import proguard.classfile.attribute.visitor.MaxStackSizeComputer;
import proguard.classfile.editor.CodeAttributeEditor.Label;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.instruction.visitor.InstructionVisitor;

public class CodeAttributeEditorDiffblueTest {
  /**
   * Test Label {@link Label#accept(Clazz, Method, CodeAttribute, int, InstructionVisitor)}.
   *
   * <ul>
   *   <li>When {@link MaxStackSizeComputer#MaxStackSizeComputer()}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link Label#accept(Clazz, Method, CodeAttribute, int,
   * InstructionVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Label.accept(Clazz, Method, CodeAttribute, int, InstructionVisitor)"})
  public void testLabelAccept_whenMaxStackSizeComputer_thenThrowUnsupportedOperationException() {
    // Arrange
    Label label = new Label(1);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> label.accept(clazz, method, codeAttribute, 2, new MaxStackSizeComputer()));
  }

  /**
   * Test Label {@link Label#equals(Object)}, and {@link Label#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
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
  public void testLabelEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Label label = new Label(1);
    Label label2 = new Label(1);

    // Act and Assert
    assertEquals(label, label2);
    int expectedHashCodeResult = label.hashCode();
    assertEquals(expectedHashCodeResult, label2.hashCode());
  }

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
    Label label = new Label(1);

    // Act and Assert
    assertEquals(label, label);
    int expectedHashCodeResult = label.hashCode();
    assertEquals(expectedHashCodeResult, label.hashCode());
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
    Label label = new Label(2);

    // Act and Assert
    assertNotEquals(label, new Label(1));
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
  public void testLabelEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Label label = new Label(1);
    label.length(2);

    // Act and Assert
    assertNotEquals(label, new Label(1));
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
    assertNotEquals(new Label(1), null);
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
    assertNotEquals(new Label(1), "Different type to Label");
  }

  /**
   * Test Label getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Label#Label(int)}
   *   <li>{@link Label#length(int)}
   *   <li>{@link Label#write(byte[], int)}
   *   <li>{@link Label#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void Label.<init>(int)",
    "int Label.length(int)",
    "String Label.toString()",
    "void Label.write(byte[], int)"
  })
  public void testLabelGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    Label actualLabel = new Label(1);
    int actualLengthResult = actualLabel.length(2);
    actualLabel.write("AXAXAXAX".getBytes("UTF-8"), 2);

    // Assert
    assertEquals("label_536870913", actualLabel.toString());
    assertEquals(0, actualLengthResult);
  }

  /**
   * Test Label {@link Label#offset()}.
   *
   * <p>Method under test: {@link Label#offset()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Label.offset()"})
  public void testLabelOffset() {
    // Arrange, Act and Assert
    assertEquals(InstructionSequenceReplacer.CLASS_A_NAME, (new Label(1)).offset());
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
    Label label = new Label(1);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> label.readInfo("AXAXAXAX".getBytes("UTF-8"), 2));
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
    Label label = new Label(1);

    // Act and Assert
    assertSame(label, label.shrink());
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
    Label label = new Label(1);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> label.writeInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link CodeAttributeEditor#CodeAttributeEditor()}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#CodeAttributeEditor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeEditor.<init>()"})
  public void testNewCodeAttributeEditor() {
    // Arrange and Act
    CodeAttributeEditor actualCodeAttributeEditor = new CodeAttributeEditor();

    // Assert
    assertFalse(actualCodeAttributeEditor.isModified());
    assertEquals(ClassEstimates.TYPICAL_CODE_LENGTH, actualCodeAttributeEditor.deleted.length);
    assertEquals(
        ClassEstimates.TYPICAL_CODE_LENGTH, actualCodeAttributeEditor.postInsertions.length);
    assertEquals(
        ClassEstimates.TYPICAL_CODE_LENGTH, actualCodeAttributeEditor.preInsertions.length);
    assertEquals(
        ClassEstimates.TYPICAL_CODE_LENGTH, actualCodeAttributeEditor.preOffsetInsertions.length);
    assertEquals(ClassEstimates.TYPICAL_CODE_LENGTH, actualCodeAttributeEditor.replacements.length);
  }

  /**
   * Test {@link CodeAttributeEditor#CodeAttributeEditor(boolean, boolean)}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#CodeAttributeEditor(boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeEditor.<init>(boolean, boolean)"})
  public void testNewCodeAttributeEditor2() {
    // Arrange and Act
    CodeAttributeEditor actualCodeAttributeEditor = new CodeAttributeEditor(true, true);

    // Assert
    assertFalse(actualCodeAttributeEditor.isModified());
    assertEquals(ClassEstimates.TYPICAL_CODE_LENGTH, actualCodeAttributeEditor.deleted.length);
    assertEquals(
        ClassEstimates.TYPICAL_CODE_LENGTH, actualCodeAttributeEditor.postInsertions.length);
    assertEquals(
        ClassEstimates.TYPICAL_CODE_LENGTH, actualCodeAttributeEditor.preInsertions.length);
    assertEquals(
        ClassEstimates.TYPICAL_CODE_LENGTH, actualCodeAttributeEditor.preOffsetInsertions.length);
    assertEquals(ClassEstimates.TYPICAL_CODE_LENGTH, actualCodeAttributeEditor.replacements.length);
  }

  /**
   * Test {@link CodeAttributeEditor#insertBeforeOffset(int, Instruction)} with {@code
   * instructionOffset}, {@code instruction}.
   *
   * <ul>
   *   <li>When {@code -16777216}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#insertBeforeOffset(int, Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeEditor.insertBeforeOffset(int, Instruction)"})
  public void testInsertBeforeOffsetWithInstructionOffsetInstruction_when16777216() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.insertBeforeOffset(
                -16777216, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link CodeAttributeEditor#insertBeforeOffset(int, Instruction)} with {@code
   * instructionOffset}, {@code instruction}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#insertBeforeOffset(int, Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeEditor.insertBeforeOffset(int, Instruction)"})
  public void testInsertBeforeOffsetWithInstructionOffsetInstruction_whenOne() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> codeAttributeEditor.insertBeforeOffset(1, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link CodeAttributeEditor#insertBeforeOffset(int, Instruction[])} with {@code
   * instructionOffset}, {@code instructions}.
   *
   * <ul>
   *   <li>When {@code -16777216}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#insertBeforeOffset(int, Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeEditor.insertBeforeOffset(int, Instruction[])"})
  public void testInsertBeforeOffsetWithInstructionOffsetInstructions_when16777216() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.insertBeforeOffset(
                -16777216, new Instruction[] {new BranchInstruction((byte) 'A', 1)}));
  }

  /**
   * Test {@link CodeAttributeEditor#insertBeforeOffset(int, Instruction[])} with {@code
   * instructionOffset}, {@code instructions}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#insertBeforeOffset(int, Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeEditor.insertBeforeOffset(int, Instruction[])"})
  public void testInsertBeforeOffsetWithInstructionOffsetInstructions_whenOne() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.insertBeforeOffset(
                1, new Instruction[] {new BranchInstruction((byte) 'A', 1)}));
  }

  /**
   * Test {@link CodeAttributeEditor#insertBeforeInstruction(int, Instruction)} with {@code
   * instructionOffset}, {@code instruction}.
   *
   * <ul>
   *   <li>When {@code -16777216}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#insertBeforeInstruction(int, Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeEditor.insertBeforeInstruction(int, Instruction)"})
  public void testInsertBeforeInstructionWithInstructionOffsetInstruction_when16777216() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.insertBeforeInstruction(
                -16777216, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link CodeAttributeEditor#insertBeforeInstruction(int, Instruction)} with {@code
   * instructionOffset}, {@code instruction}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#insertBeforeInstruction(int, Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeEditor.insertBeforeInstruction(int, Instruction)"})
  public void testInsertBeforeInstructionWithInstructionOffsetInstruction_whenOne() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> codeAttributeEditor.insertBeforeInstruction(1, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link CodeAttributeEditor#insertBeforeInstruction(int, Instruction[])} with {@code
   * instructionOffset}, {@code instructions}.
   *
   * <ul>
   *   <li>When {@code -16777216}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#insertBeforeInstruction(int, Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeEditor.insertBeforeInstruction(int, Instruction[])"})
  public void testInsertBeforeInstructionWithInstructionOffsetInstructions_when16777216() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.insertBeforeInstruction(
                -16777216, new Instruction[] {new BranchInstruction((byte) 'A', 1)}));
  }

  /**
   * Test {@link CodeAttributeEditor#insertBeforeInstruction(int, Instruction[])} with {@code
   * instructionOffset}, {@code instructions}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#insertBeforeInstruction(int, Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeEditor.insertBeforeInstruction(int, Instruction[])"})
  public void testInsertBeforeInstructionWithInstructionOffsetInstructions_whenOne() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.insertBeforeInstruction(
                1, new Instruction[] {new BranchInstruction((byte) 'A', 1)}));
  }

  /**
   * Test {@link CodeAttributeEditor#replaceInstruction(int, Instruction)} with {@code
   * instructionOffset}, {@code instruction}.
   *
   * <ul>
   *   <li>When {@code -16777216}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#replaceInstruction(int, Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeEditor.replaceInstruction(int, Instruction)"})
  public void testReplaceInstructionWithInstructionOffsetInstruction_when16777216() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.replaceInstruction(
                -16777216, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link CodeAttributeEditor#replaceInstruction(int, Instruction)} with {@code
   * instructionOffset}, {@code instruction}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#replaceInstruction(int, Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeEditor.replaceInstruction(int, Instruction)"})
  public void testReplaceInstructionWithInstructionOffsetInstruction_whenOne() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> codeAttributeEditor.replaceInstruction(1, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link CodeAttributeEditor#replaceInstruction(int, Instruction[])} with {@code
   * instructionOffset}, {@code instructions}.
   *
   * <ul>
   *   <li>When {@code -16777216}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#replaceInstruction(int, Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeEditor.replaceInstruction(int, Instruction[])"})
  public void testReplaceInstructionWithInstructionOffsetInstructions_when16777216() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.replaceInstruction(
                -16777216, new Instruction[] {new BranchInstruction((byte) 'A', 1)}));
  }

  /**
   * Test {@link CodeAttributeEditor#replaceInstruction(int, Instruction[])} with {@code
   * instructionOffset}, {@code instructions}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#replaceInstruction(int, Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeEditor.replaceInstruction(int, Instruction[])"})
  public void testReplaceInstructionWithInstructionOffsetInstructions_whenOne() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.replaceInstruction(
                1, new Instruction[] {new BranchInstruction((byte) 'A', 1)}));
  }

  /**
   * Test {@link CodeAttributeEditor#insertAfterInstruction(int, Instruction)} with {@code
   * instructionOffset}, {@code instruction}.
   *
   * <ul>
   *   <li>When {@code -16777216}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#insertAfterInstruction(int, Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeEditor.insertAfterInstruction(int, Instruction)"})
  public void testInsertAfterInstructionWithInstructionOffsetInstruction_when16777216() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.insertAfterInstruction(
                -16777216, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link CodeAttributeEditor#insertAfterInstruction(int, Instruction)} with {@code
   * instructionOffset}, {@code instruction}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#insertAfterInstruction(int, Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeEditor.insertAfterInstruction(int, Instruction)"})
  public void testInsertAfterInstructionWithInstructionOffsetInstruction_whenOne() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> codeAttributeEditor.insertAfterInstruction(1, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link CodeAttributeEditor#insertAfterInstruction(int, Instruction[])} with {@code
   * instructionOffset}, {@code instructions}.
   *
   * <ul>
   *   <li>When {@code -16777216}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#insertAfterInstruction(int, Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeEditor.insertAfterInstruction(int, Instruction[])"})
  public void testInsertAfterInstructionWithInstructionOffsetInstructions_when16777216() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.insertAfterInstruction(
                -16777216, new Instruction[] {new BranchInstruction((byte) 'A', 1)}));
  }

  /**
   * Test {@link CodeAttributeEditor#insertAfterInstruction(int, Instruction[])} with {@code
   * instructionOffset}, {@code instructions}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#insertAfterInstruction(int, Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeEditor.insertAfterInstruction(int, Instruction[])"})
  public void testInsertAfterInstructionWithInstructionOffsetInstructions_whenOne() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.insertAfterInstruction(
                1, new Instruction[] {new BranchInstruction((byte) 'A', 1)}));
  }

  /**
   * Test {@link CodeAttributeEditor#deleteInstruction(int)}.
   *
   * <ul>
   *   <li>When minus one.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#deleteInstruction(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeEditor.deleteInstruction(int)"})
  public void testDeleteInstruction_whenMinusOne() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> (new CodeAttributeEditor()).deleteInstruction(-1));
  }

  /**
   * Test {@link CodeAttributeEditor#deleteInstruction(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#deleteInstruction(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeEditor.deleteInstruction(int)"})
  public void testDeleteInstruction_whenOne() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> (new CodeAttributeEditor()).deleteInstruction(1));
  }

  /**
   * Test {@link CodeAttributeEditor#clearModifications(int)}.
   *
   * <ul>
   *   <li>When minus one.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#clearModifications(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeEditor.clearModifications(int)"})
  public void testClearModifications_whenMinusOne() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> (new CodeAttributeEditor()).clearModifications(-1));
  }

  /**
   * Test {@link CodeAttributeEditor#clearModifications(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#clearModifications(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeEditor.clearModifications(int)"})
  public void testClearModifications_whenOne() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> (new CodeAttributeEditor()).clearModifications(1));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CodeAttributeEditor#visitAnyAttribute(Clazz, Attribute)}
   *   <li>{@link CodeAttributeEditor#visitAnyTargetInfo(Clazz, TypeAnnotation, TargetInfo)}
   *   <li>{@link CodeAttributeEditor#visitAnyVerificationType(Clazz, Method, CodeAttribute, int,
   *       VerificationType)}
   *   <li>{@link CodeAttributeEditor#isModified()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean CodeAttributeEditor.isModified()",
    "void CodeAttributeEditor.visitAnyAttribute(Clazz, Attribute)",
    "void CodeAttributeEditor.visitAnyTargetInfo(Clazz, TypeAnnotation, TargetInfo)",
    "void CodeAttributeEditor.visitAnyVerificationType(Clazz, Method, CodeAttribute, int, VerificationType)"
  })
  public void testGettersAndSetters() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();

    // Act
    codeAttributeEditor.visitAnyAttribute(clazz, new BootstrapMethodsAttribute());
    LibraryClass clazz2 = new LibraryClass();
    TypeAnnotation typeAnnotation = new TypeAnnotation();
    codeAttributeEditor.visitAnyTargetInfo(clazz2, typeAnnotation, new CatchTargetInfo((byte) 'A'));
    LibraryClass clazz3 = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    codeAttributeEditor.visitAnyVerificationType(
        clazz3, method, codeAttribute, 2, VerificationTypeFactory.createDoubleType());

    // Assert
    assertFalse(codeAttributeEditor.isModified());
  }

  /**
   * Test {@link CodeAttributeEditor#isModified(int)} with {@code int}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#isModified(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CodeAttributeEditor.isModified(int)"})
  public void testIsModifiedWithInt_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new CodeAttributeEditor()).isModified(1));
  }

  /**
   * Test {@link CodeAttributeEditor#getNewOffset(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#getNewOffset(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CodeAttributeEditor.getNewOffset(int)"})
  public void testGetNewOffset_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> (new CodeAttributeEditor()).getNewOffset(-1));
  }

  /**
   * Test {@link CodeAttributeEditor#getNewOffset(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#getNewOffset(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CodeAttributeEditor.getNewOffset(int)"})
  public void testGetNewOffset_whenOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new CodeAttributeEditor()).getNewOffset(1));
  }

  /**
   * Test {@link CodeAttributeEditor#label()}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#label()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Label CodeAttributeEditor.label()"})
  public void testLabel() {
    // Arrange and Act
    Label actualLabelResult = (new CodeAttributeEditor()).label();

    // Assert
    assertEquals("nop", actualLabelResult.getName());
    assertEquals(0, actualLabelResult.identifier);
    assertEquals((byte) 0, actualLabelResult.opcode);
    assertFalse(actualLabelResult.isCategory2());
  }

  /**
   * Test {@link CodeAttributeEditor#label(int)} with {@code int}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#label(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Label CodeAttributeEditor.label(int)"})
  public void testLabelWithInt() {
    // Arrange and Act
    Label actualLabelResult = (new CodeAttributeEditor()).label(1);

    // Assert
    assertEquals("nop", actualLabelResult.getName());
    assertEquals((byte) 0, actualLabelResult.opcode);
    assertEquals(1, actualLabelResult.identifier);
    assertFalse(actualLabelResult.isCategory2());
  }

  /**
   * Test {@link CodeAttributeEditor#catch_(int, int, int, int)} with {@code identifier}, {@code
   * startOffset}, {@code endOffset}, {@code catchType}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#catch_(int, int, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Label CodeAttributeEditor.catch_(int, int, int, int)"})
  public void testCatch_WithIdentifierStartOffsetEndOffsetCatchType() {
    // Arrange and Act
    Label actualCatch_Result = (new CodeAttributeEditor()).catch_(1, 1, 3, 1);

    // Assert
    assertEquals("nop", actualCatch_Result.getName());
    assertEquals((byte) 0, actualCatch_Result.opcode);
    assertEquals(1, actualCatch_Result.identifier);
    assertFalse(actualCatch_Result.isCategory2());
  }

  /**
   * Test {@link CodeAttributeEditor#line(int, int, String)} with {@code identifier}, {@code
   * lineNumber}, {@code source}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#line(int, int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Label CodeAttributeEditor.line(int, int, String)"})
  public void testLineWithIdentifierLineNumberSource() {
    // Arrange and Act
    Label actualLineResult = (new CodeAttributeEditor()).line(1, 2, "Source");

    // Assert
    assertEquals("nop", actualLineResult.getName());
    assertEquals((byte) 0, actualLineResult.opcode);
    assertEquals(1, actualLineResult.identifier);
    assertFalse(actualLineResult.isCategory2());
  }
}
