package proguard.classfile.util.kotlin;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.function.Consumer;
import kotlin.metadata.KmAnnotation;
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

class AnnotationConstructorDiffblueTest {
  /**
   * Test {@link AnnotationConstructor#AnnotationConstructor(Consumer)}.
   *
   * <p>Method under test: {@link AnnotationConstructor#AnnotationConstructor(Consumer)}
   */
  @Test
  @DisplayName("Test new AnnotationConstructor(Consumer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.kotlin.AnnotationConstructor.<init>(java.util.function.Consumer)"
  })
  void testNewAnnotationConstructor() {
    // Arrange
    Consumer<KmAnnotation> consumer = mock(Consumer.class);
    doNothing().when(consumer).accept(Mockito.<KmAnnotation>any());

    // Act
    AnnotationConstructor actualAnnotationConstructor = new AnnotationConstructor(consumer);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    actualAnnotationConstructor.visitAnyAnnotation(
        clazz, annotatable, new KotlinAnnotation("Class Name"));

    // Assert
    verify(consumer).accept(isA(KmAnnotation.class));
  }

  /**
   * Test {@link AnnotationConstructor#visitAnyAnnotation(Clazz, KotlinAnnotatable,
   * KotlinAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link KotlinAnnotationArgument#KotlinAnnotationArgument(String, Value)} with name
   *       is {@code clazz} and {@link Value}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationConstructor#visitAnyAnnotation(Clazz, KotlinAnnotatable,
   * KotlinAnnotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnyAnnotation(Clazz, KotlinAnnotatable, KotlinAnnotation); given KotlinAnnotationArgument(String, Value) with name is 'clazz' and Value")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.kotlin.AnnotationConstructor.visitAnyAnnotation(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation)"
  })
  void testVisitAnyAnnotation_givenKotlinAnnotationArgumentWithNameIsClazzAndValue() {
    // Arrange
    Consumer<KmAnnotation> consumer = mock(Consumer.class);
    doNothing().when(consumer).accept(Mockito.<KmAnnotation>any());
    AnnotationConstructor annotationConstructor = new AnnotationConstructor(consumer);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    Value value = mock(Value.class);
    doNothing()
        .when(value)
        .accept(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any(),
            Mockito.<KotlinAnnotationArgument>any(),
            Mockito.<KotlinAnnotationArgumentVisitor>any());
    KotlinAnnotationArgument kotlinAnnotationArgument = new KotlinAnnotationArgument("Name", value);

    Value value2 = mock(Value.class);
    doNothing()
        .when(value2)
        .accept(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any(),
            Mockito.<KotlinAnnotationArgument>any(),
            Mockito.<KotlinAnnotationArgumentVisitor>any());
    KotlinAnnotationArgument kotlinAnnotationArgument2 =
        new KotlinAnnotationArgument("clazz", value2);

    ArrayList<KotlinAnnotationArgument> arguments = new ArrayList<>();
    arguments.add(kotlinAnnotationArgument2);
    arguments.add(kotlinAnnotationArgument);

    // Act
    annotationConstructor.visitAnyAnnotation(
        clazz, annotatable, new KotlinAnnotation("clazz", arguments));

    // Assert
    verify(consumer).accept(isA(KmAnnotation.class));
    verify(value2)
        .accept(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotation.class),
            isA(KotlinAnnotationArgument.class),
            isA(KotlinAnnotationArgumentVisitor.class));
    verify(value)
        .accept(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotation.class),
            isA(KotlinAnnotationArgument.class),
            isA(KotlinAnnotationArgumentVisitor.class));
  }

  /**
   * Test {@link AnnotationConstructor#visitAnyAnnotation(Clazz, KotlinAnnotatable,
   * KotlinAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link Value} {@link Value#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   *       KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)} does nothing.
   *   <li>Then calls {@link Value#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   *       KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationConstructor#visitAnyAnnotation(Clazz, KotlinAnnotatable,
   * KotlinAnnotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnyAnnotation(Clazz, KotlinAnnotatable, KotlinAnnotation); given Value accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor) does nothing; then calls accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.kotlin.AnnotationConstructor.visitAnyAnnotation(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation)"
  })
  void testVisitAnyAnnotation_givenValueAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    Consumer<KmAnnotation> consumer = mock(Consumer.class);
    doNothing().when(consumer).accept(Mockito.<KmAnnotation>any());
    AnnotationConstructor annotationConstructor = new AnnotationConstructor(consumer);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    Value value = mock(Value.class);
    doNothing()
        .when(value)
        .accept(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any(),
            Mockito.<KotlinAnnotationArgument>any(),
            Mockito.<KotlinAnnotationArgumentVisitor>any());
    KotlinAnnotationArgument kotlinAnnotationArgument = new KotlinAnnotationArgument("Name", value);

    ArrayList<KotlinAnnotationArgument> arguments = new ArrayList<>();
    arguments.add(kotlinAnnotationArgument);

    // Act
    annotationConstructor.visitAnyAnnotation(
        clazz, annotatable, new KotlinAnnotation("clazz", arguments));

    // Assert
    verify(consumer).accept(isA(KmAnnotation.class));
    verify(value)
        .accept(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotation.class),
            isA(KotlinAnnotationArgument.class),
            isA(KotlinAnnotationArgumentVisitor.class));
  }

  /**
   * Test {@link AnnotationConstructor#visitAnyAnnotation(Clazz, KotlinAnnotatable,
   * KotlinAnnotation)}.
   *
   * <ul>
   *   <li>When {@link KotlinAnnotation#KotlinAnnotation(String)} with {@code Class Name}.
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationConstructor#visitAnyAnnotation(Clazz, KotlinAnnotatable,
   * KotlinAnnotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnyAnnotation(Clazz, KotlinAnnotatable, KotlinAnnotation); when KotlinAnnotation(String) with 'Class Name'; then calls accept(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.kotlin.AnnotationConstructor.visitAnyAnnotation(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation)"
  })
  void testVisitAnyAnnotation_whenKotlinAnnotationWithClassName_thenCallsAccept() {
    // Arrange
    Consumer<KmAnnotation> consumer = mock(Consumer.class);
    doNothing().when(consumer).accept(Mockito.<KmAnnotation>any());
    AnnotationConstructor annotationConstructor = new AnnotationConstructor(consumer);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);

    // Act
    annotationConstructor.visitAnyAnnotation(
        clazz, annotatable, new KotlinAnnotation("Class Name"));

    // Assert
    verify(consumer).accept(isA(KmAnnotation.class));
  }
}
