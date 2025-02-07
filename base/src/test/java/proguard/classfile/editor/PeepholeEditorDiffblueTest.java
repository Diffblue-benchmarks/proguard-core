package proguard.classfile.editor;

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
import proguard.classfile.attribute.visitor.MaxStackSizeComputer;
import proguard.classfile.instruction.visitor.InstructionVisitor;

class PeepholeEditorDiffblueTest {
  /**
   * Test {@link PeepholeEditor#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Given {@link CodeAttributeEditor} {@link CodeAttributeEditor#reset(int)} does nothing.
   *   <li>Then calls {@link CodeAttributeEditor#reset(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PeepholeEditor#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); given CodeAttributeEditor reset(int) does nothing; then calls reset(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.PeepholeEditor.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_givenCodeAttributeEditorResetDoesNothing_thenCallsReset() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = mock(CodeAttributeEditor.class);
    doNothing().when(codeAttributeEditor).reset(anyInt());
    doNothing()
        .when(codeAttributeEditor)
        .visitCodeAttribute(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<CodeAttribute>any());
    PeepholeEditor peepholeEditor =
        new PeepholeEditor(codeAttributeEditor, new MaxStackSizeComputer());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    peepholeEditor.visitCodeAttribute(clazz, method, new CodeAttribute(1));

    // Assert
    verify(codeAttributeEditor).reset(eq(0));
    verify(codeAttributeEditor)
        .visitCodeAttribute(isA(Clazz.class), isA(Method.class), isA(CodeAttribute.class));
  }

  /**
   * Test {@link PeepholeEditor#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link CodeAttribute#instructionsAccept(Clazz, Method, InstructionVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link PeepholeEditor#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); then calls instructionsAccept(Clazz, Method, InstructionVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.PeepholeEditor.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_thenCallsInstructionsAccept() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = mock(CodeAttributeEditor.class);
    doNothing().when(codeAttributeEditor).reset(anyInt());
    doNothing()
        .when(codeAttributeEditor)
        .visitCodeAttribute(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<CodeAttribute>any());
    PeepholeEditor peepholeEditor =
        new PeepholeEditor(codeAttributeEditor, new MaxStackSizeComputer());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    doNothing()
        .when(codeAttribute)
        .instructionsAccept(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<InstructionVisitor>any());

    // Act
    peepholeEditor.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    verify(codeAttribute)
        .instructionsAccept(isA(Clazz.class), isA(Method.class), isA(InstructionVisitor.class));
    verify(codeAttributeEditor).reset(eq(0));
    verify(codeAttributeEditor)
        .visitCodeAttribute(isA(Clazz.class), isA(Method.class), isA(CodeAttribute.class));
  }

  /**
   * Test {@link PeepholeEditor#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then calls {@link CodeAttributeEditor#reset(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PeepholeEditor#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); when 'A'; then calls reset(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.PeepholeEditor.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_whenA_thenCallsReset() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = mock(CodeAttributeEditor.class);
    doNothing().when(codeAttributeEditor).reset(anyInt());
    doNothing()
        .when(codeAttributeEditor)
        .visitCodeAttribute(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<CodeAttribute>any());
    PeepholeEditor peepholeEditor =
        new PeepholeEditor(codeAttributeEditor, new MaxStackSizeComputer());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    peepholeEditor.visitCodeAttribute(
        clazz, method, new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}));

    // Assert
    verify(codeAttributeEditor).reset(eq(3));
    verify(codeAttributeEditor)
        .visitCodeAttribute(isA(Clazz.class), isA(Method.class), isA(CodeAttribute.class));
  }
}
