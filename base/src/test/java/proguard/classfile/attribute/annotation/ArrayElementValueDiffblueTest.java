package proguard.classfile.attribute.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.annotation.visitor.ElementValueVisitor;
import proguard.classfile.editor.ConstantPoolRemapper;

class ArrayElementValueDiffblueTest {
  /**
   * Test {@link ArrayElementValue#ArrayElementValue()}.
   *
   * <p>Method under test: {@link ArrayElementValue#ArrayElementValue()}
   */
  @Test
  @DisplayName("Test new ArrayElementValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.ArrayElementValue.<init>()",
    "void proguard.classfile.attribute.annotation.ArrayElementValue.<init>(int, int, proguard.classfile.attribute.annotation.ElementValue[])"
  })
  void testNewArrayElementValue() {
    // Arrange and Act
    ArrayElementValue actualArrayElementValue = new ArrayElementValue();

    // Assert
    assertNull(actualArrayElementValue.getProcessingInfo());
    assertEquals(0, actualArrayElementValue.getProcessingFlags());
  }

  /**
   * Test {@link ArrayElementValue#ArrayElementValue(int, int, ElementValue[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link ArrayElementValue#ArrayElementValue(int, int, ElementValue[])}
   */
  @Test
  @DisplayName("Test new ArrayElementValue(int, int, ElementValue[]); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.ArrayElementValue.<init>()",
    "void proguard.classfile.attribute.annotation.ArrayElementValue.<init>(int, int, proguard.classfile.attribute.annotation.ElementValue[])"
  })
  void testNewArrayElementValue_whenOne() {
    // Arrange and Act
    ArrayElementValue actualArrayElementValue =
        new ArrayElementValue(1, 3, new ElementValue[] {new AnnotationElementValue()});

    // Assert
    assertNull(actualArrayElementValue.getProcessingInfo());
    assertEquals(0, actualArrayElementValue.getProcessingFlags());
  }

  /**
   * Test {@link ArrayElementValue#getTag()}.
   *
   * <p>Method under test: {@link ArrayElementValue#getTag()}
   */
  @Test
  @DisplayName("Test getTag()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"char proguard.classfile.attribute.annotation.ArrayElementValue.getTag()"})
  void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(ElementValue.TAG_ARRAY, (new ArrayElementValue()).getTag());
  }

  /**
   * Test {@link ArrayElementValue#elementValueAccept(Clazz, Annotation, int, ElementValueVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link AnnotationElementValue#accept(Clazz, Annotation, ElementValueVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayElementValue#elementValueAccept(Clazz, Annotation, int,
   * ElementValueVisitor)}
   */
  @Test
  @DisplayName(
      "Test elementValueAccept(Clazz, Annotation, int, ElementValueVisitor); then calls accept(Clazz, Annotation, ElementValueVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.ArrayElementValue.elementValueAccept(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, int, proguard.classfile.attribute.annotation.visitor.ElementValueVisitor)"
  })
  void testElementValueAccept_thenCallsAccept() {
    // Arrange
    AnnotationElementValue annotationElementValue = mock(AnnotationElementValue.class);
    doNothing()
        .when(annotationElementValue)
        .accept(
            Mockito.<Clazz>any(), Mockito.<Annotation>any(), Mockito.<ElementValueVisitor>any());
    ArrayElementValue arrayElementValue =
        new ArrayElementValue(
            1, 3, new ElementValue[] {new AnnotationElementValue(), annotationElementValue});
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();

    // Act
    arrayElementValue.elementValueAccept(clazz, annotation, 1, new ConstantPoolRemapper());

    // Assert
    verify(annotationElementValue)
        .accept(isA(Clazz.class), isA(Annotation.class), isA(ElementValueVisitor.class));
  }
}
