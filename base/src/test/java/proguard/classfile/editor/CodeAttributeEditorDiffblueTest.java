package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.ExceptionInfo;
import proguard.classfile.attribute.LineNumberInfo;
import proguard.classfile.attribute.LocalVariableInfo;
import proguard.classfile.attribute.LocalVariableTypeInfo;
import proguard.classfile.attribute.annotation.AnnotationElementValue;
import proguard.classfile.attribute.annotation.ElementValue;
import proguard.classfile.attribute.annotation.TypeAnnotation;
import proguard.classfile.attribute.annotation.TypeAnnotationsAttribute;
import proguard.classfile.attribute.annotation.TypePathInfo;
import proguard.classfile.attribute.annotation.target.CatchTargetInfo;
import proguard.classfile.attribute.annotation.target.LocalVariableTargetElement;
import proguard.classfile.attribute.annotation.target.LocalVariableTargetInfo;
import proguard.classfile.attribute.annotation.target.OffsetTargetInfo;
import proguard.classfile.attribute.annotation.target.TargetInfo;
import proguard.classfile.attribute.annotation.visitor.TypeAnnotationVisitor;
import proguard.classfile.attribute.preverification.FullFrame;
import proguard.classfile.attribute.preverification.MoreZeroFrame;
import proguard.classfile.attribute.preverification.SameOneFrame;
import proguard.classfile.attribute.preverification.StackMapFrame;
import proguard.classfile.attribute.preverification.UninitializedType;
import proguard.classfile.attribute.preverification.VerificationType;
import proguard.classfile.attribute.preverification.VerificationTypeFactory;
import proguard.classfile.attribute.visitor.MaxStackSizeComputer;
import proguard.classfile.editor.CodeAttributeEditor.Label;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.instruction.LookUpSwitchInstruction;
import proguard.classfile.instruction.SimpleInstruction;
import proguard.classfile.instruction.TableSwitchInstruction;
import proguard.classfile.instruction.VariableInstruction;
import proguard.classfile.instruction.visitor.InstructionVisitor;

class CodeAttributeEditorDiffblueTest {
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
  @DisplayName(
      "Test Label accept(Clazz, Method, CodeAttribute, int, InstructionVisitor); when MaxStackSizeComputer(); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor$Label.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.visitor.InstructionVisitor)"
  })
  void testLabelAccept_whenMaxStackSizeComputer_thenThrowUnsupportedOperationException() {
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
  @DisplayName("Test Label equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.editor.CodeAttributeEditor$Label.equals(java.lang.Object)",
    "int proguard.classfile.editor.CodeAttributeEditor$Label.hashCode()"
  })
  void testLabelEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @DisplayName("Test Label equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.editor.CodeAttributeEditor$Label.equals(java.lang.Object)",
    "int proguard.classfile.editor.CodeAttributeEditor$Label.hashCode()"
  })
  void testLabelEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @DisplayName("Test Label equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.editor.CodeAttributeEditor$Label.equals(java.lang.Object)",
    "int proguard.classfile.editor.CodeAttributeEditor$Label.hashCode()"
  })
  void testLabelEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @DisplayName("Test Label equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.editor.CodeAttributeEditor$Label.equals(java.lang.Object)",
    "int proguard.classfile.editor.CodeAttributeEditor$Label.hashCode()"
  })
  void testLabelEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
  @DisplayName("Test Label equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.editor.CodeAttributeEditor$Label.equals(java.lang.Object)",
    "int proguard.classfile.editor.CodeAttributeEditor$Label.hashCode()"
  })
  void testLabelEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @DisplayName("Test Label equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.editor.CodeAttributeEditor$Label.equals(java.lang.Object)",
    "int proguard.classfile.editor.CodeAttributeEditor$Label.hashCode()"
  })
  void testLabelEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
  @DisplayName("Test Label getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor$Label.<init>(int)",
    "int proguard.classfile.editor.CodeAttributeEditor$Label.length(int)",
    "java.lang.String proguard.classfile.editor.CodeAttributeEditor$Label.toString()",
    "void proguard.classfile.editor.CodeAttributeEditor$Label.write(byte[], int)"
  })
  void testLabelGettersAndSetters() throws UnsupportedEncodingException {
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
  @DisplayName("Test Label offset()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.editor.CodeAttributeEditor$Label.offset()"})
  void testLabelOffset() {
    // Arrange, Act and Assert
    assertEquals(InstructionSequenceReplacer.CLASS_A_NAME, (new Label(1)).offset());
  }

  /**
   * Test Label {@link Label#readInfo(byte[], int)}.
   *
   * <p>Method under test: {@link Label#readInfo(byte[], int)}
   */
  @Test
  @DisplayName("Test Label readInfo(byte[], int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor$Label.readInfo(byte[], int)"
  })
  void testLabelReadInfo() throws UnsupportedEncodingException {
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
  @DisplayName("Test Label shrink()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.instruction.Instruction proguard.classfile.editor.CodeAttributeEditor$Label.shrink()"
  })
  void testLabelShrink() {
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
  @DisplayName("Test Label writeInfo(byte[], int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor$Label.writeInfo(byte[], int)"
  })
  void testLabelWriteInfo() throws UnsupportedEncodingException {
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
  @DisplayName("Test new CodeAttributeEditor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.editor.CodeAttributeEditor.<init>()"})
  void testNewCodeAttributeEditor() {
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
  @DisplayName("Test new CodeAttributeEditor(boolean, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.editor.CodeAttributeEditor.<init>(boolean, boolean)"})
  void testNewCodeAttributeEditor2() {
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
  @DisplayName(
      "Test insertBeforeOffset(int, Instruction) with 'instructionOffset', 'instruction'; when '-16777216'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.insertBeforeOffset(int, proguard.classfile.instruction.Instruction)"
  })
  void testInsertBeforeOffsetWithInstructionOffsetInstruction_when16777216() {
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
  @DisplayName(
      "Test insertBeforeOffset(int, Instruction) with 'instructionOffset', 'instruction'; when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.insertBeforeOffset(int, proguard.classfile.instruction.Instruction)"
  })
  void testInsertBeforeOffsetWithInstructionOffsetInstruction_whenOne() {
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
  @DisplayName(
      "Test insertBeforeOffset(int, Instruction[]) with 'instructionOffset', 'instructions'; when '-16777216'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.insertBeforeOffset(int, proguard.classfile.instruction.Instruction[])"
  })
  void testInsertBeforeOffsetWithInstructionOffsetInstructions_when16777216() {
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
  @DisplayName(
      "Test insertBeforeOffset(int, Instruction[]) with 'instructionOffset', 'instructions'; when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.insertBeforeOffset(int, proguard.classfile.instruction.Instruction[])"
  })
  void testInsertBeforeOffsetWithInstructionOffsetInstructions_whenOne() {
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
  @DisplayName(
      "Test insertBeforeInstruction(int, Instruction) with 'instructionOffset', 'instruction'; when '-16777216'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.insertBeforeInstruction(int, proguard.classfile.instruction.Instruction)"
  })
  void testInsertBeforeInstructionWithInstructionOffsetInstruction_when16777216() {
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
  @DisplayName(
      "Test insertBeforeInstruction(int, Instruction) with 'instructionOffset', 'instruction'; when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.insertBeforeInstruction(int, proguard.classfile.instruction.Instruction)"
  })
  void testInsertBeforeInstructionWithInstructionOffsetInstruction_whenOne() {
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
  @DisplayName(
      "Test insertBeforeInstruction(int, Instruction[]) with 'instructionOffset', 'instructions'; when '-16777216'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.insertBeforeInstruction(int, proguard.classfile.instruction.Instruction[])"
  })
  void testInsertBeforeInstructionWithInstructionOffsetInstructions_when16777216() {
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
  @DisplayName(
      "Test insertBeforeInstruction(int, Instruction[]) with 'instructionOffset', 'instructions'; when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.insertBeforeInstruction(int, proguard.classfile.instruction.Instruction[])"
  })
  void testInsertBeforeInstructionWithInstructionOffsetInstructions_whenOne() {
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
  @DisplayName(
      "Test replaceInstruction(int, Instruction) with 'instructionOffset', 'instruction'; when '-16777216'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.replaceInstruction(int, proguard.classfile.instruction.Instruction)"
  })
  void testReplaceInstructionWithInstructionOffsetInstruction_when16777216() {
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
  @DisplayName(
      "Test replaceInstruction(int, Instruction) with 'instructionOffset', 'instruction'; when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.replaceInstruction(int, proguard.classfile.instruction.Instruction)"
  })
  void testReplaceInstructionWithInstructionOffsetInstruction_whenOne() {
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
  @DisplayName(
      "Test replaceInstruction(int, Instruction[]) with 'instructionOffset', 'instructions'; when '-16777216'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.replaceInstruction(int, proguard.classfile.instruction.Instruction[])"
  })
  void testReplaceInstructionWithInstructionOffsetInstructions_when16777216() {
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
  @DisplayName(
      "Test replaceInstruction(int, Instruction[]) with 'instructionOffset', 'instructions'; when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.replaceInstruction(int, proguard.classfile.instruction.Instruction[])"
  })
  void testReplaceInstructionWithInstructionOffsetInstructions_whenOne() {
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
  @DisplayName(
      "Test insertAfterInstruction(int, Instruction) with 'instructionOffset', 'instruction'; when '-16777216'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.insertAfterInstruction(int, proguard.classfile.instruction.Instruction)"
  })
  void testInsertAfterInstructionWithInstructionOffsetInstruction_when16777216() {
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
  @DisplayName(
      "Test insertAfterInstruction(int, Instruction) with 'instructionOffset', 'instruction'; when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.insertAfterInstruction(int, proguard.classfile.instruction.Instruction)"
  })
  void testInsertAfterInstructionWithInstructionOffsetInstruction_whenOne() {
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
  @DisplayName(
      "Test insertAfterInstruction(int, Instruction[]) with 'instructionOffset', 'instructions'; when '-16777216'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.insertAfterInstruction(int, proguard.classfile.instruction.Instruction[])"
  })
  void testInsertAfterInstructionWithInstructionOffsetInstructions_when16777216() {
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
  @DisplayName(
      "Test insertAfterInstruction(int, Instruction[]) with 'instructionOffset', 'instructions'; when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.insertAfterInstruction(int, proguard.classfile.instruction.Instruction[])"
  })
  void testInsertAfterInstructionWithInstructionOffsetInstructions_whenOne() {
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
  @DisplayName("Test deleteInstruction(int); when minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.editor.CodeAttributeEditor.deleteInstruction(int)"})
  void testDeleteInstruction_whenMinusOne() {
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
  @DisplayName("Test deleteInstruction(int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.editor.CodeAttributeEditor.deleteInstruction(int)"})
  void testDeleteInstruction_whenOne() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> (new CodeAttributeEditor()).deleteInstruction(1));
  }

  /**
   * Test {@link CodeAttributeEditor#undeleteInstruction(int)}.
   *
   * <ul>
   *   <li>When minus one.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#undeleteInstruction(int)}
   */
  @Test
  @DisplayName("Test undeleteInstruction(int); when minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.editor.CodeAttributeEditor.undeleteInstruction(int)"})
  void testUndeleteInstruction_whenMinusOne() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> (new CodeAttributeEditor()).undeleteInstruction(-1));
  }

  /**
   * Test {@link CodeAttributeEditor#undeleteInstruction(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#undeleteInstruction(int)}
   */
  @Test
  @DisplayName("Test undeleteInstruction(int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.editor.CodeAttributeEditor.undeleteInstruction(int)"})
  void testUndeleteInstruction_whenOne() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> (new CodeAttributeEditor()).undeleteInstruction(1));
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
  @DisplayName("Test clearModifications(int); when minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.editor.CodeAttributeEditor.clearModifications(int)"})
  void testClearModifications_whenMinusOne() {
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
  @DisplayName("Test clearModifications(int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.editor.CodeAttributeEditor.clearModifications(int)"})
  void testClearModifications_whenOne() {
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.editor.CodeAttributeEditor.isModified()",
    "void proguard.classfile.editor.CodeAttributeEditor.visitAnyAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.Attribute)",
    "void proguard.classfile.editor.CodeAttributeEditor.visitAnyTargetInfo(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.TypeAnnotation, proguard.classfile.attribute.annotation.target.TargetInfo)",
    "void proguard.classfile.editor.CodeAttributeEditor.visitAnyVerificationType(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.VerificationType)"
  })
  void testGettersAndSetters() {
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
  @DisplayName("Test isModified(int) with 'int'; when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.editor.CodeAttributeEditor.isModified(int)"})
  void testIsModifiedWithInt_whenOne_thenReturnFalse() {
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
  @DisplayName("Test getNewOffset(int); when minus one; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.editor.CodeAttributeEditor.getNewOffset(int)"})
  void testGetNewOffset_whenMinusOne_thenThrowIllegalArgumentException() {
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
  @DisplayName("Test getNewOffset(int); when one; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.editor.CodeAttributeEditor.getNewOffset(int)"})
  void testGetNewOffset_whenOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new CodeAttributeEditor()).getNewOffset(1));
  }

  /**
   * Test {@link CodeAttributeEditor#visitAnyTypeAnnotationsAttribute(Clazz,
   * TypeAnnotationsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link TypeAnnotationsAttribute#typeAnnotationsAccept(Clazz,
   *       TypeAnnotationVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitAnyTypeAnnotationsAttribute(Clazz,
   * TypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnyTypeAnnotationsAttribute(Clazz, TypeAnnotationsAttribute); then calls typeAnnotationsAccept(Clazz, TypeAnnotationVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitAnyTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.TypeAnnotationsAttribute)"
  })
  void testVisitAnyTypeAnnotationsAttribute_thenCallsTypeAnnotationsAccept() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    TypeAnnotationsAttribute typeAnnotationsAttribute = mock(TypeAnnotationsAttribute.class);
    doNothing()
        .when(typeAnnotationsAttribute)
        .typeAnnotationsAccept(Mockito.<Clazz>any(), Mockito.<TypeAnnotationVisitor>any());

    // Act
    codeAttributeEditor.visitAnyTypeAnnotationsAttribute(clazz, typeAnnotationsAttribute);

    // Assert
    verify(typeAnnotationsAttribute)
        .typeAnnotationsAccept(isA(Clazz.class), isA(TypeAnnotationVisitor.class));
  }

  /**
   * Test {@link CodeAttributeEditor#visitSimpleInstruction(Clazz, Method, CodeAttribute, int,
   * SimpleInstruction)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then calls {@link Instruction#write(byte[], int)}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitSimpleInstruction(Clazz, Method,
   * CodeAttribute, int, SimpleInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitSimpleInstruction(Clazz, Method, CodeAttribute, int, SimpleInstruction); given three; then calls write(byte[], int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitSimpleInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.SimpleInstruction)"
  })
  void testVisitSimpleInstruction_givenThree_thenCallsWrite() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    SimpleInstruction simpleInstruction = mock(SimpleInstruction.class);
    when(simpleInstruction.length(anyInt())).thenReturn(3);
    doNothing().when(simpleInstruction).write(Mockito.<byte[]>any(), anyInt());

    // Act
    codeAttributeEditor.visitSimpleInstruction(clazz, method, codeAttribute, 2, simpleInstruction);

    // Assert
    verify(simpleInstruction).write(isA(byte[].class), eq(0));
    verify(simpleInstruction).length(eq(0));
  }

  /**
   * Test {@link CodeAttributeEditor#visitConstantInstruction(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction)}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitConstantInstruction(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitConstantInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction)"
  })
  void testVisitConstantInstruction() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    codeAttributeEditor.visitConstantInstruction(
        clazz, method, codeAttribute, 2, new ConstantInstruction((byte) 'A', 1));

    // Assert
    assertArrayEquals(new byte[] {'A', 0, 1, 2, 'A', 2, 'A', 2}, codeAttribute.code);
  }

  /**
   * Test {@link CodeAttributeEditor#visitVariableInstruction(Clazz, Method, CodeAttribute, int,
   * VariableInstruction)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then calls {@link Instruction#write(byte[], int)}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitVariableInstruction(Clazz, Method,
   * CodeAttribute, int, VariableInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction); given three; then calls write(byte[], int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitVariableInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.VariableInstruction)"
  })
  void testVisitVariableInstruction_givenThree_thenCallsWrite() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    VariableInstruction variableInstruction = mock(VariableInstruction.class);
    when(variableInstruction.length(anyInt())).thenReturn(3);
    doNothing().when(variableInstruction).write(Mockito.<byte[]>any(), anyInt());

    // Act
    codeAttributeEditor.visitVariableInstruction(
        clazz, method, codeAttribute, 2, variableInstruction);

    // Assert
    verify(variableInstruction).write(isA(byte[].class), eq(0));
    verify(variableInstruction).length(eq(0));
  }

  /**
   * Test {@link CodeAttributeEditor#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @DisplayName("Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitBranchInstruction(
                clazz,
                method,
                codeAttribute,
                2,
                new BranchInstruction((byte) 'A', InstructionSequenceReplacer.STRING_A_LENGTH)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <ul>
   *   <li>When {@code -16777216}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction); when '-16777216'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction_when16777216_thenThrowIllegalArgumentException() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitBranchInstruction(
                clazz, method, codeAttribute, -16777216, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <ul>
   *   <li>When {@link InstructionSequenceReplacer#STRING_A_LENGTH}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction); when STRING_A_LENGTH; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction_whenString_a_length_thenThrowIllegalArgumentException() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitBranchInstruction(
                clazz,
                method,
                codeAttribute,
                InstructionSequenceReplacer.STRING_A_LENGTH,
                new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction); when two; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction_whenTwo_thenThrowIllegalArgumentException() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitBranchInstruction(
                clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitTableSwitchInstruction(Clazz, Method, CodeAttribute, int,
   * TableSwitchInstruction)}.
   *
   * <ul>
   *   <li>When {@code -16777216}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitTableSwitchInstruction(Clazz, Method,
   * CodeAttribute, int, TableSwitchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitTableSwitchInstruction(Clazz, Method, CodeAttribute, int, TableSwitchInstruction); when '-16777216'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitTableSwitchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.TableSwitchInstruction)"
  })
  void testVisitTableSwitchInstruction_when16777216_thenThrowIllegalArgumentException() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitTableSwitchInstruction(
                clazz, method, codeAttribute, -16777216, new TableSwitchInstruction()));
  }

  /**
   * Test {@link CodeAttributeEditor#visitTableSwitchInstruction(Clazz, Method, CodeAttribute, int,
   * TableSwitchInstruction)}.
   *
   * <ul>
   *   <li>When {@link InstructionSequenceReplacer#STRING_A_LENGTH}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitTableSwitchInstruction(Clazz, Method,
   * CodeAttribute, int, TableSwitchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitTableSwitchInstruction(Clazz, Method, CodeAttribute, int, TableSwitchInstruction); when STRING_A_LENGTH")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitTableSwitchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.TableSwitchInstruction)"
  })
  void testVisitTableSwitchInstruction_whenString_a_length() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitTableSwitchInstruction(
                clazz,
                method,
                codeAttribute,
                InstructionSequenceReplacer.STRING_A_LENGTH,
                new TableSwitchInstruction()));
  }

  /**
   * Test {@link CodeAttributeEditor#visitTableSwitchInstruction(Clazz, Method, CodeAttribute, int,
   * TableSwitchInstruction)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitTableSwitchInstruction(Clazz, Method,
   * CodeAttribute, int, TableSwitchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitTableSwitchInstruction(Clazz, Method, CodeAttribute, int, TableSwitchInstruction); when two; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitTableSwitchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.TableSwitchInstruction)"
  })
  void testVisitTableSwitchInstruction_whenTwo_thenThrowIllegalArgumentException() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitTableSwitchInstruction(
                clazz, method, codeAttribute, 2, new TableSwitchInstruction()));
  }

  /**
   * Test {@link CodeAttributeEditor#visitLookUpSwitchInstruction(Clazz, Method, CodeAttribute, int,
   * LookUpSwitchInstruction)}.
   *
   * <ul>
   *   <li>When {@code -16777216}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitLookUpSwitchInstruction(Clazz, Method,
   * CodeAttribute, int, LookUpSwitchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitLookUpSwitchInstruction(Clazz, Method, CodeAttribute, int, LookUpSwitchInstruction); when '-16777216'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitLookUpSwitchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.LookUpSwitchInstruction)"
  })
  void testVisitLookUpSwitchInstruction_when16777216_thenThrowIllegalArgumentException() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitLookUpSwitchInstruction(
                clazz, method, codeAttribute, -16777216, new LookUpSwitchInstruction()));
  }

  /**
   * Test {@link CodeAttributeEditor#visitLookUpSwitchInstruction(Clazz, Method, CodeAttribute, int,
   * LookUpSwitchInstruction)}.
   *
   * <ul>
   *   <li>When {@link InstructionSequenceReplacer#STRING_A_LENGTH}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitLookUpSwitchInstruction(Clazz, Method,
   * CodeAttribute, int, LookUpSwitchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitLookUpSwitchInstruction(Clazz, Method, CodeAttribute, int, LookUpSwitchInstruction); when STRING_A_LENGTH")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitLookUpSwitchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.LookUpSwitchInstruction)"
  })
  void testVisitLookUpSwitchInstruction_whenString_a_length() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitLookUpSwitchInstruction(
                clazz,
                method,
                codeAttribute,
                InstructionSequenceReplacer.STRING_A_LENGTH,
                new LookUpSwitchInstruction()));
  }

  /**
   * Test {@link CodeAttributeEditor#visitLookUpSwitchInstruction(Clazz, Method, CodeAttribute, int,
   * LookUpSwitchInstruction)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitLookUpSwitchInstruction(Clazz, Method,
   * CodeAttribute, int, LookUpSwitchInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitLookUpSwitchInstruction(Clazz, Method, CodeAttribute, int, LookUpSwitchInstruction); when two; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitLookUpSwitchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.LookUpSwitchInstruction)"
  })
  void testVisitLookUpSwitchInstruction_whenTwo_thenThrowIllegalArgumentException() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitLookUpSwitchInstruction(
                clazz, method, codeAttribute, 2, new LookUpSwitchInstruction()));
  }

  /**
   * Test {@link CodeAttributeEditor#visitExceptionInfo(Clazz, Method, CodeAttribute,
   * ExceptionInfo)}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitExceptionInfo(Clazz, Method,
   * CodeAttribute, ExceptionInfo)}
   */
  @Test
  @DisplayName("Test visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitExceptionInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.ExceptionInfo)"
  })
  void testVisitExceptionInfo() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitExceptionInfo(
                clazz, method, codeAttribute, new ExceptionInfo(1, 3, 1, 1)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitExceptionInfo(Clazz, Method, CodeAttribute,
   * ExceptionInfo)}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitExceptionInfo(Clazz, Method,
   * CodeAttribute, ExceptionInfo)}
   */
  @Test
  @DisplayName("Test visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitExceptionInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.ExceptionInfo)"
  })
  void testVisitExceptionInfo2() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitExceptionInfo(
                clazz, method, codeAttribute, new ExceptionInfo(-16777216, 3, 1, 1)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitExceptionInfo(Clazz, Method, CodeAttribute,
   * ExceptionInfo)}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitExceptionInfo(Clazz, Method,
   * CodeAttribute, ExceptionInfo)}
   */
  @Test
  @DisplayName("Test visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitExceptionInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.ExceptionInfo)"
  })
  void testVisitExceptionInfo3() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitExceptionInfo(
                clazz,
                method,
                codeAttribute,
                new ExceptionInfo(InstructionSequenceReplacer.STRING_A_LENGTH, 3, 1, 1)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitExceptionInfo(Clazz, Method, CodeAttribute,
   * ExceptionInfo)}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitExceptionInfo(Clazz, Method,
   * CodeAttribute, ExceptionInfo)}
   */
  @Test
  @DisplayName("Test visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitExceptionInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.ExceptionInfo)"
  })
  void testVisitExceptionInfo4() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitExceptionInfo(
                clazz, method, codeAttribute, new ExceptionInfo(0, 3, 1, 1)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitAnyStackMapFrame(Clazz, Method, CodeAttribute, int,
   * StackMapFrame)}.
   *
   * <ul>
   *   <li>When {@code -16777216}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitAnyStackMapFrame(Clazz, Method,
   * CodeAttribute, int, StackMapFrame)}
   */
  @Test
  @DisplayName(
      "Test visitAnyStackMapFrame(Clazz, Method, CodeAttribute, int, StackMapFrame); when '-16777216'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitAnyStackMapFrame(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.StackMapFrame)"
  })
  void testVisitAnyStackMapFrame_when16777216_thenThrowIllegalArgumentException() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitAnyStackMapFrame(
                clazz, method, codeAttribute, -16777216, new FullFrame()));
  }

  /**
   * Test {@link CodeAttributeEditor#visitAnyStackMapFrame(Clazz, Method, CodeAttribute, int,
   * StackMapFrame)}.
   *
   * <ul>
   *   <li>When {@link InstructionSequenceReplacer#STRING_A_LENGTH}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitAnyStackMapFrame(Clazz, Method,
   * CodeAttribute, int, StackMapFrame)}
   */
  @Test
  @DisplayName(
      "Test visitAnyStackMapFrame(Clazz, Method, CodeAttribute, int, StackMapFrame); when STRING_A_LENGTH; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitAnyStackMapFrame(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.StackMapFrame)"
  })
  void testVisitAnyStackMapFrame_whenString_a_length_thenThrowIllegalArgumentException() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitAnyStackMapFrame(
                clazz,
                method,
                codeAttribute,
                InstructionSequenceReplacer.STRING_A_LENGTH,
                new FullFrame()));
  }

  /**
   * Test {@link CodeAttributeEditor#visitAnyStackMapFrame(Clazz, Method, CodeAttribute, int,
   * StackMapFrame)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitAnyStackMapFrame(Clazz, Method,
   * CodeAttribute, int, StackMapFrame)}
   */
  @Test
  @DisplayName(
      "Test visitAnyStackMapFrame(Clazz, Method, CodeAttribute, int, StackMapFrame); when two; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitAnyStackMapFrame(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.StackMapFrame)"
  })
  void testVisitAnyStackMapFrame_whenTwo_thenThrowIllegalArgumentException() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitAnyStackMapFrame(
                clazz, method, codeAttribute, 2, new FullFrame()));
  }

  /**
   * Test {@link CodeAttributeEditor#visitSameOneFrame(Clazz, Method, CodeAttribute, int,
   * SameOneFrame)}.
   *
   * <ul>
   *   <li>When {@code -16777216}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitSameOneFrame(Clazz, Method,
   * CodeAttribute, int, SameOneFrame)}
   */
  @Test
  @DisplayName(
      "Test visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame); when '-16777216'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitSameOneFrame(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.SameOneFrame)"
  })
  void testVisitSameOneFrame_when16777216_thenThrowIllegalArgumentException() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitSameOneFrame(
                clazz, method, codeAttribute, -16777216, new SameOneFrame(1)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitSameOneFrame(Clazz, Method, CodeAttribute, int,
   * SameOneFrame)}.
   *
   * <ul>
   *   <li>When {@link InstructionSequenceReplacer#STRING_A_LENGTH}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitSameOneFrame(Clazz, Method,
   * CodeAttribute, int, SameOneFrame)}
   */
  @Test
  @DisplayName(
      "Test visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame); when STRING_A_LENGTH; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitSameOneFrame(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.SameOneFrame)"
  })
  void testVisitSameOneFrame_whenString_a_length_thenThrowIllegalArgumentException() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitSameOneFrame(
                clazz,
                method,
                codeAttribute,
                InstructionSequenceReplacer.STRING_A_LENGTH,
                new SameOneFrame(1)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitSameOneFrame(Clazz, Method, CodeAttribute, int,
   * SameOneFrame)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitSameOneFrame(Clazz, Method,
   * CodeAttribute, int, SameOneFrame)}
   */
  @Test
  @DisplayName(
      "Test visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame); when two; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitSameOneFrame(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.SameOneFrame)"
  })
  void testVisitSameOneFrame_whenTwo_thenThrowIllegalArgumentException() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitSameOneFrame(
                clazz, method, codeAttribute, 2, new SameOneFrame(1)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitMoreZeroFrame(Clazz, Method, CodeAttribute, int,
   * MoreZeroFrame)}.
   *
   * <ul>
   *   <li>When {@code -16777216}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitMoreZeroFrame(Clazz, Method,
   * CodeAttribute, int, MoreZeroFrame)}
   */
  @Test
  @DisplayName(
      "Test visitMoreZeroFrame(Clazz, Method, CodeAttribute, int, MoreZeroFrame); when '-16777216'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitMoreZeroFrame(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.MoreZeroFrame)"
  })
  void testVisitMoreZeroFrame_when16777216_thenThrowIllegalArgumentException() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitMoreZeroFrame(
                clazz, method, codeAttribute, -16777216, new MoreZeroFrame(1)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitMoreZeroFrame(Clazz, Method, CodeAttribute, int,
   * MoreZeroFrame)}.
   *
   * <ul>
   *   <li>When {@link InstructionSequenceReplacer#STRING_A_LENGTH}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitMoreZeroFrame(Clazz, Method,
   * CodeAttribute, int, MoreZeroFrame)}
   */
  @Test
  @DisplayName(
      "Test visitMoreZeroFrame(Clazz, Method, CodeAttribute, int, MoreZeroFrame); when STRING_A_LENGTH; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitMoreZeroFrame(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.MoreZeroFrame)"
  })
  void testVisitMoreZeroFrame_whenString_a_length_thenThrowIllegalArgumentException() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitMoreZeroFrame(
                clazz,
                method,
                codeAttribute,
                InstructionSequenceReplacer.STRING_A_LENGTH,
                new MoreZeroFrame(1)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitMoreZeroFrame(Clazz, Method, CodeAttribute, int,
   * MoreZeroFrame)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitMoreZeroFrame(Clazz, Method,
   * CodeAttribute, int, MoreZeroFrame)}
   */
  @Test
  @DisplayName(
      "Test visitMoreZeroFrame(Clazz, Method, CodeAttribute, int, MoreZeroFrame); when two; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitMoreZeroFrame(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.MoreZeroFrame)"
  })
  void testVisitMoreZeroFrame_whenTwo_thenThrowIllegalArgumentException() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitMoreZeroFrame(
                clazz, method, codeAttribute, 2, new MoreZeroFrame(1)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitFullFrame(Clazz, Method, CodeAttribute, int, FullFrame)}.
   *
   * <ul>
   *   <li>When {@code -16777216}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitFullFrame(Clazz, Method, CodeAttribute,
   * int, FullFrame)}
   */
  @Test
  @DisplayName(
      "Test visitFullFrame(Clazz, Method, CodeAttribute, int, FullFrame); when '-16777216'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitFullFrame(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.FullFrame)"
  })
  void testVisitFullFrame_when16777216_thenThrowIllegalArgumentException() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitFullFrame(
                clazz, method, codeAttribute, -16777216, new FullFrame()));
  }

  /**
   * Test {@link CodeAttributeEditor#visitFullFrame(Clazz, Method, CodeAttribute, int, FullFrame)}.
   *
   * <ul>
   *   <li>When {@link InstructionSequenceReplacer#STRING_A_LENGTH}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitFullFrame(Clazz, Method, CodeAttribute,
   * int, FullFrame)}
   */
  @Test
  @DisplayName(
      "Test visitFullFrame(Clazz, Method, CodeAttribute, int, FullFrame); when STRING_A_LENGTH; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitFullFrame(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.FullFrame)"
  })
  void testVisitFullFrame_whenString_a_length_thenThrowIllegalArgumentException() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitFullFrame(
                clazz,
                method,
                codeAttribute,
                InstructionSequenceReplacer.STRING_A_LENGTH,
                new FullFrame()));
  }

  /**
   * Test {@link CodeAttributeEditor#visitFullFrame(Clazz, Method, CodeAttribute, int, FullFrame)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitFullFrame(Clazz, Method, CodeAttribute,
   * int, FullFrame)}
   */
  @Test
  @DisplayName(
      "Test visitFullFrame(Clazz, Method, CodeAttribute, int, FullFrame); when two; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitFullFrame(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.FullFrame)"
  })
  void testVisitFullFrame_whenTwo_thenThrowIllegalArgumentException() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> codeAttributeEditor.visitFullFrame(clazz, method, codeAttribute, 2, new FullFrame()));
  }

  /**
   * Test {@link CodeAttributeEditor#visitUninitializedType(Clazz, Method, CodeAttribute, int,
   * UninitializedType)}.
   *
   * <ul>
   *   <li>When createUninitializedType {@code -16777216}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitUninitializedType(Clazz, Method,
   * CodeAttribute, int, UninitializedType)}
   */
  @Test
  @DisplayName(
      "Test visitUninitializedType(Clazz, Method, CodeAttribute, int, UninitializedType); when createUninitializedType '-16777216'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitUninitializedType(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.UninitializedType)"
  })
  void testVisitUninitializedType_whenCreateUninitializedType16777216() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitUninitializedType(
                clazz,
                method,
                codeAttribute,
                2,
                VerificationTypeFactory.createUninitializedType(-16777216)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitUninitializedType(Clazz, Method, CodeAttribute, int,
   * UninitializedType)}.
   *
   * <ul>
   *   <li>When createUninitializedType one.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitUninitializedType(Clazz, Method,
   * CodeAttribute, int, UninitializedType)}
   */
  @Test
  @DisplayName(
      "Test visitUninitializedType(Clazz, Method, CodeAttribute, int, UninitializedType); when createUninitializedType one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitUninitializedType(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.UninitializedType)"
  })
  void testVisitUninitializedType_whenCreateUninitializedTypeOne() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitUninitializedType(
                clazz,
                method,
                codeAttribute,
                2,
                VerificationTypeFactory.createUninitializedType(1)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitUninitializedType(Clazz, Method, CodeAttribute, int,
   * UninitializedType)}.
   *
   * <ul>
   *   <li>When createUninitializedType {@link InstructionSequenceReplacer#STRING_A_LENGTH}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitUninitializedType(Clazz, Method,
   * CodeAttribute, int, UninitializedType)}
   */
  @Test
  @DisplayName(
      "Test visitUninitializedType(Clazz, Method, CodeAttribute, int, UninitializedType); when createUninitializedType STRING_A_LENGTH")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitUninitializedType(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.UninitializedType)"
  })
  void testVisitUninitializedType_whenCreateUninitializedTypeString_a_length() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitUninitializedType(
                clazz,
                method,
                codeAttribute,
                2,
                VerificationTypeFactory.createUninitializedType(
                    InstructionSequenceReplacer.STRING_A_LENGTH)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitLineNumberInfo(Clazz, Method, CodeAttribute,
   * LineNumberInfo)}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitLineNumberInfo(Clazz, Method,
   * CodeAttribute, LineNumberInfo)}
   */
  @Test
  @DisplayName("Test visitLineNumberInfo(Clazz, Method, CodeAttribute, LineNumberInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitLineNumberInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LineNumberInfo)"
  })
  void testVisitLineNumberInfo() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitLineNumberInfo(
                clazz, method, codeAttribute, new LineNumberInfo(-16777216, 2)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitLineNumberInfo(Clazz, Method, CodeAttribute,
   * LineNumberInfo)}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitLineNumberInfo(Clazz, Method,
   * CodeAttribute, LineNumberInfo)}
   */
  @Test
  @DisplayName("Test visitLineNumberInfo(Clazz, Method, CodeAttribute, LineNumberInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitLineNumberInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LineNumberInfo)"
  })
  void testVisitLineNumberInfo2() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitLineNumberInfo(
                clazz,
                method,
                codeAttribute,
                new LineNumberInfo(InstructionSequenceReplacer.STRING_A_LENGTH, 2)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitLineNumberInfo(Clazz, Method, CodeAttribute,
   * LineNumberInfo)}.
   *
   * <ul>
   *   <li>When {@link LineNumberInfo#LineNumberInfo(int, int)} with u2startPC is one and
   *       u2lineNumber is two.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitLineNumberInfo(Clazz, Method,
   * CodeAttribute, LineNumberInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLineNumberInfo(Clazz, Method, CodeAttribute, LineNumberInfo); when LineNumberInfo(int, int) with u2startPC is one and u2lineNumber is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitLineNumberInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LineNumberInfo)"
  })
  void testVisitLineNumberInfo_whenLineNumberInfoWithU2startPCIsOneAndU2lineNumberIsTwo() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitLineNumberInfo(
                clazz, method, codeAttribute, new LineNumberInfo(1, 2)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitLocalVariableInfo(Clazz, Method, CodeAttribute,
   * LocalVariableInfo)}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitLocalVariableInfo(Clazz, Method,
   * CodeAttribute, LocalVariableInfo)}
   */
  @Test
  @DisplayName("Test visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitLocalVariableInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableInfo)"
  })
  void testVisitLocalVariableInfo() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitLocalVariableInfo(
                clazz, method, codeAttribute, new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitLocalVariableInfo(Clazz, Method, CodeAttribute,
   * LocalVariableInfo)}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitLocalVariableInfo(Clazz, Method,
   * CodeAttribute, LocalVariableInfo)}
   */
  @Test
  @DisplayName("Test visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitLocalVariableInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableInfo)"
  })
  void testVisitLocalVariableInfo2() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitLocalVariableInfo(
                clazz, method, codeAttribute, new LocalVariableInfo(-16777216, 3, 1, 1, 1)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitLocalVariableInfo(Clazz, Method, CodeAttribute,
   * LocalVariableInfo)}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitLocalVariableInfo(Clazz, Method,
   * CodeAttribute, LocalVariableInfo)}
   */
  @Test
  @DisplayName("Test visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitLocalVariableInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableInfo)"
  })
  void testVisitLocalVariableInfo3() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitLocalVariableInfo(
                clazz,
                method,
                codeAttribute,
                new LocalVariableInfo(InstructionSequenceReplacer.STRING_A_LENGTH, 3, 1, 1, 1)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitLocalVariableInfo(Clazz, Method, CodeAttribute,
   * LocalVariableInfo)}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitLocalVariableInfo(Clazz, Method,
   * CodeAttribute, LocalVariableInfo)}
   */
  @Test
  @DisplayName("Test visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitLocalVariableInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableInfo)"
  })
  void testVisitLocalVariableInfo4() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitLocalVariableInfo(
                clazz, method, codeAttribute, new LocalVariableInfo(1, -1, 1, 1, 1)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute,
   * LocalVariableTypeInfo)}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitLocalVariableTypeInfo(Clazz, Method,
   * CodeAttribute, LocalVariableTypeInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitLocalVariableTypeInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeInfo)"
  })
  void testVisitLocalVariableTypeInfo() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitLocalVariableTypeInfo(
                clazz, method, codeAttribute, new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute,
   * LocalVariableTypeInfo)}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitLocalVariableTypeInfo(Clazz, Method,
   * CodeAttribute, LocalVariableTypeInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitLocalVariableTypeInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeInfo)"
  })
  void testVisitLocalVariableTypeInfo2() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitLocalVariableTypeInfo(
                clazz, method, codeAttribute, new LocalVariableTypeInfo(-16777216, 3, 1, 1, 1)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute,
   * LocalVariableTypeInfo)}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitLocalVariableTypeInfo(Clazz, Method,
   * CodeAttribute, LocalVariableTypeInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitLocalVariableTypeInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeInfo)"
  })
  void testVisitLocalVariableTypeInfo3() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitLocalVariableTypeInfo(
                clazz,
                method,
                codeAttribute,
                new LocalVariableTypeInfo(
                    InstructionSequenceReplacer.STRING_A_LENGTH, 3, 1, 1, 1)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute,
   * LocalVariableTypeInfo)}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitLocalVariableTypeInfo(Clazz, Method,
   * CodeAttribute, LocalVariableTypeInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitLocalVariableTypeInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeInfo)"
  })
  void testVisitLocalVariableTypeInfo4() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitLocalVariableTypeInfo(
                clazz, method, codeAttribute, new LocalVariableTypeInfo(1, -1, 1, 1, 1)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitTypeAnnotation(Clazz, TypeAnnotation)} with {@code clazz},
   * {@code typeAnnotation}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitTypeAnnotation(Clazz, TypeAnnotation)}
   */
  @Test
  @DisplayName(
      "Test visitTypeAnnotation(Clazz, TypeAnnotation) with 'clazz', 'typeAnnotation'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitTypeAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.TypeAnnotation)"
  })
  void testVisitTypeAnnotationWithClazzTypeAnnotation_thenThrowIllegalArgumentException() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LocalVariableTargetInfo targetInfo =
        new LocalVariableTargetInfo(
            (byte) 'A',
            3,
            new LocalVariableTargetElement[] {new LocalVariableTargetElement(1, 3, 1)});

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitTypeAnnotation(
                clazz,
                new TypeAnnotation(
                    1,
                    3,
                    new ElementValue[] {new AnnotationElementValue()},
                    targetInfo,
                    new TypePathInfo[] {new TypePathInfo(1, 1)})));
  }

  /**
   * Test {@link CodeAttributeEditor#visitOffsetTargetInfo(Clazz, Method, CodeAttribute,
   * TypeAnnotation, OffsetTargetInfo)}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitOffsetTargetInfo(Clazz, Method,
   * CodeAttribute, TypeAnnotation, OffsetTargetInfo)}
   */
  @Test
  @DisplayName(
      "Test visitOffsetTargetInfo(Clazz, Method, CodeAttribute, TypeAnnotation, OffsetTargetInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitOffsetTargetInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.TypeAnnotation, proguard.classfile.attribute.annotation.target.OffsetTargetInfo)"
  })
  void testVisitOffsetTargetInfo() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    TypeAnnotation typeAnnotation = new TypeAnnotation();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitOffsetTargetInfo(
                clazz, method, codeAttribute, typeAnnotation, new OffsetTargetInfo((byte) 'A', 2)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitOffsetTargetInfo(Clazz, Method, CodeAttribute,
   * TypeAnnotation, OffsetTargetInfo)}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitOffsetTargetInfo(Clazz, Method,
   * CodeAttribute, TypeAnnotation, OffsetTargetInfo)}
   */
  @Test
  @DisplayName(
      "Test visitOffsetTargetInfo(Clazz, Method, CodeAttribute, TypeAnnotation, OffsetTargetInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitOffsetTargetInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.TypeAnnotation, proguard.classfile.attribute.annotation.target.OffsetTargetInfo)"
  })
  void testVisitOffsetTargetInfo2() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    TypeAnnotation typeAnnotation = new TypeAnnotation();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitOffsetTargetInfo(
                clazz,
                method,
                codeAttribute,
                typeAnnotation,
                new OffsetTargetInfo((byte) 'A', -16777216)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitOffsetTargetInfo(Clazz, Method, CodeAttribute,
   * TypeAnnotation, OffsetTargetInfo)}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitOffsetTargetInfo(Clazz, Method,
   * CodeAttribute, TypeAnnotation, OffsetTargetInfo)}
   */
  @Test
  @DisplayName(
      "Test visitOffsetTargetInfo(Clazz, Method, CodeAttribute, TypeAnnotation, OffsetTargetInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitOffsetTargetInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.TypeAnnotation, proguard.classfile.attribute.annotation.target.OffsetTargetInfo)"
  })
  void testVisitOffsetTargetInfo3() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    TypeAnnotation typeAnnotation = new TypeAnnotation();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitOffsetTargetInfo(
                clazz,
                method,
                codeAttribute,
                typeAnnotation,
                new OffsetTargetInfo((byte) 'A', InstructionSequenceReplacer.STRING_A_LENGTH)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitLocalVariableTargetElement(Clazz, Method, CodeAttribute,
   * TypeAnnotation, LocalVariableTargetInfo, LocalVariableTargetElement)}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitLocalVariableTargetElement(Clazz, Method,
   * CodeAttribute, TypeAnnotation, LocalVariableTargetInfo, LocalVariableTargetElement)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTargetElement(Clazz, Method, CodeAttribute, TypeAnnotation, LocalVariableTargetInfo, LocalVariableTargetElement)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitLocalVariableTargetElement(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.TypeAnnotation, proguard.classfile.attribute.annotation.target.LocalVariableTargetInfo, proguard.classfile.attribute.annotation.target.LocalVariableTargetElement)"
  })
  void testVisitLocalVariableTargetElement() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    TypeAnnotation typeAnnotation = new TypeAnnotation();
    LocalVariableTargetInfo localVariableTargetInfo = new LocalVariableTargetInfo((byte) 'A');

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitLocalVariableTargetElement(
                clazz,
                method,
                codeAttribute,
                typeAnnotation,
                localVariableTargetInfo,
                new LocalVariableTargetElement(1, 3, 1)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitLocalVariableTargetElement(Clazz, Method, CodeAttribute,
   * TypeAnnotation, LocalVariableTargetInfo, LocalVariableTargetElement)}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitLocalVariableTargetElement(Clazz, Method,
   * CodeAttribute, TypeAnnotation, LocalVariableTargetInfo, LocalVariableTargetElement)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTargetElement(Clazz, Method, CodeAttribute, TypeAnnotation, LocalVariableTargetInfo, LocalVariableTargetElement)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitLocalVariableTargetElement(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.TypeAnnotation, proguard.classfile.attribute.annotation.target.LocalVariableTargetInfo, proguard.classfile.attribute.annotation.target.LocalVariableTargetElement)"
  })
  void testVisitLocalVariableTargetElement2() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    TypeAnnotation typeAnnotation = new TypeAnnotation();
    LocalVariableTargetInfo localVariableTargetInfo = new LocalVariableTargetInfo((byte) 'A');

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitLocalVariableTargetElement(
                clazz,
                method,
                codeAttribute,
                typeAnnotation,
                localVariableTargetInfo,
                new LocalVariableTargetElement(-16777216, 3, 1)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitLocalVariableTargetElement(Clazz, Method, CodeAttribute,
   * TypeAnnotation, LocalVariableTargetInfo, LocalVariableTargetElement)}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitLocalVariableTargetElement(Clazz, Method,
   * CodeAttribute, TypeAnnotation, LocalVariableTargetInfo, LocalVariableTargetElement)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTargetElement(Clazz, Method, CodeAttribute, TypeAnnotation, LocalVariableTargetInfo, LocalVariableTargetElement)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitLocalVariableTargetElement(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.TypeAnnotation, proguard.classfile.attribute.annotation.target.LocalVariableTargetInfo, proguard.classfile.attribute.annotation.target.LocalVariableTargetElement)"
  })
  void testVisitLocalVariableTargetElement3() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    TypeAnnotation typeAnnotation = new TypeAnnotation();
    LocalVariableTargetInfo localVariableTargetInfo = new LocalVariableTargetInfo((byte) 'A');

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitLocalVariableTargetElement(
                clazz,
                method,
                codeAttribute,
                typeAnnotation,
                localVariableTargetInfo,
                new LocalVariableTargetElement(InstructionSequenceReplacer.STRING_A_LENGTH, 3, 1)));
  }

  /**
   * Test {@link CodeAttributeEditor#visitLocalVariableTargetElement(Clazz, Method, CodeAttribute,
   * TypeAnnotation, LocalVariableTargetInfo, LocalVariableTargetElement)}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#visitLocalVariableTargetElement(Clazz, Method,
   * CodeAttribute, TypeAnnotation, LocalVariableTargetInfo, LocalVariableTargetElement)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTargetElement(Clazz, Method, CodeAttribute, TypeAnnotation, LocalVariableTargetInfo, LocalVariableTargetElement)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditor.visitLocalVariableTargetElement(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.TypeAnnotation, proguard.classfile.attribute.annotation.target.LocalVariableTargetInfo, proguard.classfile.attribute.annotation.target.LocalVariableTargetElement)"
  })
  void testVisitLocalVariableTargetElement4() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    TypeAnnotation typeAnnotation = new TypeAnnotation();
    LocalVariableTargetInfo localVariableTargetInfo = new LocalVariableTargetInfo((byte) 'A');

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeEditor.visitLocalVariableTargetElement(
                clazz,
                method,
                codeAttribute,
                typeAnnotation,
                localVariableTargetInfo,
                new LocalVariableTargetElement(1, -1, 1)));
  }

  /**
   * Test {@link CodeAttributeEditor#label()}.
   *
   * <p>Method under test: {@link CodeAttributeEditor#label()}
   */
  @Test
  @DisplayName("Test label()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CodeAttributeEditor$Label proguard.classfile.editor.CodeAttributeEditor.label()"
  })
  void testLabel() {
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
  @DisplayName("Test label(int) with 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CodeAttributeEditor$Label proguard.classfile.editor.CodeAttributeEditor.label(int)"
  })
  void testLabelWithInt() {
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
  @DisplayName(
      "Test catch_(int, int, int, int) with 'identifier', 'startOffset', 'endOffset', 'catchType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CodeAttributeEditor$Label proguard.classfile.editor.CodeAttributeEditor.catch_(int, int, int, int)"
  })
  void testCatch_WithIdentifierStartOffsetEndOffsetCatchType() {
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
  @DisplayName("Test line(int, int, String) with 'identifier', 'lineNumber', 'source'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.CodeAttributeEditor$Label proguard.classfile.editor.CodeAttributeEditor.line(int, int, java.lang.String)"
  })
  void testLineWithIdentifierLineNumberSource() {
    // Arrange and Act
    Label actualLineResult = (new CodeAttributeEditor()).line(1, 2, "Source");

    // Assert
    assertEquals("nop", actualLineResult.getName());
    assertEquals((byte) 0, actualLineResult.opcode);
    assertEquals(1, actualLineResult.identifier);
    assertFalse(actualLineResult.isCategory2());
  }
}
