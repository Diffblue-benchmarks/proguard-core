package proguard.dexfile.ir;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UtilDiffblueTest {
  /**
   * Test {@link Util#listDesc(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link Util#listDesc(String)}
   */
  @Test
  @DisplayName("Test listDesc(String); when empty string; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List proguard.dexfile.ir.Util.listDesc(java.lang.String)"})
  void testListDesc_whenEmptyString_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualListDescResult = Util.listDesc("");

    // Assert
    assertTrue(actualListDescResult.isEmpty());
  }

  /**
   * Test {@link Util#appendString(StringBuffer, String)}.
   *
   * <ul>
   *   <li>When {@code \"}.
   *   <li>Then {@link StringBuffer#StringBuffer(String)} with {@code foo} toString is {@code
   *       foo"\\\""}.
   * </ul>
   *
   * <p>Method under test: {@link Util#appendString(StringBuffer, String)}
   */
  @Test
  @DisplayName(
      "Test appendString(StringBuffer, String); when '\\\"'; then StringBuffer(String) with 'foo' toString is 'foo\"\\\\\\\"\"'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.Util.appendString(java.lang.StringBuffer, java.lang.String)"
  })
  void testAppendString_whenBackslashQuotationMark_thenStringBufferWithFooToStringIsFoo() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    Util.appendString(buf, "\\\"");

    // Assert
    assertEquals("foo\"\\\\\\\"\"", buf.toString());
  }

  /**
   * Test {@link Util#appendString(StringBuffer, String)}.
   *
   * <ul>
   *   <li>When {@link StringBuffer#StringBuffer(String)} with {@code foo}.
   *   <li>Then {@link StringBuffer#StringBuffer(String)} with {@code foo} toString is {@code
   *       foo"foo"}.
   * </ul>
   *
   * <p>Method under test: {@link Util#appendString(StringBuffer, String)}
   */
  @Test
  @DisplayName(
      "Test appendString(StringBuffer, String); when StringBuffer(String) with 'foo'; then StringBuffer(String) with 'foo' toString is 'foo\"foo\"'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.Util.appendString(java.lang.StringBuffer, java.lang.String)"
  })
  void testAppendString_whenStringBufferWithFoo_thenStringBufferWithFooToStringIsFooFoo() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    Util.appendString(buf, "foo");

    // Assert
    assertEquals("foo\"foo\"", buf.toString());
  }

  /**
   * Test {@link Util#toShortClassName(String)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link Util#toShortClassName(String)}
   */
  @Test
  @DisplayName("Test toShortClassName(String); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.dexfile.ir.Util.toShortClassName(java.lang.String)"
  })
  void testToShortClassName_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> Util.toShortClassName("The characteristics of someone or something"));
  }

  /**
   * Test {@link Util#toShortClassName(String)}.
   *
   * <ul>
   *   <li>When {@code Desc}.
   *   <li>Then return {@code double}.
   * </ul>
   *
   * <p>Method under test: {@link Util#toShortClassName(String)}
   */
  @Test
  @DisplayName("Test toShortClassName(String); when 'Desc'; then return 'double'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.dexfile.ir.Util.toShortClassName(java.lang.String)"
  })
  void testToShortClassName_whenDesc_thenReturnDouble() {
    // Arrange, Act and Assert
    assertEquals("double", Util.toShortClassName("Desc"));
  }

  /**
   * Test {@link Util#toShortClassName(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link Util#toShortClassName(String)}
   */
  @Test
  @DisplayName("Test toShortClassName(String); when empty string; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.dexfile.ir.Util.toShortClassName(java.lang.String)"
  })
  void testToShortClassName_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", Util.toShortClassName(""));
  }

  /**
   * Test {@link Util#toShortClassName(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link Util#toShortClassName(String)}
   */
  @Test
  @DisplayName("Test toShortClassName(String); when 'null'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.dexfile.ir.Util.toShortClassName(java.lang.String)"
  })
  void testToShortClassName_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", Util.toShortClassName(null));
  }

  /**
   * Test {@link Util#isMemoryLimitReached(long)}.
   *
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Util#isMemoryLimitReached(long)}
   */
  @Test
  @DisplayName("Test isMemoryLimitReached(long); when MAX_VALUE; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.Util.isMemoryLimitReached(long)"})
  void testIsMemoryLimitReached_whenMax_value_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Util.isMemoryLimitReached(Long.MAX_VALUE));
  }

  /**
   * Test {@link Util#isMemoryLimitReached(long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Util#isMemoryLimitReached(long)}
   */
  @Test
  @DisplayName("Test isMemoryLimitReached(long); when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.Util.isMemoryLimitReached(long)"})
  void testIsMemoryLimitReached_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Util.isMemoryLimitReached(1L));
  }

  /**
   * Test {@link Util#isMemoryLimitReached(long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Util#isMemoryLimitReached(long)}
   */
  @Test
  @DisplayName("Test isMemoryLimitReached(long); when zero; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.Util.isMemoryLimitReached(long)"})
  void testIsMemoryLimitReached_whenZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Util.isMemoryLimitReached(0L));
  }
}
