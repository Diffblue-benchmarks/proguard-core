package proguard.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ListMatcherDiffblueTest {
  /**
   * Method under test: {@link ListMatcher#matches(String, int, int)}
   */
  @Test
  public void testMatches() {
    // Arrange, Act and Assert
    assertFalse((new ListMatcher(new EmptyStringMatcher())).matches("String", 1, 3));
    assertTrue((new ListMatcher(new ConstantMatcher(true))).matches("String", 1, 3));
    assertFalse((new ListMatcher(new ListMatcher(new EmptyStringMatcher()))).matches("String", 1, 3));
    assertFalse(
        (new ListMatcher(new StringMatcher[]{new EmptyStringMatcher()}, new boolean[]{true, false, true, false}))
            .matches("String", 1, 3));
    assertFalse(
        (new ListMatcher(new StringMatcher[]{new ConstantMatcher(true)}, new boolean[]{true, false, true, false}))
            .matches("String", 1, 3));
    assertTrue((new ListMatcher(new StringMatcher[]{new EmptyStringMatcher()}, new boolean[]{true, false, true, true}))
        .matches("String", 1, 3));
    assertTrue(
        (new ListMatcher(new StringMatcher[]{new ConstantMatcher(true)}, new boolean[]{false, false, true, false}))
            .matches("String", 1, 3));
  }
}
