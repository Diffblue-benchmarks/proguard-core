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
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.Field;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.annotation.Annotation;
import proguard.classfile.visitor.ClassVisitor;
import proguard.util.CollectionMatcher;

class AnnotationTypeFilterDiffblueTest {
  /**
   * Test {@link AnnotationTypeFilter#visitAnnotation(Clazz, Annotation)} with {@code clazz}, {@code
   * annotation}.
   *
   * <p>Method under test: {@link AnnotationTypeFilter#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName("Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationTypeFilter.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzAnnotation() {
    // Arrange
    AnnotationTypeFilter annotationTypeFilter =
        new AnnotationTypeFilter("", new MultiAnnotationVisitor());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    annotationTypeFilter.visitAnnotation(clazz, new Annotation());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AnnotationTypeFilter#visitAnnotation(Clazz, Annotation)} with {@code clazz}, {@code
   * annotation}.
   *
   * <p>Method under test: {@link AnnotationTypeFilter#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName("Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationTypeFilter.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzAnnotation2() {
    // Arrange
    AnnotationTypeFilter annotationTypeFilter =
        new AnnotationTypeFilter(
            "", new AnnotationTypeFilter("Library class [", new MultiAnnotationVisitor()));
    LibraryClass clazz = mock(LibraryClass.class);
    Annotation annotation = mock(Annotation.class);
    when(annotation.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    annotationTypeFilter.visitAnnotation(clazz, annotation);

    // Assert
    verify(annotation, atLeast(1)).getType(isA(Clazz.class));
  }

  /**
   * Test {@link AnnotationTypeFilter#visitAnnotation(Clazz, Annotation)} with {@code clazz}, {@code
   * annotation}.
   *
   * <ul>
   *   <li>Given {@link CollectionMatcher#CollectionMatcher(Set)} with set is {@link
   *       HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationTypeFilter#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'; given CollectionMatcher(Set) with set is HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationTypeFilter.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzAnnotation_givenCollectionMatcherWithSetIsHashSet() {
    // Arrange
    CollectionMatcher stringMatcher = new CollectionMatcher(new HashSet<>());
    AnnotationTypeFilter annotationTypeFilter =
        new AnnotationTypeFilter(stringMatcher, new MultiAnnotationVisitor());
    LibraryClass clazz = mock(LibraryClass.class);
    Annotation annotation = mock(Annotation.class);
    when(annotation.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    annotationTypeFilter.visitAnnotation(clazz, annotation);

    // Assert
    verify(annotation).getType(isA(Clazz.class));
  }

  /**
   * Test {@link AnnotationTypeFilter#visitAnnotation(Clazz, Annotation)} with {@code clazz}, {@code
   * annotation}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationTypeFilter#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationTypeFilter.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzAnnotation_thenCallsGetString() {
    // Arrange
    AnnotationTypeFilter annotationTypeFilter =
        new AnnotationTypeFilter("Regular Expression", new MultiAnnotationVisitor());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    annotationTypeFilter.visitAnnotation(clazz, new Annotation());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AnnotationTypeFilter#visitAnnotation(Clazz, Annotation)} with {@code clazz}, {@code
   * annotation}.
   *
   * <ul>
   *   <li>Then calls {@link Annotation#getType(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationTypeFilter#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'; then calls getType(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationTypeFilter.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzAnnotation_thenCallsGetType() {
    // Arrange
    AnnotationTypeFilter annotationTypeFilter =
        new AnnotationTypeFilter("Regular Expression", new MultiAnnotationVisitor());
    LibraryClass clazz = mock(LibraryClass.class);
    Annotation annotation = mock(Annotation.class);
    when(annotation.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    annotationTypeFilter.visitAnnotation(clazz, annotation);

    // Assert
    verify(annotation).getType(isA(Clazz.class));
  }

  /**
   * Test {@link AnnotationTypeFilter#visitAnnotation(Clazz, Field, Annotation)} with {@code clazz},
   * {@code field}, {@code annotation}.
   *
   * <p>Method under test: {@link AnnotationTypeFilter#visitAnnotation(Clazz, Field, Annotation)}
   */
  @Test
  @DisplayName("Test visitAnnotation(Clazz, Field, Annotation) with 'clazz', 'field', 'annotation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationTypeFilter.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzFieldAnnotation() {
    // Arrange
    AnnotationTypeFilter annotationTypeFilter =
        new AnnotationTypeFilter("", new MultiAnnotationVisitor());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    annotationTypeFilter.visitAnnotation(clazz, (Field) field, new Annotation());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AnnotationTypeFilter#visitAnnotation(Clazz, Field, Annotation)} with {@code clazz},
   * {@code field}, {@code annotation}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#accept(ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationTypeFilter#visitAnnotation(Clazz, Field, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Field, Annotation) with 'clazz', 'field', 'annotation'; then calls accept(ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationTypeFilter.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzFieldAnnotation_thenCallsAccept() {
    // Arrange
    AnnotationTypeFilter annotationTypeFilter =
        new AnnotationTypeFilter(
            "", new AnnotationToAnnotatedClassVisitor(mock(ClassVisitor.class)));
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).accept(Mockito.<ClassVisitor>any());
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    Annotation annotation = mock(Annotation.class);
    when(annotation.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    annotationTypeFilter.visitAnnotation(clazz, (Field) field, annotation);

    // Assert
    verify(clazz).accept(isA(ClassVisitor.class));
    verify(annotation).getType(isA(Clazz.class));
  }

  /**
   * Test {@link AnnotationTypeFilter#visitAnnotation(Clazz, Field, Annotation)} with {@code clazz},
   * {@code field}, {@code annotation}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationTypeFilter#visitAnnotation(Clazz, Field, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Field, Annotation) with 'clazz', 'field', 'annotation'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationTypeFilter.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzFieldAnnotation_thenCallsGetString() {
    // Arrange
    AnnotationTypeFilter annotationTypeFilter =
        new AnnotationTypeFilter("Regular Expression", new MultiAnnotationVisitor());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    annotationTypeFilter.visitAnnotation(clazz, (Field) field, new Annotation());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AnnotationTypeFilter#visitAnnotation(Clazz, Field, Annotation)} with {@code clazz},
   * {@code field}, {@code annotation}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link Annotation#getType(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationTypeFilter#visitAnnotation(Clazz, Field, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Field, Annotation) with 'clazz', 'field', 'annotation'; when LibraryClass; then calls getType(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationTypeFilter.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzFieldAnnotation_whenLibraryClass_thenCallsGetType() {
    // Arrange
    AnnotationTypeFilter annotationTypeFilter =
        new AnnotationTypeFilter("Regular Expression", new MultiAnnotationVisitor());
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    Annotation annotation = mock(Annotation.class);
    when(annotation.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    annotationTypeFilter.visitAnnotation(clazz, (Field) field, annotation);

    // Assert
    verify(annotation).getType(isA(Clazz.class));
  }

  /**
   * Test {@link AnnotationTypeFilter#visitAnnotation(Clazz, Method, Annotation)} with {@code
   * clazz}, {@code method}, {@code annotation}.
   *
   * <p>Method under test: {@link AnnotationTypeFilter#visitAnnotation(Clazz, Method, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Method, Annotation) with 'clazz', 'method', 'annotation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationTypeFilter.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzMethodAnnotation() {
    // Arrange
    AnnotationTypeFilter annotationTypeFilter =
        new AnnotationTypeFilter("", new MultiAnnotationVisitor());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    annotationTypeFilter.visitAnnotation(clazz, (Method) method, new Annotation());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AnnotationTypeFilter#visitAnnotation(Clazz, Method, Annotation)} with {@code
   * clazz}, {@code method}, {@code annotation}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#accept(ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationTypeFilter#visitAnnotation(Clazz, Method, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Method, Annotation) with 'clazz', 'method', 'annotation'; then calls accept(ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationTypeFilter.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzMethodAnnotation_thenCallsAccept() {
    // Arrange
    AnnotationTypeFilter annotationTypeFilter =
        new AnnotationTypeFilter(
            "", new AnnotationToAnnotatedClassVisitor(mock(ClassVisitor.class)));
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).accept(Mockito.<ClassVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    Annotation annotation = mock(Annotation.class);
    when(annotation.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    annotationTypeFilter.visitAnnotation(clazz, (Method) method, annotation);

    // Assert
    verify(clazz).accept(isA(ClassVisitor.class));
    verify(annotation).getType(isA(Clazz.class));
  }

  /**
   * Test {@link AnnotationTypeFilter#visitAnnotation(Clazz, Method, Annotation)} with {@code
   * clazz}, {@code method}, {@code annotation}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationTypeFilter#visitAnnotation(Clazz, Method, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Method, Annotation) with 'clazz', 'method', 'annotation'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationTypeFilter.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzMethodAnnotation_thenCallsGetString() {
    // Arrange
    AnnotationTypeFilter annotationTypeFilter =
        new AnnotationTypeFilter("Regular Expression", new MultiAnnotationVisitor());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    annotationTypeFilter.visitAnnotation(clazz, (Method) method, new Annotation());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AnnotationTypeFilter#visitAnnotation(Clazz, Method, Annotation)} with {@code
   * clazz}, {@code method}, {@code annotation}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link Annotation#getType(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationTypeFilter#visitAnnotation(Clazz, Method, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Method, Annotation) with 'clazz', 'method', 'annotation'; when LibraryClass; then calls getType(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationTypeFilter.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzMethodAnnotation_whenLibraryClass_thenCallsGetType() {
    // Arrange
    AnnotationTypeFilter annotationTypeFilter =
        new AnnotationTypeFilter("Regular Expression", new MultiAnnotationVisitor());
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    Annotation annotation = mock(Annotation.class);
    when(annotation.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    annotationTypeFilter.visitAnnotation(clazz, (Method) method, annotation);

    // Assert
    verify(annotation).getType(isA(Clazz.class));
  }

  /**
   * Test {@link AnnotationTypeFilter#visitAnnotation(Clazz, Method, CodeAttribute, Annotation)}
   * with {@code clazz}, {@code method}, {@code codeAttribute}, {@code annotation}.
   *
   * <p>Method under test: {@link AnnotationTypeFilter#visitAnnotation(Clazz, Method, CodeAttribute,
   * Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Method, CodeAttribute, Annotation) with 'clazz', 'method', 'codeAttribute', 'annotation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationTypeFilter.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzMethodCodeAttributeAnnotation() {
    // Arrange
    AnnotationTypeFilter annotationTypeFilter =
        new AnnotationTypeFilter("", new MultiAnnotationVisitor());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    annotationTypeFilter.visitAnnotation(clazz, method, codeAttribute, new Annotation());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AnnotationTypeFilter#visitAnnotation(Clazz, Method, CodeAttribute, Annotation)}
   * with {@code clazz}, {@code method}, {@code codeAttribute}, {@code annotation}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#accept(ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationTypeFilter#visitAnnotation(Clazz, Method, CodeAttribute,
   * Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Method, CodeAttribute, Annotation) with 'clazz', 'method', 'codeAttribute', 'annotation'; then calls accept(ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationTypeFilter.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzMethodCodeAttributeAnnotation_thenCallsAccept() {
    // Arrange
    AnnotationTypeFilter annotationTypeFilter =
        new AnnotationTypeFilter(
            "", new AnnotationToAnnotatedClassVisitor(mock(ClassVisitor.class)));
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).accept(Mockito.<ClassVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    Annotation annotation = mock(Annotation.class);
    when(annotation.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    annotationTypeFilter.visitAnnotation(clazz, method, codeAttribute, annotation);

    // Assert
    verify(clazz).accept(isA(ClassVisitor.class));
    verify(annotation).getType(isA(Clazz.class));
  }

  /**
   * Test {@link AnnotationTypeFilter#visitAnnotation(Clazz, Method, CodeAttribute, Annotation)}
   * with {@code clazz}, {@code method}, {@code codeAttribute}, {@code annotation}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationTypeFilter#visitAnnotation(Clazz, Method, CodeAttribute,
   * Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Method, CodeAttribute, Annotation) with 'clazz', 'method', 'codeAttribute', 'annotation'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationTypeFilter.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzMethodCodeAttributeAnnotation_thenCallsGetString() {
    // Arrange
    AnnotationTypeFilter annotationTypeFilter =
        new AnnotationTypeFilter("Regular Expression", new MultiAnnotationVisitor());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    annotationTypeFilter.visitAnnotation(clazz, method, codeAttribute, new Annotation());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AnnotationTypeFilter#visitAnnotation(Clazz, Method, CodeAttribute, Annotation)}
   * with {@code clazz}, {@code method}, {@code codeAttribute}, {@code annotation}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationTypeFilter#visitAnnotation(Clazz, Method, CodeAttribute,
   * Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Method, CodeAttribute, Annotation) with 'clazz', 'method', 'codeAttribute', 'annotation'; when LibraryClass")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationTypeFilter.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzMethodCodeAttributeAnnotation_whenLibraryClass() {
    // Arrange
    AnnotationTypeFilter annotationTypeFilter =
        new AnnotationTypeFilter("Regular Expression", new MultiAnnotationVisitor());
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    Annotation annotation = mock(Annotation.class);
    when(annotation.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    annotationTypeFilter.visitAnnotation(clazz, method, codeAttribute, annotation);

    // Assert
    verify(annotation).getType(isA(Clazz.class));
  }

  /**
   * Test {@link AnnotationTypeFilter#visitAnnotation(Clazz, Method, int, Annotation)} with {@code
   * clazz}, {@code method}, {@code parameterIndex}, {@code annotation}.
   *
   * <p>Method under test: {@link AnnotationTypeFilter#visitAnnotation(Clazz, Method, int,
   * Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Method, int, Annotation) with 'clazz', 'method', 'parameterIndex', 'annotation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationTypeFilter.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.Method, int, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzMethodParameterIndexAnnotation() {
    // Arrange
    AnnotationTypeFilter annotationTypeFilter =
        new AnnotationTypeFilter("", new MultiAnnotationVisitor());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    annotationTypeFilter.visitAnnotation(clazz, method, 1, new Annotation());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AnnotationTypeFilter#visitAnnotation(Clazz, Method, int, Annotation)} with {@code
   * clazz}, {@code method}, {@code parameterIndex}, {@code annotation}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#accept(ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationTypeFilter#visitAnnotation(Clazz, Method, int,
   * Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Method, int, Annotation) with 'clazz', 'method', 'parameterIndex', 'annotation'; then calls accept(ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationTypeFilter.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.Method, int, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzMethodParameterIndexAnnotation_thenCallsAccept() {
    // Arrange
    AnnotationTypeFilter annotationTypeFilter =
        new AnnotationTypeFilter(
            "", new AnnotationToAnnotatedClassVisitor(mock(ClassVisitor.class)));
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).accept(Mockito.<ClassVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    Annotation annotation = mock(Annotation.class);
    when(annotation.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    annotationTypeFilter.visitAnnotation(clazz, method, 1, annotation);

    // Assert
    verify(clazz).accept(isA(ClassVisitor.class));
    verify(annotation).getType(isA(Clazz.class));
  }

  /**
   * Test {@link AnnotationTypeFilter#visitAnnotation(Clazz, Method, int, Annotation)} with {@code
   * clazz}, {@code method}, {@code parameterIndex}, {@code annotation}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationTypeFilter#visitAnnotation(Clazz, Method, int,
   * Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Method, int, Annotation) with 'clazz', 'method', 'parameterIndex', 'annotation'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationTypeFilter.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.Method, int, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzMethodParameterIndexAnnotation_thenCallsGetString() {
    // Arrange
    AnnotationTypeFilter annotationTypeFilter =
        new AnnotationTypeFilter("Regular Expression", new MultiAnnotationVisitor());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    annotationTypeFilter.visitAnnotation(clazz, method, 1, new Annotation());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AnnotationTypeFilter#visitAnnotation(Clazz, Method, int, Annotation)} with {@code
   * clazz}, {@code method}, {@code parameterIndex}, {@code annotation}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationTypeFilter#visitAnnotation(Clazz, Method, int,
   * Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Method, int, Annotation) with 'clazz', 'method', 'parameterIndex', 'annotation'; when LibraryClass")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationTypeFilter.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.Method, int, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzMethodParameterIndexAnnotation_whenLibraryClass() {
    // Arrange
    AnnotationTypeFilter annotationTypeFilter =
        new AnnotationTypeFilter("Regular Expression", new MultiAnnotationVisitor());
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    Annotation annotation = mock(Annotation.class);
    when(annotation.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    annotationTypeFilter.visitAnnotation(clazz, method, 1, annotation);

    // Assert
    verify(annotation).getType(isA(Clazz.class));
  }
}
