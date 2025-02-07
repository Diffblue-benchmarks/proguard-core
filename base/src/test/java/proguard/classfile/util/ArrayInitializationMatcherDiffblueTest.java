package proguard.classfile.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.evaluation.PartialEvaluator;

class ArrayInitializationMatcherDiffblueTest {
  /**
   * Test {@link ArrayInitializationMatcher#ArrayInitializationMatcher()}.
   *
   * <p>Method under test: {@link ArrayInitializationMatcher#ArrayInitializationMatcher()}
   */
  @Test
  @DisplayName("Test new ArrayInitializationMatcher()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.util.ArrayInitializationMatcher.<init>()"})
  void testNewArrayInitializationMatcher() {
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
  @DisplayName("Test new ArrayInitializationMatcher(PartialEvaluator)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ArrayInitializationMatcher.<init>(proguard.evaluation.PartialEvaluator)"
  })
  void testNewArrayInitializationMatcher2() {
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object proguard.classfile.util.ArrayInitializationMatcher.array()",
    "int proguard.classfile.util.ArrayInitializationMatcher.arrayInitializationEnd()",
    "int proguard.classfile.util.ArrayInitializationMatcher.arrayInitializationStart()"
  })
  void testGettersAndSetters() {
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
