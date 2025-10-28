package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SimpleProcessableDiffblueTest {
  /**
   * Method under test: {@link SimpleProcessable#addProcessingFlags(int[])}
   */
  @Test
  public void testAddProcessingFlags() {
    // Arrange
    SimpleProcessable simpleProcessable = new SimpleProcessable();

    // Act
    simpleProcessable.addProcessingFlags(2, 1, 2, 1);

    // Assert
    assertEquals(3, simpleProcessable.getProcessingFlags());
  }

  /**
   * Method under test: {@link SimpleProcessable#hasProcessingFlags(int[])}
   */
  @Test
  public void testHasProcessingFlags() {
    // Arrange, Act and Assert
    assertFalse((new SimpleProcessable()).hasProcessingFlags(1, -1, 1, -1));
  }

  /**
   * Method under test: {@link SimpleProcessable#hasProcessingFlags(int[])}
   */
  @Test
  public void testHasProcessingFlags2() {
    // Arrange
    SimpleProcessable simpleProcessable = new SimpleProcessable();
    simpleProcessable.addProcessingFlags(-1, 4, 2, 4);

    // Act and Assert
    assertTrue(simpleProcessable.hasProcessingFlags(1, -1, 1, -1));
  }

  /**
   * Method under test: {@link SimpleProcessable#setProcessingInfo(Object)}
   */
  @Test
  public void testSetProcessingInfo() {
    // Arrange
    SimpleProcessable simpleProcessable = new SimpleProcessable();

    // Act
    simpleProcessable.setProcessingInfo("Processing Info");

    // Assert
    assertEquals("Processing Info", simpleProcessable.getProcessingInfo());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SimpleProcessable#SimpleProcessable()}
   *   <li>{@link SimpleProcessable#setProcessingFlags(int)}
   *   <li>{@link SimpleProcessable#getProcessingFlags()}
   *   <li>{@link SimpleProcessable#getProcessingInfo()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SimpleProcessable actualSimpleProcessable = new SimpleProcessable();
    actualSimpleProcessable.setProcessingFlags(1);
    int actualProcessingFlags = actualSimpleProcessable.getProcessingFlags();
    actualSimpleProcessable.getProcessingInfo();

    // Assert that nothing has changed
    assertEquals(1, actualProcessingFlags);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SimpleProcessable#SimpleProcessable(int, Object)}
   *   <li>{@link SimpleProcessable#setProcessingFlags(int)}
   *   <li>{@link SimpleProcessable#getProcessingFlags()}
   *   <li>{@link SimpleProcessable#getProcessingInfo()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    SimpleProcessable actualSimpleProcessable = new SimpleProcessable(1, "Processing Info");
    actualSimpleProcessable.setProcessingFlags(1);
    int actualProcessingFlags = actualSimpleProcessable.getProcessingFlags();

    // Assert that nothing has changed
    assertEquals("Processing Info", actualSimpleProcessable.getProcessingInfo());
    assertEquals(1, actualProcessingFlags);
  }
}
