package proguard.classfile.util.kotlin;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.function.BiConsumer;
import kotlin.metadata.KmAnnotationArgument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.kotlin.KotlinAnnotatable;
import proguard.classfile.kotlin.KotlinAnnotation;
import proguard.classfile.kotlin.KotlinAnnotationArgument;
import proguard.classfile.kotlin.KotlinAnnotationArgument.AnnotationValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.ArrayValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.BooleanValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.ByteValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.CharValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.ClassValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.DoubleValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.EnumValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.FloatValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.IntValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.LongValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.ShortValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.StringValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.UByteValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.UIntValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.ULongValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.UShortValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.Value;
import proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor;

class AnnotationArgumentConstructorDiffblueTest {
  /**
   * Test {@link AnnotationArgumentConstructor#visitAnnotationArgument(Clazz, KotlinAnnotatable,
   * KotlinAnnotation, KotlinAnnotationArgument, AnnotationValue)}.
   *
   * <ul>
   *   <li>Then calls {@link BiConsumer#accept(Object, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationArgumentConstructor#visitAnnotationArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument,
   * KotlinAnnotationArgument.AnnotationValue)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, AnnotationValue); then calls accept(Object, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.kotlin.AnnotationArgumentConstructor.visitAnnotationArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$AnnotationValue)"
  })
  void testVisitAnnotationArgument_thenCallsAccept() {
    // Arrange
    BiConsumer<String, KmAnnotationArgument> consumer = mock(BiConsumer.class);
    doNothing().when(consumer).accept(Mockito.<String>any(), Mockito.<KmAnnotationArgument>any());
    AnnotationArgumentConstructor annotationArgumentConstructor =
        new AnnotationArgumentConstructor(consumer);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    // Act
    annotationArgumentConstructor.visitAnnotationArgument(
        clazz,
        annotatable,
        annotation,
        argument,
        new AnnotationValue(new KotlinAnnotation("Class Name")));

    // Assert
    verify(consumer).accept(eq("Name"), isA(KmAnnotationArgument.class));
  }

  /**
   * Test {@link AnnotationArgumentConstructor#visitArrayArgument(Clazz, KotlinAnnotatable,
   * KotlinAnnotation, KotlinAnnotationArgument, ArrayValue)}.
   *
   * <ul>
   *   <li>Given {@link KotlinAnnotationArgument.Value} {@link
   *       KotlinAnnotationArgument.Value#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   *       KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)} does nothing.
   *   <li>Then calls {@link KotlinAnnotationArgument.Value#accept(Clazz, KotlinAnnotatable,
   *       KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationArgumentConstructor#visitArrayArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument,
   * KotlinAnnotationArgument.ArrayValue)}
   */
  @Test
  @DisplayName(
      "Test visitArrayArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ArrayValue); given Value accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor) does nothing; then calls accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.kotlin.AnnotationArgumentConstructor.visitArrayArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$ArrayValue)"
  })
  void testVisitArrayArgument_givenValueAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    BiConsumer<String, KmAnnotationArgument> consumer = mock(BiConsumer.class);
    doNothing().when(consumer).accept(Mockito.<String>any(), Mockito.<KmAnnotationArgument>any());
    AnnotationArgumentConstructor annotationArgumentConstructor =
        new AnnotationArgumentConstructor(consumer);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    Value value = mock(Value.class);
    doNothing()
        .when(value)
        .accept(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any(),
            Mockito.<KotlinAnnotationArgument>any(),
            Mockito.<KotlinAnnotationArgumentVisitor>any());

    ArrayList<Value> elements = new ArrayList<>();
    elements.add(value);

    // Act
    annotationArgumentConstructor.visitArrayArgument(
        clazz, annotatable, annotation, argument, new ArrayValue(elements));

    // Assert
    verify(consumer).accept(eq("Name"), isA(KmAnnotationArgument.class));
    verify(value)
        .accept(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotation.class),
            isA(KotlinAnnotationArgument.class),
            isA(KotlinAnnotationArgumentVisitor.class));
  }

  /**
   * Test {@link AnnotationArgumentConstructor#visitArrayArgument(Clazz, KotlinAnnotatable,
   * KotlinAnnotation, KotlinAnnotationArgument, ArrayValue)}.
   *
   * <ul>
   *   <li>Given {@link KotlinAnnotationArgument.Value} {@link
   *       KotlinAnnotationArgument.Value#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   *       KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)} does nothing.
   *   <li>Then calls {@link KotlinAnnotationArgument.Value#accept(Clazz, KotlinAnnotatable,
   *       KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationArgumentConstructor#visitArrayArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument,
   * KotlinAnnotationArgument.ArrayValue)}
   */
  @Test
  @DisplayName(
      "Test visitArrayArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ArrayValue); given Value accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor) does nothing; then calls accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.kotlin.AnnotationArgumentConstructor.visitArrayArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$ArrayValue)"
  })
  void testVisitArrayArgument_givenValueAcceptDoesNothing_thenCallsAccept2() {
    // Arrange
    BiConsumer<String, KmAnnotationArgument> consumer = mock(BiConsumer.class);
    doNothing().when(consumer).accept(Mockito.<String>any(), Mockito.<KmAnnotationArgument>any());
    AnnotationArgumentConstructor annotationArgumentConstructor =
        new AnnotationArgumentConstructor(consumer);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    Value value = mock(Value.class);
    doNothing()
        .when(value)
        .accept(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any(),
            Mockito.<KotlinAnnotationArgument>any(),
            Mockito.<KotlinAnnotationArgumentVisitor>any());
    Value value2 = mock(Value.class);
    doNothing()
        .when(value2)
        .accept(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any(),
            Mockito.<KotlinAnnotationArgument>any(),
            Mockito.<KotlinAnnotationArgumentVisitor>any());

    ArrayList<Value> elements = new ArrayList<>();
    elements.add(value2);
    elements.add(value);

    // Act
    annotationArgumentConstructor.visitArrayArgument(
        clazz, annotatable, annotation, argument, new ArrayValue(elements));

    // Assert
    verify(consumer).accept(eq("Name"), isA(KmAnnotationArgument.class));
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
   * Test {@link AnnotationArgumentConstructor#visitArrayArgument(Clazz, KotlinAnnotatable,
   * KotlinAnnotation, KotlinAnnotationArgument, ArrayValue)}.
   *
   * <ul>
   *   <li>When {@link KotlinAnnotationArgument#KotlinAnnotationArgument(String, Value)} with {@code
   *       Name} and {@link KotlinAnnotationArgument.Value}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationArgumentConstructor#visitArrayArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument,
   * KotlinAnnotationArgument.ArrayValue)}
   */
  @Test
  @DisplayName(
      "Test visitArrayArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ArrayValue); when KotlinAnnotationArgument(String, Value) with 'Name' and Value")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.kotlin.AnnotationArgumentConstructor.visitArrayArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$ArrayValue)"
  })
  void testVisitArrayArgument_whenKotlinAnnotationArgumentWithNameAndValue() {
    // Arrange
    BiConsumer<String, KmAnnotationArgument> consumer = mock(BiConsumer.class);
    doNothing().when(consumer).accept(Mockito.<String>any(), Mockito.<KmAnnotationArgument>any());
    AnnotationArgumentConstructor annotationArgumentConstructor =
        new AnnotationArgumentConstructor(consumer);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    // Act
    annotationArgumentConstructor.visitArrayArgument(
        clazz, annotatable, annotation, argument, new ArrayValue(new ArrayList<>()));

    // Assert
    verify(consumer).accept(eq("Name"), isA(KmAnnotationArgument.class));
  }

  /**
   * Test {@link AnnotationArgumentConstructor#visitBooleanArgument(Clazz, KotlinAnnotatable,
   * KotlinAnnotation, KotlinAnnotationArgument, BooleanValue)}.
   *
   * <p>Method under test: {@link AnnotationArgumentConstructor#visitBooleanArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, BooleanValue)}
   */
  @Test
  @DisplayName(
      "Test visitBooleanArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, BooleanValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.kotlin.AnnotationArgumentConstructor.visitBooleanArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$BooleanValue)"
  })
  void testVisitBooleanArgument() {
    // Arrange
    BiConsumer<String, KmAnnotationArgument> consumer = mock(BiConsumer.class);
    doNothing().when(consumer).accept(Mockito.<String>any(), Mockito.<KmAnnotationArgument>any());
    AnnotationArgumentConstructor annotationArgumentConstructor =
        new AnnotationArgumentConstructor(consumer);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    // Act
    annotationArgumentConstructor.visitBooleanArgument(
        clazz, annotatable, annotation, argument, new BooleanValue(true));

    // Assert
    verify(consumer).accept(eq("Name"), isA(KmAnnotationArgument.class));
  }

  /**
   * Test {@link AnnotationArgumentConstructor#visitByteArgument(Clazz, KotlinAnnotatable,
   * KotlinAnnotation, KotlinAnnotationArgument, ByteValue)}.
   *
   * <p>Method under test: {@link AnnotationArgumentConstructor#visitByteArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ByteValue)}
   */
  @Test
  @DisplayName(
      "Test visitByteArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ByteValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.kotlin.AnnotationArgumentConstructor.visitByteArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$ByteValue)"
  })
  void testVisitByteArgument() {
    // Arrange
    BiConsumer<String, KmAnnotationArgument> consumer = mock(BiConsumer.class);
    doNothing().when(consumer).accept(Mockito.<String>any(), Mockito.<KmAnnotationArgument>any());
    AnnotationArgumentConstructor annotationArgumentConstructor =
        new AnnotationArgumentConstructor(consumer);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    // Act
    annotationArgumentConstructor.visitByteArgument(
        clazz, annotatable, annotation, argument, new ByteValue((byte) 'A'));

    // Assert
    verify(consumer).accept(eq("Name"), isA(KmAnnotationArgument.class));
  }

  /**
   * Test {@link AnnotationArgumentConstructor#visitCharArgument(Clazz, KotlinAnnotatable,
   * KotlinAnnotation, KotlinAnnotationArgument, CharValue)}.
   *
   * <p>Method under test: {@link AnnotationArgumentConstructor#visitCharArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, CharValue)}
   */
  @Test
  @DisplayName(
      "Test visitCharArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, CharValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.kotlin.AnnotationArgumentConstructor.visitCharArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$CharValue)"
  })
  void testVisitCharArgument() {
    // Arrange
    BiConsumer<String, KmAnnotationArgument> consumer = mock(BiConsumer.class);
    doNothing().when(consumer).accept(Mockito.<String>any(), Mockito.<KmAnnotationArgument>any());
    AnnotationArgumentConstructor annotationArgumentConstructor =
        new AnnotationArgumentConstructor(consumer);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    // Act
    annotationArgumentConstructor.visitCharArgument(
        clazz, annotatable, annotation, argument, new CharValue('A'));

    // Assert
    verify(consumer).accept(eq("Name"), isA(KmAnnotationArgument.class));
  }

  /**
   * Test {@link AnnotationArgumentConstructor#visitClassArgument(Clazz, KotlinAnnotatable,
   * KotlinAnnotation, KotlinAnnotationArgument, ClassValue)}.
   *
   * <p>Method under test: {@link AnnotationArgumentConstructor#visitClassArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ClassValue)}
   */
  @Test
  @DisplayName(
      "Test visitClassArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ClassValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.kotlin.AnnotationArgumentConstructor.visitClassArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue)"
  })
  void testVisitClassArgument() {
    // Arrange
    BiConsumer<String, KmAnnotationArgument> consumer = mock(BiConsumer.class);
    doNothing().when(consumer).accept(Mockito.<String>any(), Mockito.<KmAnnotationArgument>any());
    AnnotationArgumentConstructor annotationArgumentConstructor =
        new AnnotationArgumentConstructor(consumer);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    // Act
    annotationArgumentConstructor.visitClassArgument(
        clazz, annotatable, annotation, argument, new ClassValue("clazz", 3));

    // Assert
    verify(consumer).accept(eq("Name"), isA(KmAnnotationArgument.class));
  }

  /**
   * Test {@link AnnotationArgumentConstructor#visitClassArgument(Clazz, KotlinAnnotatable,
   * KotlinAnnotation, KotlinAnnotationArgument, ClassValue)}.
   *
   * <ul>
   *   <li>When {@link ClassValue#ClassValue(String)} with {@code Class Name}.
   *   <li>Then calls {@link BiConsumer#accept(Object, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationArgumentConstructor#visitClassArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ClassValue)}
   */
  @Test
  @DisplayName(
      "Test visitClassArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ClassValue); when ClassValue(String) with 'Class Name'; then calls accept(Object, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.kotlin.AnnotationArgumentConstructor.visitClassArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue)"
  })
  void testVisitClassArgument_whenClassValueWithClassName_thenCallsAccept() {
    // Arrange
    BiConsumer<String, KmAnnotationArgument> consumer = mock(BiConsumer.class);
    doNothing().when(consumer).accept(Mockito.<String>any(), Mockito.<KmAnnotationArgument>any());
    AnnotationArgumentConstructor annotationArgumentConstructor =
        new AnnotationArgumentConstructor(consumer);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    // Act
    annotationArgumentConstructor.visitClassArgument(
        clazz, annotatable, annotation, argument, new ClassValue("Class Name"));

    // Assert
    verify(consumer).accept(eq("Name"), isA(KmAnnotationArgument.class));
  }

  /**
   * Test {@link AnnotationArgumentConstructor#visitDoubleArgument(Clazz, KotlinAnnotatable,
   * KotlinAnnotation, KotlinAnnotationArgument, DoubleValue)}.
   *
   * <p>Method under test: {@link AnnotationArgumentConstructor#visitDoubleArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument,
   * KotlinAnnotationArgument.DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test visitDoubleArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, DoubleValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.kotlin.AnnotationArgumentConstructor.visitDoubleArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$DoubleValue)"
  })
  void testVisitDoubleArgument() {
    // Arrange
    BiConsumer<String, KmAnnotationArgument> consumer = mock(BiConsumer.class);
    doNothing().when(consumer).accept(Mockito.<String>any(), Mockito.<KmAnnotationArgument>any());
    AnnotationArgumentConstructor annotationArgumentConstructor =
        new AnnotationArgumentConstructor(consumer);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    // Act
    annotationArgumentConstructor.visitDoubleArgument(
        clazz, annotatable, annotation, argument, new DoubleValue(10.0d));

    // Assert
    verify(consumer).accept(eq("Name"), isA(KmAnnotationArgument.class));
  }

  /**
   * Test {@link AnnotationArgumentConstructor#visitEnumArgument(Clazz, KotlinAnnotatable,
   * KotlinAnnotation, KotlinAnnotationArgument, EnumValue)}.
   *
   * <p>Method under test: {@link AnnotationArgumentConstructor#visitEnumArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, EnumValue)}
   */
  @Test
  @DisplayName(
      "Test visitEnumArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, EnumValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.kotlin.AnnotationArgumentConstructor.visitEnumArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$EnumValue)"
  })
  void testVisitEnumArgument() {
    // Arrange
    BiConsumer<String, KmAnnotationArgument> consumer = mock(BiConsumer.class);
    doNothing().when(consumer).accept(Mockito.<String>any(), Mockito.<KmAnnotationArgument>any());
    AnnotationArgumentConstructor annotationArgumentConstructor =
        new AnnotationArgumentConstructor(consumer);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    // Act
    annotationArgumentConstructor.visitEnumArgument(
        clazz, annotatable, annotation, argument, new EnumValue("Class Name", "Enum Entry Name"));

    // Assert
    verify(consumer).accept(eq("Name"), isA(KmAnnotationArgument.class));
  }

  /**
   * Test {@link AnnotationArgumentConstructor#visitFloatArgument(Clazz, KotlinAnnotatable,
   * KotlinAnnotation, KotlinAnnotationArgument, FloatValue)}.
   *
   * <p>Method under test: {@link AnnotationArgumentConstructor#visitFloatArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument,
   * KotlinAnnotationArgument.FloatValue)}
   */
  @Test
  @DisplayName(
      "Test visitFloatArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, FloatValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.kotlin.AnnotationArgumentConstructor.visitFloatArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$FloatValue)"
  })
  void testVisitFloatArgument() {
    // Arrange
    BiConsumer<String, KmAnnotationArgument> consumer = mock(BiConsumer.class);
    doNothing().when(consumer).accept(Mockito.<String>any(), Mockito.<KmAnnotationArgument>any());
    AnnotationArgumentConstructor annotationArgumentConstructor =
        new AnnotationArgumentConstructor(consumer);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    // Act
    annotationArgumentConstructor.visitFloatArgument(
        clazz, annotatable, annotation, argument, new FloatValue(10.0f));

    // Assert
    verify(consumer).accept(eq("Name"), isA(KmAnnotationArgument.class));
  }

  /**
   * Test {@link AnnotationArgumentConstructor#visitIntArgument(Clazz, KotlinAnnotatable,
   * KotlinAnnotation, KotlinAnnotationArgument, IntValue)}.
   *
   * <p>Method under test: {@link AnnotationArgumentConstructor#visitIntArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument,
   * KotlinAnnotationArgument.IntValue)}
   */
  @Test
  @DisplayName(
      "Test visitIntArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, IntValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.kotlin.AnnotationArgumentConstructor.visitIntArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$IntValue)"
  })
  void testVisitIntArgument() {
    // Arrange
    BiConsumer<String, KmAnnotationArgument> consumer = mock(BiConsumer.class);
    doNothing().when(consumer).accept(Mockito.<String>any(), Mockito.<KmAnnotationArgument>any());
    AnnotationArgumentConstructor annotationArgumentConstructor =
        new AnnotationArgumentConstructor(consumer);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    // Act
    annotationArgumentConstructor.visitIntArgument(
        clazz, annotatable, annotation, argument, new IntValue(42));

    // Assert
    verify(consumer).accept(eq("Name"), isA(KmAnnotationArgument.class));
  }

  /**
   * Test {@link AnnotationArgumentConstructor#visitLongArgument(Clazz, KotlinAnnotatable,
   * KotlinAnnotation, KotlinAnnotationArgument, LongValue)}.
   *
   * <p>Method under test: {@link AnnotationArgumentConstructor#visitLongArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument,
   * KotlinAnnotationArgument.LongValue)}
   */
  @Test
  @DisplayName(
      "Test visitLongArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, LongValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.kotlin.AnnotationArgumentConstructor.visitLongArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$LongValue)"
  })
  void testVisitLongArgument() {
    // Arrange
    BiConsumer<String, KmAnnotationArgument> consumer = mock(BiConsumer.class);
    doNothing().when(consumer).accept(Mockito.<String>any(), Mockito.<KmAnnotationArgument>any());
    AnnotationArgumentConstructor annotationArgumentConstructor =
        new AnnotationArgumentConstructor(consumer);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    // Act
    annotationArgumentConstructor.visitLongArgument(
        clazz, annotatable, annotation, argument, new LongValue(42L));

    // Assert
    verify(consumer).accept(eq("Name"), isA(KmAnnotationArgument.class));
  }

  /**
   * Test {@link AnnotationArgumentConstructor#visitShortArgument(Clazz, KotlinAnnotatable,
   * KotlinAnnotation, KotlinAnnotationArgument, ShortValue)}.
   *
   * <p>Method under test: {@link AnnotationArgumentConstructor#visitShortArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ShortValue)}
   */
  @Test
  @DisplayName(
      "Test visitShortArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ShortValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.kotlin.AnnotationArgumentConstructor.visitShortArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$ShortValue)"
  })
  void testVisitShortArgument() {
    // Arrange
    BiConsumer<String, KmAnnotationArgument> consumer = mock(BiConsumer.class);
    doNothing().when(consumer).accept(Mockito.<String>any(), Mockito.<KmAnnotationArgument>any());
    AnnotationArgumentConstructor annotationArgumentConstructor =
        new AnnotationArgumentConstructor(consumer);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    // Act
    annotationArgumentConstructor.visitShortArgument(
        clazz, annotatable, annotation, argument, new ShortValue((short) 1));

    // Assert
    verify(consumer).accept(eq("Name"), isA(KmAnnotationArgument.class));
  }

  /**
   * Test {@link AnnotationArgumentConstructor#visitStringArgument(Clazz, KotlinAnnotatable,
   * KotlinAnnotation, KotlinAnnotationArgument, StringValue)}.
   *
   * <p>Method under test: {@link AnnotationArgumentConstructor#visitStringArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument,
   * KotlinAnnotationArgument.StringValue)}
   */
  @Test
  @DisplayName(
      "Test visitStringArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, StringValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.kotlin.AnnotationArgumentConstructor.visitStringArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$StringValue)"
  })
  void testVisitStringArgument() {
    // Arrange
    BiConsumer<String, KmAnnotationArgument> consumer = mock(BiConsumer.class);
    doNothing().when(consumer).accept(Mockito.<String>any(), Mockito.<KmAnnotationArgument>any());
    AnnotationArgumentConstructor annotationArgumentConstructor =
        new AnnotationArgumentConstructor(consumer);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    // Act
    annotationArgumentConstructor.visitStringArgument(
        clazz, annotatable, annotation, argument, new StringValue("42"));

    // Assert
    verify(consumer).accept(eq("Name"), isA(KmAnnotationArgument.class));
  }

  /**
   * Test {@link AnnotationArgumentConstructor#visitUByteArgument(Clazz, KotlinAnnotatable,
   * KotlinAnnotation, KotlinAnnotationArgument, UByteValue)}.
   *
   * <p>Method under test: {@link AnnotationArgumentConstructor#visitUByteArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument,
   * KotlinAnnotationArgument.UByteValue)}
   */
  @Test
  @DisplayName(
      "Test visitUByteArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, UByteValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.kotlin.AnnotationArgumentConstructor.visitUByteArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$UByteValue)"
  })
  void testVisitUByteArgument() {
    // Arrange
    BiConsumer<String, KmAnnotationArgument> consumer = mock(BiConsumer.class);
    doNothing().when(consumer).accept(Mockito.<String>any(), Mockito.<KmAnnotationArgument>any());
    AnnotationArgumentConstructor annotationArgumentConstructor =
        new AnnotationArgumentConstructor(consumer);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    // Act
    annotationArgumentConstructor.visitUByteArgument(
        clazz, annotatable, annotation, argument, new UByteValue((byte) 'A'));

    // Assert
    verify(consumer).accept(eq("Name"), isA(KmAnnotationArgument.class));
  }

  /**
   * Test {@link AnnotationArgumentConstructor#visitUIntArgument(Clazz, KotlinAnnotatable,
   * KotlinAnnotation, KotlinAnnotationArgument, UIntValue)}.
   *
   * <p>Method under test: {@link AnnotationArgumentConstructor#visitUIntArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, UIntValue)}
   */
  @Test
  @DisplayName(
      "Test visitUIntArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, UIntValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.kotlin.AnnotationArgumentConstructor.visitUIntArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$UIntValue)"
  })
  void testVisitUIntArgument() {
    // Arrange
    BiConsumer<String, KmAnnotationArgument> consumer = mock(BiConsumer.class);
    doNothing().when(consumer).accept(Mockito.<String>any(), Mockito.<KmAnnotationArgument>any());
    AnnotationArgumentConstructor annotationArgumentConstructor =
        new AnnotationArgumentConstructor(consumer);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    // Act
    annotationArgumentConstructor.visitUIntArgument(
        clazz, annotatable, annotation, argument, new UIntValue(42));

    // Assert
    verify(consumer).accept(eq("Name"), isA(KmAnnotationArgument.class));
  }

  /**
   * Test {@link AnnotationArgumentConstructor#visitULongArgument(Clazz, KotlinAnnotatable,
   * KotlinAnnotation, KotlinAnnotationArgument, ULongValue)}.
   *
   * <p>Method under test: {@link AnnotationArgumentConstructor#visitULongArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument,
   * KotlinAnnotationArgument.ULongValue)}
   */
  @Test
  @DisplayName(
      "Test visitULongArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ULongValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.kotlin.AnnotationArgumentConstructor.visitULongArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$ULongValue)"
  })
  void testVisitULongArgument() {
    // Arrange
    BiConsumer<String, KmAnnotationArgument> consumer = mock(BiConsumer.class);
    doNothing().when(consumer).accept(Mockito.<String>any(), Mockito.<KmAnnotationArgument>any());
    AnnotationArgumentConstructor annotationArgumentConstructor =
        new AnnotationArgumentConstructor(consumer);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    // Act
    annotationArgumentConstructor.visitULongArgument(
        clazz, annotatable, annotation, argument, new ULongValue(42L));

    // Assert
    verify(consumer).accept(eq("Name"), isA(KmAnnotationArgument.class));
  }

  /**
   * Test {@link AnnotationArgumentConstructor#visitUShortArgument(Clazz, KotlinAnnotatable,
   * KotlinAnnotation, KotlinAnnotationArgument, UShortValue)}.
   *
   * <p>Method under test: {@link AnnotationArgumentConstructor#visitUShortArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument,
   * KotlinAnnotationArgument.UShortValue)}
   */
  @Test
  @DisplayName(
      "Test visitUShortArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, UShortValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.kotlin.AnnotationArgumentConstructor.visitUShortArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$UShortValue)"
  })
  void testVisitUShortArgument() {
    // Arrange
    BiConsumer<String, KmAnnotationArgument> consumer = mock(BiConsumer.class);
    doNothing().when(consumer).accept(Mockito.<String>any(), Mockito.<KmAnnotationArgument>any());
    AnnotationArgumentConstructor annotationArgumentConstructor =
        new AnnotationArgumentConstructor(consumer);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    // Act
    annotationArgumentConstructor.visitUShortArgument(
        clazz, annotatable, annotation, argument, new UShortValue((short) 1));

    // Assert
    verify(consumer).accept(eq("Name"), isA(KmAnnotationArgument.class));
  }
}
