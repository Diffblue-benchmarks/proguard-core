package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OrMatcherDiffblueTest {
  /**
   * Test {@link OrMatcher#prefix()}.
   *
   * <p>Method under test: {@link OrMatcher#prefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrMatcher.prefix()"})
  public void testPrefix() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();

    // Act and Assert
    assertEquals("", (new OrMatcher(new AndMatcher(matcher1, new EmptyStringMatcher()))).prefix());
  }

  /**
   * Test {@link OrMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link OrMatcher#prefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrMatcher.prefix()"})
  public void testPrefix_givenConstantMatcherWithMatchesIsTrue_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new OrMatcher(new ConstantMatcher(true))).prefix());
  }

  /**
   * Test {@link OrMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link OrMatcher#OrMatcher(StringMatcher[])} with matchers is {@link
   *       EmptyStringMatcher} (default constructor) and {@link EmptyStringMatcher} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrMatcher#prefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrMatcher.prefix()"})
  public void testPrefix_givenOrMatcherWithMatchersIsEmptyStringMatcherAndEmptyStringMatcher() {
    // Arrange
    EmptyStringMatcher emptyStringMatcher = new EmptyStringMatcher();

    // Act and Assert
    assertEquals("", (new OrMatcher(emptyStringMatcher, new EmptyStringMatcher())).prefix());
  }

  /**
   * Test {@link OrMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link OrMatcher#OrMatcher(StringMatcher[])} with matchers is {@link
   *       EmptyStringMatcher} (default constructor).
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link OrMatcher#prefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrMatcher.prefix()"})
  public void testPrefix_givenOrMatcherWithMatchersIsEmptyStringMatcher_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new OrMatcher(new EmptyStringMatcher())).prefix());
  }

  /**
   * Test {@link OrMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link OrMatcher#OrMatcher(StringMatcher[])}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrMatcher#prefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrMatcher.prefix()"})
  public void testPrefix_givenOrMatcher_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new OrMatcher()).prefix());
  }

  /**
   * Test {@link OrMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new OrMatcher(new EmptyStringMatcher())).matches("String", 1, 3));
  }

  /**
   * Test {@link OrMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new OrMatcher(new ConstantMatcher(true))).matches("String", 1, 3));
  }
}
