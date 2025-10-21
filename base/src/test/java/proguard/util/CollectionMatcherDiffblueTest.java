package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CollectionMatcherDiffblueTest {
  /**
   * Test {@link CollectionMatcher#CollectionMatcher(String[])}.
   *
   * <p>Method under test: {@link CollectionMatcher#CollectionMatcher(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CollectionMatcher.<init>(String[])"})
  public void testNewCollectionMatcher() {
    // Arrange, Act and Assert
    assertEquals("", (new CollectionMatcher("Strings")).prefix());
  }

  /**
   * Test {@link CollectionMatcher#matches(String)} with {@code string}.
   *
   * <p>Method under test: {@link CollectionMatcher#matches(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CollectionMatcher.matches(String)"})
  public void testMatchesWithString() {
    // Arrange, Act and Assert
    assertFalse((new CollectionMatcher(new HashSet<>())).matches("String"));
  }

  /**
   * Test {@link CollectionMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CollectionMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset_whenString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new CollectionMatcher(new HashSet<>())).matches("String", 1, 3));
  }
}
