package proguard.classfile.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import proguard.classfile.ClassPool;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.classfile.kotlin.KotlinMetadata;
import proguard.classfile.kotlin.KotlinMultiFileFacadeKindMetadata;

public class ClassReferenceInitializerDiffblueTest {
  /**
   * Method under test: {@link ClassReferenceInitializer#visitAnyClass(Clazz)}
   */
  @Test
  public void testVisitAnyClass() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer = new ClassReferenceInitializer(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> classReferenceInitializer.visitAnyClass(new LibraryClass()));
  }

  /**
   * Method under test:
   * {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  public void testVisitLibraryClass() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer = new ClassReferenceInitializer(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool);
    KotlinMultiFileFacadeKindMetadata kotlinMetadata = new KotlinMultiFileFacadeKindMetadata(new int[]{1, 0, 1, 0},
        new String[]{"D1"}, 1, "Xs", "Pn");

    LibraryClass libraryClass = new LibraryClass(1, "This Class Name", "Super Class Name", kotlinMetadata);

    // Act
    classReferenceInitializer.visitLibraryClass(libraryClass);

    // Assert
    KotlinMetadata kotlinMetadata2 = libraryClass.kotlinMetadata;
    assertTrue(kotlinMetadata2 instanceof KotlinMultiFileFacadeKindMetadata);
    List<Clazz> clazzList = ((KotlinMultiFileFacadeKindMetadata) kotlinMetadata2).referencedPartClasses;
    assertEquals(1, clazzList.size());
    assertNull(clazzList.get(0));
    assertSame(kotlinMetadata.referencedPartClasses, clazzList);
  }

  /**
   * Method under test:
   * {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  public void testVisitLibraryClass2() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer = new ClassReferenceInitializer(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool);
    KotlinMultiFileFacadeKindMetadata kotlinMetadata = new KotlinMultiFileFacadeKindMetadata(new int[]{1, 0, 1, 0},
        new String[]{"kotlin/Function"}, 1, "Xs", "Pn");

    LibraryClass libraryClass = new LibraryClass(1, "This Class Name", "Super Class Name", kotlinMetadata);

    // Act
    classReferenceInitializer.visitLibraryClass(libraryClass);

    // Assert
    KotlinMetadata kotlinMetadata2 = libraryClass.kotlinMetadata;
    assertTrue(kotlinMetadata2 instanceof KotlinMultiFileFacadeKindMetadata);
    assertSame(kotlinMetadata.referencedPartClasses,
        ((KotlinMultiFileFacadeKindMetadata) kotlinMetadata2).referencedPartClasses);
  }

  /**
   * Method under test:
   * {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  public void testVisitLibraryClass3() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer = new ClassReferenceInitializer(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool);
    KotlinMultiFileFacadeKindMetadata kotlinMetadata = new KotlinMultiFileFacadeKindMetadata(new int[]{1, 0, 1, 0},
        new String[]{""}, 1, "Xs", "Pn");

    LibraryClass libraryClass = new LibraryClass(1, "This Class Name", "Super Class Name", kotlinMetadata);

    // Act
    classReferenceInitializer.visitLibraryClass(libraryClass);

    // Assert
    KotlinMetadata kotlinMetadata2 = libraryClass.kotlinMetadata;
    assertTrue(kotlinMetadata2 instanceof KotlinMultiFileFacadeKindMetadata);
    assertSame(kotlinMetadata.referencedPartClasses,
        ((KotlinMultiFileFacadeKindMetadata) kotlinMetadata2).referencedPartClasses);
  }

  /**
   * Method under test:
   * {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  public void testVisitLibraryClass4() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer = new ClassReferenceInitializer(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool);
    KotlinMultiFileFacadeKindMetadata kotlinMetadata = new KotlinMultiFileFacadeKindMetadata(new int[]{1, 0, 1, 0},
        new String[]{}, 1, "Xs", "Pn");

    LibraryClass libraryClass = new LibraryClass(1, "This Class Name", "Super Class Name", kotlinMetadata);

    // Act
    classReferenceInitializer.visitLibraryClass(libraryClass);

    // Assert
    KotlinMetadata kotlinMetadata2 = libraryClass.kotlinMetadata;
    assertTrue(kotlinMetadata2 instanceof KotlinMultiFileFacadeKindMetadata);
    List<Clazz> clazzList = ((KotlinMultiFileFacadeKindMetadata) kotlinMetadata2).referencedPartClasses;
    assertTrue(clazzList.isEmpty());
    assertSame(kotlinMetadata.referencedPartClasses, clazzList);
  }

  /**
   * Method under test:
   * {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  public void testVisitLibraryClass5() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer = new ClassReferenceInitializer(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool);
    KotlinMultiFileFacadeKindMetadata kotlinMetadata = new KotlinMultiFileFacadeKindMetadata(new int[]{1, 0, 1, 0},
        new String[]{"kotlin/Function", "kotlin/reflect/KFunction"}, 1, "Xs", "Pn");

    LibraryClass libraryClass = new LibraryClass(1, "This Class Name", "Super Class Name", kotlinMetadata);

    // Act
    classReferenceInitializer.visitLibraryClass(libraryClass);

    // Assert
    KotlinMetadata kotlinMetadata2 = libraryClass.kotlinMetadata;
    assertTrue(kotlinMetadata2 instanceof KotlinMultiFileFacadeKindMetadata);
    assertSame(kotlinMetadata.referencedPartClasses,
        ((KotlinMultiFileFacadeKindMetadata) kotlinMetadata2).referencedPartClasses);
  }

  /**
   * Method under test:
   * {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  public void testVisitLibraryClass6() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer = new ClassReferenceInitializer(new ClassPool(),
        KotlinConstants.dummyClassPool);
    KotlinMultiFileFacadeKindMetadata kotlinMetadata = new KotlinMultiFileFacadeKindMetadata(new int[]{1, 0, 1, 0},
        new String[]{"kotlin/Function"}, 1, "Xs", "Pn");

    LibraryClass libraryClass = new LibraryClass(1, "This Class Name", "Super Class Name", kotlinMetadata);

    // Act
    classReferenceInitializer.visitLibraryClass(libraryClass);

    // Assert
    KotlinMetadata kotlinMetadata2 = libraryClass.kotlinMetadata;
    assertTrue(kotlinMetadata2 instanceof KotlinMultiFileFacadeKindMetadata);
    assertSame(kotlinMetadata.referencedPartClasses,
        ((KotlinMultiFileFacadeKindMetadata) kotlinMetadata2).referencedPartClasses);
  }
}
