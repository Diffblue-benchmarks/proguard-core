package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SameZeroFrameDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SameZeroFrame#SameZeroFrame()}
   *   <li>{@link SameZeroFrame#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SameZeroFrame.<init>()", "java.lang.String SameZeroFrame.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    SameZeroFrame actualSameZeroFrame = new SameZeroFrame();

    // Assert
    assertEquals("[0] Var: ..., Stack: (empty)", actualSameZeroFrame.toString());
    assertNull(actualSameZeroFrame.getProcessingInfo());
    assertEquals(0, actualSameZeroFrame.getOffsetDelta());
    assertEquals(0, actualSameZeroFrame.getProcessingFlags());
  }

  /**
   * Test {@link SameZeroFrame#SameZeroFrame(int)}.
   *
   * <p>Method under test: {@link SameZeroFrame#SameZeroFrame(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SameZeroFrame.<init>(int)"})
  public void testNewSameZeroFrame() {
    // Arrange and Act
    SameZeroFrame actualSameZeroFrame = new SameZeroFrame(1);

    // Assert
    assertNull(actualSameZeroFrame.getProcessingInfo());
    assertEquals(0, actualSameZeroFrame.getProcessingFlags());
    assertEquals(1, actualSameZeroFrame.getTag());
    assertEquals(1, actualSameZeroFrame.getOffsetDelta());
  }

  /**
   * Test {@link SameZeroFrame#getTag()}.
   *
   * <ul>
   *   <li>Given {@link SameZeroFrame#SameZeroFrame(int)} with tag is one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SameZeroFrame#getTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SameZeroFrame.getTag()"})
  public void testGetTag_givenSameZeroFrameWithTagIsOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, (new SameZeroFrame(1)).getTag());
  }

  /**
   * Test {@link SameZeroFrame#getTag()}.
   *
   * <ul>
   *   <li>Then return {@link StackMapFrame#SAME_ZERO_FRAME_EXTENDED}.
   * </ul>
   *
   * <p>Method under test: {@link SameZeroFrame#getTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SameZeroFrame.getTag()"})
  public void testGetTag_thenReturnSame_zero_frame_extended() {
    // Arrange
    SameZeroFrame sameZeroFrame = new SameZeroFrame(1);
    sameZeroFrame.u2offsetDelta = StackMapFrame.SAME_ONE_FRAME;

    // Act and Assert
    assertEquals(StackMapFrame.SAME_ZERO_FRAME_EXTENDED, sameZeroFrame.getTag());
  }
}
