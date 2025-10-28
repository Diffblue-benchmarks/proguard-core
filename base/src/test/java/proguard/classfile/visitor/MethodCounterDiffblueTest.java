package proguard.classfile.visitor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.Member;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramMethod;

public class MethodCounterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link MethodCounter}
   *   <li>{@link MethodCounter#visitAnyMember(Clazz, Member)}
   *   <li>{@link MethodCounter#getCount()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    MethodCounter actualMethodCounter = new MethodCounter();
    LibraryClass clazz = new LibraryClass();
    actualMethodCounter.visitAnyMember(clazz, new LibraryField(1, "Name", "Descriptor"));

    // Assert that nothing has changed
    assertEquals(0, actualMethodCounter.getCount());
  }

  /**
   * Method under test:
   * {@link MethodCounter#visitProgramMethod(ProgramClass, ProgramMethod)}
   */
  @Test
  public void testVisitProgramMethod() {
    // Arrange
    MethodCounter methodCounter = new MethodCounter();
    ProgramClass programClass = new ProgramClass();

    // Act
    methodCounter.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    assertEquals(1, methodCounter.getCount());
  }
}
