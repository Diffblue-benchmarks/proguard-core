package proguard.classfile.visitor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMethod;

class MemberAccessFlagSetterDiffblueTest {
  /**
   * Test {@link MemberAccessFlagSetter#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>When {@link ProgramField#ProgramField()}.
   *   <li>Then {@link ProgramField#ProgramField()} AccessFlags is one.
   * </ul>
   *
   * <p>Method under test: {@link MemberAccessFlagSetter#visitProgramField(ProgramClass,
   * ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); when ProgramField(); then ProgramField() AccessFlags is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemberAccessFlagSetter.visitProgramField(ProgramClass, ProgramField)"})
  void testVisitProgramField_whenProgramField_thenProgramFieldAccessFlagsIsOne() {
    // Arrange
    MemberAccessFlagSetter memberAccessFlagSetter = new MemberAccessFlagSetter(1);
    ProgramClass programClass = new ProgramClass();
    ProgramField programField = new ProgramField();

    // Act
    memberAccessFlagSetter.visitProgramField(programClass, programField);

    // Assert
    assertEquals(1, programField.getAccessFlags());
  }

  /**
   * Test {@link MemberAccessFlagSetter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>When {@link ProgramMethod#ProgramMethod()}.
   *   <li>Then {@link ProgramMethod#ProgramMethod()} AccessFlags is one.
   * </ul>
   *
   * <p>Method under test: {@link MemberAccessFlagSetter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); when ProgramMethod(); then ProgramMethod() AccessFlags is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemberAccessFlagSetter.visitProgramMethod(ProgramClass, ProgramMethod)"})
  void testVisitProgramMethod_whenProgramMethod_thenProgramMethodAccessFlagsIsOne() {
    // Arrange
    MemberAccessFlagSetter memberAccessFlagSetter = new MemberAccessFlagSetter(1);
    ProgramClass programClass = new ProgramClass();
    ProgramMethod programMethod = new ProgramMethod();

    // Act
    memberAccessFlagSetter.visitProgramMethod(programClass, programMethod);

    // Assert
    assertEquals(1, programMethod.getAccessFlags());
  }
}
