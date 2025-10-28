package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ConstantMatcherDiffblueTest {
  /**
   * Method under test: {@link ConstantMatcher#prefix()}
   */
  @Test
  public void testPrefix() {
    // Arrange, Act and Assert
    assertEquals("", (new ConstantMatcher(true)).prefix());
    assertNull((new ConstantMatcher(false)).prefix());
  }

  /**
   * Method under test: {@link ConstantMatcher#matches(String, int, int)}
   */
  @Test
  public void testMatches() {
    // Arrange, Act and Assert
    assertTrue((new ConstantMatcher(true)).matches("String", 1, 3));
    assertFalse((new ConstantMatcher(false)).matches("String", 1, 3));
  }
}
