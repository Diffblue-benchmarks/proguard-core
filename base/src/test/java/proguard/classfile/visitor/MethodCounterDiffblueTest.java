package proguard.classfile.visitor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.Member;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramMethod;

class MethodCounterDiffblueTest {
  /**
   * Test {@link MethodCounter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link MethodCounter#visitProgramMethod(ProgramClass, ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MethodCounter.visitProgramMethod(ProgramClass, ProgramMethod)"})
  void testVisitProgramMethod() {
    // Arrange
    MethodCounter methodCounter = new MethodCounter();
    ProgramClass programClass = new ProgramClass();

    // Act
    methodCounter.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    assertEquals(1, methodCounter.getCount());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link MethodCounter}
   *   <li>{@link MethodCounter#visitAnyMember(Clazz, Member)}
   *   <li>{@link MethodCounter#getCount()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MethodCounter.<init>()",
    "int MethodCounter.getCount()",
    "void MethodCounter.visitAnyMember(Clazz, Member)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    MethodCounter actualMethodCounter = new MethodCounter();
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");
    actualMethodCounter.visitAnyMember(clazz, member);

    // Assert
    assertEquals(0, actualMethodCounter.getCount());
  }
}
