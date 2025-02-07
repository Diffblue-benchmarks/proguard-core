package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.util.SimpleProcessable.<init>()",
    "void proguard.util.SimpleProcessable.<init>(int, java.lang.Object)",
    "int proguard.util.SimpleProcessable.getProcessingFlags()",
    "java.lang.Object proguard.util.SimpleProcessable.getProcessingInfo()",
    "void proguard.util.SimpleProcessable.setProcessingFlags(int)"
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.util.SimpleProcessable.<init>()",
    "void proguard.util.SimpleProcessable.<init>(int, java.lang.Object)",
    "int proguard.util.SimpleProcessable.getProcessingFlags()",
    "java.lang.Object proguard.util.SimpleProcessable.getProcessingInfo()",
    "void proguard.util.SimpleProcessable.setProcessingFlags(int)"
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.SimpleProcessable.addProcessingFlags(int[])"})
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
   *   <li>Given {@link SimpleProcessable#SimpleProcessable()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleProcessable#hasProcessingFlags(int[])}
   */
  @Test
  @DisplayName("Test hasProcessingFlags(int[]); given SimpleProcessable(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.SimpleProcessable.hasProcessingFlags(int[])"})
  void testHasProcessingFlags_givenSimpleProcessable_thenReturnFalse() {
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
  @DisplayName("Test hasProcessingFlags(int[]); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.SimpleProcessable.hasProcessingFlags(int[])"})
  void testHasProcessingFlags_thenReturnTrue() {
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
  @DisplayName("Test setProcessingInfo(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.util.SimpleProcessable.setProcessingInfo(java.lang.Object)"})
  void testSetProcessingInfo() {
    // Arrange
    SimpleProcessable simpleProcessable = new SimpleProcessable();

    // Act
    simpleProcessable.setProcessingInfo("Processing Info");

    // Assert
    assertEquals("Processing Info", simpleProcessable.getProcessingInfo());
  }
}
