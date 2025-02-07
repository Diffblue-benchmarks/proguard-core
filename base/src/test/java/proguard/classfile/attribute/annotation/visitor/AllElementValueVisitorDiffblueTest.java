package proguard.classfile.attribute.annotation.visitor;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import com.guardsquare.proguard.assembler.AnnotationsParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.annotation.Annotation;
import proguard.classfile.attribute.annotation.AnnotationDefaultAttribute;
import proguard.classfile.attribute.annotation.AnnotationElementValue;
import proguard.classfile.attribute.annotation.ElementValue;
import proguard.classfile.attribute.annotation.EnumConstantElementValue;
import proguard.classfile.editor.ConstantPoolRemapper;
import proguard.classfile.editor.ElementValueAdder;

class AllElementValueVisitorDiffblueTest {
  /**
   * Test {@link AllElementValueVisitor#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AnnotationDefaultAttribute#defaultValueAccept(Clazz,
   *       ElementValueVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link AllElementValueVisitor#visitAnnotationDefaultAttribute(Clazz,
   * Method, AnnotationDefaultAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute); then calls defaultValueAccept(Clazz, ElementValueVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AllElementValueVisitor.visitAnnotationDefaultAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute_thenCallsDefaultValueAccept() {
    // Arrange
    AllElementValueVisitor allElementValueVisitor =
        new AllElementValueVisitor(true, new ConstantPoolRemapper());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AnnotationDefaultAttribute annotationDefaultAttribute = mock(AnnotationDefaultAttribute.class);
    doNothing()
        .when(annotationDefaultAttribute)
        .defaultValueAccept(Mockito.<Clazz>any(), Mockito.<ElementValueVisitor>any());

    // Act
    allElementValueVisitor.visitAnnotationDefaultAttribute(
        clazz, method, annotationDefaultAttribute);

    // Assert
    verify(annotationDefaultAttribute)
        .defaultValueAccept(isA(Clazz.class), isA(ElementValueVisitor.class));
  }

  /**
   * Test {@link AllElementValueVisitor#visitAnnotation(Clazz, Annotation)} with {@code clazz},
   * {@code annotation}.
   *
   * <ul>
   *   <li>Then calls {@link Annotation#elementValuesAccept(Clazz, ElementValueVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link AllElementValueVisitor#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'; then calls elementValuesAccept(Clazz, ElementValueVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AllElementValueVisitor.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzAnnotation_thenCallsElementValuesAccept() {
    // Arrange
    AllElementValueVisitor allElementValueVisitor =
        new AllElementValueVisitor(true, new ConstantPoolRemapper());
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = mock(Annotation.class);
    doNothing()
        .when(annotation)
        .elementValuesAccept(Mockito.<Clazz>any(), Mockito.<ElementValueVisitor>any());

    // Act
    allElementValueVisitor.visitAnnotation(clazz, annotation);

    // Assert
    verify(annotation).elementValuesAccept(isA(Clazz.class), isA(ElementValueVisitor.class));
  }

  /**
   * Test {@link AllElementValueVisitor#visitEnumConstantElementValue(Clazz, Annotation,
   * EnumConstantElementValue)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AllElementValueVisitor#visitEnumConstantElementValue(Clazz,
   * Annotation, EnumConstantElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AllElementValueVisitor.visitEnumConstantElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.EnumConstantElementValue)"
  })
  void testVisitEnumConstantElementValue_thenCallsGetString() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AllElementValueVisitor allElementValueVisitor =
        new AllElementValueVisitor(
            new ElementValueAdder(
                targetClass,
                new Annotation(1, 3, new ElementValue[] {new AnnotationElementValue()}),
                true));
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();

    // Act
    allElementValueVisitor.visitEnumConstantElementValue(
        clazz, annotation, new EnumConstantElementValue(1, 1, 1));

    // Assert
    verify(targetClass, atLeast(1)).getString(eq(0));
  }

  /**
   * Test {@link AllElementValueVisitor#visitEnumConstantElementValue(Clazz, Annotation,
   * EnumConstantElementValue)}.
   *
   * <ul>
   *   <li>Then calls {@link AnnotationsParser#visitEnumConstantElementValue(Clazz, Annotation,
   *       EnumConstantElementValue)}.
   * </ul>
   *
   * <p>Method under test: {@link AllElementValueVisitor#visitEnumConstantElementValue(Clazz,
   * Annotation, EnumConstantElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue); then calls visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AllElementValueVisitor.visitEnumConstantElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.EnumConstantElementValue)"
  })
  void testVisitEnumConstantElementValue_thenCallsVisitEnumConstantElementValue() {
    // Arrange
    AnnotationsParser elementValueVisitor = mock(AnnotationsParser.class);
    doNothing()
        .when(elementValueVisitor)
        .visitEnumConstantElementValue(
            Mockito.<Clazz>any(),
            Mockito.<Annotation>any(),
            Mockito.<EnumConstantElementValue>any());
    AllElementValueVisitor allElementValueVisitor =
        new AllElementValueVisitor(true, elementValueVisitor);
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();

    // Act
    allElementValueVisitor.visitEnumConstantElementValue(
        clazz, annotation, new EnumConstantElementValue(1, 1, 1));

    // Assert
    verify(elementValueVisitor)
        .visitEnumConstantElementValue(
            isA(Clazz.class), isA(Annotation.class), isA(EnumConstantElementValue.class));
  }

  /**
   * Test {@link AllElementValueVisitor#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}.
   *
   * <p>Method under test: {@link AllElementValueVisitor#visitAnnotationElementValue(Clazz,
   * Annotation, AnnotationElementValue)}
   */
  @Test
  @DisplayName("Test visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AllElementValueVisitor.visitAnnotationElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.AnnotationElementValue)"
  })
  void testVisitAnnotationElementValue() {
    // Arrange
    AnnotationsParser elementValueVisitor = mock(AnnotationsParser.class);
    doNothing()
        .when(elementValueVisitor)
        .visitAnnotationElementValue(
            Mockito.<Clazz>any(), Mockito.<Annotation>any(), Mockito.<AnnotationElementValue>any());
    AllElementValueVisitor allElementValueVisitor =
        new AllElementValueVisitor(true, elementValueVisitor);
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();

    // Act
    allElementValueVisitor.visitAnnotationElementValue(
        clazz, annotation, new AnnotationElementValue(1, new Annotation()));

    // Assert
    verify(elementValueVisitor)
        .visitAnnotationElementValue(
            isA(Clazz.class), isA(Annotation.class), isA(AnnotationElementValue.class));
  }

  /**
   * Test {@link AllElementValueVisitor#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}.
   *
   * <p>Method under test: {@link AllElementValueVisitor#visitAnnotationElementValue(Clazz,
   * Annotation, AnnotationElementValue)}
   */
  @Test
  @DisplayName("Test visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AllElementValueVisitor.visitAnnotationElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.AnnotationElementValue)"
  })
  void testVisitAnnotationElementValue2() {
    // Arrange
    AnnotationsParser elementValueVisitor = mock(AnnotationsParser.class);
    doNothing()
        .when(elementValueVisitor)
        .visitAnnotationElementValue(
            Mockito.<Clazz>any(), Mockito.<Annotation>any(), Mockito.<AnnotationElementValue>any());
    AllElementValueVisitor allElementValueVisitor =
        new AllElementValueVisitor(false, elementValueVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    allElementValueVisitor.visitAnnotationElementValue(
        clazz, new Annotation(), mock(AnnotationElementValue.class));

    // Assert
    verify(elementValueVisitor)
        .visitAnnotationElementValue(
            isA(Clazz.class), isA(Annotation.class), isA(AnnotationElementValue.class));
  }

  /**
   * Test {@link AllElementValueVisitor#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}.
   *
   * <ul>
   *   <li>Then calls {@link AnnotationElementValue#annotationAccept(Clazz, AnnotationVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link AllElementValueVisitor#visitAnnotationElementValue(Clazz,
   * Annotation, AnnotationElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue); then calls annotationAccept(Clazz, AnnotationVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AllElementValueVisitor.visitAnnotationElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.AnnotationElementValue)"
  })
  void testVisitAnnotationElementValue_thenCallsAnnotationAccept() {
    // Arrange
    AnnotationsParser elementValueVisitor = mock(AnnotationsParser.class);
    doNothing()
        .when(elementValueVisitor)
        .visitAnnotationElementValue(
            Mockito.<Clazz>any(), Mockito.<Annotation>any(), Mockito.<AnnotationElementValue>any());
    AllElementValueVisitor allElementValueVisitor =
        new AllElementValueVisitor(true, elementValueVisitor);
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    AnnotationElementValue annotationElementValue = mock(AnnotationElementValue.class);
    doNothing()
        .when(annotationElementValue)
        .annotationAccept(Mockito.<Clazz>any(), Mockito.<AnnotationVisitor>any());

    // Act
    allElementValueVisitor.visitAnnotationElementValue(clazz, annotation, annotationElementValue);

    // Assert
    verify(elementValueVisitor)
        .visitAnnotationElementValue(
            isA(Clazz.class), isA(Annotation.class), isA(AnnotationElementValue.class));
    verify(annotationElementValue).annotationAccept(isA(Clazz.class), isA(AnnotationVisitor.class));
  }
}
