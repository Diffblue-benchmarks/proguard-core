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

class DoubleTypeDiffblueTest {
  /**
   * Test {@link DoubleType#accept(Clazz, Method, CodeAttribute, int, VerificationTypeVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link VerificationTypeVisitor#visitDoubleType(Clazz, Method, CodeAttribute,
   *       int, DoubleType)}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleType#accept(Clazz, Method, CodeAttribute, int,
   * VerificationTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, CodeAttribute, int, VerificationTypeVisitor); then calls visitDoubleType(Clazz, Method, CodeAttribute, int, DoubleType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.DoubleType.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.visitor.VerificationTypeVisitor)"
  })
  void testAccept_thenCallsVisitDoubleType() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    CodeAttributeComposer verificationTypeVisitor = mock(CodeAttributeComposer.class);
    doNothing()
        .when(verificationTypeVisitor)
        .visitDoubleType(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            Mockito.<DoubleType>any());

    // Act
    VerificationTypeFactory.DOUBLE_TYPE.accept(
        clazz, method, codeAttribute, 1, verificationTypeVisitor);

    // Assert
    verify(verificationTypeVisitor)
        .visitDoubleType(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(1),
            isA(DoubleType.class));
  }

  /**
   * Test {@link DoubleType#stackAccept(Clazz, Method, CodeAttribute, int, int,
   * VerificationTypeVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link VerificationTypeVisitor#visitStackDoubleType(Clazz, Method,
   *       CodeAttribute, int, int, DoubleType)}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleType#stackAccept(Clazz, Method, CodeAttribute, int, int,
   * VerificationTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test stackAccept(Clazz, Method, CodeAttribute, int, int, VerificationTypeVisitor); then calls visitStackDoubleType(Clazz, Method, CodeAttribute, int, int, DoubleType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.DoubleType.stackAccept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, int, proguard.classfile.attribute.preverification.visitor.VerificationTypeVisitor)"
  })
  void testStackAccept_thenCallsVisitStackDoubleType() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    CodeAttributeComposer verificationTypeVisitor = mock(CodeAttributeComposer.class);
    doNothing()
        .when(verificationTypeVisitor)
        .visitStackDoubleType(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            anyInt(),
            Mockito.<DoubleType>any());

    // Act
    VerificationTypeFactory.DOUBLE_TYPE.stackAccept(
        clazz, method, codeAttribute, 1, 1, verificationTypeVisitor);

    // Assert
    verify(verificationTypeVisitor)
        .visitStackDoubleType(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(1),
            eq(1),
            isA(DoubleType.class));
  }

  /**
   * Test {@link DoubleType#variablesAccept(Clazz, Method, CodeAttribute, int, int,
   * VerificationTypeVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link VerificationTypeVisitor#visitVariablesDoubleType(Clazz, Method,
   *       CodeAttribute, int, int, DoubleType)}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleType#variablesAccept(Clazz, Method, CodeAttribute, int, int,
   * VerificationTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test variablesAccept(Clazz, Method, CodeAttribute, int, int, VerificationTypeVisitor); then calls visitVariablesDoubleType(Clazz, Method, CodeAttribute, int, int, DoubleType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.DoubleType.variablesAccept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, int, proguard.classfile.attribute.preverification.visitor.VerificationTypeVisitor)"
  })
  void testVariablesAccept_thenCallsVisitVariablesDoubleType() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    CodeAttributeComposer verificationTypeVisitor = mock(CodeAttributeComposer.class);
    doNothing()
        .when(verificationTypeVisitor)
        .visitVariablesDoubleType(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            anyInt(),
            Mockito.<DoubleType>any());

    // Act
    VerificationTypeFactory.DOUBLE_TYPE.variablesAccept(
        clazz, method, codeAttribute, 1, 1, verificationTypeVisitor);

    // Assert
    verify(verificationTypeVisitor)
        .visitVariablesDoubleType(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(1),
            eq(1),
            isA(DoubleType.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DoubleType}
   *   <li>{@link DoubleType#toString()}
   *   <li>{@link DoubleType#getTag()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.DoubleType.<init>()",
    "int proguard.classfile.attribute.preverification.DoubleType.getTag()",
    "java.lang.String proguard.classfile.attribute.preverification.DoubleType.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    DoubleType actualDoubleType = new DoubleType();
    String actualToStringResult = actualDoubleType.toString();
    int actualTag = actualDoubleType.getTag();

    // Assert
    assertEquals("d", actualToStringResult);
    assertNull(actualDoubleType.getProcessingInfo());
    assertEquals(0, actualDoubleType.getProcessingFlags());
    assertEquals(3, actualTag);
  }
}
