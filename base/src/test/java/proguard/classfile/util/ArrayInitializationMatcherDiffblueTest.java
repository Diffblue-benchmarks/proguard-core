package proguard.classfile.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.evaluation.PartialEvaluator;

public class ArrayInitializationMatcherDiffblueTest {
  /**
   * Test {@link ArrayInitializationMatcher#ArrayInitializationMatcher()}.
   *
   * <p>Method under test: {@link ArrayInitializationMatcher#ArrayInitializationMatcher()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ArrayInitializationMatcher.<init>()"})
  public void testNewArrayInitializationMatcher() {
    // Arrange and Act
    ArrayInitializationMatcher actualArrayInitializationMatcher = new ArrayInitializationMatcher();

    // Assert
    assertNull(actualArrayInitializationMatcher.array());
    assertEquals(0, actualArrayInitializationMatcher.arrayInitializationEnd());
    assertEquals(0, actualArrayInitializationMatcher.arrayInitializationStart());
  }

  /**
   * Test {@link ArrayInitializationMatcher#ArrayInitializationMatcher(PartialEvaluator)}.
   *
   * <p>Method under test: {@link
   * ArrayInitializationMatcher#ArrayInitializationMatcher(PartialEvaluator)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ArrayInitializationMatcher.<init>(PartialEvaluator)"})
  public void testNewArrayInitializationMatcher2() {
    // Arrange and Act
    ArrayInitializationMatcher actualArrayInitializationMatcher =
        new ArrayInitializationMatcher(new PartialEvaluator());

    // Assert
    assertNull(actualArrayInitializationMatcher.array());
    assertEquals(0, actualArrayInitializationMatcher.arrayInitializationEnd());
    assertEquals(0, actualArrayInitializationMatcher.arrayInitializationStart());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ArrayInitializationMatcher#array()}
   *   <li>{@link ArrayInitializationMatcher#arrayInitializationEnd()}
   *   <li>{@link ArrayInitializationMatcher#arrayInitializationStart()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Object ArrayInitializationMatcher.array()",
    "int ArrayInitializationMatcher.arrayInitializationEnd()",
    "int ArrayInitializationMatcher.arrayInitializationStart()"
  })
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
}
