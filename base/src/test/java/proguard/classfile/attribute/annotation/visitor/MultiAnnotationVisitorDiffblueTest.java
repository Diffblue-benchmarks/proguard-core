package proguard.classfile.attribute.annotation.visitor;

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
import proguard.classfile.Field;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.annotation.Annotation;
import proguard.classfile.visitor.ClassVisitor;

class MultiAnnotationVisitorDiffblueTest {
  /**
   * Test {@link MultiAnnotationVisitor#visitAnnotation(Clazz, Field, Annotation)} with {@code
   * clazz}, {@code field}, {@code annotation}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiAnnotationVisitor#visitAnnotation(Clazz, Field, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Field, Annotation) with 'clazz', 'field', 'annotation'; then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.MultiAnnotationVisitor.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzFieldAnnotation_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    MultiAnnotationVisitor multiAnnotationVisitor =
        new MultiAnnotationVisitor(new AnnotationToAnnotatedClassVisitor(classVisitor));
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    multiAnnotationVisitor.visitAnnotation(clazz, (Field) field, new Annotation());

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link MultiAnnotationVisitor#visitAnnotation(Clazz, Method, Annotation)} with {@code
   * clazz}, {@code method}, {@code annotation}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiAnnotationVisitor#visitAnnotation(Clazz, Method, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Method, Annotation) with 'clazz', 'method', 'annotation'; then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.MultiAnnotationVisitor.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzMethodAnnotation_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    MultiAnnotationVisitor multiAnnotationVisitor =
        new MultiAnnotationVisitor(new AnnotationToAnnotatedClassVisitor(classVisitor));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    multiAnnotationVisitor.visitAnnotation(clazz, (Method) method, new Annotation());

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link MultiAnnotationVisitor#visitAnnotation(Clazz, Method, CodeAttribute, Annotation)}
   * with {@code clazz}, {@code method}, {@code codeAttribute}, {@code annotation}.
   *
   * <p>Method under test: {@link MultiAnnotationVisitor#visitAnnotation(Clazz, Method,
   * CodeAttribute, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Method, CodeAttribute, Annotation) with 'clazz', 'method', 'codeAttribute', 'annotation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.MultiAnnotationVisitor.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzMethodCodeAttributeAnnotation() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    MultiAnnotationVisitor multiAnnotationVisitor =
        new MultiAnnotationVisitor(new AnnotationToAnnotatedClassVisitor(classVisitor));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    multiAnnotationVisitor.visitAnnotation(clazz, method, codeAttribute, new Annotation());

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link MultiAnnotationVisitor#visitAnnotation(Clazz, Method, int, Annotation)} with {@code
   * clazz}, {@code method}, {@code parameterIndex}, {@code annotation}.
   *
   * <p>Method under test: {@link MultiAnnotationVisitor#visitAnnotation(Clazz, Method, int,
   * Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Method, int, Annotation) with 'clazz', 'method', 'parameterIndex', 'annotation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.MultiAnnotationVisitor.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.Method, int, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzMethodParameterIndexAnnotation() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    MultiAnnotationVisitor multiAnnotationVisitor =
        new MultiAnnotationVisitor(new AnnotationToAnnotatedClassVisitor(classVisitor));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    multiAnnotationVisitor.visitAnnotation(clazz, method, 1, new Annotation());

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }
}
