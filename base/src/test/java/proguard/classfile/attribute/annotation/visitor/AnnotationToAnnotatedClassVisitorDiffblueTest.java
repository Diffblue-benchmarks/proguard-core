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
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.annotation.Annotation;
import proguard.classfile.visitor.ClassVisitor;

class AnnotationToAnnotatedClassVisitorDiffblueTest {
  /**
   * Test {@link AnnotationToAnnotatedClassVisitor#visitAnnotation(Clazz, Annotation)} with {@code
   * clazz}, {@code annotation}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationToAnnotatedClassVisitor#visitAnnotation(Clazz,
   * Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'; then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationToAnnotatedClassVisitor.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzAnnotation_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    AnnotationToAnnotatedClassVisitor annotationToAnnotatedClassVisitor =
        new AnnotationToAnnotatedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    annotationToAnnotatedClassVisitor.visitAnnotation(clazz, new Annotation());

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }
}
