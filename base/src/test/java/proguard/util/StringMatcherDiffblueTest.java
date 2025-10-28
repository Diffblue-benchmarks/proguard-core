package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class StringMatcherDiffblueTest {
  /**
   * Method under test: {@link StringMatcher#matches(String)}
   */
  @Test
  public void testMatches() {
    // Arrange, Act and Assert
    assertFalse((new EmptyStringMatcher()).matches("String"));
    assertTrue((new EmptyStringMatcher()).matches(""));
  }

  /**
   * Method under test: {@link StringMatcher#prefix()}
   */
  @Test
  public void testPrefix() {
    // Arrange, Act and Assert
    assertEquals("", (new EmptyStringMatcher()).prefix());
  }
}
