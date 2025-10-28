package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class OrMatcherDiffblueTest {
  /**
   * Method under test: {@link OrMatcher#prefix()}
   */
  @Test
  public void testPrefix() {
    // Arrange, Act and Assert
    assertEquals("", (new OrMatcher(new EmptyStringMatcher())).prefix());
    assertEquals("", (new OrMatcher(new ConstantMatcher(true))).prefix());
    assertNull((new OrMatcher()).prefix());
  }

  /**
   * Method under test: {@link OrMatcher#prefix()}
   */
  @Test
  public void testPrefix2() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();

    // Act and Assert
    assertEquals("", (new OrMatcher(new AndMatcher(matcher1, new EmptyStringMatcher()))).prefix());
  }

  /**
   * Method under test: {@link OrMatcher#prefix()}
   */
  @Test
  public void testPrefix3() {
    // Arrange
    EmptyStringMatcher emptyStringMatcher = new EmptyStringMatcher();

    // Act and Assert
    assertEquals("", (new OrMatcher(emptyStringMatcher, new EmptyStringMatcher())).prefix());
  }

  /**
   * Method under test: {@link OrMatcher#matches(String, int, int)}
   */
  @Test
  public void testMatches() {
    // Arrange, Act and Assert
    assertFalse((new OrMatcher(new EmptyStringMatcher())).matches("String", 1, 3));
    assertTrue((new OrMatcher(new ConstantMatcher(true))).matches("String", 1, 3));
  }
}
