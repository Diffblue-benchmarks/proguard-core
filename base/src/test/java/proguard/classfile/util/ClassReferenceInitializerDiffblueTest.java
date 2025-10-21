package proguard.classfile.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.ClassPool;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.ProgramClass;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.classfile.kotlin.KotlinMetadata;
import proguard.classfile.kotlin.KotlinMultiFileFacadeKindMetadata;

public class ClassReferenceInitializerDiffblueTest {
  /**
   * Test {@link ClassReferenceInitializer#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitAnyClass(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassReferenceInitializer.visitAnyClass(Clazz)"})
  public void testVisitAnyClass_whenLibraryClass_thenThrowUnsupportedOperationException() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> classReferenceInitializer.visitAnyClass(new LibraryClass()));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassReferenceInitializer.visitLibraryClass(LibraryClass)"})
  public void testVisitLibraryClass() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    KotlinMultiFileFacadeKindMetadata kotlinMetadata =
        new KotlinMultiFileFacadeKindMetadata(
            new int[] {1, 0, 1, 0}, new String[] {"D1"}, 1, "Xs", "Pn");

    LibraryClass libraryClass =
        new LibraryClass(1, "This Class Name", "Super Class Name", kotlinMetadata);

    // Act
    classReferenceInitializer.visitLibraryClass(libraryClass);

    // Assert
    KotlinMetadata kotlinMetadata2 = libraryClass.kotlinMetadata;
    assertTrue(kotlinMetadata2 instanceof KotlinMultiFileFacadeKindMetadata);
    List<Clazz> clazzList =
        ((KotlinMultiFileFacadeKindMetadata) kotlinMetadata2).referencedPartClasses;
    assertEquals(1, clazzList.size());
    assertNull(clazzList.get(0));
    assertSame(kotlinMetadata.referencedPartClasses, clazzList);
  }

  /**
   * Test {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassReferenceInitializer.visitLibraryClass(LibraryClass)"})
  public void testVisitLibraryClass2() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    KotlinMultiFileFacadeKindMetadata kotlinMetadata =
        new KotlinMultiFileFacadeKindMetadata(
            new int[] {1, 0, 1, 0}, new String[] {"kotlin/Function"}, 1, "Xs", "Pn");

    LibraryClass libraryClass =
        new LibraryClass(1, "This Class Name", "Super Class Name", kotlinMetadata);

    // Act
    classReferenceInitializer.visitLibraryClass(libraryClass);

    // Assert
    KotlinMetadata kotlinMetadata2 = libraryClass.kotlinMetadata;
    List<Clazz> clazzList =
        ((KotlinMultiFileFacadeKindMetadata) kotlinMetadata2).referencedPartClasses;
    assertEquals(1, clazzList.size());
    assertTrue(clazzList.get(0) instanceof ProgramClass);
    assertTrue(kotlinMetadata2 instanceof KotlinMultiFileFacadeKindMetadata);
    assertSame(kotlinMetadata.referencedPartClasses, clazzList);
  }

  /**
   * Test {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassReferenceInitializer.visitLibraryClass(LibraryClass)"})
  public void testVisitLibraryClass3() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    KotlinMultiFileFacadeKindMetadata kotlinMetadata =
        new KotlinMultiFileFacadeKindMetadata(
            new int[] {1, 0, 1, 0}, new String[] {""}, 1, "Xs", "Pn");

    LibraryClass libraryClass =
        new LibraryClass(1, "This Class Name", "Super Class Name", kotlinMetadata);

    // Act
    classReferenceInitializer.visitLibraryClass(libraryClass);

    // Assert
    KotlinMetadata kotlinMetadata2 = libraryClass.kotlinMetadata;
    assertTrue(kotlinMetadata2 instanceof KotlinMultiFileFacadeKindMetadata);
    assertSame(
        kotlinMetadata.referencedPartClasses,
        ((KotlinMultiFileFacadeKindMetadata) kotlinMetadata2).referencedPartClasses);
  }

  /**
   * Test {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassReferenceInitializer.visitLibraryClass(LibraryClass)"})
  public void testVisitLibraryClass4() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass libraryClass =
        new LibraryClass(
            1,
            "This Class Name",
            "Super Class Name",
            new KotlinMultiFileFacadeKindMetadata(
                new int[] {1, 0, 1, 0}, new String[] {}, 1, "Xs", "Pn"));

    // Act
    classReferenceInitializer.visitLibraryClass(libraryClass);

    // Assert
    KotlinMetadata kotlinMetadata = libraryClass.kotlinMetadata;
    assertTrue(kotlinMetadata instanceof KotlinMultiFileFacadeKindMetadata);
    assertTrue(
        ((KotlinMultiFileFacadeKindMetadata) kotlinMetadata).referencedPartClasses.isEmpty());
  }

  /**
   * Test {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassReferenceInitializer.visitLibraryClass(LibraryClass)"})
  public void testVisitLibraryClass5() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass libraryClass =
        new LibraryClass(
            1,
            "This Class Name",
            "Super Class Name",
            new KotlinMultiFileFacadeKindMetadata(
                new int[] {1, 0, 1, 0},
                new String[] {"kotlin/Function", "kotlin/reflect/KFunction"},
                1,
                "Xs",
                "Pn"));

    // Act
    classReferenceInitializer.visitLibraryClass(libraryClass);

    // Assert
    KotlinMetadata kotlinMetadata = libraryClass.kotlinMetadata;
    List<Clazz> clazzList =
        ((KotlinMultiFileFacadeKindMetadata) kotlinMetadata).referencedPartClasses;
    assertEquals(2, clazzList.size());
    assertTrue(clazzList.get(0) instanceof ProgramClass);
    assertTrue(clazzList.get(1) instanceof ProgramClass);
    assertTrue(kotlinMetadata instanceof KotlinMultiFileFacadeKindMetadata);
  }

  /**
   * Test {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassReferenceInitializer.visitLibraryClass(LibraryClass)"})
  public void testVisitLibraryClass6() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(new ClassPool(), KotlinConstants.dummyClassPool);
    KotlinMultiFileFacadeKindMetadata kotlinMetadata =
        new KotlinMultiFileFacadeKindMetadata(
            new int[] {1, 0, 1, 0}, new String[] {"kotlin/Function"}, 1, "Xs", "Pn");

    LibraryClass libraryClass =
        new LibraryClass(1, "This Class Name", "Super Class Name", kotlinMetadata);

    // Act
    classReferenceInitializer.visitLibraryClass(libraryClass);

    // Assert
    KotlinMetadata kotlinMetadata2 = libraryClass.kotlinMetadata;
    List<Clazz> clazzList =
        ((KotlinMultiFileFacadeKindMetadata) kotlinMetadata2).referencedPartClasses;
    assertEquals(1, clazzList.size());
    assertTrue(clazzList.get(0) instanceof ProgramClass);
    assertTrue(kotlinMetadata2 instanceof KotlinMultiFileFacadeKindMetadata);
    assertSame(kotlinMetadata.referencedPartClasses, clazzList);
  }
}
