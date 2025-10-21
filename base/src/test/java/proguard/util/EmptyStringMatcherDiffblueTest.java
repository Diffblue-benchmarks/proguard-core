package proguard.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EmptyStringMatcherDiffblueTest {
  /**
   * Test {@link EmptyStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EmptyStringMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EmptyStringMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new EmptyStringMatcher()).matches("String", 1, 3));
  }

  /**
   * Test {@link EmptyStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EmptyStringMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EmptyStringMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset_whenString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new EmptyStringMatcher()).matches("String", 3, 3));
  }
}
