package proguard.classfile.editor;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.visitor.AttributeVisitor;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.classfile.visitor.MemberVisitor;

class AccessFixerDiffblueTest {
  /**
   * Test {@link AccessFixer#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#attributesAccept(AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link AccessFixer#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); then calls attributesAccept(AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AccessFixer.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenCallsAttributesAccept() {
    // Arrange
    AccessFixer accessFixer = new AccessFixer();
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).attributesAccept(Mockito.<AttributeVisitor>any());
    doNothing().when(programClass).constantPoolEntriesAccept(Mockito.<ConstantVisitor>any());
    doNothing().when(programClass).fieldsAccept(Mockito.<MemberVisitor>any());
    doNothing().when(programClass).methodsAccept(Mockito.<MemberVisitor>any());

    // Act
    accessFixer.visitProgramClass(programClass);

    // Assert
    verify(programClass, atLeast(1)).attributesAccept(Mockito.<AttributeVisitor>any());
    verify(programClass).constantPoolEntriesAccept(isA(ConstantVisitor.class));
    verify(programClass, atLeast(1)).fieldsAccept(Mockito.<MemberVisitor>any());
    verify(programClass, atLeast(1)).methodsAccept(Mockito.<MemberVisitor>any());
  }
}
