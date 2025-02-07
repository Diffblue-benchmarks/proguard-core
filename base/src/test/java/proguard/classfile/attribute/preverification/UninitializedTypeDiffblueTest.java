package proguard.classfile.attribute.preverification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
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
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.preverification.visitor.VerificationTypeVisitor;
import proguard.classfile.editor.CodeAttributeComposer;

class UninitializedTypeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code u:0}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UninitializedType#UninitializedType()}
   *   <li>{@link UninitializedType#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return toString is 'u:0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.UninitializedType.<init>()",
    "void proguard.classfile.attribute.preverification.UninitializedType.<init>(int)",
    "java.lang.String proguard.classfile.attribute.preverification.UninitializedType.toString()"
  })
  void testGettersAndSetters_thenReturnToStringIsU0() {
    // Arrange and Act
    UninitializedType actualUninitializedType = new UninitializedType();

    // Assert
    assertEquals("u:0", actualUninitializedType.toString());
    assertNull(actualUninitializedType.getProcessingInfo());
    assertEquals(0, actualUninitializedType.getProcessingFlags());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toString is {@code u:1}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UninitializedType#UninitializedType(int)}
   *   <li>{@link UninitializedType#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one; then return toString is 'u:1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.UninitializedType.<init>()",
    "void proguard.classfile.attribute.preverification.UninitializedType.<init>(int)",
    "java.lang.String proguard.classfile.attribute.preverification.UninitializedType.toString()"
  })
  void testGettersAndSetters_whenOne_thenReturnToStringIsU1() {
    // Arrange and Act
    UninitializedType actualUninitializedType = new UninitializedType(1);

    // Assert
    assertEquals("u:1", actualUninitializedType.toString());
    assertNull(actualUninitializedType.getProcessingInfo());
    assertEquals(0, actualUninitializedType.getProcessingFlags());
  }

  /**
   * Test {@link UninitializedType#getTag()}.
   *
   * <p>Method under test: {@link UninitializedType#getTag()}
   */
  @Test
  @DisplayName("Test getTag()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.attribute.preverification.UninitializedType.getTag()"})
  void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(8, VerificationTypeFactory.createUninitializedType(1).getTag());
  }

  /**
   * Test {@link UninitializedType#accept(Clazz, Method, CodeAttribute, int,
   * VerificationTypeVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link CodeAttributeComposer#visitUninitializedType(Clazz, Method,
   *       CodeAttribute, int, UninitializedType)}.
   * </ul>
   *
   * <p>Method under test: {@link UninitializedType#accept(Clazz, Method, CodeAttribute, int,
   * VerificationTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, CodeAttribute, int, VerificationTypeVisitor); then calls visitUninitializedType(Clazz, Method, CodeAttribute, int, UninitializedType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.UninitializedType.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.visitor.VerificationTypeVisitor)"
  })
  void testAccept_thenCallsVisitUninitializedType() {
    // Arrange
    UninitializedType createUninitializedTypeResult =
        VerificationTypeFactory.createUninitializedType(1);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    CodeAttributeComposer verificationTypeVisitor = mock(CodeAttributeComposer.class);
    doNothing()
        .when(verificationTypeVisitor)
        .visitUninitializedType(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            Mockito.<UninitializedType>any());

    // Act
    createUninitializedTypeResult.accept(clazz, method, codeAttribute, 1, verificationTypeVisitor);

    // Assert
    verify(verificationTypeVisitor)
        .visitUninitializedType(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(1),
            isA(UninitializedType.class));
  }

  /**
   * Test {@link UninitializedType#stackAccept(Clazz, Method, CodeAttribute, int, int,
   * VerificationTypeVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link VerificationTypeVisitor#visitStackUninitializedType(Clazz, Method,
   *       CodeAttribute, int, int, UninitializedType)}.
   * </ul>
   *
   * <p>Method under test: {@link UninitializedType#stackAccept(Clazz, Method, CodeAttribute, int,
   * int, VerificationTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test stackAccept(Clazz, Method, CodeAttribute, int, int, VerificationTypeVisitor); then calls visitStackUninitializedType(Clazz, Method, CodeAttribute, int, int, UninitializedType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.UninitializedType.stackAccept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, int, proguard.classfile.attribute.preverification.visitor.VerificationTypeVisitor)"
  })
  void testStackAccept_thenCallsVisitStackUninitializedType() {
    // Arrange
    UninitializedType createUninitializedTypeResult =
        VerificationTypeFactory.createUninitializedType(1);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    CodeAttributeComposer verificationTypeVisitor = mock(CodeAttributeComposer.class);
    doNothing()
        .when(verificationTypeVisitor)
        .visitStackUninitializedType(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            anyInt(),
            Mockito.<UninitializedType>any());

    // Act
    createUninitializedTypeResult.stackAccept(
        clazz, method, codeAttribute, 1, 1, verificationTypeVisitor);

    // Assert
    verify(verificationTypeVisitor)
        .visitStackUninitializedType(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(1),
            eq(1),
            isA(UninitializedType.class));
  }

  /**
   * Test {@link UninitializedType#variablesAccept(Clazz, Method, CodeAttribute, int, int,
   * VerificationTypeVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link VerificationTypeVisitor#visitVariablesUninitializedType(Clazz, Method,
   *       CodeAttribute, int, int, UninitializedType)}.
   * </ul>
   *
   * <p>Method under test: {@link UninitializedType#variablesAccept(Clazz, Method, CodeAttribute,
   * int, int, VerificationTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test variablesAccept(Clazz, Method, CodeAttribute, int, int, VerificationTypeVisitor); then calls visitVariablesUninitializedType(Clazz, Method, CodeAttribute, int, int, UninitializedType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.UninitializedType.variablesAccept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, int, proguard.classfile.attribute.preverification.visitor.VerificationTypeVisitor)"
  })
  void testVariablesAccept_thenCallsVisitVariablesUninitializedType() {
    // Arrange
    UninitializedType createUninitializedTypeResult =
        VerificationTypeFactory.createUninitializedType(1);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    CodeAttributeComposer verificationTypeVisitor = mock(CodeAttributeComposer.class);
    doNothing()
        .when(verificationTypeVisitor)
        .visitVariablesUninitializedType(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            anyInt(),
            Mockito.<UninitializedType>any());

    // Act
    createUninitializedTypeResult.variablesAccept(
        clazz, method, codeAttribute, 1, 1, verificationTypeVisitor);

    // Assert
    verify(verificationTypeVisitor)
        .visitVariablesUninitializedType(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(1),
            eq(1),
            isA(UninitializedType.class));
  }

  /**
   * Test {@link UninitializedType#equals(Object)}, and {@link UninitializedType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UninitializedType#equals(Object)}
   *   <li>{@link UninitializedType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.UninitializedType.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.UninitializedType.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UninitializedType createUninitializedTypeResult =
        VerificationTypeFactory.createUninitializedType(1);
    UninitializedType createUninitializedTypeResult2 =
        VerificationTypeFactory.createUninitializedType(1);

    // Act and Assert
    assertEquals(createUninitializedTypeResult, createUninitializedTypeResult2);
    int expectedHashCodeResult = createUninitializedTypeResult.hashCode();
    assertEquals(expectedHashCodeResult, createUninitializedTypeResult2.hashCode());
  }

  /**
   * Test {@link UninitializedType#equals(Object)}, and {@link UninitializedType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UninitializedType#equals(Object)}
   *   <li>{@link UninitializedType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.UninitializedType.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.UninitializedType.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UninitializedType createUninitializedTypeResult =
        VerificationTypeFactory.createUninitializedType(1);

    // Act and Assert
    assertEquals(createUninitializedTypeResult, createUninitializedTypeResult);
    int expectedHashCodeResult = createUninitializedTypeResult.hashCode();
    assertEquals(expectedHashCodeResult, createUninitializedTypeResult.hashCode());
  }

  /**
   * Test {@link UninitializedType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UninitializedType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.UninitializedType.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.UninitializedType.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UninitializedType createUninitializedTypeResult =
        VerificationTypeFactory.createUninitializedType(0);

    // Act and Assert
    assertNotEquals(
        createUninitializedTypeResult, VerificationTypeFactory.createUninitializedType(1));
  }

  /**
   * Test {@link UninitializedType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UninitializedType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.UninitializedType.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.UninitializedType.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(VerificationTypeFactory.createUninitializedType(1), null);
  }

  /**
   * Test {@link UninitializedType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UninitializedType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.UninitializedType.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.UninitializedType.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        VerificationTypeFactory.createUninitializedType(1), "Different type to UninitializedType");
  }
}
