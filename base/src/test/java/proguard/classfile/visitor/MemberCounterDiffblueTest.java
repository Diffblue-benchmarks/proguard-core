package proguard.classfile.visitor;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMethod;

public class MemberCounterDiffblueTest {
  /**
   * Test {@link MemberCounter#visitLibraryField(LibraryClass, LibraryField)}.
   *
   * <p>Method under test: {@link MemberCounter#visitLibraryField(LibraryClass, LibraryField)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MemberCounter.visitLibraryField(LibraryClass, LibraryField)"})
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
   * Test {@link MemberCounter#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <p>Method under test: {@link MemberCounter#visitLibraryMethod(LibraryClass, LibraryMethod)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MemberCounter.visitLibraryMethod(LibraryClass, LibraryMethod)"})
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
   * Test {@link MemberCounter#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <p>Method under test: {@link MemberCounter#visitProgramField(ProgramClass, ProgramField)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MemberCounter.visitProgramField(ProgramClass, ProgramField)"})
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
   * Test {@link MemberCounter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link MemberCounter#visitProgramMethod(ProgramClass, ProgramMethod)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MemberCounter.visitProgramMethod(ProgramClass, ProgramMethod)"})
  public void testVisitProgramMethod() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MemberCounter.<init>()", "int MemberCounter.getCount()"})
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, (new MemberCounter()).getCount());
  }
}
