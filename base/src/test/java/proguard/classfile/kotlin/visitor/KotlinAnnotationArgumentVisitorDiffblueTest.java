package proguard.classfile.kotlin.visitor;

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
import proguard.classfile.kotlin.KotlinAnnotationArgument.ClassValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.EnumValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.Value;
import proguard.classfile.kotlin.visitor.filter.KotlinAnnotationArgumentFilter;

class KotlinAnnotationArgumentVisitorDiffblueTest {
  /**
   * Test {@link KotlinAnnotationArgumentVisitor#visitClassArgument(Clazz, KotlinAnnotatable,
   * KotlinAnnotation, KotlinAnnotationArgument, ClassValue)}.
   *
   * <ul>
   *   <li>When {@link Value} {@link Value#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   *       KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)} does nothing.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationArgumentVisitor#visitClassArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ClassValue)}
   */
  @Test
  @DisplayName(
      "Test visitClassArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ClassValue); when Value accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor) does nothing; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor.visitClassArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue)"
  })
  void testVisitClassArgument_whenValueAcceptDoesNothing_thenCallsTest() {
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
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", value);

    // Act
    kotlinAnnotationArgumentFilter.visitClassArgument(
        clazz, annotatable, annotation, argument, new ClassValue("Class Name"));

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

  /**
   * Test {@link KotlinAnnotationArgumentVisitor#visitEnumArgument(Clazz, KotlinAnnotatable,
   * KotlinAnnotation, KotlinAnnotationArgument, EnumValue)}.
   *
   * <ul>
   *   <li>When {@link Value} {@link Value#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   *       KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)} does nothing.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationArgumentVisitor#visitEnumArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, EnumValue)}
   */
  @Test
  @DisplayName(
      "Test visitEnumArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, EnumValue); when Value accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor) does nothing; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor.visitEnumArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$EnumValue)"
  })
  void testVisitEnumArgument_whenValueAcceptDoesNothing_thenCallsTest() {
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
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", value);

    // Act
    kotlinAnnotationArgumentFilter.visitEnumArgument(
        clazz, annotatable, annotation, argument, new EnumValue("Class Name", "Enum Entry Name"));

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
