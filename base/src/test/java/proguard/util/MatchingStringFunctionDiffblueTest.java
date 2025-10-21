package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MatchingStringFunctionDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MatchingStringFunction.transform(String)"})
  public void testTransform_givenCollectionMatcherWithSetIsHashSet_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MatchingStringFunction.transform(String)"})
  public void testTransform_givenConstantMatcherWithMatchesIsTrue_thenReturnString() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MatchingStringFunction.transform(String)"})
  public void testTransform_givenMatchingStringFunctionWithStringMatcherIsEmptyStringMatcher() {
    // Arrange, Act and Assert
    assertNull((new MatchingStringFunction(new EmptyStringMatcher())).transform("String"));
  }
}
