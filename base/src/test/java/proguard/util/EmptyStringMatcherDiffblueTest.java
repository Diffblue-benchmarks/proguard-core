package proguard.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class EmptyStringMatcherDiffblueTest {
  /**
   * Method under test: {@link EmptyStringMatcher#matches(String, int, int)}
   */
  @Test
  public void testMatches() {
    // Arrange, Act and Assert
    assertFalse((new EmptyStringMatcher()).matches("String", 1, 3));
    assertTrue((new EmptyStringMatcher()).matches("String", 3, 3));
  }
}
