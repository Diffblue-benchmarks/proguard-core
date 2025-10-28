package proguard.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class IdentityStringFunctionDiffblueTest {
  /**
   * Method under test: {@link IdentityStringFunction#transform(String)}
   */
  @Test
  public void testTransform() {
    // Arrange, Act and Assert
    assertEquals("String", (new IdentityStringFunction()).transform("String"));
  }
}
