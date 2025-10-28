package proguard.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CircularIntBufferDiffblueTest {
  /**
   * Method under test: {@link CircularIntBuffer#push(int)}
   */
  @Test
  public void testPush() {
    // Arrange
    CircularIntBuffer circularIntBuffer = new CircularIntBuffer(3);

    // Act
    circularIntBuffer.push(42);

    // Assert
    assertEquals(1, circularIntBuffer.size());
    assertEquals(42, circularIntBuffer.peek());
  }

  /**
   * Method under test: {@link CircularIntBuffer#peek(int)}
   */
  @Test
  public void testPeek() {
    // Arrange, Act and Assert
    assertEquals(0, (new CircularIntBuffer(3)).peek(-1));
  }

  /**
   * Method under test: {@link CircularIntBuffer#CircularIntBuffer(int)}
   */
  @Test
  public void testNewCircularIntBuffer() {
    // Arrange, Act and Assert
    assertEquals(0, (new CircularIntBuffer(3)).size());
  }

  /**
   * Method under test: {@link CircularIntBuffer#size()}
   */
  @Test
  public void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new CircularIntBuffer(3)).size());
  }
}
