package proguard.classfile.visitor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.ProgramClass;

class ClassVersionSetterDiffblueTest {
  /**
   * Test {@link ClassVersionSetter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ClassVersionSetter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassVersionSetter.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass() {
    // Arrange
    ClassVersionSetter classVersionSetter = new ClassVersionSetter(-1, new HashSet<>());
    ProgramClass programClass = new ProgramClass();

    // Act
    classVersionSetter.visitProgramClass(programClass);

    // Assert
    assertEquals(-1, programClass.u4version);
  }

  /**
   * Test {@link ClassVersionSetter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Given {@link ClassVersionSetter#ClassVersionSetter(int)} with classVersion is minus one.
   * </ul>
   *
   * <p>Method under test: {@link ClassVersionSetter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); given ClassVersionSetter(int) with classVersion is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassVersionSetter.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass_givenClassVersionSetterWithClassVersionIsMinusOne() {
    // Arrange
    ClassVersionSetter classVersionSetter = new ClassVersionSetter(-1);
    ProgramClass programClass = new ProgramClass();

    // Act
    classVersionSetter.visitProgramClass(programClass);

    // Assert
    assertEquals(-1, programClass.u4version);
  }

  /**
   * Test {@link ClassVersionSetter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then {@link ProgramClass#ProgramClass()} {@link ProgramClass#u4version} is one.
   * </ul>
   *
   * <p>Method under test: {@link ClassVersionSetter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass); then ProgramClass() u4version is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassVersionSetter.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass_thenProgramClassU4versionIsOne() {
    // Arrange
    ClassVersionSetter classVersionSetter = new ClassVersionSetter(1);
    ProgramClass programClass = new ProgramClass();

    // Act
    classVersionSetter.visitProgramClass(programClass);

    // Assert
    assertEquals(1, programClass.u4version);
  }
}
