package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.util.HashSet;
import org.junit.Test;

public class CollectionMatcherDiffblueTest {
  /**
   * Method under test: {@link CollectionMatcher#matches(String)}
   */
  @Test
  public void testMatches() {
    // Arrange, Act and Assert
    assertFalse((new CollectionMatcher(new HashSet<>())).matches("String"));
    assertFalse((new CollectionMatcher(new HashSet<>())).matches("String", 1, 3));
  }

  /**
   * Method under test: {@link CollectionMatcher#CollectionMatcher(String[])}
   */
  @Test
  public void testNewCollectionMatcher() {
    // Arrange, Act and Assert
    assertEquals("", (new CollectionMatcher("Strings")).prefix());
  }
}
