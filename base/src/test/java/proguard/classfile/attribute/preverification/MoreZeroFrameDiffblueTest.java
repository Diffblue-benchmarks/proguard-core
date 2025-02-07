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

class MoreZeroFrameDiffblueTest {
  /**
   * Test {@link MoreZeroFrame#MoreZeroFrame()}.
   *
   * <p>Method under test: {@link MoreZeroFrame#MoreZeroFrame()}
   */
  @Test
  @DisplayName("Test new MoreZeroFrame()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.MoreZeroFrame.<init>()",
    "void proguard.classfile.attribute.preverification.MoreZeroFrame.<init>(int, proguard.classfile.attribute.preverification.VerificationType[])"
  })
  void testNewMoreZeroFrame() {
    // Arrange and Act
    MoreZeroFrame actualMoreZeroFrame = new MoreZeroFrame();

    // Assert
    assertNull(actualMoreZeroFrame.getProcessingInfo());
    assertEquals(0, actualMoreZeroFrame.getOffsetDelta());
    assertEquals(0, actualMoreZeroFrame.getProcessingFlags());
  }

  /**
   * Test {@link MoreZeroFrame#MoreZeroFrame(int)}.
   *
   * <p>Method under test: {@link MoreZeroFrame#MoreZeroFrame(int)}
   */
  @Test
  @DisplayName("Test new MoreZeroFrame(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.attribute.preverification.MoreZeroFrame.<init>(int)"})
  void testNewMoreZeroFrame2() {
    // Arrange and Act
    MoreZeroFrame actualMoreZeroFrame = new MoreZeroFrame(1);

    // Assert
    assertNull(actualMoreZeroFrame.additionalVariables);
    assertNull(actualMoreZeroFrame.getProcessingInfo());
    assertEquals(-250, actualMoreZeroFrame.additionalVariablesCount);
    assertEquals(0, actualMoreZeroFrame.getOffsetDelta());
    assertEquals(0, actualMoreZeroFrame.getProcessingFlags());
    assertEquals(1, actualMoreZeroFrame.getTag());
  }

  /**
   * Test {@link MoreZeroFrame#MoreZeroFrame(int, VerificationType[])}.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link MoreZeroFrame#MoreZeroFrame(int, VerificationType[])}
   */
  @Test
  @DisplayName("Test new MoreZeroFrame(int, VerificationType[]); when three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.MoreZeroFrame.<init>()",
    "void proguard.classfile.attribute.preverification.MoreZeroFrame.<init>(int, proguard.classfile.attribute.preverification.VerificationType[])"
  })
  void testNewMoreZeroFrame_whenThree() {
    // Arrange and Act
    MoreZeroFrame actualMoreZeroFrame =
        new MoreZeroFrame(3, new VerificationType[] {VerificationTypeFactory.DOUBLE_TYPE});

    // Assert
    assertNull(actualMoreZeroFrame.getProcessingInfo());
    assertEquals(0, actualMoreZeroFrame.getOffsetDelta());
    assertEquals(0, actualMoreZeroFrame.getProcessingFlags());
  }

  /**
   * Test {@link MoreZeroFrame#getTag()}.
   *
   * <p>Method under test: {@link MoreZeroFrame#getTag()}
   */
  @Test
  @DisplayName("Test getTag()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.attribute.preverification.MoreZeroFrame.getTag()"})
  void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(1, (new MoreZeroFrame(1)).getTag());
  }

  /**
   * Test {@link MoreZeroFrame#accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor)}.
   *
   * <p>Method under test: {@link MoreZeroFrame#accept(Clazz, Method, CodeAttribute, int,
   * StackMapFrameVisitor)}
   */
  @Test
  @DisplayName("Test accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.MoreZeroFrame.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.visitor.StackMapFrameVisitor)"
  })
  void testAccept() {
    // Arrange
    MoreZeroFrame moreZeroFrame =
        new MoreZeroFrame(new VerificationType[] {VerificationTypeFactory.DOUBLE_TYPE});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    moreZeroFrame.accept(clazz, method, codeAttribute, 2, new ConstantPoolRemapper());

    // Assert that nothing has changed
    assertNull(moreZeroFrame.getProcessingInfo());
  }

  /**
   * Test {@link MoreZeroFrame#accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor)}.
   *
   * <ul>
   *   <li>Then {@link MoreZeroFrame#MoreZeroFrame(int)} with tag is one ProcessingInfo is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link MoreZeroFrame#accept(Clazz, Method, CodeAttribute, int,
   * StackMapFrameVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor); then MoreZeroFrame(int) with tag is one ProcessingInfo is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.MoreZeroFrame.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.visitor.StackMapFrameVisitor)"
  })
  void testAccept_thenMoreZeroFrameWithTagIsOneProcessingInfoIsNull() {
    // Arrange
    MoreZeroFrame moreZeroFrame = new MoreZeroFrame(1);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    moreZeroFrame.accept(clazz, method, codeAttribute, 2, new ConstantPoolRemapper());

    // Assert that nothing has changed
    assertNull(moreZeroFrame.getProcessingInfo());
  }

  /**
   * Test {@link MoreZeroFrame#accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor)}.
   *
   * <ul>
   *   <li>Then {@link MoreZeroFrame#MoreZeroFrame(int)} with tag is one ProcessingInfo is {@code
   *       Processing Info}.
   * </ul>
   *
   * <p>Method under test: {@link MoreZeroFrame#accept(Clazz, Method, CodeAttribute, int,
   * StackMapFrameVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor); then MoreZeroFrame(int) with tag is one ProcessingInfo is 'Processing Info'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.MoreZeroFrame.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.visitor.StackMapFrameVisitor)"
  })
  void testAccept_thenMoreZeroFrameWithTagIsOneProcessingInfoIsProcessingInfo() {
    // Arrange
    MoreZeroFrame moreZeroFrame = new MoreZeroFrame(1);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    moreZeroFrame.accept(
        clazz, method, codeAttribute, 2, new ProcessingInfoSetter("Processing Info"));

    // Assert
    assertEquals("Processing Info", moreZeroFrame.getProcessingInfo());
  }

  /**
   * Test {@link MoreZeroFrame#equals(Object)}, and {@link MoreZeroFrame#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MoreZeroFrame#equals(Object)}
   *   <li>{@link MoreZeroFrame#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.MoreZeroFrame.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.MoreZeroFrame.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MoreZeroFrame moreZeroFrame = new MoreZeroFrame(1);
    MoreZeroFrame moreZeroFrame2 = new MoreZeroFrame(1);

    // Act and Assert
    assertEquals(moreZeroFrame, moreZeroFrame2);
    int expectedHashCodeResult = moreZeroFrame.hashCode();
    assertEquals(expectedHashCodeResult, moreZeroFrame2.hashCode());
  }

  /**
   * Test {@link MoreZeroFrame#equals(Object)}, and {@link MoreZeroFrame#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MoreZeroFrame#equals(Object)}
   *   <li>{@link MoreZeroFrame#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.MoreZeroFrame.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.MoreZeroFrame.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MoreZeroFrame moreZeroFrame = new MoreZeroFrame(1);

    // Act and Assert
    assertEquals(moreZeroFrame, moreZeroFrame);
    int expectedHashCodeResult = moreZeroFrame.hashCode();
    assertEquals(expectedHashCodeResult, moreZeroFrame.hashCode());
  }

  /**
   * Test {@link MoreZeroFrame#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MoreZeroFrame#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.MoreZeroFrame.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.MoreZeroFrame.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MoreZeroFrame moreZeroFrame = new MoreZeroFrame(-250);

    // Act and Assert
    assertNotEquals(moreZeroFrame, new MoreZeroFrame(1));
  }

  /**
   * Test {@link MoreZeroFrame#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MoreZeroFrame#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.MoreZeroFrame.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.MoreZeroFrame.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MoreZeroFrame(1), null);
  }

  /**
   * Test {@link MoreZeroFrame#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MoreZeroFrame#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.MoreZeroFrame.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.MoreZeroFrame.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MoreZeroFrame(1), "Different type to MoreZeroFrame");
  }

  /**
   * Test {@link MoreZeroFrame#toString()}.
   *
   * <ul>
   *   <li>Given {@link MoreZeroFrame#MoreZeroFrame(int)} with tag is one.
   *   <li>Then return {@code [0] Var: ..., Stack: (empty)}.
   * </ul>
   *
   * <p>Method under test: {@link MoreZeroFrame#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given MoreZeroFrame(int) with tag is one; then return '[0] Var: ..., Stack: (empty)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.attribute.preverification.MoreZeroFrame.toString()"
  })
  void testToString_givenMoreZeroFrameWithTagIsOne_thenReturn0VarStackEmpty() {
    // Arrange, Act and Assert
    assertEquals("[0] Var: ..., Stack: (empty)", (new MoreZeroFrame(1)).toString());
  }

  /**
   * Test {@link MoreZeroFrame#toString()}.
   *
   * <ul>
   *   <li>Then return {@code [0] Var: ...[d], Stack: (empty)}.
   * </ul>
   *
   * <p>Method under test: {@link MoreZeroFrame#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '[0] Var: ...[d], Stack: (empty)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.attribute.preverification.MoreZeroFrame.toString()"
  })
  void testToString_thenReturn0VarDStackEmpty() {
    // Arrange, Act and Assert
    assertEquals(
        "[0] Var: ...[d], Stack: (empty)",
        (new MoreZeroFrame(new VerificationType[] {VerificationTypeFactory.DOUBLE_TYPE}))
            .toString());
  }
}
