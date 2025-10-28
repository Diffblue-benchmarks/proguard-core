package proguard.classfile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;

public class ProgramMethodDiffblueTest {
  /**
   * Method under test: {@link ProgramMethod#ProgramMethod()}
   */
  @Test
  public void testNewProgramMethod() {
    // Arrange and Act
    ProgramMethod actualProgramMethod = new ProgramMethod();

    // Assert
    assertNull(actualProgramMethod.getProcessingInfo());
    assertEquals(0, actualProgramMethod.getAccessFlags());
    assertEquals(0, actualProgramMethod.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link ProgramMethod#ProgramMethod(int, int, int, int, Attribute[], Clazz[])}
   */
  @Test
  public void testNewProgramMethod2() {
    // Arrange and Act
    ProgramMethod actualProgramMethod = new ProgramMethod(1, 1, 1, 3, new Attribute[]{new BootstrapMethodsAttribute()},
        new Clazz[]{new LibraryClass()});

    // Assert
    assertNull(actualProgramMethod.getProcessingInfo());
    assertEquals(0, actualProgramMethod.getProcessingFlags());
    assertEquals(1, actualProgramMethod.getAccessFlags());
  }

  /**
   * Method under test:
   * {@link ProgramMethod#ProgramMethod(int, int, int, int, Attribute[], Clazz[], int, Object)}
   */
  @Test
  public void testNewProgramMethod3() {
    // Arrange and Act
    ProgramMethod actualProgramMethod = new ProgramMethod(1, 1, 1, 3, new Attribute[]{new BootstrapMethodsAttribute()},
        new Clazz[]{new LibraryClass()}, 1, "Processing Info");

    // Assert
    assertEquals("Processing Info", actualProgramMethod.getProcessingInfo());
    assertEquals(1, actualProgramMethod.getAccessFlags());
    assertEquals(1, actualProgramMethod.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link ProgramMethod#ProgramMethod(int, int, int, Clazz[])}
   */
  @Test
  public void testNewProgramMethod4() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();

    // Act
    ProgramMethod actualProgramMethod = new ProgramMethod(1, 1, 1, new Clazz[]{libraryClass});

    // Assert
    assertNull(actualProgramMethod.getProcessingInfo());
    assertEquals(0, actualProgramMethod.getProcessingFlags());
    assertEquals(0, actualProgramMethod.attributes.length);
    assertEquals(0, actualProgramMethod.u2attributesCount);
    assertEquals(1, actualProgramMethod.getAccessFlags());
    Clazz[] clazzArray = actualProgramMethod.referencedClasses;
    assertEquals(1, clazzArray.length);
    assertEquals(1, actualProgramMethod.u2descriptorIndex);
    assertEquals(1, actualProgramMethod.u2nameIndex);
    assertSame(libraryClass, clazzArray[0]);
  }

  /**
   * Method under test:
   * {@link ProgramMethod#ProgramMethod(int, int, int, Clazz[], int, Object)}
   */
  @Test
  public void testNewProgramMethod5() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();

    // Act
    ProgramMethod actualProgramMethod = new ProgramMethod(1, 1, 1, new Clazz[]{libraryClass}, 1, "Processing Info");

    // Assert
    assertEquals("Processing Info", actualProgramMethod.getProcessingInfo());
    assertEquals(0, actualProgramMethod.attributes.length);
    assertEquals(0, actualProgramMethod.u2attributesCount);
    assertEquals(1, actualProgramMethod.getAccessFlags());
    assertEquals(1, actualProgramMethod.getProcessingFlags());
    Clazz[] clazzArray = actualProgramMethod.referencedClasses;
    assertEquals(1, clazzArray.length);
    assertEquals(1, actualProgramMethod.u2descriptorIndex);
    assertEquals(1, actualProgramMethod.u2nameIndex);
    assertSame(libraryClass, clazzArray[0]);
  }
}
