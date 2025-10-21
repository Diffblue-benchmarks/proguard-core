package proguard.classfile.visitor;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.Member;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramMethod;

public class MethodCounterDiffblueTest {
  /**
   * Test {@link MethodCounter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link MethodCounter#visitProgramMethod(ProgramClass, ProgramMethod)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MethodCounter.visitProgramMethod(ProgramClass, ProgramMethod)"})
  public void testVisitProgramMethod() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MethodCounter.<init>()",
    "int MethodCounter.getCount()",
    "void MethodCounter.visitAnyMember(Clazz, Member)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    MethodCounter actualMethodCounter = new MethodCounter();
    LibraryClass clazz = new LibraryClass();
    actualMethodCounter.visitAnyMember(clazz, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(0, actualMethodCounter.getCount());
  }
}
