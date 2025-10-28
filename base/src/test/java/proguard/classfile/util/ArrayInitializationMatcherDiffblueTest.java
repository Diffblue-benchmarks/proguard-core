package proguard.classfile.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.evaluation.PartialEvaluator;

public class ArrayInitializationMatcherDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ArrayInitializationMatcher#array()}
   *   <li>{@link ArrayInitializationMatcher#arrayInitializationEnd()}
   *   <li>{@link ArrayInitializationMatcher#arrayInitializationStart()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ArrayInitializationMatcher arrayInitializationMatcher = new ArrayInitializationMatcher();

    // Act
    Object actualArrayResult = arrayInitializationMatcher.array();
    int actualArrayInitializationEndResult = arrayInitializationMatcher.arrayInitializationEnd();

    // Assert
    assertNull(actualArrayResult);
    assertEquals(0, actualArrayInitializationEndResult);
    assertEquals(0, arrayInitializationMatcher.arrayInitializationStart());
  }

  /**
   * Method under test:
   * {@link ArrayInitializationMatcher#ArrayInitializationMatcher()}
   */
  @Test
  public void testNewArrayInitializationMatcher() {
    // Arrange and Act
    ArrayInitializationMatcher actualArrayInitializationMatcher = new ArrayInitializationMatcher();

    // Assert
    assertNull(actualArrayInitializationMatcher.array());
    assertEquals(0, actualArrayInitializationMatcher.arrayInitializationEnd());
    assertEquals(0, actualArrayInitializationMatcher.arrayInitializationStart());
  }

  /**
   * Method under test:
   * {@link ArrayInitializationMatcher#ArrayInitializationMatcher(PartialEvaluator)}
   */
  @Test
  public void testNewArrayInitializationMatcher2() {
    // Arrange and Act
    ArrayInitializationMatcher actualArrayInitializationMatcher = new ArrayInitializationMatcher(
        new PartialEvaluator());

    // Assert
    assertNull(actualArrayInitializationMatcher.array());
    assertEquals(0, actualArrayInitializationMatcher.arrayInitializationEnd());
    assertEquals(0, actualArrayInitializationMatcher.arrayInitializationStart());
  }
}
