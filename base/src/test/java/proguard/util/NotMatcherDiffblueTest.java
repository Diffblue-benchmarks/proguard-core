package proguard.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class NotMatcherDiffblueTest {
  /**
   * Test {@link NotMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NotMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NotMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset_givenConstantMatcherWithMatchesIsTrue() {
    // Arrange, Act and Assert
    assertFalse((new NotMatcher(new ConstantMatcher(true))).matches("String", 1, 3));
  }

  /**
   * Test {@link NotMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <ul>
   *   <li>Given {@link NotMatcher#NotMatcher(StringMatcher)} with matcher is {@link
   *       NotMatcher#NotMatcher(StringMatcher)}.
   * </ul>
   *
   * <p>Method under test: {@link NotMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NotMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset_givenNotMatcherWithMatcherIsNotMatcher() {
    // Arrange, Act and Assert
    assertFalse((new NotMatcher(new NotMatcher(new EmptyStringMatcher()))).matches("String", 1, 3));
  }

  /**
   * Test {@link NotMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NotMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NotMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new NotMatcher(new EmptyStringMatcher())).matches("String", 1, 3));
  }
}
