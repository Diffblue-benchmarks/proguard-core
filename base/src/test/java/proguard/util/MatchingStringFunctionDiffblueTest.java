package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.util.HashSet;
import org.junit.Test;

public class MatchingStringFunctionDiffblueTest {
  /**
   * Method under test: {@link MatchingStringFunction#transform(String)}
   */
  @Test
  public void testTransform() {
    // Arrange, Act and Assert
    assertNull((new MatchingStringFunction(new EmptyStringMatcher())).transform("String"));
    assertNull((new MatchingStringFunction(new CollectionMatcher(new HashSet<>()))).transform("String"));
    assertEquals("String", (new MatchingStringFunction(new ConstantMatcher(true))).transform("String"));
  }
}
