package proguard.classfile.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.ProgramClass;

public class ClassSubHierarchyInitializerDiffblueTest {
  /**
   * Test {@link ClassSubHierarchyInitializer#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassSubHierarchyInitializer#visitAnyClass(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassSubHierarchyInitializer.visitAnyClass(Clazz)"})
  public void testVisitAnyClass_whenLibraryClass_thenThrowUnsupportedOperationException() {
    // Arrange
    ClassSubHierarchyInitializer classSubHierarchyInitializer = new ClassSubHierarchyInitializer();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> classSubHierarchyInitializer.visitAnyClass(new LibraryClass()));
  }

  /**
   * Test {@link ClassSubHierarchyInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <ul>
   *   <li>Given {@link LibraryClass#LibraryClass()}.
   *   <li>Then {@link LibraryClass#LibraryClass()} SuperClass {@link LibraryClass}.
   * </ul>
   *
   * <p>Method under test: {@link ClassSubHierarchyInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassSubHierarchyInitializer.visitLibraryClass(LibraryClass)"})
  public void testVisitLibraryClass_givenLibraryClass_thenLibraryClassSuperClassLibraryClass() {
    // Arrange
    ClassSubHierarchyInitializer classSubHierarchyInitializer = new ClassSubHierarchyInitializer();
    LibraryClass libraryClass = new LibraryClass();
    LibraryClass libraryClass2 = new LibraryClass();
    libraryClass.superClass = libraryClass2;
    libraryClass.interfaceClasses = null;

    // Act
    classSubHierarchyInitializer.visitLibraryClass(libraryClass);

    // Assert
    Clazz superClass = libraryClass.getSuperClass();
    assertTrue(superClass instanceof LibraryClass);
    Clazz[] clazzArray = ((LibraryClass) superClass).subClasses;
    assertEquals(1, clazzArray.length);
    assertEquals(1, ((LibraryClass) superClass).subClassCount);
    assertSame(libraryClass, clazzArray[0]);
    assertSame(libraryClass2.subClasses, clazzArray);
  }

  /**
   * Test {@link ClassSubHierarchyInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <ul>
   *   <li>Given {@link ProgramClass#ProgramClass()}.
   *   <li>Then {@link LibraryClass#LibraryClass()} SuperClass {@link ProgramClass}.
   * </ul>
   *
   * <p>Method under test: {@link ClassSubHierarchyInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassSubHierarchyInitializer.visitLibraryClass(LibraryClass)"})
  public void testVisitLibraryClass_givenProgramClass_thenLibraryClassSuperClassProgramClass() {
    // Arrange
    ClassSubHierarchyInitializer classSubHierarchyInitializer = new ClassSubHierarchyInitializer();
    LibraryClass libraryClass = new LibraryClass();
    ProgramClass programClass = new ProgramClass();
    libraryClass.superClass = programClass;
    libraryClass.interfaceClasses = null;

    // Act
    classSubHierarchyInitializer.visitLibraryClass(libraryClass);

    // Assert
    Clazz superClass = libraryClass.getSuperClass();
    assertTrue(superClass instanceof ProgramClass);
    Clazz[] clazzArray = ((ProgramClass) superClass).subClasses;
    assertEquals(1, clazzArray.length);
    assertEquals(1, ((ProgramClass) superClass).subClassCount);
    assertSame(libraryClass, clazzArray[0]);
    assertSame(programClass.subClasses, clazzArray);
  }

  /**
   * Test {@link ClassSubHierarchyInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <ul>
   *   <li>Then first element {@link LibraryClass}.
   * </ul>
   *
   * <p>Method under test: {@link ClassSubHierarchyInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassSubHierarchyInitializer.visitLibraryClass(LibraryClass)"})
  public void testVisitLibraryClass_thenFirstElementLibraryClass() {
    // Arrange
    ClassSubHierarchyInitializer classSubHierarchyInitializer = new ClassSubHierarchyInitializer();
    LibraryClass libraryClass = new LibraryClass();
    libraryClass.superClass = null;
    LibraryClass libraryClass2 = new LibraryClass();
    libraryClass.interfaceClasses = new Clazz[] {libraryClass2};

    // Act
    classSubHierarchyInitializer.visitLibraryClass(libraryClass);

    // Assert
    Clazz[] clazzArray = libraryClass.interfaceClasses;
    Clazz clazz = clazzArray[0];
    assertTrue(clazz instanceof LibraryClass);
    assertEquals(1, clazzArray.length);
    Clazz[] clazzArray2 = ((LibraryClass) clazz).subClasses;
    assertEquals(1, clazzArray2.length);
    assertEquals(1, ((LibraryClass) clazz).subClassCount);
    assertSame(libraryClass, clazzArray2[0]);
    assertSame(libraryClass2.subClasses, clazzArray2);
  }

  /**
   * Test {@link ClassSubHierarchyInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <ul>
   *   <li>Then first element {@link ProgramClass}.
   * </ul>
   *
   * <p>Method under test: {@link ClassSubHierarchyInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassSubHierarchyInitializer.visitLibraryClass(LibraryClass)"})
  public void testVisitLibraryClass_thenFirstElementProgramClass() {
    // Arrange
    ClassSubHierarchyInitializer classSubHierarchyInitializer = new ClassSubHierarchyInitializer();
    LibraryClass libraryClass = new LibraryClass();
    libraryClass.superClass = null;
    ProgramClass programClass = new ProgramClass();
    libraryClass.interfaceClasses = new Clazz[] {programClass};

    // Act
    classSubHierarchyInitializer.visitLibraryClass(libraryClass);

    // Assert
    Clazz[] clazzArray = libraryClass.interfaceClasses;
    Clazz clazz = clazzArray[0];
    assertTrue(clazz instanceof ProgramClass);
    assertEquals(1, clazzArray.length);
    Clazz[] clazzArray2 = ((ProgramClass) clazz).subClasses;
    assertEquals(1, clazzArray2.length);
    assertEquals(1, ((ProgramClass) clazz).subClassCount);
    assertSame(libraryClass, clazzArray2[0]);
    assertSame(programClass.subClasses, clazzArray2);
  }
}
