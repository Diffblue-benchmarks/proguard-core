package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.util.HashMap;
import org.junit.Test;

public class MapStringFunctionDiffblueTest {
  /**
   * Method under test: {@link MapStringFunction#transform(String)}
   */
  @Test
  public void testTransform() {
    // Arrange, Act and Assert
    assertNull((new MapStringFunction(new HashMap<>())).transform("String"));
  }

  /**
   * Method under test: {@link MapStringFunction#transform(String)}
   */
  @Test
  public void testTransform2() {
    // Arrange
    HashMap<Object, Object> map = new HashMap<>();
    map.put("42", "42");

    // Act and Assert
    assertEquals("42", (new MapStringFunction(map)).transform("42"));
  }
}
