package proguard.classfile.kotlin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMember;
import proguard.classfile.LibraryMethod;
import proguard.classfile.editor.AttributeSorter;
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
import proguard.classfile.kotlin.KotlinAnnotationArgument.LiteralValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.LongValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.ShortValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.StringValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.UByteValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.UIntValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.ULongValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.UShortValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.Value;
import proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor;
import proguard.classfile.kotlin.visitor.KotlinAnnotationVisitor;
import proguard.classfile.visitor.ClassVisitor;
import proguard.classfile.visitor.MemberVisitor;

class KotlinAnnotationArgumentDiffblueTest {
  /**
   * Test AnnotationValue {@link AnnotationValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   *
   * <p>Method under test: {@link AnnotationValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}
   */
  @Test
  @DisplayName(
      "Test AnnotationValue accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$AnnotationValue.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor)"
  })
  void testAnnotationValueAccept() {
    // Arrange
    AnnotationValue annotationValue = new AnnotationValue(new KotlinAnnotation("Class Name"));
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation kotlinMetadataAnnotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    KotlinAnnotationArgumentVisitor visitor = mock(KotlinAnnotationArgumentVisitor.class);
    doNothing()
        .when(visitor)
        .visitAnnotationArgument(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any(),
            Mockito.<KotlinAnnotationArgument>any(),
            Mockito.<AnnotationValue>any());

    // Act
    annotationValue.accept(clazz, annotatable, kotlinMetadataAnnotation, argument, visitor);

    // Assert
    verify(visitor)
        .visitAnnotationArgument(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotation.class),
            isA(KotlinAnnotationArgument.class),
            isA(AnnotationValue.class));
  }

  /**
   * Test AnnotationValue {@link AnnotationValue#annotationAccept(Clazz, KotlinAnnotatable,
   * KotlinAnnotationVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinAnnotationVisitor#visitAnyAnnotation(Clazz, KotlinAnnotatable,
   *       KotlinAnnotation)}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationValue#annotationAccept(Clazz, KotlinAnnotatable,
   * KotlinAnnotationVisitor)}
   */
  @Test
  @DisplayName(
      "Test AnnotationValue annotationAccept(Clazz, KotlinAnnotatable, KotlinAnnotationVisitor); then calls visitAnyAnnotation(Clazz, KotlinAnnotatable, KotlinAnnotation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$AnnotationValue.annotationAccept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.visitor.KotlinAnnotationVisitor)"
  })
  void testAnnotationValueAnnotationAccept_thenCallsVisitAnyAnnotation() {
    // Arrange
    AnnotationValue annotationValue = new AnnotationValue(new KotlinAnnotation("Class Name"));
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotationVisitor visitor = mock(KotlinAnnotationVisitor.class);
    doNothing()
        .when(visitor)
        .visitAnyAnnotation(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any());

    // Act
    annotationValue.annotationAccept(clazz, annotatable, visitor);

    // Assert
    verify(visitor)
        .visitAnyAnnotation(
            isA(Clazz.class), isA(KotlinAnnotatable.class), isA(KotlinAnnotation.class));
  }

  /**
   * Test AnnotationValue {@link AnnotationValue#equals(Object)}, and {@link
   * AnnotationValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AnnotationValue#equals(Object)}
   *   <li>{@link AnnotationValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test AnnotationValue equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$AnnotationValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$AnnotationValue.hashCode()"
  })
  void testAnnotationValueEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AnnotationValue annotationValue = new AnnotationValue(new KotlinAnnotation("Class Name"));
    AnnotationValue annotationValue2 = new AnnotationValue(new KotlinAnnotation("Class Name"));

    // Act and Assert
    assertEquals(annotationValue, annotationValue2);
    int expectedHashCodeResult = annotationValue.hashCode();
    assertEquals(expectedHashCodeResult, annotationValue2.hashCode());
  }

  /**
   * Test AnnotationValue {@link AnnotationValue#equals(Object)}, and {@link
   * AnnotationValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AnnotationValue#equals(Object)}
   *   <li>{@link AnnotationValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test AnnotationValue equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$AnnotationValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$AnnotationValue.hashCode()"
  })
  void testAnnotationValueEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AnnotationValue annotationValue = new AnnotationValue(new KotlinAnnotation("Class Name"));

    // Act and Assert
    assertEquals(annotationValue, annotationValue);
    int expectedHashCodeResult = annotationValue.hashCode();
    assertEquals(expectedHashCodeResult, annotationValue.hashCode());
  }

  /**
   * Test AnnotationValue {@link AnnotationValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationValue#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test AnnotationValue equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$AnnotationValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$AnnotationValue.hashCode()"
  })
  void testAnnotationValueEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AnnotationValue annotationValue =
        new AnnotationValue(new KotlinAnnotation("proguard.classfile.kotlin.KotlinAnnotation"));

    // Act and Assert
    assertNotEquals(annotationValue, new AnnotationValue(new KotlinAnnotation("Class Name")));
  }

  /**
   * Test AnnotationValue {@link AnnotationValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationValue#equals(Object)}
   */
  @Test
  @DisplayName("Test AnnotationValue equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$AnnotationValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$AnnotationValue.hashCode()"
  })
  void testAnnotationValueEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AnnotationValue(new KotlinAnnotation("Class Name")), null);
  }

  /**
   * Test AnnotationValue {@link AnnotationValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationValue#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test AnnotationValue equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$AnnotationValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$AnnotationValue.hashCode()"
  })
  void testAnnotationValueEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new AnnotationValue(new KotlinAnnotation("Class Name")),
        "Different type to AnnotationValue");
  }

  /**
   * Test AnnotationValue getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AnnotationValue#AnnotationValue(KotlinAnnotation)}
   *   <li>{@link AnnotationValue#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test AnnotationValue getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$AnnotationValue.<init>(proguard.classfile.kotlin.KotlinAnnotation)",
    "java.lang.String proguard.classfile.kotlin.KotlinAnnotationArgument$AnnotationValue.toString()"
  })
  void testAnnotationValueGettersAndSetters() {
    // Arrange and Act
    AnnotationValue actualAnnotationValue = new AnnotationValue(new KotlinAnnotation("Class Name"));

    // Assert
    assertEquals("Class Name()", actualAnnotationValue.toString());
    KotlinAnnotation kotlinAnnotation = actualAnnotationValue.kotlinMetadataAnnotation;
    assertNull(kotlinAnnotation.getProcessingInfo());
    assertEquals(0, kotlinAnnotation.getProcessingFlags());
    assertTrue(kotlinAnnotation.arguments.isEmpty());
  }

  /**
   * Test ArrayValue {@link ArrayValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   *
   * <p>Method under test: {@link ArrayValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}
   */
  @Test
  @DisplayName(
      "Test ArrayValue accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$ArrayValue.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor)"
  })
  void testArrayValueAccept() {
    // Arrange
    ArrayValue arrayValue = new ArrayValue(new ArrayList<>());
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation kotlinMetadataAnnotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    KotlinAnnotationArgumentVisitor visitor = mock(KotlinAnnotationArgumentVisitor.class);
    doNothing()
        .when(visitor)
        .visitArrayArgument(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any(),
            Mockito.<KotlinAnnotationArgument>any(),
            Mockito.<ArrayValue>any());

    // Act
    arrayValue.accept(clazz, annotatable, kotlinMetadataAnnotation, argument, visitor);

    // Assert
    verify(visitor)
        .visitArrayArgument(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotation.class),
            isA(KotlinAnnotationArgument.class),
            isA(ArrayValue.class));
  }

  /**
   * Test ArrayValue {@link ArrayValue#elementsAccept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   *
   * <ul>
   *   <li>Given {@link Value} {@link Value#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   *       KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)} does nothing.
   *   <li>Then calls {@link Value#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   *       KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayValue#elementsAccept(Clazz, KotlinAnnotatable,
   * KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}
   */
  @Test
  @DisplayName(
      "Test ArrayValue elementsAccept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor); given Value accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor) does nothing; then calls accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$ArrayValue.elementsAccept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor)"
  })
  void testArrayValueElementsAccept_givenValueAcceptDoesNothing_thenCallsAccept() {
    // Arrange
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
    ArrayValue arrayValue = new ArrayValue(elements);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation kotlinAnnotation = new KotlinAnnotation("Class Name");

    // Act
    arrayValue.elementsAccept(
        clazz,
        annotatable,
        kotlinAnnotation,
        new KotlinAnnotationArgument("Name", mock(Value.class)),
        mock(KotlinAnnotationArgumentVisitor.class));

    // Assert
    verify(value)
        .accept(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotation.class),
            isA(KotlinAnnotationArgument.class),
            isA(KotlinAnnotationArgumentVisitor.class));
  }

  /**
   * Test ArrayValue {@link ArrayValue#elementsAccept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   *
   * <ul>
   *   <li>Given {@link Value} {@link Value#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   *       KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)} does nothing.
   *   <li>Then calls {@link Value#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   *       KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayValue#elementsAccept(Clazz, KotlinAnnotatable,
   * KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}
   */
  @Test
  @DisplayName(
      "Test ArrayValue elementsAccept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor); given Value accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor) does nothing; then calls accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$ArrayValue.elementsAccept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor)"
  })
  void testArrayValueElementsAccept_givenValueAcceptDoesNothing_thenCallsAccept2() {
    // Arrange
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
    ArrayValue arrayValue = new ArrayValue(elements);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation kotlinAnnotation = new KotlinAnnotation("Class Name");

    // Act
    arrayValue.elementsAccept(
        clazz,
        annotatable,
        kotlinAnnotation,
        new KotlinAnnotationArgument("Name", mock(Value.class)),
        mock(KotlinAnnotationArgumentVisitor.class));

    // Assert
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
   * Test ArrayValue {@link ArrayValue#equals(Object)}, and {@link ArrayValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ArrayValue#equals(Object)}
   *   <li>{@link ArrayValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ArrayValue equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$ArrayValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$ArrayValue.hashCode()"
  })
  void testArrayValueEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ArrayValue arrayValue = new ArrayValue(new ArrayList<>());
    ArrayValue arrayValue2 = new ArrayValue(new ArrayList<>());

    // Act and Assert
    assertEquals(arrayValue, arrayValue2);
    int expectedHashCodeResult = arrayValue.hashCode();
    assertEquals(expectedHashCodeResult, arrayValue2.hashCode());
  }

  /**
   * Test ArrayValue {@link ArrayValue#equals(Object)}, and {@link ArrayValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ArrayValue#equals(Object)}
   *   <li>{@link ArrayValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ArrayValue equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$ArrayValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$ArrayValue.hashCode()"
  })
  void testArrayValueEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ArrayValue arrayValue = new ArrayValue(new ArrayList<>());

    // Act and Assert
    assertEquals(arrayValue, arrayValue);
    int expectedHashCodeResult = arrayValue.hashCode();
    assertEquals(expectedHashCodeResult, arrayValue.hashCode());
  }

  /**
   * Test ArrayValue {@link ArrayValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ArrayValue#equals(Object)}
   */
  @Test
  @DisplayName("Test ArrayValue equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$ArrayValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$ArrayValue.hashCode()"
  })
  void testArrayValueEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<Value> elements = new ArrayList<>();
    elements.add(mock(Value.class));
    ArrayValue arrayValue = new ArrayValue(elements);

    // Act and Assert
    assertNotEquals(arrayValue, new ArrayValue(new ArrayList<>()));
  }

  /**
   * Test ArrayValue {@link ArrayValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ArrayValue#equals(Object)}
   */
  @Test
  @DisplayName("Test ArrayValue equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$ArrayValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$ArrayValue.hashCode()"
  })
  void testArrayValueEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<Value> elements = new ArrayList<>();
    elements.add(new ArrayValue(new ArrayList<>()));
    ArrayValue arrayValue = new ArrayValue(elements);

    ArrayList<Value> elements2 = new ArrayList<>();
    elements2.add(mock(Value.class));

    // Act and Assert
    assertNotEquals(arrayValue, new ArrayValue(elements2));
  }

  /**
   * Test ArrayValue {@link ArrayValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ArrayValue#equals(Object)}
   */
  @Test
  @DisplayName("Test ArrayValue equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$ArrayValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$ArrayValue.hashCode()"
  })
  void testArrayValueEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ArrayValue(new ArrayList<>()), null);
  }

  /**
   * Test ArrayValue {@link ArrayValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ArrayValue#equals(Object)}
   */
  @Test
  @DisplayName("Test ArrayValue equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$ArrayValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$ArrayValue.hashCode()"
  })
  void testArrayValueEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ArrayValue(new ArrayList<>()), "Different type to ArrayValue");
  }

  /**
   * Test ArrayValue getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ArrayValue#ArrayValue(List)}
   *   <li>{@link ArrayValue#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test ArrayValue getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$ArrayValue.<init>(java.util.List)",
    "java.lang.String proguard.classfile.kotlin.KotlinAnnotationArgument$ArrayValue.toString()"
  })
  void testArrayValueGettersAndSetters() {
    // Arrange and Act
    ArrayValue actualArrayValue = new ArrayValue(new ArrayList<>());

    // Assert
    assertEquals("[]", actualArrayValue.toString());
    assertTrue(actualArrayValue.elements.isEmpty());
  }

  /**
   * Test BooleanValue {@link BooleanValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   *
   * <p>Method under test: {@link BooleanValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}
   */
  @Test
  @DisplayName(
      "Test BooleanValue accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$BooleanValue.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor)"
  })
  void testBooleanValueAccept() {
    // Arrange
    BooleanValue booleanValue = new BooleanValue(true);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation kotlinMetadataAnnotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    KotlinAnnotationArgumentVisitor visitor = mock(KotlinAnnotationArgumentVisitor.class);
    doNothing()
        .when(visitor)
        .visitBooleanArgument(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any(),
            Mockito.<KotlinAnnotationArgument>any(),
            Mockito.<BooleanValue>any());

    // Act
    booleanValue.accept(clazz, annotatable, kotlinMetadataAnnotation, argument, visitor);

    // Assert
    verify(visitor)
        .visitBooleanArgument(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotation.class),
            isA(KotlinAnnotationArgument.class),
            isA(BooleanValue.class));
  }

  /**
   * Test BooleanValue {@link BooleanValue#BooleanValue(boolean)}.
   *
   * <p>Method under test: {@link BooleanValue#BooleanValue(boolean)}
   */
  @Test
  @DisplayName("Test BooleanValue new BooleanValue(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$BooleanValue.<init>(boolean)"
  })
  void testBooleanValueNewBooleanValue() {
    // Arrange, Act and Assert
    assertTrue((new BooleanValue(true)).value);
  }

  /**
   * Test ByteValue {@link ByteValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   *
   * <p>Method under test: {@link ByteValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}
   */
  @Test
  @DisplayName(
      "Test ByteValue accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$ByteValue.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor)"
  })
  void testByteValueAccept() {
    // Arrange
    ByteValue byteValue = new ByteValue((byte) 'A');
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation kotlinMetadataAnnotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    KotlinAnnotationArgumentVisitor visitor = mock(KotlinAnnotationArgumentVisitor.class);
    doNothing()
        .when(visitor)
        .visitByteArgument(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any(),
            Mockito.<KotlinAnnotationArgument>any(),
            Mockito.<ByteValue>any());

    // Act
    byteValue.accept(clazz, annotatable, kotlinMetadataAnnotation, argument, visitor);

    // Assert
    verify(visitor)
        .visitByteArgument(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotation.class),
            isA(KotlinAnnotationArgument.class),
            isA(ByteValue.class));
  }

  /**
   * Test ByteValue {@link ByteValue#ByteValue(byte)}.
   *
   * <p>Method under test: {@link ByteValue#ByteValue(byte)}
   */
  @Test
  @DisplayName("Test ByteValue new ByteValue(byte)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$ByteValue.<init>(byte)"
  })
  void testByteValueNewByteValue() {
    // Arrange, Act and Assert
    assertEquals('A', (new ByteValue((byte) 'A')).value.byteValue());
  }

  /**
   * Test CharValue {@link CharValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   *
   * <p>Method under test: {@link CharValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}
   */
  @Test
  @DisplayName(
      "Test CharValue accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$CharValue.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor)"
  })
  void testCharValueAccept() {
    // Arrange
    CharValue charValue = new CharValue('A');
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation kotlinMetadataAnnotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    KotlinAnnotationArgumentVisitor visitor = mock(KotlinAnnotationArgumentVisitor.class);
    doNothing()
        .when(visitor)
        .visitCharArgument(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any(),
            Mockito.<KotlinAnnotationArgument>any(),
            Mockito.<CharValue>any());

    // Act
    charValue.accept(clazz, annotatable, kotlinMetadataAnnotation, argument, visitor);

    // Assert
    verify(visitor)
        .visitCharArgument(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotation.class),
            isA(KotlinAnnotationArgument.class),
            isA(CharValue.class));
  }

  /**
   * Test CharValue {@link CharValue#CharValue(char)}.
   *
   * <p>Method under test: {@link CharValue#CharValue(char)}
   */
  @Test
  @DisplayName("Test CharValue new CharValue(char)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$CharValue.<init>(char)"
  })
  void testCharValueNewCharValue() {
    // Arrange, Act and Assert
    assertEquals('A', (new CharValue('A')).value.charValue());
  }

  /**
   * Test ClassValue {@link ClassValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   *
   * <p>Method under test: {@link ClassValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}
   */
  @Test
  @DisplayName(
      "Test ClassValue accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor)"
  })
  void testClassValueAccept() {
    // Arrange
    ClassValue classValue = new ClassValue("Class Name");
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation kotlinMetadataAnnotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    KotlinAnnotationArgumentVisitor visitor = mock(KotlinAnnotationArgumentVisitor.class);
    doNothing()
        .when(visitor)
        .visitClassArgument(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any(),
            Mockito.<KotlinAnnotationArgument>any(),
            Mockito.<ClassValue>any());

    // Act
    classValue.accept(clazz, annotatable, kotlinMetadataAnnotation, argument, visitor);

    // Assert
    verify(visitor)
        .visitClassArgument(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotation.class),
            isA(KotlinAnnotationArgument.class),
            isA(ClassValue.class));
  }

  /**
   * Test ClassValue {@link ClassValue#equals(Object)}, and {@link ClassValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClassValue#equals(Object)}
   *   <li>{@link ClassValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ClassValue equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue.hashCode()"
  })
  void testClassValueEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ClassValue classValue = new ClassValue("Class Name");
    ClassValue classValue2 = new ClassValue("Class Name");

    // Act and Assert
    assertEquals(classValue, classValue2);
    int expectedHashCodeResult = classValue.hashCode();
    assertEquals(expectedHashCodeResult, classValue2.hashCode());
  }

  /**
   * Test ClassValue {@link ClassValue#equals(Object)}, and {@link ClassValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClassValue#equals(Object)}
   *   <li>{@link ClassValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ClassValue equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue.hashCode()"
  })
  void testClassValueEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ClassValue classValue = new ClassValue("Class Name");

    // Act and Assert
    assertEquals(classValue, classValue);
    int expectedHashCodeResult = classValue.hashCode();
    assertEquals(expectedHashCodeResult, classValue.hashCode());
  }

  /**
   * Test ClassValue {@link ClassValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClassValue#equals(Object)}
   */
  @Test
  @DisplayName("Test ClassValue equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue.hashCode()"
  })
  void testClassValueEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ClassValue classValue =
        new ClassValue("proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue");

    // Act and Assert
    assertNotEquals(classValue, new ClassValue("Class Name"));
  }

  /**
   * Test ClassValue {@link ClassValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClassValue#equals(Object)}
   */
  @Test
  @DisplayName("Test ClassValue equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue.hashCode()"
  })
  void testClassValueEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ClassValue classValue = new ClassValue("Class Name", 3);

    // Act and Assert
    assertNotEquals(classValue, new ClassValue("Class Name"));
  }

  /**
   * Test ClassValue {@link ClassValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClassValue#equals(Object)}
   */
  @Test
  @DisplayName("Test ClassValue equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue.hashCode()"
  })
  void testClassValueEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ClassValue("Class Name"), null);
  }

  /**
   * Test ClassValue {@link ClassValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClassValue#equals(Object)}
   */
  @Test
  @DisplayName("Test ClassValue equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue.hashCode()"
  })
  void testClassValueEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ClassValue("Class Name"), "Different type to ClassValue");
  }

  /**
   * Test ClassValue getters and setters.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   *   <li>Then return toString is {@code Class Name}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClassValue#ClassValue(String)}
   *   <li>{@link ClassValue#toString()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ClassValue getters and setters; when 'Class Name'; then return toString is 'Class Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue.<init>(java.lang.String)",
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue.<init>(java.lang.String, int)",
    "java.lang.String proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue.toString()"
  })
  void testClassValueGettersAndSetters_whenClassName_thenReturnToStringIsClassName() {
    // Arrange, Act and Assert
    assertEquals("Class Name", (new ClassValue("Class Name")).toString());
  }

  /**
   * Test ClassValue getters and setters.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return toString is {@code [[[Class Name}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClassValue#ClassValue(String, int)}
   *   <li>{@link ClassValue#toString()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ClassValue getters and setters; when three; then return toString is '[[[Class Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue.<init>(java.lang.String)",
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue.<init>(java.lang.String, int)",
    "java.lang.String proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue.toString()"
  })
  void testClassValueGettersAndSetters_whenThree_thenReturnToStringIsClassName() {
    // Arrange, Act and Assert
    assertEquals("[[[Class Name", (new ClassValue("Class Name", 3)).toString());
  }

  /**
   * Test ClassValue {@link ClassValue#referencedClassAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassValue#referencedClassAccept(ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test ClassValue referencedClassAccept(ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue.referencedClassAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testClassValueReferencedClassAccept_thenCallsVisitLibraryClass() {
    // Arrange
    ClassValue classValue = new ClassValue("Class Name");
    classValue.referencedClass = new LibraryClass();
    ClassVisitor visitor = mock(ClassVisitor.class);
    doNothing().when(visitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    classValue.referencedClassAccept(visitor);

    // Assert
    verify(visitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test DoubleValue {@link DoubleValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   *
   * <p>Method under test: {@link DoubleValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}
   */
  @Test
  @DisplayName(
      "Test DoubleValue accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$DoubleValue.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor)"
  })
  void testDoubleValueAccept() {
    // Arrange
    DoubleValue doubleValue = new DoubleValue(10.0d);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation kotlinMetadataAnnotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    KotlinAnnotationArgumentVisitor visitor = mock(KotlinAnnotationArgumentVisitor.class);
    doNothing()
        .when(visitor)
        .visitDoubleArgument(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any(),
            Mockito.<KotlinAnnotationArgument>any(),
            Mockito.<DoubleValue>any());

    // Act
    doubleValue.accept(clazz, annotatable, kotlinMetadataAnnotation, argument, visitor);

    // Assert
    verify(visitor)
        .visitDoubleArgument(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotation.class),
            isA(KotlinAnnotationArgument.class),
            isA(DoubleValue.class));
  }

  /**
   * Test DoubleValue {@link DoubleValue#DoubleValue(double)}.
   *
   * <p>Method under test: {@link DoubleValue#DoubleValue(double)}
   */
  @Test
  @DisplayName("Test DoubleValue new DoubleValue(double)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$DoubleValue.<init>(double)"
  })
  void testDoubleValueNewDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(10.0d, (new DoubleValue(10.0d)).value.doubleValue());
  }

  /**
   * Test EnumValue {@link EnumValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   *
   * <p>Method under test: {@link EnumValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}
   */
  @Test
  @DisplayName(
      "Test EnumValue accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$EnumValue.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor)"
  })
  void testEnumValueAccept() {
    // Arrange
    EnumValue enumValue = new EnumValue("Class Name", "Enum Entry Name");
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation kotlinMetadataAnnotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    KotlinAnnotationArgumentVisitor visitor = mock(KotlinAnnotationArgumentVisitor.class);
    doNothing()
        .when(visitor)
        .visitEnumArgument(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any(),
            Mockito.<KotlinAnnotationArgument>any(),
            Mockito.<EnumValue>any());

    // Act
    enumValue.accept(clazz, annotatable, kotlinMetadataAnnotation, argument, visitor);

    // Assert
    verify(visitor)
        .visitEnumArgument(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotation.class),
            isA(KotlinAnnotationArgument.class),
            isA(EnumValue.class));
  }

  /**
   * Test EnumValue {@link EnumValue#equals(Object)}, and {@link EnumValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EnumValue#equals(Object)}
   *   <li>{@link EnumValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test EnumValue equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$EnumValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$EnumValue.hashCode()"
  })
  void testEnumValueEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EnumValue enumValue = new EnumValue("Class Name", "Enum Entry Name");
    EnumValue enumValue2 = new EnumValue("Class Name", "Enum Entry Name");

    // Act and Assert
    assertEquals(enumValue, enumValue2);
    int expectedHashCodeResult = enumValue.hashCode();
    assertEquals(expectedHashCodeResult, enumValue2.hashCode());
  }

  /**
   * Test EnumValue {@link EnumValue#equals(Object)}, and {@link EnumValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EnumValue#equals(Object)}
   *   <li>{@link EnumValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test EnumValue equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$EnumValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$EnumValue.hashCode()"
  })
  void testEnumValueEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EnumValue enumValue = new EnumValue("Class Name", "Enum Entry Name");

    // Act and Assert
    assertEquals(enumValue, enumValue);
    int expectedHashCodeResult = enumValue.hashCode();
    assertEquals(expectedHashCodeResult, enumValue.hashCode());
  }

  /**
   * Test EnumValue {@link EnumValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EnumValue#equals(Object)}
   */
  @Test
  @DisplayName("Test EnumValue equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$EnumValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$EnumValue.hashCode()"
  })
  void testEnumValueEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EnumValue enumValue = new EnumValue("Enum Entry Name", "Enum Entry Name");

    // Act and Assert
    assertNotEquals(enumValue, new EnumValue("Class Name", "Enum Entry Name"));
  }

  /**
   * Test EnumValue {@link EnumValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EnumValue#equals(Object)}
   */
  @Test
  @DisplayName("Test EnumValue equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$EnumValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$EnumValue.hashCode()"
  })
  void testEnumValueEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EnumValue enumValue = new EnumValue("Class Name", "Class Name");

    // Act and Assert
    assertNotEquals(enumValue, new EnumValue("Class Name", "Enum Entry Name"));
  }

  /**
   * Test EnumValue {@link EnumValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EnumValue#equals(Object)}
   */
  @Test
  @DisplayName("Test EnumValue equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$EnumValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$EnumValue.hashCode()"
  })
  void testEnumValueEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EnumValue("Class Name", "Enum Entry Name"), null);
  }

  /**
   * Test EnumValue {@link EnumValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EnumValue#equals(Object)}
   */
  @Test
  @DisplayName("Test EnumValue equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$EnumValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$EnumValue.hashCode()"
  })
  void testEnumValueEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EnumValue("Class Name", "Enum Entry Name"), "Different type to EnumValue");
  }

  /**
   * Test EnumValue getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EnumValue#EnumValue(String, String)}
   *   <li>{@link EnumValue#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test EnumValue getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$EnumValue.<init>(java.lang.String, java.lang.String)",
    "java.lang.String proguard.classfile.kotlin.KotlinAnnotationArgument$EnumValue.toString()"
  })
  void testEnumValueGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "Class Name.Enum Entry Name", (new EnumValue("Class Name", "Enum Entry Name")).toString());
  }

  /**
   * Test EnumValue {@link EnumValue#referencedClassAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link EnumValue#referencedClassAccept(ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test EnumValue referencedClassAccept(ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$EnumValue.referencedClassAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testEnumValueReferencedClassAccept_thenCallsVisitLibraryClass() {
    // Arrange
    EnumValue enumValue = new EnumValue("Class Name", "Enum Entry Name");
    enumValue.referencedClass = new LibraryClass();
    ClassVisitor visitor = mock(ClassVisitor.class);
    doNothing().when(visitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    enumValue.referencedClassAccept(visitor);

    // Assert
    verify(visitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test FloatValue {@link FloatValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   *
   * <p>Method under test: {@link FloatValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}
   */
  @Test
  @DisplayName(
      "Test FloatValue accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$FloatValue.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor)"
  })
  void testFloatValueAccept() {
    // Arrange
    FloatValue floatValue = new FloatValue(10.0f);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation kotlinMetadataAnnotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    KotlinAnnotationArgumentVisitor visitor = mock(KotlinAnnotationArgumentVisitor.class);
    doNothing()
        .when(visitor)
        .visitFloatArgument(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any(),
            Mockito.<KotlinAnnotationArgument>any(),
            Mockito.<FloatValue>any());

    // Act
    floatValue.accept(clazz, annotatable, kotlinMetadataAnnotation, argument, visitor);

    // Assert
    verify(visitor)
        .visitFloatArgument(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotation.class),
            isA(KotlinAnnotationArgument.class),
            isA(FloatValue.class));
  }

  /**
   * Test FloatValue {@link FloatValue#FloatValue(float)}.
   *
   * <p>Method under test: {@link FloatValue#FloatValue(float)}
   */
  @Test
  @DisplayName("Test FloatValue new FloatValue(float)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$FloatValue.<init>(float)"
  })
  void testFloatValueNewFloatValue() {
    // Arrange, Act and Assert
    assertEquals(10.0f, (new FloatValue(10.0f)).value.floatValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KotlinAnnotationArgument#KotlinAnnotationArgument(String, Value)}
   *   <li>{@link KotlinAnnotationArgument#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument.<init>(java.lang.String, proguard.classfile.kotlin.KotlinAnnotationArgument$Value)",
    "java.lang.String proguard.classfile.kotlin.KotlinAnnotationArgument.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    KotlinAnnotationArgument actualKotlinAnnotationArgument =
        new KotlinAnnotationArgument("Name", mock(Value.class));
    actualKotlinAnnotationArgument.toString();

    // Assert
    assertNull(actualKotlinAnnotationArgument.getProcessingInfo());
    assertEquals(0, actualKotlinAnnotationArgument.getProcessingFlags());
  }

  /**
   * Test {@link KotlinAnnotationArgument#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgumentVisitor)}.
   *
   * <p>Method under test: {@link KotlinAnnotationArgument#accept(Clazz, KotlinAnnotatable,
   * KotlinAnnotation, KotlinAnnotationArgumentVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor)"
  })
  void testAccept() {
    // Arrange
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
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);

    // Act
    kotlinAnnotationArgument.accept(
        clazz,
        annotatable,
        new KotlinAnnotation("Class Name"),
        mock(KotlinAnnotationArgumentVisitor.class));

    // Assert
    verify(value)
        .accept(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotation.class),
            isA(KotlinAnnotationArgument.class),
            isA(KotlinAnnotationArgumentVisitor.class));
  }

  /**
   * Test IntValue {@link IntValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   *
   * <p>Method under test: {@link IntValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}
   */
  @Test
  @DisplayName(
      "Test IntValue accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$IntValue.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor)"
  })
  void testIntValueAccept() {
    // Arrange
    IntValue intValue = new IntValue(42);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation kotlinMetadataAnnotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    KotlinAnnotationArgumentVisitor visitor = mock(KotlinAnnotationArgumentVisitor.class);
    doNothing()
        .when(visitor)
        .visitIntArgument(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any(),
            Mockito.<KotlinAnnotationArgument>any(),
            Mockito.<IntValue>any());

    // Act
    intValue.accept(clazz, annotatable, kotlinMetadataAnnotation, argument, visitor);

    // Assert
    verify(visitor)
        .visitIntArgument(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotation.class),
            isA(KotlinAnnotationArgument.class),
            isA(IntValue.class));
  }

  /**
   * Test IntValue {@link IntValue#IntValue(int)}.
   *
   * <p>Method under test: {@link IntValue#IntValue(int)}
   */
  @Test
  @DisplayName("Test IntValue new IntValue(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$IntValue.<init>(int)"
  })
  void testIntValueNewIntValue() {
    // Arrange, Act and Assert
    assertEquals(42, (new IntValue(42)).value.intValue());
  }

  /**
   * Test LiteralValue {@link LiteralValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   *
   * <p>Method under test: {@link LiteralValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}
   */
  @Test
  @DisplayName(
      "Test LiteralValue accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$LiteralValue.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor)"
  })
  void testLiteralValueAccept() {
    // Arrange
    LiteralValue<Object> literalValue = new LiteralValue<>("Value");
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    KotlinAnnotationArgumentVisitor visitor = mock(KotlinAnnotationArgumentVisitor.class);
    doNothing()
        .when(visitor)
        .visitAnyLiteralArgument(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any(),
            Mockito.<KotlinAnnotationArgument>any(),
            Mockito.<LiteralValue<Object>>any());

    // Act
    literalValue.accept(clazz, annotatable, annotation, argument, visitor);

    // Assert
    verify(visitor)
        .visitAnyLiteralArgument(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotation.class),
            isA(KotlinAnnotationArgument.class),
            isA(LiteralValue.class));
  }

  /**
   * Test LiteralValue {@link LiteralValue#equals(Object)}, and {@link LiteralValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LiteralValue#equals(Object)}
   *   <li>{@link LiteralValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test LiteralValue equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$LiteralValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$LiteralValue.hashCode()"
  })
  void testLiteralValueEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LiteralValue<Object> literalValue = new LiteralValue<>("Value");
    LiteralValue<Object> literalValue2 = new LiteralValue<>("Value");

    // Act and Assert
    assertEquals(literalValue, literalValue2);
    int expectedHashCodeResult = literalValue.hashCode();
    assertEquals(expectedHashCodeResult, literalValue2.hashCode());
  }

  /**
   * Test LiteralValue {@link LiteralValue#equals(Object)}, and {@link LiteralValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LiteralValue#equals(Object)}
   *   <li>{@link LiteralValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test LiteralValue equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$LiteralValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$LiteralValue.hashCode()"
  })
  void testLiteralValueEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LiteralValue<Object> literalValue = new LiteralValue<>("Value");

    // Act and Assert
    assertEquals(literalValue, literalValue);
    int expectedHashCodeResult = literalValue.hashCode();
    assertEquals(expectedHashCodeResult, literalValue.hashCode());
  }

  /**
   * Test LiteralValue {@link LiteralValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LiteralValue#equals(Object)}
   */
  @Test
  @DisplayName("Test LiteralValue equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$LiteralValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$LiteralValue.hashCode()"
  })
  void testLiteralValueEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LiteralValue<Object> literalValue = new LiteralValue<>(42);

    // Act and Assert
    assertNotEquals(literalValue, new LiteralValue<>("Value"));
  }

  /**
   * Test LiteralValue {@link LiteralValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LiteralValue#equals(Object)}
   */
  @Test
  @DisplayName("Test LiteralValue equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$LiteralValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$LiteralValue.hashCode()"
  })
  void testLiteralValueEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LiteralValue<Object> literalValue = new LiteralValue<>(new BooleanValue(true));

    // Act and Assert
    assertNotEquals(literalValue, new LiteralValue<>("Value"));
  }

  /**
   * Test LiteralValue {@link LiteralValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LiteralValue#equals(Object)}
   */
  @Test
  @DisplayName("Test LiteralValue equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$LiteralValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$LiteralValue.hashCode()"
  })
  void testLiteralValueEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LiteralValue<Object> literalValue = new LiteralValue<>("Value");

    // Act and Assert
    assertNotEquals(literalValue, null);
  }

  /**
   * Test LiteralValue {@link LiteralValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LiteralValue#equals(Object)}
   */
  @Test
  @DisplayName("Test LiteralValue equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument$LiteralValue.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument$LiteralValue.hashCode()"
  })
  void testLiteralValueEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LiteralValue<Object> literalValue = new LiteralValue<>("Value");

    // Act and Assert
    assertNotEquals(literalValue, "Different type to LiteralValue");
  }

  /**
   * Test LiteralValue getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LiteralValue#LiteralValue(Object)}
   *   <li>{@link LiteralValue#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test LiteralValue getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$LiteralValue.<init>(java.lang.Object)",
    "java.lang.String proguard.classfile.kotlin.KotlinAnnotationArgument$LiteralValue.toString()"
  })
  void testLiteralValueGettersAndSetters() {
    // Arrange and Act
    LiteralValue<Object> actualLiteralValue = new LiteralValue<>("Value");

    // Assert
    assertSame(actualLiteralValue.value, actualLiteralValue.toString());
  }

  /**
   * Test LongValue {@link LongValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   *
   * <p>Method under test: {@link LongValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}
   */
  @Test
  @DisplayName(
      "Test LongValue accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$LongValue.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor)"
  })
  void testLongValueAccept() {
    // Arrange
    LongValue longValue = new LongValue(42L);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation kotlinMetadataAnnotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    KotlinAnnotationArgumentVisitor visitor = mock(KotlinAnnotationArgumentVisitor.class);
    doNothing()
        .when(visitor)
        .visitLongArgument(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any(),
            Mockito.<KotlinAnnotationArgument>any(),
            Mockito.<LongValue>any());

    // Act
    longValue.accept(clazz, annotatable, kotlinMetadataAnnotation, argument, visitor);

    // Assert
    verify(visitor)
        .visitLongArgument(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotation.class),
            isA(KotlinAnnotationArgument.class),
            isA(LongValue.class));
  }

  /**
   * Test LongValue {@link LongValue#LongValue(long)}.
   *
   * <p>Method under test: {@link LongValue#LongValue(long)}
   */
  @Test
  @DisplayName("Test LongValue new LongValue(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$LongValue.<init>(long)"
  })
  void testLongValueNewLongValue() {
    // Arrange, Act and Assert
    assertEquals(42L, (new LongValue(42L)).value.longValue());
  }

  /**
   * Test {@link KotlinAnnotationArgument#referencedMethodAccept(MemberVisitor)}.
   *
   * <ul>
   *   <li>Given {@link LibraryMethod} {@link LibraryMember#accept(Clazz, MemberVisitor)} does
   *       nothing.
   *   <li>Then calls {@link LibraryMember#accept(Clazz, MemberVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationArgument#referencedMethodAccept(MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedMethodAccept(MemberVisitor); given LibraryMethod accept(Clazz, MemberVisitor) does nothing; then calls accept(Clazz, MemberVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument.referencedMethodAccept(proguard.classfile.visitor.MemberVisitor)"
  })
  void testReferencedMethodAccept_givenLibraryMethodAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    LibraryMethod libraryMethod = mock(LibraryMethod.class);
    doNothing().when(libraryMethod).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    KotlinAnnotationArgument kotlinAnnotationArgument =
        new KotlinAnnotationArgument("Name", mock(Value.class));
    kotlinAnnotationArgument.referencedAnnotationMethod = libraryMethod;

    // Act
    kotlinAnnotationArgument.referencedMethodAccept(new AttributeSorter());

    // Assert
    verify(libraryMethod).accept((Clazz) isNull(), isA(MemberVisitor.class));
  }

  /**
   * Test {@link KotlinAnnotationArgument#equals(Object)}, and {@link
   * KotlinAnnotationArgument#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KotlinAnnotationArgument#equals(Object)}
   *   <li>{@link KotlinAnnotationArgument#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    KotlinAnnotationArgument kotlinAnnotationArgument =
        new KotlinAnnotationArgument("Name", mock(Value.class));

    // Act and Assert
    assertEquals(kotlinAnnotationArgument, kotlinAnnotationArgument);
    int expectedHashCodeResult = kotlinAnnotationArgument.hashCode();
    assertEquals(expectedHashCodeResult, kotlinAnnotationArgument.hashCode());
  }

  /**
   * Test {@link KotlinAnnotationArgument#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationArgument#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    KotlinAnnotationArgument kotlinAnnotationArgument =
        new KotlinAnnotationArgument("Name", mock(Value.class));

    // Act and Assert
    assertNotEquals(
        kotlinAnnotationArgument, new KotlinAnnotationArgument("Name", mock(Value.class)));
  }

  /**
   * Test {@link KotlinAnnotationArgument#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationArgument#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    KotlinAnnotationArgument kotlinAnnotationArgument =
        new KotlinAnnotationArgument(
            "proguard.classfile.kotlin.KotlinAnnotationArgument", mock(Value.class));

    // Act and Assert
    assertNotEquals(
        kotlinAnnotationArgument, new KotlinAnnotationArgument("Name", mock(Value.class)));
  }

  /**
   * Test {@link KotlinAnnotationArgument#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationArgument#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KotlinAnnotationArgument("Name", mock(Value.class)), null);
  }

  /**
   * Test {@link KotlinAnnotationArgument#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationArgument#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotationArgument.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotationArgument.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new KotlinAnnotationArgument("Name", mock(Value.class)),
        "Different type to KotlinAnnotationArgument");
  }

  /**
   * Test ShortValue {@link ShortValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   *
   * <p>Method under test: {@link ShortValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}
   */
  @Test
  @DisplayName(
      "Test ShortValue accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$ShortValue.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor)"
  })
  void testShortValueAccept() {
    // Arrange
    ShortValue shortValue = new ShortValue((short) 1);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation kotlinMetadataAnnotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    KotlinAnnotationArgumentVisitor visitor = mock(KotlinAnnotationArgumentVisitor.class);
    doNothing()
        .when(visitor)
        .visitShortArgument(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any(),
            Mockito.<KotlinAnnotationArgument>any(),
            Mockito.<ShortValue>any());

    // Act
    shortValue.accept(clazz, annotatable, kotlinMetadataAnnotation, argument, visitor);

    // Assert
    verify(visitor)
        .visitShortArgument(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotation.class),
            isA(KotlinAnnotationArgument.class),
            isA(ShortValue.class));
  }

  /**
   * Test ShortValue {@link ShortValue#ShortValue(short)}.
   *
   * <p>Method under test: {@link ShortValue#ShortValue(short)}
   */
  @Test
  @DisplayName("Test ShortValue new ShortValue(short)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$ShortValue.<init>(short)"
  })
  void testShortValueNewShortValue() {
    // Arrange, Act and Assert
    assertEquals((short) 1, (new ShortValue((short) 1)).value.shortValue());
  }

  /**
   * Test StringValue {@link StringValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   *
   * <p>Method under test: {@link StringValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}
   */
  @Test
  @DisplayName(
      "Test StringValue accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$StringValue.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor)"
  })
  void testStringValueAccept() {
    // Arrange
    StringValue stringValue = new StringValue("42");
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation kotlinMetadataAnnotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    KotlinAnnotationArgumentVisitor visitor = mock(KotlinAnnotationArgumentVisitor.class);
    doNothing()
        .when(visitor)
        .visitStringArgument(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any(),
            Mockito.<KotlinAnnotationArgument>any(),
            Mockito.<StringValue>any());

    // Act
    stringValue.accept(clazz, annotatable, kotlinMetadataAnnotation, argument, visitor);

    // Assert
    verify(visitor)
        .visitStringArgument(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotation.class),
            isA(KotlinAnnotationArgument.class),
            isA(StringValue.class));
  }

  /**
   * Test StringValue {@link StringValue#StringValue(String)}.
   *
   * <p>Method under test: {@link StringValue#StringValue(String)}
   */
  @Test
  @DisplayName("Test StringValue new StringValue(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$StringValue.<init>(java.lang.String)"
  })
  void testStringValueNewStringValue() {
    // Arrange, Act and Assert
    assertEquals("42", (new StringValue("42")).value);
  }

  /**
   * Test UByteValue {@link UByteValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   *
   * <p>Method under test: {@link UByteValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}
   */
  @Test
  @DisplayName(
      "Test UByteValue accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$UByteValue.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor)"
  })
  void testUByteValueAccept() {
    // Arrange
    UByteValue uByteValue = new UByteValue((byte) 'A');
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    KotlinAnnotationArgumentVisitor visitor = mock(KotlinAnnotationArgumentVisitor.class);
    doNothing()
        .when(visitor)
        .visitUByteArgument(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any(),
            Mockito.<KotlinAnnotationArgument>any(),
            Mockito.<UByteValue>any());

    // Act
    uByteValue.accept(clazz, annotatable, annotation, argument, visitor);

    // Assert
    verify(visitor)
        .visitUByteArgument(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotation.class),
            isA(KotlinAnnotationArgument.class),
            isA(UByteValue.class));
  }

  /**
   * Test UByteValue {@link UByteValue#UByteValue(byte)}.
   *
   * <p>Method under test: {@link UByteValue#UByteValue(byte)}
   */
  @Test
  @DisplayName("Test UByteValue new UByteValue(byte)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$UByteValue.<init>(byte)"
  })
  void testUByteValueNewUByteValue() {
    // Arrange, Act and Assert
    assertEquals('A', (new UByteValue((byte) 'A')).value.byteValue());
  }

  /**
   * Test UIntValue {@link UIntValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   *
   * <p>Method under test: {@link UIntValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}
   */
  @Test
  @DisplayName(
      "Test UIntValue accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$UIntValue.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor)"
  })
  void testUIntValueAccept() {
    // Arrange
    UIntValue uIntValue = new UIntValue(42);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    KotlinAnnotationArgumentVisitor visitor = mock(KotlinAnnotationArgumentVisitor.class);
    doNothing()
        .when(visitor)
        .visitUIntArgument(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any(),
            Mockito.<KotlinAnnotationArgument>any(),
            Mockito.<UIntValue>any());

    // Act
    uIntValue.accept(clazz, annotatable, annotation, argument, visitor);

    // Assert
    verify(visitor)
        .visitUIntArgument(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotation.class),
            isA(KotlinAnnotationArgument.class),
            isA(UIntValue.class));
  }

  /**
   * Test UIntValue {@link UIntValue#UIntValue(int)}.
   *
   * <p>Method under test: {@link UIntValue#UIntValue(int)}
   */
  @Test
  @DisplayName("Test UIntValue new UIntValue(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$UIntValue.<init>(int)"
  })
  void testUIntValueNewUIntValue() {
    // Arrange, Act and Assert
    assertEquals(42, (new UIntValue(42)).value.intValue());
  }

  /**
   * Test ULongValue {@link ULongValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   *
   * <p>Method under test: {@link ULongValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}
   */
  @Test
  @DisplayName(
      "Test ULongValue accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$ULongValue.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor)"
  })
  void testULongValueAccept() {
    // Arrange
    ULongValue uLongValue = new ULongValue(42L);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    KotlinAnnotationArgumentVisitor visitor = mock(KotlinAnnotationArgumentVisitor.class);
    doNothing()
        .when(visitor)
        .visitULongArgument(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any(),
            Mockito.<KotlinAnnotationArgument>any(),
            Mockito.<ULongValue>any());

    // Act
    uLongValue.accept(clazz, annotatable, annotation, argument, visitor);

    // Assert
    verify(visitor)
        .visitULongArgument(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotation.class),
            isA(KotlinAnnotationArgument.class),
            isA(ULongValue.class));
  }

  /**
   * Test ULongValue {@link ULongValue#ULongValue(long)}.
   *
   * <p>Method under test: {@link ULongValue#ULongValue(long)}
   */
  @Test
  @DisplayName("Test ULongValue new ULongValue(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$ULongValue.<init>(long)"
  })
  void testULongValueNewULongValue() {
    // Arrange, Act and Assert
    assertEquals(42L, (new ULongValue(42L)).value.longValue());
  }

  /**
   * Test UShortValue {@link UShortValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   *
   * <p>Method under test: {@link UShortValue#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   * KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}
   */
  @Test
  @DisplayName(
      "Test UShortValue accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$UShortValue.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor)"
  })
  void testUShortValueAccept() {
    // Arrange
    UShortValue uShortValue = new UShortValue((short) 1);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    KotlinAnnotationArgumentVisitor visitor = mock(KotlinAnnotationArgumentVisitor.class);
    doNothing()
        .when(visitor)
        .visitUShortArgument(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any(),
            Mockito.<KotlinAnnotationArgument>any(),
            Mockito.<UShortValue>any());

    // Act
    uShortValue.accept(clazz, annotatable, annotation, argument, visitor);

    // Assert
    verify(visitor)
        .visitUShortArgument(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotation.class),
            isA(KotlinAnnotationArgument.class),
            isA(UShortValue.class));
  }

  /**
   * Test UShortValue {@link UShortValue#UShortValue(short)}.
   *
   * <p>Method under test: {@link UShortValue#UShortValue(short)}
   */
  @Test
  @DisplayName("Test UShortValue new UShortValue(short)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotationArgument$UShortValue.<init>(short)"
  })
  void testUShortValueNewUShortValue() {
    // Arrange, Act and Assert
    assertEquals((short) 1, (new UShortValue((short) 1)).value.shortValue());
  }
}
