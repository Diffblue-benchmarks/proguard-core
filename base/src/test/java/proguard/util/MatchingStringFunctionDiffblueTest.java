package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MatchingStringFunctionDiffblueTest {
  /**
   * Test {@link MatchingStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Given {@link CollectionMatcher#CollectionMatcher(Set)} with set is {@link
   *       HashSet#HashSet()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MatchingStringFunction#transform(String)}
   */
  @Test
  @DisplayName(
      "Test transform(String); given CollectionMatcher(Set) with set is HashSet(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.MatchingStringFunction.transform(java.lang.String)"
  })
  void testTransform_givenCollectionMatcherWithSetIsHashSet_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        (new MatchingStringFunction(new CollectionMatcher(new HashSet<>()))).transform("String"));
  }

  /**
   * Test {@link MatchingStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link MatchingStringFunction#transform(String)}
   */
  @Test
  @DisplayName(
      "Test transform(String); given ConstantMatcher(boolean) with matches is 'true'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.MatchingStringFunction.transform(java.lang.String)"
  })
  void testTransform_givenConstantMatcherWithMatchesIsTrue_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals(
        "String", (new MatchingStringFunction(new ConstantMatcher(true))).transform("String"));
  }

  /**
   * Test {@link MatchingStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Given {@link MatchingStringFunction#MatchingStringFunction(StringMatcher)} with
   *       stringMatcher is {@link EmptyStringMatcher} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MatchingStringFunction#transform(String)}
   */
  @Test
  @DisplayName(
      "Test transform(String); given MatchingStringFunction(StringMatcher) with stringMatcher is EmptyStringMatcher (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.MatchingStringFunction.transform(java.lang.String)"
  })
  void testTransform_givenMatchingStringFunctionWithStringMatcherIsEmptyStringMatcher() {
    // Arrange, Act and Assert
    assertNull((new MatchingStringFunction(new EmptyStringMatcher())).transform("String"));
  }
}
