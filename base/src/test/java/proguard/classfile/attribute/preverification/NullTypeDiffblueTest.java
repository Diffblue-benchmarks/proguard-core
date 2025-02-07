package proguard.classfile.attribute.preverification;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

class NullTypeDiffblueTest {
  /**
   * Test {@link NullType#accept(Clazz, Method, CodeAttribute, int, VerificationTypeVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link VerificationTypeVisitor#visitNullType(Clazz, Method, CodeAttribute,
   *       int, NullType)}.
   * </ul>
   *
   * <p>Method under test: {@link NullType#accept(Clazz, Method, CodeAttribute, int,
   * VerificationTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, CodeAttribute, int, VerificationTypeVisitor); then calls visitNullType(Clazz, Method, CodeAttribute, int, NullType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.NullType.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.visitor.VerificationTypeVisitor)"
  })
  void testAccept_thenCallsVisitNullType() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    CodeAttributeComposer verificationTypeVisitor = mock(CodeAttributeComposer.class);
    doNothing()
        .when(verificationTypeVisitor)
        .visitNullType(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            Mockito.<NullType>any());

    // Act
    VerificationTypeFactory.NULL_TYPE.accept(
        clazz, method, codeAttribute, 1, verificationTypeVisitor);

    // Assert
    verify(verificationTypeVisitor)
        .visitNullType(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(1),
            isA(NullType.class));
  }

  /**
   * Test {@link NullType#stackAccept(Clazz, Method, CodeAttribute, int, int,
   * VerificationTypeVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link VerificationTypeVisitor#visitStackNullType(Clazz, Method,
   *       CodeAttribute, int, int, NullType)}.
   * </ul>
   *
   * <p>Method under test: {@link NullType#stackAccept(Clazz, Method, CodeAttribute, int, int,
   * VerificationTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test stackAccept(Clazz, Method, CodeAttribute, int, int, VerificationTypeVisitor); then calls visitStackNullType(Clazz, Method, CodeAttribute, int, int, NullType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.NullType.stackAccept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, int, proguard.classfile.attribute.preverification.visitor.VerificationTypeVisitor)"
  })
  void testStackAccept_thenCallsVisitStackNullType() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    CodeAttributeComposer verificationTypeVisitor = mock(CodeAttributeComposer.class);
    doNothing()
        .when(verificationTypeVisitor)
        .visitStackNullType(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            anyInt(),
            Mockito.<NullType>any());

    // Act
    VerificationTypeFactory.NULL_TYPE.stackAccept(
        clazz, method, codeAttribute, 1, 1, verificationTypeVisitor);

    // Assert
    verify(verificationTypeVisitor)
        .visitStackNullType(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(1),
            eq(1),
            isA(NullType.class));
  }

  /**
   * Test {@link NullType#variablesAccept(Clazz, Method, CodeAttribute, int, int,
   * VerificationTypeVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link VerificationTypeVisitor#visitVariablesNullType(Clazz, Method,
   *       CodeAttribute, int, int, NullType)}.
   * </ul>
   *
   * <p>Method under test: {@link NullType#variablesAccept(Clazz, Method, CodeAttribute, int, int,
   * VerificationTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test variablesAccept(Clazz, Method, CodeAttribute, int, int, VerificationTypeVisitor); then calls visitVariablesNullType(Clazz, Method, CodeAttribute, int, int, NullType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.NullType.variablesAccept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, int, proguard.classfile.attribute.preverification.visitor.VerificationTypeVisitor)"
  })
  void testVariablesAccept_thenCallsVisitVariablesNullType() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    CodeAttributeComposer verificationTypeVisitor = mock(CodeAttributeComposer.class);
    doNothing()
        .when(verificationTypeVisitor)
        .visitVariablesNullType(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            anyInt(),
            Mockito.<NullType>any());

    // Act
    VerificationTypeFactory.NULL_TYPE.variablesAccept(
        clazz, method, codeAttribute, 1, 1, verificationTypeVisitor);

    // Assert
    verify(verificationTypeVisitor)
        .visitVariablesNullType(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(1),
            eq(1),
            isA(NullType.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link NullType}
   *   <li>{@link NullType#toString()}
   *   <li>{@link NullType#getTag()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.NullType.<init>()",
    "int proguard.classfile.attribute.preverification.NullType.getTag()",
    "java.lang.String proguard.classfile.attribute.preverification.NullType.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    NullType actualNullType = new NullType();
    String actualToStringResult = actualNullType.toString();
    int actualTag = actualNullType.getTag();

    // Assert
    assertEquals("n", actualToStringResult);
    assertNull(actualNullType.getProcessingInfo());
    assertEquals(0, actualNullType.getProcessingFlags());
    assertEquals(5, actualTag);
  }
}
