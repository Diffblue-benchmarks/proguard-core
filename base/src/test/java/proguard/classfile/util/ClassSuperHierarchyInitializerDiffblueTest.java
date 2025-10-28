package proguard.classfile.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.kotlin.KotlinConstants;

public class ClassSuperHierarchyInitializerDiffblueTest {
  /**
   * Method under test:
   * {@link ClassSuperHierarchyInitializer#visitAnyClass(Clazz)}
   */
  @Test
  public void testVisitAnyClass() {
    // Arrange
    ClassSuperHierarchyInitializer classSuperHierarchyInitializer = new ClassSuperHierarchyInitializer(
        KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> classSuperHierarchyInitializer.visitAnyClass(new LibraryClass()));
  }

  /**
   * Method under test:
   * {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  public void testVisitLibraryClass() {
    // Arrange
    ClassSuperHierarchyInitializer classSuperHierarchyInitializer = new ClassSuperHierarchyInitializer(
        KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass libraryClass = new LibraryClass();

    // Act
    classSuperHierarchyInitializer.visitLibraryClass(libraryClass);

    // Assert that nothing has changed
    assertEquals(0, libraryClass.getInterfaceCount());
    assertEquals(0, libraryClass.interfaceClasses.length);
  }

  /**
   * Method under test:
   * {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  public void testVisitLibraryClass2() {
    // Arrange
    ClassSuperHierarchyInitializer classSuperHierarchyInitializer = new ClassSuperHierarchyInitializer(
        KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass libraryClass = new LibraryClass();
    libraryClass.superClassName = null;
    libraryClass.interfaceNames = new String[]{"Library Class"};

    // Act
    classSuperHierarchyInitializer.visitLibraryClass(libraryClass);

    // Assert
    Clazz[] clazzArray = libraryClass.interfaceClasses;
    assertNull(clazzArray[0]);
    assertEquals(1, libraryClass.getInterfaceCount());
    assertEquals(1, clazzArray.length);
  }
}
