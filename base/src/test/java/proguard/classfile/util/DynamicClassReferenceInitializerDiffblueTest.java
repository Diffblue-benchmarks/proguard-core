package proguard.classfile.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
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
import proguard.classfile.constant.MethodrefConstant;
import proguard.classfile.constant.RefConstant;
import proguard.classfile.constant.StringConstant;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.classfile.visitor.ClassVisitor;
import proguard.util.ConstantMatcher;
import proguard.util.EmptyStringMatcher;
import proguard.util.StringMatcher;

class DynamicClassReferenceInitializerDiffblueTest {
  /**
   * Test {@link DynamicClassReferenceInitializer#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass} {@link ProgramClass#accept(ClassVisitor)} does nothing.
   *   <li>Then calls {@link ProgramClass#accept(ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicClassReferenceInitializer#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); when ProgramClass accept(ClassVisitor) does nothing; then calls accept(ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicClassReferenceInitializer.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_whenProgramClassAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    WarningPrinter missingNotePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter dependencyWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter notePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    DynamicClassReferenceInitializer dynamicClassReferenceInitializer =
        new DynamicClassReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            missingNotePrinter,
            dependencyWarningPrinter,
            notePrinter,
            new EmptyStringMatcher());
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).accept(Mockito.<ClassVisitor>any());

    // Act
    dynamicClassReferenceInitializer.visitProgramClass(programClass);

    // Assert
    verify(programClass).accept(isA(ClassVisitor.class));
  }

  /**
   * Test {@link DynamicClassReferenceInitializer#visitStringConstant(Clazz, StringConstant)}.
   *
   * <p>Method under test: {@link DynamicClassReferenceInitializer#visitStringConstant(Clazz,
   * StringConstant)}
   */
  @Test
  @DisplayName("Test visitStringConstant(Clazz, StringConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicClassReferenceInitializer.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant() {
    // Arrange
    WarningPrinter missingNotePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter dependencyWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter notePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    DynamicClassReferenceInitializer dynamicClassReferenceInitializer =
        new DynamicClassReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            missingNotePrinter,
            dependencyWarningPrinter,
            notePrinter,
            new EmptyStringMatcher());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getName()).thenReturn("Name");
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    dynamicClassReferenceInitializer.visitStringConstant(clazz, new StringConstant());

    // Assert that nothing has changed
    verify(clazz).getName();
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link DynamicClassReferenceInitializer#visitStringConstant(Clazz, StringConstant)}.
   *
   * <p>Method under test: {@link DynamicClassReferenceInitializer#visitStringConstant(Clazz,
   * StringConstant)}
   */
  @Test
  @DisplayName("Test visitStringConstant(Clazz, StringConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicClassReferenceInitializer.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant2() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    LibraryClass libraryClass = new LibraryClass();
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(libraryClass);
    WarningPrinter missingNotePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter dependencyWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter notePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    DynamicClassReferenceInitializer dynamicClassReferenceInitializer =
        new DynamicClassReferenceInitializer(
            programClassPool,
            KotlinConstants.dummyClassPool,
            missingNotePrinter,
            dependencyWarningPrinter,
            notePrinter,
            new EmptyStringMatcher());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getName()).thenReturn("Name");
    when(clazz.getString(anyInt())).thenReturn("String");
    StringConstant stringConstant = new StringConstant();

    // Act
    dynamicClassReferenceInitializer.visitStringConstant(clazz, stringConstant);

    // Assert
    verify(programClassPool).getClass(eq("String"));
    verify(clazz).getName();
    verify(clazz).getString(eq(0));
    Clazz clazz2 = stringConstant.referencedClass;
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
   * Test {@link DynamicClassReferenceInitializer#visitStringConstant(Clazz, StringConstant)}.
   *
   * <p>Method under test: {@link DynamicClassReferenceInitializer#visitStringConstant(Clazz,
   * StringConstant)}
   */
  @Test
  @DisplayName("Test visitStringConstant(Clazz, StringConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicClassReferenceInitializer.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant3() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    LibraryClass libraryClass = new LibraryClass();
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(libraryClass);
    WarningPrinter missingNotePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter notePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    DynamicClassReferenceInitializer dynamicClassReferenceInitializer =
        new DynamicClassReferenceInitializer(
            programClassPool,
            KotlinConstants.dummyClassPool,
            missingNotePrinter,
            null,
            notePrinter,
            new EmptyStringMatcher());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getName()).thenReturn("Name");
    when(clazz.getString(anyInt())).thenReturn("String");
    StringConstant stringConstant = new StringConstant();

    // Act
    dynamicClassReferenceInitializer.visitStringConstant(clazz, stringConstant);

    // Assert
    verify(programClassPool).getClass(eq("String"));
    verify(clazz).getName();
    verify(clazz).getString(eq(0));
    Clazz clazz2 = stringConstant.referencedClass;
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
   * Test {@link DynamicClassReferenceInitializer#visitStringConstant(Clazz, StringConstant)}.
   *
   * <p>Method under test: {@link DynamicClassReferenceInitializer#visitStringConstant(Clazz,
   * StringConstant)}
   */
  @Test
  @DisplayName("Test visitStringConstant(Clazz, StringConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicClassReferenceInitializer.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant4() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    LibraryClass libraryClass = new LibraryClass();
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(libraryClass);
    WarningPrinter missingNotePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    PrintWriter printWriter = new PrintWriter(new StringWriter());
    WarningPrinter dependencyWarningPrinter = new WarningPrinter(printWriter, new ArrayList<>());

    WarningPrinter notePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    DynamicClassReferenceInitializer dynamicClassReferenceInitializer =
        new DynamicClassReferenceInitializer(
            programClassPool,
            KotlinConstants.dummyClassPool,
            missingNotePrinter,
            dependencyWarningPrinter,
            notePrinter,
            new EmptyStringMatcher());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getName()).thenReturn("Name");
    when(clazz.getString(anyInt())).thenReturn("String");
    StringConstant stringConstant = new StringConstant();

    // Act
    dynamicClassReferenceInitializer.visitStringConstant(clazz, stringConstant);

    // Assert
    verify(programClassPool).getClass(eq("String"));
    verify(clazz).getName();
    verify(clazz).getString(eq(0));
    Clazz clazz2 = stringConstant.referencedClass;
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
   * Test {@link DynamicClassReferenceInitializer#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>Given {@code []}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicClassReferenceInitializer#visitStringConstant(Clazz,
   * StringConstant)}
   */
  @Test
  @DisplayName("Test visitStringConstant(Clazz, StringConstant); given '[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicClassReferenceInitializer.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant_givenLeftSquareBracketRightSquareBracket() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    LibraryClass libraryClass = new LibraryClass();
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(libraryClass);
    WarningPrinter dependencyWarningPrinter = mock(WarningPrinter.class);
    doNothing()
        .when(dependencyWarningPrinter)
        .print(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());
    WarningPrinter missingNotePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter notePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    DynamicClassReferenceInitializer dynamicClassReferenceInitializer =
        new DynamicClassReferenceInitializer(
            programClassPool,
            KotlinConstants.dummyClassPool,
            missingNotePrinter,
            dependencyWarningPrinter,
            notePrinter,
            new EmptyStringMatcher());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getName()).thenReturn("Name");
    when(clazz.getString(anyInt())).thenReturn("[]");
    StringConstant stringConstant = new StringConstant();

    // Act
    dynamicClassReferenceInitializer.visitStringConstant(clazz, stringConstant);

    // Assert
    verify(programClassPool).getClass(eq(""));
    verify(clazz).getName();
    verify(clazz).getString(eq(0));
    verify(dependencyWarningPrinter)
        .print(
            eq("Name"),
            eq(""),
            eq("Warning: library class Name depends dynamically on program class "));
    Clazz clazz2 = stringConstant.referencedClass;
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
   * Test {@link DynamicClassReferenceInitializer#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link StringConstant#getString(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicClassReferenceInitializer#visitStringConstant(Clazz,
   * StringConstant)}
   */
  @Test
  @DisplayName("Test visitStringConstant(Clazz, StringConstant); then calls getString(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicClassReferenceInitializer.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant_thenCallsGetString() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(new LibraryClass());
    WarningPrinter dependencyWarningPrinter = mock(WarningPrinter.class);
    doNothing()
        .when(dependencyWarningPrinter)
        .print(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());
    WarningPrinter missingNotePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter notePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    DynamicClassReferenceInitializer dynamicClassReferenceInitializer =
        new DynamicClassReferenceInitializer(
            programClassPool,
            KotlinConstants.dummyClassPool,
            missingNotePrinter,
            dependencyWarningPrinter,
            notePrinter,
            new EmptyStringMatcher());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getName()).thenReturn("Name");
    StringConstant stringConstant = mock(StringConstant.class);
    when(stringConstant.getString(Mockito.<Clazz>any())).thenReturn("String");

    // Act
    dynamicClassReferenceInitializer.visitStringConstant(clazz, stringConstant);

    // Assert
    verify(programClassPool).getClass(eq("String"));
    verify(clazz).getName();
    verify(stringConstant).getString(isA(Clazz.class));
    verify(dependencyWarningPrinter)
        .print(
            eq("Name"),
            eq("String"),
            eq("Warning: library class Name depends dynamically on program class String"));
  }

  /**
   * Test {@link DynamicClassReferenceInitializer#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link WarningPrinter#print(String, String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicClassReferenceInitializer#visitStringConstant(Clazz,
   * StringConstant)}
   */
  @Test
  @DisplayName(
      "Test visitStringConstant(Clazz, StringConstant); then calls print(String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicClassReferenceInitializer.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant_thenCallsPrint() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    LibraryClass libraryClass = new LibraryClass();
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(libraryClass);
    WarningPrinter dependencyWarningPrinter = mock(WarningPrinter.class);
    doNothing()
        .when(dependencyWarningPrinter)
        .print(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());
    WarningPrinter missingNotePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter notePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    DynamicClassReferenceInitializer dynamicClassReferenceInitializer =
        new DynamicClassReferenceInitializer(
            programClassPool,
            KotlinConstants.dummyClassPool,
            missingNotePrinter,
            dependencyWarningPrinter,
            notePrinter,
            new EmptyStringMatcher());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getName()).thenReturn("Name");
    when(clazz.getString(anyInt())).thenReturn("String");
    StringConstant stringConstant = new StringConstant();

    // Act
    dynamicClassReferenceInitializer.visitStringConstant(clazz, stringConstant);

    // Assert
    verify(programClassPool).getClass(eq("String"));
    verify(clazz).getName();
    verify(clazz).getString(eq(0));
    verify(dependencyWarningPrinter)
        .print(
            eq("Name"),
            eq("String"),
            eq("Warning: library class Name depends dynamically on program class String"));
    Clazz clazz2 = stringConstant.referencedClass;
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
   * Test {@link DynamicClassReferenceInitializer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link DynamicClassReferenceInitializer#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicClassReferenceInitializer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant() {
    // Arrange
    WarningPrinter missingNotePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter dependencyWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    PrintWriter printWriter = new PrintWriter(new StringWriter());
    WarningPrinter notePrinter = new WarningPrinter(printWriter, new ArrayList<>());

    DynamicClassReferenceInitializer dynamicClassReferenceInitializer =
        new DynamicClassReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            missingNotePrinter,
            dependencyWarningPrinter,
            notePrinter,
            new EmptyStringMatcher());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getName()).thenReturn("Name");
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    dynamicClassReferenceInitializer.visitClassConstant(clazz, new ClassConstant());

    // Assert
    verify(clazz, atLeast(1)).getName();
    verify(clazz, atLeast(1)).getString(eq(0));
  }

  /**
   * Test {@link DynamicClassReferenceInitializer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link DynamicClassReferenceInitializer#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicClassReferenceInitializer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant2() {
    // Arrange
    WarningPrinter notePrinter = mock(WarningPrinter.class);
    doNothing()
        .when(notePrinter)
        .print(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());
    WarningPrinter missingNotePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter dependencyWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    DynamicClassReferenceInitializer dynamicClassReferenceInitializer =
        new DynamicClassReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            missingNotePrinter,
            dependencyWarningPrinter,
            notePrinter,
            new EmptyStringMatcher());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getName()).thenReturn("Name");
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    dynamicClassReferenceInitializer.visitClassConstant(clazz, new ClassConstant());

    // Assert
    verify(clazz, atLeast(1)).getName();
    verify(clazz, atLeast(1)).getString(eq(0));
    verify(notePrinter)
        .print(
            eq("Name"),
            eq("String"),
            eq("Note: Name calls '(String)Class.forName(variable).newInstance()'"));
  }

  /**
   * Test {@link DynamicClassReferenceInitializer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicClassReferenceInitializer#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); given ConstantMatcher(boolean) with matches is 'true'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicClassReferenceInitializer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_givenConstantMatcherWithMatchesIsTrue_thenCallsGetString() {
    // Arrange
    WarningPrinter missingNotePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter dependencyWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter notePrinter = mock(WarningPrinter.class);
    DynamicClassReferenceInitializer dynamicClassReferenceInitializer =
        new DynamicClassReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            missingNotePrinter,
            dependencyWarningPrinter,
            notePrinter,
            new ConstantMatcher(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    dynamicClassReferenceInitializer.visitClassConstant(clazz, new ClassConstant());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link DynamicClassReferenceInitializer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Given {@link StringMatcher} {@link StringMatcher#matches(String)} return {@code false}.
   *   <li>Then calls {@link ClassConstant#getName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicClassReferenceInitializer#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); given StringMatcher matches(String) return 'false'; then calls getName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicClassReferenceInitializer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_givenStringMatcherMatchesReturnFalse_thenCallsGetName() {
    // Arrange
    WarningPrinter notePrinter = mock(WarningPrinter.class);
    doNothing()
        .when(notePrinter)
        .print(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());
    StringMatcher noteExceptionMatcher = mock(StringMatcher.class);
    when(noteExceptionMatcher.matches(Mockito.<String>any())).thenReturn(false);
    WarningPrinter missingNotePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    DynamicClassReferenceInitializer dynamicClassReferenceInitializer =
        new DynamicClassReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            missingNotePrinter,
            new WarningPrinter(new PrintWriter(new StringWriter())),
            notePrinter,
            noteExceptionMatcher);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getName()).thenReturn("Name");
    ClassConstant classConstant = mock(ClassConstant.class);
    when(classConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    dynamicClassReferenceInitializer.visitClassConstant(clazz, classConstant);

    // Assert
    verify(clazz, atLeast(1)).getName();
    verify(classConstant, atLeast(1)).getName(isA(Clazz.class));
    verify(notePrinter)
        .print(
            eq("Name"),
            eq("Name"),
            eq("Note: Name calls '(Name)Class.forName(variable).newInstance()'"));
    verify(noteExceptionMatcher).matches(eq("Name"));
  }

  /**
   * Test {@link DynamicClassReferenceInitializer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Given {@link StringMatcher} {@link StringMatcher#matches(String)} return {@code true}.
   *   <li>Then calls {@link StringMatcher#matches(String)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicClassReferenceInitializer#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); given StringMatcher matches(String) return 'true'; then calls matches(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicClassReferenceInitializer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_givenStringMatcherMatchesReturnTrue_thenCallsMatches() {
    // Arrange
    StringMatcher noteExceptionMatcher = mock(StringMatcher.class);
    when(noteExceptionMatcher.matches(Mockito.<String>any())).thenReturn(true);
    WarningPrinter missingNotePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    DynamicClassReferenceInitializer dynamicClassReferenceInitializer =
        new DynamicClassReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            missingNotePrinter,
            new WarningPrinter(new PrintWriter(new StringWriter())),
            mock(WarningPrinter.class),
            noteExceptionMatcher);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    dynamicClassReferenceInitializer.visitClassConstant(clazz, new ClassConstant());

    // Assert
    verify(clazz).getString(eq(0));
    verify(noteExceptionMatcher).matches(eq("String"));
  }

  /**
   * Test {@link DynamicClassReferenceInitializer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicClassReferenceInitializer#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant); then calls getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicClassReferenceInitializer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_thenCallsGetName() {
    // Arrange
    WarningPrinter missingNotePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter dependencyWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter notePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    DynamicClassReferenceInitializer dynamicClassReferenceInitializer =
        new DynamicClassReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            missingNotePrinter,
            dependencyWarningPrinter,
            notePrinter,
            new EmptyStringMatcher());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getName()).thenReturn("Name");
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    dynamicClassReferenceInitializer.visitClassConstant(clazz, new ClassConstant());

    // Assert
    verify(clazz, atLeast(1)).getName();
    verify(clazz, atLeast(1)).getString(eq(0));
  }

  /**
   * Test {@link DynamicClassReferenceInitializer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link ClassConstant#getName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicClassReferenceInitializer#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); when LibraryClass; then calls getName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicClassReferenceInitializer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_whenLibraryClass_thenCallsGetName() {
    // Arrange
    StringMatcher noteExceptionMatcher = mock(StringMatcher.class);
    when(noteExceptionMatcher.matches(Mockito.<String>any())).thenReturn(true);
    WarningPrinter missingNotePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    DynamicClassReferenceInitializer dynamicClassReferenceInitializer =
        new DynamicClassReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            missingNotePrinter,
            new WarningPrinter(new PrintWriter(new StringWriter())),
            mock(WarningPrinter.class),
            noteExceptionMatcher);
    LibraryClass clazz = mock(LibraryClass.class);
    ClassConstant classConstant = mock(ClassConstant.class);
    when(classConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    dynamicClassReferenceInitializer.visitClassConstant(clazz, classConstant);

    // Assert
    verify(classConstant).getName(isA(Clazz.class));
    verify(noteExceptionMatcher).matches(eq("Name"));
  }

  /**
   * Test {@link DynamicClassReferenceInitializer#visitMethodrefConstant(Clazz, MethodrefConstant)}.
   *
   * <p>Method under test: {@link DynamicClassReferenceInitializer#visitMethodrefConstant(Clazz,
   * MethodrefConstant)}
   */
  @Test
  @DisplayName("Test visitMethodrefConstant(Clazz, MethodrefConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicClassReferenceInitializer.visitMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodrefConstant)"
  })
  void testVisitMethodrefConstant() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any()))
        .thenReturn(
            new LibraryClass(
                1,
                "(Ljava/lang/String;)Ljava/lang/Class;",
                "(Ljava/lang/String;)Ljava/lang/Class;"));
    WarningPrinter missingNotePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter dependencyWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter notePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    DynamicClassReferenceInitializer dynamicClassReferenceInitializer =
        new DynamicClassReferenceInitializer(
            programClassPool,
            KotlinConstants.dummyClassPool,
            missingNotePrinter,
            dependencyWarningPrinter,
            notePrinter,
            new EmptyStringMatcher());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("(Ljava/lang/String;)Ljava/lang/Class;");

    // Act
    dynamicClassReferenceInitializer.visitMethodrefConstant(clazz, new MethodrefConstant());

    // Assert
    verify(programClassPool).getClass(eq("Class Name"));
    verify(clazz).getClassName(eq(0));
    verify(clazz).getName(eq(0));
    verify(clazz).getType(eq(0));
  }

  /**
   * Test {@link DynamicClassReferenceInitializer#visitMethodrefConstant(Clazz, MethodrefConstant)}.
   *
   * <ul>
   *   <li>Given {@link ClassPool} {@link ClassPool#getClass(String)} return {@link
   *       ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicClassReferenceInitializer#visitMethodrefConstant(Clazz,
   * MethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodrefConstant(Clazz, MethodrefConstant); given ClassPool getClass(String) return ProgramClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicClassReferenceInitializer.visitMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodrefConstant)"
  })
  void testVisitMethodrefConstant_givenClassPoolGetClassReturnProgramClass() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(new ProgramClass());
    WarningPrinter missingNotePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter dependencyWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter notePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    DynamicClassReferenceInitializer dynamicClassReferenceInitializer =
        new DynamicClassReferenceInitializer(
            programClassPool,
            KotlinConstants.dummyClassPool,
            missingNotePrinter,
            dependencyWarningPrinter,
            notePrinter,
            new EmptyStringMatcher());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("(Ljava/lang/String;)Ljava/lang/Class;");

    // Act
    dynamicClassReferenceInitializer.visitMethodrefConstant(clazz, new MethodrefConstant());

    // Assert
    verify(programClassPool).getClass(eq("Class Name"));
    verify(clazz).getClassName(eq(0));
    verify(clazz).getName(eq(0));
    verify(clazz).getType(eq(0));
  }

  /**
   * Test {@link DynamicClassReferenceInitializer#visitMethodrefConstant(Clazz, MethodrefConstant)}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getType(int)} return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicClassReferenceInitializer#visitMethodrefConstant(Clazz,
   * MethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodrefConstant(Clazz, MethodrefConstant); given 'Type'; when LibraryClass getType(int) return 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicClassReferenceInitializer.visitMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodrefConstant)"
  })
  void testVisitMethodrefConstant_givenType_whenLibraryClassGetTypeReturnType() {
    // Arrange
    WarningPrinter missingNotePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter dependencyWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter notePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    DynamicClassReferenceInitializer dynamicClassReferenceInitializer =
        new DynamicClassReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            missingNotePrinter,
            dependencyWarningPrinter,
            notePrinter,
            new EmptyStringMatcher());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getType(anyInt())).thenReturn("Type");

    // Act
    dynamicClassReferenceInitializer.visitMethodrefConstant(clazz, new MethodrefConstant());

    // Assert
    verify(clazz).getType(eq(0));
  }

  /**
   * Test {@link DynamicClassReferenceInitializer#visitMethodrefConstant(Clazz, MethodrefConstant)}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link RefConstant#getType(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicClassReferenceInitializer#visitMethodrefConstant(Clazz,
   * MethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodrefConstant(Clazz, MethodrefConstant); given 'Type'; when LibraryClass; then calls getType(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicClassReferenceInitializer.visitMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodrefConstant)"
  })
  void testVisitMethodrefConstant_givenType_whenLibraryClass_thenCallsGetType() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    WarningPrinter missingNotePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter dependencyWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter notePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    DynamicClassReferenceInitializer dynamicClassReferenceInitializer =
        new DynamicClassReferenceInitializer(
            programClassPool,
            KotlinConstants.dummyClassPool,
            missingNotePrinter,
            dependencyWarningPrinter,
            notePrinter,
            new EmptyStringMatcher());
    LibraryClass clazz = mock(LibraryClass.class);
    MethodrefConstant methodrefConstant = mock(MethodrefConstant.class);
    when(methodrefConstant.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    dynamicClassReferenceInitializer.visitMethodrefConstant(clazz, methodrefConstant);

    // Assert
    verify(methodrefConstant).getType(isA(Clazz.class));
  }

  /**
   * Test {@link DynamicClassReferenceInitializer#visitMethodrefConstant(Clazz, MethodrefConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getClassName(int)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicClassReferenceInitializer#visitMethodrefConstant(Clazz,
   * MethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodrefConstant(Clazz, MethodrefConstant); then calls getClassName(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicClassReferenceInitializer.visitMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodrefConstant)"
  })
  void testVisitMethodrefConstant_thenCallsGetClassName() {
    // Arrange
    WarningPrinter missingNotePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter dependencyWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter notePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    DynamicClassReferenceInitializer dynamicClassReferenceInitializer =
        new DynamicClassReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            missingNotePrinter,
            dependencyWarningPrinter,
            notePrinter,
            new EmptyStringMatcher());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("(Ljava/lang/String;)Ljava/lang/Class;");

    // Act
    dynamicClassReferenceInitializer.visitMethodrefConstant(clazz, new MethodrefConstant());

    // Assert
    verify(clazz).getClassName(eq(0));
    verify(clazz).getName(eq(0));
    verify(clazz).getType(eq(0));
  }
}
