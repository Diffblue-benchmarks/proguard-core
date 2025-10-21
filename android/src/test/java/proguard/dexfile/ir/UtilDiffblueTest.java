package proguard.dexfile.ir;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class UtilDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List Util.listDesc(String)"})
  public void testListDesc_whenEmptyString_thenReturnEmpty() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Util.appendString(StringBuffer, String)"})
  public void testAppendString_whenBackslashQuotationMark_thenStringBufferWithFooToStringIsFoo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Util.appendString(StringBuffer, String)"})
  public void testAppendString_whenStringBufferWithFoo_thenStringBufferWithFooToStringIsFooFoo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Util.toShortClassName(String)"})
  public void testToShortClassName_thenThrowUnsupportedOperationException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Util.toShortClassName(String)"})
  public void testToShortClassName_whenDesc_thenReturnDouble() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Util.toShortClassName(String)"})
  public void testToShortClassName_whenEmptyString_thenReturnEmptyString() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Util.toShortClassName(String)"})
  public void testToShortClassName_whenNull_thenReturnEmptyString() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Util.isMemoryLimitReached(long)"})
  public void testIsMemoryLimitReached_whenMax_value_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Util.isMemoryLimitReached(long)"})
  public void testIsMemoryLimitReached_whenOne_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Util.isMemoryLimitReached(long)"})
  public void testIsMemoryLimitReached_whenZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Util.isMemoryLimitReached(0L));
  }
}
