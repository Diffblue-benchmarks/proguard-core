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

class MemberAccessSetterDiffblueTest {
  /**
   * Test {@link MemberAccessSetter#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Then {@link ProgramField#ProgramField()} AccessFlags is one.
   * </ul>
   *
   * <p>Method under test: {@link MemberAccessSetter#visitProgramField(ProgramClass, ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); then ProgramField() AccessFlags is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemberAccessSetter.visitProgramField(ProgramClass, ProgramField)"})
  void testVisitProgramField_thenProgramFieldAccessFlagsIsOne() {
    // Arrange
    MemberAccessSetter memberAccessSetter = new MemberAccessSetter(1);
    ProgramClass programClass = new ProgramClass();
    ProgramField programField = new ProgramField();

    // Act
    memberAccessSetter.visitProgramField(programClass, programField);

    // Assert
    assertEquals(1, programField.getAccessFlags());
  }

  /**
   * Test {@link MemberAccessSetter#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Then {@link ProgramField#ProgramField()} AccessFlags is two.
   * </ul>
   *
   * <p>Method under test: {@link MemberAccessSetter#visitProgramField(ProgramClass, ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); then ProgramField() AccessFlags is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemberAccessSetter.visitProgramField(ProgramClass, ProgramField)"})
  void testVisitProgramField_thenProgramFieldAccessFlagsIsTwo() {
    // Arrange
    MemberAccessSetter memberAccessSetter = new MemberAccessSetter(2);
    ProgramClass programClass = new ProgramClass();
    ProgramField programField = new ProgramField();

    // Act
    memberAccessSetter.visitProgramField(programClass, programField);

    // Assert
    assertEquals(2, programField.getAccessFlags());
  }

  /**
   * Test {@link MemberAccessSetter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Then {@link ProgramMethod#ProgramMethod()} AccessFlags is one.
   * </ul>
   *
   * <p>Method under test: {@link MemberAccessSetter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); then ProgramMethod() AccessFlags is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemberAccessSetter.visitProgramMethod(ProgramClass, ProgramMethod)"})
  void testVisitProgramMethod_thenProgramMethodAccessFlagsIsOne() {
    // Arrange
    MemberAccessSetter memberAccessSetter = new MemberAccessSetter(1);
    ProgramClass programClass = new ProgramClass();
    ProgramMethod programMethod = new ProgramMethod();

    // Act
    memberAccessSetter.visitProgramMethod(programClass, programMethod);

    // Assert
    assertEquals(1, programMethod.getAccessFlags());
  }

  /**
   * Test {@link MemberAccessSetter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Then {@link ProgramMethod#ProgramMethod()} AccessFlags is two.
   * </ul>
   *
   * <p>Method under test: {@link MemberAccessSetter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); then ProgramMethod() AccessFlags is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemberAccessSetter.visitProgramMethod(ProgramClass, ProgramMethod)"})
  void testVisitProgramMethod_thenProgramMethodAccessFlagsIsTwo() {
    // Arrange
    MemberAccessSetter memberAccessSetter = new MemberAccessSetter(2);
    ProgramClass programClass = new ProgramClass();
    ProgramMethod programMethod = new ProgramMethod();

    // Act
    memberAccessSetter.visitProgramMethod(programClass, programMethod);

    // Assert
    assertEquals(2, programMethod.getAccessFlags());
  }
}
