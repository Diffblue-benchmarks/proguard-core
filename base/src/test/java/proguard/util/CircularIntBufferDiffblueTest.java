package proguard.util;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CircularIntBufferDiffblueTest {
  /**
   * Test {@link CircularIntBuffer#CircularIntBuffer(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link CircularIntBuffer#CircularIntBuffer(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CircularIntBuffer.<init>(int)"})
  public void testNewCircularIntBuffer_whenThree_thenReturnSizeIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new CircularIntBuffer(3)).size());
  }

  /**
   * Test {@link CircularIntBuffer#push(int)}.
   *
   * <ul>
   *   <li>Then {@link CircularIntBuffer#CircularIntBuffer(int)} with maxSize is three size is one.
   * </ul>
   *
   * <p>Method under test: {@link CircularIntBuffer#push(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CircularIntBuffer.push(int)"})
  public void testPush_thenCircularIntBufferWithMaxSizeIsThreeSizeIsOne() {
    // Arrange
    CircularIntBuffer circularIntBuffer = new CircularIntBuffer(3);

    // Act
    circularIntBuffer.push(42);

    // Assert
    assertEquals(1, circularIntBuffer.size());
    assertEquals(42, circularIntBuffer.peek());
  }

  /**
   * Test {@link CircularIntBuffer#peek(int)} with {@code int}.
   *
   * <ul>
   *   <li>Given {@link CircularIntBuffer#CircularIntBuffer(int)} with maxSize is three.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CircularIntBuffer#peek(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CircularIntBuffer.peek(int)"})
  public void testPeekWithInt_givenCircularIntBufferWithMaxSizeIsThree_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new CircularIntBuffer(3)).peek(-1));
  }

  /**
   * Test {@link CircularIntBuffer#size()}.
   *
   * <p>Method under test: {@link CircularIntBuffer#size()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CircularIntBuffer.size()"})
  public void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new CircularIntBuffer(3)).size());
  }
}
