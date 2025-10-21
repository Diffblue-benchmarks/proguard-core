package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LessZeroFrameDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LessZeroFrame.<init>()",
    "void LessZeroFrame.<init>(byte)",
    "java.lang.String LessZeroFrame.toString()"
  })
  public void testGettersAndSetters_thenReturnToStringIs0VarChopped0StackEmpty() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LessZeroFrame.<init>()",
    "void LessZeroFrame.<init>(byte)",
    "java.lang.String LessZeroFrame.toString()"
  })
  public void testGettersAndSetters_whenA_thenReturnToStringIs0VarChopped65StackEmpty() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LessZeroFrame.<init>(int)"})
  public void testNewLessZeroFrame() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LessZeroFrame.getTag()"})
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(186, (new LessZeroFrame((byte) 'A')).getTag());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LessZeroFrame.equals(Object)", "int LessZeroFrame.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LessZeroFrame.equals(Object)", "int LessZeroFrame.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LessZeroFrame.equals(Object)", "int LessZeroFrame.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LessZeroFrame.equals(Object)", "int LessZeroFrame.hashCode()"})
  public void testEquals_whenOtherIsSame_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LessZeroFrame.equals(Object)", "int LessZeroFrame.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LessZeroFrame((byte) 'A'), "Different type to LessZeroFrame");
  }
}
