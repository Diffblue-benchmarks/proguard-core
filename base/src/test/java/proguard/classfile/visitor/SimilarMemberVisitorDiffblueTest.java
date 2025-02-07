package proguard.classfile.visitor;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMethod;
import proguard.classfile.editor.AttributeSorter;

class SimilarMemberVisitorDiffblueTest {
  /**
   * Test {@link SimilarMemberVisitor#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link SimilarMemberVisitor#visitProgramField(ProgramClass,
   * ProgramField)}
   */
  @Test
  @DisplayName("Test visitProgramField(ProgramClass, ProgramField); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.SimilarMemberVisitor.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_thenCallsGetString() {
    // Arrange
    SimilarMemberVisitor similarMemberVisitor =
        new SimilarMemberVisitor(true, true, true, true, new AttributeSorter());
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getString(anyInt())).thenReturn("String");
    doNothing()
        .when(programClass)
        .hierarchyAccept(
            anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<ClassVisitor>any());

    // Act
    similarMemberVisitor.visitProgramField(programClass, new ProgramField());

    // Assert
    verify(programClass, atLeast(1)).getString(eq(0));
    verify(programClass)
        .hierarchyAccept(eq(true), eq(true), eq(true), eq(true), isA(ClassVisitor.class));
  }

  /**
   * Test {@link SimilarMemberVisitor#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link SimilarMemberVisitor#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.SimilarMemberVisitor.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_thenCallsGetString() {
    // Arrange
    SimilarMemberVisitor similarMemberVisitor =
        new SimilarMemberVisitor(true, true, true, true, new AttributeSorter());
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getString(anyInt())).thenReturn("String");
    doNothing()
        .when(programClass)
        .hierarchyAccept(
            anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<ClassVisitor>any());

    // Act
    similarMemberVisitor.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(programClass, atLeast(1)).getString(eq(0));
    verify(programClass)
        .hierarchyAccept(eq(true), eq(true), eq(true), eq(true), isA(ClassVisitor.class));
  }
}
