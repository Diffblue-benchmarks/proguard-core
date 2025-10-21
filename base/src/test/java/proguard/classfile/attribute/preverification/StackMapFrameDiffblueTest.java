package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StackMapFrameDiffblueTest {
  /**
   * Test {@link StackMapFrame#getOffsetDelta()}.
   *
   * <p>Method under test: {@link StackMapFrame#getOffsetDelta()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int StackMapFrame.getOffsetDelta()"})
  public void testGetOffsetDelta() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StackMapFrame.equals(Object)", "int StackMapFrame.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StackMapFrame.equals(Object)", "int StackMapFrame.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StackMapFrame.equals(Object)", "int StackMapFrame.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StackMapFrame.equals(Object)", "int StackMapFrame.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StackMapFrame.equals(Object)", "int StackMapFrame.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FullFrame(), "Different type to StackMapFrame");
  }

  /**
   * Test {@link StackMapFrame#toString()}.
   *
   * <p>Method under test: {@link StackMapFrame#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String StackMapFrame.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("[0] Var: , Stack: ", (new FullFrame()).toString());
  }
}
