package proguard.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ListMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset() {
    // Arrange, Act and Assert
    assertFalse(new ListMatcher(new EmptyStringMatcher()).matches("String", 1, 3));
  }

  /**
   * Test {@link ListMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <p>Method under test: {@link ListMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ListMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset2() {
    // Arrange
    StringMatcher[] matchers = new StringMatcher[] {new EmptyStringMatcher()};
    ListMatcher listMatcher = new ListMatcher(matchers, new boolean[] {true, false, true, false});

    // Act and Assert
    assertFalse(listMatcher.matches("String", 1, 3));
  }

  /**
   * Test {@link ListMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <p>Method under test: {@link ListMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ListMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset3() {
    // Arrange
    StringMatcher[] matchers = new StringMatcher[] {new ConstantMatcher(true)};
    ListMatcher listMatcher = new ListMatcher(matchers, new boolean[] {true, false, true, false});

    // Act and Assert
    assertFalse(listMatcher.matches("String", 1, 3));
  }

  /**
   * Test {@link ListMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <p>Method under test: {@link ListMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ListMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset4() {
    // Arrange
    StringMatcher[] matchers = new StringMatcher[] {new ListMatcher(new EmptyStringMatcher())};
    ListMatcher listMatcher = new ListMatcher(matchers, new boolean[] {true, false, true, false});

    // Act and Assert
    assertFalse(listMatcher.matches("String", 1, 3));
  }

  /**
   * Test {@link ListMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <p>Method under test: {@link ListMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ListMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset5() {
    // Arrange
    StringMatcher[] matchers = new StringMatcher[] {new EmptyStringMatcher()};
    ListMatcher listMatcher = new ListMatcher(matchers, new boolean[] {true, false, true, true});

    // Act and Assert
    assertTrue(listMatcher.matches("String", 1, 3));
  }

  /**
   * Test {@link ListMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <p>Method under test: {@link ListMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName("Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ListMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset6() {
    // Arrange
    StringMatcher[] matchers = new StringMatcher[] {new ConstantMatcher(true)};
    ListMatcher listMatcher = new ListMatcher(matchers, new boolean[] {false, false, true, false});

    // Act and Assert
    assertTrue(listMatcher.matches("String", 1, 3));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ListMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset_givenConstantMatcherWithMatchesIsTrue() {
    // Arrange, Act and Assert
    assertTrue(new ListMatcher(new ConstantMatcher(true)).matches("String", 1, 3));
  }
}
