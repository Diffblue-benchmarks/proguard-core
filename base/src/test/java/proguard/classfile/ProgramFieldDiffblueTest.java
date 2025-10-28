package proguard.classfile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;

public class ProgramFieldDiffblueTest {
  /**
   * Method under test: {@link ProgramField#ProgramField()}
   */
  @Test
  public void testNewProgramField() {
    // Arrange and Act
    ProgramField actualProgramField = new ProgramField();

    // Assert
    assertNull(actualProgramField.getProcessingInfo());
    assertEquals(0, actualProgramField.getAccessFlags());
    assertEquals(0, actualProgramField.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link ProgramField#ProgramField(int, int, int, int, Attribute[], Clazz)}
   */
  @Test
  public void testNewProgramField2() {
    // Arrange and Act
    ProgramField actualProgramField = new ProgramField(1, 1, 1, 3, new Attribute[]{new BootstrapMethodsAttribute()},
        new LibraryClass());

    // Assert
    assertNull(actualProgramField.getProcessingInfo());
    assertEquals(0, actualProgramField.getProcessingFlags());
    assertEquals(1, actualProgramField.getAccessFlags());
  }

  /**
   * Method under test:
   * {@link ProgramField#ProgramField(int, int, int, int, Attribute[], Clazz, int, Object)}
   */
  @Test
  public void testNewProgramField3() {
    // Arrange and Act
    ProgramField actualProgramField = new ProgramField(1, 1, 1, 3, new Attribute[]{new BootstrapMethodsAttribute()},
        new LibraryClass(), 1, "Processing Info");

    // Assert
    assertEquals("Processing Info", actualProgramField.getProcessingInfo());
    assertEquals(1, actualProgramField.getAccessFlags());
    assertEquals(1, actualProgramField.getProcessingFlags());
  }

  /**
   * Method under test: {@link ProgramField#ProgramField(int, int, int, Clazz)}
   */
  @Test
  public void testNewProgramField4() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ProgramField actualProgramField = new ProgramField(1, 1, 1, referencedClass);

    // Assert
    Clazz clazz = actualProgramField.referencedClass;
    assertTrue(clazz instanceof LibraryClass);
    assertNull(((LibraryClass) clazz).interfaceNames);
    assertNull(((LibraryClass) clazz).fields);
    assertNull(((LibraryClass) clazz).methods);
    assertNull(clazz.getProcessingInfo());
    assertNull(actualProgramField.getProcessingInfo());
    assertNull(clazz.getName());
    assertNull(clazz.getSuperName());
    assertNull(clazz.getFeatureName());
    assertNull(clazz.getSuperClass());
    assertNull(((LibraryClass) clazz).kotlinMetadata);
    assertEquals(0, clazz.getAccessFlags());
    assertEquals(0, clazz.getInterfaceCount());
    assertEquals(0, clazz.getProcessingFlags());
    assertEquals(0, actualProgramField.getProcessingFlags());
    Clazz[] clazzArray = ((LibraryClass) clazz).interfaceClasses;
    assertEquals(0, clazzArray.length);
    assertEquals(0, actualProgramField.attributes.length);
    assertEquals(0, ((LibraryClass) clazz).subClassCount);
    assertEquals(0, actualProgramField.u2attributesCount);
    assertEquals(1, actualProgramField.getAccessFlags());
    assertEquals(1, actualProgramField.u2descriptorIndex);
    assertEquals(1, actualProgramField.u2nameIndex);
    assertFalse(((LibraryClass) clazz).isVisible());
    assertTrue(clazz.getExtraFeatureNames().isEmpty());
    Clazz[] clazzArray2 = referencedClass.subClasses;
    assertSame(clazzArray2, clazzArray);
    assertSame(clazzArray2, ((LibraryClass) clazz).subClasses);
  }

  /**
   * Method under test:
   * {@link ProgramField#ProgramField(int, int, int, Clazz, int, Object)}
   */
  @Test
  public void testNewProgramField5() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ProgramField actualProgramField = new ProgramField(1, 1, 1, referencedClass, 1, "Processing Info");

    // Assert
    Clazz clazz = actualProgramField.referencedClass;
    assertTrue(clazz instanceof LibraryClass);
    assertEquals("Processing Info", actualProgramField.getProcessingInfo());
    assertNull(((LibraryClass) clazz).interfaceNames);
    assertNull(((LibraryClass) clazz).fields);
    assertNull(((LibraryClass) clazz).methods);
    assertNull(clazz.getProcessingInfo());
    assertNull(clazz.getName());
    assertNull(clazz.getSuperName());
    assertNull(clazz.getFeatureName());
    assertNull(clazz.getSuperClass());
    assertNull(((LibraryClass) clazz).kotlinMetadata);
    assertEquals(0, clazz.getAccessFlags());
    assertEquals(0, clazz.getInterfaceCount());
    assertEquals(0, clazz.getProcessingFlags());
    Clazz[] clazzArray = ((LibraryClass) clazz).interfaceClasses;
    assertEquals(0, clazzArray.length);
    assertEquals(0, actualProgramField.attributes.length);
    assertEquals(0, ((LibraryClass) clazz).subClassCount);
    assertEquals(0, actualProgramField.u2attributesCount);
    assertEquals(1, actualProgramField.getAccessFlags());
    assertEquals(1, actualProgramField.getProcessingFlags());
    assertEquals(1, actualProgramField.u2descriptorIndex);
    assertEquals(1, actualProgramField.u2nameIndex);
    assertFalse(((LibraryClass) clazz).isVisible());
    assertTrue(clazz.getExtraFeatureNames().isEmpty());
    Clazz[] clazzArray2 = referencedClass.subClasses;
    assertSame(clazzArray2, clazzArray);
    assertSame(clazzArray2, ((LibraryClass) clazz).subClasses);
  }
}
