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

class LongTypeDiffblueTest {
  /**
   * Test {@link LongType#accept(Clazz, Method, CodeAttribute, int, VerificationTypeVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link VerificationTypeVisitor#visitLongType(Clazz, Method, CodeAttribute,
   *       int, LongType)}.
   * </ul>
   *
   * <p>Method under test: {@link LongType#accept(Clazz, Method, CodeAttribute, int,
   * VerificationTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, CodeAttribute, int, VerificationTypeVisitor); then calls visitLongType(Clazz, Method, CodeAttribute, int, LongType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.LongType.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.visitor.VerificationTypeVisitor)"
  })
  void testAccept_thenCallsVisitLongType() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    CodeAttributeComposer verificationTypeVisitor = mock(CodeAttributeComposer.class);
    doNothing()
        .when(verificationTypeVisitor)
        .visitLongType(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            Mockito.<LongType>any());

    // Act
    VerificationTypeFactory.LONG_TYPE.accept(
        clazz, method, codeAttribute, 1, verificationTypeVisitor);

    // Assert
    verify(verificationTypeVisitor)
        .visitLongType(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(1),
            isA(LongType.class));
  }

  /**
   * Test {@link LongType#stackAccept(Clazz, Method, CodeAttribute, int, int,
   * VerificationTypeVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link VerificationTypeVisitor#visitStackLongType(Clazz, Method,
   *       CodeAttribute, int, int, LongType)}.
   * </ul>
   *
   * <p>Method under test: {@link LongType#stackAccept(Clazz, Method, CodeAttribute, int, int,
   * VerificationTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test stackAccept(Clazz, Method, CodeAttribute, int, int, VerificationTypeVisitor); then calls visitStackLongType(Clazz, Method, CodeAttribute, int, int, LongType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.LongType.stackAccept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, int, proguard.classfile.attribute.preverification.visitor.VerificationTypeVisitor)"
  })
  void testStackAccept_thenCallsVisitStackLongType() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    CodeAttributeComposer verificationTypeVisitor = mock(CodeAttributeComposer.class);
    doNothing()
        .when(verificationTypeVisitor)
        .visitStackLongType(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            anyInt(),
            Mockito.<LongType>any());

    // Act
    VerificationTypeFactory.LONG_TYPE.stackAccept(
        clazz, method, codeAttribute, 1, 1, verificationTypeVisitor);

    // Assert
    verify(verificationTypeVisitor)
        .visitStackLongType(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(1),
            eq(1),
            isA(LongType.class));
  }

  /**
   * Test {@link LongType#variablesAccept(Clazz, Method, CodeAttribute, int, int,
   * VerificationTypeVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link VerificationTypeVisitor#visitVariablesLongType(Clazz, Method,
   *       CodeAttribute, int, int, LongType)}.
   * </ul>
   *
   * <p>Method under test: {@link LongType#variablesAccept(Clazz, Method, CodeAttribute, int, int,
   * VerificationTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test variablesAccept(Clazz, Method, CodeAttribute, int, int, VerificationTypeVisitor); then calls visitVariablesLongType(Clazz, Method, CodeAttribute, int, int, LongType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.LongType.variablesAccept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, int, proguard.classfile.attribute.preverification.visitor.VerificationTypeVisitor)"
  })
  void testVariablesAccept_thenCallsVisitVariablesLongType() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    CodeAttributeComposer verificationTypeVisitor = mock(CodeAttributeComposer.class);
    doNothing()
        .when(verificationTypeVisitor)
        .visitVariablesLongType(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            anyInt(),
            Mockito.<LongType>any());

    // Act
    VerificationTypeFactory.LONG_TYPE.variablesAccept(
        clazz, method, codeAttribute, 1, 1, verificationTypeVisitor);

    // Assert
    verify(verificationTypeVisitor)
        .visitVariablesLongType(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(1),
            eq(1),
            isA(LongType.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link LongType}
   *   <li>{@link LongType#toString()}
   *   <li>{@link LongType#getTag()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.LongType.<init>()",
    "int proguard.classfile.attribute.preverification.LongType.getTag()",
    "java.lang.String proguard.classfile.attribute.preverification.LongType.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    LongType actualLongType = new LongType();
    String actualToStringResult = actualLongType.toString();
    int actualTag = actualLongType.getTag();

    // Assert
    assertEquals("l", actualToStringResult);
    assertNull(actualLongType.getProcessingInfo());
    assertEquals(0, actualLongType.getProcessingFlags());
    assertEquals(4, actualTag);
  }
}
