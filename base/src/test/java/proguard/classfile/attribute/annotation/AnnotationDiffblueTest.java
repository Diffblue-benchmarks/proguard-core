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
import proguard.classfile.attribute.annotation.visitor.ElementValueVisitor;
import proguard.classfile.editor.ConstantPoolRemapper;
import proguard.classfile.visitor.ClassVisitor;

class AnnotationDiffblueTest {
  /**
   * Test {@link Annotation#Annotation()}.
   *
   * <p>Method under test: {@link Annotation#Annotation()}
   */
  @Test
  @DisplayName("Test new Annotation()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.Annotation.<init>()",
    "void proguard.classfile.attribute.annotation.Annotation.<init>(int, int, proguard.classfile.attribute.annotation.ElementValue[])"
  })
  void testNewAnnotation() {
    // Arrange and Act
    Annotation actualAnnotation = new Annotation();

    // Assert
    assertNull(actualAnnotation.getProcessingInfo());
    assertEquals(0, actualAnnotation.getProcessingFlags());
  }

  /**
   * Test {@link Annotation#Annotation(int, int, ElementValue[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link Annotation#Annotation(int, int, ElementValue[])}
   */
  @Test
  @DisplayName("Test new Annotation(int, int, ElementValue[]); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.Annotation.<init>()",
    "void proguard.classfile.attribute.annotation.Annotation.<init>(int, int, proguard.classfile.attribute.annotation.ElementValue[])"
  })
  void testNewAnnotation_whenOne() {
    // Arrange and Act
    Annotation actualAnnotation =
        new Annotation(1, 3, new ElementValue[] {new AnnotationElementValue()});

    // Assert
    assertNull(actualAnnotation.getProcessingInfo());
    assertEquals(0, actualAnnotation.getProcessingFlags());
  }

  /**
   * Test {@link Annotation#getType(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getString(int)} return {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link Annotation#getType(Clazz)}
   */
  @Test
  @DisplayName(
      "Test getType(Clazz); given 'String'; when LibraryClass getString(int) return 'String'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.attribute.annotation.Annotation.getType(proguard.classfile.Clazz)"
  })
  void testGetType_givenString_whenLibraryClassGetStringReturnString_thenReturnString() {
    // Arrange
    Annotation annotation = new Annotation();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    String actualType = annotation.getType(clazz);

    // Assert
    verify(clazz).getString(eq(0));
    assertEquals("String", actualType);
  }

  /**
   * Test {@link Annotation#referencedClassAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link Annotation#referencedClassAccept(ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedClassAccept(ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.Annotation.referencedClassAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testReferencedClassAccept_thenCallsVisitLibraryClass() {
    // Arrange
    Annotation annotation = new Annotation();
    annotation.referencedClasses = new Clazz[] {new LibraryClass()};
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    annotation.referencedClassAccept(classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link Annotation#referencedClassesAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link Annotation#referencedClassesAccept(ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedClassesAccept(ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.Annotation.referencedClassesAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testReferencedClassesAccept_thenCallsVisitLibraryClass() {
    // Arrange
    Annotation annotation = new Annotation();
    annotation.referencedClasses = new Clazz[] {new LibraryClass()};
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    annotation.referencedClassesAccept(classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link Annotation#elementValueAccept(Clazz, int, ElementValueVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link AnnotationElementValue#accept(Clazz, Annotation, ElementValueVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link Annotation#elementValueAccept(Clazz, int, ElementValueVisitor)}
   */
  @Test
  @DisplayName(
      "Test elementValueAccept(Clazz, int, ElementValueVisitor); then calls accept(Clazz, Annotation, ElementValueVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.Annotation.elementValueAccept(proguard.classfile.Clazz, int, proguard.classfile.attribute.annotation.visitor.ElementValueVisitor)"
  })
  void testElementValueAccept_thenCallsAccept() {
    // Arrange
    AnnotationElementValue annotationElementValue = mock(AnnotationElementValue.class);
    doNothing()
        .when(annotationElementValue)
        .accept(
            Mockito.<Clazz>any(), Mockito.<Annotation>any(), Mockito.<ElementValueVisitor>any());
    Annotation annotation =
        new Annotation(
            1, 3, new ElementValue[] {new AnnotationElementValue(), annotationElementValue});
    LibraryClass clazz = new LibraryClass();

    // Act
    annotation.elementValueAccept(clazz, 1, new ConstantPoolRemapper());

    // Assert
    verify(annotationElementValue)
        .accept(isA(Clazz.class), isA(Annotation.class), isA(ElementValueVisitor.class));
  }
}
