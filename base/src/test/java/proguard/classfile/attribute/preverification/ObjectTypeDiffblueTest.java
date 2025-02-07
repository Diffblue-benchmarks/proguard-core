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

class ObjectTypeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code a:0}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ObjectType#ObjectType()}
   *   <li>{@link ObjectType#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return toString is 'a:0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.ObjectType.<init>()",
    "void proguard.classfile.attribute.preverification.ObjectType.<init>(int)",
    "java.lang.String proguard.classfile.attribute.preverification.ObjectType.toString()"
  })
  void testGettersAndSetters_thenReturnToStringIsA0() {
    // Arrange and Act
    ObjectType actualObjectType = new ObjectType();

    // Assert
    assertEquals("a:0", actualObjectType.toString());
    assertNull(actualObjectType.getProcessingInfo());
    assertEquals(0, actualObjectType.getProcessingFlags());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toString is {@code a:1}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ObjectType#ObjectType(int)}
   *   <li>{@link ObjectType#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one; then return toString is 'a:1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.ObjectType.<init>()",
    "void proguard.classfile.attribute.preverification.ObjectType.<init>(int)",
    "java.lang.String proguard.classfile.attribute.preverification.ObjectType.toString()"
  })
  void testGettersAndSetters_whenOne_thenReturnToStringIsA1() {
    // Arrange and Act
    ObjectType actualObjectType = new ObjectType(1);

    // Assert
    assertEquals("a:1", actualObjectType.toString());
    assertNull(actualObjectType.getProcessingInfo());
    assertEquals(0, actualObjectType.getProcessingFlags());
  }

  /**
   * Test {@link ObjectType#getTag()}.
   *
   * <p>Method under test: {@link ObjectType#getTag()}
   */
  @Test
  @DisplayName("Test getTag()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.attribute.preverification.ObjectType.getTag()"})
  void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(7, VerificationTypeFactory.createObjectType(1).getTag());
  }

  /**
   * Test {@link ObjectType#accept(Clazz, Method, CodeAttribute, int, VerificationTypeVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link VerificationTypeVisitor#visitObjectType(Clazz, Method, CodeAttribute,
   *       int, ObjectType)}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectType#accept(Clazz, Method, CodeAttribute, int,
   * VerificationTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, CodeAttribute, int, VerificationTypeVisitor); then calls visitObjectType(Clazz, Method, CodeAttribute, int, ObjectType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.ObjectType.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.visitor.VerificationTypeVisitor)"
  })
  void testAccept_thenCallsVisitObjectType() {
    // Arrange
    ObjectType createObjectTypeResult = VerificationTypeFactory.createObjectType(1);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    CodeAttributeComposer verificationTypeVisitor = mock(CodeAttributeComposer.class);
    doNothing()
        .when(verificationTypeVisitor)
        .visitObjectType(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            Mockito.<ObjectType>any());

    // Act
    createObjectTypeResult.accept(clazz, method, codeAttribute, 1, verificationTypeVisitor);

    // Assert
    verify(verificationTypeVisitor)
        .visitObjectType(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(1),
            isA(ObjectType.class));
  }

  /**
   * Test {@link ObjectType#stackAccept(Clazz, Method, CodeAttribute, int, int,
   * VerificationTypeVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link VerificationTypeVisitor#visitStackObjectType(Clazz, Method,
   *       CodeAttribute, int, int, ObjectType)}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectType#stackAccept(Clazz, Method, CodeAttribute, int, int,
   * VerificationTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test stackAccept(Clazz, Method, CodeAttribute, int, int, VerificationTypeVisitor); then calls visitStackObjectType(Clazz, Method, CodeAttribute, int, int, ObjectType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.ObjectType.stackAccept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, int, proguard.classfile.attribute.preverification.visitor.VerificationTypeVisitor)"
  })
  void testStackAccept_thenCallsVisitStackObjectType() {
    // Arrange
    ObjectType createObjectTypeResult = VerificationTypeFactory.createObjectType(1);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    CodeAttributeComposer verificationTypeVisitor = mock(CodeAttributeComposer.class);
    doNothing()
        .when(verificationTypeVisitor)
        .visitStackObjectType(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            anyInt(),
            Mockito.<ObjectType>any());

    // Act
    createObjectTypeResult.stackAccept(clazz, method, codeAttribute, 1, 1, verificationTypeVisitor);

    // Assert
    verify(verificationTypeVisitor)
        .visitStackObjectType(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(1),
            eq(1),
            isA(ObjectType.class));
  }

  /**
   * Test {@link ObjectType#variablesAccept(Clazz, Method, CodeAttribute, int, int,
   * VerificationTypeVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link VerificationTypeVisitor#visitVariablesObjectType(Clazz, Method,
   *       CodeAttribute, int, int, ObjectType)}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectType#variablesAccept(Clazz, Method, CodeAttribute, int, int,
   * VerificationTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test variablesAccept(Clazz, Method, CodeAttribute, int, int, VerificationTypeVisitor); then calls visitVariablesObjectType(Clazz, Method, CodeAttribute, int, int, ObjectType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.ObjectType.variablesAccept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, int, proguard.classfile.attribute.preverification.visitor.VerificationTypeVisitor)"
  })
  void testVariablesAccept_thenCallsVisitVariablesObjectType() {
    // Arrange
    ObjectType createObjectTypeResult = VerificationTypeFactory.createObjectType(1);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    CodeAttributeComposer verificationTypeVisitor = mock(CodeAttributeComposer.class);
    doNothing()
        .when(verificationTypeVisitor)
        .visitVariablesObjectType(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            anyInt(),
            Mockito.<ObjectType>any());

    // Act
    createObjectTypeResult.variablesAccept(
        clazz, method, codeAttribute, 1, 1, verificationTypeVisitor);

    // Assert
    verify(verificationTypeVisitor)
        .visitVariablesObjectType(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(1),
            eq(1),
            isA(ObjectType.class));
  }

  /**
   * Test {@link ObjectType#equals(Object)}, and {@link ObjectType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ObjectType#equals(Object)}
   *   <li>{@link ObjectType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.ObjectType.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.ObjectType.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ObjectType createObjectTypeResult = VerificationTypeFactory.createObjectType(1);
    ObjectType createObjectTypeResult2 = VerificationTypeFactory.createObjectType(1);

    // Act and Assert
    assertEquals(createObjectTypeResult, createObjectTypeResult2);
    int expectedHashCodeResult = createObjectTypeResult.hashCode();
    assertEquals(expectedHashCodeResult, createObjectTypeResult2.hashCode());
  }

  /**
   * Test {@link ObjectType#equals(Object)}, and {@link ObjectType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ObjectType#equals(Object)}
   *   <li>{@link ObjectType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.ObjectType.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.ObjectType.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ObjectType createObjectTypeResult = VerificationTypeFactory.createObjectType(1);

    // Act and Assert
    assertEquals(createObjectTypeResult, createObjectTypeResult);
    int expectedHashCodeResult = createObjectTypeResult.hashCode();
    assertEquals(expectedHashCodeResult, createObjectTypeResult.hashCode());
  }

  /**
   * Test {@link ObjectType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.ObjectType.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.ObjectType.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ObjectType createObjectTypeResult = VerificationTypeFactory.createObjectType(0);

    // Act and Assert
    assertNotEquals(createObjectTypeResult, VerificationTypeFactory.createObjectType(1));
  }

  /**
   * Test {@link ObjectType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.ObjectType.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.ObjectType.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(VerificationTypeFactory.createObjectType(1), null);
  }

  /**
   * Test {@link ObjectType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.ObjectType.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.ObjectType.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(VerificationTypeFactory.createObjectType(1), "Different type to ObjectType");
  }
}
