package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CollectionMatcherDiffblueTest {
  /**
   * Test {@link CollectionMatcher#CollectionMatcher(String[])}.
   *
   * <p>Method under test: {@link CollectionMatcher#CollectionMatcher(String[])}
   */
  @Test
  @DisplayName("Test new CollectionMatcher(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CollectionMatcher.<init>(String[])"})
  void testNewCollectionMatcher() {
    // Arrange, Act and Assert
    assertEquals("", new CollectionMatcher("Strings").prefix());
  }

  /**
   * Test {@link CollectionMatcher#matches(String)} with {@code string}.
   *
   * <p>Method under test: {@link CollectionMatcher#matches(String)}
   */
  @Test
  @DisplayName("Test matches(String) with 'string'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollectionMatcher.matches(String)"})
  void testMatchesWithString() {
    // Arrange, Act and Assert
    assertFalse(new CollectionMatcher(new HashSet<>()).matches("String"));
  }

  /**
   * Test {@link CollectionMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionMatcher#matches(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test matches(String, int, int) with 'string', 'beginOffset', 'endOffset'; when 'String'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollectionMatcher.matches(String, int, int)"})
  void testMatchesWithStringBeginOffsetEndOffset_whenString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new CollectionMatcher(new HashSet<>()).matches("String", 1, 3));
  }
}
