package proguard.classfile.kotlin.visitor.filter;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.kotlin.KotlinAnnotatable;
import proguard.classfile.kotlin.KotlinAnnotation;
import proguard.classfile.kotlin.KotlinAnnotationArgument;
import proguard.classfile.kotlin.KotlinAnnotationArgument.Value;
import proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor;

class KotlinAnnotationArgumentFilterDiffblueTest {
  /**
   * Test {@link KotlinAnnotationArgumentFilter#visitAnyArgument(Clazz, KotlinAnnotatable,
   * KotlinAnnotation, KotlinAnnotationArgument, Value)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationArgumentFilter#visitAnyArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, Value)}
   */
  @Test
  @DisplayName(
      "Test visitAnyArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, Value); given Predicate test(Object) return 'false'; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinAnnotationArgumentFilter.visitAnyArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$Value)"
  })
  void testVisitAnyArgument_givenPredicateTestReturnFalse_thenCallsTest() {
    // Arrange
    Predicate<KotlinAnnotationArgument> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinAnnotationArgument>any())).thenReturn(false);
    KotlinAnnotationArgumentFilter kotlinAnnotationArgumentFilter =
        new KotlinAnnotationArgumentFilter(predicate, mock(KotlinAnnotationArgumentVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");

    // Act
    kotlinAnnotationArgumentFilter.visitAnyArgument(
        clazz,
        annotatable,
        annotation,
        new KotlinAnnotationArgument("Name", mock(Value.class)),
        mock(Value.class));

    // Assert
    verify(predicate).test(isA(KotlinAnnotationArgument.class));
  }

  /**
   * Test {@link KotlinAnnotationArgumentFilter#visitAnyArgument(Clazz, KotlinAnnotatable,
   * KotlinAnnotation, KotlinAnnotationArgument, Value)}.
   *
   * <ul>
   *   <li>When {@link Value} {@link Value#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   *       KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)} does nothing.
   *   <li>Then calls {@link Value#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   *       KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationArgumentFilter#visitAnyArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, Value)}
   */
  @Test
  @DisplayName(
      "Test visitAnyArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, Value); when Value accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor) does nothing; then calls accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinAnnotationArgumentFilter.visitAnyArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$Value)"
  })
  void testVisitAnyArgument_whenValueAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    Predicate<KotlinAnnotationArgument> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinAnnotationArgument>any())).thenReturn(true);
    KotlinAnnotationArgumentFilter kotlinAnnotationArgumentFilter =
        new KotlinAnnotationArgumentFilter(predicate, mock(KotlinAnnotationArgumentVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    Value value = mock(Value.class);
    doNothing()
        .when(value)
        .accept(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any(),
            Mockito.<KotlinAnnotationArgument>any(),
            Mockito.<KotlinAnnotationArgumentVisitor>any());

    // Act
    kotlinAnnotationArgumentFilter.visitAnyArgument(
        clazz,
        annotatable,
        annotation,
        new KotlinAnnotationArgument("Name", value),
        mock(Value.class));

    // Assert
    verify(predicate).test(isA(KotlinAnnotationArgument.class));
    verify(value)
        .accept(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotation.class),
            isA(KotlinAnnotationArgument.class),
            isA(KotlinAnnotationArgumentVisitor.class));
  }
}
