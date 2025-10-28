package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class LessZeroFrameDiffblueTest {
  /**
   * Method under test: {@link LessZeroFrame#getTag()}
   */
  @Test
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(186, (new LessZeroFrame((byte) 'A')).getTag());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LessZeroFrame#equals(Object)}
   *   <li>{@link LessZeroFrame#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link LessZeroFrame#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LessZeroFrame lessZeroFrame = new LessZeroFrame((byte) 'A');

    // Act and Assert
    assertNotEquals(lessZeroFrame, new LessZeroFrame((byte) 'A'));
  }

  /**
   * Method under test: {@link LessZeroFrame#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LessZeroFrame((byte) 'A'), null);
  }

  /**
   * Method under test: {@link LessZeroFrame#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsSame_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LessZeroFrame((byte) 'A'), new LessZeroFrame((byte) 'A'));
  }

  /**
   * Method under test: {@link LessZeroFrame#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LessZeroFrame((byte) 'A'), "Different type to LessZeroFrame");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LessZeroFrame#LessZeroFrame()}
   *   <li>{@link LessZeroFrame#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    LessZeroFrame actualLessZeroFrame = new LessZeroFrame();

    // Assert
    assertEquals("[0] Var: (chopped 0), Stack: (empty)", actualLessZeroFrame.toString());
    assertNull(actualLessZeroFrame.getProcessingInfo());
    assertEquals(0, actualLessZeroFrame.getOffsetDelta());
    assertEquals(0, actualLessZeroFrame.getProcessingFlags());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LessZeroFrame#LessZeroFrame(byte)}
   *   <li>{@link LessZeroFrame#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    LessZeroFrame actualLessZeroFrame = new LessZeroFrame((byte) 'A');

    // Assert
    assertEquals("[0] Var: (chopped 65), Stack: (empty)", actualLessZeroFrame.toString());
    assertNull(actualLessZeroFrame.getProcessingInfo());
    assertEquals(0, actualLessZeroFrame.getOffsetDelta());
    assertEquals(0, actualLessZeroFrame.getProcessingFlags());
  }

  /**
   * Method under test: {@link LessZeroFrame#LessZeroFrame(int)}
   */
  @Test
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
}
