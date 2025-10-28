package proguard.classfile.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.ProgramClass;

public class ClassSubHierarchyInitializerDiffblueTest {
  /**
   * Method under test: {@link ClassSubHierarchyInitializer#visitAnyClass(Clazz)}
   */
  @Test
  public void testVisitAnyClass() {
    // Arrange
    ClassSubHierarchyInitializer classSubHierarchyInitializer = new ClassSubHierarchyInitializer();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> classSubHierarchyInitializer.visitAnyClass(new LibraryClass()));
  }

  /**
   * Method under test:
   * {@link ClassSubHierarchyInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  public void testVisitLibraryClass() {
    // Arrange
    ClassSubHierarchyInitializer classSubHierarchyInitializer = new ClassSubHierarchyInitializer();
    LibraryClass libraryClass = new LibraryClass();

    // Act
    classSubHierarchyInitializer.visitLibraryClass(libraryClass);

    // Assert
    assertNull(libraryClass.getSuperClass());
    assertEquals(0, libraryClass.interfaceClasses.length);
  }

  /**
   * Method under test:
   * {@link ClassSubHierarchyInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  public void testVisitLibraryClass2() {
    // Arrange
    ClassSubHierarchyInitializer classSubHierarchyInitializer = new ClassSubHierarchyInitializer();
    LibraryClass libraryClass = new LibraryClass();
    libraryClass.interfaceClasses = null;
    libraryClass.superClass = null;

    // Act
    classSubHierarchyInitializer.visitLibraryClass(libraryClass);

    // Assert
    assertNull(libraryClass.interfaceClasses);
    assertNull(libraryClass.getSuperClass());
  }

  /**
   * Method under test:
   * {@link ClassSubHierarchyInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  public void testVisitLibraryClass3() {
    // Arrange
    ClassSubHierarchyInitializer classSubHierarchyInitializer = new ClassSubHierarchyInitializer();
    LibraryClass libraryClass = new LibraryClass();
    libraryClass.interfaceClasses = null;
    LibraryClass libraryClass2 = new LibraryClass();
    libraryClass.superClass = libraryClass2;

    // Act
    classSubHierarchyInitializer.visitLibraryClass(libraryClass);

    // Assert
    assertNull(libraryClass.interfaceClasses);
    assertSame(libraryClass2, libraryClass.getSuperClass());
  }

  /**
   * Method under test:
   * {@link ClassSubHierarchyInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  public void testVisitLibraryClass4() {
    // Arrange
    ClassSubHierarchyInitializer classSubHierarchyInitializer = new ClassSubHierarchyInitializer();
    LibraryClass libraryClass = new LibraryClass();
    LibraryClass libraryClass2 = new LibraryClass();
    libraryClass.interfaceClasses = new Clazz[]{libraryClass2};
    libraryClass.superClass = null;

    // Act
    classSubHierarchyInitializer.visitLibraryClass(libraryClass);

    // Assert
    assertNull(libraryClass.getSuperClass());
    Clazz[] clazzArray = libraryClass.interfaceClasses;
    assertEquals(1, clazzArray.length);
    assertSame(libraryClass2, clazzArray[0]);
  }

  /**
   * Method under test:
   * {@link ClassSubHierarchyInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  public void testVisitLibraryClass5() {
    // Arrange
    ClassSubHierarchyInitializer classSubHierarchyInitializer = new ClassSubHierarchyInitializer();
    LibraryClass libraryClass = new LibraryClass();
    libraryClass.interfaceClasses = null;
    ProgramClass programClass = new ProgramClass();
    libraryClass.superClass = programClass;

    // Act
    classSubHierarchyInitializer.visitLibraryClass(libraryClass);

    // Assert
    assertNull(libraryClass.interfaceClasses);
    assertSame(programClass, libraryClass.getSuperClass());
  }

  /**
   * Method under test:
   * {@link ClassSubHierarchyInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  public void testVisitLibraryClass6() {
    // Arrange
    ClassSubHierarchyInitializer classSubHierarchyInitializer = new ClassSubHierarchyInitializer();
    LibraryClass libraryClass = new LibraryClass();
    ProgramClass programClass = new ProgramClass();
    libraryClass.interfaceClasses = new Clazz[]{programClass};
    libraryClass.superClass = null;

    // Act
    classSubHierarchyInitializer.visitLibraryClass(libraryClass);

    // Assert
    assertNull(libraryClass.getSuperClass());
    Clazz[] clazzArray = libraryClass.interfaceClasses;
    assertEquals(1, clazzArray.length);
    assertSame(programClass, clazzArray[0]);
  }

  /**
   * Method under test:
   * {@link ClassSubHierarchyInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  public void testVisitLibraryClass7() {
    // Arrange
    ClassSubHierarchyInitializer classSubHierarchyInitializer = new ClassSubHierarchyInitializer();
    LibraryClass libraryClass = new LibraryClass();
    libraryClass.interfaceClasses = new Clazz[]{null};
    libraryClass.superClass = null;

    // Act
    classSubHierarchyInitializer.visitLibraryClass(libraryClass);

    // Assert
    assertNull(libraryClass.getSuperClass());
    Clazz[] clazzArray = libraryClass.interfaceClasses;
    assertNull(clazzArray[0]);
    assertEquals(1, clazzArray.length);
  }
}
