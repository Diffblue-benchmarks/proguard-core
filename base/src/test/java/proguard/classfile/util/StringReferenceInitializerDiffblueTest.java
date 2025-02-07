package proguard.classfile.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.ClassPool;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.constant.StringConstant;
import proguard.classfile.kotlin.KotlinConstants;

class StringReferenceInitializerDiffblueTest {
  /**
   * Test {@link StringReferenceInitializer#visitStringConstant(Clazz, StringConstant)}.
   *
   * <p>Method under test: {@link StringReferenceInitializer#visitStringConstant(Clazz,
   * StringConstant)}
   */
  @Test
  @DisplayName("Test visitStringConstant(Clazz, StringConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.StringReferenceInitializer.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant() {
    // Arrange
    StringReferenceInitializer stringReferenceInitializer =
        new StringReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    stringReferenceInitializer.visitStringConstant(clazz, new StringConstant());

    // Assert that nothing has changed
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link StringReferenceInitializer#visitStringConstant(Clazz, StringConstant)}.
   *
   * <p>Method under test: {@link StringReferenceInitializer#visitStringConstant(Clazz,
   * StringConstant)}
   */
  @Test
  @DisplayName("Test visitStringConstant(Clazz, StringConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.StringReferenceInitializer.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant2() {
    // Arrange
    StringReferenceInitializer stringReferenceInitializer =
        new StringReferenceInitializer(mock(ClassPool.class), KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryClass referencedClass = new LibraryClass();
    StringConstant stringConstant =
        new StringConstant(1, referencedClass, new LibraryField(1, "[]", "[]"));

    // Act
    stringReferenceInitializer.visitStringConstant(clazz, stringConstant);

    // Assert that nothing has changed
    Clazz clazz2 = stringConstant.referencedClass;
    assertTrue(clazz2 instanceof LibraryClass);
    assertEquals(0, clazz2.getAccessFlags());
    assertEquals(0, clazz2.getInterfaceCount());
    assertEquals(0, clazz2.getProcessingFlags());
    assertEquals(0, ((LibraryClass) clazz2).interfaceClasses.length);
    assertEquals(0, ((LibraryClass) clazz2).subClassCount);
    assertTrue(clazz2.getExtraFeatureNames().isEmpty());
    assertSame(referencedClass.subClasses, ((LibraryClass) clazz2).subClasses);
  }

  /**
   * Test {@link StringReferenceInitializer#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>Given {@link ClassPool} {@link ClassPool#getClass(String)} return {@code null}.
   *   <li>Then calls {@link StringConstant#getString(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link StringReferenceInitializer#visitStringConstant(Clazz,
   * StringConstant)}
   */
  @Test
  @DisplayName(
      "Test visitStringConstant(Clazz, StringConstant); given ClassPool getClass(String) return 'null'; then calls getString(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.StringReferenceInitializer.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant_givenClassPoolGetClassReturnNull_thenCallsGetString() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(null);
    ClassPool libraryClassPool = mock(ClassPool.class);
    when(libraryClassPool.getClass(Mockito.<String>any())).thenReturn(new LibraryClass());
    StringReferenceInitializer stringReferenceInitializer =
        new StringReferenceInitializer(programClassPool, libraryClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    StringConstant stringConstant = mock(StringConstant.class);
    when(stringConstant.getString(Mockito.<Clazz>any())).thenReturn("String");

    // Act
    stringReferenceInitializer.visitStringConstant(clazz, stringConstant);

    // Assert
    verify(programClassPool).getClass(eq("String"));
    verify(libraryClassPool).getClass(eq("String"));
    verify(stringConstant).getString(isA(Clazz.class));
  }

  /**
   * Test {@link StringReferenceInitializer#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>Given {@code []}.
   * </ul>
   *
   * <p>Method under test: {@link StringReferenceInitializer#visitStringConstant(Clazz,
   * StringConstant)}
   */
  @Test
  @DisplayName("Test visitStringConstant(Clazz, StringConstant); given '[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.StringReferenceInitializer.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant_givenLeftSquareBracketRightSquareBracket() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    LibraryClass libraryClass = new LibraryClass();
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(libraryClass);
    StringReferenceInitializer stringReferenceInitializer =
        new StringReferenceInitializer(programClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("[]");
    StringConstant stringConstant = new StringConstant();

    // Act
    stringReferenceInitializer.visitStringConstant(clazz, stringConstant);

    // Assert
    verify(programClassPool).getClass(eq(""));
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
   * Test {@link StringReferenceInitializer#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link StringConstant#getString(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link StringReferenceInitializer#visitStringConstant(Clazz,
   * StringConstant)}
   */
  @Test
  @DisplayName("Test visitStringConstant(Clazz, StringConstant); then calls getString(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.StringReferenceInitializer.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant_thenCallsGetString() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(new LibraryClass());
    StringReferenceInitializer stringReferenceInitializer =
        new StringReferenceInitializer(programClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    StringConstant stringConstant = mock(StringConstant.class);
    when(stringConstant.getString(Mockito.<Clazz>any())).thenReturn("String");

    // Act
    stringReferenceInitializer.visitStringConstant(clazz, stringConstant);

    // Assert
    verify(programClassPool).getClass(eq("String"));
    verify(stringConstant).getString(isA(Clazz.class));
  }

  /**
   * Test {@link StringReferenceInitializer#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>Then {@link StringConstant#StringConstant()} {@link StringConstant#referencedClass}
   *       {@link LibraryClass}.
   * </ul>
   *
   * <p>Method under test: {@link StringReferenceInitializer#visitStringConstant(Clazz,
   * StringConstant)}
   */
  @Test
  @DisplayName(
      "Test visitStringConstant(Clazz, StringConstant); then StringConstant() referencedClass LibraryClass")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.StringReferenceInitializer.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant_thenStringConstantReferencedClassLibraryClass() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    LibraryClass libraryClass = new LibraryClass();
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(libraryClass);
    StringReferenceInitializer stringReferenceInitializer =
        new StringReferenceInitializer(programClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    StringConstant stringConstant = new StringConstant();

    // Act
    stringReferenceInitializer.visitStringConstant(clazz, stringConstant);

    // Assert
    verify(programClassPool).getClass(eq("String"));
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
}
