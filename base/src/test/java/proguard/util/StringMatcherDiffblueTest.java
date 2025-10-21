package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StringMatcherDiffblueTest {
  /**
   * Test {@link StringMatcher#matches(String)} with {@code String}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StringMatcher#matches(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StringMatcher.matches(String)"})
  public void testMatchesWithString_whenEmptyString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new EmptyStringMatcher()).matches(""));
  }

  /**
   * Test {@link StringMatcher#matches(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringMatcher#matches(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StringMatcher.matches(String)"})
  public void testMatchesWithString_whenString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new EmptyStringMatcher()).matches("String"));
  }

  /**
   * Test {@link StringMatcher#prefix()}.
   *
   * <p>Method under test: {@link StringMatcher#prefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StringMatcher.prefix()"})
  public void testPrefix() {
    // Arrange, Act and Assert
    assertEquals("", (new EmptyStringMatcher()).prefix());
  }
}
