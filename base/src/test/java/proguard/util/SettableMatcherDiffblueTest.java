package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SettableMatcherDiffblueTest {
  /**
   * Method under test: {@link SettableMatcher#prefix()}
   */
  @Test
  public void testPrefix() {
    // Arrange
    SettableMatcher settableMatcher = new SettableMatcher();
    settableMatcher.setMatcher(new EmptyStringMatcher());

    // Act and Assert
    assertEquals("", settableMatcher.prefix());
  }

  /**
   * Method under test: {@link SettableMatcher#prefix()}
   */
  @Test
  public void testPrefix2() {
    // Arrange
    SettableMatcher settableMatcher = new SettableMatcher();
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();
    settableMatcher.setMatcher(new AndMatcher(matcher1, new EmptyStringMatcher()));

    // Act and Assert
    assertEquals("", settableMatcher.prefix());
  }

  /**
   * Method under test: {@link SettableMatcher#prefix()}
   */
  @Test
  public void testPrefix3() {
    // Arrange
    SettableMatcher settableMatcher = new SettableMatcher();
    settableMatcher.setMatcher(new ConstantMatcher(true));

    // Act and Assert
    assertEquals("", settableMatcher.prefix());
  }

  /**
   * Method under test: {@link SettableMatcher#matches(String, int, int)}
   */
  @Test
  public void testMatches() {
    // Arrange
    SettableMatcher settableMatcher = new SettableMatcher();
    settableMatcher.setMatcher(new EmptyStringMatcher());

    // Act and Assert
    assertFalse(settableMatcher.matches("String", 1, 3));
  }

  /**
   * Method under test: {@link SettableMatcher#matches(String, int, int)}
   */
  @Test
  public void testMatches2() {
    // Arrange
    SettableMatcher settableMatcher = new SettableMatcher();
    settableMatcher.setMatcher(new ConstantMatcher(true));

    // Act and Assert
    assertTrue(settableMatcher.matches("String", 1, 3));
  }

  /**
   * Method under test: {@link SettableMatcher#matches(String, int, int)}
   */
  @Test
  public void testMatches3() {
    // Arrange
    SettableMatcher matcher = new SettableMatcher();
    matcher.setMatcher(new EmptyStringMatcher());

    SettableMatcher settableMatcher = new SettableMatcher();
    settableMatcher.setMatcher(matcher);

    // Act and Assert
    assertFalse(settableMatcher.matches("String", 1, 3));
  }
}
