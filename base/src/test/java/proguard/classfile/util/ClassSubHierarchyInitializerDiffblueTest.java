package proguard.classfile.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.ClassPool;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.ProgramClass;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.classfile.visitor.ClassVisitor;

class ClassSubHierarchyInitializerDiffblueTest {
  /**
   * Test {@link ClassSubHierarchyInitializer#visitClassPool(ClassPool)}.
   *
   * <ul>
   *   <li>When {@link ClassPool} {@link ClassPool#classesAccept(ClassVisitor)} does nothing.
   *   <li>Then calls {@link ClassPool#classesAccept(ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassSubHierarchyInitializer#visitClassPool(ClassPool)}
   */
  @Test
  @DisplayName(
      "Test visitClassPool(ClassPool); when ClassPool classesAccept(ClassVisitor) does nothing; then calls classesAccept(ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassSubHierarchyInitializer.visitClassPool(proguard.classfile.ClassPool)"
  })
  void testVisitClassPool_whenClassPoolClassesAcceptDoesNothing_thenCallsClassesAccept() {
    // Arrange
    ClassSubHierarchyInitializer classSubHierarchyInitializer = new ClassSubHierarchyInitializer();
    ClassPool classPool = mock(ClassPool.class);
    doNothing().when(classPool).classesAccept(Mockito.<ClassVisitor>any());

    // Act
    classSubHierarchyInitializer.visitClassPool(classPool);

    // Assert
    verify(classPool, atLeast(1)).classesAccept(Mockito.<ClassVisitor>any());
  }

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
  @DisplayName(
      "Test visitAnyClass(Clazz); when LibraryClass(); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassSubHierarchyInitializer.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass_whenLibraryClass_thenThrowUnsupportedOperationException() {
    // Arrange
    ClassSubHierarchyInitializer classSubHierarchyInitializer = new ClassSubHierarchyInitializer();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> classSubHierarchyInitializer.visitAnyClass(new LibraryClass()));
  }

  /**
   * Test {@link ClassSubHierarchyInitializer#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#interfaceConstantsAccept(ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassSubHierarchyInitializer#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); then calls interfaceConstantsAccept(ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassSubHierarchyInitializer.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenCallsInterfaceConstantsAccept() {
    // Arrange
    ClassSubHierarchyInitializer classSubHierarchyInitializer = new ClassSubHierarchyInitializer();
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).interfaceConstantsAccept(Mockito.<ConstantVisitor>any());
    doNothing().when(programClass).superClassConstantAccept(Mockito.<ConstantVisitor>any());

    // Act
    classSubHierarchyInitializer.visitProgramClass(programClass);

    // Assert
    verify(programClass).interfaceConstantsAccept(isA(ConstantVisitor.class));
    verify(programClass).superClassConstantAccept(isA(ConstantVisitor.class));
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
  @DisplayName(
      "Test visitLibraryClass(LibraryClass); given LibraryClass(); then LibraryClass() SuperClass LibraryClass")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassSubHierarchyInitializer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass_givenLibraryClass_thenLibraryClassSuperClassLibraryClass() {
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
  @DisplayName(
      "Test visitLibraryClass(LibraryClass); given ProgramClass(); then LibraryClass() SuperClass ProgramClass")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassSubHierarchyInitializer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass_givenProgramClass_thenLibraryClassSuperClassProgramClass() {
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
  @DisplayName("Test visitLibraryClass(LibraryClass); then first element LibraryClass")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassSubHierarchyInitializer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass_thenFirstElementLibraryClass() {
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
  @DisplayName("Test visitLibraryClass(LibraryClass); then first element ProgramClass")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassSubHierarchyInitializer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass_thenFirstElementProgramClass() {
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
