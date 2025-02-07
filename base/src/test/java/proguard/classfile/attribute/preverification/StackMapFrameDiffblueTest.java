package proguard.classfile.attribute.preverification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StackMapFrameDiffblueTest {
  /**
   * Test {@link StackMapFrame#getOffsetDelta()}.
   *
   * <p>Method under test: {@link StackMapFrame#getOffsetDelta()}
   */
  @Test
  @DisplayName("Test getOffsetDelta()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.preverification.StackMapFrame.getOffsetDelta()"
  })
  void testGetOffsetDelta() {
    // Arrange, Act and Assert
    assertEquals(0, (new FullFrame()).getOffsetDelta());
  }

  /**
   * Test {@link StackMapFrame#equals(Object)}, and {@link StackMapFrame#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link StackMapFrame#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.StackMapFrame.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.StackMapFrame.hashCode()"
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
   * Test {@link StackMapFrame#equals(Object)}, and {@link StackMapFrame#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link StackMapFrame#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.StackMapFrame.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.StackMapFrame.hashCode()"
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
   * Test {@link StackMapFrame#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StackMapFrame#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.StackMapFrame.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.StackMapFrame.hashCode()"
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
   * Test {@link StackMapFrame#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StackMapFrame#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.StackMapFrame.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.StackMapFrame.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FullFrame(), null);
  }

  /**
   * Test {@link StackMapFrame#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StackMapFrame#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.attribute.preverification.StackMapFrame.equals(java.lang.Object)",
    "int proguard.classfile.attribute.preverification.StackMapFrame.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FullFrame(), "Different type to StackMapFrame");
  }

  /**
   * Test {@link StackMapFrame#toString()}.
   *
   * <p>Method under test: {@link StackMapFrame#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.attribute.preverification.StackMapFrame.toString()"
  })
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("[0] Var: , Stack: ", (new FullFrame()).toString());
  }
}
