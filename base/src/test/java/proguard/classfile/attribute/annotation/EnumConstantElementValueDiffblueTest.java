package proguard.classfile.attribute.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.annotation.visitor.AllElementValueVisitor;
import proguard.classfile.attribute.annotation.visitor.ElementValueVisitor;
import proguard.classfile.visitor.ClassVisitor;

class EnumConstantElementValueDiffblueTest {
  /**
   * Test {@link EnumConstantElementValue#EnumConstantElementValue()}.
   *
   * <p>Method under test: {@link EnumConstantElementValue#EnumConstantElementValue()}
   */
  @Test
  @DisplayName("Test new EnumConstantElementValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.EnumConstantElementValue.<init>()",
    "void proguard.classfile.attribute.annotation.EnumConstantElementValue.<init>(int, int, int)"
  })
  void testNewEnumConstantElementValue() {
    // Arrange and Act
    EnumConstantElementValue actualEnumConstantElementValue = new EnumConstantElementValue();

    // Assert
    assertNull(actualEnumConstantElementValue.getProcessingInfo());
    assertEquals(0, actualEnumConstantElementValue.getProcessingFlags());
  }

  /**
   * Test {@link EnumConstantElementValue#EnumConstantElementValue(int, int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link EnumConstantElementValue#EnumConstantElementValue(int, int, int)}
   */
  @Test
  @DisplayName("Test new EnumConstantElementValue(int, int, int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.EnumConstantElementValue.<init>()",
    "void proguard.classfile.attribute.annotation.EnumConstantElementValue.<init>(int, int, int)"
  })
  void testNewEnumConstantElementValue_whenOne() {
    // Arrange and Act
    EnumConstantElementValue actualEnumConstantElementValue = new EnumConstantElementValue(1, 1, 1);

    // Assert
    assertNull(actualEnumConstantElementValue.getProcessingInfo());
    assertEquals(0, actualEnumConstantElementValue.getProcessingFlags());
  }

  /**
   * Test {@link EnumConstantElementValue#getTypeName(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link EnumConstantElementValue#getTypeName(Clazz)}
   */
  @Test
  @DisplayName("Test getTypeName(Clazz); given 'String'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.attribute.annotation.EnumConstantElementValue.getTypeName(proguard.classfile.Clazz)"
  })
  void testGetTypeName_givenString_thenReturnString() {
    // Arrange
    EnumConstantElementValue enumConstantElementValue = new EnumConstantElementValue(1, 1, 1);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    String actualTypeName = enumConstantElementValue.getTypeName(clazz);

    // Assert
    verify(clazz).getString(eq(1));
    assertEquals("String", actualTypeName);
  }

  /**
   * Test {@link EnumConstantElementValue#getConstantName(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link EnumConstantElementValue#getConstantName(Clazz)}
   */
  @Test
  @DisplayName("Test getConstantName(Clazz); given 'String'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.attribute.annotation.EnumConstantElementValue.getConstantName(proguard.classfile.Clazz)"
  })
  void testGetConstantName_givenString_thenReturnString() {
    // Arrange
    EnumConstantElementValue enumConstantElementValue = new EnumConstantElementValue(1, 1, 1);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    String actualConstantName = enumConstantElementValue.getConstantName(clazz);

    // Assert
    verify(clazz).getString(eq(1));
    assertEquals("String", actualConstantName);
  }

  /**
   * Test {@link EnumConstantElementValue#referencedClassesAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link EnumConstantElementValue#referencedClassesAccept(ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedClassesAccept(ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.EnumConstantElementValue.referencedClassesAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testReferencedClassesAccept_thenCallsVisitLibraryClass() {
    // Arrange
    EnumConstantElementValue enumConstantElementValue = new EnumConstantElementValue(1, 1, 1);
    enumConstantElementValue.referencedClasses = new Clazz[] {new LibraryClass()};
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    enumConstantElementValue.referencedClassesAccept(classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link EnumConstantElementValue#getTag()}.
   *
   * <p>Method under test: {@link EnumConstantElementValue#getTag()}
   */
  @Test
  @DisplayName("Test getTag()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "char proguard.classfile.attribute.annotation.EnumConstantElementValue.getTag()"
  })
  void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(ElementValue.TAG_ENUM_CONSTANT, (new EnumConstantElementValue(1, 1, 1)).getTag());
  }

  /**
   * Test {@link EnumConstantElementValue#accept(Clazz, Annotation, ElementValueVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link AllElementValueVisitor#visitEnumConstantElementValue(Clazz, Annotation,
   *       EnumConstantElementValue)}.
   * </ul>
   *
   * <p>Method under test: {@link EnumConstantElementValue#accept(Clazz, Annotation,
   * ElementValueVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Annotation, ElementValueVisitor); then calls visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.EnumConstantElementValue.accept(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.visitor.ElementValueVisitor)"
  })
  void testAccept_thenCallsVisitEnumConstantElementValue() {
    // Arrange
    EnumConstantElementValue enumConstantElementValue = new EnumConstantElementValue(1, 1, 1);
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    AllElementValueVisitor elementValueVisitor = mock(AllElementValueVisitor.class);
    doNothing()
        .when(elementValueVisitor)
        .visitEnumConstantElementValue(
            Mockito.<Clazz>any(),
            Mockito.<Annotation>any(),
            Mockito.<EnumConstantElementValue>any());

    // Act
    enumConstantElementValue.accept(clazz, annotation, elementValueVisitor);

    // Assert
    verify(elementValueVisitor)
        .visitEnumConstantElementValue(
            isA(Clazz.class), isA(Annotation.class), isA(EnumConstantElementValue.class));
  }
}
