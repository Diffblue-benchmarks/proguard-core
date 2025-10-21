package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FixedStringMatcherDiffblueTest {
  /**
   * Test {@link FixedStringMatcher#prefix()}.
   *
   * <p>Method under test: {@link FixedStringMatcher#prefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FixedStringMatcher.prefix()"})
  public void testPrefix() {
    // Arrange, Act and Assert
    assertEquals(
        "Fixed String",
        (new FixedStringMatcher("Fixed String", new EmptyStringMatcher())).prefix());
  }

  /**
   * Test {@link FixedStringMatcher#prefix()}.
   *
   * <p>Method under test: {@link FixedStringMatcher#prefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FixedStringMatcher.prefix()"})
  public void testPrefix2() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();

    // Act and Assert
    assertEquals(
        "Fixed String",
        (new FixedStringMatcher("Fixed String", new AndMatcher(matcher1, new EmptyStringMatcher())))
            .prefix());
  }

  /**
   * Test {@link FixedStringMatcher#prefix()}.
   *
   * <p>Method under test: {@link FixedStringMatcher#prefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FixedStringMatcher.prefix()"})
  public void testPrefix3() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();

    // Act and Assert
    assertEquals(
        "Fixed String",
        (new FixedStringMatcher(
                "Fixed String", new AndMatcher(matcher1, new FixedStringMatcher("Fixed String"))))
            .prefix());
  }

  /**
   * Test {@link FixedStringMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code false}.
   *   <li>Then return {@code Fixed String}.
   * </ul>
   *
   * <p>Method under test: {@link FixedStringMatcher#prefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FixedStringMatcher.prefix()"})
  public void testPrefix_givenConstantMatcherWithMatchesIsFalse_thenReturnFixedString() {
    // Arrange, Act and Assert
    assertEquals(
        "Fixed String",
        (new FixedStringMatcher("Fixed String", new ConstantMatcher(false))).prefix());
  }

  /**
   * Test {@link FixedStringMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   *   <li>Then return {@code Fixed String}.
   * </ul>
   *
   * <p>Method under test: {@link FixedStringMatcher#prefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FixedStringMatcher.prefix()"})
  public void testPrefix_givenConstantMatcherWithMatchesIsTrue_thenReturnFixedString() {
    // Arrange, Act and Assert
    assertEquals(
        "Fixed String",
        (new FixedStringMatcher("Fixed String", new ConstantMatcher(true))).prefix());
  }

  /**
   * Test {@link FixedStringMatcher#prefix()}.
   *
   * <ul>
   *   <li>Given {@link FixedStringMatcher#FixedStringMatcher(String)} with {@code Fixed String}.
   *   <li>Then return {@code Fixed String}.
   * </ul>
   *
   * <p>Method under test: {@link FixedStringMatcher#prefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FixedStringMatcher.prefix()"})
  public void testPrefix_givenFixedStringMatcherWithFixedString_thenReturnFixedString() {
    // Arrange, Act and Assert
    assertEquals("Fixed String", (new FixedStringMatcher("Fixed String")).prefix());
  }

  /**
   * Test {@link FixedStringMatcher#prefix()}.
   *
   * <ul>
   *   <li>Then return {@code Fixed StringFixed String}.
   * </ul>
   *
   * <p>Method under test: {@link FixedStringMatcher#prefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FixedStringMatcher.prefix()"})
  public void testPrefix_thenReturnFixedStringFixedString() {
    // Arrange, Act and Assert
    assertEquals(
        "Fixed StringFixed String",
        (new FixedStringMatcher("Fixed String", new FixedStringMatcher("Fixed String"))).prefix());
  }

  /**
   * Test {@link FixedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link FixedStringMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FixedStringMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset() {
    // Arrange, Act and Assert
    assertFalse((new FixedStringMatcher("42")).matches("String", 1, 3));
  }

  /**
   * Test {@link FixedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link FixedStringMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FixedStringMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset2() {
    // Arrange, Act and Assert
    assertFalse((new FixedStringMatcher("")).matches("String", 1, 3));
  }

  /**
   * Test {@link FixedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link FixedStringMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FixedStringMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset3() {
    // Arrange, Act and Assert
    assertFalse((new FixedStringMatcher("", new EmptyStringMatcher())).matches("String", 1, 3));
  }

  /**
   * Test {@link FixedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link FixedStringMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FixedStringMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset4() {
    // Arrange, Act and Assert
    assertFalse(
        (new FixedStringMatcher("", new FixedStringMatcher("Fixed String")))
            .matches("String", 1, 3));
  }

  /**
   * Test {@link FixedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FixedStringMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FixedStringMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset_givenConstantMatcherWithMatchesIsTrue() {
    // Arrange, Act and Assert
    assertTrue((new FixedStringMatcher("", new ConstantMatcher(true))).matches("String", 1, 3));
  }

  /**
   * Test {@link FixedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>Given {@link FixedStringMatcher#FixedStringMatcher(String)} with {@code Fixed String}.
   * </ul>
   *
   * <p>Method under test: {@link FixedStringMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FixedStringMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset_givenFixedStringMatcherWithFixedString() {
    // Arrange, Act and Assert
    assertFalse((new FixedStringMatcher("Fixed String")).matches("String", 1, 3));
  }

  /**
   * Test {@link FixedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FixedStringMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FixedStringMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new FixedStringMatcher("")).matches("String", 1, 1));
  }
}
