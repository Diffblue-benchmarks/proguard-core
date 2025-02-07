package proguard.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ListMatcherDiffblueTest {
  /**
   * Test {@link ListMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <p>Method under test: {@link ListMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.ListMatcher.matches(java.lang.String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset() {
    // Arrange, Act and Assert
    assertFalse((new ListMatcher(new EmptyStringMatcher())).matches("String", 1, 3));
  }

  /**
   * Test {@link ListMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <p>Method under test: {@link ListMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.ListMatcher.matches(java.lang.String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset2() {
    // Arrange, Act and Assert
    assertFalse(
        (new ListMatcher(new ListMatcher(new EmptyStringMatcher()))).matches("String", 1, 3));
  }

  /**
   * Test {@link ListMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <p>Method under test: {@link ListMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.ListMatcher.matches(java.lang.String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset3() {
    // Arrange, Act and Assert
    assertFalse(
        (new ListMatcher(
                new StringMatcher[] {new EmptyStringMatcher()},
                new boolean[] {true, false, true, false}))
            .matches("String", 1, 3));
  }

  /**
   * Test {@link ListMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <p>Method under test: {@link ListMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.ListMatcher.matches(java.lang.String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset4() {
    // Arrange, Act and Assert
    assertFalse(
        (new ListMatcher(
                new StringMatcher[] {new ConstantMatcher(true)},
                new boolean[] {true, false, true, false}))
            .matches("String", 1, 3));
  }

  /**
   * Test {@link ListMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <p>Method under test: {@link ListMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.ListMatcher.matches(java.lang.String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset5() {
    // Arrange, Act and Assert
    assertTrue(
        (new ListMatcher(
                new StringMatcher[] {new EmptyStringMatcher()},
                new boolean[] {true, false, true, true}))
            .matches("String", 1, 3));
  }

  /**
   * Test {@link ListMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <p>Method under test: {@link ListMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.ListMatcher.matches(java.lang.String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset6() {
    // Arrange, Act and Assert
    assertTrue(
        (new ListMatcher(
                new StringMatcher[] {new ConstantMatcher(true)},
                new boolean[] {false, false, true, false}))
            .matches("String", 1, 3));
  }

  /**
   * Test {@link ListMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ListMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'; given ConstantMatcher(boolean) with matches is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.util.ListMatcher.matches(java.lang.String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset_givenConstantMatcherWithMatchesIsTrue() {
    // Arrange, Act and Assert
    assertTrue((new ListMatcher(new ConstantMatcher(true))).matches("String", 1, 3));
  }
}
