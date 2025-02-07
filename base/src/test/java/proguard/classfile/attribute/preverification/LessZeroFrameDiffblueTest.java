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
import proguard.classfile.attribute.preverification.visitor.StackMapFrameVisitor;
import proguard.classfile.editor.CodeAttributeComposer;

class LessZeroFrameDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code [0] Var: (chopped 0), Stack: (empty)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LessZeroFrame#LessZeroFrame()}
   *   <li>{@link LessZeroFrame#toString()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; then return toString is '[0] Var: (chopped 0), Stack: (empty)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.LessZeroFrame.<init>()",
    "void proguard.classfile.attribute.preverification.LessZeroFrame.<init>(byte)",
    "java.lang.String proguard.classfile.attribute.preverification.LessZeroFrame.toString()"
  })
  void testGettersAndSetters_thenReturnToStringIs0VarChopped0StackEmpty() {
    // Arrange and Act
    LessZeroFrame actualLessZeroFrame = new LessZeroFrame();

    // Assert
    assertEquals("[0] Var: (chopped 0), Stack: (empty)", actualLessZeroFrame.toString());
    assertNull(actualLessZeroFrame.getProcessingInfo());
    assertEquals(0, actualLessZeroFrame.getOffsetDelta());
    assertEquals(0, actualLessZeroFrame.getProcessingFlags());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return toString is {@code [0] Var: (chopped 65), Stack: (empty)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LessZeroFrame#LessZeroFrame(byte)}
   *   <li>{@link LessZeroFrame#toString()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'A'; then return toString is '[0] Var: (chopped 65), Stack: (empty)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.LessZeroFrame.<init>()",
    "void proguard.classfile.attribute.preverification.LessZeroFrame.<init>(byte)",
    "java.lang.String proguard.classfile.attribute.preverification.LessZeroFrame.toString()"
  })
  void testGettersAndSetters_whenA_thenReturnToStringIs0VarChopped65StackEmpty() {
    // Arrange and Act
    LessZeroFrame actualLessZeroFrame = new LessZeroFrame((byte) 'A');

    // Assert
    assertEquals("[0] Var: (chopped 65), Stack: (empty)", actualLessZeroFrame.toString());
    assertNull(actualLessZeroFrame.getProcessingInfo());
    assertEquals(0, actualLessZeroFrame.getOffsetDelta());
    assertEquals(0, actualLessZeroFrame.getProcessingFlags());
  }

  /**
   * Test {@link LessZeroFrame#LessZeroFrame(int)}.
   *
   * <p>Method under test: {@link LessZeroFrame#LessZeroFrame(int)}
   */
  @Test
  @DisplayName("Test new LessZeroFrame(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.attribute.preverification.LessZeroFrame.<init>(int)"})
  void testNewLessZeroFrame() {
    // Arrange and Act
    LessZeroFrame actualLessZeroFrame = new LessZeroFrame(1);

    // Assert
    assertNull(actualLessZeroFrame.getProcessingInfo());
    assertEquals(0, actualLessZeroFrame.getOffsetDelta());
    assertEquals(0, actualLessZeroFrame.getProcessingFlags());
    assertEquals(1, actualLessZeroFrame.getTag());
    assertEquals(250, actualLessZeroFrame.choppedVariablesCount);
  }

  /**
   * Test {@link LessZeroFrame#getTag()}.
   *
   * <p>Method under test: {@link LessZeroFrame#getTag()}
   */
  @Test
  @DisplayName("Test getTag()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.attribute.preverification.LessZeroFrame.getTag()"})
  void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(186, (new LessZeroFrame((byte) 'A')).getTag());
  }

  /**
   * Test {@link LessZeroFrame#accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link StackMapFrameVisitor#visitLessZeroFrame(Clazz, Method, CodeAttribute,
   *       int, LessZeroFrame)}.
   * </ul>
   *
   * <p>Method under test: {@link LessZeroFrame#accept(Clazz, Method, CodeAttribute, int,
   * StackMapFrameVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, CodeAttribute, int, StackMapFrameVisitor); then calls visitLessZeroFrame(Clazz, Method, CodeAttribute, int, LessZeroFrame)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.preverification.LessZeroFrame.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.visitor.StackMapFrameVisitor)"
  })
  void testAccept_thenCallsVisitLessZeroFrame() {
    // Arrange
    LessZeroFrame lessZeroFrame = new LessZeroFrame((byte) 'A');
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    CodeAttributeComposer stackMapFrameVisitor = mock(CodeAttributeComposer.class);
    doNothing()
        .when(stackMapFrameVisitor)
        .visitLessZeroFrame(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            Mockito.<LessZeroFrame>any());

    // Act
    lessZeroFrame.accept(clazz, method, codeAttribute, 2, stackMapFrameVisitor);

    // Assert
    verify(stackMapFrameVisitor)
        .visitLessZeroFrame(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(2),
            isA(LessZeroFrame.class));
  }

  /**
   * Test {@link LessZeroFrame#equals(Object)}, and {@link LessZeroFrame#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LessZeroFrame#equals(Object)}
   *   <li>{@link LessZeroFrame#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.LessZeroFrame.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.LessZeroFrame.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LessZeroFrame lessZeroFrame = new LessZeroFrame((byte) 1);
    LessZeroFrame lessZeroFrame2 = new LessZeroFrame((byte) 'A');

    // Act and Assert
    assertEquals(lessZeroFrame, lessZeroFrame2);
    int notExpectedHashCodeResult = lessZeroFrame.hashCode();
    assertNotEquals(notExpectedHashCodeResult, lessZeroFrame2.hashCode());
  }

  /**
   * Test {@link LessZeroFrame#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LessZeroFrame#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.LessZeroFrame.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.LessZeroFrame.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LessZeroFrame lessZeroFrame = new LessZeroFrame((byte) 'A');

    // Act and Assert
    assertNotEquals(lessZeroFrame, new LessZeroFrame((byte) 'A'));
  }

  /**
   * Test {@link LessZeroFrame#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LessZeroFrame#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.LessZeroFrame.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.LessZeroFrame.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LessZeroFrame((byte) 'A'), null);
  }

  /**
   * Test {@link LessZeroFrame#equals(Object)}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LessZeroFrame#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is same; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.LessZeroFrame.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.LessZeroFrame.hashCode()"
  })
  void testEquals_whenOtherIsSame_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LessZeroFrame((byte) 'A'), new LessZeroFrame((byte) 'A'));
  }

  /**
   * Test {@link LessZeroFrame#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LessZeroFrame#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.LessZeroFrame.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.LessZeroFrame.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LessZeroFrame((byte) 'A'), "Different type to LessZeroFrame");
  }
}
