package proguard.dexfile.reader;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class VisibilityDiffblueTest {
  /**
   * Method under test: {@link Visibility#displayName()}
   */
  @Test
  public void testDisplayName() {
    // Arrange, Act and Assert
    assertEquals("build", Visibility.BUILD.displayName());
  }
}
