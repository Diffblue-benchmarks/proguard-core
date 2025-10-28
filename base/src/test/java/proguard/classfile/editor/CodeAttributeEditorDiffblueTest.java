package proguard.classfile.editor;

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
import proguard.classfile.attribute.annotation.TypePathInfo;
import proguard.classfile.attribute.annotation.target.CatchTargetInfo;
import proguard.classfile.attribute.annotation.target.LocalVariableTargetElement;
import proguard.classfile.attribute.annotation.target.LocalVariableTargetInfo;
import proguard.classfile.attribute.annotation.target.OffsetTargetInfo;
import proguard.classfile.attribute.annotation.target.TargetInfo;
import proguard.classfile.attribute.preverification.FullFrame;
import proguard.classfile.attribute.preverification.MoreZeroFrame;
import proguard.classfile.attribute.preverification.SameOneFrame;
import proguard.classfile.attribute.preverification.StackMapFrame;
import proguard.classfile.attribute.preverification.UninitializedType;
import proguard.classfile.attribute.preverification.VerificationType;
import proguard.classfile.attribute.preverification.VerificationTypeFactory;
import proguard.classfile.attribute.visitor.MaxStackSizeComputer;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.instruction.LookUpSwitchInstruction;
import proguard.classfile.instruction.TableSwitchInstruction;
import proguard.classfile.instruction.visitor.InstructionVisitor;

public class CodeAttributeEditorDiffblueTest {
  /**
   * Method under test:
   * {@link CodeAttributeEditor#insertBeforeOffset(int, Instruction)}
   */
  @Test
  public void testInsertBeforeOffset() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> codeAttributeEditor.insertBeforeOffset(1, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#insertBeforeOffset(int, Instruction)}
   */
  @Test
  public void testInsertBeforeOffset2() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> codeAttributeEditor.insertBeforeOffset(-16777216, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#insertBeforeOffset(int, Instruction[])}
   */
  @Test
  public void testInsertBeforeOffset3() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> codeAttributeEditor.insertBeforeOffset(1, new Instruction[]{new BranchInstruction((byte) 'A', 1)}));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#insertBeforeOffset(int, Instruction[])}
   */
  @Test
  public void testInsertBeforeOffset4() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.insertBeforeOffset(-16777216,
        new Instruction[]{new BranchInstruction((byte) 'A', 1)}));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#insertBeforeInstruction(int, Instruction)}
   */
  @Test
  public void testInsertBeforeInstruction() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> codeAttributeEditor.insertBeforeInstruction(1, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#insertBeforeInstruction(int, Instruction)}
   */
  @Test
  public void testInsertBeforeInstruction2() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> codeAttributeEditor.insertBeforeInstruction(-16777216, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#insertBeforeInstruction(int, Instruction[])}
   */
  @Test
  public void testInsertBeforeInstruction3() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> codeAttributeEditor.insertBeforeInstruction(1, new Instruction[]{new BranchInstruction((byte) 'A', 1)}));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#insertBeforeInstruction(int, Instruction[])}
   */
  @Test
  public void testInsertBeforeInstruction4() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.insertBeforeInstruction(-16777216,
        new Instruction[]{new BranchInstruction((byte) 'A', 1)}));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor.Label#accept(Clazz, Method, CodeAttribute, int, InstructionVisitor)}
   */
  @Test
  public void testLabelAccept() {
    // Arrange
    CodeAttributeEditor.Label label = new CodeAttributeEditor.Label(1);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> label.accept(clazz, method, codeAttribute, 2, new MaxStackSizeComputer()));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CodeAttributeEditor.Label#equals(Object)}
   *   <li>{@link CodeAttributeEditor.Label#hashCode()}
   * </ul>
   */
  @Test
  public void testLabelEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CodeAttributeEditor.Label label = new CodeAttributeEditor.Label(1);
    CodeAttributeEditor.Label label2 = new CodeAttributeEditor.Label(1);

    // Act and Assert
    assertEquals(label, label2);
    int expectedHashCodeResult = label.hashCode();
    assertEquals(expectedHashCodeResult, label2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CodeAttributeEditor.Label#equals(Object)}
   *   <li>{@link CodeAttributeEditor.Label#hashCode()}
   * </ul>
   */
  @Test
  public void testLabelEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CodeAttributeEditor.Label label = new CodeAttributeEditor.Label(1);

    // Act and Assert
    assertEquals(label, label);
    int expectedHashCodeResult = label.hashCode();
    assertEquals(expectedHashCodeResult, label.hashCode());
  }

  /**
   * Method under test: {@link CodeAttributeEditor.Label#equals(Object)}
   */
  @Test
  public void testLabelEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CodeAttributeEditor.Label label = new CodeAttributeEditor.Label(2);

    // Act and Assert
    assertNotEquals(label, new CodeAttributeEditor.Label(1));
  }

  /**
   * Method under test: {@link CodeAttributeEditor.Label#equals(Object)}
   */
  @Test
  public void testLabelEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CodeAttributeEditor.Label label = new CodeAttributeEditor.Label(1);
    label.length(2);

    // Act and Assert
    assertNotEquals(label, new CodeAttributeEditor.Label(1));
  }

  /**
   * Method under test: {@link CodeAttributeEditor.Label#equals(Object)}
   */
  @Test
  public void testLabelEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CodeAttributeEditor.Label(1), null);
  }

  /**
   * Method under test: {@link CodeAttributeEditor.Label#equals(Object)}
   */
  @Test
  public void testLabelEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CodeAttributeEditor.Label(1), "Different type to Label");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CodeAttributeEditor.Label#Label(int)}
   *   <li>{@link CodeAttributeEditor.Label#length(int)}
   *   <li>{@link CodeAttributeEditor.Label#write(byte[], int)}
   *   <li>{@link CodeAttributeEditor.Label#toString()}
   * </ul>
   */
  @Test
  public void testLabelGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    CodeAttributeEditor.Label actualLabel = new CodeAttributeEditor.Label(1);
    int actualLengthResult = actualLabel.length(2);
    actualLabel.write("AXAXAXAX".getBytes("UTF-8"), 2);

    // Assert
    assertEquals("label_536870913", actualLabel.toString());
    assertEquals(0, actualLengthResult);
  }

  /**
   * Method under test: {@link CodeAttributeEditor.Label#offset()}
   */
  @Test
  public void testLabelOffset() {
    // Arrange, Act and Assert
    assertEquals(InstructionSequenceReplacer.CLASS_A_NAME, (new CodeAttributeEditor.Label(1)).offset());
  }

  /**
   * Method under test: {@link CodeAttributeEditor.Label#readInfo(byte[], int)}
   */
  @Test
  public void testLabelReadInfo() throws UnsupportedEncodingException {
    // Arrange
    CodeAttributeEditor.Label label = new CodeAttributeEditor.Label(1);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> label.readInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Method under test: {@link CodeAttributeEditor.Label#shrink()}
   */
  @Test
  public void testLabelShrink() {
    // Arrange
    CodeAttributeEditor.Label label = new CodeAttributeEditor.Label(1);

    // Act and Assert
    assertSame(label, label.shrink());
  }

  /**
   * Method under test: {@link CodeAttributeEditor.Label#writeInfo(byte[], int)}
   */
  @Test
  public void testLabelWriteInfo() throws UnsupportedEncodingException {
    // Arrange
    CodeAttributeEditor.Label label = new CodeAttributeEditor.Label(1);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> label.writeInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#replaceInstruction(int, Instruction)}
   */
  @Test
  public void testReplaceInstruction() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> codeAttributeEditor.replaceInstruction(1, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#replaceInstruction(int, Instruction)}
   */
  @Test
  public void testReplaceInstruction2() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> codeAttributeEditor.replaceInstruction(-16777216, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#replaceInstruction(int, Instruction[])}
   */
  @Test
  public void testReplaceInstruction3() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> codeAttributeEditor.replaceInstruction(1, new Instruction[]{new BranchInstruction((byte) 'A', 1)}));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#replaceInstruction(int, Instruction[])}
   */
  @Test
  public void testReplaceInstruction4() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.replaceInstruction(-16777216,
        new Instruction[]{new BranchInstruction((byte) 'A', 1)}));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#insertAfterInstruction(int, Instruction)}
   */
  @Test
  public void testInsertAfterInstruction() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> codeAttributeEditor.insertAfterInstruction(1, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#insertAfterInstruction(int, Instruction)}
   */
  @Test
  public void testInsertAfterInstruction2() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> codeAttributeEditor.insertAfterInstruction(-16777216, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#insertAfterInstruction(int, Instruction[])}
   */
  @Test
  public void testInsertAfterInstruction3() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> codeAttributeEditor.insertAfterInstruction(1, new Instruction[]{new BranchInstruction((byte) 'A', 1)}));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#insertAfterInstruction(int, Instruction[])}
   */
  @Test
  public void testInsertAfterInstruction4() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.insertAfterInstruction(-16777216,
        new Instruction[]{new BranchInstruction((byte) 'A', 1)}));
  }

  /**
   * Method under test: {@link CodeAttributeEditor#deleteInstruction(int)}
   */
  @Test
  public void testDeleteInstruction() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new CodeAttributeEditor()).deleteInstruction(1));
    assertThrows(IllegalArgumentException.class, () -> (new CodeAttributeEditor()).deleteInstruction(-1));
  }

  /**
   * Method under test: {@link CodeAttributeEditor#undeleteInstruction(int)}
   */
  @Test
  public void testUndeleteInstruction() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new CodeAttributeEditor()).undeleteInstruction(1));
    assertThrows(IllegalArgumentException.class, () -> (new CodeAttributeEditor()).undeleteInstruction(-1));
  }

  /**
   * Method under test: {@link CodeAttributeEditor#clearModifications(int)}
   */
  @Test
  public void testClearModifications() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new CodeAttributeEditor()).clearModifications(1));
    assertThrows(IllegalArgumentException.class, () -> (new CodeAttributeEditor()).clearModifications(-1));
  }

  /**
   * Method under test: {@link CodeAttributeEditor#isModified(int)}
   */
  @Test
  public void testIsModified() {
    // Arrange, Act and Assert
    assertFalse((new CodeAttributeEditor()).isModified(1));
  }

  /**
   * Method under test: {@link CodeAttributeEditor#getNewOffset(int)}
   */
  @Test
  public void testGetNewOffset() {
    // Arrange, Act and Assert
    assertEquals(0, (new CodeAttributeEditor()).getNewOffset(1));
    assertThrows(IllegalArgumentException.class, () -> (new CodeAttributeEditor()).getNewOffset(-1));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction)}
   */
  @Test
  public void testVisitConstantInstruction() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    codeAttributeEditor.visitConstantInstruction(clazz, method, codeAttribute, 2,
        new ConstantInstruction((byte) 'A', 1));

    // Assert
    byte[] byteArray = codeAttribute.code;
    assertEquals((byte) 0, byteArray[1]);
    assertEquals((byte) 1, byteArray[2]);
    assertEquals(8, byteArray.length);
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)}
   */
  @Test
  public void testVisitBranchInstruction() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitBranchInstruction(clazz, method,
        codeAttribute, 2, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)}
   */
  @Test
  public void testVisitBranchInstruction2() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitBranchInstruction(clazz, method,
        codeAttribute, -16777216, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)}
   */
  @Test
  public void testVisitBranchInstruction3() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitBranchInstruction(clazz, method,
        codeAttribute, InstructionSequenceReplacer.STRING_A_LENGTH, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)}
   */
  @Test
  public void testVisitBranchInstruction4() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitBranchInstruction(clazz, method,
        codeAttribute, 2, new BranchInstruction((byte) 'A', InstructionSequenceReplacer.STRING_A_LENGTH)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitTableSwitchInstruction(Clazz, Method, CodeAttribute, int, TableSwitchInstruction)}
   */
  @Test
  public void testVisitTableSwitchInstruction() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitTableSwitchInstruction(clazz, method,
        codeAttribute, 2, new TableSwitchInstruction()));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitTableSwitchInstruction(Clazz, Method, CodeAttribute, int, TableSwitchInstruction)}
   */
  @Test
  public void testVisitTableSwitchInstruction2() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitTableSwitchInstruction(clazz, method,
        codeAttribute, -16777216, new TableSwitchInstruction()));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitTableSwitchInstruction(Clazz, Method, CodeAttribute, int, TableSwitchInstruction)}
   */
  @Test
  public void testVisitTableSwitchInstruction3() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitTableSwitchInstruction(clazz, method,
        codeAttribute, InstructionSequenceReplacer.STRING_A_LENGTH, new TableSwitchInstruction()));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitLookUpSwitchInstruction(Clazz, Method, CodeAttribute, int, LookUpSwitchInstruction)}
   */
  @Test
  public void testVisitLookUpSwitchInstruction() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitLookUpSwitchInstruction(clazz, method,
        codeAttribute, 2, new LookUpSwitchInstruction()));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitLookUpSwitchInstruction(Clazz, Method, CodeAttribute, int, LookUpSwitchInstruction)}
   */
  @Test
  public void testVisitLookUpSwitchInstruction2() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitLookUpSwitchInstruction(clazz, method,
        codeAttribute, -16777216, new LookUpSwitchInstruction()));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitLookUpSwitchInstruction(Clazz, Method, CodeAttribute, int, LookUpSwitchInstruction)}
   */
  @Test
  public void testVisitLookUpSwitchInstruction3() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitLookUpSwitchInstruction(clazz, method,
        codeAttribute, InstructionSequenceReplacer.STRING_A_LENGTH, new LookUpSwitchInstruction()));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)}
   */
  @Test
  public void testVisitExceptionInfo() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> codeAttributeEditor.visitExceptionInfo(clazz, method, codeAttribute, new ExceptionInfo(1, 3, 1, 1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)}
   */
  @Test
  public void testVisitExceptionInfo2() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitExceptionInfo(clazz, method,
        codeAttribute, new ExceptionInfo(-16777216, 3, 1, 1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)}
   */
  @Test
  public void testVisitExceptionInfo3() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitExceptionInfo(clazz, method,
        codeAttribute, new ExceptionInfo(InstructionSequenceReplacer.STRING_A_LENGTH, 3, 1, 1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)}
   */
  @Test
  public void testVisitExceptionInfo4() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> codeAttributeEditor.visitExceptionInfo(clazz, method, codeAttribute, new ExceptionInfo(0, 3, 1, 1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitAnyStackMapFrame(Clazz, Method, CodeAttribute, int, StackMapFrame)}
   */
  @Test
  public void testVisitAnyStackMapFrame() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> codeAttributeEditor.visitAnyStackMapFrame(clazz, method, codeAttribute, 2, new FullFrame()));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitAnyStackMapFrame(Clazz, Method, CodeAttribute, int, StackMapFrame)}
   */
  @Test
  public void testVisitAnyStackMapFrame2() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> codeAttributeEditor.visitAnyStackMapFrame(clazz, method, codeAttribute, -16777216, new FullFrame()));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitAnyStackMapFrame(Clazz, Method, CodeAttribute, int, StackMapFrame)}
   */
  @Test
  public void testVisitAnyStackMapFrame3() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitAnyStackMapFrame(clazz, method,
        codeAttribute, InstructionSequenceReplacer.STRING_A_LENGTH, new FullFrame()));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)}
   */
  @Test
  public void testVisitSameOneFrame() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> codeAttributeEditor.visitSameOneFrame(clazz, method, codeAttribute, 2, new SameOneFrame(1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)}
   */
  @Test
  public void testVisitSameOneFrame2() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> codeAttributeEditor.visitSameOneFrame(clazz, method, codeAttribute, -16777216, new SameOneFrame(1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)}
   */
  @Test
  public void testVisitSameOneFrame3() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitSameOneFrame(clazz, method,
        codeAttribute, InstructionSequenceReplacer.STRING_A_LENGTH, new SameOneFrame(1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitMoreZeroFrame(Clazz, Method, CodeAttribute, int, MoreZeroFrame)}
   */
  @Test
  public void testVisitMoreZeroFrame() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> codeAttributeEditor.visitMoreZeroFrame(clazz, method, codeAttribute, 2, new MoreZeroFrame(1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitMoreZeroFrame(Clazz, Method, CodeAttribute, int, MoreZeroFrame)}
   */
  @Test
  public void testVisitMoreZeroFrame2() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> codeAttributeEditor.visitMoreZeroFrame(clazz, method, codeAttribute, -16777216, new MoreZeroFrame(1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitMoreZeroFrame(Clazz, Method, CodeAttribute, int, MoreZeroFrame)}
   */
  @Test
  public void testVisitMoreZeroFrame3() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitMoreZeroFrame(clazz, method,
        codeAttribute, InstructionSequenceReplacer.STRING_A_LENGTH, new MoreZeroFrame(1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitFullFrame(Clazz, Method, CodeAttribute, int, FullFrame)}
   */
  @Test
  public void testVisitFullFrame() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> codeAttributeEditor.visitFullFrame(clazz, method, codeAttribute, 2, new FullFrame()));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitFullFrame(Clazz, Method, CodeAttribute, int, FullFrame)}
   */
  @Test
  public void testVisitFullFrame2() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> codeAttributeEditor.visitFullFrame(clazz, method, codeAttribute, -16777216, new FullFrame()));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitFullFrame(Clazz, Method, CodeAttribute, int, FullFrame)}
   */
  @Test
  public void testVisitFullFrame3() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitFullFrame(clazz, method, codeAttribute,
        InstructionSequenceReplacer.STRING_A_LENGTH, new FullFrame()));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitUninitializedType(Clazz, Method, CodeAttribute, int, UninitializedType)}
   */
  @Test
  public void testVisitUninitializedType() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitUninitializedType(clazz, method,
        codeAttribute, 2, VerificationTypeFactory.createUninitializedType(1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitUninitializedType(Clazz, Method, CodeAttribute, int, UninitializedType)}
   */
  @Test
  public void testVisitUninitializedType2() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitUninitializedType(clazz, method,
        codeAttribute, 2, VerificationTypeFactory.createUninitializedType(-16777216)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitUninitializedType(Clazz, Method, CodeAttribute, int, UninitializedType)}
   */
  @Test
  public void testVisitUninitializedType3() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> codeAttributeEditor.visitUninitializedType(clazz, method, codeAttribute, 2,
            VerificationTypeFactory.createUninitializedType(InstructionSequenceReplacer.STRING_A_LENGTH)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitLineNumberInfo(Clazz, Method, CodeAttribute, LineNumberInfo)}
   */
  @Test
  public void testVisitLineNumberInfo() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> codeAttributeEditor.visitLineNumberInfo(clazz, method, codeAttribute, new LineNumberInfo(1, 2)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitLineNumberInfo(Clazz, Method, CodeAttribute, LineNumberInfo)}
   */
  @Test
  public void testVisitLineNumberInfo2() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> codeAttributeEditor.visitLineNumberInfo(clazz, method, codeAttribute, new LineNumberInfo(-16777216, 2)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitLineNumberInfo(Clazz, Method, CodeAttribute, LineNumberInfo)}
   */
  @Test
  public void testVisitLineNumberInfo3() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitLineNumberInfo(clazz, method,
        codeAttribute, new LineNumberInfo(InstructionSequenceReplacer.STRING_A_LENGTH, 2)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo)}
   */
  @Test
  public void testVisitLocalVariableInfo() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitLocalVariableInfo(clazz, method,
        codeAttribute, new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo)}
   */
  @Test
  public void testVisitLocalVariableInfo2() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitLocalVariableInfo(clazz, method,
        codeAttribute, new LocalVariableInfo(-16777216, 3, 1, 1, 1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo)}
   */
  @Test
  public void testVisitLocalVariableInfo3() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitLocalVariableInfo(clazz, method,
        codeAttribute, new LocalVariableInfo(InstructionSequenceReplacer.STRING_A_LENGTH, 3, 1, 1, 1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo)}
   */
  @Test
  public void testVisitLocalVariableInfo4() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitLocalVariableInfo(clazz, method,
        codeAttribute, new LocalVariableInfo(1, -1, 1, 1, 1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo)}
   */
  @Test
  public void testVisitLocalVariableTypeInfo() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitLocalVariableTypeInfo(clazz, method,
        codeAttribute, new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo)}
   */
  @Test
  public void testVisitLocalVariableTypeInfo2() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitLocalVariableTypeInfo(clazz, method,
        codeAttribute, new LocalVariableTypeInfo(-16777216, 3, 1, 1, 1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo)}
   */
  @Test
  public void testVisitLocalVariableTypeInfo3() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitLocalVariableTypeInfo(clazz, method,
        codeAttribute, new LocalVariableTypeInfo(InstructionSequenceReplacer.STRING_A_LENGTH, 3, 1, 1, 1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo)}
   */
  @Test
  public void testVisitLocalVariableTypeInfo4() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitLocalVariableTypeInfo(clazz, method,
        codeAttribute, new LocalVariableTypeInfo(1, -1, 1, 1, 1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitTypeAnnotation(Clazz, TypeAnnotation)}
   */
  @Test
  public void testVisitTypeAnnotation() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LocalVariableTargetInfo targetInfo = new LocalVariableTargetInfo((byte) 'A', 3,
        new LocalVariableTargetElement[]{new LocalVariableTargetElement(1, 3, 1)});

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> codeAttributeEditor.visitTypeAnnotation(clazz, new TypeAnnotation(1, 3,
            new ElementValue[]{new AnnotationElementValue()}, targetInfo, new TypePathInfo[]{new TypePathInfo(1, 1)})));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitOffsetTargetInfo(Clazz, Method, CodeAttribute, TypeAnnotation, OffsetTargetInfo)}
   */
  @Test
  public void testVisitOffsetTargetInfo() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    TypeAnnotation typeAnnotation = new TypeAnnotation();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitOffsetTargetInfo(clazz, method,
        codeAttribute, typeAnnotation, new OffsetTargetInfo((byte) 'A', 2)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitOffsetTargetInfo(Clazz, Method, CodeAttribute, TypeAnnotation, OffsetTargetInfo)}
   */
  @Test
  public void testVisitOffsetTargetInfo2() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    TypeAnnotation typeAnnotation = new TypeAnnotation();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitOffsetTargetInfo(clazz, method,
        codeAttribute, typeAnnotation, new OffsetTargetInfo((byte) 'A', -16777216)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitOffsetTargetInfo(Clazz, Method, CodeAttribute, TypeAnnotation, OffsetTargetInfo)}
   */
  @Test
  public void testVisitOffsetTargetInfo3() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    TypeAnnotation typeAnnotation = new TypeAnnotation();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitOffsetTargetInfo(clazz, method,
        codeAttribute, typeAnnotation, new OffsetTargetInfo((byte) 'A', InstructionSequenceReplacer.STRING_A_LENGTH)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitLocalVariableTargetElement(Clazz, Method, CodeAttribute, TypeAnnotation, LocalVariableTargetInfo, LocalVariableTargetElement)}
   */
  @Test
  public void testVisitLocalVariableTargetElement() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    TypeAnnotation typeAnnotation = new TypeAnnotation();
    LocalVariableTargetInfo localVariableTargetInfo = new LocalVariableTargetInfo((byte) 'A');

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitLocalVariableTargetElement(clazz,
        method, codeAttribute, typeAnnotation, localVariableTargetInfo, new LocalVariableTargetElement(1, 3, 1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitLocalVariableTargetElement(Clazz, Method, CodeAttribute, TypeAnnotation, LocalVariableTargetInfo, LocalVariableTargetElement)}
   */
  @Test
  public void testVisitLocalVariableTargetElement2() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    TypeAnnotation typeAnnotation = new TypeAnnotation();
    LocalVariableTargetInfo localVariableTargetInfo = new LocalVariableTargetInfo((byte) 'A');

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> codeAttributeEditor.visitLocalVariableTargetElement(clazz, method, codeAttribute, typeAnnotation,
            localVariableTargetInfo, new LocalVariableTargetElement(-16777216, 3, 1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitLocalVariableTargetElement(Clazz, Method, CodeAttribute, TypeAnnotation, LocalVariableTargetInfo, LocalVariableTargetElement)}
   */
  @Test
  public void testVisitLocalVariableTargetElement3() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    TypeAnnotation typeAnnotation = new TypeAnnotation();
    LocalVariableTargetInfo localVariableTargetInfo = new LocalVariableTargetInfo((byte) 'A');

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> codeAttributeEditor.visitLocalVariableTargetElement(clazz, method, codeAttribute, typeAnnotation,
            localVariableTargetInfo,
            new LocalVariableTargetElement(InstructionSequenceReplacer.STRING_A_LENGTH, 3, 1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeEditor#visitLocalVariableTargetElement(Clazz, Method, CodeAttribute, TypeAnnotation, LocalVariableTargetInfo, LocalVariableTargetElement)}
   */
  @Test
  public void testVisitLocalVariableTargetElement4() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    TypeAnnotation typeAnnotation = new TypeAnnotation();
    LocalVariableTargetInfo localVariableTargetInfo = new LocalVariableTargetInfo((byte) 'A');

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeEditor.visitLocalVariableTargetElement(clazz,
        method, codeAttribute, typeAnnotation, localVariableTargetInfo, new LocalVariableTargetElement(1, -1, 1)));
  }

  /**
   * Method under test: {@link CodeAttributeEditor#label()}
   */
  @Test
  public void testLabel() {
    // Arrange and Act
    CodeAttributeEditor.Label actualLabelResult = (new CodeAttributeEditor()).label();

    // Assert
    assertEquals("nop", actualLabelResult.getName());
    assertEquals(0, actualLabelResult.identifier);
    assertEquals((byte) 0, actualLabelResult.opcode);
    assertFalse(actualLabelResult.isCategory2());
  }

  /**
   * Method under test: {@link CodeAttributeEditor#label(int)}
   */
  @Test
  public void testLabel2() {
    // Arrange and Act
    CodeAttributeEditor.Label actualLabelResult = (new CodeAttributeEditor()).label(1);

    // Assert
    assertEquals("nop", actualLabelResult.getName());
    assertEquals((byte) 0, actualLabelResult.opcode);
    assertEquals(1, actualLabelResult.identifier);
    assertFalse(actualLabelResult.isCategory2());
  }

  /**
   * Method under test: {@link CodeAttributeEditor#catch_(int, int, int, int)}
   */
  @Test
  public void testCatch_() {
    // Arrange and Act
    CodeAttributeEditor.Label actualCatch_Result = (new CodeAttributeEditor()).catch_(1, 1, 3, 1);

    // Assert
    assertEquals("nop", actualCatch_Result.getName());
    assertEquals((byte) 0, actualCatch_Result.opcode);
    assertEquals(1, actualCatch_Result.identifier);
    assertFalse(actualCatch_Result.isCategory2());
  }

  /**
   * Method under test: {@link CodeAttributeEditor#line(int, int, String)}
   */
  @Test
  public void testLine() {
    // Arrange and Act
    CodeAttributeEditor.Label actualLineResult = (new CodeAttributeEditor()).line(1, 2, "Source");

    // Assert
    assertEquals("nop", actualLineResult.getName());
    assertEquals((byte) 0, actualLineResult.opcode);
    assertEquals(1, actualLineResult.identifier);
    assertFalse(actualLineResult.isCategory2());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CodeAttributeEditor#visitAnyAttribute(Clazz, Attribute)}
   *   <li>
   * {@link CodeAttributeEditor#visitAnyTargetInfo(Clazz, TypeAnnotation, TargetInfo)}
   *   <li>
   * {@link CodeAttributeEditor#visitAnyVerificationType(Clazz, Method, CodeAttribute, int, VerificationType)}
   *   <li>{@link CodeAttributeEditor#isModified()}
   * </ul>
   */
  @Test
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
    codeAttributeEditor.visitAnyVerificationType(clazz3, method, codeAttribute, 2,
        VerificationTypeFactory.createDoubleType());

    // Assert that nothing has changed
    assertFalse(codeAttributeEditor.isModified());
  }
}
