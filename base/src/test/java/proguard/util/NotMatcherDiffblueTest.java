package proguard.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class NotMatcherDiffblueTest {
  /**
   * Method under test: {@link NotMatcher#matches(String, int, int)}
   */
  @Test
  public void testMatches() {
    // Arrange, Act and Assert
    assertTrue((new NotMatcher(new EmptyStringMatcher())).matches("String", 1, 3));
    assertFalse((new NotMatcher(new ConstantMatcher(true))).matches("String", 1, 3));
    assertFalse((new NotMatcher(new NotMatcher(new EmptyStringMatcher()))).matches("String", 1, 3));
  }
}
