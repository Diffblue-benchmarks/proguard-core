package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SimpleProcessableDiffblueTest {
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
  @DisplayName("Test getters and setters; then return ProcessingInfo is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleProcessable.<init>()",
    "void SimpleProcessable.<init>(int, Object)",
    "int SimpleProcessable.getProcessingFlags()",
    "Object SimpleProcessable.getProcessingInfo()",
    "void SimpleProcessable.setProcessingFlags(int)"
  })
  void testGettersAndSetters_thenReturnProcessingInfoIsNull() {
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
  @DisplayName("Test getters and setters; when one; then return 'Processing Info'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleProcessable.<init>()",
    "void SimpleProcessable.<init>(int, Object)",
    "int SimpleProcessable.getProcessingFlags()",
    "Object SimpleProcessable.getProcessingInfo()",
    "void SimpleProcessable.setProcessingFlags(int)"
  })
  void testGettersAndSetters_whenOne_thenReturnProcessingInfo() {
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
  @DisplayName("Test addProcessingFlags(int[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleProcessable.addProcessingFlags(int[])"})
  void testAddProcessingFlags() {
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
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleProcessable#hasProcessingFlags(int[])}
   */
  @Test
  @DisplayName("Test hasProcessingFlags(int[]); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SimpleProcessable.hasProcessingFlags(int[])"})
  void testHasProcessingFlags_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new SimpleProcessable().hasProcessingFlags());
  }

  /**
   * Test {@link SimpleProcessable#hasProcessingFlags(int[])}.
   *
   * <ul>
   *   <li>When one and minus one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleProcessable#hasProcessingFlags(int[])}
   */
  @Test
  @DisplayName("Test hasProcessingFlags(int[]); when one and minus one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SimpleProcessable.hasProcessingFlags(int[])"})
  void testHasProcessingFlags_whenOneAndMinusOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new SimpleProcessable().hasProcessingFlags(1, -1, 1, -1));
  }

  /**
   * Test {@link SimpleProcessable#setProcessingInfo(Object)}.
   *
   * <p>Method under test: {@link SimpleProcessable#setProcessingInfo(Object)}
   */
  @Test
  @DisplayName("Test setProcessingInfo(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleProcessable.setProcessingInfo(Object)"})
  void testSetProcessingInfo() {
    // Arrange
    SimpleProcessable simpleProcessable = new SimpleProcessable();

    // Act
    simpleProcessable.setProcessingInfo("Processing Info");

    // Assert
    assertEquals("Processing Info", simpleProcessable.getProcessingInfo());
  }
}
