package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConstantMatcherDiffblueTest {
  /**
   * Test {@link ConstantMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code false}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantMatcher#prefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ConstantMatcher.prefix()"})
  public void testPrefix_givenConstantMatcherWithMatchesIsFalse_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ConstantMatcher(false)).prefix());
  }

  /**
   * Test {@link ConstantMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ConstantMatcher#prefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ConstantMatcher.prefix()"})
  public void testPrefix_givenConstantMatcherWithMatchesIsTrue_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new ConstantMatcher(true)).prefix());
  }

  /**
   * Test {@link ConstantMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ConstantMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ConstantMatcher(false)).matches("String", 1, 3));
  }

  /**
   * Test {@link ConstantMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ConstantMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new ConstantMatcher(true)).matches("String", 1, 3));
  }
}
