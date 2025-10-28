package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.BootstrapMethodInfo;
import proguard.classfile.attribute.BootstrapMethodsAttribute;

public class BootstrapMethodInfoAdderDiffblueTest {
  /**
   * Method under test: {@link BootstrapMethodInfoAdder#getBootstrapMethodIndex()}
   */
  @Test
  public void testGetBootstrapMethodIndex() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act and Assert
    assertEquals(0,
        (new BootstrapMethodInfoAdder(targetClass, new BootstrapMethodsAttribute())).getBootstrapMethodIndex());
  }

  /**
   * Method under test:
   * {@link BootstrapMethodInfoAdder#visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)}
   */
  @Test
  public void testVisitBootstrapMethodInfo() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    BootstrapMethodInfoAdder bootstrapMethodInfoAdder = new BootstrapMethodInfoAdder(targetClass,
        new BootstrapMethodsAttribute(1, 3, new BootstrapMethodInfo[]{new BootstrapMethodInfo()}));
    LibraryClass clazz = new LibraryClass();

    // Act
    bootstrapMethodInfoAdder.visitBootstrapMethodInfo(clazz, new BootstrapMethodInfo());

    // Assert
    assertEquals(3, bootstrapMethodInfoAdder.getBootstrapMethodIndex());
  }

  /**
   * Method under test:
   * {@link BootstrapMethodInfoAdder#BootstrapMethodInfoAdder(ProgramClass, BootstrapMethodsAttribute)}
   */
  @Test
  public void testNewBootstrapMethodInfoAdder() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act and Assert
    assertEquals(0,
        (new BootstrapMethodInfoAdder(targetClass, new BootstrapMethodsAttribute())).getBootstrapMethodIndex());
  }

  /**
   * Method under test:
   * {@link BootstrapMethodInfoAdder#BootstrapMethodInfoAdder(ProgramClass, BootstrapMethodsAttribute)}
   */
  @Test
  public void testNewBootstrapMethodInfoAdder2() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 2;

    // Act and Assert
    assertEquals(0,
        (new BootstrapMethodInfoAdder(targetClass, new BootstrapMethodsAttribute())).getBootstrapMethodIndex());
  }
}
