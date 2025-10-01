package proguard.classfile.visitor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMethod;

class MemberCounterDiffblueTest {
  /**
   * Test {@link MemberCounter#visitLibraryField(LibraryClass, LibraryField)}.
   *
   * <p>Method under test: {@link MemberCounter#visitLibraryField(LibraryClass, LibraryField)}
   */
  @Test
  @DisplayName("Test visitLibraryField(LibraryClass, LibraryField)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemberCounter.visitLibraryField(LibraryClass, LibraryField)"})
  void testVisitLibraryField() {
    // Arrange
    MemberCounter memberCounter = new MemberCounter();
    LibraryClass libraryClass = new LibraryClass();
    LibraryField libraryField = new LibraryField(1, "Name", "Descriptor");

    // Act
    memberCounter.visitLibraryField(libraryClass, libraryField);

    // Assert
    assertEquals(1, memberCounter.getCount());
  }

  /**
   * Test {@link MemberCounter#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <p>Method under test: {@link MemberCounter#visitLibraryMethod(LibraryClass, LibraryMethod)}
   */
  @Test
  @DisplayName("Test visitLibraryMethod(LibraryClass, LibraryMethod)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemberCounter.visitLibraryMethod(LibraryClass, LibraryMethod)"})
  void testVisitLibraryMethod() {
    // Arrange
    MemberCounter memberCounter = new MemberCounter();
    LibraryClass libraryClass = new LibraryClass();
    LibraryMethod libraryMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    memberCounter.visitLibraryMethod(libraryClass, libraryMethod);

    // Assert
    assertEquals(1, memberCounter.getCount());
  }

  /**
   * Test {@link MemberCounter#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <p>Method under test: {@link MemberCounter#visitProgramField(ProgramClass, ProgramField)}
   */
  @Test
  @DisplayName("Test visitProgramField(ProgramClass, ProgramField)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemberCounter.visitProgramField(ProgramClass, ProgramField)"})
  void testVisitProgramField() {
    // Arrange
    MemberCounter memberCounter = new MemberCounter();
    ProgramClass programClass = new ProgramClass();

    // Act
    memberCounter.visitProgramField(programClass, new ProgramField());

    // Assert
    assertEquals(1, memberCounter.getCount());
  }

  /**
   * Test {@link MemberCounter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link MemberCounter#visitProgramMethod(ProgramClass, ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemberCounter.visitProgramMethod(ProgramClass, ProgramMethod)"})
  void testVisitProgramMethod() {
    // Arrange
    MemberCounter memberCounter = new MemberCounter();
    ProgramClass programClass = new ProgramClass();

    // Act
    memberCounter.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    assertEquals(1, memberCounter.getCount());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link MemberCounter}
   *   <li>{@link MemberCounter#getCount()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemberCounter.<init>()", "int MemberCounter.getCount()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, new MemberCounter().getCount());
  }
}
