package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MapStringFunctionDiffblueTest {
  /**
   * Test {@link MapStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is {@code 42}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link MapStringFunction#transform(String)}
   */
  @Test
  @DisplayName("Test transform(String); given HashMap() '42' is '42'; when '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.MapStringFunction.transform(java.lang.String)"
  })
  void testTransform_givenHashMap42Is42_when42_thenReturn42() {
    // Arrange
    HashMap<Object, Object> map = new HashMap<>();
    map.put("42", "42");

    // Act and Assert
    assertEquals("42", (new MapStringFunction(map)).transform("42"));
  }

  /**
   * Test {@link MapStringFunction#transform(String)}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MapStringFunction#transform(String)}
   */
  @Test
  @DisplayName("Test transform(String); when 'String'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.util.MapStringFunction.transform(java.lang.String)"
  })
  void testTransform_whenString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new MapStringFunction(new HashMap<>())).transform("String"));
  }
}
