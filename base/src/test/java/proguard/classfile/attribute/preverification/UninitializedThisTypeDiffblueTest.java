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

class UninitializedThisTypeDiffblueTest {
  /**
   * Test {@link UninitializedThisType#getTag()}.
   *
   * <p>Method under test: {@link UninitializedThisType#getTag()}
   */
  @Test
  @DisplayName("Test getTag()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.preverification.UninitializedThisType.getTag()"
  })
  void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(6, VerificationTypeFactory.UNINITIALIZED_THIS_TYPE.getTag());
  }

  /**
   * Test {@link UninitializedThisType#accept(Clazz, Method, CodeAttribute, int,
   * VerificationTypeVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link VerificationTypeVisitor#visitUninitializedThisType(Clazz, Method,
   *       CodeAttribute, int, UninitializedThisType)}.
   * </ul>
   *
   * <p>Method under test: {@link UninitializedThisType#accept(Clazz, Method, CodeAttribute, int,
   * VerificationTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, CodeAttribute, int, VerificationTypeVisitor); then calls visitUninitializedThisType(Clazz, Method, CodeAttribute, int, UninitializedThisType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.UninitializedThisType.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.visitor.VerificationTypeVisitor)"
  })
  void testAccept_thenCallsVisitUninitializedThisType() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    CodeAttributeComposer verificationTypeVisitor = mock(CodeAttributeComposer.class);
    doNothing()
        .when(verificationTypeVisitor)
        .visitUninitializedThisType(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            Mockito.<UninitializedThisType>any());

    // Act
    VerificationTypeFactory.UNINITIALIZED_THIS_TYPE.accept(
        clazz, method, codeAttribute, 1, verificationTypeVisitor);

    // Assert
    verify(verificationTypeVisitor)
        .visitUninitializedThisType(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(1),
            isA(UninitializedThisType.class));
  }

  /**
   * Test {@link UninitializedThisType#stackAccept(Clazz, Method, CodeAttribute, int, int,
   * VerificationTypeVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link VerificationTypeVisitor#visitStackUninitializedThisType(Clazz, Method,
   *       CodeAttribute, int, int, UninitializedThisType)}.
   * </ul>
   *
   * <p>Method under test: {@link UninitializedThisType#stackAccept(Clazz, Method, CodeAttribute,
   * int, int, VerificationTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test stackAccept(Clazz, Method, CodeAttribute, int, int, VerificationTypeVisitor); then calls visitStackUninitializedThisType(Clazz, Method, CodeAttribute, int, int, UninitializedThisType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.UninitializedThisType.stackAccept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, int, proguard.classfile.attribute.preverification.visitor.VerificationTypeVisitor)"
  })
  void testStackAccept_thenCallsVisitStackUninitializedThisType() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    CodeAttributeComposer verificationTypeVisitor = mock(CodeAttributeComposer.class);
    doNothing()
        .when(verificationTypeVisitor)
        .visitStackUninitializedThisType(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            anyInt(),
            Mockito.<UninitializedThisType>any());

    // Act
    VerificationTypeFactory.UNINITIALIZED_THIS_TYPE.stackAccept(
        clazz, method, codeAttribute, 1, 1, verificationTypeVisitor);

    // Assert
    verify(verificationTypeVisitor)
        .visitStackUninitializedThisType(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(1),
            eq(1),
            isA(UninitializedThisType.class));
  }

  /**
   * Test {@link UninitializedThisType#variablesAccept(Clazz, Method, CodeAttribute, int, int,
   * VerificationTypeVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link VerificationTypeVisitor#visitVariablesUninitializedThisType(Clazz,
   *       Method, CodeAttribute, int, int, UninitializedThisType)}.
   * </ul>
   *
   * <p>Method under test: {@link UninitializedThisType#variablesAccept(Clazz, Method,
   * CodeAttribute, int, int, VerificationTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test variablesAccept(Clazz, Method, CodeAttribute, int, int, VerificationTypeVisitor); then calls visitVariablesUninitializedThisType(Clazz, Method, CodeAttribute, int, int, UninitializedThisType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.UninitializedThisType.variablesAccept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, int, proguard.classfile.attribute.preverification.visitor.VerificationTypeVisitor)"
  })
  void testVariablesAccept_thenCallsVisitVariablesUninitializedThisType() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    CodeAttributeComposer verificationTypeVisitor = mock(CodeAttributeComposer.class);
    doNothing()
        .when(verificationTypeVisitor)
        .visitVariablesUninitializedThisType(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            anyInt(),
            Mockito.<UninitializedThisType>any());

    // Act
    VerificationTypeFactory.UNINITIALIZED_THIS_TYPE.variablesAccept(
        clazz, method, codeAttribute, 1, 1, verificationTypeVisitor);

    // Assert
    verify(verificationTypeVisitor)
        .visitVariablesUninitializedThisType(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(1),
            eq(1),
            isA(UninitializedThisType.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link UninitializedThisType}
   *   <li>{@link UninitializedThisType#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.UninitializedThisType.<init>()",
    "java.lang.String proguard.classfile.attribute.preverification.UninitializedThisType.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    UninitializedThisType actualUninitializedThisType = new UninitializedThisType();

    // Assert
    assertEquals("u:this", actualUninitializedThisType.toString());
    assertNull(actualUninitializedThisType.getProcessingInfo());
    assertEquals(0, actualUninitializedThisType.getProcessingFlags());
  }
}
