package proguard.classfile.attribute.preverification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.preverification.visitor.StackMapFrameVisitor;
import proguard.classfile.editor.ConstantPoolRemapper;
import proguard.classfile.visitor.ProcessingInfoSetter;

class FullFrameDiffblueTest {
  /**
   * Test {@link FullFrame#FullFrame()}.
   *
   * <ul>
   *   <li>Then return OffsetDelta is zero.
   * </ul>
   *
   * <p>Method under test: {@link FullFrame#FullFrame()}
   */
  @Test
  @DisplayName("Test new FullFrame(); then return OffsetDelta is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.FullFrame.<init>()",
    "void proguard.classfile.attribute.preverification.FullFrame.<init>(int, int, proguard.classfile.attribute.preverification.VerificationType[], int, proguard.classfile.attribute.preverification.VerificationType[])"
  })
  void testNewFullFrame_thenReturnOffsetDeltaIsZero() {
    // Arrange and Act
    FullFrame actualFullFrame = new FullFrame();

    // Assert
    assertNull(actualFullFrame.getProcessingInfo());
    assertEquals(0, actualFullFrame.getOffsetDelta());
    assertEquals(0, actualFullFrame.getProcessingFlags());
  }

  /**
   * Test {@link FullFrame#FullFrame(int, int, VerificationType[], int, VerificationType[])}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return OffsetDelta is two.
   * </ul>
   *
   * <p>Method under test: {@link FullFrame#FullFrame(int, int, VerificationType[], int,
   * VerificationType[])}
   */
  @Test
  @DisplayName(
      "Test new FullFrame(int, int, VerificationType[], int, VerificationType[]); when two; then return OffsetDelta is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.FullFrame.<init>()",
    "void proguard.classfile.attribute.preverification.FullFrame.<init>(int, int, proguard.classfile.attribute.preverification.VerificationType[], int, proguard.classfile.attribute.preverification.VerificationType[])"
  })
  void testNewFullFrame_whenTwo_thenReturnOffsetDeltaIsTwo() {
    // Arrange and Act
    FullFrame actualFullFrame =
        new FullFrame(
            2,
            3,
            new VerificationType[] {VerificationTypeFactory.DOUBLE_TYPE},
            3,
            new VerificationType[] {VerificationTypeFactory.DOUBLE_TYPE});

    // Assert
    assertNull(actualFullFrame.getProcessingInfo());
    assertEquals(0, actualFullFrame.getProcessingFlags());
    assertEquals(2, actualFullFrame.getOffsetDelta());
  }

  /**
   * Test {@link FullFrame#getTag()}.
   *
   * <p>Method under test: {@link FullFrame#getTag()}
   */
  @Test
  @DisplayName("Test getTag()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.attribute.preverification.FullFrame.getTag()"})
  void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(StackMapFrame.FULL_FRAME, (new FullFrame()).getTag());
  }

  /**
   * Test {@link FullFrame#accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor)}.
   *
   * <p>Method under test: {@link FullFrame#accept(Clazz, Method, CodeAttribute, int,
   * StackMapFrameVisitor)}
   */
  @Test
  @DisplayName("Test accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.FullFrame.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.visitor.StackMapFrameVisitor)"
  })
  void testAccept() {
    // Arrange
    FullFrame fullFrame =
        new FullFrame(
            2,
            new VerificationType[] {VerificationTypeFactory.DOUBLE_TYPE},
            new VerificationType[] {VerificationTypeFactory.DOUBLE_TYPE});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    fullFrame.accept(clazz, method, codeAttribute, 2, new ConstantPoolRemapper());

    // Assert that nothing has changed
    assertNull(fullFrame.getProcessingInfo());
  }

  /**
   * Test {@link FullFrame#accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor)}.
   *
   * <ul>
   *   <li>Given {@link FullFrame#FullFrame()}.
   *   <li>Then {@link FullFrame#FullFrame()} ProcessingInfo is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FullFrame#accept(Clazz, Method, CodeAttribute, int,
   * StackMapFrameVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor); given FullFrame(); then FullFrame() ProcessingInfo is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.FullFrame.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.visitor.StackMapFrameVisitor)"
  })
  void testAccept_givenFullFrame_thenFullFrameProcessingInfoIsNull() {
    // Arrange
    FullFrame fullFrame = new FullFrame();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    fullFrame.accept(clazz, method, codeAttribute, 2, new ConstantPoolRemapper());

    // Assert that nothing has changed
    assertNull(fullFrame.getProcessingInfo());
  }

  /**
   * Test {@link FullFrame#accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor)}.
   *
   * <ul>
   *   <li>Then {@link FullFrame#FullFrame()} ProcessingInfo is {@code Processing Info}.
   * </ul>
   *
   * <p>Method under test: {@link FullFrame#accept(Clazz, Method, CodeAttribute, int,
   * StackMapFrameVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor); then FullFrame() ProcessingInfo is 'Processing Info'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.FullFrame.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.visitor.StackMapFrameVisitor)"
  })
  void testAccept_thenFullFrameProcessingInfoIsProcessingInfo() {
    // Arrange
    FullFrame fullFrame = new FullFrame();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    fullFrame.accept(clazz, method, codeAttribute, 2, new ProcessingInfoSetter("Processing Info"));

    // Assert
    assertEquals("Processing Info", fullFrame.getProcessingInfo());
  }

  /**
   * Test {@link FullFrame#equals(Object)}, and {@link FullFrame#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FullFrame#equals(Object)}
   *   <li>{@link FullFrame#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.FullFrame.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.FullFrame.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FullFrame fullFrame = new FullFrame();
    FullFrame fullFrame2 = new FullFrame();

    // Act and Assert
    assertEquals(fullFrame, fullFrame2);
    int expectedHashCodeResult = fullFrame.hashCode();
    assertEquals(expectedHashCodeResult, fullFrame2.hashCode());
  }

  /**
   * Test {@link FullFrame#equals(Object)}, and {@link FullFrame#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FullFrame#equals(Object)}
   *   <li>{@link FullFrame#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.FullFrame.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.FullFrame.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FullFrame fullFrame =
        new FullFrame(
            2,
            new VerificationType[] {VerificationTypeFactory.DOUBLE_TYPE},
            new VerificationType[] {VerificationTypeFactory.DOUBLE_TYPE});
    FullFrame fullFrame2 =
        new FullFrame(
            2,
            new VerificationType[] {VerificationTypeFactory.DOUBLE_TYPE},
            new VerificationType[] {VerificationTypeFactory.DOUBLE_TYPE});

    // Act and Assert
    assertEquals(fullFrame, fullFrame2);
    int expectedHashCodeResult = fullFrame.hashCode();
    assertEquals(expectedHashCodeResult, fullFrame2.hashCode());
  }

  /**
   * Test {@link FullFrame#equals(Object)}, and {@link FullFrame#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FullFrame#equals(Object)}
   *   <li>{@link FullFrame#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.FullFrame.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.FullFrame.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FullFrame fullFrame = new FullFrame();

    // Act and Assert
    assertEquals(fullFrame, fullFrame);
    int expectedHashCodeResult = fullFrame.hashCode();
    assertEquals(expectedHashCodeResult, fullFrame.hashCode());
  }

  /**
   * Test {@link FullFrame#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FullFrame#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.FullFrame.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.FullFrame.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FullFrame fullFrame =
        new FullFrame(
            2,
            new VerificationType[] {VerificationTypeFactory.DOUBLE_TYPE},
            new VerificationType[] {VerificationTypeFactory.DOUBLE_TYPE});

    // Act and Assert
    assertNotEquals(fullFrame, new FullFrame());
  }

  /**
   * Test {@link FullFrame#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FullFrame#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.FullFrame.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.FullFrame.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FullFrame fullFrame =
        new FullFrame(
            0,
            new VerificationType[] {VerificationTypeFactory.DOUBLE_TYPE},
            new VerificationType[] {VerificationTypeFactory.DOUBLE_TYPE});

    // Act and Assert
    assertNotEquals(fullFrame, new FullFrame());
  }

  /**
   * Test {@link FullFrame#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FullFrame#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.FullFrame.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.FullFrame.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    FullFrame fullFrame =
        new FullFrame(
            0,
            new VerificationType[] {},
            new VerificationType[] {VerificationTypeFactory.DOUBLE_TYPE});

    // Act and Assert
    assertNotEquals(fullFrame, new FullFrame());
  }

  /**
   * Test {@link FullFrame#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FullFrame#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.FullFrame.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.FullFrame.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    FullFrame fullFrame =
        new FullFrame(
            2,
            new VerificationType[] {VerificationTypeFactory.FLOAT_TYPE},
            new VerificationType[] {VerificationTypeFactory.DOUBLE_TYPE});

    // Act and Assert
    assertNotEquals(
        fullFrame,
        new FullFrame(
            2,
            new VerificationType[] {VerificationTypeFactory.DOUBLE_TYPE},
            new VerificationType[] {VerificationTypeFactory.DOUBLE_TYPE}));
  }

  /**
   * Test {@link FullFrame#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FullFrame#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.FullFrame.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.FullFrame.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    FullFrame fullFrame =
        new FullFrame(
            2,
            new VerificationType[] {VerificationTypeFactory.DOUBLE_TYPE},
            new VerificationType[] {VerificationTypeFactory.FLOAT_TYPE});

    // Act and Assert
    assertNotEquals(
        fullFrame,
        new FullFrame(
            2,
            new VerificationType[] {VerificationTypeFactory.DOUBLE_TYPE},
            new VerificationType[] {VerificationTypeFactory.DOUBLE_TYPE}));
  }

  /**
   * Test {@link FullFrame#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FullFrame#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.FullFrame.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.FullFrame.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FullFrame(), null);
  }

  /**
   * Test {@link FullFrame#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FullFrame#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.FullFrame.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.FullFrame.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FullFrame(), "Different type to FullFrame");
  }

  /**
   * Test {@link FullFrame#toString()}.
   *
   * <ul>
   *   <li>Given {@link FullFrame#FullFrame()}.
   *   <li>Then return {@code [0] Var: , Stack:}.
   * </ul>
   *
   * <p>Method under test: {@link FullFrame#toString()}
   */
  @Test
  @DisplayName("Test toString(); given FullFrame(); then return '[0] Var: , Stack:'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.attribute.preverification.FullFrame.toString()"
  })
  void testToString_givenFullFrame_thenReturn0VarStack() {
    // Arrange, Act and Assert
    assertEquals("[0] Var: , Stack: ", (new FullFrame()).toString());
  }

  /**
   * Test {@link FullFrame#toString()}.
   *
   * <ul>
   *   <li>Then return {@code [2] Var: [d], Stack: [d]}.
   * </ul>
   *
   * <p>Method under test: {@link FullFrame#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '[2] Var: [d], Stack: [d]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.attribute.preverification.FullFrame.toString()"
  })
  void testToString_thenReturn2VarDStackD() {
    // Arrange, Act and Assert
    assertEquals(
        "[2] Var: [d], Stack: [d]",
        (new FullFrame(
                2,
                new VerificationType[] {VerificationTypeFactory.DOUBLE_TYPE},
                new VerificationType[] {VerificationTypeFactory.DOUBLE_TYPE}))
            .toString());
  }
}
