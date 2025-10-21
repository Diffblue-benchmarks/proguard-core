package proguard.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ListMatcherDiffblueTest {
  /**
   * Test {@link ListMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <p>Method under test: {@link ListMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ListMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset() {
    // Arrange, Act and Assert
    assertFalse((new ListMatcher(new EmptyStringMatcher())).matches("String", 1, 3));
  }

  /**
   * Test {@link ListMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <p>Method under test: {@link ListMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ListMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset2() {
    // Arrange, Act and Assert
    assertFalse(
        (new ListMatcher(new ListMatcher(new EmptyStringMatcher()))).matches("String", 1, 3));
  }

  /**
   * Test {@link ListMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <p>Method under test: {@link ListMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ListMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset3() {
    // Arrange, Act and Assert
    assertFalse(
        (new ListMatcher(
                new StringMatcher[] {new EmptyStringMatcher()},
                new boolean[] {true, false, true, false}))
            .matches("String", 1, 3));
  }

  /**
   * Test {@link ListMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <p>Method under test: {@link ListMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ListMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset4() {
    // Arrange, Act and Assert
    assertFalse(
        (new ListMatcher(
                new StringMatcher[] {new ConstantMatcher(true)},
                new boolean[] {true, false, true, false}))
            .matches("String", 1, 3));
  }

  /**
   * Test {@link ListMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <p>Method under test: {@link ListMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ListMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset5() {
    // Arrange, Act and Assert
    assertTrue(
        (new ListMatcher(
                new StringMatcher[] {new EmptyStringMatcher()},
                new boolean[] {true, false, true, true}))
            .matches("String", 1, 3));
  }

  /**
   * Test {@link ListMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <p>Method under test: {@link ListMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ListMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset6() {
    // Arrange, Act and Assert
    assertTrue(
        (new ListMatcher(
                new StringMatcher[] {new ConstantMatcher(true)},
                new boolean[] {false, false, true, false}))
            .matches("String", 1, 3));
  }

  /**
   * Test {@link ListMatcher#matches(String, int, int)} with {@code string}, {@code beginOffset},
   * {@code endOffset}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ListMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ListMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset_givenConstantMatcherWithMatchesIsTrue() {
    // Arrange, Act and Assert
    assertTrue((new ListMatcher(new ConstantMatcher(true))).matches("String", 1, 3));
  }
}
