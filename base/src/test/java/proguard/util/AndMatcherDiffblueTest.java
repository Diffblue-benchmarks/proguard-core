package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class AndMatcherDiffblueTest {
  /**
   * Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  public void testPrefix() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();

    // Act and Assert
    assertEquals("", (new AndMatcher(matcher1, new EmptyStringMatcher())).prefix());
  }

  /**
   * Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  public void testPrefix2() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();
    AndMatcher matcher12 = new AndMatcher(matcher1, new EmptyStringMatcher());

    // Act and Assert
    assertEquals("", (new AndMatcher(matcher12, new EmptyStringMatcher())).prefix());
  }

  /**
   * Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  public void testPrefix3() {
    // Arrange
    ConstantMatcher matcher1 = new ConstantMatcher(true);

    // Act and Assert
    assertEquals("", (new AndMatcher(matcher1, new EmptyStringMatcher())).prefix());
  }

  /**
   * Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  public void testPrefix4() {
    // Arrange
    FixedStringMatcher matcher1 = new FixedStringMatcher("Fixed String", new EmptyStringMatcher());

    // Act and Assert
    assertEquals("", (new AndMatcher(matcher1, new EmptyStringMatcher())).prefix());
  }

  /**
   * Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  public void testPrefix5() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();
    EmptyStringMatcher matcher12 = new EmptyStringMatcher();

    // Act and Assert
    assertEquals("", (new AndMatcher(matcher1, new AndMatcher(matcher12, new EmptyStringMatcher()))).prefix());
  }

  /**
   * Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  public void testPrefix6() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();

    // Act and Assert
    assertEquals("", (new AndMatcher(matcher1, new ConstantMatcher(true))).prefix());
  }

  /**
   * Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  public void testPrefix7() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();

    // Act and Assert
    assertEquals("", (new AndMatcher(matcher1, new FixedStringMatcher("Fixed String"))).prefix());
  }

  /**
   * Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  public void testPrefix8() {
    // Arrange
    ConstantMatcher matcher1 = new ConstantMatcher(false);

    // Act and Assert
    assertNull((new AndMatcher(matcher1, new EmptyStringMatcher())).prefix());
  }

  /**
   * Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  public void testPrefix9() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();
    FixedStringMatcher matcher12 = new FixedStringMatcher("Fixed String",
        new AndMatcher(matcher1, new EmptyStringMatcher()));

    // Act and Assert
    assertEquals("", (new AndMatcher(matcher12, new EmptyStringMatcher())).prefix());
  }

  /**
   * Method under test: {@link AndMatcher#prefix()}
   */
  @Test
  public void testPrefix10() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();

    // Act and Assert
    assertNull((new AndMatcher(matcher1, new ConstantMatcher(false))).prefix());
  }

  /**
   * Method under test: {@link AndMatcher#matches(String, int, int)}
   */
  @Test
  public void testMatches() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();

    // Act and Assert
    assertFalse((new AndMatcher(matcher1, new EmptyStringMatcher())).matches("String", 1, 3));
  }

  /**
   * Method under test: {@link AndMatcher#matches(String, int, int)}
   */
  @Test
  public void testMatches2() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();
    AndMatcher matcher12 = new AndMatcher(matcher1, new EmptyStringMatcher());

    // Act and Assert
    assertFalse((new AndMatcher(matcher12, new EmptyStringMatcher())).matches("String", 1, 3));
  }

  /**
   * Method under test: {@link AndMatcher#matches(String, int, int)}
   */
  @Test
  public void testMatches3() {
    // Arrange
    ConstantMatcher matcher1 = new ConstantMatcher(true);

    // Act and Assert
    assertFalse((new AndMatcher(matcher1, new EmptyStringMatcher())).matches("String", 1, 3));
  }

  /**
   * Method under test: {@link AndMatcher#matches(String, int, int)}
   */
  @Test
  public void testMatches4() {
    // Arrange
    EmptyStringMatcher matcher1 = new EmptyStringMatcher();

    // Act and Assert
    assertTrue((new AndMatcher(matcher1, new EmptyStringMatcher())).matches("String", 3, 3));
  }

  /**
   * Method under test: {@link AndMatcher#matches(String, int, int)}
   */
  @Test
  public void testMatches5() {
    // Arrange
    ConstantMatcher matcher1 = new ConstantMatcher(true);
    EmptyStringMatcher matcher12 = new EmptyStringMatcher();

    // Act and Assert
    assertFalse(
        (new AndMatcher(matcher1, new AndMatcher(matcher12, new EmptyStringMatcher()))).matches("String", 1, 3));
  }
}
