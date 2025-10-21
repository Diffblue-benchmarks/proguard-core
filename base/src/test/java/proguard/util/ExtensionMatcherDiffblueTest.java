package proguard.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ExtensionMatcherDiffblueTest {
  /**
   * Test {@link ExtensionMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ExtensionMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExtensionMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ExtensionMatcher("Extension")).matches("String", 1, 3));
  }

  /**
   * Test {@link ExtensionMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ExtensionMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExtensionMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new ExtensionMatcher("")).matches("String", 1, 3));
  }
}
