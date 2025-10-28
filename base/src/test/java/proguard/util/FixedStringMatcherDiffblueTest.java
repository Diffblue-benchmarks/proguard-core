package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class FixedStringMatcherDiffblueTest {
  /**
   * Method under test: {@link FixedStringMatcher#prefix()}
   */
  @Test
  public void testPrefix() {
    // Arrange, Act and Assert
    assertEquals("Fixed String", (new FixedStringMatcher("Fixed String")).prefix());
    assertEquals("Fixed String", (new FixedStringMatcher("Fixed String", new EmptyStringMatcher())).prefix());
    assertEquals("Fixed String", (new FixedStringMatcher("Fixed String", new ConstantMatcher(true))).prefix());
    assertEquals("Fixed StringFixed String",
        (new FixedStringMatcher("Fixed String", new FixedStringMatcher("Fixed String"))).prefix());
    assertEquals("Fixed String", (new FixedStringMatcher("Fixed String", new ConstantMatcher(false))).prefix());
  }

  /**
   * Method under test: {@link FixedStringMatcher#prefix()}
   */
  @Test
  public void testPrefix2() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();

    // Act and Assert
    assertEquals("Fixed String",
        (new FixedStringMatcher("Fixed String", new AndMatcher(matcher1, new EmptyStringMatcher()))).prefix());
  }

  /**
   * Method under test: {@link FixedStringMatcher#prefix()}
   */
  @Test
  public void testPrefix3() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();

    // Act and Assert
    assertEquals("Fixed String",
        (new FixedStringMatcher("Fixed String", new AndMatcher(matcher1, new FixedStringMatcher("Fixed String"))))
            .prefix());
  }

  /**
   * Method under test: {@link FixedStringMatcher#matches(String, int, int)}
   */
  @Test
  public void testMatches() {
    // Arrange, Act and Assert
    assertFalse((new FixedStringMatcher("Fixed String")).matches("String", 1, 3));
    assertFalse((new FixedStringMatcher("42")).matches("String", 1, 3));
    assertFalse((new FixedStringMatcher("")).matches("String", 1, 3));
    assertTrue((new FixedStringMatcher("")).matches("String", 1, 1));
    assertFalse((new FixedStringMatcher("", new EmptyStringMatcher())).matches("String", 1, 3));
    assertTrue((new FixedStringMatcher("", new ConstantMatcher(true))).matches("String", 1, 3));
    assertFalse((new FixedStringMatcher("", new FixedStringMatcher("Fixed String"))).matches("String", 1, 3));
  }
}
