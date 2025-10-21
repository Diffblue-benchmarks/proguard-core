package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SettableMatcherDiffblueTest {
  /**
   * Test {@link SettableMatcher#prefix()}.
   *
   * <p>Method under test: {@link SettableMatcher#prefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SettableMatcher.prefix()"})
  public void testPrefix() {
    // Arrange
    SettableMatcher settableMatcher = new SettableMatcher();
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();
    settableMatcher.setMatcher(new AndMatcher(matcher1, new EmptyStringMatcher()));

    // Act and Assert
    assertEquals("", settableMatcher.prefix());
  }

  /**
   * Test {@link SettableMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link SettableMatcher} (default constructor) Matcher is {@link
   *       ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SettableMatcher#prefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SettableMatcher.prefix()"})
  public void testPrefix_givenSettableMatcherMatcherIsConstantMatcherWithMatchesIsTrue() {
    // Arrange
    SettableMatcher settableMatcher = new SettableMatcher();
    settableMatcher.setMatcher(new ConstantMatcher(true));

    // Act and Assert
    assertEquals("", settableMatcher.prefix());
  }

  /**
   * Test {@link SettableMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link SettableMatcher} (default constructor) Matcher is {@link EmptyStringMatcher}
   *       (default constructor).
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link SettableMatcher#prefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SettableMatcher.prefix()"})
  public void testPrefix_givenSettableMatcherMatcherIsEmptyStringMatcher_thenReturnEmptyString() {
    // Arrange
    SettableMatcher settableMatcher = new SettableMatcher();
    settableMatcher.setMatcher(new EmptyStringMatcher());

    // Act and Assert
    assertEquals("", settableMatcher.prefix());
  }

  /**
   * Test {@link SettableMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SettableMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SettableMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset_thenReturnFalse() {
    // Arrange
    SettableMatcher settableMatcher = new SettableMatcher();
    settableMatcher.setMatcher(new EmptyStringMatcher());

    // Act and Assert
    assertFalse(settableMatcher.matches("String", 1, 3));
  }

  /**
   * Test {@link SettableMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SettableMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SettableMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset_thenReturnFalse2() {
    // Arrange
    SettableMatcher matcher = new SettableMatcher();
    matcher.setMatcher(new EmptyStringMatcher());

    SettableMatcher settableMatcher = new SettableMatcher();
    settableMatcher.setMatcher(matcher);

    // Act and Assert
    assertFalse(settableMatcher.matches("String", 1, 3));
  }

  /**
   * Test {@link SettableMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SettableMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SettableMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset_thenReturnTrue() {
    // Arrange
    SettableMatcher settableMatcher = new SettableMatcher();
    settableMatcher.setMatcher(new ConstantMatcher(true));

    // Act and Assert
    assertTrue(settableMatcher.matches("String", 1, 3));
  }
}
