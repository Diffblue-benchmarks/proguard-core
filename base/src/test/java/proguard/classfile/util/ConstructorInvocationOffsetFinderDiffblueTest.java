package proguard.classfile.util;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramMember;
import proguard.classfile.ProgramMethod;
import proguard.classfile.attribute.visitor.AttributeVisitor;

class ConstructorInvocationOffsetFinderDiffblueTest {
  /**
   * Test {@link ConstructorInvocationOffsetFinder#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Given {@code <init>}.
   *   <li>When {@link ProgramClass}.
   *   <li>Then calls {@link ProgramMember#getName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstructorInvocationOffsetFinder#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); given '<init>'; when ProgramClass; then calls getName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ConstructorInvocationOffsetFinder.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_givenInit_whenProgramClass_thenCallsGetName() {
    // Arrange
    ConstructorInvocationOffsetFinder constructorInvocationOffsetFinder =
        new ConstructorInvocationOffsetFinder();
    ProgramClass programClass = mock(ProgramClass.class);
    ProgramMethod programMethod = mock(ProgramMethod.class);
    doNothing()
        .when(programMethod)
        .attributesAccept(Mockito.<ProgramClass>any(), Mockito.<AttributeVisitor>any());
    when(programMethod.getName(Mockito.<Clazz>any())).thenReturn("<init>");

    // Act
    constructorInvocationOffsetFinder.visitProgramMethod(programClass, programMethod);

    // Assert
    verify(programMethod).getName(isA(Clazz.class));
    verify(programMethod).attributesAccept(isA(ProgramClass.class), isA(AttributeVisitor.class));
  }

  /**
   * Test {@link ConstructorInvocationOffsetFinder#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass} {@link ProgramClass#getString(int)} return {@code <init>}.
   *   <li>Then calls {@link ProgramClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstructorInvocationOffsetFinder#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); when ProgramClass getString(int) return '<init>'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ConstructorInvocationOffsetFinder.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_whenProgramClassGetStringReturnInit_thenCallsGetString() {
    // Arrange
    ConstructorInvocationOffsetFinder constructorInvocationOffsetFinder =
        new ConstructorInvocationOffsetFinder();
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getString(anyInt())).thenReturn("<init>");

    // Act
    constructorInvocationOffsetFinder.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(programClass).getString(eq(0));
  }
}
