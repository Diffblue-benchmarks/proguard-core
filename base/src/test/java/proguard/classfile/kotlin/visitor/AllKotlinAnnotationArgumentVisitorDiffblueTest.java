package proguard.classfile.kotlin.visitor;

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
import proguard.classfile.kotlin.KotlinAnnotatable;
import proguard.classfile.kotlin.KotlinAnnotation;

class AllKotlinAnnotationArgumentVisitorDiffblueTest {
  /**
   * Test {@link AllKotlinAnnotationArgumentVisitor#visitAnyAnnotation(Clazz, KotlinAnnotatable,
   * KotlinAnnotation)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinAnnotation#argumentsAccept(Clazz, KotlinAnnotatable,
   *       KotlinAnnotationArgumentVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link AllKotlinAnnotationArgumentVisitor#visitAnyAnnotation(Clazz,
   * KotlinAnnotatable, KotlinAnnotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnyAnnotation(Clazz, KotlinAnnotatable, KotlinAnnotation); then calls argumentsAccept(Clazz, KotlinAnnotatable, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.AllKotlinAnnotationArgumentVisitor.visitAnyAnnotation(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation)"
  })
  void testVisitAnyAnnotation_thenCallsArgumentsAccept() {
    // Arrange
    AllKotlinAnnotationArgumentVisitor allKotlinAnnotationArgumentVisitor =
        new AllKotlinAnnotationArgumentVisitor(mock(KotlinAnnotationArgumentVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = mock(KotlinAnnotation.class);
    doNothing()
        .when(annotation)
        .argumentsAccept(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotationArgumentVisitor>any());

    // Act
    allKotlinAnnotationArgumentVisitor.visitAnyAnnotation(clazz, annotatable, annotation);

    // Assert
    verify(annotation)
        .argumentsAccept(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotationArgumentVisitor.class));
  }
}
