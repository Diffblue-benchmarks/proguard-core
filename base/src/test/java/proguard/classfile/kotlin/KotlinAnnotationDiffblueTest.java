package proguard.classfile.kotlin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
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
import proguard.classfile.kotlin.KotlinAnnotationArgument.Value;
import proguard.classfile.kotlin.flags.KotlinTypeAliasFlags;
import proguard.classfile.kotlin.flags.KotlinTypeParameterFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;
import proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor;
import proguard.classfile.kotlin.visitor.KotlinAnnotationVisitor;
import proguard.classfile.visitor.ClassVisitor;

class KotlinAnnotationDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KotlinAnnotation#KotlinAnnotation(String, List)}
   *   <li>{@link KotlinAnnotation#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotation.<init>(java.lang.String)",
    "void proguard.classfile.kotlin.KotlinAnnotation.<init>(java.lang.String, java.util.List)",
    "java.lang.String proguard.classfile.kotlin.KotlinAnnotation.toString()"
  })
  void testGettersAndSetters_whenArrayList() {
    // Arrange and Act
    KotlinAnnotation actualKotlinAnnotation = new KotlinAnnotation("Class Name", new ArrayList<>());

    // Assert
    assertEquals("Class Name()", actualKotlinAnnotation.toString());
    assertNull(actualKotlinAnnotation.getProcessingInfo());
    assertEquals(0, actualKotlinAnnotation.getProcessingFlags());
    assertTrue(actualKotlinAnnotation.arguments.isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KotlinAnnotation#KotlinAnnotation(String)}
   *   <li>{@link KotlinAnnotation#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Class Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotation.<init>(java.lang.String)",
    "void proguard.classfile.kotlin.KotlinAnnotation.<init>(java.lang.String, java.util.List)",
    "java.lang.String proguard.classfile.kotlin.KotlinAnnotation.toString()"
  })
  void testGettersAndSetters_whenClassName() {
    // Arrange and Act
    KotlinAnnotation actualKotlinAnnotation = new KotlinAnnotation("Class Name");

    // Assert
    assertEquals("Class Name()", actualKotlinAnnotation.toString());
    assertNull(actualKotlinAnnotation.getProcessingInfo());
    assertEquals(0, actualKotlinAnnotation.getProcessingFlags());
    assertTrue(actualKotlinAnnotation.arguments.isEmpty());
  }

  /**
   * Test {@link KotlinAnnotation#accept(Clazz, KotlinAnnotatable, KotlinAnnotationVisitor)} with
   * {@code clazz}, {@code annotatable}, {@code kotlinAnnotationVisitor}.
   *
   * <p>Method under test: {@link KotlinAnnotation#accept(Clazz, KotlinAnnotatable,
   * KotlinAnnotationVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, KotlinAnnotatable, KotlinAnnotationVisitor) with 'clazz', 'annotatable', 'kotlinAnnotationVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotation.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.visitor.KotlinAnnotationVisitor)"
  })
  void testAcceptWithClazzAnnotatableKotlinAnnotationVisitor() {
    // Arrange
    KotlinAnnotation kotlinAnnotation = new KotlinAnnotation("Class Name");
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotationVisitor kotlinAnnotationVisitor = mock(KotlinAnnotationVisitor.class);
    doNothing()
        .when(kotlinAnnotationVisitor)
        .visitAnyAnnotation(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any());

    // Act
    kotlinAnnotation.accept(clazz, annotatable, kotlinAnnotationVisitor);

    // Assert
    verify(kotlinAnnotationVisitor)
        .visitAnyAnnotation(
            isA(Clazz.class), isA(KotlinAnnotatable.class), isA(KotlinAnnotation.class));
  }

  /**
   * Test {@link KotlinAnnotation#accept(Clazz, KotlinTypeAliasMetadata, KotlinAnnotationVisitor)}
   * with {@code clazz}, {@code kotlinTypeAliasMetadata}, {@code kotlinAnnotationVisitor}.
   *
   * <p>Method under test: {@link KotlinAnnotation#accept(Clazz, KotlinTypeAliasMetadata,
   * KotlinAnnotationVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, KotlinTypeAliasMetadata, KotlinAnnotationVisitor) with 'clazz', 'kotlinTypeAliasMetadata', 'kotlinAnnotationVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotation.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinTypeAliasMetadata, proguard.classfile.kotlin.visitor.KotlinAnnotationVisitor)"
  })
  void testAcceptWithClazzKotlinTypeAliasMetadataKotlinAnnotationVisitor() {
    // Arrange
    KotlinAnnotation kotlinAnnotation = new KotlinAnnotation("Class Name");
    LibraryClass clazz = new LibraryClass();
    KotlinVisibilityFlags visibility = new KotlinVisibilityFlags();
    visibility.isInternal = true;
    visibility.isLocal = true;
    visibility.isPrivate = true;
    visibility.isPrivateToThis = true;
    visibility.isProtected = true;
    visibility.isPublic = true;
    KotlinTypeAliasMetadata kotlinTypeAliasMetadata =
        new KotlinTypeAliasMetadata(new KotlinTypeAliasFlags(visibility), "Name");

    KotlinAnnotationVisitor kotlinAnnotationVisitor = mock(KotlinAnnotationVisitor.class);
    doNothing()
        .when(kotlinAnnotationVisitor)
        .visitTypeAliasAnnotation(
            Mockito.<Clazz>any(),
            Mockito.<KotlinTypeAliasMetadata>any(),
            Mockito.<KotlinAnnotation>any());

    // Act
    kotlinAnnotation.accept(clazz, kotlinTypeAliasMetadata, kotlinAnnotationVisitor);

    // Assert
    verify(kotlinAnnotationVisitor)
        .visitTypeAliasAnnotation(
            isA(Clazz.class), isA(KotlinTypeAliasMetadata.class), isA(KotlinAnnotation.class));
  }

  /**
   * Test {@link KotlinAnnotation#accept(Clazz, KotlinTypeMetadata, KotlinAnnotationVisitor)} with
   * {@code clazz}, {@code kotlinTypeMetadata}, {@code kotlinAnnotationVisitor}.
   *
   * <p>Method under test: {@link KotlinAnnotation#accept(Clazz, KotlinTypeMetadata,
   * KotlinAnnotationVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, KotlinTypeMetadata, KotlinAnnotationVisitor) with 'clazz', 'kotlinTypeMetadata', 'kotlinAnnotationVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotation.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinTypeMetadata, proguard.classfile.kotlin.visitor.KotlinAnnotationVisitor)"
  })
  void testAcceptWithClazzKotlinTypeMetadataKotlinAnnotationVisitor() {
    // Arrange
    KotlinAnnotation kotlinAnnotation = new KotlinAnnotation("Class Name");
    LibraryClass clazz = new LibraryClass();
    KotlinTypeMetadata kotlinTypeMetadata = KotlinTypeMetadata.starProjection();
    KotlinAnnotationVisitor kotlinAnnotationVisitor = mock(KotlinAnnotationVisitor.class);
    doNothing()
        .when(kotlinAnnotationVisitor)
        .visitTypeAnnotation(
            Mockito.<Clazz>any(),
            Mockito.<KotlinTypeMetadata>any(),
            Mockito.<KotlinAnnotation>any());

    // Act
    kotlinAnnotation.accept(clazz, kotlinTypeMetadata, kotlinAnnotationVisitor);

    // Assert
    verify(kotlinAnnotationVisitor)
        .visitTypeAnnotation(
            isA(Clazz.class), isA(KotlinTypeMetadata.class), isA(KotlinAnnotation.class));
  }

  /**
   * Test {@link KotlinAnnotation#accept(Clazz, KotlinTypeParameterMetadata,
   * KotlinAnnotationVisitor)} with {@code clazz}, {@code kotlinTypeParameterMetadata}, {@code
   * kotlinAnnotationVisitor}.
   *
   * <p>Method under test: {@link KotlinAnnotation#accept(Clazz, KotlinTypeParameterMetadata,
   * KotlinAnnotationVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, KotlinTypeParameterMetadata, KotlinAnnotationVisitor) with 'clazz', 'kotlinTypeParameterMetadata', 'kotlinAnnotationVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotation.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinTypeParameterMetadata, proguard.classfile.kotlin.visitor.KotlinAnnotationVisitor)"
  })
  void testAcceptWithClazzKotlinTypeParameterMetadataKotlinAnnotationVisitor() {
    // Arrange
    KotlinAnnotation kotlinAnnotation = new KotlinAnnotation("Class Name");
    LibraryClass clazz = new LibraryClass();
    KotlinTypeParameterFlags flags = new KotlinTypeParameterFlags();
    flags.isReified = true;
    KotlinTypeParameterMetadata kotlinTypeParameterMetadata =
        new KotlinTypeParameterMetadata(flags, "Name", 1, KotlinTypeVariance.INVARIANT);

    KotlinAnnotationVisitor kotlinAnnotationVisitor = mock(KotlinAnnotationVisitor.class);
    doNothing()
        .when(kotlinAnnotationVisitor)
        .visitTypeParameterAnnotation(
            Mockito.<Clazz>any(),
            Mockito.<KotlinTypeParameterMetadata>any(),
            Mockito.<KotlinAnnotation>any());

    // Act
    kotlinAnnotation.accept(clazz, kotlinTypeParameterMetadata, kotlinAnnotationVisitor);

    // Assert
    verify(kotlinAnnotationVisitor)
        .visitTypeParameterAnnotation(
            isA(Clazz.class), isA(KotlinTypeParameterMetadata.class), isA(KotlinAnnotation.class));
  }

  /**
   * Test {@link KotlinAnnotation#referencedClassAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotation#referencedClassAccept(ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedClassAccept(ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotation.referencedClassAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testReferencedClassAccept_thenCallsVisitLibraryClass() {
    // Arrange
    KotlinAnnotation kotlinAnnotation = new KotlinAnnotation("Class Name");
    kotlinAnnotation.referencedAnnotationClass = new LibraryClass();
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    kotlinAnnotation.referencedClassAccept(classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link KotlinAnnotation#argumentsAccept(Clazz, KotlinAnnotatable,
   * KotlinAnnotationArgumentVisitor)}.
   *
   * <ul>
   *   <li>Given {@link Value} {@link Value#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   *       KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)} does nothing.
   *   <li>Then calls {@link Value#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   *       KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotation#argumentsAccept(Clazz, KotlinAnnotatable,
   * KotlinAnnotationArgumentVisitor)}
   */
  @Test
  @DisplayName(
      "Test argumentsAccept(Clazz, KotlinAnnotatable, KotlinAnnotationArgumentVisitor); given Value accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor) does nothing; then calls accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotation.argumentsAccept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor)"
  })
  void testArgumentsAccept_givenValueAcceptDoesNothing_thenCallsAccept() {
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

    ArrayList<KotlinAnnotationArgument> arguments = new ArrayList<>();
    arguments.add(kotlinAnnotationArgument);
    KotlinAnnotation kotlinAnnotation = new KotlinAnnotation("Class Name", arguments);

    // Act
    kotlinAnnotation.argumentsAccept(
        new LibraryClass(),
        mock(KotlinAnnotatable.class),
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
   * Test {@link KotlinAnnotation#argumentsAccept(Clazz, KotlinAnnotatable,
   * KotlinAnnotationArgumentVisitor)}.
   *
   * <ul>
   *   <li>Given {@link Value} {@link Value#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   *       KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)} does nothing.
   *   <li>Then calls {@link Value#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   *       KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotation#argumentsAccept(Clazz, KotlinAnnotatable,
   * KotlinAnnotationArgumentVisitor)}
   */
  @Test
  @DisplayName(
      "Test argumentsAccept(Clazz, KotlinAnnotatable, KotlinAnnotationArgumentVisitor); given Value accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor) does nothing; then calls accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinAnnotation.argumentsAccept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor)"
  })
  void testArgumentsAccept_givenValueAcceptDoesNothing_thenCallsAccept2() {
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
        new KotlinAnnotationArgument("Name", value2);

    ArrayList<KotlinAnnotationArgument> arguments = new ArrayList<>();
    arguments.add(kotlinAnnotationArgument2);
    arguments.add(kotlinAnnotationArgument);
    KotlinAnnotation kotlinAnnotation = new KotlinAnnotation("Class Name", arguments);

    // Act
    kotlinAnnotation.argumentsAccept(
        new LibraryClass(),
        mock(KotlinAnnotatable.class),
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
   * Test {@link KotlinAnnotation#equals(Object)}, and {@link KotlinAnnotation#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KotlinAnnotation#equals(Object)}
   *   <li>{@link KotlinAnnotation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotation.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    KotlinAnnotation kotlinAnnotation = new KotlinAnnotation("Class Name");
    KotlinAnnotation kotlinAnnotation2 = new KotlinAnnotation("Class Name");

    // Act and Assert
    assertEquals(kotlinAnnotation, kotlinAnnotation2);
    int expectedHashCodeResult = kotlinAnnotation.hashCode();
    assertEquals(expectedHashCodeResult, kotlinAnnotation2.hashCode());
  }

  /**
   * Test {@link KotlinAnnotation#equals(Object)}, and {@link KotlinAnnotation#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KotlinAnnotation#equals(Object)}
   *   <li>{@link KotlinAnnotation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotation.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    KotlinAnnotation kotlinAnnotation = new KotlinAnnotation("Class Name");

    // Act and Assert
    assertEquals(kotlinAnnotation, kotlinAnnotation);
    int expectedHashCodeResult = kotlinAnnotation.hashCode();
    assertEquals(expectedHashCodeResult, kotlinAnnotation.hashCode());
  }

  /**
   * Test {@link KotlinAnnotation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotation.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    KotlinAnnotation kotlinAnnotation =
        new KotlinAnnotation("proguard.classfile.kotlin.KotlinAnnotation");

    // Act and Assert
    assertNotEquals(kotlinAnnotation, new KotlinAnnotation("Class Name"));
  }

  /**
   * Test {@link KotlinAnnotation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotation.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<KotlinAnnotationArgument> arguments = new ArrayList<>();
    arguments.add(new KotlinAnnotationArgument("Name", mock(Value.class)));
    KotlinAnnotation kotlinAnnotation = new KotlinAnnotation("Class Name", arguments);

    // Act and Assert
    assertNotEquals(kotlinAnnotation, new KotlinAnnotation("Class Name"));
  }

  /**
   * Test {@link KotlinAnnotation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotation.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotation.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KotlinAnnotation("Class Name"), null);
  }

  /**
   * Test {@link KotlinAnnotation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.KotlinAnnotation.equals(java.lang.Object)",
    "int proguard.classfile.kotlin.KotlinAnnotation.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KotlinAnnotation("Class Name"), "Different type to KotlinAnnotation");
  }
}
