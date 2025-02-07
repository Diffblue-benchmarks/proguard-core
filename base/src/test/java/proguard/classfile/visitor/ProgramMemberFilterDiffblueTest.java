package proguard.classfile.visitor;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMethod;

class ProgramMemberFilterDiffblueTest {
  /**
   * Test {@link ProgramMemberFilter#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Then calls {@link MemberVisitor#visitProgramField(ProgramClass, ProgramField)}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramMemberFilter#visitProgramField(ProgramClass, ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); then calls visitProgramField(ProgramClass, ProgramField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ProgramMemberFilter.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_thenCallsVisitProgramField() {
    // Arrange
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitProgramField(Mockito.<ProgramClass>any(), Mockito.<ProgramField>any());
    ProgramMemberFilter programMemberFilter = new ProgramMemberFilter(memberVisitor);
    ProgramClass programClass = new ProgramClass();

    // Act
    programMemberFilter.visitProgramField(programClass, new ProgramField());

    // Assert
    verify(memberVisitor).visitProgramField(isA(ProgramClass.class), isA(ProgramField.class));
  }

  /**
   * Test {@link ProgramMemberFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link MethodImplementationFilter#visitProgramMethod(ProgramClass,
   *       ProgramMethod)}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramMemberFilter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); then calls visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ProgramMemberFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_thenCallsVisitProgramMethod() {
    // Arrange
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitProgramMethod(Mockito.<ProgramClass>any(), Mockito.<ProgramMethod>any());
    ProgramMemberFilter programMemberFilter = new ProgramMemberFilter(memberVisitor);
    ProgramClass programClass = new ProgramClass();

    // Act
    programMemberFilter.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(memberVisitor).visitProgramMethod(isA(ProgramClass.class), isA(ProgramMethod.class));
  }
}
