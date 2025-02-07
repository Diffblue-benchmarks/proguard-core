package proguard.classfile.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.ClassPool;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.ProgramClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.classfile.kotlin.KotlinConstants;

class ClassSuperHierarchyInitializerDiffblueTest {
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
  @DisplayName(
      "Test visitAnyClass(Clazz); when LibraryClass(); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassSuperHierarchyInitializer.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass_whenLibraryClass_thenThrowUnsupportedOperationException() {
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
   * Test {@link ClassSuperHierarchyInitializer#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#interfaceConstantsAccept(ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassSuperHierarchyInitializer#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); then calls interfaceConstantsAccept(ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassSuperHierarchyInitializer.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenCallsInterfaceConstantsAccept() {
    // Arrange
    ClassSuperHierarchyInitializer classSuperHierarchyInitializer =
        new ClassSuperHierarchyInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).interfaceConstantsAccept(Mockito.<ConstantVisitor>any());
    doNothing().when(programClass).superClassConstantAccept(Mockito.<ConstantVisitor>any());

    // Act
    classSuperHierarchyInitializer.visitProgramClass(programClass);

    // Assert
    verify(programClass).interfaceConstantsAccept(isA(ConstantVisitor.class));
    verify(programClass).superClassConstantAccept(isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <p>Method under test: {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName("Test visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassSuperHierarchyInitializer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass() {
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
  @DisplayName("Test visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassSuperHierarchyInitializer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass2() {
    // Arrange
    InvalidClassReferenceVisitor invalidClassReferenceVisitor =
        mock(InvalidClassReferenceVisitor.class);
    doNothing()
        .when(invalidClassReferenceVisitor)
        .visitMissingClass(Mockito.<Clazz>any(), Mockito.<String>any());
    ClassSuperHierarchyInitializer classSuperHierarchyInitializer =
        new ClassSuperHierarchyInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            invalidClassReferenceVisitor);
    LibraryClass libraryClass = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    classSuperHierarchyInitializer.visitLibraryClass(libraryClass);

    // Assert that nothing has changed
    verify(invalidClassReferenceVisitor)
        .visitMissingClass(isA(Clazz.class), eq("Super Class Name"));
    assertEquals(0, libraryClass.getInterfaceCount());
    assertEquals(0, libraryClass.interfaceClasses.length);
  }

  /**
   * Test {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <p>Method under test: {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName("Test visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassSuperHierarchyInitializer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass3() {
    // Arrange
    InvalidClassReferenceVisitor invalidClassReferenceVisitor =
        mock(InvalidClassReferenceVisitor.class);
    doNothing()
        .when(invalidClassReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassSuperHierarchyInitializer classSuperHierarchyInitializer =
        new ClassSuperHierarchyInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            invalidClassReferenceVisitor);
    LibraryClass libraryClass = new LibraryClass(1, "This Class Name", "kotlin/Function");

    // Act
    classSuperHierarchyInitializer.visitLibraryClass(libraryClass);

    // Assert
    verify(invalidClassReferenceVisitor).visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
    assertTrue(libraryClass.getSuperClass() instanceof ProgramClass);
  }

  /**
   * Test {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <p>Method under test: {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName("Test visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassSuperHierarchyInitializer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass4() {
    // Arrange
    ClassSuperHierarchyInitializer classSuperHierarchyInitializer =
        new ClassSuperHierarchyInitializer(
            new ClassPool(),
            KotlinConstants.dummyClassPool,
            mock(InvalidClassReferenceVisitor.class));
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
  @DisplayName("Test visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassSuperHierarchyInitializer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass5() {
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
  @DisplayName("Test visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassSuperHierarchyInitializer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass6() {
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
  @DisplayName("Test visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassSuperHierarchyInitializer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass7() {
    // Arrange
    WarningPrinter missingWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    PrintWriter printWriter = new PrintWriter(new StringWriter());
    ClassSuperHierarchyInitializer classSuperHierarchyInitializer =
        new ClassSuperHierarchyInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            missingWarningPrinter,
            new WarningPrinter(printWriter, new ArrayList<>()));
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
  @DisplayName("Test visitLibraryClass(LibraryClass); given ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassSuperHierarchyInitializer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass_givenArrayListAdd42() {
    // Arrange
    ArrayList<Object> classFilter = new ArrayList<>();
    classFilter.add("42");
    WarningPrinter dependencyWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()), classFilter);

    ClassSuperHierarchyInitializer classSuperHierarchyInitializer =
        new ClassSuperHierarchyInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            new WarningPrinter(new PrintWriter(new StringWriter())),
            dependencyWarningPrinter);
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
   *   <li>Then {@link LibraryClass#LibraryClass()} SuperClass is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName("Test visitLibraryClass(LibraryClass); then LibraryClass() SuperClass is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassSuperHierarchyInitializer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass_thenLibraryClassSuperClassIsNull() {
    // Arrange
    InvalidClassReferenceVisitor invalidClassReferenceVisitor =
        mock(InvalidClassReferenceVisitor.class);
    doNothing()
        .when(invalidClassReferenceVisitor)
        .visitMissingClass(Mockito.<Clazz>any(), Mockito.<String>any());
    ClassSuperHierarchyInitializer classSuperHierarchyInitializer =
        new ClassSuperHierarchyInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            invalidClassReferenceVisitor);
    LibraryClass libraryClass = new LibraryClass();
    libraryClass.superClassName = null;
    libraryClass.interfaceNames = new String[] {"Library Class"};

    // Act
    classSuperHierarchyInitializer.visitLibraryClass(libraryClass);

    // Assert
    verify(invalidClassReferenceVisitor).visitMissingClass(isA(Clazz.class), eq("Library Class"));
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
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassSuperHierarchyInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName("Test visitLibraryClass(LibraryClass); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassSuperHierarchyInitializer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass_thenThrowUnsupportedOperationException() {
    // Arrange
    InvalidClassReferenceVisitor invalidClassReferenceVisitor =
        mock(InvalidClassReferenceVisitor.class);
    doThrow(new UnsupportedOperationException("foo"))
        .when(invalidClassReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassSuperHierarchyInitializer classSuperHierarchyInitializer =
        new ClassSuperHierarchyInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            invalidClassReferenceVisitor);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            classSuperHierarchyInitializer.visitLibraryClass(
                new LibraryClass(1, "This Class Name", "kotlin/Function")));
    verify(invalidClassReferenceVisitor).visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
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
  @DisplayName(
      "Test visitLibraryClass(LibraryClass); when LibraryClass(); then LibraryClass() InterfaceCount is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassSuperHierarchyInitializer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass_whenLibraryClass_thenLibraryClassInterfaceCountIsZero() {
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

  /**
   * Test {@link ClassSuperHierarchyInitializer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link ClassSuperHierarchyInitializer#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassSuperHierarchyInitializer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant() {
    // Arrange
    ClassSuperHierarchyInitializer classSuperHierarchyInitializer =
        new ClassSuperHierarchyInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    classSuperHierarchyInitializer.visitClassConstant(clazz, new ClassConstant());

    // Assert that nothing has changed
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link ClassSuperHierarchyInitializer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link ClassSuperHierarchyInitializer#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassSuperHierarchyInitializer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant2() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    LibraryClass libraryClass = new LibraryClass();
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(libraryClass);
    ClassSuperHierarchyInitializer classSuperHierarchyInitializer =
        new ClassSuperHierarchyInitializer(programClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    ClassConstant classConstant = new ClassConstant();

    // Act
    classSuperHierarchyInitializer.visitClassConstant(clazz, classConstant);

    // Assert
    verify(programClassPool).getClass(eq("String"));
    verify(clazz).getString(eq(0));
    Clazz clazz2 = classConstant.referencedClass;
    assertTrue(clazz2 instanceof LibraryClass);
    assertNull(((LibraryClass) clazz2).interfaceNames);
    assertNull(((LibraryClass) clazz2).fields);
    assertNull(((LibraryClass) clazz2).methods);
    assertNull(clazz2.getProcessingInfo());
    assertNull(clazz2.getName());
    assertNull(clazz2.getSuperName());
    assertNull(clazz2.getFeatureName());
    assertNull(clazz2.getSuperClass());
    assertNull(((LibraryClass) clazz2).kotlinMetadata);
    assertEquals(0, clazz2.getAccessFlags());
    assertEquals(0, clazz2.getInterfaceCount());
    assertEquals(0, clazz2.getProcessingFlags());
    assertEquals(0, ((LibraryClass) clazz2).interfaceClasses.length);
    assertEquals(0, ((LibraryClass) clazz2).subClassCount);
    assertTrue(clazz2.getExtraFeatureNames().isEmpty());
    assertSame(libraryClass.subClasses, ((LibraryClass) clazz2).subClasses);
  }

  /**
   * Test {@link ClassSuperHierarchyInitializer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link ClassSuperHierarchyInitializer#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassSuperHierarchyInitializer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant3() {
    // Arrange
    InvalidClassReferenceVisitor invalidClassReferenceVisitor =
        mock(InvalidClassReferenceVisitor.class);
    doNothing()
        .when(invalidClassReferenceVisitor)
        .visitMissingClass(Mockito.<Clazz>any(), Mockito.<String>any());
    ClassSuperHierarchyInitializer classSuperHierarchyInitializer =
        new ClassSuperHierarchyInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            invalidClassReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    classSuperHierarchyInitializer.visitClassConstant(clazz, new ClassConstant());

    // Assert that nothing has changed
    verify(clazz).getString(eq(0));
    verify(invalidClassReferenceVisitor).visitMissingClass(isA(Clazz.class), eq("String"));
  }

  /**
   * Test {@link ClassSuperHierarchyInitializer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link ClassSuperHierarchyInitializer#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassSuperHierarchyInitializer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant4() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    LibraryClass libraryClass = new LibraryClass();
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(libraryClass);
    InvalidClassReferenceVisitor invalidClassReferenceVisitor =
        mock(InvalidClassReferenceVisitor.class);
    doNothing()
        .when(invalidClassReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassSuperHierarchyInitializer classSuperHierarchyInitializer =
        new ClassSuperHierarchyInitializer(
            programClassPool, KotlinConstants.dummyClassPool, invalidClassReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    ClassConstant classConstant = new ClassConstant();

    // Act
    classSuperHierarchyInitializer.visitClassConstant(clazz, classConstant);

    // Assert
    verify(programClassPool).getClass(eq("String"));
    verify(clazz).getString(eq(0));
    verify(invalidClassReferenceVisitor).visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
    Clazz clazz2 = classConstant.referencedClass;
    assertTrue(clazz2 instanceof LibraryClass);
    assertNull(((LibraryClass) clazz2).interfaceNames);
    assertNull(((LibraryClass) clazz2).fields);
    assertNull(((LibraryClass) clazz2).methods);
    assertNull(clazz2.getProcessingInfo());
    assertNull(clazz2.getName());
    assertNull(clazz2.getSuperName());
    assertNull(clazz2.getFeatureName());
    assertNull(clazz2.getSuperClass());
    assertNull(((LibraryClass) clazz2).kotlinMetadata);
    assertEquals(0, clazz2.getAccessFlags());
    assertEquals(0, clazz2.getInterfaceCount());
    assertEquals(0, clazz2.getProcessingFlags());
    assertEquals(0, ((LibraryClass) clazz2).interfaceClasses.length);
    assertEquals(0, ((LibraryClass) clazz2).subClassCount);
    assertTrue(clazz2.getExtraFeatureNames().isEmpty());
    assertSame(libraryClass.subClasses, ((LibraryClass) clazz2).subClasses);
  }

  /**
   * Test {@link ClassSuperHierarchyInitializer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link ClassSuperHierarchyInitializer#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassSuperHierarchyInitializer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant5() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(new LibraryClass());
    InvalidClassReferenceVisitor invalidClassReferenceVisitor =
        mock(InvalidClassReferenceVisitor.class);
    doThrow(new UnsupportedOperationException("foo"))
        .when(invalidClassReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassSuperHierarchyInitializer classSuperHierarchyInitializer =
        new ClassSuperHierarchyInitializer(
            programClassPool, KotlinConstants.dummyClassPool, invalidClassReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> classSuperHierarchyInitializer.visitClassConstant(clazz, new ClassConstant()));
    verify(programClassPool).getClass(eq("String"));
    verify(clazz).getString(eq(0));
    verify(invalidClassReferenceVisitor).visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
  }

  /**
   * Test {@link ClassSuperHierarchyInitializer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link ClassSuperHierarchyInitializer#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassSuperHierarchyInitializer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant6() {
    // Arrange
    ClassPool libraryClassPool = mock(ClassPool.class);
    LibraryClass libraryClass = new LibraryClass();
    when(libraryClassPool.getClass(Mockito.<String>any())).thenReturn(libraryClass);
    WarningPrinter missingWarningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    ClassSuperHierarchyInitializer classSuperHierarchyInitializer =
        new ClassSuperHierarchyInitializer(
            KotlinConstants.dummyClassPool,
            libraryClassPool,
            missingWarningPrinter,
            new WarningPrinter(new PrintWriter(new StringWriter())));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    ClassConstant classConstant = new ClassConstant();

    // Act
    classSuperHierarchyInitializer.visitClassConstant(clazz, classConstant);

    // Assert
    verify(libraryClassPool).getClass(eq("String"));
    verify(clazz).getString(eq(0));
    Clazz clazz2 = classConstant.referencedClass;
    assertTrue(clazz2 instanceof LibraryClass);
    assertNull(((LibraryClass) clazz2).interfaceNames);
    assertNull(((LibraryClass) clazz2).fields);
    assertNull(((LibraryClass) clazz2).methods);
    assertNull(clazz2.getProcessingInfo());
    assertNull(clazz2.getName());
    assertNull(clazz2.getSuperName());
    assertNull(clazz2.getFeatureName());
    assertNull(clazz2.getSuperClass());
    assertNull(((LibraryClass) clazz2).kotlinMetadata);
    assertEquals(0, clazz2.getAccessFlags());
    assertEquals(0, clazz2.getInterfaceCount());
    assertEquals(0, clazz2.getProcessingFlags());
    assertEquals(0, ((LibraryClass) clazz2).interfaceClasses.length);
    assertEquals(0, ((LibraryClass) clazz2).subClassCount);
    assertTrue(clazz2.getExtraFeatureNames().isEmpty());
    assertSame(libraryClass.subClasses, ((LibraryClass) clazz2).subClasses);
  }

  /**
   * Test {@link ClassSuperHierarchyInitializer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link ClassSuperHierarchyInitializer#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassSuperHierarchyInitializer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant7() {
    // Arrange
    InvalidClassReferenceVisitor invalidClassReferenceVisitor =
        mock(InvalidClassReferenceVisitor.class);
    doThrow(new UnsupportedOperationException("kotlin/Function"))
        .when(invalidClassReferenceVisitor)
        .visitMissingClass(Mockito.<Clazz>any(), Mockito.<String>any());
    ClassSuperHierarchyInitializer classSuperHierarchyInitializer =
        new ClassSuperHierarchyInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            invalidClassReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> classSuperHierarchyInitializer.visitClassConstant(clazz, new ClassConstant()));
    verify(clazz).getString(eq(0));
    verify(invalidClassReferenceVisitor).visitMissingClass(isA(Clazz.class), eq("String"));
  }
}
