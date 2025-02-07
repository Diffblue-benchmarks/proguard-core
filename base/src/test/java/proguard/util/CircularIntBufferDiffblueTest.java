package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CircularIntBufferDiffblueTest {
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
  @DisplayName("Test new CircularIntBuffer(int); when three; then return size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.CircularIntBuffer.<init>(int)"})
  void testNewCircularIntBuffer_whenThree_thenReturnSizeIsZero() {
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
  @DisplayName("Test push(int); then CircularIntBuffer(int) with maxSize is three size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.CircularIntBuffer.push(int)"})
  void testPush_thenCircularIntBufferWithMaxSizeIsThreeSizeIsOne() {
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
  @DisplayName(
      "Test peek(int) with 'int'; given CircularIntBuffer(int) with maxSize is three; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.CircularIntBuffer.peek(int)"})
  void testPeekWithInt_givenCircularIntBufferWithMaxSizeIsThree_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new CircularIntBuffer(3)).peek(-1));
  }

  /**
   * Test {@link CircularIntBuffer#size()}.
   *
   * <p>Method under test: {@link CircularIntBuffer#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.util.CircularIntBuffer.size()"})
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new CircularIntBuffer(3)).size());
  }
}
