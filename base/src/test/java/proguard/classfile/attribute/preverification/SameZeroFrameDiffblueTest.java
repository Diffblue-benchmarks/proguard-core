package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class SameZeroFrameDiffblueTest {
  /**
   * Method under test: {@link SameZeroFrame#getTag()}
   */
  @Test
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(1, (new SameZeroFrame(1)).getTag());
  }

  /**
   * Method under test: {@link SameZeroFrame#getTag()}
   */
  @Test
  public void testGetTag2() {
    // Arrange
    SameZeroFrame sameZeroFrame = new SameZeroFrame(1);
    sameZeroFrame.u2offsetDelta = StackMapFrame.SAME_ONE_FRAME;

    // Act and Assert
    assertEquals(StackMapFrame.SAME_ZERO_FRAME_EXTENDED, sameZeroFrame.getTag());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SameZeroFrame#SameZeroFrame()}
   *   <li>{@link SameZeroFrame#toString()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link SameZeroFrame#SameZeroFrame(int)}
   */
  @Test
  public void testNewSameZeroFrame() {
    // Arrange and Act
    SameZeroFrame actualSameZeroFrame = new SameZeroFrame(1);

    // Assert
    assertNull(actualSameZeroFrame.getProcessingInfo());
    assertEquals(0, actualSameZeroFrame.getProcessingFlags());
    assertEquals(1, actualSameZeroFrame.getTag());
    assertEquals(1, actualSameZeroFrame.getOffsetDelta());
  }
}
