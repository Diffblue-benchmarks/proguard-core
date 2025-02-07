package proguard.classfile.editor;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;

class CodeAttributeEditorResetterDiffblueTest {
  /**
   * Test {@link CodeAttributeEditorResetter#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Given {@link CodeAttributeEditor} {@link CodeAttributeEditor#reset(int)} does nothing.
   *   <li>Then calls {@link CodeAttributeEditor#reset(int)}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeEditorResetter#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); given CodeAttributeEditor reset(int) does nothing; then calls reset(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeEditorResetter.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_givenCodeAttributeEditorResetDoesNothing_thenCallsReset() {
    // Arrange
    CodeAttributeEditor codeAttributeEditor = mock(CodeAttributeEditor.class);
    doNothing().when(codeAttributeEditor).reset(anyInt());
    CodeAttributeEditorResetter codeAttributeEditorResetter =
        new CodeAttributeEditorResetter(codeAttributeEditor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    codeAttributeEditorResetter.visitCodeAttribute(clazz, method, new CodeAttribute(1));

    // Assert
    verify(codeAttributeEditor).reset(eq(0));
  }
}
