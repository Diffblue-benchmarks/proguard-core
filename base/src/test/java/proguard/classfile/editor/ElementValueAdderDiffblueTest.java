package proguard.classfile.editor;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
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
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.annotation.Annotation;
import proguard.classfile.attribute.annotation.AnnotationDefaultAttribute;
import proguard.classfile.attribute.annotation.AnnotationElementValue;
import proguard.classfile.attribute.annotation.ArrayElementValue;
import proguard.classfile.attribute.annotation.ClassElementValue;
import proguard.classfile.attribute.annotation.ConstantElementValue;
import proguard.classfile.attribute.annotation.ElementValue;
import proguard.classfile.attribute.annotation.EnumConstantElementValue;
import proguard.classfile.attribute.annotation.visitor.AnnotationVisitor;

class ElementValueAdderDiffblueTest {
  /**
   * Test {@link ElementValueAdder#visitConstantElementValue(Clazz, Annotation,
   * ConstantElementValue)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ElementValueAdder#visitConstantElementValue(Clazz, Annotation,
   * ConstantElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitConstantElementValue(Clazz, Annotation, ConstantElementValue); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ElementValueAdder.visitConstantElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ConstantElementValue)"
  })
  void testVisitConstantElementValue_thenCallsGetString() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    ElementValueAdder elementValueAdder =
        new ElementValueAdder(
            targetClass,
            new Annotation(1, 3, new ElementValue[] {new AnnotationElementValue()}),
            true);
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();

    // Act
    elementValueAdder.visitConstantElementValue(clazz, annotation, new ConstantElementValue('A'));

    // Assert
    verify(targetClass, atLeast(1)).getString(eq(0));
  }

  /**
   * Test {@link ElementValueAdder#visitEnumConstantElementValue(Clazz, Annotation,
   * EnumConstantElementValue)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ElementValueAdder#visitEnumConstantElementValue(Clazz, Annotation,
   * EnumConstantElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ElementValueAdder.visitEnumConstantElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.EnumConstantElementValue)"
  })
  void testVisitEnumConstantElementValue_thenCallsGetString() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    ElementValueAdder elementValueAdder =
        new ElementValueAdder(
            targetClass,
            new Annotation(1, 3, new ElementValue[] {new AnnotationElementValue()}),
            true);
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();

    // Act
    elementValueAdder.visitEnumConstantElementValue(
        clazz, annotation, new EnumConstantElementValue(1, 1, 1));

    // Assert
    verify(targetClass, atLeast(1)).getString(eq(0));
  }

  /**
   * Test {@link ElementValueAdder#visitClassElementValue(Clazz, Annotation, ClassElementValue)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ElementValueAdder#visitClassElementValue(Clazz, Annotation,
   * ClassElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitClassElementValue(Clazz, Annotation, ClassElementValue); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ElementValueAdder.visitClassElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ClassElementValue)"
  })
  void testVisitClassElementValue_thenCallsGetString() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    ElementValueAdder elementValueAdder =
        new ElementValueAdder(
            targetClass,
            new Annotation(1, 3, new ElementValue[] {new AnnotationElementValue()}),
            true);
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();

    // Act
    elementValueAdder.visitClassElementValue(clazz, annotation, new ClassElementValue(1, 1));

    // Assert
    verify(targetClass, atLeast(1)).getString(eq(0));
  }

  /**
   * Test {@link ElementValueAdder#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}.
   *
   * <p>Method under test: {@link ElementValueAdder#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}
   */
  @Test
  @DisplayName("Test visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ElementValueAdder.visitAnnotationElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.AnnotationElementValue)"
  })
  void testVisitAnnotationElementValue() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    ElementValueAdder elementValueAdder =
        new ElementValueAdder(targetClass, new AnnotationDefaultAttribute(), true);
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    AnnotationElementValue annotationElementValue = mock(AnnotationElementValue.class);
    doNothing()
        .when(annotationElementValue)
        .annotationAccept(Mockito.<Clazz>any(), Mockito.<AnnotationVisitor>any());

    // Act
    elementValueAdder.visitAnnotationElementValue(clazz, annotation, annotationElementValue);

    // Assert
    verify(annotationElementValue).annotationAccept(isA(Clazz.class), isA(AnnotationVisitor.class));
  }

  /**
   * Test {@link ElementValueAdder#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ElementValueAdder#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ElementValueAdder.visitAnnotationElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.AnnotationElementValue)"
  })
  void testVisitAnnotationElementValue_thenCallsGetString() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    ElementValueAdder elementValueAdder =
        new ElementValueAdder(
            targetClass,
            new Annotation(1, 3, new ElementValue[] {new AnnotationElementValue()}),
            true);
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    AnnotationElementValue annotationElementValue = mock(AnnotationElementValue.class);
    doNothing()
        .when(annotationElementValue)
        .annotationAccept(Mockito.<Clazz>any(), Mockito.<AnnotationVisitor>any());

    // Act
    elementValueAdder.visitAnnotationElementValue(clazz, annotation, annotationElementValue);

    // Assert
    verify(targetClass, atLeast(1)).getString(eq(0));
    verify(annotationElementValue).annotationAccept(isA(Clazz.class), isA(AnnotationVisitor.class));
  }

  /**
   * Test {@link ElementValueAdder#visitArrayElementValue(Clazz, Annotation, ArrayElementValue)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ElementValueAdder#visitArrayElementValue(Clazz, Annotation,
   * ArrayElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitArrayElementValue(Clazz, Annotation, ArrayElementValue); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ElementValueAdder.visitArrayElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ArrayElementValue)"
  })
  void testVisitArrayElementValue_thenCallsGetString() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    ElementValueAdder elementValueAdder =
        new ElementValueAdder(
            targetClass,
            new Annotation(1, 3, new ElementValue[] {new AnnotationElementValue()}),
            true);
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();

    // Act
    elementValueAdder.visitArrayElementValue(clazz, annotation, new ArrayElementValue());

    // Assert
    verify(targetClass, atLeast(1)).getString(eq(0));
  }
}
