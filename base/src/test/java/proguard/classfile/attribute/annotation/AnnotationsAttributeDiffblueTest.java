package proguard.classfile.attribute.annotation;

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
import proguard.classfile.attribute.annotation.visitor.AnnotationToAnnotatedClassVisitor;
import proguard.classfile.attribute.annotation.visitor.AnnotationVisitor;
import proguard.classfile.visitor.ClassVisitor;

class AnnotationsAttributeDiffblueTest {
  /**
   * Test {@link AnnotationsAttribute#annotationAccept(Clazz, Field, int, AnnotationVisitor)} with
   * {@code clazz}, {@code field}, {@code index}, {@code annotationVisitor}.
   *
   * <p>Method under test: {@link AnnotationsAttribute#annotationAccept(Clazz, Field, int,
   * AnnotationVisitor)}
   */
  @Test
  @DisplayName(
      "Test annotationAccept(Clazz, Field, int, AnnotationVisitor) with 'clazz', 'field', 'index', 'annotationVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.AnnotationsAttribute.annotationAccept(proguard.classfile.Clazz, proguard.classfile.Field, int, proguard.classfile.attribute.annotation.visitor.AnnotationVisitor)"
  })
  void testAnnotationAcceptWithClazzFieldIndexAnnotationVisitor() {
    // Arrange
    Annotation annotation = new Annotation();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute(
            1, 3, new Annotation[] {annotation, new Annotation()});
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    runtimeInvisibleAnnotationsAttribute.annotationAccept(
        clazz, field, 1, new AnnotationToAnnotatedClassVisitor(classVisitor));

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link AnnotationsAttribute#annotationAccept(Clazz, Method, int, AnnotationVisitor)} with
   * {@code clazz}, {@code method}, {@code index}, {@code annotationVisitor}.
   *
   * <p>Method under test: {@link AnnotationsAttribute#annotationAccept(Clazz, Method, int,
   * AnnotationVisitor)}
   */
  @Test
  @DisplayName(
      "Test annotationAccept(Clazz, Method, int, AnnotationVisitor) with 'clazz', 'method', 'index', 'annotationVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.AnnotationsAttribute.annotationAccept(proguard.classfile.Clazz, proguard.classfile.Method, int, proguard.classfile.attribute.annotation.visitor.AnnotationVisitor)"
  })
  void testAnnotationAcceptWithClazzMethodIndexAnnotationVisitor() {
    // Arrange
    Annotation annotation = new Annotation();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute(
            1, 3, new Annotation[] {annotation, new Annotation()});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    runtimeInvisibleAnnotationsAttribute.annotationAccept(
        clazz, method, 1, new AnnotationToAnnotatedClassVisitor(classVisitor));

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }
}
