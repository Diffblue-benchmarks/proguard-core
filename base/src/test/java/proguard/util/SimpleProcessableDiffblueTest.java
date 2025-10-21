package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SimpleProcessableDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return ProcessingInfo is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SimpleProcessable#SimpleProcessable()}
   *   <li>{@link SimpleProcessable#setProcessingFlags(int)}
   *   <li>{@link SimpleProcessable#getProcessingFlags()}
   *   <li>{@link SimpleProcessable#getProcessingInfo()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SimpleProcessable.<init>()",
    "void SimpleProcessable.<init>(int, Object)",
    "int SimpleProcessable.getProcessingFlags()",
    "Object SimpleProcessable.getProcessingInfo()",
    "void SimpleProcessable.setProcessingFlags(int)"
  })
  public void testGettersAndSetters_thenReturnProcessingInfoIsNull() {
    // Arrange and Act
    SimpleProcessable actualSimpleProcessable = new SimpleProcessable();
    actualSimpleProcessable.setProcessingFlags(1);
    int actualProcessingFlags = actualSimpleProcessable.getProcessingFlags();

    // Assert
    assertNull(actualSimpleProcessable.getProcessingInfo());
    assertEquals(1, actualProcessingFlags);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code Processing Info}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SimpleProcessable#SimpleProcessable(int, Object)}
   *   <li>{@link SimpleProcessable#setProcessingFlags(int)}
   *   <li>{@link SimpleProcessable#getProcessingFlags()}
   *   <li>{@link SimpleProcessable#getProcessingInfo()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SimpleProcessable.<init>()",
    "void SimpleProcessable.<init>(int, Object)",
    "int SimpleProcessable.getProcessingFlags()",
    "Object SimpleProcessable.getProcessingInfo()",
    "void SimpleProcessable.setProcessingFlags(int)"
  })
  public void testGettersAndSetters_whenOne_thenReturnProcessingInfo() {
    // Arrange and Act
    SimpleProcessable actualSimpleProcessable = new SimpleProcessable(1, "Processing Info");
    actualSimpleProcessable.setProcessingFlags(1);
    int actualProcessingFlags = actualSimpleProcessable.getProcessingFlags();

    // Assert
    assertEquals("Processing Info", actualSimpleProcessable.getProcessingInfo());
    assertEquals(1, actualProcessingFlags);
  }

  /**
   * Test {@link SimpleProcessable#addProcessingFlags(int[])}.
   *
   * <p>Method under test: {@link SimpleProcessable#addProcessingFlags(int[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleProcessable.addProcessingFlags(int[])"})
  public void testAddProcessingFlags() {
    // Arrange
    SimpleProcessable simpleProcessable = new SimpleProcessable();

    // Act
    simpleProcessable.addProcessingFlags(2, 1, 2, 1);

    // Assert
    assertEquals(3, simpleProcessable.getProcessingFlags());
  }

  /**
   * Test {@link SimpleProcessable#hasProcessingFlags(int[])}.
   *
   * <ul>
   *   <li>Given {@link SimpleProcessable#SimpleProcessable()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleProcessable#hasProcessingFlags(int[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SimpleProcessable.hasProcessingFlags(int[])"})
  public void testHasProcessingFlags_givenSimpleProcessable_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new SimpleProcessable()).hasProcessingFlags(1, -1, 1, -1));
  }

  /**
   * Test {@link SimpleProcessable#hasProcessingFlags(int[])}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleProcessable#hasProcessingFlags(int[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SimpleProcessable.hasProcessingFlags(int[])"})
  public void testHasProcessingFlags_thenReturnTrue() {
    // Arrange
    SimpleProcessable simpleProcessable = new SimpleProcessable();
    simpleProcessable.addProcessingFlags(-1, 4, 2, 4);

    // Act and Assert
    assertTrue(simpleProcessable.hasProcessingFlags(1, -1, 1, -1));
  }

  /**
   * Test {@link SimpleProcessable#setProcessingInfo(Object)}.
   *
   * <p>Method under test: {@link SimpleProcessable#setProcessingInfo(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleProcessable.setProcessingInfo(Object)"})
  public void testSetProcessingInfo() {
    // Arrange
    SimpleProcessable simpleProcessable = new SimpleProcessable();

    // Act
    simpleProcessable.setProcessingInfo("Processing Info");

    // Assert
    assertEquals("Processing Info", simpleProcessable.getProcessingInfo());
  }
}
