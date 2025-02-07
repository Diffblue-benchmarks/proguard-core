package proguard.classfile.visitor;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberCounter.visitLibraryField(proguard.classfile.LibraryClass, proguard.classfile.LibraryField)"
  })
  void testVisitLibraryField() {
    // Arrange
    MemberCounter memberCounter = new MemberCounter();
    LibraryClass libraryClass = new LibraryClass();

    // Act
    memberCounter.visitLibraryField(libraryClass, new LibraryField(1, "Name", "Descriptor"));

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberCounter.visitLibraryMethod(proguard.classfile.LibraryClass, proguard.classfile.LibraryMethod)"
  })
  void testVisitLibraryMethod() {
    // Arrange
    MemberCounter memberCounter = new MemberCounter();
    LibraryClass libraryClass = new LibraryClass();

    // Act
    memberCounter.visitLibraryMethod(libraryClass, new LibraryMethod(1, "Name", "Descriptor"));

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberCounter.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberCounter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberCounter.<init>()",
    "int proguard.classfile.visitor.MemberCounter.getCount()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, (new MemberCounter()).getCount());
  }
}
