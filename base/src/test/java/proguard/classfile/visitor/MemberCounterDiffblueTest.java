package proguard.classfile.visitor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMethod;

public class MemberCounterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link MemberCounter}
   *   <li>{@link MemberCounter#getCount()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, (new MemberCounter()).getCount());
  }

  /**
   * Method under test:
   * {@link MemberCounter#visitLibraryField(LibraryClass, LibraryField)}
   */
  @Test
  public void testVisitLibraryField() {
    // Arrange
    MemberCounter memberCounter = new MemberCounter();
    LibraryClass libraryClass = new LibraryClass();

    // Act
    memberCounter.visitLibraryField(libraryClass, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, memberCounter.getCount());
  }

  /**
   * Method under test:
   * {@link MemberCounter#visitLibraryMethod(LibraryClass, LibraryMethod)}
   */
  @Test
  public void testVisitLibraryMethod() {
    // Arrange
    MemberCounter memberCounter = new MemberCounter();
    LibraryClass libraryClass = new LibraryClass();

    // Act
    memberCounter.visitLibraryMethod(libraryClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(1, memberCounter.getCount());
  }

  /**
   * Method under test:
   * {@link MemberCounter#visitProgramField(ProgramClass, ProgramField)}
   */
  @Test
  public void testVisitProgramField() {
    // Arrange
    MemberCounter memberCounter = new MemberCounter();
    ProgramClass programClass = new ProgramClass();

    // Act
    memberCounter.visitProgramField(programClass, new ProgramField());

    // Assert
    assertEquals(1, memberCounter.getCount());
  }

  /**
   * Method under test:
   * {@link MemberCounter#visitProgramMethod(ProgramClass, ProgramMethod)}
   */
  @Test
  public void testVisitProgramMethod() {
    // Arrange
    MemberCounter memberCounter = new MemberCounter();
    ProgramClass programClass = new ProgramClass();

    // Act
    memberCounter.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    assertEquals(1, memberCounter.getCount());
  }
}
