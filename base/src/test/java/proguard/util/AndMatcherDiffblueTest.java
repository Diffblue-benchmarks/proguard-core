package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AndMatcherDiffblueTest {
  /**
   * Test {@link AndMatcher#prefix()}.
   *
   * <p>Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AndMatcher.prefix()"})
  public void testPrefix() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();

    // Act and Assert
    assertEquals("", (new AndMatcher(matcher1, new EmptyStringMatcher())).prefix());
  }

  /**
   * Test {@link AndMatcher#prefix()}.
   *
   * <p>Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AndMatcher.prefix()"})
  public void testPrefix2() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();
    AndMatcher matcher12 = new AndMatcher(matcher1, new EmptyStringMatcher());

    // Act and Assert
    assertEquals("", (new AndMatcher(matcher12, new EmptyStringMatcher())).prefix());
  }

  /**
   * Test {@link AndMatcher#prefix()}.
   *
   * <p>Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AndMatcher.prefix()"})
  public void testPrefix3() {
    // Arrange
    FixedStringMatcher matcher1 = new FixedStringMatcher("Fixed String", new EmptyStringMatcher());

    // Act and Assert
    assertEquals("", (new AndMatcher(matcher1, new EmptyStringMatcher())).prefix());
  }

  /**
   * Test {@link AndMatcher#prefix()}.
   *
   * <p>Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AndMatcher.prefix()"})
  public void testPrefix4() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();
    EmptyStringMatcher matcher12 = new EmptyStringMatcher();

    // Act and Assert
    assertEquals(
        "",
        (new AndMatcher(matcher1, new AndMatcher(matcher12, new EmptyStringMatcher()))).prefix());
  }

  /**
   * Test {@link AndMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code false}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AndMatcher.prefix()"})
  public void testPrefix_givenConstantMatcherWithMatchesIsFalse_thenReturnNull() {
    // Arrange
    ConstantMatcher matcher1 = new ConstantMatcher(false);

    // Act and Assert
    assertNull((new AndMatcher(matcher1, new EmptyStringMatcher())).prefix());
  }

  /**
   * Test {@link AndMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code false}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AndMatcher.prefix()"})
  public void testPrefix_givenConstantMatcherWithMatchesIsFalse_thenReturnNull2() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();

    // Act and Assert
    assertNull((new AndMatcher(matcher1, new ConstantMatcher(false))).prefix());
  }

  /**
   * Test {@link AndMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AndMatcher.prefix()"})
  public void testPrefix_givenConstantMatcherWithMatchesIsTrue_thenReturnEmptyString() {
    // Arrange
    ConstantMatcher matcher1 = new ConstantMatcher(true);

    // Act and Assert
    assertEquals("", (new AndMatcher(matcher1, new EmptyStringMatcher())).prefix());
  }

  /**
   * Test {@link AndMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AndMatcher.prefix()"})
  public void testPrefix_givenConstantMatcherWithMatchesIsTrue_thenReturnEmptyString2() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();

    // Act and Assert
    assertEquals("", (new AndMatcher(matcher1, new ConstantMatcher(true))).prefix());
  }

  /**
   * Test {@link AndMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link FixedStringMatcher#FixedStringMatcher(String, StringMatcher)} with {@code
   *       Fixed String} and nextMatcher is {@link AndMatcher#AndMatcher(StringMatcher,
   *       StringMatcher)}.
   * </ul>
   *
   * <p>Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AndMatcher.prefix()"})
  public void testPrefix_givenFixedStringMatcherWithFixedStringAndNextMatcherIsAndMatcher() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();
    FixedStringMatcher matcher12 =
        new FixedStringMatcher("Fixed String", new AndMatcher(matcher1, new EmptyStringMatcher()));

    // Act and Assert
    assertEquals("", (new AndMatcher(matcher12, new EmptyStringMatcher())).prefix());
  }

  /**
   * Test {@link AndMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link FixedStringMatcher#FixedStringMatcher(String)} with {@code Fixed String}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AndMatcher.prefix()"})
  public void testPrefix_givenFixedStringMatcherWithFixedString_thenReturnEmptyString() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();

    // Act and Assert
    assertEquals("", (new AndMatcher(matcher1, new FixedStringMatcher("Fixed String"))).prefix());
  }

  /**
   * Test {@link AndMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <p>Method under test: {@link AndMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AndMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();
    AndMatcher matcher12 = new AndMatcher(matcher1, new EmptyStringMatcher());

    // Act and Assert
    assertFalse((new AndMatcher(matcher12, new EmptyStringMatcher())).matches("String", 1, 3));
  }

  /**
   * Test {@link AndMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <p>Method under test: {@link AndMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AndMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset2() {
    // Arrange
    ConstantMatcher matcher1 = new ConstantMatcher(true);

    // Act and Assert
    assertFalse((new AndMatcher(matcher1, new EmptyStringMatcher())).matches("String", 1, 3));
  }

  /**
   * Test {@link AndMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <p>Method under test: {@link AndMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AndMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset3() {
    // Arrange
    ConstantMatcher matcher1 = new ConstantMatcher(true);
    EmptyStringMatcher matcher12 = new EmptyStringMatcher();

    // Act and Assert
    assertFalse(
        (new AndMatcher(matcher1, new AndMatcher(matcher12, new EmptyStringMatcher())))
            .matches("String", 1, 3));
  }

  /**
   * Test {@link AndMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AndMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AndMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset_thenReturnFalse() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();

    // Act and Assert
    assertFalse((new AndMatcher(matcher1, new EmptyStringMatcher())).matches("String", 1, 3));
  }

  /**
   * Test {@link AndMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AndMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AndMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset_thenReturnTrue() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();

    // Act and Assert
    assertTrue((new AndMatcher(matcher1, new EmptyStringMatcher())).matches("String", 3, 3));
  }
}
