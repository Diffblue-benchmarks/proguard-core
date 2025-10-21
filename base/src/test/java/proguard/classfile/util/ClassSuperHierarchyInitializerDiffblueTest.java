package proguard.classfile.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.ClassPool;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.ProgramClass;
import proguard.classfile.kotlin.KotlinConstants;

public class ClassSuperHierarchyInitializerDiffblueTest {
  /**
   * Test {@link ClassSuperHierarchyInitializer#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassSuperHierarchyInitializer#visitAnyClass(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassSuperHierarchyInitializer.visitAnyClass(Clazz)"})
  public void testVisitAnyClass_whenLibraryClass_thenThrowUnsupportedOperationException() {
    // Arrange
    ClassSuperHierarchyInitializer classSuperHierarchyInitializer =
        new ClassSuperHierarchyInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> classSuperHierarchyInitializer.visitAnyClass(new LibraryClass()));
  }

  /**
   * Test {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <p>Method under test: {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassSuperHierarchyInitializer.visitLibraryClass(LibraryClass)"})
  public void testVisitLibraryClass() {
    // Arrange
    ClassSuperHierarchyInitializer classSuperHierarchyInitializer =
        new ClassSuperHierarchyInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass libraryClass = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    classSuperHierarchyInitializer.visitLibraryClass(libraryClass);

    // Assert that nothing has changed
    assertEquals(0, libraryClass.getInterfaceCount());
    assertEquals(0, libraryClass.interfaceClasses.length);
  }

  /**
   * Test {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <p>Method under test: {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassSuperHierarchyInitializer.visitLibraryClass(LibraryClass)"})
  public void testVisitLibraryClass2() {
    // Arrange
    WarningPrinter missingWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    ClassSuperHierarchyInitializer classSuperHierarchyInitializer =
        new ClassSuperHierarchyInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            missingWarningPrinter,
            new WarningPrinter(new PrintWriter(new StringWriter())));
    LibraryClass libraryClass = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    classSuperHierarchyInitializer.visitLibraryClass(libraryClass);

    // Assert that nothing has changed
    assertEquals(0, libraryClass.getInterfaceCount());
    assertEquals(0, libraryClass.interfaceClasses.length);
  }

  /**
   * Test {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <p>Method under test: {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassSuperHierarchyInitializer.visitLibraryClass(LibraryClass)"})
  public void testVisitLibraryClass3() {
    // Arrange
    ClassSuperHierarchyInitializer classSuperHierarchyInitializer =
        new ClassSuperHierarchyInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass libraryClass = new LibraryClass(1, "This Class Name", "kotlin/Function");

    // Act
    classSuperHierarchyInitializer.visitLibraryClass(libraryClass);

    // Assert
    assertTrue(libraryClass.getSuperClass() instanceof ProgramClass);
  }

  /**
   * Test {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <p>Method under test: {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassSuperHierarchyInitializer.visitLibraryClass(LibraryClass)"})
  public void testVisitLibraryClass4() {
    // Arrange
    PrintWriter printWriter = new PrintWriter(new StringWriter());
    WarningPrinter missingWarningPrinter = new WarningPrinter(printWriter, new ArrayList<>());

    ClassSuperHierarchyInitializer classSuperHierarchyInitializer =
        new ClassSuperHierarchyInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            missingWarningPrinter,
            new WarningPrinter(new PrintWriter(new StringWriter())));
    LibraryClass libraryClass = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    classSuperHierarchyInitializer.visitLibraryClass(libraryClass);

    // Assert that nothing has changed
    assertEquals(0, libraryClass.getInterfaceCount());
    assertEquals(0, libraryClass.interfaceClasses.length);
  }

  /**
   * Test {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <p>Method under test: {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassSuperHierarchyInitializer.visitLibraryClass(LibraryClass)"})
  public void testVisitLibraryClass5() {
    // Arrange
    WarningPrinter missingWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    ClassSuperHierarchyInitializer classSuperHierarchyInitializer =
        new ClassSuperHierarchyInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            missingWarningPrinter,
            new WarningPrinter(new PrintWriter(new StringWriter())));
    LibraryClass libraryClass = new LibraryClass(1, "This Class Name", "kotlin/Function");

    // Act
    classSuperHierarchyInitializer.visitLibraryClass(libraryClass);

    // Assert
    assertTrue(libraryClass.getSuperClass() instanceof ProgramClass);
  }

  /**
   * Test {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <p>Method under test: {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassSuperHierarchyInitializer.visitLibraryClass(LibraryClass)"})
  public void testVisitLibraryClass6() {
    // Arrange
    ClassSuperHierarchyInitializer classSuperHierarchyInitializer =
        new ClassSuperHierarchyInitializer(new ClassPool(), KotlinConstants.dummyClassPool);
    LibraryClass libraryClass = new LibraryClass(1, "This Class Name", "kotlin/Function");

    // Act
    classSuperHierarchyInitializer.visitLibraryClass(libraryClass);

    // Assert
    assertTrue(libraryClass.getSuperClass() instanceof ProgramClass);
  }

  /**
   * Test {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <p>Method under test: {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassSuperHierarchyInitializer.visitLibraryClass(LibraryClass)"})
  public void testVisitLibraryClass7() {
    // Arrange
    ClassSuperHierarchyInitializer classSuperHierarchyInitializer =
        new ClassSuperHierarchyInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            new WarningPrinter(new PrintWriter(new StringWriter())),
            null);
    LibraryClass libraryClass = new LibraryClass(1, "This Class Name", "kotlin/Function");

    // Act
    classSuperHierarchyInitializer.visitLibraryClass(libraryClass);

    // Assert
    assertTrue(libraryClass.getSuperClass() instanceof ProgramClass);
  }

  /**
   * Test {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassSuperHierarchyInitializer.visitLibraryClass(LibraryClass)"})
  public void testVisitLibraryClass_givenArrayListAdd42() {
    // Arrange
    ArrayList<Object> classFilter = new ArrayList<>();
    classFilter.add("42");
    WarningPrinter missingWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()), classFilter);

    ClassSuperHierarchyInitializer classSuperHierarchyInitializer =
        new ClassSuperHierarchyInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            missingWarningPrinter,
            new WarningPrinter(new PrintWriter(new StringWriter())));
    LibraryClass libraryClass = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    classSuperHierarchyInitializer.visitLibraryClass(libraryClass);

    // Assert that nothing has changed
    assertEquals(0, libraryClass.getInterfaceCount());
    assertEquals(0, libraryClass.interfaceClasses.length);
  }

  /**
   * Test {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then {@link LibraryClass#LibraryClass()} SuperClass is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassSuperHierarchyInitializer.visitLibraryClass(LibraryClass)"})
  public void testVisitLibraryClass_givenNull_thenLibraryClassSuperClassIsNull() {
    // Arrange
    ClassSuperHierarchyInitializer classSuperHierarchyInitializer =
        new ClassSuperHierarchyInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass libraryClass = new LibraryClass();
    libraryClass.superClassName = null;
    libraryClass.interfaceNames = new String[] {"Library Class"};

    // Act
    classSuperHierarchyInitializer.visitLibraryClass(libraryClass);

    // Assert
    assertNull(libraryClass.getSuperClass());
    Clazz[] clazzArray = libraryClass.interfaceClasses;
    assertNull(clazzArray[0]);
    assertEquals(1, libraryClass.getInterfaceCount());
    assertEquals(1, clazzArray.length);
  }

  /**
   * Test {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then {@link LibraryClass#LibraryClass()} InterfaceCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassSuperHierarchyInitializer.visitLibraryClass(LibraryClass)"})
  public void testVisitLibraryClass_whenLibraryClass_thenLibraryClassInterfaceCountIsZero() {
    // Arrange
    ClassSuperHierarchyInitializer classSuperHierarchyInitializer =
        new ClassSuperHierarchyInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass libraryClass = new LibraryClass();

    // Act
    classSuperHierarchyInitializer.visitLibraryClass(libraryClass);

    // Assert that nothing has changed
    assertEquals(0, libraryClass.getInterfaceCount());
    assertEquals(0, libraryClass.interfaceClasses.length);
  }
}
